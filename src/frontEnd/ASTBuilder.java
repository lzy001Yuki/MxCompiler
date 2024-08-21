package frontEnd;
import AST.Def.*;
import AST.Expr.ExprNode;
import AST.Stat.*;
import AST.Expr.*;
import AST.ProgramNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.MxParser.*;
import parser.MxParser;
import parser.MxParserBaseVisitor;
import AST.ASTNode;
import utils.DataType;
import utils.Error;
import utils.Pair;
import utils.Position;

import java.math.BigInteger;

public class ASTBuilder extends MxParserBaseVisitor<ASTNode> {
    @Override public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        Position pos = new Position(ctx);
        ProgramNode programNode = new ProgramNode(pos);
        if (ctx.mainDef() == null) throw new Error("SemanticError", "main function missed", pos);
        for (var child: ctx.children) {
            if (!(child instanceof TerminalNode)) programNode.definition.add((defNode) visit(child));
        }
        return programNode;
    }

    @Override
    public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        Position pos = new Position(ctx);
        funcDefNode funcDef = new funcDefNode(pos, ctx.Identifier().getText());
        funcDef.returnType = new DataType(ctx.returnType());
        if (ctx.para() != null) funcDef.para = (paraListNode) visitPara(ctx.para());
        if (ctx.block() != null) funcDef.funcBlock = (blockStatNode) visitBlock(ctx.block());
        return funcDef;
    }

    @Override
    public ASTNode visitPara(MxParser.ParaContext ctx) {
        Position pos = new Position(ctx);
        paraListNode para = new paraListNode(pos);
        for (int i = 0; i < ctx.Identifier().size(); i++) {
            para.paraList.add(new paraDef(new DataType(ctx.typename(i)), ctx.Identifier(i).getText()));
        }
        return para;
    }

    @Override
    public ASTNode visitMainDef(MxParser.MainDefContext ctx) {
        Position pos = new Position(ctx);
        mainDefNode mainDef = new mainDefNode(pos);
        mainDef.blockStat = (blockStatNode) visitBlock(ctx.block());
        return mainDef;
    }
    @Override
    public ASTNode visitBlock(MxParser.BlockContext ctx) {
        Position pos = new Position(ctx);
        blockStatNode blockStat = new blockStatNode(pos);
        for (var it: ctx.stat()) {
            statNode stat = (statNode) visit(it);
            blockStat.statList.add(stat);
        }
        return blockStat;
    }
    @Override
    public ASTNode visitBlockStat(MxParser.BlockStatContext ctx) {
        return visitBlock(ctx.block());
    }

    @Override
    public ASTNode visitVarStat(MxParser.VarStatContext ctx) {
        Position pos = new Position(ctx);
        varStatNode varStat = new varStatNode(pos);
        varStat.varDef = (varDefNode) visitVarDef(ctx.varDef());
        return varStat;
    }
    @Override
    public ASTNode visitReturnStat(MxParser.ReturnStatContext ctx) {
        Position pos = new Position(ctx);
        returnStatNode returnStat = new returnStatNode(pos);
        if (ctx.expr() != null)  returnStat.exprNode = (ExprNode) visit(ctx.expr());
        return returnStat;
    }
    @Override
    public ASTNode visitBreakStat(MxParser.BreakStatContext ctx) {
        Position pos = new Position(ctx);
        return new breakStatNode(pos);
    }

    @Override
    public ASTNode visitContStat(ContStatContext ctx) {
        Position pos = new Position(ctx);
        return new continueStatNode(pos);
    }
    @Override
    public ASTNode visitExprStat(ExprStatContext ctx) {
        Position pos = new Position(ctx);
        exprStatNode exprStat = new exprStatNode(pos);
        exprStat.exprNode = (ExprNode) visit(ctx.expr());
        return exprStat;
    }
    @Override
    public ASTNode visitNoneStat(MxParser.NoneStatContext ctx) {
        Position pos = new Position(ctx);
        exprStatNode exprStat = new exprStatNode(pos);
        exprStat.exprNode = null;
        return exprStat;
    }
    @Override
    public ASTNode visitIfStat(IfStatContext ctx) {
        Position pos = new Position(ctx);
        ifStatNode ifStat = new ifStatNode(pos);
        ifStat.conExpr = (ExprNode) visit(ctx.expr());
        ifStat.ifStat = (statNode) visit(ctx.ifStat);
        if (ctx.elseStat != null)  ifStat.elseStat = (statNode) visit(ctx.elseStat);
        return ifStat;
    }
    @Override
    public ASTNode visitWhileStat(WhileStatContext ctx) {
        Position pos = new Position(ctx);
        whileStatNode whileStat = new whileStatNode(pos);
        whileStat.whileExpr = (ExprNode) visit(ctx.expr());
        whileStat.whileStat = (statNode) visit(ctx.stat());
        return whileStat;
    }
    @Override
    public ASTNode visitForStat(ForStatContext ctx) {
        Position pos = new Position(ctx);
        forStatNode forStat = new forStatNode(pos);
        if (ctx.init1 != null) forStat.initStat = (varDefNode) visitVarDef(ctx.init1);
        else if (ctx.init2 != null) forStat.initExpr = (ExprNode) visit(ctx.init2);
        if (ctx.condExpr != null) forStat.condExpr = (ExprNode) visit(ctx.condExpr);
        if (ctx.stepExpr != null) forStat.stepExpr = (ExprNode) visit(ctx.stepExpr);
        if (ctx.stat() != null)forStat.stat = (statNode) visit(ctx.stat());
        return forStat;
    }
    @Override
    public ASTNode visitConstructor(ConstructorContext ctx) {
        Position pos = new Position(ctx);
        constructNode construct = new constructNode(pos, ctx.Identifier().getText());
        construct.blockStat = (blockStatNode) visitBlock(ctx.block());
        return construct;
    }
    @Override
    public ASTNode visitClassDef(ClassDefContext ctx) {
        Position pos = new Position(ctx);
        classDefNode classDef = new classDefNode(pos, ctx.Identifier().getText());
        if (ctx.constructor().size() > 1) throw new Error("SemanticError", "more than one class constructor", pos);
        if (ctx.constructor().isEmpty()) classDef.constructor = null;
        else classDef.constructor = (constructNode) visitConstructor(ctx.constructor(0));
        for (var funcDef: ctx.funcDef()) {
            if (classDef.funcMap.containsKey(funcDef.Identifier().getText())) throw new Error("SemanticError", "Multiple Definitions", pos);
            classDef.funcMap.put(funcDef.Identifier().getText(), (funcDefNode) visitFuncDef(funcDef));
        }
        int index = 0;
        for (var varDef: ctx.varDef()) {
            varDefNode def = (varDefNode) visitVarDef(varDef);
            for (var member: def.varList) {
                if (classDef.varMap.containsKey(member.varName)) throw new Error("SemanticError", "Multiple Definitions", pos);
                classDef.varMap.put(member.varName, new Pair<Integer, varDefAtomNode>(index, member));
                index++;
            }
        }
        return classDef;
    }
    @Override
    public ASTNode visitVarDefAtom(VarDefAtomContext ctx) {
        Position pos = new Position(ctx);
        varDefAtomNode varAtom = new varDefAtomNode(pos, ctx.Identifier().getText());
        if (ctx.expr() != null)  varAtom.assignNode = (ExprNode) visit(ctx.expr());
        return varAtom;
    }
    @Override
    public ASTNode visitVarDef(VarDefContext ctx) {
        Position pos = new Position(ctx);
        varDefNode varDef = new varDefNode(pos);
        DataType type = new DataType(ctx.typename());
        for (var varAtom: ctx.varDefAtom()) {
            varDefAtomNode atom = (varDefAtomNode) visitVarDefAtom(varAtom);
            atom.type = type;
            varDef.varList.add(atom);
        }
        return varDef;
    }
    @Override
    public ASTNode visitAtomExpr(AtomExprContext ctx) {
        Position pos = new Position(ctx);
        atomExprNode atomExpr = new atomExprNode(pos);
        if (ctx.atom().Identifier() != null) {
            atomExpr.id = ctx.atom().Identifier().getText();
        } else if (ctx.atom().False() != null) {
            atomExpr.boolExpr = new cBoolExpr(false);
        } else if (ctx.atom().True() != null) {
            atomExpr.boolExpr = new cBoolExpr(true);
        } else if (ctx.atom().Integer() != null) {
            BigInteger val1 = new BigInteger(ctx.atom().Integer().getText());
            BigInteger val2 = new BigInteger("2147483647");
            if (val1.compareTo(val2) > 0) atomExpr.intExpr = new cIntExpr(ctx.atom().Integer().getText());
            else atomExpr.intExpr = new cIntExpr(Integer.parseInt(ctx.atom().Integer().getText()));
        } else if (ctx.atom().Null() != null) {
            atomExpr.nullExpr = new cNullExpr();
        } else if (ctx.atom().This() != null) {
            atomExpr.thisExpr = new cThisExpr();
        } else if (ctx.atom().Str() != null) {
            atomExpr.strExpr = new cStrExpr(ctx.atom().Str().getText());
        } else if (ctx.atom().stringFormat() != null) {
            atomExpr.formatExpr = (cFormatExpr) visitStringFormat(ctx.atom().stringFormat());
        }
        return atomExpr;
    }
    @Override
    public ASTNode visitStringFormat(StringFormatContext ctx) {
        Position pos = new Position(ctx);
        cFormatExpr formatString;
        if (ctx.Head() != null)  formatString = new cFormatExpr(pos, ctx.getText(), false);
        else formatString = new cFormatExpr(pos, ctx.getText(), true);
        if (ctx.Head() != null) formatString.head = ctx.Head().toString();
        if (ctx.Middle() != null) {
            for (var mid: ctx.Middle()) formatString.middle.add(mid.toString());
        }
        if (ctx.Tail() != null) formatString.tail = ctx.Tail().toString();
        for (var def: ctx.expr()) {
            ExprNode exprNode = (ExprNode) visit(def);
            formatString.expr.add(exprNode);
        }
        return formatString;
    }
    @Override
    public ASTNode visitUnaryExpr(UnaryExprContext ctx) {
        Position pos = new Position(ctx);
        unaryExprNode unaryExpr = new unaryExprNode(pos, ctx.op.getText(), false);
        unaryExpr.exprNode = (ExprNode) visit(ctx.expr());
        return unaryExpr;
    }
    @Override
    public ASTNode visitPostfixExpr(PostfixExprContext ctx) {
        Position pos = new Position(ctx);
        unaryExprNode unaryExpr = new unaryExprNode(pos, ctx.op.getText(), false);
        unaryExpr.exprNode = (ExprNode) visit(ctx.expr());
        return unaryExpr;
    }
    @Override
    public ASTNode visitPrefixExpr(PrefixExprContext ctx) {
        Position pos = new Position(ctx);
        unaryExprNode unaryExpr = new unaryExprNode(pos, ctx.op.getText(), true);
        unaryExpr.exprNode = (ExprNode) visit(ctx.expr());
        return unaryExpr;
    }
    @Override
    public ASTNode visitAlgorExpr(AlgorExprContext ctx) {
        Position pos = new Position(ctx);
        binaryExprNode binaryExpr = new binaryExprNode(pos, ctx.op.getText());
        binaryExpr.lhs = (ExprNode) visit(ctx.expr(0));
        binaryExpr.rhs = (ExprNode) visit(ctx.expr(1));
        return binaryExpr;
    }
    @Override
    public ASTNode visitBitExpr(BitExprContext ctx) {
        Position pos = new Position(ctx);
        binaryExprNode binaryExpr = new binaryExprNode(pos, ctx.op.getText());
        binaryExpr.lhs = (ExprNode) visit(ctx.expr(0));
        binaryExpr.rhs = (ExprNode) visit(ctx.expr(1));
        return binaryExpr;
    }
    @Override
    public ASTNode visitLogicExpr(LogicExprContext ctx) {
        Position pos = new Position(ctx);
        binaryExprNode binaryExpr = new binaryExprNode(pos, ctx.op.getText());
        binaryExpr.lhs = (ExprNode) visit(ctx.expr(0));
        binaryExpr.rhs = (ExprNode) visit(ctx.expr(1));
        return binaryExpr;
    }
    @Override
    public ASTNode visitTernaryExpr(TernaryExprContext ctx) {
        Position pos = new Position(ctx);
        ternaryExprNode ternaryExpr = new ternaryExprNode(pos);
        ternaryExpr.expr1 = (ExprNode) visit(ctx.expr(0));
        ternaryExpr.expr2 = (ExprNode) visit(ctx.expr(1));
        ternaryExpr.expr3 = (ExprNode) visit(ctx.expr(2));
        return ternaryExpr;
    }
    @Override
    public ASTNode visitBasicExpr(MxParser.BasicExprContext ctx) {
        Position pos = new Position(ctx);
        basicExprNode basicExprNode = new basicExprNode(pos);
        basicExprNode.exprNode = (ExprNode) visit(ctx.expr());
        return basicExprNode;
    }
    @Override
    public ASTNode visitMemberExpr(MemberExprContext ctx) {
        Position pos = new Position(ctx);
        memberExprNode memberExpr = new memberExprNode(pos);
        memberExpr.obj = (ExprNode) visit(ctx.expr());
        memberExpr.member = ctx.Identifier().getText();
        return memberExpr;
    }
    @Override
    public ASTNode visitIndexExpr(IndexExprContext ctx) {
        Position pos = new Position(ctx);
        indexExprNode indexExpr = new indexExprNode(pos);
        indexExpr.exprNode = (ExprNode) visit(ctx.expr(0));
        for (int i = 1; i < ctx.expr().size(); i++) {
            indexExpr.index.add((ExprNode) visit(ctx.expr(i)));
        }
        return indexExpr;
    }
    @Override
    public ASTNode visitAssignExpr(AssignExprContext ctx) {
        Position pos = new Position(ctx);
        assignExprNode assignExpr = new assignExprNode(pos);
        assignExpr.lhs = (ExprNode) visit(ctx.expr(0));
        assignExpr.rhs = (ExprNode) visit(ctx.expr(1));
        return assignExpr;
    }
    @Override
    public ASTNode visitFuncExpr(FuncExprContext ctx) {
        Position pos = new Position(ctx);
        funcExprNode funcExpr = new funcExprNode(pos);
        funcExpr.exprNode = (ExprNode) visit(ctx.expr(0));
        for (int i = 1; i < ctx.expr().size(); i++) {
            funcExpr.paraList.add((ExprNode) visit(ctx.expr(i)));
        }
        return funcExpr;
    }
    @Override
    public ASTNode visitVarExpr(VarExprContext ctx) {
        Position pos = new Position(ctx);
        varExprNode varExpr = new varExprNode(pos);
        if (ctx.Int() != null) varExpr.type = new DataType("int");
        else if (ctx.Bool() != null) varExpr.type = new DataType("bool");
        else if (ctx.String() != null) varExpr.type = new DataType("string");
        else if (ctx.Identifier() != null) {
            varExpr.type = new DataType(ctx.Identifier().getText());
        }
        return varExpr;
    }
    @Override
    public ASTNode visitArrayExpr1(ArrayExpr1Context ctx) {
        Position pos = new Position(ctx);
        arrayExprNode arrayExpr = new arrayExprNode(pos);
        if (ctx.Int() != null) arrayExpr.type = new DataType("int");
        else if (ctx.Bool() != null) arrayExpr.type = new DataType("bool");
        else if (ctx.String() != null) arrayExpr.type = new DataType("string");
        else if (ctx.Identifier() != null) {
            arrayExpr.type = new DataType(ctx.Identifier().getText());
            arrayExpr.type.isClass = true;
        }
        for (var index: ctx.expr()) {
            arrayExpr.indexList.add((ExprNode) visit(index));
        }
        for (int i = 0; i < arrayExpr.indexList.size(); i++) {
            int lbIndex = ctx.LBracket(i).getSymbol().getTokenIndex();
            int rbIndex = ctx.RBracket(i).getSymbol().getTokenIndex();
            if (rbIndex == lbIndex + 1) throw new Error("SemanticError", "the size of multidimensional array must be specified from left to right", pos);
        }
        if (ctx.initArray() != null) {
            arrayExpr.iniList = (initArrayExprNode) visitInitArray(ctx.initArray());
//            atomExprNode atom = new atomExprNode(null);
//            atom.intExpr = new cIntExpr(arrayExpr.iniList.list.size());
//            arrayExpr.indexList.add(atom);
        }
        arrayExpr.type.arrayDim = ctx.LBracket().size();
        arrayExpr.type.isArray = true;
        return arrayExpr;
    }
    @Override
    public ASTNode visitInitArray(InitArrayContext ctx) {
        Position pos = new Position(ctx);
        initArrayExprNode initArrayExpr = new initArrayExprNode(pos);
        for (var init: ctx.expr()) {
            initArrayExpr.list.add((ExprNode) visit(init));
        }
        return initArrayExpr;
    }
}

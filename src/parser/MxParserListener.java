// Generated from MxParser.g4 by ANTLR 4.7.2
package parser;
import parser.MxParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(MxParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(MxParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#mainDef}.
	 * @param ctx the parse tree
	 */
	void enterMainDef(MxParser.MainDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#mainDef}.
	 * @param ctx the parse tree
	 */
	void exitMainDef(MxParser.MainDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(MxParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(MxParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(MxParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(MxParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MxParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MxParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initArray}.
	 * @param ctx the parse tree
	 */
	void enterInitArray(MxParser.InitArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initArray}.
	 * @param ctx the parse tree
	 */
	void exitInitArray(MxParser.InitArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MxParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MxParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr2}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr2(MxParser.ArrayExpr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr2}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr2(MxParser.ArrayExpr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr1}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr1(MxParser.ArrayExpr1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr1}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr1(MxParser.ArrayExpr1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(MxParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(MxParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(MxParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(MxParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(MxParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(MxParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpr(MxParser.BasicExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpr(MxParser.BasicExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpr(MxParser.BitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpr(MxParser.BitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code algorExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterAlgorExpr(MxParser.AlgorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code algorExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitAlgorExpr(MxParser.AlgorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr(MxParser.LogicExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr(MxParser.LogicExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(MxParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(MxParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser# expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefAtom}.
	 * @param ctx the parse tree
	 */
	void enterVarDefAtom(MxParser.VarDefAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefAtom}.
	 * @param ctx the parse tree
	 */
	void exitVarDefAtom(MxParser.VarDefAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#stringFormat}.
	 * @param ctx the parse tree
	 */
	void enterStringFormat(MxParser.StringFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#stringFormat}.
	 * @param ctx the parse tree
	 */
	void exitStringFormat(MxParser.StringFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MxParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MxParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarStat(MxParser.VarStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarStat(MxParser.VarStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(MxParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(MxParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(MxParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(MxParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContStat(MxParser.ContStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContStat(MxParser.ContStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(MxParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(MxParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNoneStat(MxParser.NoneStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNoneStat(MxParser.NoneStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MxParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MxParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MxParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MxParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MxParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MxParser.ForStatContext ctx);
}
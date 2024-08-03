// Generated from MxParser.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParserParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParserParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParserParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParserParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  returnTypr}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParserParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  returnTypr}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParserParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(MxParserParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(MxParserParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  para}.
	 * @param ctx the parse tree
	 */
	void enterPara(MxParserParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  para}.
	 * @param ctx the parse tree
	 */
	void exitPara(MxParserParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  mainDef}.
	 * @param ctx the parse tree
	 */
	void enterMainDef(MxParserParser.MainDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  mainDef}.
	 * @param ctx the parse tree
	 */
	void exitMainDef(MxParserParser.MainDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(MxParserParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(MxParserParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(MxParserParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(MxParserParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParserParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParserParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(MxParserParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser#  typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(MxParserParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser#  atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MxParserParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MxParserParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ororExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterOrorExpr(MxParserParser.OrorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ororExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitOrorExpr(MxParserParser.OrorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MxParserParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MxParserParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxParserParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxParserParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxParserParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxParserParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MxParserParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MxParserParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr2}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr2(MxParserParser.ArrayExpr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr2}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr2(MxParserParser.ArrayExpr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr1}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr1(MxParserParser.ArrayExpr1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr1}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr1(MxParserParser.ArrayExpr1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code xorExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterXorExpr(MxParserParser.XorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xorExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitXorExpr(MxParserParser.XorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpr(MxParserParser.ShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpr(MxParserParser.ShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(MxParserParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(MxParserParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(MxParserParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(MxParserParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(MxParserParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(MxParserParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpr(MxParserParser.BasicExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpr(MxParserParser.BasicExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code algorExpr1}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterAlgorExpr1(MxParserParser.AlgorExpr1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code algorExpr1}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitAlgorExpr1(MxParserParser.AlgorExpr1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code andandExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterAndandExpr(MxParserParser.AndandExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andandExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitAndandExpr(MxParserParser.AndandExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code algorExpr2}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterAlgorExpr2(MxParserParser.AlgorExpr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code algorExpr2}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitAlgorExpr2(MxParserParser.AlgorExpr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MxParserParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MxParserParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(MxParserParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(MxParserParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(MxParserParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(MxParserParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(MxParserParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(MxParserParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxParserParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxParserParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MxParserParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MxParserParser#  expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MxParserParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# varDefAtom}.
	 * @param ctx the parse tree
	 */
	void enterVarDefAtom(MxParserParser.VarDefAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# varDefAtom}.
	 * @param ctx the parse tree
	 */
	void exitVarDefAtom(MxParserParser.VarDefAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxParserParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxParserParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# head}.
	 * @param ctx the parse tree
	 */
	void enterHead(MxParserParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# head}.
	 * @param ctx the parse tree
	 */
	void exitHead(MxParserParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# middle}.
	 * @param ctx the parse tree
	 */
	void enterMiddle(MxParserParser.MiddleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# middle}.
	 * @param ctx the parse tree
	 */
	void exitMiddle(MxParserParser.MiddleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(MxParserParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(MxParserParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# stringFormat}.
	 * @param ctx the parse tree
	 */
	void enterStringFormat(MxParserParser.StringFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# stringFormat}.
	 * @param ctx the parse tree
	 */
	void exitStringFormat(MxParserParser.StringFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParserParser# block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParserParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParserParser# block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParserParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MxParserParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MxParserParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterVarStat(MxParserParser.VarStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitVarStat(MxParserParser.VarStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(MxParserParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(MxParserParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(MxParserParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(MxParserParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterContStat(MxParserParser.ContStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitContStat(MxParserParser.ContStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(MxParserParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(MxParserParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterNoneStat(MxParserParser.NoneStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitNoneStat(MxParserParser.NoneStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MxParserParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MxParserParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MxParserParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MxParserParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MxParserParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxParserParser# stat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MxParserParser.ForStatContext ctx);
}
package parser;// Generated from MxParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser # program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(MxParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # mainDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDef(MxParser.MainDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(MxParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(MxParser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MxParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # initArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitArray(MxParser.InitArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(MxParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr2}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr2(MxParser.ArrayExpr2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr1}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr1(MxParser.ArrayExpr1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(MxParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(MxParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(MxParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(MxParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitExpr(MxParser.BitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code algorExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorExpr(MxParser.AlgorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(MxParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(MxParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(MxParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParser # expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # varDefAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefAtom(MxParser.VarDefAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # stringFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFormat(MxParser.StringFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser # block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(MxParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarStat(MxParser.VarStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(MxParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(MxParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContStat(MxParser.ContStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(MxParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneStat(MxParser.NoneStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MxParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(MxParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxParser # stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(MxParser.ForStatContext ctx);
}
// Generated from MxParser.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParserParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParserParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(MxParserParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(MxParserParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#mainDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDef(MxParserParser.MainDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(MxParserParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParserParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(MxParserParser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MxParserParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#initArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitArray(MxParserParser.InitArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(MxParserParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(MxParserParser.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(MxParserParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr2}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr2(MxParserParser.ArrayExpr2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr1}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr1(MxParserParser.ArrayExpr1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(MxParserParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(MxParserParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(MxParserParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpr(MxParserParser.BasicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitExpr(MxParserParser.BitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(MxParserParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code algorExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorExpr(MxParserParser.AlgorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(MxParserParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(MxParserParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(MxParserParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxParserParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#varDefAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefAtom(MxParserParser.VarDefAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxParserParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(MxParserParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#middle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiddle(MxParserParser.MiddleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(MxParserParser.TailContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#stringFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFormat(MxParserParser.StringFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParserParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParserParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(MxParserParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarStat(MxParserParser.VarStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(MxParserParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(MxParserParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContStat(MxParserParser.ContStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(MxParserParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneStat(MxParserParser.NoneStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MxParserParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(MxParserParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxParserParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(MxParserParser.ForStatContext ctx);
}
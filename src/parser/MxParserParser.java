// Generated from MxParser.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Main=3, Void=4, Bool=5, Int=6, String=7, New=8, Class=9, 
		Null=10, True=11, False=12, This=13, If=14, Else=15, For=16, While=17, 
		Break=18, Continue=19, Return=20, Identifier=21, Add=22, Sub=23, Mul=24, 
		Div=25, Mod=26, GT=27, LT=28, GET=29, LET=30, NEQ=31, EQ=32, And=33, Or=34, 
		AndAnd=35, OrOr=36, Caret=37, Not=38, Tilde=39, LeftShift=40, RightShift=41, 
		Assign=42, Incre=43, Decre=44, Question=45, Colon=46, Semi=47, Comma=48, 
		Dot=49, Quote=50, LParen=51, RParen=52, LBracket=53, RBracket=54, LBrace=55, 
		RBrace=56, Integer=57, Str=58, Format1=59, Whitespace=60, Newline=61, 
		BlockComment=62, LineComment=63, FormatStr=64;
	public static final int
		RULE_program = 0, RULE_funcDef = 1, RULE_returnType = 2, RULE_para = 3, 
		RULE_mainDef = 4, RULE_constructor = 5, RULE_classDef = 6, RULE_typename = 7, 
		RULE_atom = 8, RULE_initArray = 9, RULE_expr = 10, RULE_varDefAtom = 11, 
		RULE_varDef = 12, RULE_head = 13, RULE_middle = 14, RULE_tail = 15, RULE_stringFormat = 16, 
		RULE_block = 17, RULE_stat = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcDef", "returnType", "para", "mainDef", "constructor", 
			"classDef", "typename", "atom", "initArray", "expr", "varDefAtom", "varDef", 
			"head", "middle", "tail", "stringFormat", "block", "stat"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'f\"'", "'$'", "'main'", "'void'", "'bool'", "'int'", "'string'", 
			"'new'", "'class'", "'null'", "'true'", "'false'", "'this'", "'if'", 
			"'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", null, 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", "'<='", "'!='", 
			"'=='", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'<<'", "'>>'", 
			"'='", "'++'", "'--'", "'?'", "':'", "';'", "','", "'.'", "'\"'", "'('", 
			"')'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Main", "Void", "Bool", "Int", "String", "New", "Class", 
			"Null", "True", "False", "This", "If", "Else", "For", "While", "Break", 
			"Continue", "Return", "Identifier", "Add", "Sub", "Mul", "Div", "Mod", 
			"GT", "LT", "GET", "LET", "NEQ", "EQ", "And", "Or", "AndAnd", "OrOr", 
			"Caret", "Not", "Tilde", "LeftShift", "RightShift", "Assign", "Incre", 
			"Decre", "Question", "Colon", "Semi", "Comma", "Dot", "Quote", "LParen", 
			"RParen", "LBracket", "RBracket", "LBrace", "RBrace", "Integer", "Str", 
			"Format1", "Whitespace", "Newline", "BlockComment", "LineComment", "FormatStr"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MxParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MainDefContext mainDef() {
			return getRuleContext(MainDefContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MxParserParser.EOF, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(41);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(38);
						funcDef();
						}
						break;
					case 2:
						{
						setState(39);
						classDef();
						}
						break;
					case 3:
						{
						setState(40);
						varDef();
						}
						break;
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(46);
			mainDef();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(47);
					funcDef();
					}
					break;
				case 2:
					{
					setState(48);
					classDef();
					}
					break;
				case 3:
					{
					setState(49);
					varDef();
					}
					break;
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			returnType();
			setState(58);
			match(Identifier);
			setState(59);
			match(LParen);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(60);
				para();
				}
			}

			setState(63);
			match(RParen);
			setState(64);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(MxParserParser.Void, 0); }
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_returnType);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(Void);
				}
				break;
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				typename();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParaContext extends ParserRuleContext {
		public List<TypenameContext> typename() {
			return getRuleContexts(TypenameContext.class);
		}
		public TypenameContext typename(int i) {
			return getRuleContext(TypenameContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxParserParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParserParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParserParser.Comma, i);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			typename();
			setState(71);
			match(Identifier);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(72);
				match(Comma);
				setState(73);
				typename();
				setState(74);
				match(Identifier);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainDefContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MxParserParser.Int, 0); }
		public TerminalNode Main() { return getToken(MxParserParser.Main, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitMainDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDefContext mainDef() throws RecognitionException {
		MainDefContext _localctx = new MainDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mainDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(Int);
			setState(82);
			match(Main);
			setState(83);
			match(LParen);
			setState(84);
			match(RParen);
			setState(85);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(Identifier);
			setState(88);
			match(LParen);
			setState(89);
			match(RParen);
			setState(90);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParserParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode LBrace() { return getToken(MxParserParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParserParser.RBrace, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Class);
			setState(93);
			match(Identifier);
			setState(94);
			match(LBrace);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(95);
					varDef();
					}
					break;
				case 2:
					{
					setState(96);
					constructor();
					}
					break;
				case 3:
					{
					setState(97);
					funcDef();
					}
					break;
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(RBrace);
			setState(104);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenameContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MxParserParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParserParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParserParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public List<TerminalNode> LBracket() { return getTokens(MxParserParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParserParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParserParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParserParser.RBracket, i);
		}
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitTypename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(107);
				match(LBracket);
				setState(108);
				match(RBracket);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode False() { return getToken(MxParserParser.False, 0); }
		public TerminalNode True() { return getToken(MxParserParser.True, 0); }
		public TerminalNode Integer() { return getToken(MxParserParser.Integer, 0); }
		public TerminalNode Str() { return getToken(MxParserParser.Str, 0); }
		public TerminalNode Null() { return getToken(MxParserParser.Null, 0); }
		public TerminalNode This() { return getToken(MxParserParser.This, 0); }
		public StringFormatContext stringFormat() {
			return getRuleContext(StringFormatContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atom);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(Identifier);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(False);
				}
				break;
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(True);
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(Integer);
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				match(Str);
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				match(Null);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
				match(This);
				}
				break;
			case T__0:
			case Format1:
				enterOuterAlt(_localctx, 8);
				{
				setState(121);
				stringFormat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitArrayContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(MxParserParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParserParser.RBrace, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParserParser.Comma, i);
		}
		public InitArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitInitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitArrayContext initArray() throws RecognitionException {
		InitArrayContext _localctx = new InitArrayContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_initArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(124);
			match(LBrace);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
				{
				setState(125);
				expr(0);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(126);
					match(Comma);
					setState(127);
					expr(0);
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(135);
			match(RBrace);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParserParser.Comma, i);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode Dot() { return getToken(MxParserParser.Dot, 0); }
		public MemberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpr2Context extends ExprContext {
		public InitArrayContext initArray() {
			return getRuleContext(InitArrayContext.class,0);
		}
		public ArrayExpr2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitArrayExpr2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpr1Context extends ExprContext {
		public TerminalNode New() { return getToken(MxParserParser.New, 0); }
		public TerminalNode Int() { return getToken(MxParserParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParserParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParserParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public List<TerminalNode> LBracket() { return getTokens(MxParserParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParserParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParserParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParserParser.RBracket, i);
		}
		public InitArrayContext initArray() {
			return getRuleContext(InitArrayContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayExpr1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitArrayExpr1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> LBracket() { return getTokens(MxParserParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParserParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParserParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParserParser.RBracket, i);
		}
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode New() { return getToken(MxParserParser.New, 0); }
		public TerminalNode Int() { return getToken(MxParserParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParserParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParserParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Incre() { return getToken(MxParserParser.Incre, 0); }
		public TerminalNode Decre() { return getToken(MxParserParser.Decre, 0); }
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicExprContext extends ExprContext {
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public BasicExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBasicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LeftShift() { return getToken(MxParserParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(MxParserParser.RightShift, 0); }
		public TerminalNode And() { return getToken(MxParserParser.And, 0); }
		public TerminalNode Caret() { return getToken(MxParserParser.Caret, 0); }
		public TerminalNode Or() { return getToken(MxParserParser.Or, 0); }
		public BitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Not() { return getToken(MxParserParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(MxParserParser.Tilde, 0); }
		public TerminalNode Add() { return getToken(MxParserParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParserParser.Sub, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlgorExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxParserParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParserParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParserParser.Mod, 0); }
		public TerminalNode Add() { return getToken(MxParserParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParserParser.Sub, 0); }
		public AlgorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAlgorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Question() { return getToken(MxParserParser.Question, 0); }
		public TerminalNode Colon() { return getToken(MxParserParser.Colon, 0); }
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(MxParserParser.GT, 0); }
		public TerminalNode GET() { return getToken(MxParserParser.GET, 0); }
		public TerminalNode LT() { return getToken(MxParserParser.LT, 0); }
		public TerminalNode LET() { return getToken(MxParserParser.LET, 0); }
		public TerminalNode NEQ() { return getToken(MxParserParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(MxParserParser.EQ, 0); }
		public TerminalNode AndAnd() { return getToken(MxParserParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(MxParserParser.OrOr, 0); }
		public LogicExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Incre() { return getToken(MxParserParser.Incre, 0); }
		public TerminalNode Decre() { return getToken(MxParserParser.Decre, 0); }
		public PostfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPostfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MxParserParser.Assign, 0); }
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new ArrayExpr1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(138);
				match(New);
				setState(139);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(145); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(140);
						match(LBracket);
						setState(142);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(141);
							expr(0);
							}
						}

						setState(144);
						match(RBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(147); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(149);
					initArray();
					}
					break;
				}
				}
				break;
			case 2:
				{
				_localctx = new ArrayExpr2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				initArray();
				}
				break;
			case 3:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(New);
				setState(154);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(155);
					match(LParen);
					setState(156);
					match(RParen);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde))) != 0)) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(160);
				expr(16);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Incre || _la==Decre) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				expr(14);
				}
				break;
			case 6:
				{
				_localctx = new BasicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(LParen);
				setState(164);
				expr(0);
				setState(165);
				match(RParen);
				}
				break;
			case 7:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(233);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new AlgorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(171);
						((AlgorExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((AlgorExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(172);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AlgorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(174);
						((AlgorExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((AlgorExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(177);
						((BitExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((BitExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(180);
						((LogicExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GET) | (1L << LET) | (1L << NEQ) | (1L << EQ))) != 0)) ) {
							((LogicExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(183);
						((BitExprContext)_localctx).op = match(And);
						setState(184);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(186);
						((BitExprContext)_localctx).op = match(Caret);
						setState(187);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(189);
						((BitExprContext)_localctx).op = match(Or);
						setState(190);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(192);
						((LogicExprContext)_localctx).op = match(AndAnd);
						setState(193);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(195);
						((LogicExprContext)_localctx).op = match(OrOr);
						setState(196);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(198);
						match(Question);
						setState(199);
						expr(0);
						setState(200);
						match(Colon);
						setState(201);
						expr(4);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(204);
						((AssignExprContext)_localctx).op = match(Assign);
						setState(205);
						expr(3);
						}
						break;
					case 12:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(211); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(207);
								match(LBracket);
								setState(208);
								expr(0);
								setState(209);
								match(RBracket);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(213); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 13:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(216);
						match(LParen);
						setState(225);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(217);
							expr(0);
							setState(222);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==Comma) {
								{
								{
								setState(218);
								match(Comma);
								setState(219);
								expr(0);
								}
								}
								setState(224);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(227);
						match(RParen);
						}
						break;
					case 14:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(229);
						((MemberExprContext)_localctx).op = match(Dot);
						setState(230);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(232);
						((PostfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Incre || _la==Decre) ) {
							((PostfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarDefAtomContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParserParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVarDefAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefAtomContext varDefAtom() throws RecognitionException {
		VarDefAtomContext _localctx = new VarDefAtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDefAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(Identifier);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(239);
				match(Assign);
				setState(240);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public List<VarDefAtomContext> varDefAtom() {
			return getRuleContexts(VarDefAtomContext.class);
		}
		public VarDefAtomContext varDefAtom(int i) {
			return getRuleContext(VarDefAtomContext.class,i);
		}
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParserParser.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			typename();
			setState(244);
			varDefAtom();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(245);
				match(Comma);
				setState(246);
				varDefAtom();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeadContext extends ParserRuleContext {
		public TerminalNode FormatStr() { return getToken(MxParserParser.FormatStr, 0); }
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__0);
			setState(255);
			match(FormatStr);
			setState(256);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MiddleContext extends ParserRuleContext {
		public TerminalNode FormatStr() { return getToken(MxParserParser.FormatStr, 0); }
		public MiddleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_middle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitMiddle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MiddleContext middle() throws RecognitionException {
		MiddleContext _localctx = new MiddleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_middle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__1);
			setState(259);
			match(FormatStr);
			setState(260);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TailContext extends ParserRuleContext {
		public TerminalNode FormatStr() { return getToken(MxParserParser.FormatStr, 0); }
		public TerminalNode Quote() { return getToken(MxParserParser.Quote, 0); }
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__1);
			setState(263);
			match(FormatStr);
			setState(264);
			match(Quote);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringFormatContext extends ParserRuleContext {
		public TerminalNode Format1() { return getToken(MxParserParser.Format1, 0); }
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public TailContext tail() {
			return getRuleContext(TailContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<MiddleContext> middle() {
			return getRuleContexts(MiddleContext.class);
		}
		public MiddleContext middle(int i) {
			return getRuleContext(MiddleContext.class,i);
		}
		public StringFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringFormat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitStringFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringFormatContext stringFormat() throws RecognitionException {
		StringFormatContext _localctx = new StringFormatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stringFormat);
		int _la;
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Format1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(Format1);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(267);
				head();
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(268);
					expr(0);
					}
				}

				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(271);
						middle();
						setState(273);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(272);
							expr(0);
							}
						}

						}
						} 
					}
					setState(279);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(280);
				tail();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(MxParserParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParserParser.RBrace, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(LBrace);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << Semi) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
				{
				{
				setState(285);
				stat();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public StatContext ifStat;
		public StatContext elseStat;
		public TerminalNode If() { return getToken(MxParserParser.If, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParserParser.Else, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContStatContext extends StatContext {
		public TerminalNode Continue() { return getToken(MxParserParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public ContStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitContStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public ExprStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public TerminalNode Return() { return getToken(MxParserParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarStatContext extends StatContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVarStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode Break() { return getToken(MxParserParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoneStatContext extends StatContext {
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public NoneStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitNoneStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatContext extends StatContext {
		public VarDefContext init1;
		public ExprContext init2;
		public ExprContext condExpr;
		public ExprContext stepExpr;
		public TerminalNode For() { return getToken(MxParserParser.For, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(MxParserParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParserParser.Semi, i);
		}
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode While() { return getToken(MxParserParser.While, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stat);
		int _la;
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				block();
				}
				break;
			case 2:
				_localctx = new VarStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				varDef();
				}
				break;
			case 3:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(Return);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(296);
					expr(0);
					}
				}

				setState(299);
				match(Semi);
				}
				break;
			case 4:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				match(Break);
				setState(301);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new ContStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(302);
				match(Continue);
				setState(303);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(304);
				expr(0);
				setState(305);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new NoneStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(307);
				match(Semi);
				}
				break;
			case 8:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(308);
				match(If);
				setState(309);
				match(LParen);
				setState(310);
				expr(0);
				setState(311);
				match(RParen);
				setState(312);
				((IfStatContext)_localctx).ifStat = stat();
				setState(315);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(313);
					match(Else);
					setState(314);
					((IfStatContext)_localctx).elseStat = stat();
					}
					break;
				}
				}
				break;
			case 9:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(317);
				match(While);
				setState(318);
				match(LParen);
				setState(319);
				expr(0);
				setState(320);
				match(RParen);
				setState(321);
				stat();
				}
				break;
			case 10:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(323);
				match(For);
				setState(324);
				match(LParen);
				setState(330);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(325);
					((ForStatContext)_localctx).init1 = varDef();
					}
					break;
				case 2:
					{
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
						{
						setState(326);
						((ForStatContext)_localctx).init2 = expr(0);
						}
					}

					setState(329);
					match(Semi);
					}
					break;
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(332);
					((ForStatContext)_localctx).condExpr = expr(0);
					}
				}

				setState(335);
				match(Semi);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(336);
					((ForStatContext)_localctx).stepExpr = expr(0);
					}
				}

				setState(339);
				match(RParen);
				setState(340);
				stat();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 19);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u015a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\2\3"+
		"\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3@\n\3\3\3\3\3"+
		"\3\3\3\4\3\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5O\n\5\f\5\16\5R\13\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\be\n\b\f\b\16\bh\13\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tp\n\t\f\t\16\ts\13\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n}\n\n\3\13\3\13\3\13\3\13\7\13\u0083"+
		"\n\13\f\13\16\13\u0086\13\13\5\13\u0088\n\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u0091\n\f\3\f\6\f\u0094\n\f\r\f\16\f\u0095\3\f\5\f\u0099\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u00a0\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00ab\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00d6\n\f\r\f\16\f\u00d7\3"+
		"\f\3\f\3\f\3\f\3\f\7\f\u00df\n\f\f\f\16\f\u00e2\13\f\5\f\u00e4\n\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u00ec\n\f\f\f\16\f\u00ef\13\f\3\r\3\r\3\r\5\r"+
		"\u00f4\n\r\3\16\3\16\3\16\3\16\7\16\u00fa\n\16\f\16\16\16\u00fd\13\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\5\22\u0110\n\22\3\22\3\22\5\22\u0114\n\22\7\22\u0116\n"+
		"\22\f\22\16\22\u0119\13\22\3\22\3\22\5\22\u011d\n\22\3\23\3\23\7\23\u0121"+
		"\n\23\f\23\16\23\u0124\13\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u012c"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u013e\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u014a\n\24\3\24\5\24\u014d\n\24\3\24\5\24\u0150\n\24\3"+
		"\24\3\24\5\24\u0154\n\24\3\24\3\24\5\24\u0158\n\24\3\24\2\3\26\25\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\t\4\2\7\t\27\27\4\2\30\31("+
		")\3\2-.\3\2\32\34\3\2\30\31\3\2*+\3\2\35\"\2\u018e\2-\3\2\2\2\4;\3\2\2"+
		"\2\6F\3\2\2\2\bH\3\2\2\2\nS\3\2\2\2\fY\3\2\2\2\16^\3\2\2\2\20l\3\2\2\2"+
		"\22|\3\2\2\2\24~\3\2\2\2\26\u00aa\3\2\2\2\30\u00f0\3\2\2\2\32\u00f5\3"+
		"\2\2\2\34\u0100\3\2\2\2\36\u0104\3\2\2\2 \u0108\3\2\2\2\"\u011c\3\2\2"+
		"\2$\u011e\3\2\2\2&\u0157\3\2\2\2(,\5\4\3\2),\5\16\b\2*,\5\32\16\2+(\3"+
		"\2\2\2+)\3\2\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/"+
		"-\3\2\2\2\60\66\5\n\6\2\61\65\5\4\3\2\62\65\5\16\b\2\63\65\5\32\16\2\64"+
		"\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\2\2\3:\3\3\2\2\2;<\5\6\4\2<=\7\27"+
		"\2\2=?\7\65\2\2>@\5\b\5\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\66\2\2BC\5"+
		"$\23\2C\5\3\2\2\2DG\7\6\2\2EG\5\20\t\2FD\3\2\2\2FE\3\2\2\2G\7\3\2\2\2"+
		"HI\5\20\t\2IP\7\27\2\2JK\7\62\2\2KL\5\20\t\2LM\7\27\2\2MO\3\2\2\2NJ\3"+
		"\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\t\3\2\2\2RP\3\2\2\2ST\7\b\2\2TU"+
		"\7\5\2\2UV\7\65\2\2VW\7\66\2\2WX\5$\23\2X\13\3\2\2\2YZ\7\27\2\2Z[\7\65"+
		"\2\2[\\\7\66\2\2\\]\5$\23\2]\r\3\2\2\2^_\7\13\2\2_`\7\27\2\2`f\79\2\2"+
		"ae\5\32\16\2be\5\f\7\2ce\5\4\3\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2eh\3\2\2"+
		"\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7:\2\2jk\7\61\2\2k\17\3\2"+
		"\2\2lq\t\2\2\2mn\7\67\2\2np\78\2\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2"+
		"\2\2r\21\3\2\2\2sq\3\2\2\2t}\7\27\2\2u}\7\16\2\2v}\7\r\2\2w}\7;\2\2x}"+
		"\7<\2\2y}\7\f\2\2z}\7\17\2\2{}\5\"\22\2|t\3\2\2\2|u\3\2\2\2|v\3\2\2\2"+
		"|w\3\2\2\2|x\3\2\2\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\23\3\2\2\2~\u0087"+
		"\79\2\2\177\u0084\5\26\f\2\u0080\u0081\7\62\2\2\u0081\u0083\5\26\f\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0087\177\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7:\2\2\u008a\25\3\2\2\2\u008b"+
		"\u008c\b\f\1\2\u008c\u008d\7\n\2\2\u008d\u0093\t\2\2\2\u008e\u0090\7\67"+
		"\2\2\u008f\u0091\5\26\f\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0094\78\2\2\u0093\u008e\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0099\5\24\13\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u00ab\3"+
		"\2\2\2\u009a\u00ab\5\24\13\2\u009b\u009c\7\n\2\2\u009c\u009f\t\2\2\2\u009d"+
		"\u009e\7\65\2\2\u009e\u00a0\7\66\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00ab\3\2\2\2\u00a1\u00a2\t\3\2\2\u00a2\u00ab\5\26\f\22\u00a3"+
		"\u00a4\t\4\2\2\u00a4\u00ab\5\26\f\20\u00a5\u00a6\7\65\2\2\u00a6\u00a7"+
		"\5\26\f\2\u00a7\u00a8\7\66\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\5\22\n"+
		"\2\u00aa\u008b\3\2\2\2\u00aa\u009a\3\2\2\2\u00aa\u009b\3\2\2\2\u00aa\u00a1"+
		"\3\2\2\2\u00aa\u00a3\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00ed\3\2\2\2\u00ac\u00ad\f\17\2\2\u00ad\u00ae\t\5\2\2\u00ae\u00ec\5"+
		"\26\f\20\u00af\u00b0\f\16\2\2\u00b0\u00b1\t\6\2\2\u00b1\u00ec\5\26\f\17"+
		"\u00b2\u00b3\f\r\2\2\u00b3\u00b4\t\7\2\2\u00b4\u00ec\5\26\f\16\u00b5\u00b6"+
		"\f\f\2\2\u00b6\u00b7\t\b\2\2\u00b7\u00ec\5\26\f\r\u00b8\u00b9\f\13\2\2"+
		"\u00b9\u00ba\7#\2\2\u00ba\u00ec\5\26\f\f\u00bb\u00bc\f\n\2\2\u00bc\u00bd"+
		"\7\'\2\2\u00bd\u00ec\5\26\f\13\u00be\u00bf\f\t\2\2\u00bf\u00c0\7$\2\2"+
		"\u00c0\u00ec\5\26\f\n\u00c1\u00c2\f\b\2\2\u00c2\u00c3\7%\2\2\u00c3\u00ec"+
		"\5\26\f\t\u00c4\u00c5\f\7\2\2\u00c5\u00c6\7&\2\2\u00c6\u00ec\5\26\f\b"+
		"\u00c7\u00c8\f\6\2\2\u00c8\u00c9\7/\2\2\u00c9\u00ca\5\26\f\2\u00ca\u00cb"+
		"\7\60\2\2\u00cb\u00cc\5\26\f\6\u00cc\u00ec\3\2\2\2\u00cd\u00ce\f\5\2\2"+
		"\u00ce\u00cf\7,\2\2\u00cf\u00ec\5\26\f\5\u00d0\u00d5\f\25\2\2\u00d1\u00d2"+
		"\7\67\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\78\2\2\u00d4\u00d6\3\2\2\2"+
		"\u00d5\u00d1\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\u00ec\3\2\2\2\u00d9\u00da\f\24\2\2\u00da\u00e3\7\65\2\2"+
		"\u00db\u00e0\5\26\f\2\u00dc\u00dd\7\62\2\2\u00dd\u00df\5\26\f\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00ec\7\66\2\2\u00e6\u00e7\f"+
		"\23\2\2\u00e7\u00e8\7\63\2\2\u00e8\u00ec\7\27\2\2\u00e9\u00ea\f\21\2\2"+
		"\u00ea\u00ec\t\4\2\2\u00eb\u00ac\3\2\2\2\u00eb\u00af\3\2\2\2\u00eb\u00b2"+
		"\3\2\2\2\u00eb\u00b5\3\2\2\2\u00eb\u00b8\3\2\2\2\u00eb\u00bb\3\2\2\2\u00eb"+
		"\u00be\3\2\2\2\u00eb\u00c1\3\2\2\2\u00eb\u00c4\3\2\2\2\u00eb\u00c7\3\2"+
		"\2\2\u00eb\u00cd\3\2\2\2\u00eb\u00d0\3\2\2\2\u00eb\u00d9\3\2\2\2\u00eb"+
		"\u00e6\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\27\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3"+
		"\7\27\2\2\u00f1\u00f2\7,\2\2\u00f2\u00f4\5\26\f\2\u00f3\u00f1\3\2\2\2"+
		"\u00f3\u00f4\3\2\2\2\u00f4\31\3\2\2\2\u00f5\u00f6\5\20\t\2\u00f6\u00fb"+
		"\5\30\r\2\u00f7\u00f8\7\62\2\2\u00f8\u00fa\5\30\r\2\u00f9\u00f7\3\2\2"+
		"\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe"+
		"\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ff\33\3\2\2\2\u0100"+
		"\u0101\7\3\2\2\u0101\u0102\7B\2\2\u0102\u0103\7\4\2\2\u0103\35\3\2\2\2"+
		"\u0104\u0105\7\4\2\2\u0105\u0106\7B\2\2\u0106\u0107\7\4\2\2\u0107\37\3"+
		"\2\2\2\u0108\u0109\7\4\2\2\u0109\u010a\7B\2\2\u010a\u010b\7\64\2\2\u010b"+
		"!\3\2\2\2\u010c\u011d\7=\2\2\u010d\u010f\5\34\17\2\u010e\u0110\5\26\f"+
		"\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0117\3\2\2\2\u0111\u0113"+
		"\5\36\20\2\u0112\u0114\5\26\f\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2"+
		"\2\u0114\u0116\3\2\2\2\u0115\u0111\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011b\5 \21\2\u011b\u011d\3\2\2\2\u011c\u010c\3\2\2\2\u011c\u010d\3\2"+
		"\2\2\u011d#\3\2\2\2\u011e\u0122\79\2\2\u011f\u0121\5&\24\2\u0120\u011f"+
		"\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7:\2\2\u0126%\3\2\2\2\u0127"+
		"\u0158\5$\23\2\u0128\u0158\5\32\16\2\u0129\u012b\7\26\2\2\u012a\u012c"+
		"\5\26\f\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2"+
		"\u012d\u0158\7\61\2\2\u012e\u012f\7\24\2\2\u012f\u0158\7\61\2\2\u0130"+
		"\u0131\7\25\2\2\u0131\u0158\7\61\2\2\u0132\u0133\5\26\f\2\u0133\u0134"+
		"\7\61\2\2\u0134\u0158\3\2\2\2\u0135\u0158\7\61\2\2\u0136\u0137\7\20\2"+
		"\2\u0137\u0138\7\65\2\2\u0138\u0139\5\26\f\2\u0139\u013a\7\66\2\2\u013a"+
		"\u013d\5&\24\2\u013b\u013c\7\21\2\2\u013c\u013e\5&\24\2\u013d\u013b\3"+
		"\2\2\2\u013d\u013e\3\2\2\2\u013e\u0158\3\2\2\2\u013f\u0140\7\23\2\2\u0140"+
		"\u0141\7\65\2\2\u0141\u0142\5\26\f\2\u0142\u0143\7\66\2\2\u0143\u0144"+
		"\5&\24\2\u0144\u0158\3\2\2\2\u0145\u0146\7\22\2\2\u0146\u014c\7\65\2\2"+
		"\u0147\u014d\5\32\16\2\u0148\u014a\5\26\f\2\u0149\u0148\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\7\61\2\2\u014c\u0147\3"+
		"\2\2\2\u014c\u0149\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u0150\5\26\f\2\u014f"+
		"\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\7\61"+
		"\2\2\u0152\u0154\5\26\f\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0156\7\66\2\2\u0156\u0158\5&\24\2\u0157\u0127\3"+
		"\2\2\2\u0157\u0128\3\2\2\2\u0157\u0129\3\2\2\2\u0157\u012e\3\2\2\2\u0157"+
		"\u0130\3\2\2\2\u0157\u0132\3\2\2\2\u0157\u0135\3\2\2\2\u0157\u0136\3\2"+
		"\2\2\u0157\u013f\3\2\2\2\u0157\u0145\3\2\2\2\u0158\'\3\2\2\2\'+-\64\66"+
		"?FPdfq|\u0084\u0087\u0090\u0095\u0098\u009f\u00aa\u00d7\u00e0\u00e3\u00eb"+
		"\u00ed\u00f3\u00fb\u010f\u0113\u0117\u011c\u0122\u012b\u013d\u0149\u014c"+
		"\u014f\u0153\u0157";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
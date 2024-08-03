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
		RULE_program = 0, RULE_funcDef = 1, RULE_returnType = 2, RULE_funcName = 3, 
		RULE_para = 4, RULE_mainDef = 5, RULE_className = 6, RULE_constructor = 7, 
		RULE_classDef = 8, RULE_typename = 9, RULE_atom = 10, RULE_expr = 11, 
		RULE_varDefAtom = 12, RULE_varDef = 13, RULE_head = 14, RULE_middle = 15, 
		RULE_tail = 16, RULE_stringFormat = 17, RULE_block = 18, RULE_stat = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcDef", "returnType", "funcName", "para", "mainDef", "className", 
			"constructor", "classDef", "typename", "atom", "expr", "varDefAtom", 
			"varDef", "head", "middle", "tail", "stringFormat", "block", "stat"
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitProgram(this);
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
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(43);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(40);
						funcDef();
						}
						break;
					case 2:
						{
						setState(41);
						classDef();
						}
						break;
					case 3:
						{
						setState(42);
						varDef();
						}
						break;
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(48);
			mainDef();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				setState(52);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(49);
					funcDef();
					}
					break;
				case 2:
					{
					setState(50);
					classDef();
					}
					break;
				case 3:
					{
					setState(51);
					varDef();
					}
					break;
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitFuncDef(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			returnType();
			setState(60);
			funcName();
			setState(61);
			match(LParen);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(62);
				para();
				}
			}

			setState(65);
			match(RParen);
			setState(66);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitReturnType(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_returnType);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(Void);
				}
				break;
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
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

	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitFuncName(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(Identifier);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitPara(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			typename();
			setState(75);
			match(Identifier);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(76);
				match(Comma);
				setState(77);
				typename();
				setState(78);
				match(Identifier);
				}
				}
				setState(84);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterMainDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitMainDef(this);
		}
	}

	public final MainDefContext mainDef() throws RecognitionException {
		MainDefContext _localctx = new MainDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mainDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(Int);
			setState(86);
			match(Main);
			setState(87);
			match(LParen);
			setState(88);
			match(RParen);
			setState(89);
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

	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParserParser.Identifier, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitClassName(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(Identifier);
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
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitConstructor(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			className();
			setState(94);
			match(LParen);
			setState(95);
			match(RParen);
			setState(96);
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
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitClassDef(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(Class);
			setState(99);
			className();
			setState(100);
			match(LBrace);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(104);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(101);
					varDef();
					}
					break;
				case 2:
					{
					setState(102);
					constructor();
					}
					break;
				case 3:
					{
					setState(103);
					funcDef();
					}
					break;
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(RBrace);
			setState(110);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterTypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitTypename(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(113);
				match(LBracket);
				setState(114);
				match(RBracket);
				}
				}
				setState(119);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(Identifier);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(False);
				}
				break;
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(True);
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(Integer);
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(Str);
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				match(Null);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 7);
				{
				setState(126);
				match(This);
				}
				break;
			case T__0:
			case Format1:
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
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
	public static class OrorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OrOr() { return getToken(MxParserParser.OrOr, 0); }
		public OrorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterOrorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitOrorExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitFuncExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitMemberExpr(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAtomExpr(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Or() { return getToken(MxParserParser.Or, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitOrExpr(this);
		}
	}
	public static class ArrayExpr2Context extends ExprContext {
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
		public ArrayExpr2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterArrayExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitArrayExpr2(this);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParserParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParserParser.RBracket, i);
		}
		public TerminalNode LBrace() { return getToken(MxParserParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParserParser.RBrace, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParserParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParserParser.Comma, i);
		}
		public ArrayExpr1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterArrayExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitArrayExpr1(this);
		}
	}
	public static class XorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Caret() { return getToken(MxParserParser.Caret, 0); }
		public XorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterXorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitXorExpr(this);
		}
	}
	public static class ShiftExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LeftShift() { return getToken(MxParserParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(MxParserParser.RightShift, 0); }
		public ShiftExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterShiftExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitShiftExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitIndexExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitVarExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitPrefixExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBasicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBasicExpr(this);
		}
	}
	public static class AlgorExpr1Context extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxParserParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParserParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParserParser.Mod, 0); }
		public AlgorExpr1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAlgorExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAlgorExpr1(this);
		}
	}
	public static class AndandExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AndAnd() { return getToken(MxParserParser.AndAnd, 0); }
		public AndandExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAndandExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAndandExpr(this);
		}
	}
	public static class AlgorExpr2Context extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Add() { return getToken(MxParserParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParserParser.Sub, 0); }
		public AlgorExpr2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAlgorExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAlgorExpr2(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitUnaryExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitTernaryExpr(this);
		}
	}
	public static class CompExprContext extends ExprContext {
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
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitCompExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterPostfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitPostfixExpr(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAssignExpr(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode And() { return getToken(MxParserParser.And, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAndExpr(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ArrayExpr1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(131);
				match(New);
				setState(132);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(137); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(133);
						match(LBracket);
						setState(134);
						expr(0);
						setState(135);
						match(RBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(139); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(141);
						match(LBracket);
						setState(142);
						match(RBracket);
						}
						} 
					}
					setState(147);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(148);
					match(LBrace);
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
						{
						setState(149);
						expr(0);
						setState(154);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(150);
							match(Comma);
							setState(151);
							expr(0);
							}
							}
							setState(156);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(159);
					match(RBrace);
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
				setState(162);
				match(LBrace);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(163);
					expr(0);
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(164);
						match(Comma);
						setState(165);
						expr(0);
						}
						}
						setState(170);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(173);
				match(RBrace);
				}
				break;
			case 3:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(New);
				setState(175);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(176);
					match(LParen);
					setState(177);
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
				setState(180);
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
				setState(181);
				expr(16);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
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
				setState(183);
				expr(14);
				}
				break;
			case 6:
				{
				_localctx = new BasicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				match(LParen);
				setState(185);
				expr(0);
				setState(186);
				match(RParen);
				}
				break;
			case 7:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new AlgorExpr1Context(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(192);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AlgorExpr2Context(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(195);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(196);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(198);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(199);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(201);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GET) | (1L << LET) | (1L << NEQ) | (1L << EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(202);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(204);
						match(And);
						setState(205);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new XorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(207);
						match(Caret);
						setState(208);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(210);
						match(Or);
						setState(211);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new AndandExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(213);
						match(AndAnd);
						setState(214);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new OrorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(216);
						match(OrOr);
						setState(217);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(219);
						match(Question);
						setState(220);
						expr(0);
						setState(221);
						match(Colon);
						setState(222);
						expr(4);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(225);
						((AssignExprContext)_localctx).op = match(Assign);
						setState(226);
						expr(3);
						}
						break;
					case 12:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(232); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(228);
								match(LBracket);
								setState(229);
								expr(0);
								setState(230);
								match(RBracket);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(234); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 13:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(237);
						match(LParen);
						setState(246);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(238);
							expr(0);
							setState(243);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==Comma) {
								{
								{
								setState(239);
								match(Comma);
								setState(240);
								expr(0);
								}
								}
								setState(245);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(248);
						match(RParen);
						}
						break;
					case 14:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(250);
						((MemberExprContext)_localctx).op = match(Dot);
						setState(251);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(253);
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
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterVarDefAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitVarDefAtom(this);
		}
	}

	public final VarDefAtomContext varDefAtom() throws RecognitionException {
		VarDefAtomContext _localctx = new VarDefAtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varDefAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(Identifier);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(260);
				match(Assign);
				setState(261);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitVarDef(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			typename();
			setState(265);
			varDefAtom();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(266);
				match(Comma);
				setState(267);
				varDefAtom();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitHead(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__0);
			setState(276);
			match(FormatStr);
			setState(277);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterMiddle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitMiddle(this);
		}
	}

	public final MiddleContext middle() throws RecognitionException {
		MiddleContext _localctx = new MiddleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_middle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__1);
			setState(280);
			match(FormatStr);
			setState(281);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitTail(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__1);
			setState(284);
			match(FormatStr);
			setState(285);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterStringFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitStringFormat(this);
		}
	}

	public final StringFormatContext stringFormat() throws RecognitionException {
		StringFormatContext _localctx = new StringFormatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stringFormat);
		int _la;
		try {
			int _alt;
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Format1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(Format1);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(288);
				head();
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(289);
					expr(0);
					}
				}

				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(292);
						middle();
						setState(294);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(293);
							expr(0);
							}
						}

						}
						} 
					}
					setState(300);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(301);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(LBrace);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << Semi) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
				{
				{
				setState(306);
				stat();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitIfStat(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBlockStat(this);
		}
	}
	public static class ContStatContext extends StatContext {
		public TerminalNode Continue() { return getToken(MxParserParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public ContStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterContStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitContStat(this);
		}
	}
	public static class ExprStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public ExprStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitExprStat(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitReturnStat(this);
		}
	}
	public static class VarStatContext extends StatContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterVarStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitVarStat(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode Break() { return getToken(MxParserParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBreakStat(this);
		}
	}
	public static class NoneStatContext extends StatContext {
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public NoneStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterNoneStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitNoneStat(this);
		}
	}
	public static class ForStatContext extends StatContext {
		public StatContext stat1;
		public ExprContext stat2;
		public ExprContext stat3;
		public TerminalNode For() { return getToken(MxParserParser.For, 0); }
		public TerminalNode LParen() { return getToken(MxParserParser.LParen, 0); }
		public TerminalNode Semi() { return getToken(MxParserParser.Semi, 0); }
		public TerminalNode RParen() { return getToken(MxParserParser.RParen, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitForStat(this);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitWhileStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stat);
		int _la;
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				block();
				}
				break;
			case 2:
				_localctx = new VarStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				varDef();
				}
				break;
			case 3:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				match(Return);
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(317);
					expr(0);
					}
				}

				setState(320);
				match(Semi);
				}
				break;
			case 4:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				match(Break);
				setState(322);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new ContStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(323);
				match(Continue);
				setState(324);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(325);
				expr(0);
				setState(326);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new NoneStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(328);
				match(Semi);
				}
				break;
			case 8:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(329);
				match(If);
				setState(330);
				match(LParen);
				setState(331);
				expr(0);
				setState(332);
				match(RParen);
				setState(333);
				stat();
				setState(336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(334);
					match(Else);
					setState(335);
					stat();
					}
					break;
				}
				}
				break;
			case 9:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(338);
				match(While);
				setState(339);
				match(LParen);
				setState(340);
				expr(0);
				setState(341);
				match(RParen);
				setState(342);
				stat();
				}
				break;
			case 10:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(344);
				match(For);
				setState(345);
				match(LParen);
				setState(346);
				((ForStatContext)_localctx).stat1 = stat();
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(347);
					((ForStatContext)_localctx).stat2 = expr(0);
					}
				}

				setState(350);
				match(Semi);
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(351);
					((ForStatContext)_localctx).stat3 = expr(0);
					}
				}

				setState(354);
				match(RParen);
				setState(355);
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u016a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
		"\2\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3B"+
		"\n\3\3\3\3\3\3\3\3\4\3\4\5\4I\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"S\n\6\f\6\16\6V\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nk\n\n\f\n\16\nn\13\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\7\13v\n\13\f\13\16\13y\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u0083\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u008c\n\r\r\r\16\r\u008d"+
		"\3\r\3\r\7\r\u0092\n\r\f\r\16\r\u0095\13\r\3\r\3\r\3\r\3\r\7\r\u009b\n"+
		"\r\f\r\16\r\u009e\13\r\5\r\u00a0\n\r\3\r\5\r\u00a3\n\r\3\r\3\r\3\r\3\r"+
		"\7\r\u00a9\n\r\f\r\16\r\u00ac\13\r\5\r\u00ae\n\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00b5\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c0\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\6\r\u00eb\n\r\r\r\16\r\u00ec\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00f4\n\r\f\r\16\r\u00f7\13\r\5\r\u00f9\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u0101\n\r\f\r\16\r\u0104\13\r\3\16\3\16\3\16\5\16\u0109\n\16\3\17\3"+
		"\17\3\17\3\17\7\17\u010f\n\17\f\17\16\17\u0112\13\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5"+
		"\23\u0125\n\23\3\23\3\23\5\23\u0129\n\23\7\23\u012b\n\23\f\23\16\23\u012e"+
		"\13\23\3\23\3\23\5\23\u0132\n\23\3\24\3\24\7\24\u0136\n\24\f\24\16\24"+
		"\u0139\13\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0141\n\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u0153\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u015f\n\25\3\25\3\25\5\25\u0163\n\25\3\25\3\25\3\25\5\25\u0168\n\25\3"+
		"\25\2\3\30\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\t\4\2\7\t"+
		"\27\27\4\2\30\31()\3\2-.\3\2\32\34\3\2\30\31\3\2*+\3\2\35\"\2\u019d\2"+
		"/\3\2\2\2\4=\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nL\3\2\2\2\fW\3\2\2\2\16]\3"+
		"\2\2\2\20_\3\2\2\2\22d\3\2\2\2\24r\3\2\2\2\26\u0082\3\2\2\2\30\u00bf\3"+
		"\2\2\2\32\u0105\3\2\2\2\34\u010a\3\2\2\2\36\u0115\3\2\2\2 \u0119\3\2\2"+
		"\2\"\u011d\3\2\2\2$\u0131\3\2\2\2&\u0133\3\2\2\2(\u0167\3\2\2\2*.\5\4"+
		"\3\2+.\5\22\n\2,.\5\34\17\2-*\3\2\2\2-+\3\2\2\2-,\3\2\2\2.\61\3\2\2\2"+
		"/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\628\5\f\7\2\63\67\5\4"+
		"\3\2\64\67\5\22\n\2\65\67\5\34\17\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65"+
		"\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\2\2"+
		"\3<\3\3\2\2\2=>\5\6\4\2>?\5\b\5\2?A\7\65\2\2@B\5\n\6\2A@\3\2\2\2AB\3\2"+
		"\2\2BC\3\2\2\2CD\7\66\2\2DE\5&\24\2E\5\3\2\2\2FI\7\6\2\2GI\5\24\13\2H"+
		"F\3\2\2\2HG\3\2\2\2I\7\3\2\2\2JK\7\27\2\2K\t\3\2\2\2LM\5\24\13\2MT\7\27"+
		"\2\2NO\7\62\2\2OP\5\24\13\2PQ\7\27\2\2QS\3\2\2\2RN\3\2\2\2SV\3\2\2\2T"+
		"R\3\2\2\2TU\3\2\2\2U\13\3\2\2\2VT\3\2\2\2WX\7\b\2\2XY\7\5\2\2YZ\7\65\2"+
		"\2Z[\7\66\2\2[\\\5&\24\2\\\r\3\2\2\2]^\7\27\2\2^\17\3\2\2\2_`\5\16\b\2"+
		"`a\7\65\2\2ab\7\66\2\2bc\5&\24\2c\21\3\2\2\2de\7\13\2\2ef\5\16\b\2fl\7"+
		"9\2\2gk\5\34\17\2hk\5\20\t\2ik\5\4\3\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2k"+
		"n\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7:\2\2pq\7\61\2\2"+
		"q\23\3\2\2\2rw\t\2\2\2st\7\67\2\2tv\78\2\2us\3\2\2\2vy\3\2\2\2wu\3\2\2"+
		"\2wx\3\2\2\2x\25\3\2\2\2yw\3\2\2\2z\u0083\7\27\2\2{\u0083\7\16\2\2|\u0083"+
		"\7\r\2\2}\u0083\7;\2\2~\u0083\7<\2\2\177\u0083\7\f\2\2\u0080\u0083\7\17"+
		"\2\2\u0081\u0083\5$\23\2\u0082z\3\2\2\2\u0082{\3\2\2\2\u0082|\3\2\2\2"+
		"\u0082}\3\2\2\2\u0082~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0081\3\2\2\2\u0083\27\3\2\2\2\u0084\u0085\b\r\1\2\u0085\u0086\7\n\2"+
		"\2\u0086\u008b\t\2\2\2\u0087\u0088\7\67\2\2\u0088\u0089\5\30\r\2\u0089"+
		"\u008a\78\2\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0093\3\2\2\2\u008f"+
		"\u0090\7\67\2\2\u0090\u0092\78\2\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u00a2\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u009f\79\2\2\u0097\u009c\5\30\r\2\u0098\u0099\7\62"+
		"\2\2\u0099\u009b\5\30\r\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009f\u0097\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a3\7:\2\2\u00a2\u0096\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00c0\3\2"+
		"\2\2\u00a4\u00ad\79\2\2\u00a5\u00aa\5\30\r\2\u00a6\u00a7\7\62\2\2\u00a7"+
		"\u00a9\5\30\r\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00a5\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00c0\7:"+
		"\2\2\u00b0\u00b1\7\n\2\2\u00b1\u00b4\t\2\2\2\u00b2\u00b3\7\65\2\2\u00b3"+
		"\u00b5\7\66\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00c0\3"+
		"\2\2\2\u00b6\u00b7\t\3\2\2\u00b7\u00c0\5\30\r\22\u00b8\u00b9\t\4\2\2\u00b9"+
		"\u00c0\5\30\r\20\u00ba\u00bb\7\65\2\2\u00bb\u00bc\5\30\r\2\u00bc\u00bd"+
		"\7\66\2\2\u00bd\u00c0\3\2\2\2\u00be\u00c0\5\26\f\2\u00bf\u0084\3\2\2\2"+
		"\u00bf\u00a4\3\2\2\2\u00bf\u00b0\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00b8"+
		"\3\2\2\2\u00bf\u00ba\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u0102\3\2\2\2\u00c1"+
		"\u00c2\f\17\2\2\u00c2\u00c3\t\5\2\2\u00c3\u0101\5\30\r\20\u00c4\u00c5"+
		"\f\16\2\2\u00c5\u00c6\t\6\2\2\u00c6\u0101\5\30\r\17\u00c7\u00c8\f\r\2"+
		"\2\u00c8\u00c9\t\7\2\2\u00c9\u0101\5\30\r\16\u00ca\u00cb\f\f\2\2\u00cb"+
		"\u00cc\t\b\2\2\u00cc\u0101\5\30\r\r\u00cd\u00ce\f\13\2\2\u00ce\u00cf\7"+
		"#\2\2\u00cf\u0101\5\30\r\f\u00d0\u00d1\f\n\2\2\u00d1\u00d2\7\'\2\2\u00d2"+
		"\u0101\5\30\r\13\u00d3\u00d4\f\t\2\2\u00d4\u00d5\7$\2\2\u00d5\u0101\5"+
		"\30\r\n\u00d6\u00d7\f\b\2\2\u00d7\u00d8\7%\2\2\u00d8\u0101\5\30\r\t\u00d9"+
		"\u00da\f\7\2\2\u00da\u00db\7&\2\2\u00db\u0101\5\30\r\b\u00dc\u00dd\f\6"+
		"\2\2\u00dd\u00de\7/\2\2\u00de\u00df\5\30\r\2\u00df\u00e0\7\60\2\2\u00e0"+
		"\u00e1\5\30\r\6\u00e1\u0101\3\2\2\2\u00e2\u00e3\f\5\2\2\u00e3\u00e4\7"+
		",\2\2\u00e4\u0101\5\30\r\5\u00e5\u00ea\f\25\2\2\u00e6\u00e7\7\67\2\2\u00e7"+
		"\u00e8\5\30\r\2\u00e8\u00e9\78\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e6\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u0101\3\2\2\2\u00ee\u00ef\f\24\2\2\u00ef\u00f8\7\65\2\2\u00f0\u00f5\5"+
		"\30\r\2\u00f1\u00f2\7\62\2\2\u00f2\u00f4\5\30\r\2\u00f3\u00f1\3\2\2\2"+
		"\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f9"+
		"\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u0101\7\66\2\2\u00fb\u00fc\f\23\2\2\u00fc\u00fd\7"+
		"\63\2\2\u00fd\u0101\7\27\2\2\u00fe\u00ff\f\21\2\2\u00ff\u0101\t\4\2\2"+
		"\u0100\u00c1\3\2\2\2\u0100\u00c4\3\2\2\2\u0100\u00c7\3\2\2\2\u0100\u00ca"+
		"\3\2\2\2\u0100\u00cd\3\2\2\2\u0100\u00d0\3\2\2\2\u0100\u00d3\3\2\2\2\u0100"+
		"\u00d6\3\2\2\2\u0100\u00d9\3\2\2\2\u0100\u00dc\3\2\2\2\u0100\u00e2\3\2"+
		"\2\2\u0100\u00e5\3\2\2\2\u0100\u00ee\3\2\2\2\u0100\u00fb\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\31\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0108\7\27\2\2\u0106\u0107"+
		"\7,\2\2\u0107\u0109\5\30\r\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\33\3\2\2\2\u010a\u010b\5\24\13\2\u010b\u0110\5\32\16\2\u010c\u010d\7"+
		"\62\2\2\u010d\u010f\5\32\16\2\u010e\u010c\3\2\2\2\u010f\u0112\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0113\u0114\7\61\2\2\u0114\35\3\2\2\2\u0115\u0116\7\3\2\2\u0116"+
		"\u0117\7B\2\2\u0117\u0118\7\4\2\2\u0118\37\3\2\2\2\u0119\u011a\7\4\2\2"+
		"\u011a\u011b\7B\2\2\u011b\u011c\7\4\2\2\u011c!\3\2\2\2\u011d\u011e\7\4"+
		"\2\2\u011e\u011f\7B\2\2\u011f\u0120\7\64\2\2\u0120#\3\2\2\2\u0121\u0132"+
		"\7=\2\2\u0122\u0124\5\36\20\2\u0123\u0125\5\30\r\2\u0124\u0123\3\2\2\2"+
		"\u0124\u0125\3\2\2\2\u0125\u012c\3\2\2\2\u0126\u0128\5 \21\2\u0127\u0129"+
		"\5\30\r\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2"+
		"\u012a\u0126\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\5\"\22\2"+
		"\u0130\u0132\3\2\2\2\u0131\u0121\3\2\2\2\u0131\u0122\3\2\2\2\u0132%\3"+
		"\2\2\2\u0133\u0137\79\2\2\u0134\u0136\5(\25\2\u0135\u0134\3\2\2\2\u0136"+
		"\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7:\2\2\u013b\'\3\2\2\2\u013c\u0168"+
		"\5&\24\2\u013d\u0168\5\34\17\2\u013e\u0140\7\26\2\2\u013f\u0141\5\30\r"+
		"\2\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0168"+
		"\7\61\2\2\u0143\u0144\7\24\2\2\u0144\u0168\7\61\2\2\u0145\u0146\7\25\2"+
		"\2\u0146\u0168\7\61\2\2\u0147\u0148\5\30\r\2\u0148\u0149\7\61\2\2\u0149"+
		"\u0168\3\2\2\2\u014a\u0168\7\61\2\2\u014b\u014c\7\20\2\2\u014c\u014d\7"+
		"\65\2\2\u014d\u014e\5\30\r\2\u014e\u014f\7\66\2\2\u014f\u0152\5(\25\2"+
		"\u0150\u0151\7\21\2\2\u0151\u0153\5(\25\2\u0152\u0150\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0168\3\2\2\2\u0154\u0155\7\23\2\2\u0155\u0156\7\65\2\2"+
		"\u0156\u0157\5\30\r\2\u0157\u0158\7\66\2\2\u0158\u0159\5(\25\2\u0159\u0168"+
		"\3\2\2\2\u015a\u015b\7\22\2\2\u015b\u015c\7\65\2\2\u015c\u015e\5(\25\2"+
		"\u015d\u015f\5\30\r\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160"+
		"\3\2\2\2\u0160\u0162\7\61\2\2\u0161\u0163\5\30\r\2\u0162\u0161\3\2\2\2"+
		"\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7\66\2\2\u0165\u0166"+
		"\5(\25\2\u0166\u0168\3\2\2\2\u0167\u013c\3\2\2\2\u0167\u013d\3\2\2\2\u0167"+
		"\u013e\3\2\2\2\u0167\u0143\3\2\2\2\u0167\u0145\3\2\2\2\u0167\u0147\3\2"+
		"\2\2\u0167\u014a\3\2\2\2\u0167\u014b\3\2\2\2\u0167\u0154\3\2\2\2\u0167"+
		"\u015a\3\2\2\2\u0168)\3\2\2\2\'-/\668AHTjlw\u0082\u008d\u0093\u009c\u009f"+
		"\u00a2\u00aa\u00ad\u00b4\u00bf\u00ec\u00f5\u00f8\u0100\u0102\u0108\u0110"+
		"\u0124\u0128\u012c\u0131\u0137\u0140\u0152\u015e\u0162\u0167";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
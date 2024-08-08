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
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Main=1, Void=2, Bool=3, Int=4, String=5, New=6, Class=7, Null=8, True=9, 
		False=10, This=11, If=12, Else=13, For=14, While=15, Break=16, Continue=17, 
		Return=18, Head=19, Middle=20, Tail=21, Identifier=22, Add=23, Sub=24, 
		Mul=25, Div=26, Mod=27, GT=28, LT=29, GET=30, LET=31, NEQ=32, EQ=33, And=34, 
		Or=35, AndAnd=36, OrOr=37, Caret=38, Not=39, Tilde=40, LeftShift=41, RightShift=42, 
		Assign=43, Incre=44, Decre=45, Question=46, Colon=47, Semi=48, Comma=49, 
		Dot=50, Quote=51, LParen=52, RParen=53, LBracket=54, RBracket=55, LBrace=56, 
		RBrace=57, Integer=58, Str=59, Format1=60, Whitespace=61, Newline=62, 
		BlockComment=63, LineComment=64;
	public static final int
		RULE_program = 0, RULE_funcDef = 1, RULE_returnType = 2, RULE_para = 3, 
		RULE_mainDef = 4, RULE_constructor = 5, RULE_classDef = 6, RULE_typename = 7, 
		RULE_atom = 8, RULE_initArray = 9, RULE_expr = 10, RULE_varDefAtom = 11, 
		RULE_varDef = 12, RULE_stringFormat = 13, RULE_block = 14, RULE_stat = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcDef", "returnType", "para", "mainDef", "constructor", 
			"classDef", "typename", "atom", "initArray", "expr", "varDefAtom", "varDef", 
			"stringFormat", "block", "stat"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'void'", "'bool'", "'int'", "'string'", "'new'", "'class'", 
			"'null'", "'true'", "'false'", "'this'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", null, null, null, null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'>'", "'<'", "'>='", "'<='", "'!='", "'=='", "'&'", 
			"'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'<<'", "'>>'", "'='", "'++'", 
			"'--'", "'?'", "':'", "';'", "','", "'.'", "'\"'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Main", "Void", "Bool", "Int", "String", "New", "Class", "Null", 
			"True", "False", "This", "If", "Else", "For", "While", "Break", "Continue", 
			"Return", "Head", "Middle", "Tail", "Identifier", "Add", "Sub", "Mul", 
			"Div", "Mod", "GT", "LT", "GET", "LET", "NEQ", "EQ", "And", "Or", "AndAnd", 
			"OrOr", "Caret", "Not", "Tilde", "LeftShift", "RightShift", "Assign", 
			"Incre", "Decre", "Question", "Colon", "Semi", "Comma", "Dot", "Quote", 
			"LParen", "RParen", "LBracket", "RBracket", "LBrace", "RBrace", "Integer", 
			"Str", "Format1", "Whitespace", "Newline", "BlockComment", "LineComment"
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

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MainDefContext mainDef() {
			return getRuleContext(MainDefContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
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
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(35);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(32);
						funcDef();
						}
						break;
					case 2:
						{
						setState(33);
						classDef();
						}
						break;
					case 3:
						{
						setState(34);
						varDef();
						}
						break;
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(40);
			mainDef();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				setState(44);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(41);
					funcDef();
					}
					break;
				case 2:
					{
					setState(42);
					classDef();
					}
					break;
				case 3:
					{
					setState(43);
					varDef();
					}
					break;
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
			setState(51);
			returnType();
			setState(52);
			match(Identifier);
			setState(53);
			match(LParen);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(54);
				para();
				}
			}

			setState(57);
			match(RParen);
			setState(58);
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
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(Void);
				}
				break;
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
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
		public List<TerminalNode> Identifier() { return getTokens(MxParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
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
			setState(64);
			typename();
			setState(65);
			match(Identifier);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(66);
				match(Comma);
				setState(67);
				typename();
				setState(68);
				match(Identifier);
				}
				}
				setState(74);
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
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Main() { return getToken(MxParser.Main, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
			setState(75);
			match(Int);
			setState(76);
			match(Main);
			setState(77);
			match(LParen);
			setState(78);
			match(RParen);
			setState(79);
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
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
			setState(81);
			match(Identifier);
			setState(82);
			match(LParen);
			setState(83);
			match(RParen);
			setState(84);
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
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
			setState(86);
			match(Class);
			setState(87);
			match(Identifier);
			setState(88);
			match(LBrace);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(92);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(89);
					varDef();
					}
					break;
				case 2:
					{
					setState(90);
					constructor();
					}
					break;
				case 3:
					{
					setState(91);
					funcDef();
					}
					break;
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(RBrace);
			setState(98);
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
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public List<TerminalNode> LBracket() { return getTokens(MxParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParser.RBracket, i);
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
			setState(100);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(101);
				match(LBracket);
				setState(102);
				match(RBracket);
				}
				}
				setState(107);
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
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode Integer() { return getToken(MxParser.Integer, 0); }
		public TerminalNode Str() { return getToken(MxParser.Str, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
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
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(Identifier);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(False);
				}
				break;
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(True);
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				match(Integer);
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				match(Str);
				}
				break;
			case Null:
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				match(Null);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				match(This);
				}
				break;
			case Head:
			case Format1:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
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
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
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
			setState(118);
			match(LBrace);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
				{
				setState(119);
				expr(0);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(120);
					match(Comma);
					setState(121);
					expr(0);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(129);
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
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
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
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
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
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public List<TerminalNode> LBracket() { return getTokens(MxParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParser.RBracket, i);
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
		public List<TerminalNode> LBracket() { return getTokens(MxParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParser.RBracket, i);
		}
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
		public TerminalNode Incre() { return getToken(MxParser.Incre, 0); }
		public TerminalNode Decre() { return getToken(MxParser.Decre, 0); }
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicExprContext extends ExprContext {
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
		public TerminalNode LeftShift() { return getToken(MxParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(MxParser.RightShift, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public TerminalNode Caret() { return getToken(MxParser.Caret, 0); }
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
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
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(MxParser.Tilde, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
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
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
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
		public TerminalNode Question() { return getToken(MxParser.Question, 0); }
		public TerminalNode Colon() { return getToken(MxParser.Colon, 0); }
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
		public TerminalNode GT() { return getToken(MxParser.GT, 0); }
		public TerminalNode GET() { return getToken(MxParser.GET, 0); }
		public TerminalNode LT() { return getToken(MxParser.LT, 0); }
		public TerminalNode LET() { return getToken(MxParser.LET, 0); }
		public TerminalNode NEQ() { return getToken(MxParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(MxParser.EQ, 0); }
		public TerminalNode AndAnd() { return getToken(MxParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(MxParser.OrOr, 0); }
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
		public TerminalNode Incre() { return getToken(MxParser.Incre, 0); }
		public TerminalNode Decre() { return getToken(MxParser.Decre, 0); }
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
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
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
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new ArrayExpr1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(132);
				match(New);
				setState(133);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(139); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(134);
						match(LBracket);
						setState(136);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(135);
							expr(0);
							}
						}

						setState(138);
						match(RBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(141); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(143);
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
				setState(146);
				initArray();
				}
				break;
			case 3:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(New);
				setState(148);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(149);
					match(LParen);
					setState(150);
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
				setState(153);
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
				setState(154);
				expr(16);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
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
				setState(156);
				expr(14);
				}
				break;
			case 6:
				{
				_localctx = new BasicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(LParen);
				setState(158);
				expr(0);
				setState(159);
				match(RParen);
				}
				break;
			case 7:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new AlgorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(165);
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
						setState(166);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AlgorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(168);
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
						setState(169);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(171);
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
						setState(172);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(174);
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
						setState(175);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(177);
						((BitExprContext)_localctx).op = match(And);
						setState(178);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(180);
						((BitExprContext)_localctx).op = match(Caret);
						setState(181);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BitExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(183);
						((BitExprContext)_localctx).op = match(Or);
						setState(184);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(186);
						((LogicExprContext)_localctx).op = match(AndAnd);
						setState(187);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(189);
						((LogicExprContext)_localctx).op = match(OrOr);
						setState(190);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(192);
						match(Question);
						setState(193);
						expr(0);
						setState(194);
						match(Colon);
						setState(195);
						expr(4);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(198);
						((AssignExprContext)_localctx).op = match(Assign);
						setState(199);
						expr(3);
						}
						break;
					case 12:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(205); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(201);
								match(LBracket);
								setState(202);
								expr(0);
								setState(203);
								match(RBracket);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(207); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 13:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(210);
						match(LParen);
						setState(219);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
							{
							setState(211);
							expr(0);
							setState(216);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==Comma) {
								{
								{
								setState(212);
								match(Comma);
								setState(213);
								expr(0);
								}
								}
								setState(218);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(221);
						match(RParen);
						}
						break;
					case 14:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(223);
						((MemberExprContext)_localctx).op = match(Dot);
						setState(224);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(226);
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
				setState(231);
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
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
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
			setState(232);
			match(Identifier);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(233);
				match(Assign);
				setState(234);
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
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
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
			setState(237);
			typename();
			setState(238);
			varDefAtom();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(239);
				match(Comma);
				setState(240);
				varDefAtom();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
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

	public static class StringFormatContext extends ParserRuleContext {
		public TerminalNode Format1() { return getToken(MxParser.Format1, 0); }
		public TerminalNode Head() { return getToken(MxParser.Head, 0); }
		public TerminalNode Tail() { return getToken(MxParser.Tail, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Middle() { return getTokens(MxParser.Middle); }
		public TerminalNode Middle(int i) {
			return getToken(MxParser.Middle, i);
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
		enterRule(_localctx, 26, RULE_stringFormat);
		int _la;
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Format1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(Format1);
				}
				break;
			case Head:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(249);
				match(Head);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(250);
					expr(0);
					}
				}

				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Middle) {
					{
					{
					setState(253);
					match(Middle);
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
						{
						setState(254);
						expr(0);
						}
					}

					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				match(Tail);
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
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
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
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LBrace);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << Semi) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
				{
				{
				setState(266);
				stat();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
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
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
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
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExprStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoneStatContext extends StatContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
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
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(MxParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(MxParser.Semi, i);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
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
		enterRule(_localctx, 30, RULE_stat);
		int _la;
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				block();
				}
				break;
			case 2:
				_localctx = new VarStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				varDef();
				}
				break;
			case 3:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				match(Return);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(277);
					expr(0);
					}
				}

				setState(280);
				match(Semi);
				}
				break;
			case 4:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				match(Break);
				setState(282);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new ContStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				match(Continue);
				setState(284);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(285);
				expr(0);
				setState(286);
				match(Semi);
				}
				break;
			case 7:
				_localctx = new NoneStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(288);
				match(Semi);
				}
				break;
			case 8:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(289);
				match(If);
				setState(290);
				match(LParen);
				setState(291);
				expr(0);
				setState(292);
				match(RParen);
				setState(293);
				((IfStatContext)_localctx).ifStat = stat();
				setState(296);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(294);
					match(Else);
					setState(295);
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
				setState(298);
				match(While);
				setState(299);
				match(LParen);
				setState(300);
				expr(0);
				setState(301);
				match(RParen);
				setState(302);
				stat();
				}
				break;
			case 10:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(304);
				match(For);
				setState(305);
				match(LParen);
				setState(311);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(306);
					((ForStatContext)_localctx).init1 = varDef();
					}
					break;
				case 2:
					{
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
						{
						setState(307);
						((ForStatContext)_localctx).init2 = expr(0);
						}
					}

					setState(310);
					match(Semi);
					}
					break;
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(313);
					((ForStatContext)_localctx).condExpr = expr(0);
					}
				}

				setState(316);
				match(Semi);
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Head) | (1L << Identifier) | (1L << Add) | (1L << Sub) | (1L << Not) | (1L << Tilde) | (1L << Incre) | (1L << Decre) | (1L << LParen) | (1L << LBrace) | (1L << Integer) | (1L << Str) | (1L << Format1))) != 0)) {
					{
					setState(317);
					((ForStatContext)_localctx).stepExpr = expr(0);
					}
				}

				setState(320);
				match(RParen);
				setState(321);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u0147\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3\3\4\3\4\5\4A\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b_\n\b\f\b\16\bb\13\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\7\tj\n\t\f\t\16\tm\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nw\n\n\3\13\3\13\3\13\3\13\7\13}\n\13\f\13\16\13\u0080\13\13\5\13\u0082"+
		"\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u008b\n\f\3\f\6\f\u008e\n\f\r"+
		"\f\16\f\u008f\3\f\5\f\u0093\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u009a\n\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a5\n\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\6\f\u00d0\n\f\r\f\16\f\u00d1\3\f\3\f\3\f\3\f\3\f\7\f\u00d9\n\f\f\f\16"+
		"\f\u00dc\13\f\5\f\u00de\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00e6\n\f\f\f"+
		"\16\f\u00e9\13\f\3\r\3\r\3\r\5\r\u00ee\n\r\3\16\3\16\3\16\3\16\7\16\u00f4"+
		"\n\16\f\16\16\16\u00f7\13\16\3\16\3\16\3\17\3\17\3\17\5\17\u00fe\n\17"+
		"\3\17\3\17\5\17\u0102\n\17\7\17\u0104\n\17\f\17\16\17\u0107\13\17\3\17"+
		"\5\17\u010a\n\17\3\20\3\20\7\20\u010e\n\20\f\20\16\20\u0111\13\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\5\21\u0119\n\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u012b\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0137\n\21\3\21\5\21"+
		"\u013a\n\21\3\21\5\21\u013d\n\21\3\21\3\21\5\21\u0141\n\21\3\21\3\21\5"+
		"\21\u0145\n\21\3\21\2\3\26\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\2\t\4\2\5\7\30\30\4\2\31\32)*\3\2./\3\2\33\35\3\2\31\32\3\2+,\3\2\36"+
		"#\2\u017e\2\'\3\2\2\2\4\65\3\2\2\2\6@\3\2\2\2\bB\3\2\2\2\nM\3\2\2\2\f"+
		"S\3\2\2\2\16X\3\2\2\2\20f\3\2\2\2\22v\3\2\2\2\24x\3\2\2\2\26\u00a4\3\2"+
		"\2\2\30\u00ea\3\2\2\2\32\u00ef\3\2\2\2\34\u0109\3\2\2\2\36\u010b\3\2\2"+
		"\2 \u0144\3\2\2\2\"&\5\4\3\2#&\5\16\b\2$&\5\32\16\2%\"\3\2\2\2%#\3\2\2"+
		"\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*\60"+
		"\5\n\6\2+/\5\4\3\2,/\5\16\b\2-/\5\32\16\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2"+
		"\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63"+
		"\64\7\2\2\3\64\3\3\2\2\2\65\66\5\6\4\2\66\67\7\30\2\2\679\7\66\2\28:\5"+
		"\b\5\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7\67\2\2<=\5\36\20\2=\5\3\2\2\2"+
		">A\7\4\2\2?A\5\20\t\2@>\3\2\2\2@?\3\2\2\2A\7\3\2\2\2BC\5\20\t\2CJ\7\30"+
		"\2\2DE\7\63\2\2EF\5\20\t\2FG\7\30\2\2GI\3\2\2\2HD\3\2\2\2IL\3\2\2\2JH"+
		"\3\2\2\2JK\3\2\2\2K\t\3\2\2\2LJ\3\2\2\2MN\7\6\2\2NO\7\3\2\2OP\7\66\2\2"+
		"PQ\7\67\2\2QR\5\36\20\2R\13\3\2\2\2ST\7\30\2\2TU\7\66\2\2UV\7\67\2\2V"+
		"W\5\36\20\2W\r\3\2\2\2XY\7\t\2\2YZ\7\30\2\2Z`\7:\2\2[_\5\32\16\2\\_\5"+
		"\f\7\2]_\5\4\3\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a"+
		"\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7;\2\2de\7\62\2\2e\17\3\2\2\2fk\t\2\2\2"+
		"gh\78\2\2hj\79\2\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\21\3\2\2\2"+
		"mk\3\2\2\2nw\7\30\2\2ow\7\f\2\2pw\7\13\2\2qw\7<\2\2rw\7=\2\2sw\7\n\2\2"+
		"tw\7\r\2\2uw\5\34\17\2vn\3\2\2\2vo\3\2\2\2vp\3\2\2\2vq\3\2\2\2vr\3\2\2"+
		"\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\23\3\2\2\2x\u0081\7:\2\2y~\5\26\f\2"+
		"z{\7\63\2\2{}\5\26\f\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2"+
		"\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081y\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\7;\2\2\u0084\25\3\2\2\2\u0085\u0086\b\f\1\2"+
		"\u0086\u0087\7\b\2\2\u0087\u008d\t\2\2\2\u0088\u008a\78\2\2\u0089\u008b"+
		"\5\26\f\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008e\79\2\2\u008d\u0088\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u0093\5\24\13\2"+
		"\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u00a5\3\2\2\2\u0094\u00a5"+
		"\5\24\13\2\u0095\u0096\7\b\2\2\u0096\u0099\t\2\2\2\u0097\u0098\7\66\2"+
		"\2\u0098\u009a\7\67\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u00a5\3\2\2\2\u009b\u009c\t\3\2\2\u009c\u00a5\5\26\f\22\u009d\u009e\t"+
		"\4\2\2\u009e\u00a5\5\26\f\20\u009f\u00a0\7\66\2\2\u00a0\u00a1\5\26\f\2"+
		"\u00a1\u00a2\7\67\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a5\5\22\n\2\u00a4\u0085"+
		"\3\2\2\2\u00a4\u0094\3\2\2\2\u00a4\u0095\3\2\2\2\u00a4\u009b\3\2\2\2\u00a4"+
		"\u009d\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00e7\3\2"+
		"\2\2\u00a6\u00a7\f\17\2\2\u00a7\u00a8\t\5\2\2\u00a8\u00e6\5\26\f\20\u00a9"+
		"\u00aa\f\16\2\2\u00aa\u00ab\t\6\2\2\u00ab\u00e6\5\26\f\17\u00ac\u00ad"+
		"\f\r\2\2\u00ad\u00ae\t\7\2\2\u00ae\u00e6\5\26\f\16\u00af\u00b0\f\f\2\2"+
		"\u00b0\u00b1\t\b\2\2\u00b1\u00e6\5\26\f\r\u00b2\u00b3\f\13\2\2\u00b3\u00b4"+
		"\7$\2\2\u00b4\u00e6\5\26\f\f\u00b5\u00b6\f\n\2\2\u00b6\u00b7\7(\2\2\u00b7"+
		"\u00e6\5\26\f\13\u00b8\u00b9\f\t\2\2\u00b9\u00ba\7%\2\2\u00ba\u00e6\5"+
		"\26\f\n\u00bb\u00bc\f\b\2\2\u00bc\u00bd\7&\2\2\u00bd\u00e6\5\26\f\t\u00be"+
		"\u00bf\f\7\2\2\u00bf\u00c0\7\'\2\2\u00c0\u00e6\5\26\f\b\u00c1\u00c2\f"+
		"\6\2\2\u00c2\u00c3\7\60\2\2\u00c3\u00c4\5\26\f\2\u00c4\u00c5\7\61\2\2"+
		"\u00c5\u00c6\5\26\f\6\u00c6\u00e6\3\2\2\2\u00c7\u00c8\f\5\2\2\u00c8\u00c9"+
		"\7-\2\2\u00c9\u00e6\5\26\f\5\u00ca\u00cf\f\25\2\2\u00cb\u00cc\78\2\2\u00cc"+
		"\u00cd\5\26\f\2\u00cd\u00ce\79\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cb\3\2"+
		"\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00e6\3\2\2\2\u00d3\u00d4\f\24\2\2\u00d4\u00dd\7\66\2\2\u00d5\u00da\5"+
		"\26\f\2\u00d6\u00d7\7\63\2\2\u00d7\u00d9\5\26\f\2\u00d8\u00d6\3\2\2\2"+
		"\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00de"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e6\7\67\2\2\u00e0\u00e1\f\23\2\2\u00e1\u00e2\7"+
		"\64\2\2\u00e2\u00e6\7\30\2\2\u00e3\u00e4\f\21\2\2\u00e4\u00e6\t\4\2\2"+
		"\u00e5\u00a6\3\2\2\2\u00e5\u00a9\3\2\2\2\u00e5\u00ac\3\2\2\2\u00e5\u00af"+
		"\3\2\2\2\u00e5\u00b2\3\2\2\2\u00e5\u00b5\3\2\2\2\u00e5\u00b8\3\2\2\2\u00e5"+
		"\u00bb\3\2\2\2\u00e5\u00be\3\2\2\2\u00e5\u00c1\3\2\2\2\u00e5\u00c7\3\2"+
		"\2\2\u00e5\u00ca\3\2\2\2\u00e5\u00d3\3\2\2\2\u00e5\u00e0\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\27\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\7\30\2\2\u00eb\u00ec"+
		"\7-\2\2\u00ec\u00ee\5\26\f\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\31\3\2\2\2\u00ef\u00f0\5\20\t\2\u00f0\u00f5\5\30\r\2\u00f1\u00f2\7\63"+
		"\2\2\u00f2\u00f4\5\30\r\2\u00f3\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f8\u00f9\7\62\2\2\u00f9\33\3\2\2\2\u00fa\u010a\7>\2\2\u00fb\u00fd"+
		"\7\25\2\2\u00fc\u00fe\5\26\f\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2"+
		"\u00fe\u0105\3\2\2\2\u00ff\u0101\7\26\2\2\u0100\u0102\5\26\f\2\u0101\u0100"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u00ff\3\2\2\2\u0104"+
		"\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0108\u010a\7\27\2\2\u0109\u00fa\3\2\2\2\u0109"+
		"\u00fb\3\2\2\2\u010a\35\3\2\2\2\u010b\u010f\7:\2\2\u010c\u010e\5 \21\2"+
		"\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110"+
		"\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7;\2\2\u0113"+
		"\37\3\2\2\2\u0114\u0145\5\36\20\2\u0115\u0145\5\32\16\2\u0116\u0118\7"+
		"\24\2\2\u0117\u0119\5\26\f\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u0145\7\62\2\2\u011b\u011c\7\22\2\2\u011c\u0145\7"+
		"\62\2\2\u011d\u011e\7\23\2\2\u011e\u0145\7\62\2\2\u011f\u0120\5\26\f\2"+
		"\u0120\u0121\7\62\2\2\u0121\u0145\3\2\2\2\u0122\u0145\7\62\2\2\u0123\u0124"+
		"\7\16\2\2\u0124\u0125\7\66\2\2\u0125\u0126\5\26\f\2\u0126\u0127\7\67\2"+
		"\2\u0127\u012a\5 \21\2\u0128\u0129\7\17\2\2\u0129\u012b\5 \21\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0145\3\2\2\2\u012c\u012d\7\21"+
		"\2\2\u012d\u012e\7\66\2\2\u012e\u012f\5\26\f\2\u012f\u0130\7\67\2\2\u0130"+
		"\u0131\5 \21\2\u0131\u0145\3\2\2\2\u0132\u0133\7\20\2\2\u0133\u0139\7"+
		"\66\2\2\u0134\u013a\5\32\16\2\u0135\u0137\5\26\f\2\u0136\u0135\3\2\2\2"+
		"\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\7\62\2\2\u0139\u0134"+
		"\3\2\2\2\u0139\u0136\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u013d\5\26\f\2"+
		"\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140"+
		"\7\62\2\2\u013f\u0141\5\26\f\2\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2"+
		"\u0141\u0142\3\2\2\2\u0142\u0143\7\67\2\2\u0143\u0145\5 \21\2\u0144\u0114"+
		"\3\2\2\2\u0144\u0115\3\2\2\2\u0144\u0116\3\2\2\2\u0144\u011b\3\2\2\2\u0144"+
		"\u011d\3\2\2\2\u0144\u011f\3\2\2\2\u0144\u0122\3\2\2\2\u0144\u0123\3\2"+
		"\2\2\u0144\u012c\3\2\2\2\u0144\u0132\3\2\2\2\u0145!\3\2\2\2\'%\'.\609"+
		"@J^`kv~\u0081\u008a\u008f\u0092\u0099\u00a4\u00d1\u00da\u00dd\u00e5\u00e7"+
		"\u00ed\u00f5\u00fd\u0101\u0105\u0109\u010f\u0118\u012a\u0136\u0139\u013c"+
		"\u0140\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
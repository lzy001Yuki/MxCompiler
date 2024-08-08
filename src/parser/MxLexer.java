// Generated from MxLexer.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Main", "Void", "Bool", "Int", "String", "New", "Class", "Null", "True", 
			"False", "This", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"Head", "Middle", "Tail", "Identifier", "Add", "Sub", "Mul", "Div", "Mod", 
			"GT", "LT", "GET", "LET", "NEQ", "EQ", "And", "Or", "AndAnd", "OrOr", 
			"Caret", "Not", "Tilde", "LeftShift", "RightShift", "Assign", "Incre", 
			"Decre", "Question", "Colon", "Semi", "Comma", "Dot", "Quote", "LParen", 
			"RParen", "LBracket", "RBracket", "LBrace", "RBrace", "Integer", "Str", 
			"FormatStr", "Format1", "Whitespace", "Newline", "BlockComment", "LineComment"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2B\u01a1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\7\27\u00f7\n\27\f\27"+
		"\16\27\u00fa\13\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		"-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3"+
		"\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\7;\u014e\n;"+
		"\f;\16;\u0151\13;\3;\5;\u0154\n;\3<\3<\3<\3<\3<\3<\3<\3<\7<\u015e\n<\f"+
		"<\16<\u0161\13<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\7=\u016e\n=\f=\16=\u0171"+
		"\13=\3>\3>\3>\3>\3>\3>\3?\6?\u017a\n?\r?\16?\u017b\3?\3?\3@\3@\5@\u0182"+
		"\n@\3@\5@\u0185\n@\3@\3@\3A\3A\3A\3A\7A\u018d\nA\fA\16A\u0190\13A\3A\3"+
		"A\3A\3A\3A\3B\3B\3B\3B\7B\u019b\nB\fB\16B\u019e\13B\3B\3B\3\u018e\2C\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9"+
		"q:s;u<w=y\2{>}?\177@\u0081A\u0083B\3\2\n\4\2C\\c|\6\2\62;C\\aac|\3\2\63"+
		";\3\2\62;\5\2\"#%]_\u0080\6\2\"#%%\']_\u0080\4\2\13\13\"\"\4\2\f\f\17"+
		"\17\2\u01b0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2{"+
		"\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0085"+
		"\3\2\2\2\5\u008a\3\2\2\2\7\u008f\3\2\2\2\t\u0094\3\2\2\2\13\u0098\3\2"+
		"\2\2\r\u009f\3\2\2\2\17\u00a3\3\2\2\2\21\u00a9\3\2\2\2\23\u00ae\3\2\2"+
		"\2\25\u00b3\3\2\2\2\27\u00b9\3\2\2\2\31\u00be\3\2\2\2\33\u00c1\3\2\2\2"+
		"\35\u00c6\3\2\2\2\37\u00ca\3\2\2\2!\u00d0\3\2\2\2#\u00d6\3\2\2\2%\u00df"+
		"\3\2\2\2\'\u00e6\3\2\2\2)\u00ec\3\2\2\2+\u00f0\3\2\2\2-\u00f4\3\2\2\2"+
		"/\u00fb\3\2\2\2\61\u00fd\3\2\2\2\63\u00ff\3\2\2\2\65\u0101\3\2\2\2\67"+
		"\u0103\3\2\2\29\u0105\3\2\2\2;\u0107\3\2\2\2=\u0109\3\2\2\2?\u010c\3\2"+
		"\2\2A\u010f\3\2\2\2C\u0112\3\2\2\2E\u0115\3\2\2\2G\u0117\3\2\2\2I\u0119"+
		"\3\2\2\2K\u011c\3\2\2\2M\u011f\3\2\2\2O\u0121\3\2\2\2Q\u0123\3\2\2\2S"+
		"\u0125\3\2\2\2U\u0128\3\2\2\2W\u012b\3\2\2\2Y\u012d\3\2\2\2[\u0130\3\2"+
		"\2\2]\u0133\3\2\2\2_\u0135\3\2\2\2a\u0137\3\2\2\2c\u0139\3\2\2\2e\u013b"+
		"\3\2\2\2g\u013d\3\2\2\2i\u013f\3\2\2\2k\u0141\3\2\2\2m\u0143\3\2\2\2o"+
		"\u0145\3\2\2\2q\u0147\3\2\2\2s\u0149\3\2\2\2u\u0153\3\2\2\2w\u0155\3\2"+
		"\2\2y\u016f\3\2\2\2{\u0172\3\2\2\2}\u0179\3\2\2\2\177\u0184\3\2\2\2\u0081"+
		"\u0188\3\2\2\2\u0083\u0196\3\2\2\2\u0085\u0086\7o\2\2\u0086\u0087\7c\2"+
		"\2\u0087\u0088\7k\2\2\u0088\u0089\7p\2\2\u0089\4\3\2\2\2\u008a\u008b\7"+
		"x\2\2\u008b\u008c\7q\2\2\u008c\u008d\7k\2\2\u008d\u008e\7f\2\2\u008e\6"+
		"\3\2\2\2\u008f\u0090\7d\2\2\u0090\u0091\7q\2\2\u0091\u0092\7q\2\2\u0092"+
		"\u0093\7n\2\2\u0093\b\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096"+
		"\u0097\7v\2\2\u0097\n\3\2\2\2\u0098\u0099\7u\2\2\u0099\u009a\7v\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u009e\7i\2\2"+
		"\u009e\f\3\2\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7y"+
		"\2\2\u00a2\16\3\2\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6"+
		"\7c\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7u\2\2\u00a8\20\3\2\2\2\u00a9\u00aa"+
		"\7p\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7n\2\2\u00ad"+
		"\22\3\2\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7w\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2\24\3\2\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7c\2\2\u00b5"+
		"\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7g\2\2\u00b8\26\3\2\2\2\u00b9"+
		"\u00ba\7v\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7u\2\2"+
		"\u00bd\30\3\2\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7h\2\2\u00c0\32\3\2\2"+
		"\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\34\3\2\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9"+
		"\7t\2\2\u00c9\36\3\2\2\2\u00ca\u00cb\7y\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd"+
		"\7k\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7g\2\2\u00cf \3\2\2\2\u00d0\u00d1"+
		"\7d\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7c\2\2\u00d4"+
		"\u00d5\7m\2\2\u00d5\"\3\2\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8\7q\2\2\u00d8"+
		"\u00d9\7p\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7p\2\2"+
		"\u00dc\u00dd\7w\2\2\u00dd\u00de\7g\2\2\u00de$\3\2\2\2\u00df\u00e0\7t\2"+
		"\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4"+
		"\7t\2\2\u00e4\u00e5\7p\2\2\u00e5&\3\2\2\2\u00e6\u00e7\7h\2\2\u00e7\u00e8"+
		"\7$\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\5y=\2\u00ea\u00eb\7&\2\2\u00eb"+
		"(\3\2\2\2\u00ec\u00ed\7&\2\2\u00ed\u00ee\5y=\2\u00ee\u00ef\7&\2\2\u00ef"+
		"*\3\2\2\2\u00f0\u00f1\7&\2\2\u00f1\u00f2\5y=\2\u00f2\u00f3\5g\64\2\u00f3"+
		",\3\2\2\2\u00f4\u00f8\t\2\2\2\u00f5\u00f7\t\3\2\2\u00f6\u00f5\3\2\2\2"+
		"\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9.\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7-\2\2\u00fc\60\3\2\2\2\u00fd\u00fe"+
		"\7/\2\2\u00fe\62\3\2\2\2\u00ff\u0100\7,\2\2\u0100\64\3\2\2\2\u0101\u0102"+
		"\7\61\2\2\u0102\66\3\2\2\2\u0103\u0104\7\'\2\2\u01048\3\2\2\2\u0105\u0106"+
		"\7@\2\2\u0106:\3\2\2\2\u0107\u0108\7>\2\2\u0108<\3\2\2\2\u0109\u010a\7"+
		"@\2\2\u010a\u010b\7?\2\2\u010b>\3\2\2\2\u010c\u010d\7>\2\2\u010d\u010e"+
		"\7?\2\2\u010e@\3\2\2\2\u010f\u0110\7#\2\2\u0110\u0111\7?\2\2\u0111B\3"+
		"\2\2\2\u0112\u0113\7?\2\2\u0113\u0114\7?\2\2\u0114D\3\2\2\2\u0115\u0116"+
		"\7(\2\2\u0116F\3\2\2\2\u0117\u0118\7~\2\2\u0118H\3\2\2\2\u0119\u011a\7"+
		"(\2\2\u011a\u011b\7(\2\2\u011bJ\3\2\2\2\u011c\u011d\7~\2\2\u011d\u011e"+
		"\7~\2\2\u011eL\3\2\2\2\u011f\u0120\7`\2\2\u0120N\3\2\2\2\u0121\u0122\7"+
		"#\2\2\u0122P\3\2\2\2\u0123\u0124\7\u0080\2\2\u0124R\3\2\2\2\u0125\u0126"+
		"\7>\2\2\u0126\u0127\7>\2\2\u0127T\3\2\2\2\u0128\u0129\7@\2\2\u0129\u012a"+
		"\7@\2\2\u012aV\3\2\2\2\u012b\u012c\7?\2\2\u012cX\3\2\2\2\u012d\u012e\7"+
		"-\2\2\u012e\u012f\7-\2\2\u012fZ\3\2\2\2\u0130\u0131\7/\2\2\u0131\u0132"+
		"\7/\2\2\u0132\\\3\2\2\2\u0133\u0134\7A\2\2\u0134^\3\2\2\2\u0135\u0136"+
		"\7<\2\2\u0136`\3\2\2\2\u0137\u0138\7=\2\2\u0138b\3\2\2\2\u0139\u013a\7"+
		".\2\2\u013ad\3\2\2\2\u013b\u013c\7\60\2\2\u013cf\3\2\2\2\u013d\u013e\7"+
		"$\2\2\u013eh\3\2\2\2\u013f\u0140\7*\2\2\u0140j\3\2\2\2\u0141\u0142\7+"+
		"\2\2\u0142l\3\2\2\2\u0143\u0144\7]\2\2\u0144n\3\2\2\2\u0145\u0146\7_\2"+
		"\2\u0146p\3\2\2\2\u0147\u0148\7}\2\2\u0148r\3\2\2\2\u0149\u014a\7\177"+
		"\2\2\u014at\3\2\2\2\u014b\u014f\t\4\2\2\u014c\u014e\t\5\2\2\u014d\u014c"+
		"\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0154\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\7\62\2\2\u0153\u014b\3"+
		"\2\2\2\u0153\u0152\3\2\2\2\u0154v\3\2\2\2\u0155\u015f\5g\64\2\u0156\u0157"+
		"\7^\2\2\u0157\u015e\7p\2\2\u0158\u0159\7^\2\2\u0159\u015e\7^\2\2\u015a"+
		"\u015b\7^\2\2\u015b\u015e\7$\2\2\u015c\u015e\t\6\2\2\u015d\u0156\3\2\2"+
		"\2\u015d\u0158\3\2\2\2\u015d\u015a\3\2\2\2\u015d\u015c\3\2\2\2\u015e\u0161"+
		"\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0162\u0163\5g\64\2\u0163x\3\2\2\2\u0164\u0165\7^\2\2\u0165"+
		"\u016e\7p\2\2\u0166\u0167\7^\2\2\u0167\u016e\7^\2\2\u0168\u0169\7^\2\2"+
		"\u0169\u016e\7$\2\2\u016a\u016e\t\7\2\2\u016b\u016c\7&\2\2\u016c\u016e"+
		"\7&\2\2\u016d\u0164\3\2\2\2\u016d\u0166\3\2\2\2\u016d\u0168\3\2\2\2\u016d"+
		"\u016a\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170z\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173"+
		"\7h\2\2\u0173\u0174\7$\2\2\u0174\u0175\3\2\2\2\u0175\u0176\5y=\2\u0176"+
		"\u0177\7$\2\2\u0177|\3\2\2\2\u0178\u017a\t\b\2\2\u0179\u0178\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2"+
		"\2\2\u017d\u017e\b?\2\2\u017e~\3\2\2\2\u017f\u0181\7\17\2\2\u0180\u0182"+
		"\7\f\2\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183"+
		"\u0185\7\f\2\2\u0184\u017f\3\2\2\2\u0184\u0183\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186\u0187\b@\2\2\u0187\u0080\3\2\2\2\u0188\u0189\7\61\2\2\u0189"+
		"\u018a\7,\2\2\u018a\u018e\3\2\2\2\u018b\u018d\13\2\2\2\u018c\u018b\3\2"+
		"\2\2\u018d\u0190\3\2\2\2\u018e\u018f\3\2\2\2\u018e\u018c\3\2\2\2\u018f"+
		"\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\7,\2\2\u0192\u0193\7\61"+
		"\2\2\u0193\u0194\3\2\2\2\u0194\u0195\bA\2\2\u0195\u0082\3\2\2\2\u0196"+
		"\u0197\7\61\2\2\u0197\u0198\7\61\2\2\u0198\u019c\3\2\2\2\u0199\u019b\n"+
		"\t\2\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\bB"+
		"\2\2\u01a0\u0084\3\2\2\2\17\2\u00f8\u014f\u0153\u015d\u015f\u016d\u016f"+
		"\u017b\u0181\u0184\u018e\u019c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from MxParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParserLexer extends Lexer {
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
		BlockComment=62, LineComment=63;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "Main", "Void", "Bool", "Int", "String", "New", "Class", 
			"Null", "True", "False", "This", "If", "Else", "For", "While", "Break", 
			"Continue", "Return", "Identifier", "Add", "Sub", "Mul", "Div", "Mod", 
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
			"Format1", "Whitespace", "Newline", "BlockComment", "LineComment"
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


	public MxParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxParser.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u0196\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\7\26\u00ec\n\26\f\26\16\26\u00ef\13\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3"+
		"8\38\39\39\3:\3:\7:\u0143\n:\f:\16:\u0146\13:\3:\5:\u0149\n:\3;\3;\3;"+
		"\3;\3;\3;\3;\3;\7;\u0153\n;\f;\16;\u0156\13;\3;\3;\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3<\7<\u0163\n<\f<\16<\u0166\13<\3=\3=\3=\3=\3=\3=\3>\6>\u016f\n>"+
		"\r>\16>\u0170\3>\3>\3?\3?\5?\u0177\n?\3?\5?\u017a\n?\3?\3?\3@\3@\3@\3"+
		"@\7@\u0182\n@\f@\16@\u0185\13@\3@\3@\3@\3@\3@\3A\3A\3A\3A\7A\u0190\nA"+
		"\fA\16A\u0193\13A\3A\3A\3\u0183\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w\2y={>}?\177@\u0081A\3\2\n"+
		"\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\5\2\"#%]_\u0080\6\2\"#%%\']_"+
		"\u0080\4\2\13\13\"\"\4\2\f\f\17\17\2\u01a5\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\3\u0083\3\2\2\2\5\u0086\3\2\2\2\7\u0088\3\2\2\2\t\u008d\3\2\2"+
		"\2\13\u0092\3\2\2\2\r\u0097\3\2\2\2\17\u009b\3\2\2\2\21\u00a2\3\2\2\2"+
		"\23\u00a6\3\2\2\2\25\u00ac\3\2\2\2\27\u00b1\3\2\2\2\31\u00b6\3\2\2\2\33"+
		"\u00bc\3\2\2\2\35\u00c1\3\2\2\2\37\u00c4\3\2\2\2!\u00c9\3\2\2\2#\u00cd"+
		"\3\2\2\2%\u00d3\3\2\2\2\'\u00d9\3\2\2\2)\u00e2\3\2\2\2+\u00e9\3\2\2\2"+
		"-\u00f0\3\2\2\2/\u00f2\3\2\2\2\61\u00f4\3\2\2\2\63\u00f6\3\2\2\2\65\u00f8"+
		"\3\2\2\2\67\u00fa\3\2\2\29\u00fc\3\2\2\2;\u00fe\3\2\2\2=\u0101\3\2\2\2"+
		"?\u0104\3\2\2\2A\u0107\3\2\2\2C\u010a\3\2\2\2E\u010c\3\2\2\2G\u010e\3"+
		"\2\2\2I\u0111\3\2\2\2K\u0114\3\2\2\2M\u0116\3\2\2\2O\u0118\3\2\2\2Q\u011a"+
		"\3\2\2\2S\u011d\3\2\2\2U\u0120\3\2\2\2W\u0122\3\2\2\2Y\u0125\3\2\2\2["+
		"\u0128\3\2\2\2]\u012a\3\2\2\2_\u012c\3\2\2\2a\u012e\3\2\2\2c\u0130\3\2"+
		"\2\2e\u0132\3\2\2\2g\u0134\3\2\2\2i\u0136\3\2\2\2k\u0138\3\2\2\2m\u013a"+
		"\3\2\2\2o\u013c\3\2\2\2q\u013e\3\2\2\2s\u0148\3\2\2\2u\u014a\3\2\2\2w"+
		"\u0164\3\2\2\2y\u0167\3\2\2\2{\u016e\3\2\2\2}\u0179\3\2\2\2\177\u017d"+
		"\3\2\2\2\u0081\u018b\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7$\2\2\u0085"+
		"\4\3\2\2\2\u0086\u0087\7&\2\2\u0087\6\3\2\2\2\u0088\u0089\7o\2\2\u0089"+
		"\u008a\7c\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\b\3\2\2\2\u008d"+
		"\u008e\7x\2\2\u008e\u008f\7q\2\2\u008f\u0090\7k\2\2\u0090\u0091\7f\2\2"+
		"\u0091\n\3\2\2\2\u0092\u0093\7d\2\2\u0093\u0094\7q\2\2\u0094\u0095\7q"+
		"\2\2\u0095\u0096\7n\2\2\u0096\f\3\2\2\2\u0097\u0098\7k\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7v\2\2\u009a\16\3\2\2\2\u009b\u009c\7u\2\2\u009c\u009d"+
		"\7v\2\2\u009d\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0"+
		"\u00a1\7i\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7g\2\2\u00a4"+
		"\u00a5\7y\2\2\u00a5\22\3\2\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7n\2\2\u00a8"+
		"\u00a9\7c\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7u\2\2\u00ab\24\3\2\2\2\u00ac"+
		"\u00ad\7p\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7n\2\2"+
		"\u00b0\26\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7"+
		"w\2\2\u00b4\u00b5\7g\2\2\u00b5\30\3\2\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8"+
		"\7c\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		"\32\3\2\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7j\2\2\u00be\u00bf\7k\2\2\u00bf"+
		"\u00c0\7u\2\2\u00c0\34\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7h\2\2\u00c3"+
		"\36\3\2\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7u\2\2\u00c7"+
		"\u00c8\7g\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7q\2\2\u00cb"+
		"\u00cc\7t\2\2\u00cc\"\3\2\2\2\u00cd\u00ce\7y\2\2\u00ce\u00cf\7j\2\2\u00cf"+
		"\u00d0\7k\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7g\2\2\u00d2$\3\2\2\2\u00d3"+
		"\u00d4\7d\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7c\2\2"+
		"\u00d7\u00d8\7m\2\2\u00d8&\3\2\2\2\u00d9\u00da\7e\2\2\u00da\u00db\7q\2"+
		"\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7k\2\2\u00de\u00df"+
		"\7p\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1\7g\2\2\u00e1(\3\2\2\2\u00e2\u00e3"+
		"\7t\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7w\2\2\u00e6"+
		"\u00e7\7t\2\2\u00e7\u00e8\7p\2\2\u00e8*\3\2\2\2\u00e9\u00ed\t\2\2\2\u00ea"+
		"\u00ec\t\3\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee,\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1"+
		"\7-\2\2\u00f1.\3\2\2\2\u00f2\u00f3\7/\2\2\u00f3\60\3\2\2\2\u00f4\u00f5"+
		"\7,\2\2\u00f5\62\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7\64\3\2\2\2\u00f8\u00f9"+
		"\7\'\2\2\u00f9\66\3\2\2\2\u00fa\u00fb\7@\2\2\u00fb8\3\2\2\2\u00fc\u00fd"+
		"\7>\2\2\u00fd:\3\2\2\2\u00fe\u00ff\7@\2\2\u00ff\u0100\7?\2\2\u0100<\3"+
		"\2\2\2\u0101\u0102\7>\2\2\u0102\u0103\7?\2\2\u0103>\3\2\2\2\u0104\u0105"+
		"\7#\2\2\u0105\u0106\7?\2\2\u0106@\3\2\2\2\u0107\u0108\7?\2\2\u0108\u0109"+
		"\7?\2\2\u0109B\3\2\2\2\u010a\u010b\7(\2\2\u010bD\3\2\2\2\u010c\u010d\7"+
		"~\2\2\u010dF\3\2\2\2\u010e\u010f\7(\2\2\u010f\u0110\7(\2\2\u0110H\3\2"+
		"\2\2\u0111\u0112\7~\2\2\u0112\u0113\7~\2\2\u0113J\3\2\2\2\u0114\u0115"+
		"\7`\2\2\u0115L\3\2\2\2\u0116\u0117\7#\2\2\u0117N\3\2\2\2\u0118\u0119\7"+
		"\u0080\2\2\u0119P\3\2\2\2\u011a\u011b\7>\2\2\u011b\u011c\7>\2\2\u011c"+
		"R\3\2\2\2\u011d\u011e\7@\2\2\u011e\u011f\7@\2\2\u011fT\3\2\2\2\u0120\u0121"+
		"\7?\2\2\u0121V\3\2\2\2\u0122\u0123\7-\2\2\u0123\u0124\7-\2\2\u0124X\3"+
		"\2\2\2\u0125\u0126\7/\2\2\u0126\u0127\7/\2\2\u0127Z\3\2\2\2\u0128\u0129"+
		"\7A\2\2\u0129\\\3\2\2\2\u012a\u012b\7<\2\2\u012b^\3\2\2\2\u012c\u012d"+
		"\7=\2\2\u012d`\3\2\2\2\u012e\u012f\7.\2\2\u012fb\3\2\2\2\u0130\u0131\7"+
		"\60\2\2\u0131d\3\2\2\2\u0132\u0133\7$\2\2\u0133f\3\2\2\2\u0134\u0135\7"+
		"*\2\2\u0135h\3\2\2\2\u0136\u0137\7+\2\2\u0137j\3\2\2\2\u0138\u0139\7]"+
		"\2\2\u0139l\3\2\2\2\u013a\u013b\7_\2\2\u013bn\3\2\2\2\u013c\u013d\7}\2"+
		"\2\u013dp\3\2\2\2\u013e\u013f\7\177\2\2\u013fr\3\2\2\2\u0140\u0144\t\4"+
		"\2\2\u0141\u0143\t\5\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0149\3\2\2\2\u0146\u0144\3\2"+
		"\2\2\u0147\u0149\7\62\2\2\u0148\u0140\3\2\2\2\u0148\u0147\3\2\2\2\u0149"+
		"t\3\2\2\2\u014a\u0154\5e\63\2\u014b\u014c\7^\2\2\u014c\u0153\7p\2\2\u014d"+
		"\u014e\7^\2\2\u014e\u0153\7^\2\2\u014f\u0150\7^\2\2\u0150\u0153\7$\2\2"+
		"\u0151\u0153\t\6\2\2\u0152\u014b\3\2\2\2\u0152\u014d\3\2\2\2\u0152\u014f"+
		"\3\2\2\2\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158\5e"+
		"\63\2\u0158v\3\2\2\2\u0159\u015a\7^\2\2\u015a\u0163\7p\2\2\u015b\u015c"+
		"\7^\2\2\u015c\u0163\7^\2\2\u015d\u015e\7^\2\2\u015e\u0163\7$\2\2\u015f"+
		"\u0163\t\7\2\2\u0160\u0161\7&\2\2\u0161\u0163\7&\2\2\u0162\u0159\3\2\2"+
		"\2\u0162\u015b\3\2\2\2\u0162\u015d\3\2\2\2\u0162\u015f\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165"+
		"x\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7h\2\2\u0168\u0169\7$\2\2\u0169"+
		"\u016a\3\2\2\2\u016a\u016b\5w<\2\u016b\u016c\7$\2\2\u016cz\3\2\2\2\u016d"+
		"\u016f\t\b\2\2\u016e\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\b>\2\2\u0173"+
		"|\3\2\2\2\u0174\u0176\7\17\2\2\u0175\u0177\7\f\2\2\u0176\u0175\3\2\2\2"+
		"\u0176\u0177\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u017a\7\f\2\2\u0179\u0174"+
		"\3\2\2\2\u0179\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\b?\2\2\u017c"+
		"~\3\2\2\2\u017d\u017e\7\61\2\2\u017e\u017f\7,\2\2\u017f\u0183\3\2\2\2"+
		"\u0180\u0182\13\2\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0184"+
		"\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186"+
		"\u0187\7,\2\2\u0187\u0188\7\61\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b@"+
		"\2\2\u018a\u0080\3\2\2\2\u018b\u018c\7\61\2\2\u018c\u018d\7\61\2\2\u018d"+
		"\u0191\3\2\2\2\u018e\u0190\n\t\2\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2"+
		"\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0194\u0195\bA\2\2\u0195\u0082\3\2\2\2\17\2\u00ed\u0144"+
		"\u0148\u0152\u0154\u0162\u0164\u0170\u0176\u0179\u0183\u0191\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from scanner\DecafLexer.g by ANTLR 4.4

	package compiler.scanner;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WHITESPACE=2, HEX_ERROR=3, INT_LITERAL=4, DECIMAL_LITERAL=5, 
		CHAR_LITERAL=6, CHAR_ERROR=7, STRING_LITERAL=8, STRING_ERROR=9, ASIG_OP=10, 
		NEGATION=11, COND_OP=12, REL_OP=13, EQ_OP=14, BOOL_LITERAL=15, KW_INT=16, 
		KW_BOOL=17, KW_CALLOUT=18, KW_VOID=19, KW_IF=20, KW_ELSE=21, KW_FOR=22, 
		KW_WHILE=23, KW_RETURN=24, KW_BREAK=25, KW_CONTINUE=26, KW_TRUE=27, KW_FALSE=28, 
		ID=29, PARENTESIS_I=30, PARENTESIS_D=31, CORCHETE_I=32, CORCHETE_D=33, 
		LLAVE_I=34, LLAVE_D=35, PLUS=36, MINUS=37, MULT=38, DIV=39, AND=40, OR=41, 
		PUNTO_COMA=42, COMA=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'"
	};
	public static final String[] ruleNames = {
		"COMMENT", "WHITESPACE", "HEX_ERROR", "INT_LITERAL", "DECIMAL_LITERAL", 
		"CHAR_LITERAL", "CHAR_ERROR", "STRING_LITERAL", "STRING_ERROR", "ASIG_OP", 
		"NEGATION", "COND_OP", "REL_OP", "EQ_OP", "BOOL_LITERAL", "KW_INT", "KW_BOOL", 
		"KW_CALLOUT", "KW_VOID", "KW_IF", "KW_ELSE", "KW_FOR", "KW_WHILE", "KW_RETURN", 
		"KW_BREAK", "KW_CONTINUE", "KW_TRUE", "KW_FALSE", "ID", "PARENTESIS_I", 
		"PARENTESIS_D", "CORCHETE_I", "CORCHETE_D", "LLAVE_I", "LLAVE_D", "PLUS", 
		"MINUS", "MULT", "DIV", "AND", "OR", "PUNTO_COMA", "COMA", "DIGIT", "ALPHA", 
		"ALPHA_NUM", "HEX_DIGIT", "ESCAPE_CHAR", "EQUAL", "HEX_LITERAL"
	};


	public DecafLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecafLexer.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		case 1: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		case 4: DECIMAL_LITERAL_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void DECIMAL_LITERAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: System.out.println("Int"); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u0180\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\2\3\2\7\2l\n\2\f\2\16\2o\13\2\3\2\3\2\3\2\3\2\3\2\7\2v\n\2\f\2\16\2"+
		"y\13\2\3\2\3\2\5\2}\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u0088"+
		"\n\4\f\4\16\4\u008b\13\4\3\5\3\5\5\5\u008f\n\5\3\6\6\6\u0092\n\6\r\6\16"+
		"\6\u0093\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u009c\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u00a6\n\b\3\b\3\b\6\b\u00aa\n\b\r\b\16\b\u00ab\3\b\3\b\3"+
		"\b\6\b\u00b1\n\b\r\b\16\b\u00b2\5\b\u00b5\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\t\u00bd\n\t\f\t\16\t\u00c0\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u00ca\n\n\f\n\16\n\u00cd\13\n\3\n\5\n\u00d0\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00d7\n\13\3\f\3\f\3\r\3\r\5\r\u00dd\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00e4\n\16\3\17\3\17\3\17\3\17\5\17\u00ea\n\17\3\20\3\20\5"+
		"\20\u00ee\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\5\36\u013e\n\36"+
		"\3\36\3\36\7\36\u0142\n\36\f\36\16\36\u0145\13\36\3\37\3\37\3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3/\3/\5/\u016b\n/\3\60\3\60\5\60\u016f\n\60\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\6\63\u017d\n\63"+
		"\r\63\16\63\u017e\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]\2_\2a\2c"+
		"\2e\2\3\2\f\3\2\f\f\5\2\13\f\17\17\"\"\5\2\62;C\\c|\6\2\f\f$$))^^\7\2"+
		"$$))^^ppvv\3\2))\4\2$$))\4\2>>@@\3\2\62;\4\2C\\c|\u0199\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\3|\3\2\2\2\5\u0080\3\2\2\2\7\u0083\3\2\2\2\t\u008e\3\2\2\2\13\u0091"+
		"\3\2\2\2\r\u009b\3\2\2\2\17\u00b4\3\2\2\2\21\u00b6\3\2\2\2\23\u00c3\3"+
		"\2\2\2\25\u00d6\3\2\2\2\27\u00d8\3\2\2\2\31\u00dc\3\2\2\2\33\u00e3\3\2"+
		"\2\2\35\u00e9\3\2\2\2\37\u00ed\3\2\2\2!\u00ef\3\2\2\2#\u00f3\3\2\2\2%"+
		"\u00fb\3\2\2\2\'\u0103\3\2\2\2)\u0108\3\2\2\2+\u010b\3\2\2\2-\u0110\3"+
		"\2\2\2/\u0114\3\2\2\2\61\u011a\3\2\2\2\63\u0121\3\2\2\2\65\u0127\3\2\2"+
		"\2\67\u0130\3\2\2\29\u0135\3\2\2\2;\u013d\3\2\2\2=\u0146\3\2\2\2?\u0148"+
		"\3\2\2\2A\u014a\3\2\2\2C\u014c\3\2\2\2E\u014e\3\2\2\2G\u0150\3\2\2\2I"+
		"\u0152\3\2\2\2K\u0154\3\2\2\2M\u0156\3\2\2\2O\u0158\3\2\2\2Q\u015a\3\2"+
		"\2\2S\u015d\3\2\2\2U\u0160\3\2\2\2W\u0162\3\2\2\2Y\u0164\3\2\2\2[\u0166"+
		"\3\2\2\2]\u016a\3\2\2\2_\u016e\3\2\2\2a\u0170\3\2\2\2c\u0176\3\2\2\2e"+
		"\u0178\3\2\2\2gh\7\61\2\2hi\7\61\2\2im\3\2\2\2jl\n\2\2\2kj\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2p}\5\5\3\2qr\7\61\2\2rs"+
		"\7,\2\2sw\3\2\2\2tv\n\2\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz"+
		"\3\2\2\2yw\3\2\2\2z{\7,\2\2{}\7\61\2\2|g\3\2\2\2|q\3\2\2\2}~\3\2\2\2~"+
		"\177\b\2\2\2\177\4\3\2\2\2\u0080\u0081\t\3\2\2\u0081\u0082\b\3\3\2\u0082"+
		"\6\3\2\2\2\u0083\u0084\7\62\2\2\u0084\u0085\7z\2\2\u0085\u0089\3\2\2\2"+
		"\u0086\u0088\n\4\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\b\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\5\13\6\2\u008d\u008f\5e\63\2\u008e\u008c\3\2\2\2\u008e\u008d\3"+
		"\2\2\2\u008f\n\3\2\2\2\u0090\u0092\5Y-\2\u0091\u0090\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\b\6\4\2\u0096\f\3\2\2\2\u0097\u0098\7)\2\2\u0098\u0099\n\5\2\2"+
		"\u0099\u009c\7)\2\2\u009a\u009c\5a\61\2\u009b\u0097\3\2\2\2\u009b\u009a"+
		"\3\2\2\2\u009c\16\3\2\2\2\u009d\u009e\7)\2\2\u009e\u009f\t\5\2\2\u009f"+
		"\u00b5\7)\2\2\u00a0\u00a1\7)\2\2\u00a1\u00a2\7^\2\2\u00a2\u00a3\3\2\2"+
		"\2\u00a3\u00a5\n\6\2\2\u00a4\u00a6\7)\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00b5\3\2\2\2\u00a7\u00a9\7)\2\2\u00a8\u00aa\n\7\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b5\7)\2\2\u00ae\u00b0\7)\2\2\u00af\u00b1"+
		"\n\7\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u009d\3\2\2\2\u00b4\u00a0\3\2"+
		"\2\2\u00b4\u00a7\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b5\20\3\2\2\2\u00b6\u00be"+
		"\7$\2\2\u00b7\u00b8\7^\2\2\u00b8\u00bd\7$\2\2\u00b9\u00ba\7^\2\2\u00ba"+
		"\u00bd\7)\2\2\u00bb\u00bd\n\b\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b9\3\2"+
		"\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7$"+
		"\2\2\u00c2\22\3\2\2\2\u00c3\u00cb\7$\2\2\u00c4\u00c5\7^\2\2\u00c5\u00ca"+
		"\7$\2\2\u00c6\u00c7\7^\2\2\u00c7\u00ca\7)\2\2\u00c8\u00ca\n\b\2\2\u00c9"+
		"\u00c4\3\2\2\2\u00c9\u00c6\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00d0\7)\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\24\3\2\2\2\u00d1\u00d7\5c\62\2\u00d2\u00d3\7-\2\2\u00d3\u00d7"+
		"\7?\2\2\u00d4\u00d5\7/\2\2\u00d5\u00d7\7?\2\2\u00d6\u00d1\3\2\2\2\u00d6"+
		"\u00d2\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\26\3\2\2\2\u00d8\u00d9\7#\2\2"+
		"\u00d9\30\3\2\2\2\u00da\u00dd\5S*\2\u00db\u00dd\5Q)\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00db\3\2\2\2\u00dd\32\3\2\2\2\u00de\u00e4\t\t\2\2\u00df\u00e0"+
		"\7>\2\2\u00e0\u00e4\7?\2\2\u00e1\u00e2\7@\2\2\u00e2\u00e4\7?\2\2\u00e3"+
		"\u00de\3\2\2\2\u00e3\u00df\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\34\3\2\2"+
		"\2\u00e5\u00e6\7?\2\2\u00e6\u00ea\7?\2\2\u00e7\u00e8\7#\2\2\u00e8\u00ea"+
		"\7?\2\2\u00e9\u00e5\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\36\3\2\2\2\u00eb"+
		"\u00ee\5\67\34\2\u00ec\u00ee\59\35\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3"+
		"\2\2\2\u00ee \3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2"+
		"\7v\2\2\u00f2\"\3\2\2\2\u00f3\u00f4\7d\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6"+
		"\7q\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7c\2\2\u00f9"+
		"\u00fa\7p\2\2\u00fa$\3\2\2\2\u00fb\u00fc\7e\2\2\u00fc\u00fd\7c\2\2\u00fd"+
		"\u00fe\7n\2\2\u00fe\u00ff\7n\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7w\2\2"+
		"\u0101\u0102\7v\2\2\u0102&\3\2\2\2\u0103\u0104\7x\2\2\u0104\u0105\7q\2"+
		"\2\u0105\u0106\7k\2\2\u0106\u0107\7f\2\2\u0107(\3\2\2\2\u0108\u0109\7"+
		"k\2\2\u0109\u010a\7h\2\2\u010a*\3\2\2\2\u010b\u010c\7g\2\2\u010c\u010d"+
		"\7n\2\2\u010d\u010e\7u\2\2\u010e\u010f\7g\2\2\u010f,\3\2\2\2\u0110\u0111"+
		"\7h\2\2\u0111\u0112\7q\2\2\u0112\u0113\7t\2\2\u0113.\3\2\2\2\u0114\u0115"+
		"\7y\2\2\u0115\u0116\7j\2\2\u0116\u0117\7k\2\2\u0117\u0118\7n\2\2\u0118"+
		"\u0119\7g\2\2\u0119\60\3\2\2\2\u011a\u011b\7t\2\2\u011b\u011c\7g\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e\u011f\7t\2\2\u011f\u0120\7p\2\2"+
		"\u0120\62\3\2\2\2\u0121\u0122\7d\2\2\u0122\u0123\7t\2\2\u0123\u0124\7"+
		"g\2\2\u0124\u0125\7c\2\2\u0125\u0126\7m\2\2\u0126\64\3\2\2\2\u0127\u0128"+
		"\7e\2\2\u0128\u0129\7q\2\2\u0129\u012a\7p\2\2\u012a\u012b\7v\2\2\u012b"+
		"\u012c\7k\2\2\u012c\u012d\7p\2\2\u012d\u012e\7w\2\2\u012e\u012f\7g\2\2"+
		"\u012f\66\3\2\2\2\u0130\u0131\7v\2\2\u0131\u0132\7t\2\2\u0132\u0133\7"+
		"w\2\2\u0133\u0134\7g\2\2\u01348\3\2\2\2\u0135\u0136\7h\2\2\u0136\u0137"+
		"\7c\2\2\u0137\u0138\7n\2\2\u0138\u0139\7u\2\2\u0139\u013a\7g\2\2\u013a"+
		":\3\2\2\2\u013b\u013e\5[.\2\u013c\u013e\7a\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013c\3\2\2\2\u013e\u0143\3\2\2\2\u013f\u0142\5]/\2\u0140\u0142\7a\2"+
		"\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0143\u0144\3\2\2\2\u0144<\3\2\2\2\u0145\u0143\3\2\2\2\u0146"+
		"\u0147\7*\2\2\u0147>\3\2\2\2\u0148\u0149\7+\2\2\u0149@\3\2\2\2\u014a\u014b"+
		"\7]\2\2\u014bB\3\2\2\2\u014c\u014d\7_\2\2\u014dD\3\2\2\2\u014e\u014f\7"+
		"}\2\2\u014fF\3\2\2\2\u0150\u0151\7\177\2\2\u0151H\3\2\2\2\u0152\u0153"+
		"\7-\2\2\u0153J\3\2\2\2\u0154\u0155\7/\2\2\u0155L\3\2\2\2\u0156\u0157\7"+
		",\2\2\u0157N\3\2\2\2\u0158\u0159\7\61\2\2\u0159P\3\2\2\2\u015a\u015b\7"+
		"(\2\2\u015b\u015c\7(\2\2\u015cR\3\2\2\2\u015d\u015e\7~\2\2\u015e\u015f"+
		"\7~\2\2\u015fT\3\2\2\2\u0160\u0161\7=\2\2\u0161V\3\2\2\2\u0162\u0163\7"+
		".\2\2\u0163X\3\2\2\2\u0164\u0165\t\n\2\2\u0165Z\3\2\2\2\u0166\u0167\t"+
		"\13\2\2\u0167\\\3\2\2\2\u0168\u016b\5Y-\2\u0169\u016b\5[.\2\u016a\u0168"+
		"\3\2\2\2\u016a\u0169\3\2\2\2\u016b^\3\2\2\2\u016c\u016f\5Y-\2\u016d\u016f"+
		"\t\13\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f`\3\2\2\2\u0170"+
		"\u0171\7)\2\2\u0171\u0172\7^\2\2\u0172\u0173\3\2\2\2\u0173\u0174\t\6\2"+
		"\2\u0174\u0175\7)\2\2\u0175b\3\2\2\2\u0176\u0177\7?\2\2\u0177d\3\2\2\2"+
		"\u0178\u0179\7\62\2\2\u0179\u017a\7z\2\2\u017a\u017c\3\2\2\2\u017b\u017d"+
		"\5_\60\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017ff\3\2\2\2\36\2mw|\u0089\u008e\u0093\u009b\u00a5\u00ab"+
		"\u00b2\u00b4\u00bc\u00be\u00c9\u00cb\u00cf\u00d6\u00dc\u00e3\u00e9\u00ed"+
		"\u013d\u0141\u0143\u016a\u016e\u017e\5\3\2\2\3\3\3\3\6\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
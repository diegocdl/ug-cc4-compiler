// Generated from scanner\DecafLexer.g by ANTLR 4.0

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
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, WHITESPACE=2, HEX_LITERAL=3, HEX_ERROR=4, DECIMAL_LITERAL=5, 
		CHAR_LITERAL=6, CHAR_ERROR=7, STRING_LITERAL=8, STRING_ERROR=9, ASIG_OP=10, 
		REL_OP=11, EQ_OP=12, BOOL_LITERAL=13, LITERAL=14, KW_INT=15, KW_BOOL=16, 
		KW_CALLOUT=17, KW_VOID=18, KW_IF=19, KW_ELSE=20, KW_FOR=21, KW_WHILE=22, 
		KW_RETURN=23, KW_BREAK=24, KW_CONTINUE=25, KW_TRUE=26, KW_FALSE=27, ID=28, 
		PARENTESIS_I=29, PARENTESIS_D=30, CORCHETE_I=31, CORCHETE_D=32, LLAVE_I=33, 
		LLAVE_D=34, PLUS=35, MINUS=36, MULT=37, DIV=38, AND=39, OR=40, PUNTO_COMA=41, 
		COMA=42;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"COMMENT", "WHITESPACE", "HEX_LITERAL", "HEX_ERROR", "DECIMAL_LITERAL", 
		"CHAR_LITERAL", "CHAR_ERROR", "STRING_LITERAL", "STRING_ERROR", "ASIG_OP", 
		"REL_OP", "EQ_OP", "BOOL_LITERAL", "LITERAL", "'int'", "'boolean'", "'callout'", 
		"'void'", "'if'", "'else'", "'for'", "'while'", "'return'", "'break'", 
		"'continue'", "'true'", "'false'", "ID", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", "';'", "','"
	};
	public static final String[] ruleNames = {
		"COMMENT", "WHITESPACE", "DIGIT", "ALPHA", "ALPHA_NUM", "HEX_DIGIT", "INT_LITERAL", 
		"HEX_LITERAL", "HEX_ERROR", "DECIMAL_LITERAL", "ESCAPE_CHAR", "CHAR_LITERAL", 
		"CHAR_ERROR", "STRING_LITERAL", "STRING_ERROR", "ASIG_OP", "REL_OP", "EQ_OP", 
		"BOOL_LITERAL", "LITERAL", "KW_INT", "KW_BOOL", "KW_CALLOUT", "KW_VOID", 
		"KW_IF", "KW_ELSE", "KW_FOR", "KW_WHILE", "KW_RETURN", "KW_BREAK", "KW_CONTINUE", 
		"KW_TRUE", "KW_FALSE", "ID", "PARENTESIS_I", "PARENTESIS_D", "CORCHETE_I", 
		"CORCHETE_D", "LLAVE_I", "LLAVE_D", "PLUS", "MINUS", "MULT", "DIV", "AND", 
		"OR", "PUNTO_COMA", "COMA"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 1: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;

		case 20: KW_INT_action((RuleContext)_localctx, actionIndex); break;

		case 21: KW_BOOL_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip(); break;
		}
	}
	private void KW_INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  System.out.println("Palabra reservada int"); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}
	private void KW_BOOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  System.out.println("Palabra reservada boolean"); break;
		}
	}

	public static final String _serializedATN =
		"\2\4,\u017b\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2"+
		"\3\2\3\2\3\2\7\2h\n\2\f\2\16\2k\13\2\3\2\3\2\3\2\3\2\3\2\7\2r\n\2\f\2"+
		"\16\2u\13\2\3\2\3\2\5\2y\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\5\6\u0086\n\6\3\7\3\7\5\7\u008a\n\7\3\b\3\b\5\b\u008e\n\b\3\t\3\t\3"+
		"\t\3\t\6\t\u0094\n\t\r\t\16\t\u0095\3\n\3\n\3\n\3\n\7\n\u009c\n\n\f\n"+
		"\16\n\u009f\13\n\3\13\6\13\u00a2\n\13\r\13\16\13\u00a3\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00b0\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00ba\n\16\3\16\3\16\6\16\u00be\n\16\r\16\16\16\u00bf\3"+
		"\16\3\16\3\16\6\16\u00c5\n\16\r\16\16\16\u00c6\5\16\u00c9\n\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u00d1\n\17\f\17\16\17\u00d4\13\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00de\n\20\f\20\16\20\u00e1\13"+
		"\20\3\20\5\20\u00e4\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00eb\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00f2\n\22\3\23\3\23\3\23\3\23\5\23\u00f8\n"+
		"\23\3\24\3\24\5\24\u00fc\n\24\3\25\3\25\3\25\5\25\u0101\n\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3#\3#\5#\u0155\n#\3#\3#\7#\u0159\n#\f#\16#\u015c\13#\3$\3$\3%\3"+
		"%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/"+
		"\3\60\3\60\3\61\3\61\2\62\3\3\2\5\4\3\7\2\1\t\2\1\13\2\1\r\2\1\17\2\1"+
		"\21\5\1\23\6\1\25\7\1\27\2\1\31\b\1\33\t\1\35\n\1\37\13\1!\f\1#\r\1%\16"+
		"\1\'\17\1)\20\1+\21\4-\22\5/\23\1\61\24\1\63\25\1\65\26\1\67\27\19\30"+
		"\1;\31\1=\32\1?\33\1A\34\1C\35\1E\36\1G\37\1I \1K!\1M\"\1O#\1Q$\1S%\1"+
		"U&\1W\'\1Y(\1[)\1]*\1_+\1a,\1\3\2\22\3\f\f\3\f\f\5\13\f\17\17\"\"\3\62"+
		";\4C\\c|\4C\\c|\5\62;C\\c|\7$$))^^ppvv\6\f\f$$))^^\6\f\f$$))^^\7$$))^"+
		"^ppvv\3))\3))\4$$))\4$$))\4>>@@\u0196\2\3\3\2\2\2\2\5\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3x\3\2\2\2\5|\3\2\2\2\7\177\3\2"+
		"\2\2\t\u0081\3\2\2\2\13\u0085\3\2\2\2\r\u0089\3\2\2\2\17\u008d\3\2\2\2"+
		"\21\u008f\3\2\2\2\23\u0097\3\2\2\2\25\u00a1\3\2\2\2\27\u00a5\3\2\2\2\31"+
		"\u00af\3\2\2\2\33\u00c8\3\2\2\2\35\u00ca\3\2\2\2\37\u00d7\3\2\2\2!\u00ea"+
		"\3\2\2\2#\u00f1\3\2\2\2%\u00f7\3\2\2\2\'\u00fb\3\2\2\2)\u0100\3\2\2\2"+
		"+\u0102\3\2\2\2-\u0108\3\2\2\2/\u0112\3\2\2\2\61\u011a\3\2\2\2\63\u011f"+
		"\3\2\2\2\65\u0122\3\2\2\2\67\u0127\3\2\2\29\u012b\3\2\2\2;\u0131\3\2\2"+
		"\2=\u0138\3\2\2\2?\u013e\3\2\2\2A\u0147\3\2\2\2C\u014c\3\2\2\2E\u0154"+
		"\3\2\2\2G\u015d\3\2\2\2I\u015f\3\2\2\2K\u0161\3\2\2\2M\u0163\3\2\2\2O"+
		"\u0165\3\2\2\2Q\u0167\3\2\2\2S\u0169\3\2\2\2U\u016b\3\2\2\2W\u016d\3\2"+
		"\2\2Y\u016f\3\2\2\2[\u0171\3\2\2\2]\u0174\3\2\2\2_\u0177\3\2\2\2a\u0179"+
		"\3\2\2\2cd\7\61\2\2de\7\61\2\2ei\3\2\2\2fh\n\2\2\2gf\3\2\2\2hk\3\2\2\2"+
		"ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2ly\5\5\3\2mn\7\61\2\2no\7,\2\2"+
		"os\3\2\2\2pr\n\3\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2"+
		"us\3\2\2\2vw\7,\2\2wy\7\61\2\2xc\3\2\2\2xm\3\2\2\2yz\3\2\2\2z{\b\2\2\2"+
		"{\4\3\2\2\2|}\t\4\2\2}~\b\3\3\2~\6\3\2\2\2\177\u0080\t\5\2\2\u0080\b\3"+
		"\2\2\2\u0081\u0082\t\6\2\2\u0082\n\3\2\2\2\u0083\u0086\5\7\4\2\u0084\u0086"+
		"\5\t\5\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\f\3\2\2\2\u0087"+
		"\u008a\5\7\4\2\u0088\u008a\t\7\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2"+
		"\2\2\u008a\16\3\2\2\2\u008b\u008e\5\25\13\2\u008c\u008e\5\21\t\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\20\3\2\2\2\u008f\u0090\7\62\2"+
		"\2\u0090\u0091\7z\2\2\u0091\u0093\3\2\2\2\u0092\u0094\5\r\7\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\22\3\2\2\2\u0097\u0098\7\62\2\2\u0098\u0099\7z\2\2\u0099\u009d\3\2\2"+
		"\2\u009a\u009c\n\b\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\24\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a2\5\7\4\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\7)\2\2\u00a6\u00a7"+
		"\7^\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\t\t\2\2\u00a9\u00aa\7)\2\2\u00aa"+
		"\30\3\2\2\2\u00ab\u00ac\7)\2\2\u00ac\u00ad\n\n\2\2\u00ad\u00b0\7)\2\2"+
		"\u00ae\u00b0\5\27\f\2\u00af\u00ab\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\32"+
		"\3\2\2\2\u00b1\u00b2\7)\2\2\u00b2\u00b3\t\13\2\2\u00b3\u00c9\7)\2\2\u00b4"+
		"\u00b5\7)\2\2\u00b5\u00b6\7^\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\n\f\2"+
		"\2\u00b8\u00ba\7)\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00c9"+
		"\3\2\2\2\u00bb\u00bd\7)\2\2\u00bc\u00be\n\r\2\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c9\7)\2\2\u00c2\u00c4\7)\2\2\u00c3\u00c5\n\16\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00b1\3\2\2\2\u00c8\u00b4\3\2\2\2\u00c8"+
		"\u00bb\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c9\34\3\2\2\2\u00ca\u00d2\7$\2\2"+
		"\u00cb\u00cc\7^\2\2\u00cc\u00d1\7$\2\2\u00cd\u00ce\7^\2\2\u00ce\u00d1"+
		"\7)\2\2\u00cf\u00d1\n\17\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6"+
		"\36\3\2\2\2\u00d7\u00df\7$\2\2\u00d8\u00d9\7^\2\2\u00d9\u00de\7$\2\2\u00da"+
		"\u00db\7^\2\2\u00db\u00de\7)\2\2\u00dc\u00de\n\20\2\2\u00dd\u00d8\3\2"+
		"\2\2\u00dd\u00da\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e2\u00e4\7)\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		" \3\2\2\2\u00e5\u00eb\7?\2\2\u00e6\u00e7\7-\2\2\u00e7\u00eb\7?\2\2\u00e8"+
		"\u00e9\7/\2\2\u00e9\u00eb\7?\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e6\3\2\2"+
		"\2\u00ea\u00e8\3\2\2\2\u00eb\"\3\2\2\2\u00ec\u00f2\t\21\2\2\u00ed\u00ee"+
		"\7>\2\2\u00ee\u00f2\7?\2\2\u00ef\u00f0\7@\2\2\u00f0\u00f2\7?\2\2\u00f1"+
		"\u00ec\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2$\3\2\2\2"+
		"\u00f3\u00f4\7?\2\2\u00f4\u00f8\7?\2\2\u00f5\u00f6\7#\2\2\u00f6\u00f8"+
		"\7?\2\2\u00f7\u00f3\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8&\3\2\2\2\u00f9\u00fc"+
		"\5A!\2\u00fa\u00fc\5C\"\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"(\3\2\2\2\u00fd\u0101\5\17\b\2\u00fe\u0101\5\31\r\2\u00ff\u0101\5\'\24"+
		"\2\u0100\u00fd\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101*"+
		"\3\2\2\2\u0102\u0103\7k\2\2\u0103\u0104\7p\2\2\u0104\u0105\7v\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\b\26\4\2\u0107,\3\2\2\2\u0108\u0109\7d\2\2"+
		"\u0109\u010a\7q\2\2\u010a\u010b\7q\2\2\u010b\u010c\7n\2\2\u010c\u010d"+
		"\7g\2\2\u010d\u010e\7c\2\2\u010e\u010f\7p\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\b\27\5\2\u0111.\3\2\2\2\u0112\u0113\7e\2\2\u0113\u0114\7c\2\2\u0114"+
		"\u0115\7n\2\2\u0115\u0116\7n\2\2\u0116\u0117\7q\2\2\u0117\u0118\7w\2\2"+
		"\u0118\u0119\7v\2\2\u0119\60\3\2\2\2\u011a\u011b\7x\2\2\u011b\u011c\7"+
		"q\2\2\u011c\u011d\7k\2\2\u011d\u011e\7f\2\2\u011e\62\3\2\2\2\u011f\u0120"+
		"\7k\2\2\u0120\u0121\7h\2\2\u0121\64\3\2\2\2\u0122\u0123\7g\2\2\u0123\u0124"+
		"\7n\2\2\u0124\u0125\7u\2\2\u0125\u0126\7g\2\2\u0126\66\3\2\2\2\u0127\u0128"+
		"\7h\2\2\u0128\u0129\7q\2\2\u0129\u012a\7t\2\2\u012a8\3\2\2\2\u012b\u012c"+
		"\7y\2\2\u012c\u012d\7j\2\2\u012d\u012e\7k\2\2\u012e\u012f\7n\2\2\u012f"+
		"\u0130\7g\2\2\u0130:\3\2\2\2\u0131\u0132\7t\2\2\u0132\u0133\7g\2\2\u0133"+
		"\u0134\7v\2\2\u0134\u0135\7w\2\2\u0135\u0136\7t\2\2\u0136\u0137\7p\2\2"+
		"\u0137<\3\2\2\2\u0138\u0139\7d\2\2\u0139\u013a\7t\2\2\u013a\u013b\7g\2"+
		"\2\u013b\u013c\7c\2\2\u013c\u013d\7m\2\2\u013d>\3\2\2\2\u013e\u013f\7"+
		"e\2\2\u013f\u0140\7q\2\2\u0140\u0141\7p\2\2\u0141\u0142\7v\2\2\u0142\u0143"+
		"\7k\2\2\u0143\u0144\7p\2\2\u0144\u0145\7w\2\2\u0145\u0146\7g\2\2\u0146"+
		"@\3\2\2\2\u0147\u0148\7v\2\2\u0148\u0149\7t\2\2\u0149\u014a\7w\2\2\u014a"+
		"\u014b\7g\2\2\u014bB\3\2\2\2\u014c\u014d\7h\2\2\u014d\u014e\7c\2\2\u014e"+
		"\u014f\7n\2\2\u014f\u0150\7u\2\2\u0150\u0151\7g\2\2\u0151D\3\2\2\2\u0152"+
		"\u0155\5\t\5\2\u0153\u0155\7a\2\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2"+
		"\2\2\u0155\u015a\3\2\2\2\u0156\u0159\5\13\6\2\u0157\u0159\7a\2\2\u0158"+
		"\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015a\u015b\3\2\2\2\u015bF\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e"+
		"\7*\2\2\u015eH\3\2\2\2\u015f\u0160\7+\2\2\u0160J\3\2\2\2\u0161\u0162\7"+
		"]\2\2\u0162L\3\2\2\2\u0163\u0164\7_\2\2\u0164N\3\2\2\2\u0165\u0166\7}"+
		"\2\2\u0166P\3\2\2\2\u0167\u0168\7\177\2\2\u0168R\3\2\2\2\u0169\u016a\7"+
		"-\2\2\u016aT\3\2\2\2\u016b\u016c\7/\2\2\u016cV\3\2\2\2\u016d\u016e\7,"+
		"\2\2\u016eX\3\2\2\2\u016f\u0170\7\61\2\2\u0170Z\3\2\2\2\u0171\u0172\7"+
		"(\2\2\u0172\u0173\7(\2\2\u0173\\\3\2\2\2\u0174\u0175\7~\2\2\u0175\u0176"+
		"\7~\2\2\u0176^\3\2\2\2\u0177\u0178\7=\2\2\u0178`\3\2\2\2\u0179\u017a\7"+
		".\2\2\u017ab\3\2\2\2\36\2isx\u0085\u0089\u008d\u0095\u009d\u00a3\u00af"+
		"\u00b9\u00bf\u00c6\u00c8\u00d0\u00d2\u00dd\u00df\u00e3\u00ea\u00f1\u00f7"+
		"\u00fb\u0100\u0154\u0158\u015a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
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
		CHAR_LITERAL=6, CHAR_ERROR=7, STRING_LITERAL=8, BIN_OP=9, ADD_ARITH_OP=10, 
		MULT_ARITH_OP=11, COND_OP=12, ASIG_OP=13, REL_OP=14, EQ_OP=15, BOOL_LITERAL=16, 
		LITERAL=17, KW_INT=18, KW_BOOL=19, KW_CALLOUT=20, KW_VOID=21, KW_IF=22, 
		KW_ELSE=23, KW_FOR=24, KW_WHILE=25, KW_RETURN=26, KW_BREAK=27, KW_CONTINUE=28, 
		KW_TRUE=29, KW_FALSE=30, ID=31, PLUS=32, MINUS=33, MULT=34, DIV=35, AND=36, 
		OR=37, PUNTO_COMA=38, COMA=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"COMMENT", "WHITESPACE", "HEX_LITERAL", "HEX_ERROR", "DECIMAL_LITERAL", 
		"CHAR_LITERAL", "CHAR_ERROR", "STRING_LITERAL", "BIN_OP", "ADD_ARITH_OP", 
		"MULT_ARITH_OP", "COND_OP", "ASIG_OP", "REL_OP", "EQ_OP", "BOOL_LITERAL", 
		"LITERAL", "'int'", "'boolean'", "'callout'", "'void'", "'if'", "'else'", 
		"'for'", "'while'", "'return'", "'break'", "'continue'", "'true'", "'false'", 
		"ID", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", "';'", "','"
	};
	public static final String[] ruleNames = {
		"COMMENT", "WHITESPACE", "DIGIT", "ALPHA", "ALPHA_NUM", "HEX_DIGIT", "INT_LITERAL", 
		"HEX_LITERAL", "HEX_ERROR", "DECIMAL_LITERAL", "ESCAPE_CHAR", "CHAR_LITERAL", 
		"CHAR_ERROR", "STRING_LITERAL", "BIN_OP", "ADD_ARITH_OP", "MULT_ARITH_OP", 
		"COND_OP", "ASIG_OP", "REL_OP", "EQ_OP", "BOOL_LITERAL", "LITERAL", "KW_INT", 
		"KW_BOOL", "KW_CALLOUT", "KW_VOID", "KW_IF", "KW_ELSE", "KW_FOR", "KW_WHILE", 
		"KW_RETURN", "KW_BREAK", "KW_CONTINUE", "KW_TRUE", "KW_FALSE", "ID", "PLUS", 
		"MINUS", "MULT", "DIV", "AND", "OR", "PUNTO_COMA", "COMA"
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

		case 23: KW_INT_action((RuleContext)_localctx, actionIndex); break;

		case 24: KW_BOOL_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4)\u016b\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\7\2b\n\2\f\2"+
		"\16\2e\13\2\3\2\3\2\3\2\3\2\3\2\7\2l\n\2\f\2\16\2o\13\2\3\2\3\2\5\2s\n"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\5\6\u0080\n\6\3\7\3\7\5"+
		"\7\u0084\n\7\3\b\3\b\5\b\u0088\n\b\3\t\3\t\3\t\3\t\6\t\u008e\n\t\r\t\16"+
		"\t\u008f\3\n\3\n\3\n\3\n\7\n\u0096\n\n\f\n\16\n\u0099\13\n\3\13\6\13\u009c"+
		"\n\13\r\13\16\13\u009d\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00aa"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b4\n\16\3\16\3\16"+
		"\6\16\u00b8\n\16\r\16\16\16\u00b9\3\16\3\16\3\16\6\16\u00bf\n\16\r\16"+
		"\16\16\u00c0\5\16\u00c3\n\16\3\17\3\17\7\17\u00c7\n\17\f\17\16\17\u00ca"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00d3\n\20\3\21\3\21\5"+
		"\21\u00d7\n\21\3\22\3\22\3\22\5\22\u00dc\n\22\3\23\3\23\5\23\u00e0\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00e7\n\24\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00ee\n\25\3\26\3\26\3\26\3\26\5\26\u00f4\n\26\3\27\3\27\5\27\u00f8\n"+
		"\27\3\30\3\30\3\30\5\30\u00fd\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%"+
		"\3%\3%\3%\3%\3%\3&\3&\5&\u0151\n&\3&\3&\7&\u0155\n&\f&\16&\u0158\13&\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\2/\3\3\2\5\4\3"+
		"\7\2\1\t\2\1\13\2\1\r\2\1\17\2\1\21\5\1\23\6\1\25\7\1\27\2\1\31\b\1\33"+
		"\t\1\35\n\1\37\13\1!\f\1#\r\1%\16\1\'\17\1)\20\1+\21\1-\22\1/\23\1\61"+
		"\24\4\63\25\5\65\26\1\67\27\19\30\1;\31\1=\32\1?\33\1A\34\1C\35\1E\36"+
		"\1G\37\1I \1K!\1M\"\1O#\1Q$\1S%\1U&\1W\'\1Y(\1[)\1\3\2\21\3\f\f\3\f\f"+
		"\5\13\f\17\17\"\"\3\62;\4C\\c|\4C\\c|\5\62;C\\c|\7$$))^^ppvv\6\f\f$$)"+
		")^^\6\f\f$$))^^\7$$))^^ppvv\3))\3))\3$$\4>>@@\u0188\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\3r\3\2\2\2\5v\3\2\2\2\7y\3\2\2\2\t{\3\2\2\2\13\177"+
		"\3\2\2\2\r\u0083\3\2\2\2\17\u0087\3\2\2\2\21\u0089\3\2\2\2\23\u0091\3"+
		"\2\2\2\25\u009b\3\2\2\2\27\u009f\3\2\2\2\31\u00a9\3\2\2\2\33\u00c2\3\2"+
		"\2\2\35\u00c4\3\2\2\2\37\u00d2\3\2\2\2!\u00d6\3\2\2\2#\u00db\3\2\2\2%"+
		"\u00df\3\2\2\2\'\u00e6\3\2\2\2)\u00ed\3\2\2\2+\u00f3\3\2\2\2-\u00f7\3"+
		"\2\2\2/\u00fc\3\2\2\2\61\u00fe\3\2\2\2\63\u0104\3\2\2\2\65\u010e\3\2\2"+
		"\2\67\u0116\3\2\2\29\u011b\3\2\2\2;\u011e\3\2\2\2=\u0123\3\2\2\2?\u0127"+
		"\3\2\2\2A\u012d\3\2\2\2C\u0134\3\2\2\2E\u013a\3\2\2\2G\u0143\3\2\2\2I"+
		"\u0148\3\2\2\2K\u0150\3\2\2\2M\u0159\3\2\2\2O\u015b\3\2\2\2Q\u015d\3\2"+
		"\2\2S\u015f\3\2\2\2U\u0161\3\2\2\2W\u0164\3\2\2\2Y\u0167\3\2\2\2[\u0169"+
		"\3\2\2\2]^\7\61\2\2^_\7\61\2\2_c\3\2\2\2`b\n\2\2\2a`\3\2\2\2be\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fs\5\5\3\2gh\7\61\2\2hi\7,\2\2"+
		"im\3\2\2\2jl\n\3\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2"+
		"om\3\2\2\2pq\7,\2\2qs\7\61\2\2r]\3\2\2\2rg\3\2\2\2st\3\2\2\2tu\b\2\2\2"+
		"u\4\3\2\2\2vw\t\4\2\2wx\b\3\3\2x\6\3\2\2\2yz\t\5\2\2z\b\3\2\2\2{|\t\6"+
		"\2\2|\n\3\2\2\2}\u0080\5\7\4\2~\u0080\5\t\5\2\177}\3\2\2\2\177~\3\2\2"+
		"\2\u0080\f\3\2\2\2\u0081\u0084\5\7\4\2\u0082\u0084\t\7\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0082\3\2\2\2\u0084\16\3\2\2\2\u0085\u0088\5\25\13\2\u0086"+
		"\u0088\5\21\t\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\20\3\2\2"+
		"\2\u0089\u008a\7\62\2\2\u008a\u008b\7z\2\2\u008b\u008d\3\2\2\2\u008c\u008e"+
		"\5\r\7\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\22\3\2\2\2\u0091\u0092\7\62\2\2\u0092\u0093\7z\2"+
		"\2\u0093\u0097\3\2\2\2\u0094\u0096\n\b\2\2\u0095\u0094\3\2\2\2\u0096\u0099"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\24\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009c\5\7\4\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\26\3\2\2\2\u009f\u00a0"+
		"\7)\2\2\u00a0\u00a1\7^\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\t\t\2\2\u00a3"+
		"\u00a4\7)\2\2\u00a4\30\3\2\2\2\u00a5\u00a6\7)\2\2\u00a6\u00a7\n\n\2\2"+
		"\u00a7\u00aa\7)\2\2\u00a8\u00aa\5\27\f\2\u00a9\u00a5\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\32\3\2\2\2\u00ab\u00ac\7)\2\2\u00ac\u00ad\t\13\2\2\u00ad"+
		"\u00c3\7)\2\2\u00ae\u00af\7)\2\2\u00af\u00b0\7^\2\2\u00b0\u00b1\3\2\2"+
		"\2\u00b1\u00b3\n\f\2\2\u00b2\u00b4\7)\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00c3\3\2\2\2\u00b5\u00b7\7)\2\2\u00b6\u00b8\n\r\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00c3\7)\2\2\u00bc\u00be\7)\2\2\u00bd\u00bf"+
		"\n\16\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00ab\3\2\2\2\u00c2\u00ae"+
		"\3\2\2\2\u00c2\u00b5\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c3\34\3\2\2\2\u00c4"+
		"\u00c8\7$\2\2\u00c5\u00c7\n\17\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cc\7$\2\2\u00cc\36\3\2\2\2\u00cd\u00d3\5!\21\2"+
		"\u00ce\u00d3\5#\22\2\u00cf\u00d3\5)\25\2\u00d0\u00d3\5+\26\2\u00d1\u00d3"+
		"\5%\23\2\u00d2\u00cd\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3 \3\2\2\2\u00d4\u00d7\5M\'\2\u00d5"+
		"\u00d7\5O(\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\"\3\2\2\2\u00d8"+
		"\u00dc\5Q)\2\u00d9\u00dc\5S*\2\u00da\u00dc\7\'\2\2\u00db\u00d8\3\2\2\2"+
		"\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc$\3\2\2\2\u00dd\u00e0\5"+
		"W,\2\u00de\u00e0\5U+\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0&"+
		"\3\2\2\2\u00e1\u00e7\7?\2\2\u00e2\u00e3\7-\2\2\u00e3\u00e7\7?\2\2\u00e4"+
		"\u00e5\7/\2\2\u00e5\u00e7\7?\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2\2"+
		"\2\u00e6\u00e4\3\2\2\2\u00e7(\3\2\2\2\u00e8\u00ee\t\20\2\2\u00e9\u00ea"+
		"\7>\2\2\u00ea\u00ee\7?\2\2\u00eb\u00ec\7@\2\2\u00ec\u00ee\7?\2\2\u00ed"+
		"\u00e8\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee*\3\2\2\2"+
		"\u00ef\u00f0\7?\2\2\u00f0\u00f4\7?\2\2\u00f1\u00f2\7#\2\2\u00f2\u00f4"+
		"\7?\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4,\3\2\2\2\u00f5\u00f8"+
		"\5G$\2\u00f6\u00f8\5I%\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		".\3\2\2\2\u00f9\u00fd\5\17\b\2\u00fa\u00fd\5\31\r\2\u00fb\u00fd\5-\27"+
		"\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\60"+
		"\3\2\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7v\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0103\b\31\4\2\u0103\62\3\2\2\2\u0104\u0105\7d\2"+
		"\2\u0105\u0106\7q\2\2\u0106\u0107\7q\2\2\u0107\u0108\7n\2\2\u0108\u0109"+
		"\7g\2\2\u0109\u010a\7c\2\2\u010a\u010b\7p\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\b\32\5\2\u010d\64\3\2\2\2\u010e\u010f\7e\2\2\u010f\u0110\7c\2\2"+
		"\u0110\u0111\7n\2\2\u0111\u0112\7n\2\2\u0112\u0113\7q\2\2\u0113\u0114"+
		"\7w\2\2\u0114\u0115\7v\2\2\u0115\66\3\2\2\2\u0116\u0117\7x\2\2\u0117\u0118"+
		"\7q\2\2\u0118\u0119\7k\2\2\u0119\u011a\7f\2\2\u011a8\3\2\2\2\u011b\u011c"+
		"\7k\2\2\u011c\u011d\7h\2\2\u011d:\3\2\2\2\u011e\u011f\7g\2\2\u011f\u0120"+
		"\7n\2\2\u0120\u0121\7u\2\2\u0121\u0122\7g\2\2\u0122<\3\2\2\2\u0123\u0124"+
		"\7h\2\2\u0124\u0125\7q\2\2\u0125\u0126\7t\2\2\u0126>\3\2\2\2\u0127\u0128"+
		"\7y\2\2\u0128\u0129\7j\2\2\u0129\u012a\7k\2\2\u012a\u012b\7n\2\2\u012b"+
		"\u012c\7g\2\2\u012c@\3\2\2\2\u012d\u012e\7t\2\2\u012e\u012f\7g\2\2\u012f"+
		"\u0130\7v\2\2\u0130\u0131\7w\2\2\u0131\u0132\7t\2\2\u0132\u0133\7p\2\2"+
		"\u0133B\3\2\2\2\u0134\u0135\7d\2\2\u0135\u0136\7t\2\2\u0136\u0137\7g\2"+
		"\2\u0137\u0138\7c\2\2\u0138\u0139\7m\2\2\u0139D\3\2\2\2\u013a\u013b\7"+
		"e\2\2\u013b\u013c\7q\2\2\u013c\u013d\7p\2\2\u013d\u013e\7v\2\2\u013e\u013f"+
		"\7k\2\2\u013f\u0140\7p\2\2\u0140\u0141\7w\2\2\u0141\u0142\7g\2\2\u0142"+
		"F\3\2\2\2\u0143\u0144\7v\2\2\u0144\u0145\7t\2\2\u0145\u0146\7w\2\2\u0146"+
		"\u0147\7g\2\2\u0147H\3\2\2\2\u0148\u0149\7h\2\2\u0149\u014a\7c\2\2\u014a"+
		"\u014b\7n\2\2\u014b\u014c\7u\2\2\u014c\u014d\7g\2\2\u014dJ\3\2\2\2\u014e"+
		"\u0151\5\t\5\2\u014f\u0151\7a\2\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2"+
		"\2\2\u0151\u0156\3\2\2\2\u0152\u0155\5\13\6\2\u0153\u0155\7a\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157L\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a"+
		"\7-\2\2\u015aN\3\2\2\2\u015b\u015c\7/\2\2\u015cP\3\2\2\2\u015d\u015e\7"+
		",\2\2\u015eR\3\2\2\2\u015f\u0160\7\61\2\2\u0160T\3\2\2\2\u0161\u0162\7"+
		"(\2\2\u0162\u0163\7(\2\2\u0163V\3\2\2\2\u0164\u0165\7~\2\2\u0165\u0166"+
		"\7~\2\2\u0166X\3\2\2\2\u0167\u0168\7=\2\2\u0168Z\3\2\2\2\u0169\u016a\7"+
		".\2\2\u016a\\\3\2\2\2\36\2cmr\177\u0083\u0087\u008f\u0097\u009d\u00a9"+
		"\u00b3\u00b9\u00c0\u00c2\u00c8\u00d2\u00d6\u00db\u00df\u00e6\u00ed\u00f3"+
		"\u00f7\u00fc\u0150\u0154\u0156";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
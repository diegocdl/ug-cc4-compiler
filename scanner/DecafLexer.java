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
		COMMENT=1, DIGIT=2, ALPHA=3, ALPHA_NUM=4, HEX_DIGIT=5, DECIMAL_LITERAL=6, 
		INT_LITERAL=7, CHAR_ERROR=8, CHAR_LITERAL=9, ESCAPE_CHAR=10, STRING_LITERAL=11, 
		ID=12, BIN_OP=13, ADD_ARITH_OP=14, MULT_ARITH_OP=15, COND_OP=16, ASIG_OP=17, 
		REL_OP=18, EQ_OP=19, BOOL_LITERAL=20, HEX_LITERAL=21, LITERAL=22, KW_INT=23, 
		KW_BOOL=24, KW_CALLOUT=25, KW_VOID=26, KW_IF=27, KW_ELSE=28, KW_FOR=29, 
		KW_WHILE=30, KW_RETURN=31, KW_BREAK=32, KW_CONTINUE=33, KW_TRUE=34, KW_FALSE=35, 
		PLUS=36, MINUS=37, MULT=38, DIV=39, AND=40, OR=41, PUNTO_COMA=42, COMA=43, 
		WHITESPACE=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"COMMENT", "DIGIT", "ALPHA", "ALPHA_NUM", "HEX_DIGIT", "DECIMAL_LITERAL", 
		"INT_LITERAL", "CHAR_ERROR", "CHAR_LITERAL", "ESCAPE_CHAR", "STRING_LITERAL", 
		"ID", "BIN_OP", "ADD_ARITH_OP", "MULT_ARITH_OP", "COND_OP", "ASIG_OP", 
		"REL_OP", "EQ_OP", "BOOL_LITERAL", "HEX_LITERAL", "LITERAL", "'int'", 
		"'boolean'", "'callout'", "'void'", "'if'", "'else'", "'for'", "'while'", 
		"'return'", "'break'", "'continue'", "'true'", "'false'", "'+'", "'-'", 
		"'*'", "'/'", "'&&'", "'||'", "';'", "','", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"COMMENT", "DIGIT", "ALPHA", "ALPHA_NUM", "HEX_DIGIT", "DECIMAL_LITERAL", 
		"INT_LITERAL", "CHAR_ERROR", "CHAR_LITERAL", "ESCAPE_CHAR", "STRING_LITERAL", 
		"ID", "BIN_OP", "ADD_ARITH_OP", "MULT_ARITH_OP", "COND_OP", "ASIG_OP", 
		"REL_OP", "EQ_OP", "BOOL_LITERAL", "HEX_LITERAL", "LITERAL", "KW_INT", 
		"KW_BOOL", "KW_CALLOUT", "KW_VOID", "KW_IF", "KW_ELSE", "KW_FOR", "KW_WHILE", 
		"KW_RETURN", "KW_BREAK", "KW_CONTINUE", "KW_TRUE", "KW_FALSE", "PLUS", 
		"MINUS", "MULT", "DIV", "AND", "OR", "PUNTO_COMA", "COMA", "WHITESPACE"
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

		case 22: KW_INT_action((RuleContext)_localctx, actionIndex); break;

		case 23: KW_BOOL_action((RuleContext)_localctx, actionIndex); break;

		case 43: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void KW_BOOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: System.out.println("Palabra reservada boolean"); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip(); break;
		}
	}
	private void KW_INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: System.out.println("Palabra reservada int"); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip(); break;
		}
	}

	public static final String _serializedATN =
		"\2\4.\u0155\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\3\2\3\2\3\2\3\2\7\2`\n\2\f\2\16\2c"+
		"\13\2\3\2\3\2\3\2\3\2\3\2\7\2j\n\2\f\2\16\2m\13\2\3\2\3\2\5\2q\n\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5{\n\5\3\6\3\6\5\6\177\n\6\3\7\6\7\u0082"+
		"\n\7\r\7\16\7\u0083\3\b\3\b\5\b\u0088\n\b\3\t\3\t\3\t\3\t\3\t\6\t\u008f"+
		"\n\t\r\t\16\t\u0090\3\t\3\t\3\t\3\t\3\t\5\t\u0098\n\t\5\t\u009a\n\t\3"+
		"\n\3\n\3\n\3\n\5\n\u00a0\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\7\f"+
		"\u00aa\n\f\f\f\16\f\u00ad\13\f\3\f\3\f\3\r\3\r\7\r\u00b3\n\r\f\r\16\r"+
		"\u00b6\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00bd\n\16\3\17\3\17\5\17\u00c1"+
		"\n\17\3\20\3\20\3\20\5\20\u00c6\n\20\3\21\3\21\5\21\u00ca\n\21\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u00d1\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u00d8"+
		"\n\23\3\24\3\24\3\24\3\24\5\24\u00de\n\24\3\25\3\25\5\25\u00e2\n\25\3"+
		"\26\3\26\3\26\3\26\6\26\u00e8\n\26\r\26\16\26\u00e9\3\27\3\27\3\27\5\27"+
		"\u00ef\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-"+
		"\2.\3\3\2\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1"+
		"\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1"+
		"+\27\1-\30\1/\31\3\61\32\4\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1"+
		"A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\5\3\2\16\3\f\f\3"+
		"\f\f\3\62;\4C\\c|\4C\\c|\3))\f$$))\62\62^^ddhhppttvvxx\3))\f$$))\62\62"+
		"^^ddhhppttvvxx\3$$\4>>@@\4\13\f\"\"\u0173\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\3p\3\2\2\2\5t\3\2\2\2\7v\3\2\2\2\tz\3\2\2\2\13~\3\2\2\2\r\u0081\3"+
		"\2\2\2\17\u0087\3\2\2\2\21\u0099\3\2\2\2\23\u009f\3\2\2\2\25\u00a1\3\2"+
		"\2\2\27\u00a7\3\2\2\2\31\u00b0\3\2\2\2\33\u00bc\3\2\2\2\35\u00c0\3\2\2"+
		"\2\37\u00c5\3\2\2\2!\u00c9\3\2\2\2#\u00d0\3\2\2\2%\u00d7\3\2\2\2\'\u00dd"+
		"\3\2\2\2)\u00e1\3\2\2\2+\u00e3\3\2\2\2-\u00ee\3\2\2\2/\u00f0\3\2\2\2\61"+
		"\u00f6\3\2\2\2\63\u0100\3\2\2\2\65\u0108\3\2\2\2\67\u010d\3\2\2\29\u0110"+
		"\3\2\2\2;\u0115\3\2\2\2=\u0119\3\2\2\2?\u011f\3\2\2\2A\u0126\3\2\2\2C"+
		"\u012c\3\2\2\2E\u0135\3\2\2\2G\u013a\3\2\2\2I\u0140\3\2\2\2K\u0142\3\2"+
		"\2\2M\u0144\3\2\2\2O\u0146\3\2\2\2Q\u0148\3\2\2\2S\u014b\3\2\2\2U\u014e"+
		"\3\2\2\2W\u0150\3\2\2\2Y\u0152\3\2\2\2[\\\7\61\2\2\\]\7\61\2\2]a\3\2\2"+
		"\2^`\n\2\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2"+
		"\2dq\5Y-\2ef\7\61\2\2fg\7,\2\2gk\3\2\2\2hj\n\3\2\2ih\3\2\2\2jm\3\2\2\2"+
		"ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7,\2\2oq\7\61\2\2p[\3\2\2\2"+
		"pe\3\2\2\2qr\3\2\2\2rs\b\2\2\2s\4\3\2\2\2tu\t\4\2\2u\6\3\2\2\2vw\t\5\2"+
		"\2w\b\3\2\2\2x{\5\5\3\2y{\5\7\4\2zx\3\2\2\2zy\3\2\2\2{\n\3\2\2\2|\177"+
		"\5\5\3\2}\177\t\6\2\2~|\3\2\2\2~}\3\2\2\2\177\f\3\2\2\2\u0080\u0082\5"+
		"\5\3\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\16\3\2\2\2\u0085\u0088\5\r\7\2\u0086\u0088\5+\26"+
		"\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\20\3\2\2\2\u0089\u008a"+
		"\7)\2\2\u008a\u008b\7)\2\2\u008b\u009a\7)\2\2\u008c\u008e\7)\2\2\u008d"+
		"\u008f\n\7\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u009a\3\2\2\2\u0092\u0093\7)\2\2\u0093"+
		"\u0094\7^\2\2\u0094\u0095\3\2\2\2\u0095\u0097\n\b\2\2\u0096\u0098\7)\2"+
		"\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0089"+
		"\3\2\2\2\u0099\u008c\3\2\2\2\u0099\u0092\3\2\2\2\u009a\22\3\2\2\2\u009b"+
		"\u009c\7)\2\2\u009c\u009d\n\t\2\2\u009d\u00a0\7)\2\2\u009e\u00a0\5\25"+
		"\13\2\u009f\u009b\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\24\3\2\2\2\u00a1\u00a2"+
		"\7)\2\2\u00a2\u00a3\7^\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\t\n\2\2\u00a5"+
		"\u00a6\7)\2\2\u00a6\26\3\2\2\2\u00a7\u00ab\7$\2\2\u00a8\u00aa\n\13\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7$\2\2\u00af"+
		"\30\3\2\2\2\u00b0\u00b4\5\7\4\2\u00b1\u00b3\5\t\5\2\u00b2\u00b1\3\2\2"+
		"\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\32"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bd\5\35\17\2\u00b8\u00bd\5\37\20"+
		"\2\u00b9\u00bd\5%\23\2\u00ba\u00bd\5\'\24\2\u00bb\u00bd\5!\21\2\u00bc"+
		"\u00b7\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bb\3\2\2\2\u00bd\34\3\2\2\2\u00be\u00c1\5I%\2\u00bf\u00c1"+
		"\5K&\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\36\3\2\2\2\u00c2"+
		"\u00c6\5M\'\2\u00c3\u00c6\5O(\2\u00c4\u00c6\7\'\2\2\u00c5\u00c2\3\2\2"+
		"\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6 \3\2\2\2\u00c7\u00ca"+
		"\5S*\2\u00c8\u00ca\5Q)\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca"+
		"\"\3\2\2\2\u00cb\u00d1\7?\2\2\u00cc\u00cd\7-\2\2\u00cd\u00d1\7?\2\2\u00ce"+
		"\u00cf\7/\2\2\u00cf\u00d1\7?\2\2\u00d0\u00cb\3\2\2\2\u00d0\u00cc\3\2\2"+
		"\2\u00d0\u00ce\3\2\2\2\u00d1$\3\2\2\2\u00d2\u00d8\t\f\2\2\u00d3\u00d4"+
		"\7>\2\2\u00d4\u00d8\7?\2\2\u00d5\u00d6\7@\2\2\u00d6\u00d8\7?\2\2\u00d7"+
		"\u00d2\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8&\3\2\2\2"+
		"\u00d9\u00da\7?\2\2\u00da\u00de\7?\2\2\u00db\u00dc\7#\2\2\u00dc\u00de"+
		"\7?\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00db\3\2\2\2\u00de(\3\2\2\2\u00df\u00e2"+
		"\5E#\2\u00e0\u00e2\5G$\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"*\3\2\2\2\u00e3\u00e4\7\62\2\2\u00e4\u00e5\7Z\2\2\u00e5\u00e7\3\2\2\2"+
		"\u00e6\u00e8\5\13\6\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea,\3\2\2\2\u00eb\u00ef\5\17\b\2\u00ec"+
		"\u00ef\5\23\n\2\u00ed\u00ef\5)\25\2\u00ee\u00eb\3\2\2\2\u00ee\u00ec\3"+
		"\2\2\2\u00ee\u00ed\3\2\2\2\u00ef.\3\2\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2"+
		"\7p\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b\30\3\2\u00f5"+
		"\60\3\2\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7q\2\2\u00f9"+
		"\u00fa\7n\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7c\2\2\u00fc\u00fd\7p\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b\31\4\2\u00ff\62\3\2\2\2\u0100\u0101"+
		"\7e\2\2\u0101\u0102\7c\2\2\u0102\u0103\7n\2\2\u0103\u0104\7n\2\2\u0104"+
		"\u0105\7q\2\2\u0105\u0106\7w\2\2\u0106\u0107\7v\2\2\u0107\64\3\2\2\2\u0108"+
		"\u0109\7x\2\2\u0109\u010a\7q\2\2\u010a\u010b\7k\2\2\u010b\u010c\7f\2\2"+
		"\u010c\66\3\2\2\2\u010d\u010e\7k\2\2\u010e\u010f\7h\2\2\u010f8\3\2\2\2"+
		"\u0110\u0111\7g\2\2\u0111\u0112\7n\2\2\u0112\u0113\7u\2\2\u0113\u0114"+
		"\7g\2\2\u0114:\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7q\2\2\u0117\u0118"+
		"\7t\2\2\u0118<\3\2\2\2\u0119\u011a\7y\2\2\u011a\u011b\7j\2\2\u011b\u011c"+
		"\7k\2\2\u011c\u011d\7n\2\2\u011d\u011e\7g\2\2\u011e>\3\2\2\2\u011f\u0120"+
		"\7t\2\2\u0120\u0121\7g\2\2\u0121\u0122\7v\2\2\u0122\u0123\7w\2\2\u0123"+
		"\u0124\7t\2\2\u0124\u0125\7p\2\2\u0125@\3\2\2\2\u0126\u0127\7d\2\2\u0127"+
		"\u0128\7t\2\2\u0128\u0129\7g\2\2\u0129\u012a\7c\2\2\u012a\u012b\7m\2\2"+
		"\u012bB\3\2\2\2\u012c\u012d\7e\2\2\u012d\u012e\7q\2\2\u012e\u012f\7p\2"+
		"\2\u012f\u0130\7v\2\2\u0130\u0131\7k\2\2\u0131\u0132\7p\2\2\u0132\u0133"+
		"\7w\2\2\u0133\u0134\7g\2\2\u0134D\3\2\2\2\u0135\u0136\7v\2\2\u0136\u0137"+
		"\7t\2\2\u0137\u0138\7w\2\2\u0138\u0139\7g\2\2\u0139F\3\2\2\2\u013a\u013b"+
		"\7h\2\2\u013b\u013c\7c\2\2\u013c\u013d\7n\2\2\u013d\u013e\7u\2\2\u013e"+
		"\u013f\7g\2\2\u013fH\3\2\2\2\u0140\u0141\7-\2\2\u0141J\3\2\2\2\u0142\u0143"+
		"\7/\2\2\u0143L\3\2\2\2\u0144\u0145\7,\2\2\u0145N\3\2\2\2\u0146\u0147\7"+
		"\61\2\2\u0147P\3\2\2\2\u0148\u0149\7(\2\2\u0149\u014a\7(\2\2\u014aR\3"+
		"\2\2\2\u014b\u014c\7~\2\2\u014c\u014d\7~\2\2\u014dT\3\2\2\2\u014e\u014f"+
		"\7=\2\2\u014fV\3\2\2\2\u0150\u0151\7.\2\2\u0151X\3\2\2\2\u0152\u0153\t"+
		"\r\2\2\u0153\u0154\b-\5\2\u0154Z\3\2\2\2\32\2akpz~\u0083\u0087\u0090\u0097"+
		"\u0099\u009f\u00ab\u00b4\u00bc\u00c0\u00c5\u00c9\u00d0\u00d7\u00dd\u00e1"+
		"\u00e9\u00ee";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
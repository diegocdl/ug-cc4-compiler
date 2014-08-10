// Generated from parser\DecafParser.g by ANTLR 4.4

  package compiler.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_WHILE=23, KW_RETURN=24, HEX_ERROR=3, PUNTO_COMA=43, STRING_ERROR=9, 
		KW_TRUE=27, KW_VOID=19, CHAR_ERROR=7, ASIG_OP=10, KW_INT=16, COMMENT=1, 
		MINUS=38, MULT=39, WHITESPACE=2, KW_BREAK=25, INT_LITERAL=4, KW_IF=20, 
		CORCHETE_D=34, ID=30, CORCHETE_I=33, KW_BOOL=17, COMA=44, PARENTESIS_D=32, 
		KW_CLASS=29, OR=42, COND_OP=12, EQ_OP=14, KW_FOR=22, KW_ELSE=21, KW_CONTINUE=26, 
		NEGATION=11, KW_CALLOUT=18, PARENTESIS_I=31, BOOL_LITERAL=15, DIV=40, 
		LLAVE_D=36, AND=41, STRING_LITERAL=8, REL_OP=13, CHAR_LITERAL=6, KW_FALSE=28, 
		LLAVE_I=35, DECIMAL_LITERAL=5, PLUS=37;
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "WHITESPACE", "HEX_ERROR", "INT_LITERAL", "DECIMAL_LITERAL", 
		"CHAR_LITERAL", "CHAR_ERROR", "STRING_LITERAL", "STRING_ERROR", "ASIG_OP", 
		"'!'", "COND_OP", "REL_OP", "EQ_OP", "BOOL_LITERAL", "'int'", "'boolean'", 
		"'callout'", "'void'", "'if'", "'else'", "'for'", "'while'", "'return'", 
		"'break'", "'continue'", "'true'", "'false'", "'class'", "ID", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'&&'", 
		"'||'", "';'", "','"
	};
	public static final int
		RULE_start = 0, RULE_statement = 1, RULE_expr = 2, RULE_literal = 3, RULE_block = 4, 
		RULE_block_error = 5, RULE_bin_op = 6, RULE_addOp = 7, RULE_mulOp = 8, 
		RULE_method_decl = 9, RULE_field_decl = 10, RULE_type = 11, RULE_method_call = 12, 
		RULE_callout_arg = 13, RULE_callout_decl = 14, RULE_class_decl = 15, RULE_program = 16, 
		RULE_location = 17, RULE_method_name = 18;
	public static final String[] ruleNames = {
		"start", "statement", "expr", "literal", "block", "block_error", "bin_op", 
		"addOp", "mulOp", "method_decl", "field_decl", "type", "method_call", 
		"callout_arg", "callout_decl", "class_decl", "program", "location", "method_name"
	};

	@Override
	public String getGrammarFileName() { return "DecafParser.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DecafParser.EOF, 0); }
		public Class_declContext class_decl() {
			return getRuleContext(Class_declContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); class_decl();
			setState(39); match(EOF);
			System.out.println("start");
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode ASIG_OP() { return getToken(DecafParser.ASIG_OP, 0); }
		public TerminalNode KW_BREAK() { return getToken(DecafParser.KW_BREAK, 0); }
		public TerminalNode KW_FOR() { return getToken(DecafParser.KW_FOR, 0); }
		public TerminalNode KW_WHILE() { return getToken(DecafParser.KW_WHILE, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(DecafParser.PUNTO_COMA, 0); }
		public TerminalNode KW_ELSE() { return getToken(DecafParser.KW_ELSE, 0); }
		public TerminalNode COMA() { return getToken(DecafParser.COMA, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode PARENTESIS_I() { return getToken(DecafParser.PARENTESIS_I, 0); }
		public TerminalNode KW_CONTINUE() { return getToken(DecafParser.KW_CONTINUE, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public TerminalNode PARENTESIS_D() { return getToken(DecafParser.PARENTESIS_D, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode KW_RETURN() { return getToken(DecafParser.KW_RETURN, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public TerminalNode KW_IF() { return getToken(DecafParser.KW_IF, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42); location();
				setState(43); match(ASIG_OP);
				setState(44); expr(0);
				setState(45); match(PUNTO_COMA);
				System.out.println("asginacion");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); method_call();
				setState(49); match(PUNTO_COMA);
				System.out.println("llamado a metodo");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52); match(KW_IF);
				setState(53); match(PARENTESIS_I);
				setState(54); expr(0);
				setState(55); match(PARENTESIS_D);
				setState(56); block();
				setState(59);
				_la = _input.LA(1);
				if (_la==KW_ELSE) {
					{
					setState(57); match(KW_ELSE);
					setState(58); block();
					}
				}

				 System.out.println("if");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63); match(KW_FOR);
				setState(64); match(PARENTESIS_I);
				setState(65); match(ID);
				setState(66); match(ASIG_OP);
				setState(67); expr(0);
				setState(68); match(COMA);
				setState(69); expr(0);
				setState(70); match(PARENTESIS_D);
				setState(71); block();
				System.out.println("for");
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74); match(KW_WHILE);
				setState(75); match(PARENTESIS_I);
				setState(76); expr(0);
				setState(77); match(PARENTESIS_D);
				setState(78); block();
				System.out.println("while");
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(81); match(KW_RETURN);
				setState(83);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << CHAR_LITERAL) | (1L << NEGATION) | (1L << BOOL_LITERAL) | (1L << KW_CALLOUT) | (1L << ID) | (1L << PARENTESIS_I) | (1L << MINUS))) != 0)) {
					{
					setState(82); expr(0);
					}
				}

				setState(85); match(PUNTO_COMA);
				System.out.println("return");
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(87); match(KW_BREAK);
				setState(88); match(PUNTO_COMA);
				System.out.println("break");
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(90); match(KW_CONTINUE);
				setState(91); match(PUNTO_COMA);
				System.out.println("statement");
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

	public static class ExprContext extends ParserRuleContext {
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode PARENTESIS_I() { return getToken(DecafParser.PARENTESIS_I, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PARENTESIS_D() { return getToken(DecafParser.PARENTESIS_D, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode NEGATION() { return getToken(DecafParser.NEGATION, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitExpr(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(96); match(MINUS);
				setState(97); expr(3);
				System.out.println("menos expr");
				}
				break;
			case 2:
				{
				setState(100); match(NEGATION);
				setState(101); expr(2);
				 System.out.println("negacion de expr");
				}
				break;
			case 3:
				{
				setState(104); location();
				System.out.println("location");
				}
				break;
			case 4:
				{
				setState(107); method_call();
				System.out.println("llamado a metodo");
				}
				break;
			case 5:
				{
				setState(110); literal();
				 System.out.println("literal");
				}
				break;
			case 6:
				{
				setState(113); match(PARENTESIS_I);
				setState(114); expr(0);
				setState(115); match(PARENTESIS_D);
				System.out.println("(expr)");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(120);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(121); bin_op();
					setState(122); expr(5);
					System.out.println("operacion");
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(DecafParser.BOOL_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(DecafParser.INT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(DecafParser.CHAR_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << CHAR_LITERAL) | (1L << BOOL_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			System.out.println("literal");
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
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
		}
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode LLAVE_I() { return getToken(DecafParser.LLAVE_I, 0); }
		public TerminalNode LLAVE_D() { return getToken(DecafParser.LLAVE_D, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(LLAVE_I);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_INT) | (1L << KW_BOOL) | (1L << KW_CALLOUT) | (1L << KW_IF) | (1L << KW_FOR) | (1L << KW_WHILE) | (1L << KW_RETURN) | (1L << KW_BREAK) | (1L << KW_CONTINUE) | (1L << ID))) != 0)) {
				{
				setState(136);
				switch (_input.LA(1)) {
				case KW_INT:
				case KW_BOOL:
					{
					setState(134); field_decl();
					}
					break;
				case KW_CALLOUT:
				case KW_IF:
				case KW_FOR:
				case KW_WHILE:
				case KW_RETURN:
				case KW_BREAK:
				case KW_CONTINUE:
				case ID:
					{
					setState(135); statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141); match(LLAVE_D);
			System.out.println("block");
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

	public static class Block_errorContext extends ParserRuleContext {
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
		}
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode LLAVE_I() { return getToken(DecafParser.LLAVE_I, 0); }
		public Block_errorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBlock_error(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBlock_error(this);
		}
	}

	public final Block_errorContext block_error() throws RecognitionException {
		Block_errorContext _localctx = new Block_errorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block_error);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(LLAVE_I);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_INT || _la==KW_BOOL) {
				{
				{
				setState(145); field_decl();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_CALLOUT) | (1L << KW_IF) | (1L << KW_FOR) | (1L << KW_WHILE) | (1L << KW_RETURN) | (1L << KW_BREAK) | (1L << KW_CONTINUE) | (1L << ID))) != 0)) {
				{
				{
				setState(151); statement();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("falto cerrar llave");
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

	public static class Bin_opContext extends ParserRuleContext {
		public TerminalNode REL_OP() { return getToken(DecafParser.REL_OP, 0); }
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public TerminalNode COND_OP() { return getToken(DecafParser.COND_OP, 0); }
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public TerminalNode EQ_OP() { return getToken(DecafParser.EQ_OP, 0); }
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBin_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBin_op(this);
		}
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bin_op);
		try {
			setState(165);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(159); addOp();
				}
				break;
			case MULT:
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(160); mulOp();
				}
				break;
			case REL_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(161); match(REL_OP);
				}
				break;
			case EQ_OP:
				enterOuterAlt(_localctx, 4);
				{
				setState(162); match(EQ_OP);
				}
				break;
			case COND_OP:
				enterOuterAlt(_localctx, 5);
				{
				setState(163); match(COND_OP);
				System.out.println("bin op");
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

	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(DecafParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitAddOp(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(DecafParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(DecafParser.DIV, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMulOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMulOp(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ( !(_la==MULT || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Method_declContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public TerminalNode PARENTESIS_I() { return getToken(DecafParser.PARENTESIS_I, 0); }
		public TerminalNode PARENTESIS_D() { return getToken(DecafParser.PARENTESIS_D, 0); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode KW_VOID() { return getToken(DecafParser.KW_VOID, 0); }
		public TerminalNode COMA(int i) {
			return getToken(DecafParser.COMA, i);
		}
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(DecafParser.COMA); }
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_decl(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_method_decl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			switch (_input.LA(1)) {
			case KW_INT:
			case KW_BOOL:
				{
				setState(171); type();
				}
				break;
			case KW_VOID:
				{
				setState(172); match(KW_VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(175); match(ID);
			setState(176); match(PARENTESIS_I);
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(180);
				_la = _input.LA(1);
				if (_la==KW_INT || _la==KW_BOOL) {
					{
					setState(177); type();
					setState(178); match(ID);
					}
				}

				}
				break;
			case 2:
				{
				setState(186); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(182); type();
						setState(183); match(ID);
						setState(184); match(COMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(188); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(190); type();
				setState(191); match(ID);
				}
				}
				break;
			}
			setState(195); match(PARENTESIS_D);
			setState(196); block();
			System.out.println("declaracion de metodo");
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

	public static class Field_declContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public List<TerminalNode> CORCHETE_I() { return getTokens(DecafParser.CORCHETE_I); }
		public TerminalNode INT_LITERAL(int i) {
			return getToken(DecafParser.INT_LITERAL, i);
		}
		public List<TerminalNode> CORCHETE_D() { return getTokens(DecafParser.CORCHETE_D); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public TerminalNode CORCHETE_D(int i) {
			return getToken(DecafParser.CORCHETE_D, i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(DecafParser.PUNTO_COMA, 0); }
		public TerminalNode CORCHETE_I(int i) {
			return getToken(DecafParser.CORCHETE_I, i);
		}
		public List<TerminalNode> INT_LITERAL() { return getTokens(DecafParser.INT_LITERAL); }
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterField_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitField_decl(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_field_decl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199); type();
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(205);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(200); match(ID);
					}
					break;
				case 2:
					{
					setState(201); match(ID);
					setState(202); match(CORCHETE_I);
					setState(203); match(INT_LITERAL);
					setState(204); match(CORCHETE_D);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(212); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(212);
						switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
						case 1:
							{
							setState(207); match(ID);
							}
							break;
						case 2:
							{
							setState(208); match(ID);
							setState(209); match(CORCHETE_I);
							setState(210); match(INT_LITERAL);
							setState(211); match(CORCHETE_D);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(214); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(221);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(216); match(ID);
					}
					break;
				case 2:
					{
					setState(217); match(ID);
					setState(218); match(CORCHETE_I);
					setState(219); match(INT_LITERAL);
					setState(220); match(CORCHETE_D);
					}
					break;
				}
				}
				break;
			}
			setState(225); match(PUNTO_COMA);
			System.out.println("declaracion de variable");
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode KW_BOOL() { return getToken(DecafParser.KW_BOOL, 0); }
		public TerminalNode KW_INT() { return getToken(DecafParser.KW_INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !(_la==KW_INT || _la==KW_BOOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Method_callContext extends ParserRuleContext {
		public TerminalNode PARENTESIS_I() { return getToken(DecafParser.PARENTESIS_I, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode PARENTESIS_D() { return getToken(DecafParser.PARENTESIS_D, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(DecafParser.COMA, i);
		}
		public Callout_argContext callout_arg(int i) {
			return getRuleContext(Callout_argContext.class,i);
		}
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public List<Callout_argContext> callout_arg() {
			return getRuleContexts(Callout_argContext.class);
		}
		public TerminalNode KW_CALLOUT() { return getToken(DecafParser.KW_CALLOUT, 0); }
		public List<TerminalNode> COMA() { return getTokens(DecafParser.COMA); }
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_call(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_method_call);
		int _la;
		try {
			int _alt;
			setState(270);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(230); method_name();
					}
					break;
				case KW_CALLOUT:
					{
					setState(231); match(KW_CALLOUT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(234); match(PARENTESIS_I);
				setState(247);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(236);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << CHAR_LITERAL) | (1L << NEGATION) | (1L << BOOL_LITERAL) | (1L << KW_CALLOUT) | (1L << ID) | (1L << PARENTESIS_I) | (1L << MINUS))) != 0)) {
						{
						setState(235); expr(0);
						}
					}

					}
					break;
				case 2:
					{
					setState(241); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(238); expr(0);
							setState(239); match(COMA);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(243); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					{
					setState(245); expr(0);
					}
					}
					break;
				}
				setState(249); match(PARENTESIS_D);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(250); method_name();
					}
					break;
				case KW_CALLOUT:
					{
					setState(251); match(KW_CALLOUT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(254); match(PARENTESIS_I);
				setState(267);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(256);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << CHAR_LITERAL) | (1L << STRING_LITERAL) | (1L << NEGATION) | (1L << BOOL_LITERAL) | (1L << KW_CALLOUT) | (1L << ID) | (1L << PARENTESIS_I) | (1L << MINUS))) != 0)) {
						{
						setState(255); callout_arg();
						}
					}

					}
					break;
				case 2:
					{
					setState(261); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(258); callout_arg();
							setState(259); match(COMA);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(263); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					{
					setState(265); callout_arg();
					}
					}
					break;
				}
				setState(269); match(PARENTESIS_D);
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

	public static class Callout_argContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public Callout_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCallout_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCallout_arg(this);
		}
	}

	public final Callout_argContext callout_arg() throws RecognitionException {
		Callout_argContext _localctx = new Callout_argContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callout_arg);
		try {
			setState(274);
			switch (_input.LA(1)) {
			case INT_LITERAL:
			case CHAR_LITERAL:
			case NEGATION:
			case BOOL_LITERAL:
			case KW_CALLOUT:
			case ID:
			case PARENTESIS_I:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(272); expr(0);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(273); match(STRING_LITERAL);
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

	public static class Callout_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(DecafParser.PUNTO_COMA, 0); }
		public TerminalNode KW_CALLOUT() { return getToken(DecafParser.KW_CALLOUT, 0); }
		public Callout_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCallout_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCallout_decl(this);
		}
	}

	public final Callout_declContext callout_decl() throws RecognitionException {
		Callout_declContext _localctx = new Callout_declContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callout_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); match(KW_CALLOUT);
			setState(277); match(ID);
			setState(278); match(PUNTO_COMA);
			System.out.println("callout_decl");
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

	public static class Class_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode KW_CLASS() { return getToken(DecafParser.KW_CLASS, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode LLAVE_I() { return getToken(DecafParser.LLAVE_I, 0); }
		public TerminalNode LLAVE_D() { return getToken(DecafParser.LLAVE_D, 0); }
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterClass_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitClass_decl(this);
		}
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_class_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(KW_CLASS);
			setState(282); match(ID);
			setState(283); match(LLAVE_I);
			setState(284); program();
			setState(285); match(LLAVE_D);
			System.out.println("declaracion de clase");
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

	public static class ProgramContext extends ParserRuleContext {
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public List<Callout_declContext> callout_decl() {
			return getRuleContexts(Callout_declContext.class);
		}
		public Callout_declContext callout_decl(int i) {
			return getRuleContext(Callout_declContext.class,i);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(291);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(288); callout_decl();
					}
					break;
				case 2:
					{
					setState(289); field_decl();
					}
					break;
				case 3:
					{
					setState(290); method_decl();
					}
					break;
				}
				}
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_INT) | (1L << KW_BOOL) | (1L << KW_CALLOUT) | (1L << KW_VOID))) != 0) );
			System.out.println("program");
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

	public static class LocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode CORCHETE_I() { return getToken(DecafParser.CORCHETE_I, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CORCHETE_D() { return getToken(DecafParser.CORCHETE_D, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLocation(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_location);
		try {
			setState(303);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(298); match(ID);
				setState(299); match(CORCHETE_I);
				setState(300); expr(0);
				setState(301); match(CORCHETE_D);
				}
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

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_name(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(ID);
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
		case 2: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u0136\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3V\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"y\n\4\3\4\3\4\3\4\3\4\3\4\7\4\u0080\n\4\f\4\16\4\u0083\13\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\7\6\u008b\n\6\f\6\16\6\u008e\13\6\3\6\3\6\3\6\3\7\3\7\7"+
		"\7\u0095\n\7\f\7\16\7\u0098\13\7\3\7\7\7\u009b\n\7\f\7\16\7\u009e\13\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a8\n\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\5\13\u00b0\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b7\n\13\3\13\3\13"+
		"\3\13\3\13\6\13\u00bd\n\13\r\13\16\13\u00be\3\13\3\13\3\13\5\13\u00c4"+
		"\n\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d0\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\6\f\u00d7\n\f\r\f\16\f\u00d8\3\f\3\f\3\f\3\f\3\f\5\f\u00e0"+
		"\n\f\5\f\u00e2\n\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\5\16\u00eb\n\16\3\16"+
		"\3\16\5\16\u00ef\n\16\3\16\3\16\3\16\6\16\u00f4\n\16\r\16\16\16\u00f5"+
		"\3\16\3\16\5\16\u00fa\n\16\3\16\3\16\3\16\5\16\u00ff\n\16\3\16\3\16\5"+
		"\16\u0103\n\16\3\16\3\16\3\16\6\16\u0108\n\16\r\16\16\16\u0109\3\16\3"+
		"\16\5\16\u010e\n\16\3\16\5\16\u0111\n\16\3\17\3\17\5\17\u0115\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\6\22\u0126\n\22\r\22\16\22\u0127\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u0132\n\23\3\24\3\24\3\24\2\3\6\25\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&\2\6\5\2\6\6\b\b\21\21\3\2\'(\3\2)*\3\2\22\23\u0151\2"+
		"(\3\2\2\2\4_\3\2\2\2\6x\3\2\2\2\b\u0084\3\2\2\2\n\u0087\3\2\2\2\f\u0092"+
		"\3\2\2\2\16\u00a7\3\2\2\2\20\u00a9\3\2\2\2\22\u00ab\3\2\2\2\24\u00af\3"+
		"\2\2\2\26\u00c9\3\2\2\2\30\u00e6\3\2\2\2\32\u0110\3\2\2\2\34\u0114\3\2"+
		"\2\2\36\u0116\3\2\2\2 \u011b\3\2\2\2\"\u0125\3\2\2\2$\u0131\3\2\2\2&\u0133"+
		"\3\2\2\2()\5 \21\2)*\7\2\2\3*+\b\2\1\2+\3\3\2\2\2,-\5$\23\2-.\7\f\2\2"+
		"./\5\6\4\2/\60\7-\2\2\60\61\b\3\1\2\61`\3\2\2\2\62\63\5\32\16\2\63\64"+
		"\7-\2\2\64\65\b\3\1\2\65`\3\2\2\2\66\67\7\26\2\2\678\7!\2\289\5\6\4\2"+
		"9:\7\"\2\2:=\5\n\6\2;<\7\27\2\2<>\5\n\6\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2"+
		"\2?@\b\3\1\2@`\3\2\2\2AB\7\30\2\2BC\7!\2\2CD\7 \2\2DE\7\f\2\2EF\5\6\4"+
		"\2FG\7.\2\2GH\5\6\4\2HI\7\"\2\2IJ\5\n\6\2JK\b\3\1\2K`\3\2\2\2LM\7\31\2"+
		"\2MN\7!\2\2NO\5\6\4\2OP\7\"\2\2PQ\5\n\6\2QR\b\3\1\2R`\3\2\2\2SU\7\32\2"+
		"\2TV\5\6\4\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7-\2\2X`\b\3\1\2YZ\7\33\2"+
		"\2Z[\7-\2\2[`\b\3\1\2\\]\7\34\2\2]^\7-\2\2^`\b\3\1\2_,\3\2\2\2_\62\3\2"+
		"\2\2_\66\3\2\2\2_A\3\2\2\2_L\3\2\2\2_S\3\2\2\2_Y\3\2\2\2_\\\3\2\2\2`\5"+
		"\3\2\2\2ab\b\4\1\2bc\7(\2\2cd\5\6\4\5de\b\4\1\2ey\3\2\2\2fg\7\r\2\2gh"+
		"\5\6\4\4hi\b\4\1\2iy\3\2\2\2jk\5$\23\2kl\b\4\1\2ly\3\2\2\2mn\5\32\16\2"+
		"no\b\4\1\2oy\3\2\2\2pq\5\b\5\2qr\b\4\1\2ry\3\2\2\2st\7!\2\2tu\5\6\4\2"+
		"uv\7\"\2\2vw\b\4\1\2wy\3\2\2\2xa\3\2\2\2xf\3\2\2\2xj\3\2\2\2xm\3\2\2\2"+
		"xp\3\2\2\2xs\3\2\2\2y\u0081\3\2\2\2z{\f\6\2\2{|\5\16\b\2|}\5\6\4\7}~\b"+
		"\4\1\2~\u0080\3\2\2\2\177z\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\7\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\t\2\2\2\u0085\u0086\b\5\1\2\u0086\t\3\2\2\2\u0087\u008c\7%\2\2\u0088"+
		"\u008b\5\26\f\2\u0089\u008b\5\4\3\2\u008a\u0088\3\2\2\2\u008a\u0089\3"+
		"\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7&\2\2\u0090\u0091\b\6"+
		"\1\2\u0091\13\3\2\2\2\u0092\u0096\7%\2\2\u0093\u0095\5\26\f\2\u0094\u0093"+
		"\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u009c\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\5\4\3\2\u009a\u0099\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\b\7\1\2\u00a0\r\3\2\2\2"+
		"\u00a1\u00a8\5\20\t\2\u00a2\u00a8\5\22\n\2\u00a3\u00a8\7\17\2\2\u00a4"+
		"\u00a8\7\20\2\2\u00a5\u00a6\7\16\2\2\u00a6\u00a8\b\b\1\2\u00a7\u00a1\3"+
		"\2\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\17\3\2\2\2\u00a9\u00aa\t\3\2\2\u00aa\21\3\2\2\2\u00ab"+
		"\u00ac\t\4\2\2\u00ac\23\3\2\2\2\u00ad\u00b0\5\30\r\2\u00ae\u00b0\7\25"+
		"\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\7 \2\2\u00b2\u00c3\7!\2\2\u00b3\u00b4\5\30\r\2\u00b4\u00b5\7 \2"+
		"\2\u00b5\u00b7\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00c4"+
		"\3\2\2\2\u00b8\u00b9\5\30\r\2\u00b9\u00ba\7 \2\2\u00ba\u00bb\7.\2\2\u00bb"+
		"\u00bd\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\5\30\r\2\u00c1"+
		"\u00c2\7 \2\2\u00c2\u00c4\3\2\2\2\u00c3\u00b6\3\2\2\2\u00c3\u00bc\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00c7\5\n\6\2\u00c7"+
		"\u00c8\b\13\1\2\u00c8\25\3\2\2\2\u00c9\u00e1\5\30\r\2\u00ca\u00d0\7 \2"+
		"\2\u00cb\u00cc\7 \2\2\u00cc\u00cd\7#\2\2\u00cd\u00ce\7\6\2\2\u00ce\u00d0"+
		"\7$\2\2\u00cf\u00ca\3\2\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00e2\3\2\2\2\u00d1\u00d7\7 \2\2\u00d2\u00d3\7 \2\2\u00d3\u00d4\7#\2"+
		"\2\u00d4\u00d5\7\6\2\2\u00d5\u00d7\7$\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d2"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00df\3\2\2\2\u00da\u00e0\7 \2\2\u00db\u00dc\7 \2\2\u00dc\u00dd\7#\2"+
		"\2\u00dd\u00de\7\6\2\2\u00de\u00e0\7$\2\2\u00df\u00da\3\2\2\2\u00df\u00db"+
		"\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00cf\3\2\2\2\u00e1\u00d6\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\7-\2\2\u00e4\u00e5\b\f\1\2\u00e5\27\3\2\2\2"+
		"\u00e6\u00e7\t\5\2\2\u00e7\31\3\2\2\2\u00e8\u00eb\5&\24\2\u00e9\u00eb"+
		"\7\24\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2"+
		"\u00ec\u00f9\7!\2\2\u00ed\u00ef\5\6\4\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00fa\3\2\2\2\u00f0\u00f1\5\6\4\2\u00f1\u00f2\7.\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\5\6\4\2\u00f8"+
		"\u00fa\3\2\2\2\u00f9\u00ee\3\2\2\2\u00f9\u00f3\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u0111\7\"\2\2\u00fc\u00ff\5&\24\2\u00fd\u00ff\7\24\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u010d\7!"+
		"\2\2\u0101\u0103\5\34\17\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u010e\3\2\2\2\u0104\u0105\5\34\17\2\u0105\u0106\7.\2\2\u0106\u0108\3"+
		"\2\2\2\u0107\u0104\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\5\34\17\2\u010c\u010e\3"+
		"\2\2\2\u010d\u0102\3\2\2\2\u010d\u0107\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0111\7\"\2\2\u0110\u00ea\3\2\2\2\u0110\u00fe\3\2\2\2\u0111\33\3\2\2"+
		"\2\u0112\u0115\5\6\4\2\u0113\u0115\7\n\2\2\u0114\u0112\3\2\2\2\u0114\u0113"+
		"\3\2\2\2\u0115\35\3\2\2\2\u0116\u0117\7\24\2\2\u0117\u0118\7 \2\2\u0118"+
		"\u0119\7-\2\2\u0119\u011a\b\20\1\2\u011a\37\3\2\2\2\u011b\u011c\7\37\2"+
		"\2\u011c\u011d\7 \2\2\u011d\u011e\7%\2\2\u011e\u011f\5\"\22\2\u011f\u0120"+
		"\7&\2\2\u0120\u0121\b\21\1\2\u0121!\3\2\2\2\u0122\u0126\5\36\20\2\u0123"+
		"\u0126\5\26\f\2\u0124\u0126\5\24\13\2\u0125\u0122\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b\22\1\2\u012a#\3\2\2\2"+
		"\u012b\u0132\7 \2\2\u012c\u012d\7 \2\2\u012d\u012e\7#\2\2\u012e\u012f"+
		"\5\6\4\2\u012f\u0130\7$\2\2\u0130\u0132\3\2\2\2\u0131\u012b\3\2\2\2\u0131"+
		"\u012c\3\2\2\2\u0132%\3\2\2\2\u0133\u0134\7 \2\2\u0134\'\3\2\2\2\"=U_"+
		"x\u0081\u008a\u008c\u0096\u009c\u00a7\u00af\u00b6\u00be\u00c3\u00cf\u00d6"+
		"\u00d8\u00df\u00e1\u00ea\u00ee\u00f5\u00f9\u00fe\u0102\u0109\u010d\u0110"+
		"\u0114\u0125\u0127\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
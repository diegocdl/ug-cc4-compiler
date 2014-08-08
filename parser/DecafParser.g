parser grammar DecafParser;

options {
    tokenVocab=DecafLexer;
}

@parser::header{
  package compiler.parser;
}

ADD_ARITH_OP	: PLUS | MINUS;
MULT_ARITH_OP	: MULT | DIV | '%';
COND_OP			: OR | AND;

// expresiones
STATEMENT		: LOCATION ASIG_OP EXPR PUNTO_COMA
				| METHOD_CALL PUNTO_COMA
				| KW_IF '(' EXPR ')' BLOCK (KW_ELSE BLOCK)?
				| KW_FOR '(' ID '=' EXPR COMA EXPR ')' BLOCK
				| KW_WHILE '(' EXPR ')' BLOCK
				| KW_RETURN (EXPR)? PUNTO_COMA
				| KW_BREAK PUNTO_COMA
				| KW_CONTINUE PUNTO_COMA;

EXPR 			: LOCATION
				| METHOD_CALL
				| LITERAL
				| '-' EXPR
				| '!' EXPR
				| '(' EXPR ')';

BLOCK			: '{' FIELD_DECL* STATEMENT* '}';

METHOD_DECL		: (TYPE | KW_VOID) ID '(' ( (TYPE ID)? | (TYPE ID COMA )+(TYPE ID) )? ')' BLOCK;
FIELD_DECL		: TYPE ( (ID | ID '[' INT_LITERAL']')? | (ID | ID '[' INT_LITERAL']')+(ID | ID '[' INT_LITERAL']')) PUNTO_COMA;   

TYPE			: KW_INT | KW_BOOL;
METHOD_CALL		: METHOD_NAME '(' ( (EXPR)? | (EXPR COMA )+(EXPR) ) ')'
				| METHOD_NAME '(' ( (CALLOUT_ARG)? | (CALLOUT_ARG COMA )+(CALLOUT_ARG) ) ')';
CALLOUT_ARG		: EXPR | STRING_LITERAL;

CALLOUT_DECL	: KW_CALLOUT ID PUNTO_COMA;

PROGRAM			: (CALLOUT_DECL* FIELD_DECL* METHOD_DECL*)WS ;
LOCATION		: ID | (ID '[' EXPR ']');
METHOD_NAME		: ID;


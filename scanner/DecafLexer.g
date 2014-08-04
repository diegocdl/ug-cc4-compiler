lexer grammar DecafLexer;

@header {
	package compiler.scanner;
}


COMMENT 		: ('//' ~('\n')* WHITESPACE | '/*' ~('\n')* '*/'){skip();};
// numeros
DIGIT			: [0-9];
ALPHA			: [a-zA-Z];
ALPHA_NUM		: DIGIT | ALPHA;
HEX_DIGIT 		: DIGIT | [a-zA-Z];
DECIMAL_LITERAL	: DIGIT+;
INT_LITERAL		: DECIMAL_LITERAL | HEX_LITERAL;

// Char y String
CHAR_ERROR		: ('\'' ('\'') '\'' | '\'' ~('\'')+ | '\'\\' ~( '\'' | '\"' | '\\' | 'n' | 'r' | 't' | 'b' | 'f' | 'v' | '0' ) ('\'')?); 
CHAR_LITERAL	: '\'' ~('\'') '\'' | ESCAPE_CHAR;
ESCAPE_CHAR		: '\'\\' ( '\'' | '\"' | '\\' | 'n' | 'r' | 't' | 'b' | 'f' | 'v' | '0' )'\''; 
STRING_LITERAL 	: '"'~('"')*'"';
ID				: ALPHA(ALPHA_NUM*);

// Operaciones 
BIN_OP			: ADD_ARITH_OP | MULT_ARITH_OP | REL_OP | EQ_OP | COND_OP;
ADD_ARITH_OP	: PLUS | MINUS;
MULT_ARITH_OP	: MULT | DIV | '%';
COND_OP			: OR | AND;
ASIG_OP			: '=' | '+=' | '-=';
REL_OP			: '<' | '>' | '<=' | '>=';
EQ_OP 			: '==' | '!=';
BOOL_LITERAL	: KW_TRUE | KW_FALSE;
HEX_LITERAL		: '0X'(HEX_DIGIT+);
LITERAL 		: INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL;

// palabras reservadas
KW_INT			: 'int' {System.out.println("Palabra reservada int");}; 
KW_BOOL			: 'boolean'{System.out.println("Palabra reservada boolean");};
KW_CALLOUT		: 'callout';
KW_VOID			: 'void';
KW_IF			: 'if';
KW_ELSE 		: 'else';
KW_FOR			: 'for';
KW_WHILE		: 'while';
KW_RETURN		: 'return';
KW_BREAK		: 'break';
KW_CONTINUE		: 'continue';
KW_TRUE			: 'true';
KW_FALSE		: 'false';

PLUS 			: '+';
MINUS 			: '-';
MULT			: '*';
DIV 			: '/';
AND 			: '&&';
OR 				: '||';
PUNTO_COMA		: ';';
COMA 			: ',';
WHITESPACE		: ('\n' | '\t' | ' ') {skip();};
lexer grammar DecafLexer;


@header {
	package compiler.scanner;
}


COMMENT 					: ('//' ~('\n')* WHITESPACE | '/*' ~('\n')* '*/'){skip();};
WHITESPACE					: ('\n' | '\t' | ' ' | '\r') {skip();};
// numeros
fragment DIGIT				: [0-9];
fragment ALPHA				: [a-zA-Z];
fragment ALPHA_NUM			: DIGIT | ALPHA;
fragment HEX_DIGIT		 	: DIGIT | [a-zA-Z];
fragment INT_LITERAL			: DECIMAL_LITERAL | HEX_LITERAL;


HEX_LITERAL					: '0x'(HEX_DIGIT)+;
HEX_ERROR					: '0x' ~([0-9] | [a-zA-Z])*;					
DECIMAL_LITERAL				: DIGIT+;

// Char y String
fragment ESCAPE_CHAR  	: '\'\\' ( '\'' | '\"' | '\\' | 'n' | 't' )'\'';
CHAR_LITERAL		  	: '\'' ~('\'' | '\\' | '\n' | '\"') '\'' 
						| ESCAPE_CHAR; // Literales de escape
CHAR_ERROR				: '\'' ('\'' | '\\' | '\n' | '\"') '\'' 
						| '\'\\' ~( '\'' | '\"' | '\\' | 'n' | 't' ) ('\'')?  
						| '\'' ~('\'')+ '\''
						| '\'' ~('\'')+ ; 
STRING_LITERAL 			: '"'~('"')*'"';

// Operaciones 
BIN_OP			: ADD_ARITH_OP | MULT_ARITH_OP | REL_OP | EQ_OP | COND_OP;
ADD_ARITH_OP	: PLUS | MINUS;
MULT_ARITH_OP	: MULT | DIV | '%';
COND_OP			: OR | AND;
ASIG_OP			: '=' | '+=' | '-=';
REL_OP			: '<' | '>' | '<=' | '>=';
EQ_OP 			: '==' | '!=';
BOOL_LITERAL	: KW_TRUE | KW_FALSE;
LITERAL 		: INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL;

// palabras reservadas
KW_INT			: 'int' { System.out.println("Palabra reservada int");}; 
KW_BOOL			: 'boolean'{ System.out.println("Palabra reservada boolean");};
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

ID						: (ALPHA | '_')(ALPHA_NUM | '_')*;
PLUS 			: '+';
MINUS 			: '-';
MULT			: '*';
DIV 			: '/';
AND 			: '&&';
OR 				: '||';
PUNTO_COMA		: ';';
COMA 			: ',';


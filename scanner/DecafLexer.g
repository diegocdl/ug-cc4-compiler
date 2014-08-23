lexer grammar DecafLexer;


@header {
	package compiler.scanner;
}


COMMENT 			: ('//' ~('\n')* WHITESPACE | '/*' ~('\n')* '*/'){skip();};
WHITESPACE			: ('\n' | '\t' | ' ' | '\r') {skip();};

// numeros
HEX_ERROR			: '0x' ~([0-9] | [a-zA-Z])*;					

INT_LITERAL			: DECIMAL_LITERAL | HEX_LITERAL ;
DECIMAL_LITERAL		: DIGIT+ {System.out.println("Int");};

// Char y String
CHAR_LITERAL	  	: '\'' ~('\'' | '\\' | '\n' | '\"') '\'' 
					| ESCAPE_CHAR; // Literales de escape
CHAR_ERROR			: '\'' ('\'' | '\\' | '\n' | '\"') '\'' 
					| '\'\\' ~( '\'' | '\"' | '\\' | 'n' | 't' ) ('\'')?  
					| '\'' ~('\'')+ '\''
					| '\'' ~('\'')+ ; 
STRING_LITERAL		: '"' ('\\''\"' | '\\''\'' | ~('"' | '\''))* '"';
STRING_ERROR		: '"' ('\\''\"' | '\\''\'' | ~('"' | '\''))* '\''?;

// Operaciones 
ASIG_OP				: EQUAL | '+=' | '-=';
NEGATION			: '!';
COND_OP				: OR | AND;
REL_OP				: '<' | '>' | '<=' | '>=';
EQ_OP 				: '==' | '!=';
BOOL_LITERAL		: KW_TRUE | KW_FALSE;


// palabras reservadas
KW_INT				: 'int'; 
KW_BOOL				: 'boolean';
KW_CALLOUT			: 'callout';
KW_VOID				: 'void';
KW_IF				: 'if';
KW_ELSE 			: 'else';
KW_FOR				: 'for';
KW_WHILE			: 'while';
KW_RETURN			: 'return';
KW_BREAK			: 'break';
KW_CONTINUE			: 'continue';
KW_TRUE				: 'true';
KW_FALSE			: 'false';
ID					: (ALPHA | '_')(ALPHA_NUM | '_')*;

PARENTESIS_I		: '(';
PARENTESIS_D		: ')';
CORCHETE_I			: '[';
CORCHETE_D			: ']';
LLAVE_I				: '{';
LLAVE_D				: '}';

PLUS 				: '+';
MINUS 				: '-';
MULT				: '*';
DIV					: '/';
AND					: '&&';
OR 					: '||';
PUNTO_COMA			: ';';
COMA				: ',';
fragment DIGIT		: [0-9];
fragment ALPHA		: [a-zA-Z];
fragment ALPHA_NUM	: DIGIT | ALPHA;
fragment HEX_DIGIT	: DIGIT | [a-zA-Z];
fragment ESCAPE_CHAR	: '\'\\' ( '\'' | '\"' | '\\' | 'n' | 't' )'\'';
fragment EQUAL		: '=';

fragment HEX_LITERAL	: '0x'(HEX_DIGIT)+;

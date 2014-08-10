parser grammar DecafParser;

options {
    tokenVocab=DecafLexer;
}

@parser::header{
  package compiler.parser;
}

// expresiones
start : program EOF{System.out.println("nada");};

statement		: location ASIG_OP expr PUNTO_COMA
				| method_call PUNTO_COMA
				| KW_IF PARENTESIS_I expr PARENTESIS_D block (KW_ELSE block)?
				| KW_FOR PARENTESIS_I ID EQUAL expr COMA expr PARENTESIS_D block
				| KW_WHILE PARENTESIS_I expr PARENTESIS_D block
				| KW_RETURN (expr)? PUNTO_COMA
				| KW_BREAK PUNTO_COMA
				| KW_CONTINUE PUNTO_COMA{System.out.println("statement");};

expr 			: location
				| method_call
				| LITERAL
				| expr bin_op expr
				| MINUS expr
				| NEGATION expr
				| PARENTESIS_I expr PARENTESIS_D{System.out.println("expr");};

block			: LLAVE_I field_decl* statement* LLAVE_D{System.out.println("block");};
block_error		: LLAVE_I field_decl* statement*{System.out.println("falto cerrar llave");};

bin_op			: ADD_ARITH_OP | MULT_ARITH_OP | REL_OP | EQ_OP | COND_OP {System.out.println("bin op");};

method_decl		: (type | KW_VOID) ID PARENTESIS_I ( (type ID)? | (type ID COMA )+(type ID) )? PARENTESIS_D block;
field_decl		: type ( (ID | ID CORCHETE_I INT_LITERAL CORCHETE_D)? | (ID | ID CORCHETE_I INT_LITERAL CORCHETE_D)+(ID | ID CORCHETE_I INT_LITERAL CORCHETE_D)) PUNTO_COMA;

type			: KW_INT | KW_BOOL;
method_call		: method_name PARENTESIS_I ( (expr)? | (expr COMA )+(expr) ) PARENTESIS_D
				| method_name PARENTESIS_I ( (callout_arg)? | (callout_arg COMA )+(callout_arg) ) PARENTESIS_D;
callout_arg		: expr | STRING_LITERAL;

callout_decl	: KW_CALLOUT ID PUNTO_COMA;

program			: (callout_decl* field_decl* method_decl*)WHITESPACE ;
location		: ID | (ID CORCHETE_I expr CORCHETE_D);
method_name		: ID;



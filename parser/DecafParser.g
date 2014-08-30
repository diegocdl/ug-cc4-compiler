parser grammar DecafParser;

options {
    tokenVocab=DecafLexer;
}

@parser::header{
  package compiler.parser;
}


start: 
	program EOF; 

statement: 
	  (statement_error
	| location ASIG_OP expr PUNTO_COMA 										
	| method_call PUNTO_COMA
	| KW_IF PARENTESIS_I expr PARENTESIS_D block (KW_ELSE block)? 			
	| KW_FOR PARENTESIS_I ID ASIG_OP expr COMA expr PARENTESIS_D block 		
	| KW_WHILE PARENTESIS_I expr PARENTESIS_D block 						
	| KW_RETURN (expr)? PUNTO_COMA 											
	| (KW_BREAK | KW_CONTINUE) PUNTO_COMA ) # hola
	  ;

			
expr:
	  location
	| method_call
	| literal
	| expr bin_op expr
	| MINUS expr
	| NEGATION expr
	| PARENTESIS_I expr PARENTESIS_D;

literal: 
	(INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL );

block:
	  (LLAVE_I (field_decl | statement)* LLAVE_D )
	| block_error;

bin_op: 
	(addOp | mulOp | REL_OP | EQ_OP | COND_OP) ;

method_decl:
	(type | KW_VOID) ID PARENTESIS_I ( (type ID) | (type ID COMA )+(type ID) )? PARENTESIS_D block
	| method_decl_error;	

field_decl:
	 type ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA 
	| field_decl_error;

keywords:
	  KW_INT
	| KW_BOOL
	| KW_CALLOUT
	| KW_VOID
	| KW_IF
	| KW_ELSE
	| KW_FOR
	| KW_WHILE
	| KW_RETURN
	| KW_BREAK
	| KW_CONTINUE
	| KW_TRUE
	| KW_FALSE;

type:
	KW_INT | KW_BOOL;

program: 
	callout_decl* field_decl* method_decl* 
	| program_error;

method_call:
	  method_call_error
	| 	(
			(method_name | KW_CALLOUT) PARENTESIS_I ( (expr)? | (expr COMA )+(expr) ) PARENTESIS_D
			| (method_name | KW_CALLOUT) PARENTESIS_I ( (callout_arg)? | (callout_arg COMA )+ (callout_arg) ) PARENTESIS_D
		); 
				
callout_arg:
	expr | STRING_LITERAL;

callout_decl:
	  callout_decl_error
	| KW_CALLOUT ID PUNTO_COMA;

method_decl_error:
	(type | KW_VOID) ID PARENTESIS_I ((type? ID COMA )* ID (type? ID COMA )*) PARENTESIS_D block 
	| ID PARENTESIS_I ( (type ID) | (type ID COMA )+(type ID) )? PARENTESIS_D block 
	| (type | KW_VOID) ID PARENTESIS_I ( (type ID) | (type ID COMA )+(type ID) )? PARENTESIS_D block_error;
	
block_error:
	LLAVE_I field_decl* statement* {notifyErrorListeners("falto cerrar llave en el bloque");};

method_call_error:
	(method_name | KW_CALLOUT) PARENTESIS_I (keywords|bin_op) PARENTESIS_D {notifyErrorListeners("Error en la llamada del metodo");}
	| INT_LITERAL PARENTESIS_I ( (expr)? | (expr COMA )+(expr) ) PARENTESIS_D {notifyErrorListeners("identificador invalido");};


location:
	  ID | (ID CORCHETE_I expr CORCHETE_D);

method_name:
	ID;

addOp:
	PLUS | MINUS;

mulOp:
	MULT | DIV;


field_decl_error: 
	type ( (ID | ID CORCHETE_I INT_LITERAL? CORCHETE_D)? | (ID COMA | ID CORCHETE_I INT_LITERAL? CORCHETE_D COMA)+(ID | ID CORCHETE_I INT_LITERAL? CORCHETE_D)) ASIG_OP literal PUNTO_COMA {notifyErrorListeners("No se puede inicializar");}
	| type ID? (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID? (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA {notifyErrorListeners("Error falta el identificador de la variable");}
	| type (ID | ID CORCHETE_I INT_LITERAL CORCHETE_D) ( COMA ID | COMA ID CORCHETE_I INT_LITERAL CORCHETE_D)* {notifyErrorListeners("Error falto ; de la declaracion de variable");}
	| type ID (CORCHETE_I .+? CORCHETE_D)? (COMA ID (CORCHETE_I .+? CORCHETE_D)? )* PUNTO_COMA {notifyErrorListeners("Error declaracion de arreglo");}
	| type ( (ID CORCHETE_I CORCHETE_D)? | (ID COMA | ID CORCHETE_I CORCHETE_D COMA)+(ID CORCHETE_I CORCHETE_D)) PUNTO_COMA {notifyErrorListeners("Falto el tamaño del arreglo");}
	| type keywords (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA keywords (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA {notifyErrorListeners("Error no se puede usar palabras reservadas");}
	| type ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA? ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA {notifyErrorListeners("Error falto una coma entre identificadores de variable");}
	| ~(KW_INT | KW_BOOL) ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA {notifyErrorListeners("Se debe indicar un tipo de dato valido");}
	;

program_error:
	callout_decl* method_decl field_decl {notifyErrorListeners("las declaraciones van primero");};
	
callout_decl_error: 
	KW_CALLOUT ID {notifyErrorListeners("falto ;");};
statement_error: 
	  if_error
	| while_error
	| for_error
	| location ASIG_OP expr 							{notifyErrorListeners("Error falto ;");}
	| location ASIG_OP expr (ASIG_OP expr)+ PUNTO_COMA 	{notifyErrorListeners("Error en la asignacion");}
	| KW_RETURN (expr)? 								{notifyErrorListeners("Error falto ;");}
	| KW_BREAK 											{notifyErrorListeners("Error falto ;");}
	| KW_CONTINUE 										{notifyErrorListeners("Error falto ;");}
	| method_call 										{notifyErrorListeners("Error falto ;");};

for_error: 
	  ID PARENTESIS_I? ID ASIG_OP expr COMA expr PARENTESIS_D? block 			{notifyErrorListeners("for invalido");}
	| KW_FOR PARENTESIS_I ID ASIG_OP expr COMA expr block 						{notifyErrorListeners("falto )");}
	| KW_FOR ID ASIG_OP expr COMA expr PARENTESIS_D block 						{notifyErrorListeners("falto (");}
	| KW_FOR ID ASIG_OP expr COMA expr (block|block_error) 						{notifyErrorListeners("faltan ()");}
	| KW_FOR PARENTESIS_I ASIG_OP expr COMA expr PARENTESIS_D block 			{notifyErrorListeners("falto el identificador");}
	| KW_FOR PARENTESIS_I ID ASIG_OP expr COMA expr PARENTESIS_D block_error	{notifyErrorListeners("error en el for");};
			
if_error:
	  KW_IF PARENTESIS_I PARENTESIS_D block (KW_ELSE block)? 			{ notifyErrorListeners("no hay condicion en el if");}
	| KW_IF PARENTESIS_I expr PARENTESIS_D (KW_ELSE block)? 			{ notifyErrorListeners("faltan las instrucciones");}
	| KW_IF expr PARENTESIS_D block (KW_ELSE block)? 					{ notifyErrorListeners("falto (");}
	| KW_IF PARENTESIS_I expr block (KW_ELSE block)? 					{ notifyErrorListeners("falto )");}
	| KW_IF expr (block|block_error) (KW_ELSE block)? 					{ notifyErrorListeners("faltan ()");}
	| KW_IF PARENTESIS_I expr PARENTESIS_D block_error KW_ELSE block 	{ notifyErrorListeners("error en el if");};

while_error:
	KW_WHILE PARENTESIS_I PARENTESIS_D block 		{notifyErrorListeners("falta la condicion del while");}
	| KW_WHILE expr PARENTESIS_D block 				{notifyErrorListeners("falto (");}
	| KW_WHILE PARENTESIS_I expr  block 			{notifyErrorListeners("falto )");}
	| KW_WHILE expr (block|block_error) 			{notifyErrorListeners("faltan ()");}
	| KW_WHILE PARENTESIS_I expr PARENTESIS_D block_error {notifyErrorListeners("Error en el while");}
	| KW_WHILE PARENTESIS_I expr PARENTESIS_D 		{notifyErrorListeners("while vacio");};
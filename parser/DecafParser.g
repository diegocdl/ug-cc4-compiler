parser grammar DecafParser;

options {
    tokenVocab=DecafLexer;
}

@parser::header{
  package compiler.parser;
}


start: 
	callout_decl* field_decl* method_decl* 		#root
	| program_error								#error
	;

statement: 
	  location ASIG_OP expr PUNTO_COMA 											#asignacion
	| KW_IF PARENTESIS_I expr PARENTESIS_D block (KW_ELSE block)? 				#ifs
	| KW_FOR PARENTESIS_I ID ASIG_OP expr COMA expr PARENTESIS_D block 			#ciclo
	| KW_WHILE PARENTESIS_I expr PARENTESIS_D block 							#ciclo
	| method_call PUNTO_COMA													#statements
	| KW_RETURN (expr)? PUNTO_COMA 												#statements
	| (KW_BREAK | KW_CONTINUE) PUNTO_COMA										#statements
	;
		
expr:
	  MINUS expr												#exp
	| NEGATION expr												#exp
	| PARENTESIS_I expr PARENTESIS_D							#par
	| expr bin_op expr											#operacion
	| literal 												#literales
	| location													#exp
	| method_call												#exp
	;

literal:
	(INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL );

block:
	(LLAVE_I (field_decl | statement)* LLAVE_D )				#bloque;

bin_op: 
	( mulOp | addOp | REL_OP | EQ_OP | COND_OP);

method_decl:
	(type | KW_VOID) ID PARENTESIS_I ( (type ID) | (type ID COMA )+(type ID) )? PARENTESIS_D block 				#method_dec;	

field_decl:
	type ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA 	#field_dec;

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

method_call:
	  method_name PARENTESIS_I ( (expr)? | (expr COMA )+(expr) ) PARENTESIS_D 							#method_c
	| method_name  PARENTESIS_I ( (callout_arg)? | (callout_arg COMA )+ (callout_arg) ) PARENTESIS_D 	#method_c
	| method_call_error 																				# mc_error
	;
				
callout_arg:
	expr | STRING_LITERAL;

callout_decl:
	  KW_CALLOUT ID PUNTO_COMA
	| callout_decl_error
	;

location:
	  ID | (ID CORCHETE_I expr CORCHETE_D);

method_name:
	ID;

addOp:
	PLUS | MINUS;

mulOp:
	MULT | DIV;

program_error:
	callout_decl_error* field_decl_error* method_decl_error* ;

field_decl_error: 
	  type ( (ID | ID CORCHETE_I INT_LITERAL? CORCHETE_D)? | (ID COMA | ID CORCHETE_I INT_LITERAL? CORCHETE_D COMA)+(ID | ID CORCHETE_I INT_LITERAL? CORCHETE_D)) ASIG_OP literal PUNTO_COMA 
	| type ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA
	| type ID? (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID? (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA 
	| type (ID | ID CORCHETE_I INT_LITERAL CORCHETE_D) ( COMA ID | COMA ID CORCHETE_I INT_LITERAL CORCHETE_D)* 
	| type ID (CORCHETE_I .+? CORCHETE_D)? (COMA ID (CORCHETE_I .+? CORCHETE_D)? )* PUNTO_COMA 
	| type ( (ID CORCHETE_I CORCHETE_D)? | (ID COMA | ID CORCHETE_I CORCHETE_D COMA)+(ID CORCHETE_I CORCHETE_D)) PUNTO_COMA 
	| type keywords (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA keywords (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA 
	| type ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA? ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA 
	| ~(KW_INT | KW_BOOL) ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA
	| ID (CORCHETE_I INT_LITERAL CORCHETE_D)? ( COMA ID (CORCHETE_I INT_LITERAL CORCHETE_D)? )* PUNTO_COMA
	;
	
callout_decl_error: 
	KW_CALLOUT ID ;

block_error:
	LLAVE_I field_decl* (statement|statement_error)* ;

method_decl_error:
	(type | KW_VOID) ID PARENTESIS_I ((type? ID COMA )* ID (type? ID COMA )*) PARENTESIS_D (block|block_error) 
	| ID PARENTESIS_I ( (type ID) | (type ID COMA )+(type ID) )? PARENTESIS_D (block|block_error) 
	| (type | KW_VOID) ID PARENTESIS_I ( (type ID) | (type ID COMA )+(type ID) )? PARENTESIS_D block_error
	;

method_call_error:
	(method_name | KW_CALLOUT) PARENTESIS_I (keywords|bin_op) PARENTESIS_D 
	| INT_LITERAL PARENTESIS_I ( (expr)? | (expr COMA )+(expr) ) PARENTESIS_D 
	;

statement_error: 
	  if_error
	| while_error
	| for_error
	| location ASIG_OP expr 							
	| location ASIG_OP expr (ASIG_OP expr)+ PUNTO_COMA 	
	| KW_RETURN (expr)? 								
	| KW_BREAK 										
	| KW_CONTINUE 										
	| method_call 										
	;

for_error: 
	  ID PARENTESIS_I? ID ASIG_OP expr COMA expr PARENTESIS_D? (block|block_error) 		
	| KW_FOR PARENTESIS_I ID ASIG_OP expr COMA expr (block|block_error) 					
	| KW_FOR ID ASIG_OP expr COMA expr PARENTESIS_D (block|block_error) 						
	| KW_FOR ID ASIG_OP expr COMA expr (block|block_error) 						
	| KW_FOR PARENTESIS_I ASIG_OP expr COMA expr PARENTESIS_D (block|block_error) 		
	| KW_FOR PARENTESIS_I ID ASIG_OP expr COMA expr PARENTESIS_D block_error	;
			
if_error:
	  KW_IF PARENTESIS_I PARENTESIS_D (block|block_error) (KW_ELSE (block|block_error))? 			
	| KW_IF PARENTESIS_I expr PARENTESIS_D (KW_ELSE (block|block_error))? 			
	| KW_IF expr PARENTESIS_D (block|block_error) (KW_ELSE (block|block_error))? 			
	| KW_IF PARENTESIS_I expr (block|block_error) (KW_ELSE (block|block_error))? 				
	| KW_IF expr (block|block_error) (KW_ELSE (block|block_error))? 					
	| KW_IF PARENTESIS_I expr PARENTESIS_D block_error KW_ELSE (block|block_error) 	;

while_error:
	  KW_WHILE PARENTESIS_I PARENTESIS_D (block|block_error) 	
	| KW_WHILE expr PARENTESIS_D (block|block_error) 				
	| KW_WHILE PARENTESIS_I expr  (block|block_error) 			
	| KW_WHILE expr (block|block_error) 			
	| KW_WHILE PARENTESIS_I expr PARENTESIS_D block_error
	| KW_WHILE PARENTESIS_I expr PARENTESIS_D 	;

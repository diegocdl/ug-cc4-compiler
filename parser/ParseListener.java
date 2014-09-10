package compiler.parser;

import compiler.lib.OutputFile;
import compiler.lib.Debug;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
public class ParseListener extends DecafParserBaseListener {
	
	public OutputFile out;
	public Debug debug;

	public ParseListener(OutputFile o, Debug deb){
		out = o;
		debug = deb;
	}
	
	 
	// public void exitProgram(DecafParser.ProgramContext ctx) { 
	// 	if(debug != null) debug.println(ctx.getStart().getLine() + "program: ");
	// 	//System.out.println("Program:" + ctx.program());
	// 	System.out.println( "en linea" + ctx.getStart().getLine());
	// }

	public void exitMethod_call_error(DecafParser.Method_call_errorContext ctx) {
		System.out.println("Error en la llamada al metodo en la linea " + ctx.getStart().getText());
	}


	@Override
	public void exitStatement_error(DecafParser.Statement_errorContext ctx) {
		//System.out.println("Error en la llamada al metodo en la linea " + ctx.getStart().getText());
		if(ctx.location() != null){
			if(ctx.PUNTO_COMA() == null){
				System.out.println("Error falto ; en la linea: " + ctx.getStart().getLine() );
			}else{
				System.out.println("Error en la asignaion");
			}
		}
		if(ctx.KW_RETURN() != null || ctx.KW_BREAK() != null || ctx.KW_CONTINUE() != null || ctx.method_call() != null ){
			System.out.println("Error falto ; en la linea: " + ctx.getStart().getLine() );
		}
	}

	@Override
	public void exitProgram_error(DecafParser.Program_errorContext ctx) {
		System.out.println("Las declaraciones van primero en la linea: " + ctx.getStart().getLine());
	}

	@Override
	public void exitWhile_error(DecafParser.While_errorContext ctx) {
		if(ctx.PARENTESIS_I() == null && ctx.PARENTESIS_D() == null ){
			System.out.println("Error faltaron los parentesis () en la linea: " + ctx.getStart().getLine());
		} else if(ctx.PARENTESIS_I() == null){
			System.out.println("Error falta el parentesis izquierdo en la linea: " + ctx.getStart().getLine());
		} else {
			System.out.println("Error falta el parentesis derecho en la linea: " + ctx.getStart().getLine());
		}

		if (ctx.block_error() != null) {
			System.out.println("Error en el bloque del while en la linea: " + ctx.getStart().getLine());
		}

		if(ctx.block() == null && ctx.block_error() == null){
			System.out.println("Error No escribio el bloque de codigo del while en la linea : " + ctx.getStart().getLine());
		}
		if(ctx.expr() == null){
			System.out.println("Error Falta la condicion del ciclo while en la linea: " + ctx.getStart().getLine());
		}
	}

	@Override
	public void exitFor_error(DecafParser.For_errorContext ctx) {
		// kw_for
		if(ctx.KW_FOR() == null){
			System.out.println("Error for invalido en la linea: " + ctx.getStart().getLine());
		}
		// parentesis
		if(ctx.PARENTESIS_I() == null && ctx.PARENTESIS_D() == null ){
			System.out.println("Error faltaron los parentesis () en la linea: " + ctx.getStart().getLine());
		} else if(ctx.PARENTESIS_I() == null){
			System.out.println("Error falta el parentesis izquierdo en la linea: " + ctx.getStart().getLine());
		} else {
			System.out.println("Error falta el parentesis derecho en la linea: " + ctx.getStart().getLine());
		}

		if (ctx.ID() == null) {
			System.out.println("Error falto el identificador del for en la linea: " + ctx.getStart().getLine());
		}

		if (ctx.block_error() != null ) {
			System.out.println("Error en el bloque del for en la linea: " + ctx.getStart().getLine());
		}
		
	}

	@Override
	public void exitIf_error(DecafParser.If_errorContext ctx) {
		if (ctx.expr() == null) {
			System.out.println("Error no indico la condicion del if en la linea: " + ctx.getStart().getLine());
		}
		if( ctx.KW_ELSE() != null && ctx.block().size() == 1){
			System.out.println("Error falto un bloque de codigo del if en la linea: " + ctx.getStart().getLine());
		}
		
		// parentesis
		if(ctx.PARENTESIS_I() == null && ctx.PARENTESIS_D() == null ){
			System.out.println("Error faltaron los parentesis () en la linea: " + ctx.getStart().getLine());
		} else if(ctx.PARENTESIS_I() == null){
			System.out.println("Error falta el parentesis izquierdo en la linea: " + ctx.getStart().getLine());
		} else {
			System.out.println("Error falta el parentesis derecho en la linea: " + ctx.getStart().getLine());
		}

		if (ctx.block_error() != null) {
			System.out.println("Error en el bloque del if en la linea: " + ctx.getStart().getLine());
		}
	}

	@Override
	public void exitMethod_decl_error(DecafParser.Method_decl_errorContext ctx) {
		System.out.println("Error decl");
		if (ctx.KW_VOID() == null && ctx.ID().size() != ctx.type().size() || ctx.ID().size() != (ctx.type().size() - 1)) {
			System.out.println("Error falto un tipo de parametro de la declaracion del metodo en la linea: " + ctx.getStart().getLine());
		}
		if(ctx.block_error() != null){
			System.out.println("Error en el bloque de la declaracion del metodo en la linea:" + ctx.getStop().getLine());
		}
		// no se indico el tipo de retorno
	}

	@Override
	public void exitCallout_decl_error(DecafParser.Callout_decl_errorContext ctx) {
		System.out.println("Falto el ; en la linea " + ctx.getStart().getLine());
	}

	@Override
	public void exitBlock_error( DecafParser.Block_errorContext ctx) {
		// ignorado por que se reporta en otros lugares
	}

	@Override
	public void exitField_decl_error( DecafParser.Field_decl_errorContext ctx) {
		System.out.println("Error field ");
		if(ctx.ASIG_OP() != null) {
			System.out.println("Erro no se puede inicializar variables al declararlas en la linea: " + ctx.getStart().getLine());
		}
		System.out.println("Sizes: " + ctx.ID() + ":" + ctx.COMA());
		if(ctx.ID().size() - 1 != ctx.COMA().size()){
			System.out.println("Error falto un identificador de variable en la linea: " + ctx.getStart().getLine());
		}
		if(ctx.PUNTO_COMA() == null){
			System.out.println("Error falto el ; de la declaracion de variable en la linea: " + ctx.getStart().getLine());
		}

		if((ctx.CORCHETE_I().size() + ctx.CORCHETE_I().size())/2  != ctx.INT_LITERAL().size()){
			System.out.println("Error en la declaracion del arreglo en la linea: " + ctx.getStart().getLine());
		}

		if(ctx.INT_LITERAL() == null){
			System.out.println("Error falto el tamaño del arreglo en la linea: " + ctx.getStart().getLine());
		}

		if(ctx.keywords() != null){
			System.out.println("Error en declaracion de variable no se permite el uso de palabras reservadas en la linea: " + ctx.getStart().getLine());
		}

		if(ctx.ID().size()-1 != ctx.COMA().size()){
			System.out.println("Error faltaron comas en la declaracion de varias variables en la linea: " + ctx.getStart().getLine());
		}

		if(ctx.KW_INT() == null && ctx.KW_BOOL() == null){
			System.out.println("Error se debe indicar un tipo de dato valido en la linea: " + ctx.getStart().getLine());
		}
	}

}
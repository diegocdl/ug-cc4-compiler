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
	
	@Override 
	public void enterProgram(DecafParser.ProgramContext ctx) { 
		if(debug != null) debug.println(ctx.getStart().getLine() + "program: ");
		//System.out.println("Program:" + ctx.program());
		System.out.println( "en linea" + ctx.getStart().getLine());
	}

	public void enterMethod_call_error(DecafParser.Method_call_errorContext ctx) {
		System.out.println("Error en la llamada al metodo en la linea " + ctx.getStart().getText());
	}


	@Override
	public void enterStatement_error(DecafParser.Statement_errorContext ctx) {
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
	public void enterProgram_error(DecafParser.Program_errorContext ctx) {

	}

	@Override
	public void enterWhile_error(DecafParser.While_errorContext ctx) {

	}

	@Override
	public void enterFor_error(DecafParser.For_errorContext ctx) {

	}

	@Override
	public void enterIf_error(DecafParser.If_errorContext ctx) {

	}

	@Override
	public void enterMethod_decl_error(DecafParser.Method_decl_errorContext ctx) {

	}

	@Override
	public void enterCallout_decl_error(DecafParser.Callout_decl_errorContext ctx) {

	}

	@Override
	public void enterBlock_error( DecafParser.Block_errorContext ctx) {

	}

	@Override
	public void enterField_decl_error( DecafParser.Field_decl_errorContext ctx) {

	}

	


}
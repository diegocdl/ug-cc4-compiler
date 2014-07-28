package compiler.ast;

import compiler.parser.CC4Parser;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Ast {

	public Debug debug;
	public OutputFile of;

	public Ast(CC4Parser parser) throws Exception {
		of = parser.getOutFile();
		String msg = "stage: Ast";
		System.out.println(msg);
		of.writeln(msg);
	}	

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Ast");
	}

	public OutputFile getOutFile(){
		return of;
	}
}
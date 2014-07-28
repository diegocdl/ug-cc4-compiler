package compiler.semantic;

import compiler.ast.Ast;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Semantic {

	public Debug debug;
	public OutputFile of;
	
	public Semantic(Ast ast) throws Exception {
		of = ast.getOutFile();
		String msg = "stage: Semantic";
		System.out.println(msg);
		of.writeln(msg);
	}

	public void setDebuger(Debug d) {
		debug = d;
		debug.println("debugging: Semantic");
	}

	public OutputFile getOutFile(){
		return of;
	}
}
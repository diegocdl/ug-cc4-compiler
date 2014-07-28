package compiler.codegen;

import compiler.irt.Irt;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Codegen {
	
	public Debug debug;
	public OutputFile of;

	public Codegen(Irt irt) throws Exception {
		String msg = "stage: codegen";
		of = irt.getOutFile();
		System.out.println(msg);
		of.writeln(msg);
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Codegen");
	}

	public OutputFile getOutFile(){
		return of;
	}
}
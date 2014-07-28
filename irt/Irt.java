package compiler.irt;

import compiler.semantic.Semantic;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Irt {

	public Debug debug;
	public OutputFile of;
	
	public Irt(Semantic semantic) throws Exception {
		String msg = "stage: Irt";
		of = semantic.getOutFile();
		System.out.println(msg);
		of.writeln(msg);
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Irt");
	}

	public OutputFile getOutFile(){
		return of;
	}

}
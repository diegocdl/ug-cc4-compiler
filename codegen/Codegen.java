package compiler.codegen;

import compiler.irt.Irt;
import compiler.lib.Debug;

public class Codegen {
	
	public Debug debug;

	public Codegen(Irt irt) {
		System.out.println("stage: codegen");
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Codegen");
	}
}
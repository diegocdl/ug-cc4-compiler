package compiler.irt;

import compiler.semantic.Semantic;
import compiler.lib.Debug;

public class Irt {

	public Debug debug;
	
	public Irt(Semantic semantic) {
		System.out.println("stage: Irt");
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Irt");
	}


}
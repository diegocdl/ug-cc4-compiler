package compiler.ast;

import compiler.parser.CC4Parser;
import compiler.lib.Debug;

public class Ast {

	public Debug debug;

	public Ast(CC4Parser parser) {
		System.out.println("stage: Ast");
	}	

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Ast");
	}
}
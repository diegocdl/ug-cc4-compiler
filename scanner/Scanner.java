package compiler.scanner;

import compiler.lib.Debug;

public class Scanner {

	public Debug debug;

	public Scanner(String inputFile) {
		System.out.println("stage: Scanner");
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Scanner");
	}
}
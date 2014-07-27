package compiler.parser;

import compiler.scanner.Scanner;
import compiler.lib.Debug;

public class CC4Parser {

	public Debug debug;

	public CC4Parser(Scanner scan) {
		System.out.println("stage: Parser");
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: CC4Parser");
	}
}
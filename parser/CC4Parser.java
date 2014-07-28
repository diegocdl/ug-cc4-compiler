package compiler.parser;

import compiler.scanner.Scanner;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class CC4Parser {

	public Debug debug;
	public OutputFile of;

	public CC4Parser(Scanner scan) throws Exception {
		String msg = "stage: Parser";
		of = scan.getOutFile();
		System.out.println(msg);
		of.writeln(msg);
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: CC4Parser");
	}

	public OutputFile getOutFile(){
		return of;
	}
}
package compiler.scanner;

import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Scanner {

	public Debug debug;
	public OutputFile of;

	public Scanner(String inputFile, OutputFile outFile) throws Exception {
		String msg = "stage: Scanner";
		System.out.println(msg);
		of = outFile;
		of.writeln(msg);
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Scanner");
	}

	public OutputFile getOutFile(){
		return of;
	}

}
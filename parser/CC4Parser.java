package compiler.parser;

import compiler.scanner.*;
import org.antlr.v4.runtime.*;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.List;

public class CC4Parser {

	public Debug debug;
	public OutputFile of;
	public DecafParser parser;
	public Scanner scan;


	public CC4Parser(Scanner scan) throws Exception {
		this.scan = scan;
		of = scan.getOutFile();
		String msg = "stage: Parser";
		System.out.println(msg);
		of.writeln(msg);
	}

	public void start() {
		try {	    
			parser = new DecafParser(new CommonTokenStream(scan.lexer));
			//parser.removeErrorListeners();
			parser.addParseListener(new ParseListener(of, debug));
			parser.start();
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.err.println("usage: java Main <file>\nwhere file is the path to the filename with the tokens");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("usage: java Main <file>\nwhere file is the path to the filename with the tokens");
			System.exit(1);
		} 
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: CC4Parser");
	}

	public OutputFile getOutFile(){
		return of;
	}
}

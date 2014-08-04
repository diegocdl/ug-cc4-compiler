package compiler.scanner;

import compiler.lib.Debug;
import compiler.lib.OutputFile;
import org.antlr.v4.runtime.*;

public class Scanner {

	public Debug debug;
	public OutputFile of;

	public Scanner(String inputFile, OutputFile outFile) throws Exception {
		String msg = "stage: Scanner";
		//System.out.println(msg);
		of = outFile;
		of.writeln(msg);
		try{
		    DecafLexer lexer = new DecafLexer(new ANTLRFileStream(inputFile));
		    int i;
		    String str;
		    Token t = lexer.nextToken();
		    while (t.getType() != Token.EOF){
		    	if(DecafLexer.tokenNames[t.getType()].equals("CHAR_ERROR")){
		    		str = t.getLine() + " -> " + DecafLexer.tokenNames[t.getType()] + ": " + t.getText().substring(1,t.getText().length()-1);
		    	}else{
		    		str = t.getLine() + " " + DecafLexer.tokenNames[t.getType()] + ": " + t.getText();
		    	}
				System.out.println(str);
				of.writeln(str);
				t = lexer.nextToken();
		    } 
		}catch(ArrayIndexOutOfBoundsException aiobe){
		    System.err.println("Must provide a valid path to the filename with the tokens");
		    System.exit(1);
		}catch(Exception e){
		    System.err.println("Must provide a valid path to the filename with the tokens");
		    System.exit(1);
		}
	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Scanner");
	}

	public OutputFile getOutFile(){
		return of;
	}

}
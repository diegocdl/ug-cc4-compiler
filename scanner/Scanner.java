package compiler.scanner;

import compiler.lib.Debug;
import compiler.lib.OutputFile;
import org.antlr.v4.runtime.*;

public class Scanner {

	public Debug debug;
	public OutputFile of;
	public DecafLexer lexer;
	public BaseErrorListener listener;

	public Scanner(String inputFile, OutputFile outFile) throws Exception {
		String msg = "stage: Scanner";
		//System.out.println(msg);
		of = outFile;
		of.writeln(msg);
		try {
		    lexer =  new DecafLexer(new ANTLRFileStream(inputFile));;
		    DecafLexer lexerTemp = new DecafLexer(new ANTLRFileStream(inputFile));
		    lexerTemp.removeErrorListeners(); // remover los listeners originales de ANTLr

		    // agregamos nuestro Listener 
	    	listener = new ErrorListener(); 
		    lexerTemp.addErrorListener(listener);

		    // Se recorren los tokens
		    String str;
		    Token t = lexerTemp.nextToken();
		    while (t.getType() != Token.EOF){
		    	str = t.getLine() 
		    			+ " " + getRuleName(t.getType())  // concatena el nombre de la regla 
		    			+ ": " + t.getText(); // se agrega el texto de token
				System.out.println(str);
				of.writeln(str);
				t = lexerTemp.nextToken();
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

	/**
	*	Retorna el nombre de la regla correspondiente al idType	
	*	se le resta 1 por que el arreglo empieza en 0 y el los tokens antlr los numero a partir de 1
	* 
	*/
	public String getRuleName(int id) {
		if (id <= DecafLexer.ruleNames.length) {
			return DecafLexer.ruleNames[ id - 1 ];
		} else {
			return null;
		}
	}
	class ErrorListener extends BaseErrorListener	{
		 @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
	                            int line, int charPositionInLine,
	                            String msg, RecognitionException e) {
	        String sourceName = recognizer.getInputStream().getSourceName();
	        if (!sourceName.isEmpty()) {
	            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
	        }
	        // try {
	        	System.out.println(e.getCtx());
	        	// System.out.println(sourceName+ " " +charPositionInLine+ " " + msg);
	        	// of.writeln(sourceName+ " " + msg);
	        	
	        // } catch (Exception ex) { 
	        	// Ignoramos la excepcion
	        // }
		}
	}
}
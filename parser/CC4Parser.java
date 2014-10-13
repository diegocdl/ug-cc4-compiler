package compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.gui.TreeViewer;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import javax.swing.*;

import compiler.scanner.*;
import compiler.lib.Debug;
import compiler.lib.ErrorHandler;
import compiler.lib.OutputFile;

public class CC4Parser {

	public Debug debug;
	public OutputFile of;
	public DecafParser parser;
	public Scanner scan;
	public ParseTree tree;


	public CC4Parser(Scanner scan) throws Exception {
		this.scan = scan;
		of = scan.getOutFile();
		String msg = "stage: Parser";
		System.out.println(msg);
		of.writeln(msg);
	}

	public void start() throws ErrorHandler {
		try {	    
			parser = new DecafParser(new CommonTokenStream(scan.lexer));
			parser.removeErrorListeners();
			parser.addErrorListener(new DecafErrorListener());
			ParseTreeWalker walker = new ParseTreeWalker();
			ParseListener listener = new ParseListener();
			tree = parser.start();
			walker.walk(listener, tree);

			// desplegar en una ventana el arbol de parseo
			TreeViewer view = 	new TreeViewer(
									Arrays.asList(DecafParser.ruleNames),
									tree
								);

            JFrame ventana = new JFrame();
			ventana.add(view);
			ventana.setBounds(0,0, 1000, 600);
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventana.setVisible(true);

			System.out.println("Arbol de parseo: " + tree.toStringTree(parser));

			// desplegar los errores
			LinkedList<String> errores = listener.getErrorList();
			for (String e : errores) {
				System.err.println(" * " + e);
				of.writeln(" * " + e);
			}
			if(listener.getErrorList().size() > 0) {
				throw new ErrorHandler("Se han encontrado " + listener.getErrorList().size() + " error(s) y no se puede continuar la compilacion.");
			}

		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.err.println("usage: java Main <file>\nwhere file is the path to the filename with the tokens");
			aiobe.printStackTrace();
			// System.exit(1);
		} catch (IOException e) {
			System.err.println("usage: java Main <file>\nwhere file is the path to the filename with the tokens");
			e.printStackTrace();
			
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
package compiler.parser;

import compiler.scanner.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.gui.TreeViewer;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.List;
import java.util.Arrays;
import javax.swing.*;


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

	public void start() {
		try {	    
			parser = new DecafParser(new CommonTokenStream(scan.lexer));
			parser.removeErrorListeners();
			parser.addParseListener(new ParseListener(of, debug));
			tree = parser.start();
			TreeViewer view = 	new TreeViewer(
									Arrays.asList(DecafParser.ruleNames),
									tree
								);
			// MiVentana window = new MiVentana(view);
			// window.start();
            JFrame ventana = new JFrame();
			ventana.add(view);
			ventana.setBounds(0,0, 1000, 600);
			ventana.setVisible(true);
			ventana.show();

			System.out.println(tree.toStringTree(parser));

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

class MiVentana extends Thread {
	JPanel ventana;

	public MiVentana(TreeViewer t){
		super();
		ventana = new JPanel();
		ventana.add(t);

	}

	public void run(){
		while(true){

			ventana.show();
		}
	}
}
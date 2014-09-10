package compiler.ast;

import compiler.parser.CC4Parser;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.List;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import compiler.parser.DecafParser;
import compiler.parser.DecafParserBaseVisitor;
public class Ast {
	
	public Debug debug;
	public OutputFile of;
	public CC4Parser parser;

	public Ast(CC4Parser parser) throws Exception {
		this.parser = parser;
		of = parser.getOutFile();
		String msg = "stage: Ast";
		System.out.println(msg);
		of.writeln(msg);
	}	

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Ast");
	}

	public OutputFile getOutFile(){
		return of;
	}
	public void start() {
    try {
		//obtener arbol de parseo
		// ParseTree tree = this.parser.parser.start();
		// System.out.println(tree.toStringTree(parser.parser));
		//usar visitor para recorrer el arbol y tomar los elementos que interesan
		AstVisitor visitor = new AstVisitor();
		Root root = (Root)visitor.visit(parser.tree);
		root.print();
		System.out.println(root);
		GraphicTree gt = new GraphicTree(root);
		String dotRepresentation = gt.build();

		of.writeln(dotRepresentation);
    } catch (ArrayIndexOutOfBoundsException aiobe) {
		System.err.println("usage: java Main <file>\nwhere file is the path to the filename with the tokens");
		aiobe.printStackTrace();
		System.exit(1);
    } catch (Exception e) {
		System.err.println("usage: java Main <file>\nwhere file is the path to the filename with the tokens");
		e.printStackTrace();
		System.exit(1);
    } 
  }
	
}


package compiler.ast;

import compiler.parser.CC4Parser;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.List;
import java.util.LinkedList;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import compiler.parser.DecafParser;
import compiler.parser.DecafParserBaseVisitor;
public class Ast {
	
	public Debug debug;
	public OutputFile of;
	public CC4Parser parser;
	public Root root;

	public Ast(CC4Parser parser) throws Exception {
		this.parser = parser;
		AstVisitor visitor = new AstVisitor();
		this.root = (Root)visitor.visit(parser.tree);
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
			if(root != null){
				String strTree = this.root.print();
				System.out.println(strTree);
				of.writeln(strTree);
			
				GraphicTree gt = new GraphicTree(root);
				String dotRepresentation = gt.build();

				of.writeln(dotRepresentation);
			}
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.err.println("ArrayIndexOutOfBoundsException");
			aiobe.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Exception");
			e.printStackTrace();
			System.exit(1);
		} 
  	}
	
}

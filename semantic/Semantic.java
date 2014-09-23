package compiler.semantic;

import java.util.LinkedList;
import compiler.ast.*;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Semantic {

	public Debug debug;
	public OutputFile of;
	public Root root;
	private SymbolTableManager symbolTableManager;

	public Semantic(Ast ast) throws Exception {
		String msg = "stage: Semantic";
		System.out.println(msg);
		of = ast.getOutFile();
		of.writeln(msg);
		root = ast.root;

		symbolTableManager = new SymbolTableManager();
		buildTable();
		System.out.println(symbolTableManager);
	}
	
	public void buildTable(){
		root.buildTable(null, symbolTableManager);
	}

	public void setDebuger(Debug d) {
		debug = d;
		debug.println("debugging: Semantic");
	}

	public OutputFile getOutFile(){
		return of;
	}
	
}

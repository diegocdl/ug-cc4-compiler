package compiler.ast;

import java.util.LinkedList;
import java.util.List;
import compiler.semantic.*;

public class MethodCall extends Node {
	
	public String nameMethod;
	public LinkedList<Node> expresiones;

	/* para method_decl */
	public MethodCall(String name, LinkedList<Node> ex){
		this.nameMethod = name;
		this.expresiones = ex;
	}

	public void checkMethodCall(Table tb){
	
	}
	
	@Override
	public String print(String padding) {
		String str = padding + "Llamada " +  nameMethod + "\n";
		if(expresiones != null){
			for ( Node e : expresiones ) {
				str += e.print(padding + "\t");
			}
		}
		return str;
	}
	
	@Override
	public String toString(){
		return "Method Call";
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"" + nameMethod + "\"];");
		rel.add("n" + parent + " -> n" + i);		
		return i;
	}
}

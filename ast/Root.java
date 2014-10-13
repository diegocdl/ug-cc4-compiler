package compiler.ast;

import java.util.List;
import java.util.LinkedList;
import compiler.semantic.Table;
import compiler.semantic.SymbolTableManager;

public class Root extends Node{

	public LinkedList<Node> declaraciones;
	
	public Root(){
		declaraciones = new LinkedList<Node>();
	}
	
	public void add(Node node){
		declaraciones.add(node);
	}

	public int size(){
		return declaraciones.size();
	}

	public Node getChild(int i){
		return declaraciones.get(i);
	}
	
	public String print(){
		return print("");
	}

	@Override
	public String print(String padding){
		String str = padding + "Root\n" ;
		for(Node n : declaraciones){
			if(n != null)
				str += n.print("\t" + padding);
		}
		return str;
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;
		dec.add("n" + ( ++i ) + "[label=\"Root\"];");
		if(parent != 0) 
			rel.add("n"+ parent + " -> n" + i );
		for (Node n : declaraciones ) {
			i = n.getDotTree(nodoActual+1, i, dec, rel);
		}
		return i;
	}
} 
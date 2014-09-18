package compiler.ast;

import java.util.List;
import java.util.LinkedList;

public class Root extends Node{

	public LinkedList<Node> declaraciones;
	
	public Root(){
		declaraciones = new LinkedList<Node>();
	}
	
	public void add(Node node){
		declaraciones.add(node);
	}
	
	public void print(String padding){
		System.out.println(padding + "Root");
		for(Node n : declaraciones){
			if(n != null)
				n.print("\t" + padding);
		}
	}

	public int size(){
		return declaraciones.size();
	}

	public Node getChild(int i){
		return declaraciones.get(i);
	}
	
	public void print(){
		print("");
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;
		dec.add("n" + ( nodoActual ) + "[label=\"Root\"];");
		for (Node n : declaraciones ) {
			n.getDotTree(i, i, dec, rel);
			i++;
		}
		return i;
	}
} 
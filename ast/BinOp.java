package compiler.ast;

import java.util.List;

public class BinOp extends Node{
	/*
		BinOp tiene una cantidad definida de nodos hijos
		BinOp puede tener distintos signos
	*/
	public Node hijo1;
	public Node hijo2;
	public String operation;
	
	public BinOp(String op, Node n1, Node n2){
		/*
			incluir argumentos con el signo y los hijos
		*/
		this.hijo1 = n1;
		this.hijo2 = n2;
		this.operation = op;
	}
	
	public void print(String padding){
		/*
			imprimir tanto el signo como los hijos
		*/
		System.out.println(padding + operation);
		if(hijo1 != null) hijo1.print(padding + "\t");
		if(hijo2 != null) hijo2.print(padding + "\t");
	}

	public int getDotTree(int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"Exp\"];");
		rel.add("n" + nodoActual + " -> n" + i);		
		i = hijo1.getDotTree(i, dec, rel);

		dec.add("n" + ( ++i ) + "[label=\"ID\"];");
		rel.add("n" + nodoActual + " -> n" + i);

		dec.add("n" + ( ++i ) + "[label=\"Exp\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = hijo1.getDotTree(i, dec, rel);		
		
		return i;
	}
} 
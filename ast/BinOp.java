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
	
	@Override
	public String print(String padding){
		/*
			imprimir tanto el signo como los hijos
		*/
		String str = padding + operation + "\n";
		if(hijo1 != null) {
			str += hijo1.print(padding + "\t");
		}
		if(hijo2 != null) {
			str += hijo2.print(padding + "\t");
		}
		return str;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"" + operation + "\"];");
		rel.add("n" + parent + " -> n" + i);

		i = hijo1.getDotTree(nodoActual + 1, i, dec, rel);
		
		i = hijo2.getDotTree(nodoActual + 1, i, dec, rel);		
		
		return i;
	}
} 
package compiler.ast;

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
} 
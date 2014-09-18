package compiler.ast;

import java.util.List;

public class Cond extends Node{
	
	public Node condicion;
	public Node consecuencia;
	public Node alternativa;
	
	public Cond(Node condicion, Node consecuencia){
		this(condicion, consecuencia, null);
	}
	
	public Cond(Node condicion, Node consecuencia, Node alternativa){
		this.condicion = condicion;
		this.consecuencia = consecuencia;
		this.alternativa = alternativa;
	}
	
	public void print(String padding){
		System.out.println(padding + "If");
		if(condicion != null) condicion.print(padding + "\t");
		if(consecuencia != null) consecuencia.print(padding + "\t");
		if(alternativa != null){
			System.out.println(padding + "\tElse");
			alternativa.print(padding + "\t");
		}
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"if\"];");
		rel.add("n" + nodoActual + " -> n" + i);		
		i = condicion.getDotTree(i, nodoActual, dec, rel);

		dec.add("n" + ( ++i ) + "[label=\"ID\"];");
		rel.add("n" + nodoActual + " -> n" + i);

		// dec.add("n" + ( ++i ) + "[label=\"Exp\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = hijo1.getDotTree(i, dec, rel);		
		
		return i;
	}
} 
package compiler.ast;

import java.util.List;
import compiler.semantic.*;

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
	
	public void checkCond(Table tb, String nombre){
	
	}
	
	@Override
	public String toString(){
		return "Cond";
	}
	
	@Override
	public String print(String padding){
		String str = padding + "If\n";
		if(condicion != null) {
			str += condicion.print(padding + "\t");
		}
		if(consecuencia != null) {
			str += consecuencia.print(padding + "\t");
		}
		if(alternativa != null){
			str += padding + "\tElse\n";
			str += alternativa.print(padding + "\t");
		}
		return str;
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

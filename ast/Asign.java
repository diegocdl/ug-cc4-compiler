package compiler.ast;

import java.util.List;
import compiler.semantic.*;

public class Asign extends Node{
	public Node id;
	public String asig;
	public Node value;
	
	public Asign(Node id, String asig, Node value){
		this.id = id;
		this.asig = asig;
		this.value = value;
	}
	
	public void print(String padding){
		System.out.println(padding + asig);
		id.print(padding + "\t");
		if(value != null) value.print(padding + "\t");
	}

	public void checkAsign(Table tb){
	
	}
	
	@Override
	public String toString(){
		return "Asignacion";
	}
	
	public int getDotTree(int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"ID\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = id.getDotTree(i, dec, rel);
		dec.add("n" + (++i) + "[label=\"" + asig + "\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = value.getDotTree(i, dec, rel);
		return i;
	}

} 

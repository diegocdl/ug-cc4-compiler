package compiler.ast;

import java.util.List;
import compiler.semantic.*;

public class Asign extends Node{
	public Node id;
	public String asig;
	public Node value;
	
	public Asign(Node id, String asig, Node value){
		super();
		this.id = id;
		this.asig = asig;
		this.value = value;
	}

	@Override
	public String print(String padding){
		String str = padding + asig+"\n";
		str += id.print(padding + "\t");
		if(value != null){
			str += value.print(padding + "\t");
		}
		return str;
	}

	public void checkAsign(Table tb){
	
	}
	

	@Override
	public String toString(){
		return "Asignacion";
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		// dec.add("n" + ( ++i ) + "[label=\"ID\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		dec.add("n" + (++i) + "[label=\"" + asig + "\"];");
		rel.add("n" + (parent) + " -> n" + i);
		i = id.getDotTree(parent+1, i, dec, rel);
		i = value.getDotTree(parent+1, i, dec, rel);
		return i;
	}

} 

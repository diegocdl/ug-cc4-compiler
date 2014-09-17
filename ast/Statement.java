package compiler.ast;

import java.util.List;
import compiler.semantic.*;

public class Statement extends Node{
	/* continue, break, return */
	public String keyword;
	/* valor a retornar */
	public Node value;
	
	public Statement(String k){
		this(k, null);
	}
	
	public Statement(String k, Node n1){
		this.keyword = k;
		this.value = n1;
	}
	
	public void print(String padding){
		System.out.println(padding + keyword);
		if(value != null){
			value.print(padding + "\t");
		}
	}

	public void checkStatement(Table tb){
	
	}
	
	@Override
	public String toString(){
		return "Statement";
	}
	
	public int getDotTree(int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"Statement\"];");
		rel.add("n" + nodoActual + " -> n" + i);		
		if (value==null){
			dec.add("n" + ( ++i ) + "[label=\"" + keyword +"\"];");
			rel.add("n" + nodoActual + " -> n" + i);		
		}else{
			dec.add("n" + ( ++i ) + "[label=\"" + keyword +"\"];");
			rel.add("n" + nodoActual + " -> n" + i);	
			i = value.getDotTree(nodoActual, dec, rel);			
		}
		// if(tipoCiclo.equals(FOR)){
		// 	dec.add("n" + ( ++i ) + "[label=\"exp\"];");
		// 	rel.add("n" + nodoActual + " -> n" + i);		
		// 	i = inicializacionVar.getDotTree(nodoActual, dec, rel);
		// }
		// dec.add("n" + ( ++i ) + "[label=\"condicion\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = condicion.getDotTree(i, dec, rel);

		// dec.add("n" + ( ++i ) + "[label=\"bloque\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = bloque.getDotTree(i, dec, rel);
		
		return i;
	}
} 

package compiler.ast;

import java.util.List;

public class Literal extends Node {
	/*char, string, Int, hex */ 
	public String value;
	
	public Literal(String s){
		this.value = s;
	}
	
	public void print(String padding){
		System.out.println(padding + value);
	}

	@Override
	public String toString(){
		return value;
	}

	public int getDotTree(int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"" + value + "\"];");
		rel.add("n" + nodoActual + " -> n" + i);		

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
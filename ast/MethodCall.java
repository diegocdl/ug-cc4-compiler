package compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class MethodCall extends Node {
	
	public String nameMethod;
	public LinkedList<Node> expresiones;

	/* para method_decl */
	public MethodCall(String name, LinkedList<Node> ex){
		this.nameMethod = name;
		this.expresiones = ex;
	}

	public void print(String padding) {
		System.out.println(padding + "Llamada ");
		System.out.println(padding +  nameMethod);
		if(expresiones != null){
			for ( Node e : expresiones ) {
				e.print(padding + "\t");
			}
		} 
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"Llamada\"];");
		rel.add("n" + nodoActual + " -> n" + i);		
		dec.add("n" + ( ++i ) + "[label=\"" + nameMethod + "\"];");
		rel.add("n" + nodoActual + " -> n" + i);	
		for (Node n : expresiones ) {
			n.getDotTree(i, i, dec, rel);
			i++;
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

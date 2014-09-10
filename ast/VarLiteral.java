package compiler.ast;

import java.util.List;
public class VarLiteral extends Node {
	public String name;
	public Node dimension;

	public VarLiteral(String name, int dim){
		this.name = name;
		this.dimension = new Literal(Integer.toString(dim));
	}
	public VarLiteral(String name, Node n){
		this.name = name;
		this.dimension = n;
	}

	public VarLiteral(String name){
		this.name = name;
		this.dimension = null;
	}

	public void print(String padding){
		System.out.println(padding + "VarLiteral");
		System.out.println("\t"+ padding + name);
		if(dimension != null) dimension.print(padding + "\t");
	}

	@Override
	public String toString(){
		return name;
	}

	public int getDotTree(int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"VarLiteral\"];");
		rel.add("n" + (nodoActual) + " -> n" + i);		

		// if(dimension != null) {
		// 	i = dimension.getDotTree(nodoActual, dec, rel);
		// }

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
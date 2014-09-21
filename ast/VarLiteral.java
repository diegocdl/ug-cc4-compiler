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
	
	@Override
	public String print(String padding){
		String str = padding + "VarLiteral\n";
		str += "\t" + padding + name + "\n";
		if(dimension != null){
			str += dimension.print(padding + "\t");
		}
		return str;
	}

	@Override
	public String toString(){
		return name;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"VarLiteral\"];");
		rel.add("n" + (parent ) + " -> n" + i);

		dec.add("n" + ( ++i ) + "[label=\""+ name +"\"];");
		rel.add("n" + (nodoActual + 1) + " -> n" + i);


		if(dimension != null) {
			i = dimension.getDotTree(parent+1, i, dec, rel);
		}


		
		return i;
	}
}
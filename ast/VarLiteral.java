package compiler.ast;
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
}
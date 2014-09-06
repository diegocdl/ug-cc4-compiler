package compiler.ast;
public class VarLiteral extends Node {
	public String name;
	public Integer dimension;

	public VarLiteral(String name, int dim){
		this.name = name;
		this.dimension = new Integer(dim);
	}

	public VarLiteral(String name){
		this.name = name;
		this.dimension = null;
	}

	public void print(String padding){
		System.out.println(padding + "VarLiteral");
		System.out.println("\t"+ padding + name);
		System.out.println("\t"+ padding + dimension);
	}
}
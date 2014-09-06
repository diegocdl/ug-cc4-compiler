package compiler.ast;

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
} 
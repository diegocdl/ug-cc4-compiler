package compiler.ast;

public class Cond extends Node{
	
	public Node condicion;
	public Node consecuencia;
	public Node alternativa;
	
	public Cond(Node condicion, Node consecuencia){
		this(condicion, consecuencia, null);
	}
	
	public Cond(Node condicion, Node consecuencia, Node alternativa){
		this.condicion = condicion;
		this.consecuencia = consecuencia;
		this.alternativa = alternativa;
	}
	
	public void print(String padding){
		System.out.println(padding + "If");
		if(condicion != null) condicion.print(padding + "\t");
		if(consecuencia != null) consecuencia.print(padding + "\t");
		if(alternativa != null){
			System.out.println(padding + "\tElse");
			alternativa.print(padding + "\t");
		}
	}
} 
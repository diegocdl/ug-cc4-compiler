package compiler.ast;
/*
	for(<id> = <expr>, <expr>) <block>
	while (<expr>) <block>

*/
public class Cycle extends Node{
	public String tipoCiclo;
	
	/* la inicializacion de variable solo se usara en el for */
	public Node inicializacionVar;
	public Node condicion;
	public Node bloque;
	
	public Cycle(String tipo, Node inicializacionVar, Node condicion, Node bloque){
		this.inicializacionVar = inicializacionVar;
		this.condicion = condicion;
		this.bloque = bloque;
		this.tipoCiclo = tipo;
	}
	

	public Cycle(Node inicializacionVar, Node condicion, Node bloque){
		this("for", inicializacionVar, condicion, bloque);
	}

	/**
	*	Constructor para ciclos while
	* 	@param condicion
	* 	@param bloque
	*/
	public Cycle(Node condicion, Node bloque){
		this("while", null, condicion, bloque);
	}
	
	public void print(String padding){
		System.out.println(padding + tipoCiclo);
		if(inicializacionVar != null) 
			inicializacionVar.print(padding + "\t");
		if(condicion != null)
			condicion.print(padding + "\t");
		if(bloque != null) 
			bloque.print(padding + "\t");
	}
} 
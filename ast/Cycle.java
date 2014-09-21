package compiler.ast;

import java.util.List;
import compiler.semantic.*;
/*
	for(<id> = <expr>, <expr>) <block>
	while (<expr>) <block>

*/
public class Cycle extends Node{

	public static final String FOR = "for";
	public static final String WHILE = "while";

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
		this(FOR, inicializacionVar, condicion, bloque);
	}

	/**
	*	Constructor para ciclos while
	* 	@param condicion
	* 	@param bloque
	*/
	public Cycle(Node condicion, Node bloque){
		this(WHILE, null, condicion, bloque);
	}
	
	
	public void checkCycle(Table tb, String nombre){
	
	}
	
	@Override
	public String toString(){
		return "Ciclo";
		/*String str = "";
		if(this.inicializacionVar != null){
			str = this.tipoCiclo + " " + this.inicializacionVar.toString() + " " + this.condicion.toString();
		}else{
			str = this.tipoCiclo + " " + this.condicion.toString();
		}
		return str;*/
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\""+ tipoCiclo + "\"];");
		rel.add("n" + nodoActual + " -> n" + i);		

		if(tipoCiclo.equals(FOR)){
			dec.add("n" + ( ++i ) + "[label=\"exp\"];");
			rel.add("n" + nodoActual + " -> n" + i);		
			i = inicializacionVar.getDotTree(i, nodoActual, dec, rel);
		}
		dec.add("n" + ( ++i ) + "[label=\"condicion\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = condicion.getDotTree(i, i, dec, rel);

		dec.add("n" + ( ++i ) + "[label=\"bloque\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = bloque.getDotTree(i, i, dec, rel);
		
		return i;
	}

	public String print(String padding){
		String str = padding + tipoCiclo + "\n";
		if(inicializacionVar != null) {
			str += inicializacionVar.print(padding + "\t");
		}
		if(condicion != null) {
			str += condicion.print(padding + "\t");
		}
		if(bloque != null) {
			str += bloque.print(padding + "\t");
		}
		return str;
	}
} 

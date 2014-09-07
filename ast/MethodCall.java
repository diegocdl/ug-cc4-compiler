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

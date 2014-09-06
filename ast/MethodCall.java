package compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class MethodCall extends Node {
	
	public String nameMethod;
	public List<Node> expresiones;

	/* para method_decl */
	public MethodCall(String name, List<Node> ex){
		this.nameMethod = name;
		this.expresiones = ex;
	}

	public void print(String padding) {
		System.out.println(padding + "Llamada ");
		if(expresiones != null){
			for ( Node e : expresiones ) {
				e.print(padding + "\t");
			}
		} else {
			System.out.println(padding + "\t" +nameMethod);
		}
	}

}

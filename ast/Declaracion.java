package compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class Declaracion extends Node {
	
	public String type;

	// para method_decl
	public String nameMethod;
	public Node bloque;

	// para field_decl
	public List<VarLiteral> nameFields;

	/* para method_decl */
	public Declaracion(String type, String name, Node bloque){
		this.type = type;
		this.nameMethod = name;
		this.bloque = bloque;
		this.nameFields = null;
	}

	public Declaracion(String type, List<VarLiteral> names){
		this.type = type;
		this.nameFields = names;
		this.nameMethod = null;
		this.bloque = null;
	}

	public void print(String padding) {
		System.out.println(padding + "Declaracion ");
		System.out.println(padding + "\t" + type);
		if(nameFields != null){
			for ( VarLiteral v : nameFields ) {
				v.print(padding + "\t");
			}
		} else {
			System.out.println(padding + "\t" +nameMethod);
		}
		if(bloque != null){
			bloque.print(padding + "\t");
		}
	}

}
package compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class Declaracion extends Node {
	
	public static final String CALLOUT = "callout";
	public static final String METODO = "metodo";
	public static final String FIELD = "field";
	public static final String PARAMETRO = "parametro";
	 

	public String type;
	public String typeDec;

	// para method_decl
	public String nameMethod;
	public Node bloque;
	public LinkedList<Declaracion> parametros;

	// para field_decl
	public List<VarLiteral> nameFields;
	
	// para callout_decl
	public String id;

	public Declaracion(String id){
		this.typeDec = CALLOUT;
		this.nameMethod = "callout";
		this.id = id;
		this.type="";
	}
	
	public Declaracion(String type, String name, LinkedList<Declaracion> listaparametros, Node bloque){
		this.type = type;
		this.typeDec = METODO;
		this.nameMethod = name;
		this.bloque = bloque;
		this.parametros = listaparametros;
		this.nameFields = null;
		this.id = null;
	}
	
	public Declaracion(String type, List<VarLiteral> names, String tp){
		this.type = type;
		this.nameFields = names;
		this.typeDec = tp;
		this.parametros = null;
		this.nameMethod = null;
		this.bloque = null;
		this.id = null;
	}

	public void print(String padding) {
		System.out.println(padding + typeDec);
		if(type != null) System.out.println(padding + "\t" + type);
		if(nameFields != null){
			for ( VarLiteral v : nameFields ) {
				v.print(padding + "\t");
			}
		} else {
			System.out.println(padding + "\t" +nameMethod);
		}
		if(parametros != null){
			for(Declaracion d : parametros){
				d.print(padding + "\t");
			}
		}
		if(bloque != null){
			bloque.print(padding + "\t");
		}
		if(id != null){
			System.out.println(padding + "\t" + id);
		}
	}

}

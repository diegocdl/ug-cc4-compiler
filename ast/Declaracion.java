package compiler.ast;

import java.util.LinkedList;
import java.util.List;

public class Declaracion extends Node {
	
	public String type;
	public String type2;
	// para method_decl
	public String nameMethod;
	public Node bloque;
	public LinkedList<Declaracion> parametros;

	// para field_decl
	public List<VarLiteral> nameFields;

	public Declaracion(String type, String name, LinkedList<Declaracion> listaparametros, Node bloque){
		this.type = type;
		this.type2 = "Declaracion";
		this.nameMethod = name;
		this.bloque = bloque;
		this.parametros = listaparametros;
		this.nameFields = null;
	}
	
	public Declaracion(String type, List<VarLiteral> names){
		this.type = type;
		this.nameFields = names;
		this.parametros = null;
		this.nameMethod = null;
		this.bloque = null;
		if(names.size() == 1){
			this.type2 = "Parametro";
		}else{
			this.type2 = "Declaracion";
		}
	}

	public void print(String padding) {
		System.out.println(padding + type2);
		System.out.println(padding + "\t" + type);
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
	}

}

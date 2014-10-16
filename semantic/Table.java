package compiler.semantic;

import java.util.Hashtable;

/**
*	Representa una tabla de simbolos de un scope
*/
public class Table {

	/**
	*	Hastable que guarda todas las variables y metos del scope el
	*	key es el nombre del metodo o variable y el value es un objeto
	*	tipo que contiene el tipo y si es metodo los posibles parametros
	*/
	public Hashtable<String,Tipos> tabla;

	/**
	*	nombre de la tabla este debe ser unico
	*/
	public String name;

	/**
	*	Nombre de la tabla padre
	*/
	public String parent;
	
	/**
	*	Constructor que inizaliza la tabla
	*	@param name Nombre de la tabla este debe ser unico
	*	@param parent Nombre de la tabla padre
	*/
	public Table(String name, String parent){
		this.name = name;
		this.parent = parent;
		this.tabla = new Hashtable<String,Tipos>();
	}
	
	
	/**
	*	Retorna un String con el nombre de la tabla, el nombre de la tabla padre y los valores de la tabla
	*	@return String con el nombre de la tabla, el nombre de la tabla padre y los valores de la tabla
	*/
	public String toTableString(){
		String str = "\nTABLA: " + this.name + "\nPADRE: " + this.parent + "\n" + this.tabla.toString();
		return str;
	}

	/**
	*	Retorna el nombre de la tabla
	*	@return nombre de la tabla
	*/
	public String getName() {
		return name;
	}

	/**
	*	{@inheritDoc}
	*/
	@Override
	public String toString() {
		String str = "\n----------------------------------------\n";
		str += "Parent: " + ((parent != null)? parent : "null") + "\n";
		str += "Name: " + name + "\n";
		str += "\t\t" + tabla.toString() + "\n";
		return str;
	}
}

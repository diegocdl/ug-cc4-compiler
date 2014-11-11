package compiler.semantic;

import java.util.Hashtable;
import java.util.Enumeration;

/**
*	Representa una tabla de simbolos de un scope
*/
public class Table {

	/**
	*	Hastable que guarda todas las variables y metos del scope el
	*	key es el nombre del metodo o variable y el value es un objeto
	*	tipo que contiene el tipo y si es metodo los posibles parametros
	*/
	private  Hashtable<String,Tipos> tabla;

	/**
	*	nombre de la tabla este debe ser unico
	*/
	public String name;

	/**
	*	Nombre de la tabla padre
	*/
	public String parent;

	/**
	*	Cantidad de variables
	*/
	public int cantidad;
	
	/**
	*	Constructor que inizaliza la tabla
	*	@param name Nombre de la tabla este debe ser unico
	*	@param parent Nombre de la tabla padre
	*/
	public Table(String name, String parent) {
		cantidad = 0;
		this.name = name;
		this.parent = parent;
		this.tabla = new Hashtable<String,Tipos>();
	}
	
	
	public Tipos put(String key, Tipos value) {
		// Tipos res = null;
		Tipos res = tabla.put(key, value);
		System.out.println(value.getTipoParametros());
		if(value.getTipoParametros() == null){
			value.setNumber(cantidad);
			// se suma la cantidad de posiciones que tenga el arreglo 
			// en el caso de una variable sera igual a 1
			cantidad += value.getDimension();
		}
		return res;
	}

	public boolean containsKey(String key) {
		return tabla.containsKey(key);
	}

	public Tipos get(String key) {
		return tabla.get(key);
	}

	/**
	*	Retorna la cantidad de variables que existen en la tabla
	*/
	public int getCantidadVariables() {
		return cantidad;
	}

	/**
	*	Retorna un String con el nombre de la tabla, el nombre de la tabla padre y los valores de la tabla
	*	@return String con el nombre de la tabla, el nombre de la tabla padre y los valores de la tabla
	*/
	public String toTableString() {
		String str = "\nTABLA: " + this.name; 
		str += "\nPADRE: " + this.parent;
		str += "\nCANTIDAD VARIABLES: " + this.cantidad + "\n";
		Enumeration<String> keys = tabla.keys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			str += "\t" + key + ": " + tabla.get(key) + "\n";
		}
		return str;
	}


	/**
	*	Retorna la posicion de memoria en el Starck de la variable
	*	@param symbolTable 	Contenedor de tablas de simbolos
	*	@param var variable para buscar su poscion
	*/
	public int getPositionVar(SymbolTable symbolTable, String var) {
		if(tabla.containsKey(var)) {
			return (4*tabla.get(var).getNumber());
		} else {
			if(!parent.equals("NULL")) {
				return cantidad*4 + symbolTable.searchByName(parent).getPositionVar(symbolTable, var);
			} else {
				return -1;
			}
		}
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
		// str += "\t\t" + tabla.toString() + "\n";
		Enumeration<String> keys = tabla.keys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			str += key + ": " + tabla.get(key) + "\n";
		}
		return str;
	}
}

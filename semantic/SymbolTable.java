package compiler.semantic;

import java.util.ArrayList;

/**
*	Guarda todas las tablas de los scopes del programa
*/
public class SymbolTable{
	
	/** 
	*	Listado con las las tablas
	*/
	public ArrayList<Table> listaTablas;
	
	/**
	*	Constructor sin parametros que Inicializa la lista
	*/
	public SymbolTable(){
		listaTablas = new ArrayList<Table>();
	}

}

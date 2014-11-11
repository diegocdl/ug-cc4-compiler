package compiler.semantic;

import java.util.ArrayList;
import compiler.irt.RegisterManager;

/**
*	Guarda todas las tablas de los scopes del programa
*/
public class SymbolTable{
	
	/** 
	*	Listado con las las tablas
	*/
	public ArrayList<Table> listaTablas;

	public RegisterManager registerManager;
	
	/**
	*	Constructor sin parametros que Inicializa la lista
	*/
	public SymbolTable(){
		listaTablas = new ArrayList<Table>();
		registerManager = new RegisterManager();
	}


	public Table searchByName(String name) {
		for (Table t : listaTablas) {
			if(t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	public RegisterManager getRegisterManager() {
		return registerManager;
	}

}

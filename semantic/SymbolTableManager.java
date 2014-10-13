package compiler.semantic;

import java.util.Hashtable;

public class SymbolTableManager{
	
	private Hashtable<Integer, Table> listaTablas;

	
	public SymbolTableManager(){
		listaTablas = new Hashtable<Integer, Table>();
	}

	public void addTable(int idNodo, Table table){
		listaTablas.put(idNodo, table);
	}

	public Table findTableById(int idNodo){
		return listaTablas.get(idNodo);
	}

	@Override
	public String toString(){
		return listaTablas.toString();
	}

}

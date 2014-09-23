package compiler.semantic;

import java.util.Hashtable;

public class Table{
	
	public Hashtable<String, String> tabla;
	public String name;
	public Table parent;
	
	public Table(String name, Table parent){
		this.name = name;
		this.parent = parent;
		this.tabla = new Hashtable<String, String>();
	}

	public void put(String name, String type){
		tabla.put(name, type);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString(){
		String str = "\n----------------------------------------\n";
		str += "Parent: " + ((parent != null)? parent.getName() : "null") + "\n";
		str += "Name: " + name + "\n";
		str += "\t\t" + tabla.toString() + "\n";
		return str;
	}
}

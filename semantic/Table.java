package compiler.semantic;

import java.util.Hashtable;

public class Table {
	public Hashtable<String,Tipos> tabla;
	public String name;
	public String parent;
	
	public Table(String name, String parent){
		this.name = name;
		this.parent = parent;
		this.tabla = new Hashtable<String,Tipos>();
	}
	
	//@Override
	public String toTableString(){
		String str = "\nTABLA: " + this.name + "\nPADRE: " + this.parent + "\n" + this.tabla.toString();
		return str;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString(){
		String str = "\n----------------------------------------\n";
		str += "Parent: " + ((parent != null)? parent : "null") + "\n";
		str += "Name: " + name + "\n";
		str += "\t\t" + tabla.toString() + "\n";
		return str;
	}
}

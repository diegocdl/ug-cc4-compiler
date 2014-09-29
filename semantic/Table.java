package compiler.semantic;

import java.util.*;

public class Table{
	
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

}

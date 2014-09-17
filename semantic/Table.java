package compiler.semantic;

import java.util.*;

public class Table{
	
	public Hashtable tabla;
	public String name;
	public String parent;
	
	public Table(String name, String parent){
		this.name = name;
		this.parent = parent;
		this.tabla = new Hashtable();
	}

}

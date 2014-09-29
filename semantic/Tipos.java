package compiler.semantic;

import java.util.LinkedList;
import compiler.ast.*;

public class Tipos{

	public String tipo;
	public LinkedList<String> tiposparametros;
	
	public Tipos(String t, LinkedList<Declaracion> dec){
		this.tipo = t;
		this.tiposparametros = new LinkedList<String>();
		for (Declaracion d : dec){
			this.tiposparametros.add(d.type);
		}
	}
	
	public Tipos(String t){
		this.tipo = t;
		this.tiposparametros = null;
	}
	
	public String toString(){
		String str = "";
		str = str + this.tipo;
		if(this.tiposparametros != null){
		str = str + " - " + this.tiposparametros.toString();
		}
		return str;
	}

}

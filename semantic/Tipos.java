package compiler.semantic;

import java.util.LinkedList;
import compiler.ast.*;

/**
*	Contiene el tipo de variable o de metodo y si es metodo guarda sus tipos de parametros
*/
public class Tipos{

	/**
	*	Tipo de metodo o parametro
	*/
	public String tipo;

	/**
	*	Lista de tipos de tipos de parametros del metodo
	*/
	public LinkedList<String> tiposparametros;
	
	/**
	*	Constructor de Tipos para metodo recibe dos parametros
	*	@param t 	tipo de valor de retorno del metodo
	*	@param dec 	Lista con tipos de parametros del metodo
	*/
	public Tipos(String t, LinkedList<Declaracion> dec){
		this.tipo = t;
		this.tiposparametros = new LinkedList<String>();
		for (Declaracion d : dec){
			this.tiposparametros.add(d.type);
		}
	}
	
	/**
	*	Constructor de Tipos para variables solo recibe tipo de variable
	*	@param t 	tipo de variable
	*/
	public Tipos(String t){
		this.tipo = t;
		this.tiposparametros = null;
	}
	
	/**
	*	{@inheritDoc}
	*/
	@Override
	public String toString(){
		String str = "";
		str = str + this.tipo;
		if(this.tiposparametros != null){
		str = str + " - " + this.tiposparametros.toString();
		}
		return str;
	}

}

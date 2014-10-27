package compiler.ast.nodes;

import java.util.LinkedList;
import java.util.List;
import compiler.semantic.*;
import compiler.irt.IrtList;

public class MethodCall extends Node {
	
	public String nameMethod;
	public LinkedList<Node> expresiones;

	/**
	*	Constructor de clase
	*	@param name 	Nombre de metodo
	*	@param ex 		parametros
	*/
	public MethodCall(String name, LinkedList<Node> ex){
		this.nameMethod = name;
		this.expresiones = ex;
	}

	/**
	*	Verifica los tipos de los paremetros de una llamada a metodo
	*	@param 	tb 			tabla del scope al que peretenece la operacion
	*	@param 	st 			Listado de todas las tablas
	*	@param 	errorList 	Lista de errores
	*	@return tipo de dato que retorna el metodo
	*/
	public String checkMethodCall(Table tb, SymbolTable st, LinkedList<String> errorList){
		boolean p = false;
		String resultado = "";
		LinkedList<String> lista = new LinkedList<String>();
		Table tabla = null;
		for (Node n : this.expresiones){
			if (n instanceof Exp){
				Exp ex = (Exp)n;
				lista.add(ex.checkExp(tb,st,errorList));
			}else if (n instanceof Literal){
				Literal lit = (Literal)n;
				lista.add(lit.checkLiteral(tb,st));
			}else if (n instanceof BinOp){
				BinOp bin = (BinOp)n;
				lista.add(bin.checkBinOp(tb,st,errorList));
			}
		}
		
		for (Table t : st.listaTablas){
			if (t.name.equals("ROOT")){
				tabla = t;
			}
		}
		if (tabla.containsKey(this.nameMethod) == true){
			resultado = tabla.get(this.nameMethod).tipo;
			//System.out.println("----> " + lista.toString());
			//System.out.println("----> " + tabla.tabla.get(this.nameMethod).tiposparametros.toString());
			if (lista.size() != tabla.get(this.nameMethod).tiposparametros.size()){
				//System.out.println("Error en el numero de argumentos");
				errorList.add("Error en el numero de argumentos en el Metodo " + this.nameMethod);
			}
			if (!lista.equals(tabla.get(this.nameMethod).tiposparametros)){
				//System.out.println("parametro invalido en la llamada a " + this.nameMethod);
				errorList.add("parametro invalido en la llamada a " + this.nameMethod);
			}
		}else{
			//System.out.println(this.nameMethod + "es un metodo no declarado");
			errorList.add(this.nameMethod + "es un metodo no declarado");
		}
		return resultado;
	}
	
	/**
	*	{@inheritDoc}
	*/
	@Override
	public String print(String padding) {
		String str = padding + "Llamada " +  nameMethod + "\n";
		if(expresiones != null){
			for ( Node e : expresiones ) {
				str += e.print(padding + "\t");
			}
		}
		return str;
	}
	
	/**
	*	{@inheritDoc}
	*/
	@Override
	public String toString(){
		return "Method Call";
	}

	/**
	*	{@inheritDoc}
	*/
	@Override
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"" + nameMethod + "\"];");
		rel.add("n" + parent + " -> n" + i);		
		return i;
	}

	/**
	*	{@inheritDoc}
	*/
	@Override
	public IrtList destruct(String parent, SymbolTable  symbolTable) {
		IrtList irtList = new IrtList();
		return irtList;
	}
}

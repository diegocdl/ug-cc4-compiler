package compiler.ast;

import java.util.List;
import java.util.regex.*;
import compiler.semantic.*;

public class Literal extends Node {
	/*char, string, Int, hex */ 
	public String value;
	
	public Literal(String s){
		super();
		this.value = s;
	}
	
	@Override
	public String print(String padding){
		return padding + value + "\n";
	}

	public String checkLiteral(Table tb, SymbolTable st){
		String resultado = "";
		if(Pattern.matches("[0-9]+",this.value)){
			resultado = "int";
		}else if(Pattern.matches("0x([0-9]|[A-F]|[a-f])+",this.value)){
			resultado = "int";
		}else if(Pattern.matches(".",this.value)){
			resultado = "char";
		}else if ((this.value.equals("\'"))||(this.value.equals("\""))||(this.value.equals("\\"))||(this.value.equals("\t"))||(this.value.equals("\n"))){
			resultado = "char";
		}else if ((this.value.equals("true"))||(this.value.equals("false"))){
			resultado = "boolean";
		}
		return resultado;
	}
	
	@Override
	public String toString(){
		return value;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"" + value + "\"];");
		rel.add("n" + parent + " -> n" + i);		

		// if(tipoCiclo.equals(FOR)){
		// 	dec.add("n" + ( ++i ) + "[label=\"exp\"];");
		// 	rel.add("n" + nodoActual + " -> n" + i);		
		// 	i = inicializacionVar.getDotTree(nodoActual, dec, rel);
		// }
		// dec.add("n" + ( ++i ) + "[label=\"condicion\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = condicion.getDotTree(i, dec, rel);

		// dec.add("n" + ( ++i ) + "[label=\"bloque\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = bloque.getDotTree(i, dec, rel);
		
		return i;
	}
} 

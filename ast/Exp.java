package compiler.ast;

import java.util.List;

public class Exp extends Node{
	/* location or method_call */
	public Node expr;
	/* MINUS or NEGATION del expr */
	public String exprModifier;

	/* indica si la expresion se encuentra dentro de parentecis */
	public boolean parentesis;
	
	public Exp(String s, boolean parentesis, Node expr) {
		this.expr = expr;
		this.exprModifier = s;
		this.parentesis = parentesis;
	}
	
	public Exp(String s, Node expr) {
		this(s, false, expr);
	}

	public Exp(boolean parentesis, Node expr) {
		this("", false, expr);
	}

	public Exp(Node expr){
		this("", false, expr);
	}
	
	public void print(String padding){
		if(!(exprModifier.equals(""))){
			System.out.println(padding + "\t" + exprModifier);
		}
		if(parentesis) System.out.print('(');
		if(expr != null) expr.print(padding + "\t");
		if(parentesis) System.out.print(')');
	}

	public int getDotTree(int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		// dec.add("n" + ( ++i ) + "[label=\"Declaracion\"];");
		// rel.add("n" + nodoActual + " -> n" + i);		

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
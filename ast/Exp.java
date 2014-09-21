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
	
	@Override
	public String print(String padding){
		String str = "";
		if(!(exprModifier.equals(""))){
			str = padding + exprModifier + "\n";
		}
		if(parentesis) {
			str += '(';
		}
		if(expr != null) {
			str += expr.print(padding);
		}
		if(parentesis) {
			str += ')';
		}
		return str;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;

		// dec.add("n" + ( ++i ) + "[label=\"Expresion\"];");
		// rel.add("n" + nodoActual + " -> n" + i);		
		if(exprModifier.equals("")){
			// dec.add("n" + ( ++i ) + "[label=\"Expresion\"];");
			// rel.add("n" + nodoActual + " -> n" + i);		
			i = expr.getDotTree(parent, i, dec, rel);
		}else{
			dec.add("n" + ( ++i ) + "[label=\"" + exprModifier + "\"];");
			rel.add("n" + nodoActual + " -> n" + i);		
			// dec.add("n" + ( ++i ) + "[label=\"Expresion\"];");
			// rel.add("n" + nodoActual + " -> n" + i);		
			i = expr.getDotTree(i, i, dec, rel);
		}
		
		return i;
	}
} 

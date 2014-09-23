package compiler.ast;

import java.util.List;
import compiler.semantic.*;

public class Statement extends Node{
	/* continue, break, return */
	public String keyword;
	/* valor a retornar */
	public Node value;
	
	public Statement(String k, Node n1){
		super();
		this.keyword = k;
		this.value = n1;
	}

	public Statement(String k){
		this(k, null);
	}
	
	@Override
	public String print(String padding){
		String str = padding + keyword + "\n";
		if(value != null){
			str += value.print(padding + "\t");
		}
		return str;
	}

	public void checkStatement(Table tb){
	
	}
	
	@Override
	public String toString(){
		return "Statement";
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"Statement\"];");
		rel.add("n" + parent + " -> n" + i);		
		if (value==null){
			dec.add("n" + ( ++i ) + "[label=\"" + keyword +"\"];");
			rel.add("n" + (parent + 1) + " -> n" + i);		
		}else{
			dec.add("n" + ( ++i ) + "[label=\"" + keyword +"\"];");
			rel.add("n" + (parent + 1) + " -> n" + i);	
			i = value.getDotTree(parent+1, nodoActual, dec, rel);			
		}
		return i;
	}
} 

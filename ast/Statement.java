package compiler.ast;

public class Statement extends Node{
	/* continue, break, return */
	public String keyword;
	/* valor a retornar */
	public Node value;
	
	public Statement(String k){
		this(k, null);
	}
	
	public Statement(String k, Node n1){
		this.keyword = k;
		this.value = n1;
	}
	
	public void print(String padding){
		System.out.println(padding + value);
		if(value != null){
			value.print(padding + "\t");
		}
	}
} 
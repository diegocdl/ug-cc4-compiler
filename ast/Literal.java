package compiler.ast;

public class Literal extends Node {
	/*char, string, Int, hex */ 
	public String value;
	
	public Literal(String s){
		this.value = s;
	}
	
	public void print(String padding){
		System.out.println(padding + value);
	}
} 
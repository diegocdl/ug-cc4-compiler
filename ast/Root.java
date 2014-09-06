package compiler.ast;

import java.util.List;
import java.util.LinkedList;

public class Root extends Node{

	public LinkedList<Node> declaraciones;
	
	public Root(){
		declaraciones = new LinkedList<Node>();
	}
	
	public void add(Node node){
		declaraciones.add(node);
	}
	
	public void print(String padding){
		System.out.println("Root");
		for(Node n : declaraciones){
			if(n != null) n.print("\t" + padding);
		}
	}
	
	public void print(){
		print("");
	}
	
} 
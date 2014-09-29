package compiler.ast;

import java.util.List;

public abstract class Node{

	private static int correlativo = 0;
	protected int id;

	public Node(){
		id = correlativo++;
	}
	
	public abstract String print(String padding);
	public abstract int getDotTree(int parent, int i, List<String> dec, List<String> rel);
}  

package compiler.ast;

import java.util.List;

public abstract class Node{
	public abstract void print(String padding);
	public abstract int getDotTree(int i, List<String> dec, List<String> rel);


} 

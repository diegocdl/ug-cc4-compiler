package compiler.ast;

import java.util.List;

public abstract class Node{

	public abstract String print(String padding);
	public abstract int getDotTree(int parent, int i, List<String> dec, List<String> rel);

} 
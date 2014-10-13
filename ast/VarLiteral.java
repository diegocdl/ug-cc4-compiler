package compiler.ast;

import java.util.List;
import java.util.LinkedList;
import compiler.semantic.*;

public class VarLiteral extends Node {
	
	public String name;
	public Node dimension;

	public VarLiteral(String name, int dim){
		this.name = name;
		this.dimension = new Literal(Integer.toString(dim));
	}

	public VarLiteral(String name, Node n){
		this.name = name;
		this.dimension = n;
	}

	public VarLiteral(String name){
		this.name = name;
		this.dimension = null;
	}

	@Override
	public String print(String padding){
		String str = padding + "VarLiteral\n";
		str += "\t" + padding + name + "\n";
		if(dimension != null){
			str += dimension.print(padding + "\t");
		}
		return str;
	}

	@Override
	public String toString(){
		if (dimension != null)
			return name + " " + dimension;
		else
			return name;
	}

	public String checkVarLiteral(Table tb, SymbolTable st, LinkedList<String> errorList){
		String resultado = "";
		boolean b = false;
		if (tb.tabla.containsKey(this.name) == false){
			Table tableaux = tb;
			Table tableaux2 = null;
			while(!(tableaux.parent.equals("NULL")) && !b){
				for (int i=0; i<st.listaTablas.size(); i++){
					tableaux2 = st.listaTablas.get(i);
					if (tableaux2.name.equals(tableaux.parent)){
						if (tableaux2.tabla.containsKey(this.name) == true){
							if (this.dimension != null){
								if (this.dimension instanceof Exp){
									Exp expr2 = (Exp)this.dimension;
									resultado = expr2.checkExp(tb,st,errorList);
								}else if (this.dimension instanceof BinOp){
									BinOp bo2 = (BinOp)this.dimension;
									resultado = bo2.checkBinOp(tb,st,errorList);
								}else if (this.dimension instanceof Literal){
									Literal lit2 = (Literal)this.dimension;
									resultado = lit2.checkLiteral(tb,st);
								}
							}else{
								resultado = tableaux2.tabla.get(this.name).tipo;
							}
							//System.out.println(tableaux2.name);
							i=st.listaTablas.size();
							b = true;
						}else{tableaux = tableaux2;i=st.listaTablas.size();}
					}
				}
			}
		}else{
			if (this.dimension != null){
				if (this.dimension instanceof Exp){
					Exp expr2 = (Exp)this.dimension;
					resultado = expr2.checkExp(tb,st,errorList);
				}else if (this.dimension instanceof BinOp){
					BinOp bo2 = (BinOp)this.dimension;
					resultado = bo2.checkBinOp(tb,st,errorList);
				}else if (this.dimension instanceof Literal){
					Literal lit2 = (Literal)this.dimension;
					resultado = lit2.checkLiteral(tb,st);
				}
			}else {
				resultado = tb.tabla.get(this.name).tipo;
			}
		}
		return resultado;
	}
	

	public String getName() {
		return name;
	}

	public boolean isArray(){
		return dimension != null;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"VarLiteral\"];");
		rel.add("n" + (parent ) + " -> n" + i);

		dec.add("n" + ( ++i ) + "[label=\""+ name +"\"];");
		rel.add("n" + (nodoActual + 1) + " -> n" + i);


		if(dimension != null) {
			i = dimension.getDotTree(parent+1, i, dec, rel);
		}

		return i;
	}
}
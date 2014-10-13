package compiler.ast;

import java.util.List;
import java.util.LinkedList;
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

	public String checkStatement(Table tb, SymbolTable st, LinkedList<String> errorList){
		String resultado = "";
		if (this.keyword.equals("return")){
			if (this.value instanceof Exp){
				Exp expr = (Exp)this.value;
				resultado = expr.checkExp(tb,st,errorList);
			}else if (this.value instanceof BinOp){
				BinOp bo = (BinOp)this.value;
				resultado = bo.checkBinOp(tb,st,errorList);
			}else if (this.value instanceof Literal){
				Literal lit = (Literal)this.value;
				resultado = lit.checkLiteral(tb,st);
			}
		}
		return resultado;
	}
	
	//Devuelve true si el break o continue esta bien
	public boolean checkBreakContinue(Table tb, SymbolTable st){
		boolean b = true;
		Table tableaux = tb;
		Table tableaux2 = null;
		if ((this.value == null) &&  ((this.keyword.equals("break")) || (this.keyword.equals("continue")))){
			b = false;
			while(!(tableaux.parent.equals("NULL")) && !b){
				if (tableaux.name.matches("CICLO_[0-9]+")){
					b = true;
					break;
				}
				for (int i=0; i<st.listaTablas.size(); i++){
					tableaux2 = st.listaTablas.get(i);
					if (tableaux2.name.equals(tableaux.parent)){
						tableaux = tableaux2;
						i=st.listaTablas.size();
					}
				}
			}
		}
		return b;
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

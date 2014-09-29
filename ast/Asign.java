package compiler.ast;

import java.util.List;
import compiler.semantic.*;

public class Asign extends Node{
	public Node id;
	public String asig;
	public Node value;
	
	public Asign(Node id, String asig, Node value){
		this.id = id;
		this.asig = asig;
		this.value = value;
	}
	
	@Override
	public String print(String padding){
		String str = padding + asig+"\n";
		str += id.print(padding + "\t");
		if(value != null){
			str += value.print(padding + "\t");
		}
		return str;
	}

	public void checkAsign(Table tb, SymbolTable st){
		boolean prueba = true;
		String verificacion = "", tipo = "";
		if (this.id instanceof VarLiteral){
			VarLiteral var = (VarLiteral)this.id;
			boolean declaracion = false;
			boolean b = false;
			boolean no = false;
			if (var.dimension == null){
				if (this.value instanceof Exp){
					Exp expr = (Exp)this.value;
					//System.out.println("Estoy en Exp");
					verificacion = expr.checkExp(tb,st);
				}else if (this.value instanceof Statement){
					Statement stm = (Statement)this.value;
					stm.checkStatement(tb,st);
				}else if (this.value instanceof BinOp){
					BinOp bo = (BinOp)this.value;
					//System.out.println("Estoy en BinOp");
					verificacion = bo.checkBinOp(tb,st);
					//System.out.println(verificacion);
				}else if (this.value instanceof Literal){
					Literal lit = (Literal)this.value;
					verificacion = lit.checkLiteral(tb,st);
				}
			if (tb.tabla.containsKey(var.name) == false){
				Table tableaux = tb;
				Table tableaux2 = null;
				while(!(tableaux.parent.equals("NULL")) && !b){
				
					for (int i=0; i<st.listaTablas.size(); i++){//(Table t : st.listaTablas){
						//if (b){
						tableaux2 = st.listaTablas.get(i);
						if (tableaux2.name.equals(tableaux.parent)){
							
							if (tableaux2.tabla.containsKey(var.name) == true){
								declaracion = true;
								tipo = tableaux2.tabla.get(var.name).tipo;
								//System.out.println("si " + tipo);
								//System.out.println(tableaux2.name);
								if (this.asig.equals("=")){
									if (!tipo.equals(verificacion)){
										System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
									}
								}else {
									if ((!tipo.equals("int")) || (!verificacion.equals("int"))){
										System.out.print("error de tipos: " + tipo + " " + this.asig + " " + verificacion);
									}
								}
								i=st.listaTablas.size();
								b = true;
							}else{tableaux = tableaux2;i=st.listaTablas.size();}
							//b=false;}
						}
						//}
					}
				}
			}else{
				declaracion = true;
				tipo = tb.tabla.get(var.name).tipo;
				if (!tipo.equals(verificacion)){
					System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
				}
			}
			if (!declaracion){
				System.out.println(var.name + " no esta declarada");		
			}
			}
			
		}
	}
	
	@Override
	public String toString(){
		return "Asignacion";
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel) {
		int nodoActual = i;

		// dec.add("n" + ( ++i ) + "[label=\"ID\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		dec.add("n" + (++i) + "[label=\"" + asig + "\"];");
		rel.add("n" + (parent) + " -> n" + i);
		i = id.getDotTree(parent+1, i, dec, rel);
		i = value.getDotTree(parent+1, i, dec, rel);
		return i;
	}


} 

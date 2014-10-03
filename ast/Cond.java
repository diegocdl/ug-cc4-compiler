package compiler.ast;

import java.util.List;
import compiler.semantic.*;

public class Cond extends Node{

	private static int correlativo = 0;
	protected int id;
	public Node condicion;
	public Node consecuencia;
	public Node alternativa;
	
	public Cond(Node condicion, Node consecuencia){
		this(condicion, consecuencia, null);
	}
	
	public Cond(Node condicion, Node consecuencia, Node alternativa){
		this.id = correlativo++;
		this.condicion = condicion;
		this.consecuencia = consecuencia;
		this.alternativa = alternativa;
	}
	
	public void checkCond(Table tab, Table tb, String nombre, SymbolTable st){
		boolean condicionValida = false;
		String verificacionCondicion = "";
		if (this.condicion instanceof Exp){
			Exp expr = (Exp)this.condicion;
			expr.checkExp(tab,st);
		}else if (this.condicion instanceof Literal){
			Literal lit = (Literal)this.condicion;
			verificacionCondicion = lit.checkLiteral(tab,st);
		}else if (this.condicion instanceof BinOp){
			BinOp bo = (BinOp)this.condicion;
			verificacionCondicion = bo.checkBinOp(tab,st);
		}
		if (verificacionCondicion.equals("boolean")){
			condicionValida = true;
		}
		if (condicionValida){
		Root rt = (Root)this.consecuencia;
		for (Node n : rt.declaraciones){
			if (n instanceof Declaracion){
				Declaracion decl = (Declaracion)n;
				for(VarLiteral vl : decl.nameFields){
						if (tb.tabla.containsKey(vl.name) == false){
							tb.tabla.put(vl.name,new Tipos(decl.type));
						}
					}
			}else if (n instanceof Asign){
				Asign as = (Asign)n;
				as.checkAsign(tb,st);
			}else if (n instanceof MethodCall){
				MethodCall mc = (MethodCall)n;
				mc.checkMethodCall(tb,st);
			}else if (n instanceof Cond){
				Cond c = (Cond)n;
				Table t = new Table("IF_"+c.id, nombre);
				st.listaTablas.add(t);
				c.checkCond(tb,t,"IF_"+c.id,st);
			} else if (n instanceof Cycle) {
				Cycle cy = (Cycle)n;
				// si es un for verifica la existencia y los tipos de la inicializacion de variablesz
				if (cy.tipoCiclo.equals(Cycle.FOR)) {
					Asign init = (Asign)cy.inicializacionVar;
					init.checkAsign(tb,st);
				}
				Table t = new Table("CICLO_"+cy.id, nombre);
				st.listaTablas.add(t);
				cy.checkCycle(t,"CICLO_"+cy.id,st);
			}else if (n instanceof Statement){
				Statement state = (Statement)n;
				//state.checkStatement(tb,st);
				if (state.checkBreakContinue() == true){
					System.out.println("no puede haber un break o continue fuera de un For o While");
				}
			}
		}
		if (this.alternativa != null){
			Root rt2 = (Root)this.consecuencia;
			for (Node n : rt2.declaraciones){
				if (n instanceof Declaracion){
					Declaracion decl = (Declaracion)n;
					for(VarLiteral vl : decl.nameFields){
						if (tb.tabla.containsKey(vl.name) == false){
							tb.tabla.put(vl.name,new Tipos(decl.type));
						}
					}
				}else if (n instanceof Asign){
					Asign as = (Asign)n;
					as.checkAsign(tb,st);
				}else if (n instanceof MethodCall){
					MethodCall mc = (MethodCall)n;
					mc.checkMethodCall(tb,st);
				}else if (n instanceof Cond){
					Cond c = (Cond)n;
					Table t = new Table("IF_"+c.id, nombre);
					st.listaTablas.add(t);
					c.checkCond(tb,t,"IF_"+c.id,st);
				}else if (n instanceof Cycle){
					Cycle cy = (Cycle)n;
					Asign init = (Asign)cy.inicializacionVar;
					init.checkAsign(tb,st);
					Table t = new Table("CICLO_"+cy.id, nombre);
					st.listaTablas.add(t);
					cy.checkCycle(t,"CICLO_"+cy.id,st);
				}else if (n instanceof Statement){
					Statement state = (Statement)n;
					//state.checkStatement(tb,st);
					if (state.checkBreakContinue() == true){
					System.out.println("no puede haber un break o continue fuera de un For o While");
					}
				}
			}
		}
		}else{System.out.println("Condicion invalida");}
	}
	
	@Override
	public String toString(){
		return "Cond";
	}
	
	@Override
	public String print(String padding){
		String str = padding + "If\n";
		if(condicion != null) {
			str += condicion.print(padding + "\t");
		}
		if(consecuencia != null) {
			str += consecuencia.print(padding + "\t");
		}
		if(alternativa != null){
			str += padding + "\tElse\n";
			str += alternativa.print(padding + "\t");
		}
		return str;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\"if\"];");
		rel.add("n" + nodoActual + " -> n" + i);		
		i = condicion.getDotTree(i, nodoActual, dec, rel);

		dec.add("n" + ( ++i ) + "[label=\"ID\"];");
		rel.add("n" + nodoActual + " -> n" + i);

		// dec.add("n" + ( ++i ) + "[label=\"Exp\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = hijo1.getDotTree(i, dec, rel);		
		
		return i;
	}
} 

 package compiler.ast;

import java.util.List;
import java.util.LinkedList;
import compiler.semantic.*;
/*
	for(<id> = <expr>, <expr>) <block>
	while (<expr>) <block>

*/
public class Cycle extends Node{

	public static final String FOR = "for";
	public static final String WHILE = "while";
	private static int correlativo = 0;
	protected int id;

	public String tipoCiclo;
	
	/* la inicializacion de variable solo se usara en el for */
	public Node inicializacionVar;
	public Node condicion;
	public Node bloque;
	
	public Cycle(String tipo, Node inicializacionVar, Node condicion, Node bloque){
		super();
		this.inicializacionVar = inicializacionVar;
		this.condicion = condicion;
		this.bloque = bloque;
		this.tipoCiclo = tipo;
		this.id = correlativo++;
	}
	

	public Cycle(Node inicializacionVar, Node condicion, Node bloque){
		this(FOR, inicializacionVar, condicion, bloque);
	}

	/**
	*	Constructor para ciclos while
	* 	@param condicion
	* 	@param bloque
	*/
	public Cycle(Node condicion, Node bloque){
		this(WHILE, null, condicion, bloque);
	}
	
	public void checkCycle(Table tb, String nombre, SymbolTable st, LinkedList<String> errorList){
		if (this.tipoCiclo.equals("for")){
			
			boolean condicionForValida = false;
			if (this.condicion instanceof Exp){
				Exp expr = (Exp)this.condicion;
				if (!(expr.checkExp(tb,st,errorList).equals("int"))){
					//System.out.println("condicion invalida");
					errorList.add("Condicion Invalida");
				}else{condicionForValida = true;}
			}else if (this.condicion instanceof Literal){
				Literal lit = (Literal)this.condicion;
				if (!(lit.checkLiteral(tb,st).equals("int"))){
					//System.out.println("condicion invalida");
					errorList.add("Condicion Invalida");
				}else{condicionForValida = true;}
			}else if (this.condicion instanceof BinOp){
				BinOp bo = (BinOp)this.condicion;
				if (!(bo.checkBinOp(tb,st,errorList).equals("int"))){
					//System.out.println("condicion invalida");
					errorList.add("Condicion Invalida");
				}else{condicionForValida = true;}
			}
			
			Root rt = (Root)this.bloque;
		for (Node n : rt.declaraciones){
			if (n instanceof Declaracion){
				Declaracion decl = (Declaracion)n;
				for(VarLiteral vl : decl.nameFields){
						if (tb.tabla.containsKey(vl.name) == false){
							if (vl.dimension == null){
								tb.tabla.put(vl.name,new Tipos(decl.type));
							}else {
								try{
									Literal literal = (Literal)vl.dimension;
									int dim = Integer.parseInt(literal.value);
									if(dim == 0){
										errorList.add(vl.name + "[0]  la dimension no puede ser 0");
									}
								} catch(Exception e){ }
								tb.tabla.put(vl.name,new Tipos(decl.type + "[]"));
							}
						}
					}
			}else if (n instanceof Asign){
				Asign as = (Asign)n;
				as.checkAsign(tb,st,errorList,0);
			}else if (n instanceof MethodCall){
				MethodCall mc = (MethodCall)n;
				mc.checkMethodCall(tb,st,errorList);
			}else if (n instanceof Cond){
				Cond c = (Cond)n;
				Table t = new Table("IF_"+c.id, nombre);
				st.listaTablas.add(t);
				c.checkCond(tb,t,"IF_"+c.id,st,errorList);
			}else if (n instanceof Cycle){
				Cycle cy = (Cycle)n;
				// si es un for verifica la existencia y los tipos de la inicializacion de variablesz
				if (cy.tipoCiclo.equals(Cycle.FOR)) {
					Asign init = (Asign)cy.inicializacionVar;
					init.checkAsign(tb,st, errorList,1);
				}
				Table t = new Table("CICLO_"+cy.id, nombre);
				st.listaTablas.add(t);
				cy.checkCycle(t,"CICLO_"+cy.id,st,errorList);
			}else if (n instanceof Statement){
				Statement state = (Statement)n;
				state.checkStatement(tb,st,errorList);
			}
		}
		}else if (this.tipoCiclo.equals("while")){
			boolean condicionValida = false;
			if (this.condicion instanceof Exp){
				Exp expr = (Exp)this.condicion;
				if (!(expr.checkExp(tb,st,errorList).equals("boolean"))){
					//System.out.println("condicion invalida");
					errorList.add("Condicion Invalida");
				}else{condicionValida = true;}
			}else if (this.condicion instanceof Literal){
				Literal lit = (Literal)this.condicion;
				if (!(lit.checkLiteral(tb,st).equals("boolean"))){
					//System.out.println("condicion invalida");
					errorList.add("Condicion Invalida");
				}else{condicionValida = true;}
			}else if (this.condicion instanceof BinOp){
				BinOp bo = (BinOp)this.condicion;
				if (!(bo.checkBinOp(tb,st,errorList).equals("boolean"))){
					//System.out.println("condicion invalida");
					errorList.add("Condicion Invalida");
				}else{condicionValida = true;}
			}
			//condicionValida = true;
			Root rt = (Root)this.bloque;
		for (Node n : rt.declaraciones){
			if (n instanceof Declaracion){
				Declaracion decl = (Declaracion)n;
				for(VarLiteral vl : decl.nameFields){
						if (tb.tabla.containsKey(vl.name) == false){
							if (vl.dimension == null){
								tb.tabla.put(vl.name,new Tipos(decl.type));
							}else {
								try{
									Literal literal = (Literal)vl.dimension;
									int dim = Integer.parseInt(literal.value);
									if(dim == 0){
										errorList.add(vl.name + "[0]  la dimension no puede ser 0");
									}
								} catch(Exception e){ }
								tb.tabla.put(vl.name,new Tipos(decl.type + "[]"));
							}
						}
					}
			}else if (n instanceof Asign){
				Asign as = (Asign)n;
				as.checkAsign(tb,st,errorList,0);
			}else if (n instanceof MethodCall){
				MethodCall mc = (MethodCall)n;
				mc.checkMethodCall(tb,st,errorList);
			}else if (n instanceof Cond){
				Cond c = (Cond)n;
				Table t = new Table("IF_"+c.id, nombre);
				st.listaTablas.add(t);
				c.checkCond(tb,t,"IF_"+c.id,st,errorList);
			}else if (n instanceof Cycle){
				Cycle cy = (Cycle)n;
				// si es un for verifica la existencia y los tipos de la inicializacion de variablesz
				if (cy.tipoCiclo.equals(Cycle.FOR)) {
					Asign init = (Asign)cy.inicializacionVar;
					init.checkAsign(tb,st, errorList,1);
				}
				Table t = new Table("CICLO_"+cy.id, nombre);
				st.listaTablas.add(t);
				cy.checkCycle(t,"CICLO_"+cy.id,st,errorList);
			}else if (n instanceof Statement){
				Statement state = (Statement)n;
				state.checkStatement(tb,st,errorList);
			}
		}
		}
	}
	
	@Override
	public String toString(){
		return "Ciclo";
		/*String str = "";
		if(this.inicializacionVar != null){
			str = this.tipoCiclo + " " + this.inicializacionVar.toString() + " " + this.condicion.toString();
		}else{
			str = this.tipoCiclo + " " + this.condicion.toString();
		}
		return str;*/
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;

		dec.add("n" + ( ++i ) + "[label=\""+ tipoCiclo + "\"];");
		rel.add("n" + nodoActual + " -> n" + i);		

		if(tipoCiclo.equals(FOR)){
			dec.add("n" + ( ++i ) + "[label=\"exp\"];");
			rel.add("n" + nodoActual + " -> n" + i);		
			i = inicializacionVar.getDotTree(i, nodoActual, dec, rel);
		}
		dec.add("n" + ( ++i ) + "[label=\"condicion\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = condicion.getDotTree(i, i, dec, rel);

		dec.add("n" + ( ++i ) + "[label=\"bloque\"];");
		rel.add("n" + nodoActual + " -> n" + i);
		i = bloque.getDotTree(i, i, dec, rel);
		
		return i;
	}

	public String print(String padding){
		String str = padding + tipoCiclo + "\n";
		if(inicializacionVar != null) {
			str += inicializacionVar.print(padding + "\t");
		}
		if(condicion != null) {
			str += condicion.print(padding + "\t");
		}
		if(bloque != null) {
			str += bloque.print(padding + "\t");
		}
		return str;
	}
} 

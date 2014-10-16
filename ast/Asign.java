package compiler.ast;

import java.util.List;
import java.util.LinkedList;
import compiler.semantic.*;


/**
*	Nodo de Asignacion esta sera clase sera usada para todas las asignaciones de valores a variables
*/
public class Asign extends Node{

	/**
	*	Identificador de variable
	*/
	public Node id;

	/**
	*	tipo de asignacion (=, -=, +=)
	*/
	public String asig;

	/**
	*	Valor a Asignar este puede ser una expresion o un literal
	*/
	public Node value;
	
	/**
	*	Constructor de clase inicializa los campos
	*/
	public Asign(Node id, String asig, Node value){
		this.id = id;
		this.asig = asig;
		this.value = value;
	}

	/**
	*	Chequea la semantica de la asignacion tipos y existencia de variables
	*	@param tb 			tabla del scope al que peretenece
	*	@param st 			Listado de todas las tablas
	*	@param  errorList	Listado con los errores
	*	@param  isfor		Indicador para saber si la asignacion esta como inicializador de variable de un for
	*/
	public void checkAsign(Table tb, SymbolTable st, LinkedList<String> errorList, int isfor){
		boolean prueba = true;
		String verificacion = "", tipo = "",expArreglo = "";
		if (this.id instanceof VarLiteral){
			VarLiteral var = (VarLiteral)this.id;
			boolean declaracion = false;
			boolean b = false;
			boolean no = false;
			//if (var.dimension == null){
				if (this.value instanceof Exp){
					Exp expr = (Exp)this.value;
					//System.out.println("Estoy en Exp");
					verificacion = expr.checkExp(tb,st,errorList);
				}else if (this.value instanceof Statement){
					Statement stm = (Statement)this.value;
					stm.checkStatement(tb,st,errorList);
				}else if (this.value instanceof BinOp){
					BinOp bo = (BinOp)this.value;
					//System.out.println("Estoy en BinOp");
					verificacion = bo.checkBinOp(tb,st,errorList);
					//System.out.println(verificacion);
				}else if (this.value instanceof Literal){
					Literal lit = (Literal)this.value;
					verificacion = lit.checkLiteral(tb,st);
				}
				if (var.dimension != null){
					if (var.dimension instanceof Exp){
						Exp expr2 = (Exp)var.dimension;
						expArreglo = expr2.checkExp(tb,st,errorList);
					}else if (var.dimension instanceof BinOp){
						BinOp bo2 = (BinOp)var.dimension;
						expArreglo = bo2.checkBinOp(tb,st,errorList);
					}else if (var.dimension instanceof Literal){
						Literal lit2 = (Literal)var.dimension;
						expArreglo = lit2.checkLiteral(tb,st);
					}
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
								if (var.dimension == null){
									if (this.asig.equals("=")){
										if ((!tipo.equals(verificacion))&&(isfor == 0)){
											//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
											errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
										}else if(((!tipo.equals("int")) || (!verificacion.equals("int")))&&(isfor == 1)){
											errorList.add("Error de tipos en la condicion del for, " + tipo + " = " + verificacion + " invalido");
										}
									}else {
										if (isfor == 0){
											if ((!tipo.equals("int")) || (!verificacion.equals("int"))){
												//System.out.print("error de tipos: " + tipo + " " + this.asig + " " + verificacion);
												errorList.add("Error de tipos: " + tipo + " " + this.asig + " " + verificacion + " incompatible");
											}
										}else{
											errorList.add(" \"+=\" y \"-=\" invalidos en for");
										}
									}
								}else {
									if (expArreglo.equals("int")){
										if (this.asig.equals("=")){
											if (tipo.equals("int[]")){
												if (!verificacion.equals("int")){
													//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
													errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
												}
											}else if (tipo.equals("boolean[]")){
												if (!verificacion.equals("boolean")){
													//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
													errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
												}
											}
										}else {
											if (tipo.equals("int[]")){
												if (!verificacion.equals("int")){
													//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
													errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
												}
											}else if (tipo.equals("boolean[]")){
												//System.out.print("error de tipos ");
												errorList.add("Error de tipos");
											}
										}
									}else{
										//System.out.println("El indice del arreglo debe ser int");
										errorList.add("El indice del arreglo debe ser int en la variable " + var.name);
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
				if (var.dimension == null){
					if (this.asig.equals("=")){
						if ((!tipo.equals(verificacion))&&(isfor == 0)){
							errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
						}else if(((!tipo.equals("int")) || (!verificacion.equals("int")))&&(isfor == 1)){
							errorList.add("Error de tipos en la condicion del for, " + tipo + " = " + verificacion + " invalido");
						}
					}else {
						if (isfor == 0){
							if ((!tipo.equals("int")) || (!verificacion.equals("int"))){
								//System.out.print("error de tipos: " + tipo + " " + this.asig + " " + verificacion);
								errorList.add("Error de tipos: " + tipo + " " + this.asig + " " + verificacion + " incompatible");
							}
						}else{
							errorList.add(" \"+=\" y \"-=\" invalidos en for");
						}
					}
				}else{
					if (expArreglo.equals("int")){
						if (this.asig.equals("=")){
							if (tipo.equals("int[]")){
								if (!verificacion.equals("int")){
									//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
									errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
								}
							}else if (tipo.equals("boolean[]")){
								if (!verificacion.equals("boolean")){
									//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
									errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
								}
							}
						}else {
							if (tipo.equals("int[]")){
								if (!verificacion.equals("int")){
									//System.out.print("error de tipos ");System.out.println(tipo + " " + verificacion);
									errorList.add("Error de tipos, " + tipo + " y " + verificacion + " incompatibles");
								}
							}else if (tipo.equals("boolean[]")){
								//System.out.print("error de tipos ");
								errorList.add("Error de tipos ");
							}
						}
					}else{
						//System.out.println("El indice del arreglo debe ser int");
						errorList.add("El indice del arreglo debe ser int en la variable " + var.name);
					}
				}
			}
			if (!declaracion){
				//System.out.println(var.name + " no esta declarada");		
				errorList.add(var.name + " no esta declarada");
			}
			//}
			
		}
	}

	/**
	*	{@inheritDoc}
	*/
	@Override
	public String print(String padding){
		String str = padding + asig+"\n";
		str += id.print(padding + "\t");
		if(value != null){
			str += value.print(padding + "\t");
		}
		return str;
	}
	
	/**
	*	{@inheritDoc} 
	*/
	@Override
	public String toString(){
		return "Asignacion";
	}
	
	/**
	*	{@inheritDoc} 
	*/
	@Override
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

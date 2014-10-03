package compiler.ast;

import java.util.LinkedList;
import java.util.List;
import compiler.semantic.*;

public class Declaracion extends Node {
	
	public static final String CALLOUT = "callout";
	public static final String METODO = "metodo";
	public static final String FIELD = "field";
	public static final String PARAMETRO = "parametro";
	 

	public String type;

	public String typeDec;

	// para method_decl
	public String nameMethod;
	public Node bloque;
	public LinkedList<Declaracion> parametros;

	// para field_decl
	public List<VarLiteral> nameFields;
	
	// para callout_decl
	public String id;

	public Declaracion(String id){
		this.typeDec = CALLOUT;
		this.nameMethod = "callout";
		this.nameFields = null;
		this.parametros = null;
		this.bloque = null;
		this.id = id;
		this.type="";
	}
	
	public Declaracion(String type, String name, LinkedList<Declaracion> listaparametros, Node bloque){
		this.type = type;
		this.typeDec = METODO;
		this.nameMethod = name;
		this.bloque = bloque;
		this.parametros = listaparametros;
		this.nameFields = null;
		this.id = null;
	}
	
	public Declaracion(String type, List<VarLiteral> names, String tp){
		this.type = type;
		this.nameFields = names;
		this.typeDec = tp;
		this.parametros = null;
		this.nameMethod = null;
		this.bloque = null;
		this.id = null;
	}

	/**
	*	Verificacion el scope del bloque del metodo, se verifica existencia y unicidad;
	*	@param tb Tabla del metodo que se va a verificar
	*	@param nombre Nombre del padre
	*	@param stable Encapsula una lista de todas las tablas
	*/
	public void checkMethod(Table tb, String nombre, SymbolTable stable){
		String returntype = "";
		Root block = (Root)this.bloque;
		for (Node n : block.declaraciones){
			if (n instanceof Declaracion){
				Declaracion d = (Declaracion)n;
				for(VarLiteral vl : d.nameFields){
					if (tb.tabla.containsKey(vl.name) == false){
						tb.tabla.put(vl.name,new Tipos(d.type));
					}else {
						System.out.println(vl.name + " no puede ser declarada de nuevo");
					}
				}
			}else if (n instanceof Cond){
				Cond c = (Cond)n;
				Table t = new Table("IF_"+c.id, nombre);
				stable.listaTablas.add(t);
				c.checkCond(tb , t, "IF_"+c.id, stable);
			}else if (n instanceof Cycle){
				Cycle cy = (Cycle)n;
				Asign init = (Asign)cy.inicializacionVar;
				init.checkAsign(tb, stable);
				Table t = new Table("CICLO_"+cy.id, nombre);
				stable.listaTablas.add(t);
				cy.checkCycle(t,"CICLO_"+cy.id,stable);
			}else if (n instanceof MethodCall){
				MethodCall mc = (MethodCall)n;
				mc.checkMethodCall(tb,stable);
			}else if (n instanceof Statement){
				Statement st = (Statement)n;
				returntype = st.checkStatement(tb,stable);
				if (st.checkBreakContinue() == true){
					System.out.println("no puede haber un break o continue fuera de un For o While");
				}
			}else if (n instanceof Asign){
				Asign a = (Asign)n;
				a.checkAsign(tb,stable);
			}
			
		}
		if (this.type.equals("void")){
			if (!returntype.equals("")){
				System.out.println("no tiene que haber return");
			}
		}else{
			if (returntype.equals("")){
				System.out.println("Falta el valor de retorno");
			}else{
				if (!this.type.equals(returntype)){
					System.out.println("tipo de retorno invalido");
				}
			}
		}
		/*if ((!this.type.equals(returntype))&&(!returntype.equals(""))){
			System.out.println("tipo de retorno invalido");
		}
		if (!(this.type.equals("void"))&&(!returntype.equals(""))){
			System.out.println("no tiene que haber return");
		}
		if (!(!this.type.equals("void"))&&(returntype.equals(""))){
			System.out.println("Falta el valor de retorno");
		}*/
	}
	
	@Override
	public String print(String padding) {
		String str = padding + typeDec + "\n";
		if(type != null) {
			str += padding + "\t" + type + "\n";
		}
		if(nameFields != null){
			for ( VarLiteral v : nameFields ) {
				str += v.print(padding + "\t");
			}
		} else {
			str += padding + "\t" +nameMethod + "\n";
		}
		if(parametros != null){
			for(Declaracion d : parametros){
				str += d.print(padding + "\t");
			}
		}
		if(bloque != null){
			str += bloque.print(padding + "\t");
		}
		if(id != null){
			str += padding + "\t" + id + "\n";
		}
		return str;
	}

	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;
		dec.add("n" + ( ++i ) + "[label=\"Declaracion\"];");
		rel.add("n" + nodoActual + " -> n" + i);		
		if(typeDec.equals(FIELD)){
			dec.add("n" + ( ++i ) + "[label=\"" + type + "\"];");
			rel.add("n" + (nodoActual + 1) + " -> n" + i);
			int fieldsParent = nodoActual + 1;
			for ( Node n : nameFields ) {
				i = n.getDotTree(fieldsParent, i, dec, rel);
				// fieldsParent++;
				// dec.add("n" + (++i ) + "[label=\"" + n.toString() + "\"];");
				// rel.add("n" + (nodoActual + 1) + " -> n" + i);				
			}

		}else if(typeDec.equals(METODO)){
			dec.add("n" + ( ++i ) + "[label=\"" + type + "\"];");
			rel.add("n" + (nodoActual + 1) + " -> n" + i);
			dec.add("n" + ( ++i ) + "[label=\"" + nameMethod + "\"];");
			rel.add("n" + (nodoActual + 1) + " -> n" + i);

			for ( Node n : parametros ) {
				i = n.getDotTree(i, i, dec, rel);
				// dec.add("n" + (++i ) + "[label=\"" + n.toString() + "\"];");
				// rel.add("n" + (nodoActual + 1) + " -> n" + i);				
			}
			i = bloque.getDotTree(nodoActual + 1, i, dec, rel);
		}else if(typeDec.equals(CALLOUT)){
			dec.add("n" + ( ++i ) + "[label=\"" + nameMethod + "\"];");
			rel.add("n" + (nodoActual + 1) + " -> n" + i);
			dec.add("n" + ( ++i ) + "[label=\"" + id + "\"];");
			rel.add("n" + (nodoActual + 1) + " -> n" + i);
		}

		// if(tipoCiclo.equals(FOR)){
		
		// 	dec.add("n" + ( ++i ) + "[label=\"exp\"];");
		// 	rel.add("n" + nodoActual + " -> n" + i);		

		// 	i = inicializacionVar.getDotTree(nodoActual, dec, rel);
		// }
		// dec.add("n" + ( ++i ) + "[label=\"condicion\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = condicion.getDotTree(i, dec, rel);

		// dec.add("n" + ( ++i ) + "[label=\"bloque\"];");
		// rel.add("n" + nodoActual + " -> n" + i);
		// i = bloque.getDotTree(i, dec, rel);
		
		return i;
	}

}

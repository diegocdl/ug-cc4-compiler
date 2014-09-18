package compiler.ast;

import java.util.LinkedList;
import java.util.List;

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

	public void print(String padding) {
		System.out.println(padding + typeDec);
		if(type != null) System.out.println(padding + "\t" + type);
		if(nameFields != null){
			for ( VarLiteral v : nameFields ) {
				v.print(padding + "\t");
			}
		} else {
			System.out.println(padding + "\t" +nameMethod);
		}
		if(parametros != null){
			for(Declaracion d : parametros){
				d.print(padding + "\t");
			}
		}
		if(bloque != null){
			bloque.print(padding + "\t");
		}
		if(id != null){
			System.out.println(padding + "\t" + id);
		}
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
			i = bloque.getDotTree(i, i, dec, rel);
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

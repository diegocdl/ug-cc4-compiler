package compiler.ast;

import java.util.List;
import java.util.LinkedList;
import compiler.semantic.Table;
import compiler.semantic.SymbolTableManager;

public class Root extends Node{

	public LinkedList<Node> declaraciones;
	
	public Root(){
		super();
		declaraciones = new LinkedList<Node>();
	}
	
	public void add(Node node){
		declaraciones.add(node);
	}

	public int size(){
		return declaraciones.size();
	}

	public Node getChild(int i){
		return declaraciones.get(i);
	}
	
	public String print(){
		return print("");
	}

	public Table buildTable(Table parent, SymbolTableManager symbolTableManager){
		Table table = new Table("Root " + id, parent);
		for (Node n : declaraciones) {
			if(n instanceof Declaracion) {
				Declaracion d = (Declaracion)n;
				if(d.getTypeDec().equals(Declaracion.FIELD)) {
					for (VarLiteral v : d.nameFields ) {
						String name = v.getName();
						String tipo = d.getTypeData() + ( (v.isArray())?"[]":"" );
						table.put(name, tipo);
					}
				} else if(d.getTypeDec().equals(Declaracion.METODO)) {
					// se agrega el nombre del metodo a la tabla
					table.put(d.nameMethod, d.getTypeData());

					Table table2 = ((Root)d.bloque).buildTable(table, symbolTableManager);

					// se agregan los parametros a la tabla
					for(Declaracion p: d.parametros){
						for (VarLiteral v : p.nameFields ) {
							String name = v.getName();
							String tipo = d.getTypeData() + ( (v.isArray())?"[]":"" );
							table2.put(name, tipo);
						}
					}
				}
			} else if(n instanceof Cond) {
				Cond c = (Cond)n;
				// se verifica que los bloques del if no sean null y se construye la tabla para cada uno
				if(c.consecuencia != null) {
					((Root)c.consecuencia).buildTable(table, symbolTableManager);
				}
				if(c.alternativa != null) {
					((Root)c.alternativa).buildTable(table, symbolTableManager);
				}
			} else if(n instanceof Cycle) {
				Cycle ciclo = (Cycle)n;
				((Root)ciclo.bloque).buildTable(table, symbolTableManager);
			}


		}
		symbolTableManager.addTable(id, table);
		return table;
	}

	@Override
	public String print(String padding){
		String str = padding + "Root\n" ;
		for(Node n : declaraciones){
			if(n != null)
				str += n.print("\t" + padding);
		}
		return str;
	}
	
	public int getDotTree(int parent, int i, List<String> dec, List<String> rel){
		int nodoActual = i;
		dec.add("n" + ( ++i ) + "[label=\"Root\"];");
		if(parent != 0) 
			rel.add("n"+ parent + " -> n" + i );
		for (Node n : declaraciones ) {
			i = n.getDotTree(nodoActual+1, i, dec, rel);
		}
		return i;
	}
} 
package compiler.semantic;

import java.util.LinkedList;
import compiler.ast.*;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Semantic {

	public Debug debug;
	public OutputFile of;
	public LinkedList<Node> listaNodos;
	public LinkedList<String> listaErrores;
	public SymbolTable tablaSimbolos;

	public Semantic(Ast ast) throws Exception {
		tablaSimbolos = new SymbolTable();
		listaNodos = ast.root.declaraciones;
		listaErrores = new LinkedList<String>();
		of = ast.getOutFile();
		String msg = "stage: Semantic";
		System.out.println(msg);
		of.writeln(msg);
	}
	
	public boolean check(){
		boolean error = false;
		boolean main = false;
		Table tglobal = new Table("ROOT", "NULL");
		this.tablaSimbolos.listaTablas.add(tglobal);
		for (Node n : listaNodos){
			if(n instanceof Declaracion) {
				Declaracion decl = (Declaracion)n;
				if(decl.typeDec.equals(Declaracion.METODO)){
					Table t = new Table(decl.nameMethod, "ROOT");
					this.tablaSimbolos.listaTablas.add(t);
					if (tglobal.tabla.containsKey(decl.nameMethod) == false){
						tglobal.tabla.put(decl.nameMethod, new Tipos(decl.type, decl.parametros));
						for (Declaracion d : decl.parametros){
							t.tabla.put(d.nameFields.get(0).name, new Tipos(d.type));
						}
					}else {
						//System.out.println(decl.nameMethod + " no puede ser declarada de nuevo");
						this.listaErrores.add(decl.nameMethod + " no puede ser declarada de nuevo");
					}
					decl.checkMethod(t,decl.nameMethod,this.tablaSimbolos,this.listaErrores);
				}else if(decl.typeDec.equals(Declaracion.FIELD)){
					for(VarLiteral vl : decl.nameFields){
						if (tglobal.tabla.containsKey(vl.name) == false){
							if (vl.dimension == null){
								tglobal.tabla.put(vl.name,new Tipos(decl.type));
							}else {
								try{
									Literal literal = (Literal)vl.dimension;
									int dim = Integer.parseInt(literal.value);
									if(dim == 0){
										this.listaErrores.add(vl.name + "[0]  la dimension no puede ser 0");
									}
								} catch(Exception e){ }
								tglobal.tabla.put(vl.name,new Tipos(decl.type + "[]"));
							}
						}else {
							//System.out.println(vl.name + " no puede ser declarada de nuevo");
							this.listaErrores.add(vl.name + " no puede ser declarada de nuevo");
						}
					}
				}
			}
		}
		for (Table tab : this.tablaSimbolos.listaTablas){
			System.out.println(tab.toTableString());
			if (tab.name.equals("main")){main = true;}
		}
		if (!main){
			//System.out.println("No hay main");
			this.listaErrores.add("No hay main");
		}
		if (!this.listaErrores.isEmpty()){
			error = true;
			System.out.println("\n- ERRORES -\n");
			for (String se : this.listaErrores){
				System.out.println("- " + se);
			}
		}
		return error;
	}
	

	public void setDebuger(Debug d) {
		debug = d;
		debug.println("debugging: Semantic");
	}

	public OutputFile getOutFile(){
		return of;
	}
	
}

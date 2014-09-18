package compiler.semantic;

import java.util.LinkedList;
import compiler.ast.*;
import compiler.lib.Debug;
import compiler.lib.OutputFile;

public class Semantic {

	public Debug debug;
	public OutputFile of;
	public LinkedList<Node> listaNodos;
	//public LinkedList<Node> listaNodos0;
	public SymbolTable tablaSimbolos;

	public Semantic(Ast ast) throws Exception {
		tablaSimbolos = new SymbolTable();
		listaNodos = ast.root.declaraciones;
		//listaNodos0 = ast.lista2;
		of = ast.getOutFile();
		String msg = "stage: Semantic";
		System.out.println(msg);
		of.writeln(msg);
	}
	
	/*public void check(){
		for (Node n : listaNodos){
			if(n instanceof Declaracion){
				Declaracion decl = (Declaracion)n;
				Table t = new Table("", "");
				this.tablaSimbolos.listaTablas.add(t);
				if(decl.typeDec.equals("field"))
				for(VarLiteral vl : decl.nameFields){
				if (t.tabla.containsKey(vl.name) == false){
					t.tabla.put(vl.name,decl.type);
					System.out.println(t.tabla.toString());
				}/*else{
					result=false;
				}*/
				/*}
			}
		}
		System.out.println(this.tablaSimbolos.listaTablas.toString());
	}*/
	
	public void check(){
		Table tglobal = new Table("ROOT", "NULL");
		this.tablaSimbolos.listaTablas.add(tglobal);
		for (Node n : listaNodos){
			if(n instanceof Declaracion){
				Declaracion decl = (Declaracion)n;
				if(decl.typeDec.equals("metodo")){
					Table t = new Table(decl.nameMethod, "ROOT");
					this.tablaSimbolos.listaTablas.add(t);
					decl.checkMethod(t,decl.nameMethod,this.tablaSimbolos);
				}else if(decl.typeDec.equals("field")){
					for(VarLiteral vl : decl.nameFields){
						if (tglobal.tabla.containsKey(vl.name) == false){
							tglobal.tabla.put(vl.name,decl.type);
							System.out.println(tglobal.tabla.toString());
						}
					}
				}
			}
		}
	}
	
	/*public void check(){
		/*String str = "", straux = "";
		int numt = 0, numaux = 0, count = 0, countif = 0, conds = 0, condinstructions = 0;
		Table tglobal = new Table("ROOT", "NULL");
		this.tablaSimbolos.listaTablas.add(tglobal);
		for (Node n : listaNodos0){
			count++;
			if(n instanceof Declaracion){
				Declaracion decl = (Declaracion)n;
				for(VarLiteral vl : decl.nameFields){
				if (tglobal.tabla.containsKey(vl.name) == false){
					tglobal.tabla.put(vl.name,decl.type);
					System.out.println(tglobal.tabla.toString());
				}
				}
			}
		}
		for (int i=listaNodos.size()-count; i>0; i--){
			if(listaNodos.get(i) instanceof Declaracion){
				Declaracion decl = (Declaracion)listaNodos.get(i);
				if(decl.typeDec.equals("metodo")){
				str = decl.nameMethod;
				straux = str;
				numt++;
				numaux++;
				Table t = new Table(str, "ROOT");
				this.tablaSimbolos.listaTablas.add(t);
				}else if(decl.typeDec.equals("field")){
				for(VarLiteral vl : decl.nameFields){
				if (this.tablaSimbolos.listaTablas.get(numt).containsKey(vl.name) == false){
					t.tabla.put(vl.name,decl.type);
					System.out.println(t.tabla.toString());
				}/*else{
					result=false;
				}*/
				/*}
				}
			}else if(listaNodos.get(i) instanceof Asign){
				Asign a = (Asign)listaNodos.get(i);
				if (this.tablaSimbolos.listaTablas.get(numt).containsKey(a.name) == true){
					
				}else{
					
				}
			}else if(listaNodos.get(i) instanceof MethodCall){
				MethodCall mc = (MethodCall)listaNodos.get(i);
				if (this.tablaSimbolos.listaTablas.get(numt).containsKey(a.nameMethod) == true){
					
				}else{
					
				}
			/*else if (listaNodos.get(i) instanceof Cond){
				boolean ifanidado = false;
				boolean elseif = false;
				Cond cnd = (Cond)n;
				countif++;
				for(Node n : cnd.consecuencia.declaraciones){
					if (n instanceof Cond){
						ifanidado = true;
					}
				}
				if (cnd.alternativa != null){
				for(Node n : cnd.alternativa.declaraciones){
					if (n instanceof Cond){
						conds++;
						elseif = true;
					}
				}
				}
				if(!ifanidado){
					Table t = new Table("IF"+countif, str);
					this.tablaSimbolos.listaTablas.add(t);
				}else{
					Table t = new Table("IF"+countif, str);
					this.tablaSimbolos.listaTablas.add(t);
					str="IF"+countif;
				}
				if (!elseif){
					Table t = new Table("ELSE"+countif, str);
					this.tablaSimbolos.listaTablas.add(t);
				}
				if(!ifanidado&&!elseif&&conds==0){
					str=straux;
				}else if(!ifanidado&&!elseif&&conds>0){
					str="IF"+(countif-1);
					conds--;
				}
			}else if (listaNodos.get(i) instanceof Root){
				Root r = (Root)n;
				Table t = new Table("IF", str);
				if (cnd.alternativa != null){
					Table t = new Table("ELSE", str);
				}
			}*/
		/*}
		System.out.println(this.tablaSimbolos.listaTablas.toString());
	}*/

	public void setDebuger(Debug d) {
		debug = d;
		debug.println("debugging: Semantic");
	}

	public OutputFile getOutFile(){
		return of;
	}
	
}

package compiler.irt;

import compiler.ast.nodes.*;
import compiler.ast.nodes.Node;
import compiler.irt.instructions.Instruction;
import compiler.irt.instructions.*;
import compiler.semantic.Semantic;
import compiler.semantic.Table;
import compiler.semantic.SymbolTable;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.Arrays;
import java.util.LinkedList;

public class Irt {

	public Debug debug;
	public OutputFile of;
	public LinkedList<Node> listaNodos;
	public SymbolTable symbolTable;
	
	public IrtList instructions;

	

	public Irt(Semantic semantic) throws Exception {
		listaNodos 		= semantic.getListaNodos();
		symbolTable 	= semantic.getSymbolTable();
		instructions 	= new IrtList();
		
		String msg = "stage: Irt";
		of = semantic.getOutFile();
		System.out.println(msg);
		of.writeln(msg);
		start();
	}

	public void start() {
		Table root = symbolTable.searchByName("ROOT");
		// se solicita la cantidad de variables a la tabla de scope principal
		int nVars = root.getCantidadVariables();

		// se agregan las instrucciones para reservar espacio en el global pointer
		LoadStore temp = new LoadStore	(
											"li", 
											symbolTable.registerManager.getT(),
											Integer.toString(nVars*4*(-1))
										);
		instructions.add(temp);
		instructions.add(new Alu(Alu.ADD, RegisterManager.GP, RegisterManager.GP, temp.getRd() ));
		// se regresa el registro temporal usado para reservar espacio en el stack
		symbolTable.registerManager.returnRegister(temp.getRd());

		// se inicializan con 0 todas las variables
		for (int i = 0; i < nVars; i++) {
				instructions.add(new LoadStore("sw", RegisterManager.ZERO, i*4 , RegisterManager.GP));
		}
		instructions.add(new Jump("jal", "main"));
		// restaurar el espacio al global pointer
		temp = new LoadStore	(
											"li", 
											symbolTable.registerManager.getT(),
											Integer.toString(nVars*4)
										);
		instructions.add(temp);
		instructions.add(new Alu(Alu.ADD, RegisterManager.GP, RegisterManager.GP, temp.getRd() ));
		// se regresa el registro temporal usado para reservar espacio en el stack
		symbolTable.registerManager.returnRegister(temp.getRd());
		instructions.add(new LoadStore	(
											"li", 
											RegisterManager.V0,
											Integer.toString(10)
										));

		instructions.add(new Syscall());


		// destruct de todos los nodos de declaracion
		for (Node n : listaNodos ) {
			if(n instanceof Declaracion){
				Declaracion dec = (Declaracion)n;
				if(dec.getTypeDec().equals(Declaracion.METODO)) {
					instructions.add(dec.destruct("ROOT", symbolTable));
				}
			}
			
		}

		System.out.println(instructions);
		System.out.println(Arrays.toString(symbolTable.registerManager.s));
		System.out.println(Arrays.toString(symbolTable.registerManager.t));

	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Irt");
	}

	public OutputFile getOutFile(){
		return of;
	}

}
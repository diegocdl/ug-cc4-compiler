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

import java.io.IOException;
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
		of = semantic.getOutFile();
		// start();
	}

	public void start() {
		String msg = "stage: Irt";

		if(debug != null)
			debug.println(msg);
		try{
			of.writeln(msg);
		} catch (IOException ioe ) {}

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

		String print = "print:\n\tadd $sp $sp -8\n\tsw $a0 0($sp)\n\tsw $v0 4($sp)\n\tlw $a0 0($fp)\n\tli $v0 1\n\tsyscall\n\tlw $a0 0($sp)\n\tlw $v0 4($sp)\n\tadd $sp $sp 8\n\tjr $ra";
		try {
			of.reset();
			of.write(instructions.toString());
			of.write(print);
		} catch (Exception ioe ) {

		}

		System.out.println(instructions);
		// se agrega al codigo funcion print 
		System.out.println(print);
		System.out.println("Registros S: " + Arrays.toString(symbolTable.registerManager.s));
		System.out.println("Registros T:" + Arrays.toString(symbolTable.registerManager.t));

	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Irt");
	}

	public OutputFile getOutFile(){
		return of;
	}

}
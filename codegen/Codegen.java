package compiler.codegen;

import compiler.irt.Irt;
import compiler.irt.IrtList;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.LinkedList;

public class Codegen {
	
	public Debug debug;
	public OutputFile of;
	public IrtList instructions;

	public Codegen(Irt irt) throws Exception {
		String msg = "stage: codegen";
		of = irt.getOutFile();
		of.writeln(msg);
	}

	public void start(){
		// se reinicia el archivo y solo se guarda en el archivo las instrucciones
		try {
			of.reset();
			of.write(instructions.toString());
			of.write(Irt.PRINT);
		} catch ( Exception e) {}

	}

	public void setDebuger(Debug d){
		debug = d;
		debug.println("debugging: Codegen");
	}

	public OutputFile getOutFile(){
		return of;
	}
}
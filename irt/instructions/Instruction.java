package compiler.irt.instructions;

import compiler.irt.Register;

public abstract class Instruction {

	// Node next;
	public abstract String toString();	


	public abstract Register getRd();
}
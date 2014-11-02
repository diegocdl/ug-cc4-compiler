package compiler.irt.instructions;

import compiler.irt.Register;

public class Immediate extends Instruction {
	
	protected int immediate;

	public Immediate(int i) {
		immediate = i;
	}


	public Register getRd() {
		return null;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		return null;
	}
}
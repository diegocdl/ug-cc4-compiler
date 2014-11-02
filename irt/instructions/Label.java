package compiler.irt.instructions;

import compiler.irt.Register;

public class Label extends Instruction {

	protected String label;

	public  Label(String l) {
		label = l;
	}


	public Register getRd() {
		return null;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		return label + ":";
	}
}
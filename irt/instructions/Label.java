package compiler.irt.instructions;

public class Label extends Instruction {

	protected String label;

	public  Label(String l) {
		label = l;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		return label + ":";
	}
}
package compiler.irt.instructions;

public class Immediate extends Instruction {
	
	protected int immediate;

	public Immediate(int i) {
		immediate = i;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		return null;
	}
}
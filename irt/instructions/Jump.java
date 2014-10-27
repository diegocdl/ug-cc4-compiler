package compiler.irt.instructions;

import compiler.irt.Register;
/**
*	Nodo para representar saltos en assmebly
*	
*/
public class Jump extends Instruction {

	protected String type;

	protected Register register;
	protected String label;

	public Jump(String type, Register register) {
		this.type = type;
		this.register = register;
	}

	public Jump(String type, String label) {
		this.type = type;
		this.label = label;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		String str = type + " ";
		if(register != null){
			str += register;
		} else if(label != null){
			str += label;
		}
		return str;
	}
}
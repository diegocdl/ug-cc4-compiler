package compiler.irt.instructions;

import compiler.irt.Register;

public class Comment extends Instruction{
	protected String comment;

	public Comment(String c) {
		comment = c;
	}

	public String toString() {
		return  "# " + comment;
	}

	public Register getRd(){
		return null;
	}
}
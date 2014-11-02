package compiler.irt.instructions;

import compiler.irt.Register;

public class Syscall extends Instruction {

	@Override
	public String toString() {
		return "syscall";
	}


	public Register getRd() {
		return null;
	}
}
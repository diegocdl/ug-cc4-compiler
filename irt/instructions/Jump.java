package compiler.irt.instructions;

import compiler.irt.Register;
/**
*	Nodo para representar saltos en assmebly
*	
*/
public class Jump extends Instruction {

	public static final String J 	=	"j";
	public static final String JR 	=	"jr";
	public static final String JAL 	=	"jal";
	public static final String BEQ 	=	"beq";
	public static final String BNE 	=	"bne";

	protected String type;

	protected Register r1;
	protected Register r2;
	protected String label;

	public Jump(String type, Register register) {
		this.type = type;
		this.r1 = register;
	}

	public Jump(String type, String label) {
		this.type = type;
		this.label = label;
	}

	public Jump(String type, Register r1, Register r2, String label) {
		this.type = type;
		this.r1 = r1;
		this.r2 = r2;
		this.label = label;
	}	


	public Register getRd(){
		return null;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		String str = type + " ";
		// String str =  "";
		// if(register != null){
		// 	str += register;
		// } else if(label != null){
		// 	str += label;
		// }
		switch (type) {
			case J: case JAL:
				str += label;
				break;
			case JR:
				str += r1;
				break;
			case BNE: case BEQ:
				str += r1 + " " + r2 + " " + label;
				break;
		}
		return str;
	}
}
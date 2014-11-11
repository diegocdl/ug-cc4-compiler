package compiler.irt.instructions;

import compiler.irt.Register;

/**
*	Unidad logico aritmetica(ALU) comprende todas las operaciones matematicas y logicas del programa
*/
public class Alu extends Instruction {

	public static final String ADD 		= "add";
	public static final String SUB 		= "sub";
	public static final String MULT 	= "mul";
	public static final String DIV 		= "div";
	public static final String EQUAL	= "seq";
	public static final String NOTEQUAL	= "sne";


	protected Register rd;

	protected Register op1;	

	/**
	*	add, mult, div. sub, rem 
	*/
	protected String type;
	
	protected Register op2;	

	/**
	*	
	*/
	public Alu(String type, Register rd, Register op1, Register op2) {
		this.rd 	= rd;
		this.op1 	= op1;
		this.type 	= type;
		this.op2 	= op2;
	}

	public Register getRd() {
		return rd;
	}

	public String getType() {
		return type;
	}

	public Register getOp1() {
		return op1;
	}

	public Register getOp2() {
		return op2;
	}

	/**
	*	{@inheritDoc}
	*/
	public String toString() {
		return getType() + " " + getRd().toString() + " " + getOp1() + " " + getOp2();
	}
}
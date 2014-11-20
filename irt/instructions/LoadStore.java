package compiler.irt.instructions;

import compiler.irt.Register;

public class LoadStore extends Instruction {

	public final static String LI = "li";
	public final static String LW = "lw";
	public final static String SW = "sw";
	protected String type;
	protected Register rs;
	protected Register rd;


	/**
	*	Guarda el valor que debe guardarse para un Store
	*/
	protected String value;

	protected int offset;

	/**
	*	LI
	*/
	public LoadStore(String type, Register r, String value) {
		this.type = type;
		this.rs = r;
		this.value = value;
	}

	/**
	*	SW, lw
	*/
	public LoadStore(String type, Register rs, int offset, Register rd ) {
		this.type 	= type;
		this.rs 	= rs; 
		this.offset	= offset; 
		this.rd 	= rd; 

	}

	public Register getRd() {
		return rs;
	}
	
	public void setRs(Register rs){
		this.rs = rs;
	}

	public LoadStore copia() {
		LoadStore clone;
		if(rd == null) {
			clone = new LoadStore(type, rs, value);
		} else {
			clone = new LoadStore(type, rs, offset, rd);
		}
		return clone;
	}

	@Override
	public String toString() {
		switch (type) {
			case "li":
				return type + " " + rs + " " + value;
			case "sw": case "lw":
				return type + " " + rs + " " + offset + "(" + rd + ")";
		}
		return "";
	}
}

package compiler.irt;

public class Register {

	protected String type;
	protected int number;

	public Register(String t, int num) {
		type = t;
		number = num;
	}

	public Register(String t) {
		type = t;
	}

	public String getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		if(type.length() > 1) {
			return "$" + type;
		} else {	
			return "$" + type + number;
		} 
	}

}
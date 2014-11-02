package compiler.irt;

public class RegisterManager {


	public static final Register ZERO 	= new Register("zero");
	public static final Register SP 	= new Register("sp");
	public static final Register GP		= new Register("gp");
	public static final Register FP		= new Register("fp");
	public static final Register RA		= new Register("ra");
	public static final Register V0		= new Register("v", 0);
	
	public boolean s[];
	public boolean t[];

	public RegisterManager() {
		s = new boolean[8];
		t = new boolean[8];
	}

	public Register getS() {
		for (int i = 0;  i < s.length; i++ ) {
			if(!s[i]) {
				s[i] = true;
				return new Register("s", i);
			}
		}
		return null;
	}

	public Register getT() {
		for (int i = 0;  i < s.length; i++ ) {
			if(!t[i]) {
				t[i] = true;
				Register r = new Register("t", i);
				System.out.println("Otorgado: " + r);
				return r;
			}
		}
		return null;
	}

	public void returnRegister(Register r) {
		if(r != null) {
			switch (r.getType()) {
				case "s":
					s[r.getNumber()] = false;
					break;
				case "t":
					t[r.getNumber()] = false;
					break;
			}
		} 
	}


}
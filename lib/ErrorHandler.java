package compiler.lib;

public class ErrorHandler extends Exception{
	public ErrorHandler(int error, String option) {
		switch(error){
			case 1:
				System.err.println("Opcion " + option + " no reconocida");
				break;
			case 2:
				System.err.println("Archivo " + option + " es invalido");
				break;
			case 3:
				System.err.println("opcion de -opt \"" + option + "\" es invalida");
				break;
			case 4:
				System.err.println("opcion de -target \"" + option + "\" es invalida");
				break;
			case 5:
				System.err.println("Error No se indico el archivo, falto la opcion o es una opcion invalida");
				break;
		}
	}
}

package compiler.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
*	Clase que abre un FileOutput Stream para grabar a un archivo mas facilmente
*/
public class OutputFile {
	
	/** acceso al archivo */
	FileOutputStream fs;

	/**
	*	Constructor de clase inicializa campos
	*	@param path direccion del archivo en la que se desea guardarlo
	*/
	public OutputFile( String path ) throws FileNotFoundException {
		fs = new FileOutputStream( path );
	}

	/**
	*	Escribe un String en una linea al archivo
	*	@param str string a escribir
	*/
	public void writeln( String str ) throws IOException {
		str += "\n";
		this.write(str);
	}

	/**
	*	Escribe un String al archivo
	*	@param str String
	*/
	public void write( String str ) throws IOException {
		fs.write( str.getBytes() );
	}	


}
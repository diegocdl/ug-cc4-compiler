package compiler.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OutputFile {
	
	FileOutputStream fs;

	public OutputFile( String path ) throws FileNotFoundException {
		fs = new FileOutputStream( path );
	}

	public void writeln( String str ) throws IOException {
		str += "\n";
		fs.write( str.getBytes() );
	}


}
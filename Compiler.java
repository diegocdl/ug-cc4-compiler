import java.util.regex.Pattern;
import java.io.File;
import compiler.scanner.Scanner;
import compiler.parser.CC4Parser;
import compiler.ast.Ast;
import compiler.irt.Irt;
import compiler.semantic.Semantic;
import compiler.codegen.Codegen;
import compiler.opt.Algebraic;
import compiler.opt.ConstantFolding;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import compiler.lib.ErrorHandler;

public class Compiler {
	public static void main(String[] args)  throws Exception {
		// Variables de configuracion del Compilador
		try{
		String inputFilename = "";
		String outputFilename = "";
		String target = "";
		String opt = "";
		String debug [] = null;


		String option = "";
		String option2 = "";
		if ( args.length > 1 ) {
			// recorre el arreglo args y setea las variables de configuración 
			for ( int i = 0; i< args.length; i++ ) {
				switch(args[i]){
					case "-o":
						outputFilename = args[++i];
						break;
					case "-target":
						target = args[++i];
						break;
					case "-opt":
						opt = args[++i];
						//System.out.println("optimizacion " + opt );
						break;
					case "-debug":
						debug = args[++i].split(":");
						//System.out.print("Debug: " + args[++i]);
						break;
					case "-h":
						printHelp();
						exit(0);
						break;
					default:
						if ( Pattern.matches("[^\\-].*\\.dcf", args[i]) && args.length-1 == i ) {
							inputFilename = args[i];
						} else if(Pattern.matches("[^\\-].*(^\\.)", args[i])){
							throw new ErrorHandler("Error en la opcion: " + args[i]);
						}else if( !Pattern.matches("[^\\-].*\\.dcf", args[i]) && args.length-1 == i ){
							throw new ErrorHandler("Error en el archivo: " + args[i]);
						} else{
							throw new ErrorHandler("Error en la opcion: " + args[i]);
						}
						break;
				}
			}
		}else if (args.length==0){
			printHelp();
		}else if ((args[0].equals("-h"))&&(args.length==1)){
			printHelp();
		}

		Scanner scan;
		CC4Parser parse;
		Ast ast;
		Semantic semantic;
		Irt irt;
		Codegen codegen;
		ConstantFolding cf;
		Algebraic algebraic;
		Debug deb = new Debug();
		OutputFile outFile;

		if ((args.length > 0)&&(!args[0].equals("-h"))){
			if ( !target.equals("") ){
				if(!inputFilename.equals("") && existeArchivo(inputFilename)) {
					if(outputFilename.equals("")){
						outputFilename = inputFilename.substring(0, inputFilename.lastIndexOf('.')) + ".s";
					}
					outFile = new OutputFile( outputFilename );

					System.out.println("input: " + inputFilename);
					System.out.println("output: " + outputFilename);
					// Ejecuta el compilador hasta el target indicado
					if( target.equals("scan") || target.equals("parse") || target.equals("ast") 
							|| target.equals("semantic") || target.equals("irt") || target.equals("codegen") ){

						scan = new Scanner(inputFilename, outFile);
						if (buscarString(debug, "scan")) scan.setDebuger(deb);
						scan.start();
						if (target.equals("scan")) {
							if(!opt.equals("")) throw new ErrorHandler("Error: No se puede optimizar en " + target + ", debe ser codegen");
							exit(0);
						}
						parse = new CC4Parser(scan);
						parse.start();
						if (buscarString(debug, "parse")) parse.setDebuger(deb);
						if (target.equals("parse")) {
							if(!opt.equals("")) throw new ErrorHandler("Error: No se puede optimizar en " + target + ", debe ser codegen");
							exit(0);
						}
						ast = new Ast(parse);
						ast.start();
						if (buscarString(debug, "ast")) ast.setDebuger(deb);
						if (target.equals("ast")) {
							if(!opt.equals("")) throw new ErrorHandler("Error: No se puede optimizar en " + target + ", debe ser codegen");
							exit(0);
						}
						semantic = new Semantic(ast);
						if (buscarString(debug, "semantic")) semantic.setDebuger(deb);
						if (target.equals("semantic")) {
							if(!opt.equals("")) throw new ErrorHandler("Error: No se puede optimizar en " + target + ", debe ser codegen");
							exit(0);
						}
						irt = new Irt(semantic);
						if (buscarString(debug, "irt")) irt.setDebuger(deb);
						if (target.equals("irt")) {
							if(!opt.equals("")) throw new ErrorHandler("Error: No se puede optimizar en " + target + ", debe ser codegen");
							exit(0);
						}
						codegen = new Codegen(irt);
						if (buscarString(debug, "codegen")) codegen.setDebuger(deb);

						if ( !opt.equals("") ){
							if(!inputFilename.equals("")) {
								if(outputFilename.equals("")){
									outputFilename = inputFilename.substring(0, inputFilename.lastIndexOf('.')) + ".s";	
								}
					
								System.out.println("input: " + inputFilename);
								System.out.println("output: " + outputFilename);

								if( opt.equals("constant") ){
									cf = new ConstantFolding(inputFilename); exit(0);
								} else if( opt.equals("algebraic") ){
									algebraic = new Algebraic(inputFilename); exit(0);
								}else {
									throw new ErrorHandler("Opcion de optimizacion invalida: " + opt);
								}
								
							} else {
								throw new ErrorHandler("Error: No se indico archivo, opcion o la opcion es invalida");
							}
						} 
					}else {
						throw new ErrorHandler("Opcion de target invalida: " + target);
				    }

				} else {
					throw new ErrorHandler("Error: No se indico archivo, opcion o la opcion es invalida");
				}
			}else {
				throw new ErrorHandler("Error: No se indico archivo, opcion o la opcion es invalida");
			}
			
		}

			} catch(ErrorHandler e) {
				System.err.println(e.getMessage());
			}
		
    }

	/**
	*	Despliega la ayuda del comand line
	*/
	public static void printHelp() {
		System.out.println("\t-o <outname>Escribir el output a un archivo de texto llamado <outname>.\n");
		System.out.println("\t-target <stage> Donde <stage> es uno de:");
		System.out.println("\t\t\t- scan");
		System.out.println("\t\t\t- parse");
		System.out.println("\t\t\t- ast"); 
		System.out.println("\t\t\t- semantic");
		System.out.println("\t\t\t- irt");
		System.out.println("\t\t\t- codegen"); 
		System.out.println("\t\tla compilación debe proceder hasta la etapa indicada.");
		System.out.println("\t\tPor ejemplo, si <stage> es scan, una instancia de scan debe ser");
		System.out.println("\t\tcreada imprimiendo en el archivo de salida \"stage: scanning\".");
		System.out.println("\t\tSi es parse una instancia de parser debe ser creada a partir de");
		System.out.println("\t\tla instancia de scanner imprimiendo \"stage: parsing\", además ");
		System.out.println("\t\tdel mensaje de scanner y así sucesivamente.\n");
		System.out.println("\t-opt <optimzation>  <optimization> es uno de: constant, algebraic;");
		System.out.println("\t\tla compilacion debe hacer solo la optimización que se le pida,"); 
		System.out.println("\t\ty debe imprimir como en -target \"optimizing: constant folding\""); 
		System.out.println("\t\t\"o optimizing: algebraic simplification\".\n"); 
		System.out.println("\t-debug <stage>  Imprimir información de debugging. Debe haber un"); 
		System.out.println("\t\tmensaje por cada etapa listada en <stage> de la forma ");
		System.out.println("\t\t\"Debugging <stage>\". <stage> tiene las mismas opciones de"); 
		System.out.println("\t\t-target, con la diferencia que se pueden \"debuggear\" varias");
		System.out.println("\t\tetapas, separandolas con ':' de la forma scan:parse:etc.\n");
		System.out.println("\t-h Muestra esta ayuda al usuario.");
	}

	public static void exit(int i){
		try{
					Thread.sleep(10000);
				}catch (Exception e) {
					
				}
		System.exit(i);
	}

	public static boolean existeArchivo(String file){
		File f = new File(file);
		return f.exists();
	}

	public static boolean buscarString(String [] array, String str){
		if( array != null) {
			for (String e : array) {
				if (e.equals(str)) {
					return true;
				}
			}
		}
		return false;
	}
}

import java.util.regex.Pattern;
import compiler.scanner.Scanner;
import compiler.parser.CC4Parser;
import compiler.ast.Ast;
import compiler.irt.Irt;
import compiler.semantic.Semantic;
import compiler.codegen.Codegen;

public class Compiler {
	public static void main(String[] args) {
		// Variables de configuracion del Compilador
		String inputFilename = "";
		String outputFilename = "";
		String target = "";
		String opt = "";
		String debug = "";
		

		String option = "";
		String option2 = "";
		if ( args.length > 0 ) {
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
						System.out.println("optimizacion " + opt );
						break;
					case "-debug":
						debug = args[++i];
						System.out.print("Debug: " + args[++i]);
						break;
					case "-h":
						printHelp();
						exit(0);
						break;
					default:
						if ( Pattern.matches("[^\\-].*\\.[d][c][f]", args[i]) && args.length-1 == i ) {
							inputFilename = args[i];
						} else {
							System.err.println("Opcion " + args[i] + " no reconocida");
							System.exit(1);
						}
						break;
				}
			}

			Scanner scan;
			CC4Parser parse;
			Ast ast;
			Semantic semantic;
			Irt irt;
			Codegen codegen;
			
			if ( !target.equals("") ){
				if(!inputFilename.equals("")) {

					if(outputFilename.equals("")){
						outputFilename = inputFilename.substring(0, inputFilename.lastIndexOf('.')) + ".s";	
					}

					System.out.println("input: " + inputFilename);
					System.out.println("output: " + outputFilename);

					// Ejecuta el compilador hasta el target indicado
					if( target.equals("scan") || target.equals("parse") || target.equals("ast") 
							|| target.equals("semantic") || target.equals("irt") || target.equals("codegen") ){

						scan = new Scanner(inputFilename);
						if (target.equals("scan")) exit(0);
						parse = new CC4Parser(scan);
						if (target.equals("parse")) exit(0);
						ast = new Ast(parse);
						if (target.equals("ast")) exit(0);
						semantic = new Semantic(ast);
						if (target.equals("semantic")) exit(0);
						irt = new Irt(semantic);
						if (target.equals("irt")) exit(0);
						codegen = new Codegen(irt);
					}

				} else {
					System.err.println("Error No se indico el archivo");
				}
			} else {
				System.err.println("Error No se indico target");
			}
		} else {
			printHelp();
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
		System.exit(i);
	}
}
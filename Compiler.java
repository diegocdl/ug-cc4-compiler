public class Compiler {
	public static void main(String[] args) {
		System.out.println("Test");
		String option = "";
		String option2 = "";
		String filename = "";
		if(args.length>2){
			for (int i=0; i<args.length; i++){
				if(i==args.length-3){
					option = args[i];
				}else if(i==args.length-2){
					option2 = args[i];
				}else if(i==args.length-1){
					filename = args[i];
				}
			}
		}else if((args.length<2)&&(args.length>0)){
			option = args[0];
		}
		System.out.println(option + " " + option2 + " " + filename);
		switch(option){
			case "-h":
			System.out.println("-o <outname>	Escribir el output a un archivo de texto llamado <outname>.\n");
			System.out.println("-target <stage>	Donde <stage> es uno de: scan, parse, ast, semantic, irt, codegen; la compilación debe proceder hasta la etapa indicada."); 
			System.out.println("Por ejemplo, si <stage> es scan, una instancia de scan debe ser creada imprimiendo en el archivo de salida \"stage: scanning\".");
			System.out.println("Si es parse una instancia de parser debe ser creada a partir de la instancia de scanner imprimiendo \"stage: parsing\",");
			System.out.println("además del mensaje de scanner y así sucesivamente.\n");
			System.out.println("-opt <optimzation>	<optimization> es uno de: constant, algebraic; la compilación debe hacer solo la optimización que se le pida,");
			System.out.println("y debe imprimir como en -target \"optimizing: constant folding\" o \"optimizing: algebraic simplification\".\n"); 
			System.out.println("-debug <stage>	Imprimir información de debugging. Debe haber un mensaje por cada etapa listada en <stage> de la forma \"Debugging <stage\"."); 
			System.out.println("<stage> tiene las mismas opciones de -target, con la diferencia que se pueden \"debuggear\" varias etapas,"); 
			System.out.println("separandolas con ':' de la forma scan:parse:etc.\n");
			System.out.println("-h		Muestra esta ayuda al usuario.");
			break;
			case "-o":
			break;
			case "-stage":
			break;
			case "-debug":
			break;
			case "":
			System.out.println("-o <outname>	Escribir el output a un archivo de texto llamado <outname>.\n");
			System.out.println("-target <stage>	Donde <stage> es uno de: scan, parse, ast, semantic, irt, codegen; la compilación debe proceder hasta la etapa indicada."); 
			System.out.println("Por ejemplo, si <stage> es scan, una instancia de scan debe ser creada imprimiendo en el archivo de salida \"stage: scanning\".");
			System.out.println("Si es parse una instancia de parser debe ser creada a partir de la instancia de scanner imprimiendo \"stage: parsing\",");
			System.out.println("además del mensaje de scanner y así sucesivamente.\n");
			System.out.println("-opt <optimzation>	<optimization> es uno de: constant, algebraic; la compilación debe hacer solo la optimización que se le pida,");
			System.out.println("y debe imprimir como en -target \"optimizing: constant folding\" o \"optimizing: algebraic simplification\".\n"); 
			System.out.println("-debug <stage>	Imprimir información de debugging. Debe haber un mensaje por cada etapa listada en <stage> de la forma \"Debugging <stage\"."); 
			System.out.println("<stage> tiene las mismas opciones de -target, con la diferencia que se pueden \"debuggear\" varias etapas,"); 
			System.out.println("separandolas con ':' de la forma scan:parse:etc.\n");
			System.out.println("-h		Muestra esta ayuda al usuario.");
			break;
		}
	}
}

# Documentacion Fase 0 / Command Line Interface - CLI
Erwin Morataya y Diego Calderon

 - 	El archivo Compiler.java tiene el main y recibe los parametros de compilacion para la ejecucion
 	y esto se recibe como un arreglo en el main, utilizamos unas variables de configuracion de el 
 	input, output, target, optimizaciones y degub las cuales se les asigna la opcion seleccionada 
 	para cada bandera, luego se validan los valores y que el archivo de input tenga extencion .dcf 
 	dado que asumimos que como es un compilador del lenguaje Decaf esta sera la extencion del archivo 
 	de input necesaria, la ayuda se implemento como un metodo de la clase Compiler.java y se creo un 
 	metodo de exit para que cierre el programa para simplificar el codigo.

 -	Despues de haber configurado las variables y validar los datos se creo una instancia de cada Fase 
 	hasta al target seleccionado si no se indica que el target sea codegen entonces no se realizara la 
 	fase de optimizacion dado que esta es la ultima fase. Todos los Constructores reciben un objeto de 
 	la fase anterior excepto el de Scanner que recibe el nombre del archivo de input, se verifica que 
 	fases se deben debuggear y se les pasa un objeto Debug que se encarga de imprimir los mensajes de 
 	Debug.

 - 	Los erroes se manejan como excepciones por lo que la calse ErrorHandler.java hereda de Exception 
 	y cuando ocurre se lanza una excepcion con un mensaje personalizado y esta se propaga hasta el 
 	main y se despliega solo en el main.

 - 	Para imprimir al archivo se agrego una clase OutputFile.java en el paquete lib la cual maneja la 
 	salida hacia un archivo y esta se le pasa como parametro a todas las fases para que puedan 
 	guardar en el archivo de output.
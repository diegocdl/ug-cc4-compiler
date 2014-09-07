Documentacion fase 2 / AST
=====================================
Autores: Erwin Morataya y Diego Calderon

 -	Se utilizaron las siguientes etiquetas para generar los visits con `ANTLR` se agrego la bandera `visitor` para que se generara el archivo `DecafParserBaseVisitor.java` del cual se heredo para sobre sobre escribir los metodos de visita de las reglas y en este crear los nodos con la informacion que nos interesa guardar para la siguientes fases.

	 -	`# root` 
	 - 	`# asignacion`
	 - 	`# ifs`
	 - 	`# ciclo`
	 - 	`# statement`
	 - 	`# exp`
	 - 	`# literales`
	 - 	`# operacion`
	 - 	`# par`
	 - 	`# bloque`
	 - 	`# method_dec`
	 - 	`# method_c`
	 - 	`# field_dec`
	 - 	`# error`

 -	Para poder realizar esta fase fue necesario retirar todo el codigo de java que se encontraba en los archivos de gramaticas `DecafLexer.g` y `DecafParser.g` y se intento trasladar la notificacion de errores del parser al `DecafParseBaseListener.java` pero no funciono como se deseaba y para no retrasarnos se postpuso la notificacion de errores y se avanzo utilizando casos ideales sin errores, posteriormente se completara la notificacion de errores.
 -	El arbol de parseo generado por `ANTLR` se despliega utilizando el `TreeViewer` el cual se agrega a un `JFrame` de la libreria swing para poder desplegarlo graficamente en una ventana.
 -	En esta fase siempre se despliega el arbol en la terminal pero no nos dio tiempo de implementar el debug y que solo cuando estubiera activo.


Nodos
-----------------------------------------
Los siguientes nodos se crearon heredando de la clase abstracta `Node`
 - 'Root'
 - 'Literal'
 - 'Cond'
 - 'BinOp'
 - 'Cycle'
 - 'Exp'
 - 'MethodCall'
 - 'VarLiteral'
 - 'Statement'
 - 'Asign'
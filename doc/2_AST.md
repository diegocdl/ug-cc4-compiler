Documentación fase 2 / AST
=====================================
Autores: Erwin Morataya y Diego Calderón

 -	Se utilizaron las siguientes etiquetas para generar los visits con `ANTLR` y se agregó la bandera `visitor` para que se generara el archivo `DecafParserBaseVisitor.java` del cual se heredó para sobrescribir los métodos de visita de las reglas y en este crear los nodos con la información que nos interesa guardar para las siguientes fases.

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

 -	Para poder realizar esta fase fue necesario retirar todo el código de java que se encontraba en los archivos de gramáticas `DecafLexer.g` y `DecafParser.g` y se intentó trasladar la notificación de errores del parser al `DecafParseBaseListener.java` pero no funcionó como se deseaba y para no retrasarnos se postpuso la notificación de errores y se avanzó utilizando casos ideales sin errores, posteriormente se completará la notificación de errores.
 -	El árbol de parseo generado por `ANTLR` se despliega utilizando el `TreeViewer` el cual se agrega a un `JFrame` de la librería swing para poder desplegarlo gráficamente en una ventana.
 -	En esta fase siempre se despliega el árbol en la terminal pero no nos dio tiempo de implementar el debug y que solo cuando estuviera activo.


Nodos
-----------------------------------------
Los siguientes nodos se crearon heredando de la clase abstracta `Node` y nos van a servir para guardar la información que nos interesa y formar el AST por medio de una lista de estos nodos que van a estar en la clase `Root`. La clase `Root` también nos va a servir para implementar los bloques.

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

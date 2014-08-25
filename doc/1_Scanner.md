Documentacion fase 1 / Scanner
=====================================
Autores: Erwin Morataya y Diego Calderon

 -	Se creo un Lexer temporal adicional para poder recorrerlo y dejar el original para que lo reciba el parser y no se produsca 
 	un error que el lexer no tiene mas toquens y ya llego al `EOF`.
 -	El lexer es recorrido en un ciclo `while` hasta llegar al `EOF` en el ciclo se obtiene el siguiente token
 	y se obtiene el tipo que retorna un numero entero y en un arreglo llamado `ruleNames` en el archivo `DecafLexer.java` 
 	y se despliega a pantalla si el Debug esta activo y se guarda en el archivo de salida.
 -	Si el token es una de las reglas de error entonces de despliega un mensaje con el error.
 -  Se removieron los ErrorListener que tiene antlr por defecto y se agrego uno personalizado se dejo como un campo de la clase 
 	`Scanner.java` para que el Parser tambien pudiera usarlo
	
Errores
-------------------------------------
En esta parte de la fase se contemplaron errores en `Strings`, `Chars`, `hexadecimales` y un caso de error general
 - 	En los `strings` se contemplo que los caracteres de escape sean validos y que el string si finalice 
 	con una comilla doble.
 -	En los `char` se contiempla que se puede tener caracteres de escaoe que no seran validos y que se 
 	debe finalizar con una comilla simple.
 -	En el caso de `hexadecimal` se contemplo que `0x` seria un error o si tiene letras fuera del rango 
 	de la a-fA-F

Documentacion fase 1 / Parser
=====================================
 -	El parser recibe como parametro en el constructor un objeto tipo `Scanner` y obtiene el campo `lexer`
 	para crear el DecafParser se removieron los ErrorListeners por defecto y se uso el mismo BaseErrorListener de Scanner
 -	En cada regla de derivacion se despliega en pantalla que regla es.
 -	Se crearon reglas de derivacion para los errores y cada regla de error tiene asociada un `notifyErrorListeners(msg)`
 	donde `msg` es un String con la descripcion del error.
 -	Las gramatica fue escrita en base al documento `decaf-specifications.pdf` y se fue modificando para desplegar los errores
 - 	Se modificaron los testcase dado que los testcase contenian `class` pero las especificaciones de decaf no indicaban que el
 	codigo debia estar contenido en clases

Errores
-------------------------------------
En esta parte de la fase se contemplaron mas errores segun los testcase provistos, los mensajes de error son desplegados con la
descripcion del error y el numero de linea donde se encuentra.

 -	**Declaracion de variables:** se verifico que solo se puede tener dos tipos `boolean` o `int` que pueden ser un arreglo pero
 	solo se puede inicializar el numero de elementos del arreglo con un numero entero, no se puede asignar un valor en la declaracion,
 	se puede declarar varias variables separadas por coma siempre y cuando sean del mismo tipo se verifico que tuvieran la separacion 
 	por coma, se verifico que se haya escrito el identificador de la variable y no sea una palabra reservada.
 - 	**Ciclos for:** se verificaron los parentecis y los parametros que debe llevar dentro de los parentecis ademas tambien las llaves 
 	de apertura y cierre del bloque de codigo que pertenece al `for.
 -	**Condiciona if:** se verifico que tenga una condicion y que tenga los parentecis de apertura y de cierre y las llaves de apertura
 	y cierre del bloque.
 -	**Ciclo while:** se verifico que contenga la condicion del ciclo y los parentecis.
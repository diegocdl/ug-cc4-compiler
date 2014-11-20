Documentación fase 1 / Scanner
=====================================
Autores: Erwin Morataya y Diego Calderón

 -	Se creó un Lexer temporal adicional para poder recorrerlo y dejar el original para que lo reciba el parser y no se produzca 
 	un error de que el lexer no tiene mas tokens y ya llegó al `EOF`.
 -	El lexer es recorrido en un ciclo `while` hasta llegar al `EOF` en el ciclo se obtiene el siguiente token
 	y se obtiene el tipo que retorna un numero entero y en un arreglo llamado `ruleNames` en el archivo `DecafLexer.java` 
 	y se despliega a pantalla si el Debug esta activo y se guarda en el archivo de salida.
 -	Si el token es una de las reglas de error entonces de despliega un mensaje con el error.
 -  Se removieron los ErrorListener que tiene antlr por defecto y se agrego uno personalizado se dejo como un campo de la clase 
 	`Scanner.java` para que el Parser tambien pudiera usarlo
	
Errores
-------------------------------------
En esta parte de la fase se contemplaron errores en `Strings`, `Chars`, `hexadecimales` y un caso de error general
 - 	En los `strings` se contemplo que los caracteres de escape sean validos y que el string finalice 
 	con una comilla doble.
 -	En los `char` se contempla que se pueden tener caracteres de escape que no sean validos y que se 
 	debe finalizar con una comilla simple.
 -	En el caso de `hexadecimal` se contemplo que `0x` sería un error o si tiene letras fuera del rango 
 	de la a-fA-F.

Documentación fase 1 / Parser
=====================================
 -	El parser recibe como parámetro en el constructor un objeto tipo `Scanner` y obtiene el campo `lexer`,
 	para crear el DecafParser se removieron los ErrorListeners por defecto y se usó el mismo BaseErrorListener de Scanner.
 -	En cada regla de derivación se despliega en pantalla que regla es.
 -	Se crearon reglas de derivación para los errores y cada regla de error tiene asociada un `notifyErrorListeners(msg)`
 	donde `msg` es un String con la descripción del error.
 -	Las gramática fue escrita en base al documento `decaf-specifications.pdf` y se fue modificando para desplegar los errores.
 - 	Se modificaron los testcase dado que los testcase contenían `class` pero las especificaciones de decaf no indicaban que el
 	código debía estar contenido en clases.

Errores
-------------------------------------
En esta parte de la fase se contemplaron más errores según los testcase provistos, los mensajes de error son desplegados con la
descripción del error y el numero de línea donde se encuentra.

 -	**Declaración de variables:** Se verificó que solo se puede tener dos tipos `boolean` o `int` que pueden ser un arreglo pero
 	solo se puede inicializar el numero de elementos del arreglo con un numero entero, no se puede asignar un valor en la declaración,
 	se puede declarar varias variables separadas por coma siempre y cuando sean del mismo tipo, se verifico que tuvieran la separacion 
 	por coma, se verificó que se haya escrito el identificador de la variable y no sea una palabra reservada.
 - 	**Ciclos for:** Se verificaron los paréntesis y los parámetros que debe llevar dentro de los paréntesis, además también las llaves 
 	de apertura y cierre del bloque de código que pertenece al `for.
 -	**Condición if:** Se verifico que tenga una condición y que tenga los paréntesis de apertura y de cierre y las llaves de apertura
 	y cierre del bloque.
 -	**Ciclo while:** Se verificó que contenga la condición del ciclo y los paréntesis.
 -	**Estructura del programa:** Se verificó el orden de la estructura del programa según las especificaciones de Decaf.

 Actualización
 ====================================

 Scanner
 ------------------------------------
 - 	Se corrigió la gramática para los comentarios.

 Parser
 ------------------------------------
 - 	Se cambiaron el orden de algunas reglas por problemas en la jerarquía de operaciones matematicas.

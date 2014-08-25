# Documentacion fase 1 / Scanner
Autores: Erwin Morataya y Diego Calderon

 -	Se creo un Lexer temporal adicional para poder recorrerlo y dejar el original para que lo reciba el parser y no se produsca 
 	un error que el lexer no tiene mas toquens y ya llego al <code>EOF</code>.
 -	El lexer es recorrido en un ciclo <code>while</code> hasta llegar al <code>EOF</code> en el ciclo se obtiene el siguiente token
 	y se obtiene el tipo que retorna un numero entero y en un arreglo llamado <code>ruleNames</code> en el archivo <code>DecafLexer.java</code> 
 	y se despliega a pantalla si el Debug esta activo y se guarda en el archivo de salida.
 -	Si el token es una de las reglas de error entonces de despliega un mensaje con el error.
 -  Se removieron los ErrorListener que tiene antlr por defecto y se agrego uno personalizado se dejo como un campo de la clase 
 	<code>Scanner.java</code> para que el Parser tambien pudiera usarlo
	
## Errores
En esta fase se contemplaron errores en <code>Strings</code>, <code>Chars</code>, <code>hexadecimales</code> y un caso de error general
 - 	En los <code>strings</code> se contemplo que los caracteres de escape sean validos y que el string si finalice 
 	con una comilla doble.
 -	En los <code>char</code> se contiempla que se puede tener caracteres de escaoe que no seran validos y que se 
 	debe finalizar con una comilla simple.
 -	En el caso de <code>hexadecimal</code> se contemplo que <code>0x</code> seria un error o si tiene letras fuera del rango 
 	de la a-fA-F
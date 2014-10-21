Documentacion fase 3 / Semantic
=====================================
Autores: Erwin Morataya y Diego Calderon

 -	Para crear nuestra tabla de simbolos implementamos una clase `Table` que contiene el nombre de la tabla, el padre de la tabla y una 	HashTable que contiene el nombre de la variable o metodo, el tipo y si es metodo contiene tambien el tipo de cada uno de sus 		parametros. Tambien implementamos la clase `SymbolTable` que va a contener todas las tablas creadas en forma de una lista.

 - 	Para hacer las verificaciones de unicidad, existencia y tipos realizamos un metodo para cada clase que se encarga de hacer las
 	verificaciones, en la clase semantic en donde recibimos un ast obtenemos el root que contiene los nodos del ast y verificamos cada nodo para ver a que clase pertenece y aplicarle su metodo de verificacion. Para cada uno de estos metodos de verificacion se pasa como parametro la tabla y la lista de tablas para verificar la unicidad y existencia de las variables declaradas viendo cada tabla de la lista por medio del padre de la tabla. Para la verificacion de tipos se realizaron metodos para las expresiones que nos van a dar como resultado un string y ese string va ser el tipo de la expresion y ese string se compara con el tipo de la variable a la que se le esta asignando la expresion para ver si corresponden, en el caso de if y while se verifica que el resultado de la expresion sea boolean.
 -	Se agrego una lista que se le pasa a los metodos `check` donde se pueden generar errores para poder agregarlos al listado y 			posteriormente desplegarlos
 -	Se verifico que los arreglos no puedan ser de 0 posiciones, no se verifico que fueran positivos por que por la gramatica solo se 		puede tener numeros  mayores o iguales que 0 

Ejemplo 
-------------------------------------

```java
int a;

int add(int a, int b) {
	return a + b;
}

int main() {
	a = add(2, 3);
	return a;
}
```

Este codigo generaria las siguientes tablas de simbolos:

**Parent:** null   
**Name:** ROOT

|    nombre    |     tipo       |  tipos de parametros   |
|:------------:|:--------------:|:----------------------:|
|      a       |      int       |         null           |
|     add      |      int       |       {int, int}       |
|     main     |      int       |         null           |

**Parent:** ROOT   
**Name:** add

|    nombre    |     tipo       |  tipos de parametros   |
|:------------:|:--------------:|:----------------------:|
|      a       |      int       |         null           |
|      b       |      int       |         null           |

 - no hay declaraciones de variables en main por lo tanto no tiene tabla de simbolos

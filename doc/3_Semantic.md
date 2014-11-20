Documentación fase 3 / Semantic
=====================================
Autores: Erwin Morataya y Diego Calderón

 -	Para crear nuestra tabla de símbolos implementamos una clase `Table` que contiene el nombre de la tabla, el padre de la tabla y una 	HashTable que contiene el nombre de la variable o método, el tipo y si es método contiene también el tipo de cada uno de sus 		parámetros. También implementamos la clase `SymbolTable` que va a contener todas las tablas creadas en forma de una lista y se creo un método para poder buscar cada tabla por medio de su nombre.

 - 	Para hacer las verificaciones de unicidad, existencia y tipos realizamos un método `check` para cada clase que se encarga de hacer estas verificaciones, en la clase semantic en donde recibimos un ast obtenemos el root que contiene los nodos del ast y verificamos cada nodo para ver a que clase pertenece y aplicarle su método de verificación. Para cada uno de estos métodos de verificacién se pasa como parámetro la tabla, la lista de todas las tablas y una lista de errores y para verificar la unicidad y existencia de las variables declaradas se revisa cada tabla de la lista por medio del padre de la tabla. Para la verificación de tipos se realizaron métodos para las expresiones que nos van a dar como resultado un string y ese string va ser el tipo de la expresión y ese string se compara con el tipo de la variable a la que se le esta asignando la expresión para ver si corresponden, este string además puede ser de tipo "error" que nos indica que se estan operando ints con booleans o que los tipos no corresponden con la operación. Este string también nos sirve para la verificación de la condición de un if y while, la inicialización del for, el tipo de return de un método y verificaciones de este tipo.
 -	La lista de errores se le pasa a los métodos `check` en donde se pueden generar errores para poder agregarlos al listado y 			posteriormente desplegarlos.
 -	Se verifico que los arreglos no puedan ser de 0 posiciones, no se verifico que fueran positivos porque por la gramatica solo se 		pueden tener números  mayores o iguales a 0.

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

Este código generaría las siguientes tablas de símbolos:

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

 - no hay declaraciones de variables en main por lo tanto no tiene tabla de símbolos

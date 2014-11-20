Documentacion fase 3 / Irt-Codegen
=====================================
Autores: Erwin Morataya y Diego Calderon
 - 	Se realizaron las dos fases juntas para agilizar el tiempo de desarrollo dado que solo generamos codigo para `MIPS`.
 - 	Se modifico parte de lo desarrollado para la fase de semantic.
 -	Se implementaron metodos destruct para todos los nodos del AST, por comodidad y orden se movieron las clases que heredan de `Node` a un subpaquete llamado `nodes`.
 - 	Para el manejo de registros se crearon las clases
 		- `Register`: Contiene un campo con el numero de registro y el tipo (s o t)
 		- `RegisterManager`: Administra el uso de los registros posee un metodo para otorgar registros y otro para recibir registros que se han dejado de usar para evitar el uso de un registro dos veces y se tenga perdida de datos.
 - 	Se creo una clase abstracta `Instruction` de la que heredan todos los tipos de instrucciones:
 	- `Alu`: esta instruccion abarca todos los tipos de instruccion en la que se realicen operaciones matematico logicas(suma, resta, multiplicacion, division).
 	- `Immediate`: Pendiente de uso
 	- `Jump`: saltos a etiquetas o registros (jal, jr, j)
 	- `Label`: indica un label en el codigo
 	- `LoadStore`: sw, lw, sb, lb.
 	- `Syscall`: llamada a funcion del sistema de MIPS

 -	Se implemento una funcion `print(int n)` para poder desplegar resultados, se agrego a la tabla de simbolos en semantic para que no fuera una función invalida para las verificaciones de semantic.
	 ```Assembly
	print:
		add $sp $sp -8
		sw $a0 0($sp)
		sw $v0 4($sp)
		li $a0 0($fp)
		li $v0 1
		syscall
		lw $a0 0($sp)
		lw $v0 4($sp)
		add $sp $sp 8
		jr $ra
	```

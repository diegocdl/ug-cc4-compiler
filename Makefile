make: scanner\DecafLexer.java scanner\DecafLexer.class scanner\Scanner.class	\
	parser\DecafParser.java parser\DecafParser.class parser\CC4Parser.class 	\
	ast\Ast.class \
	semantic\Semantic.class semantic\Table.class \
	irt\Irt.class codegen\Codegen.class		\
	opt\Algebraic.class opt\ConstantFolding.class 		\
	lib\Debug.class lib\ErrorHandler.class lib\OutputFile.class		\
	Compiler.class

Compiler.class: Compiler.java
	javac Compiler.java

# Scanner
scanner\Scanner.class: scanner\Scanner.java
	javac scanner\Scanner.java

scanner\DecafLexer.java: scanner\DecafLexer.g
	java org.antlr.v4.Tool scanner\DecafLexer.g

scanner\DecafLexer.class: scanner\DecafLexer.java
	javac scanner\DecafLexer.java

# Parser
parser\CC4Parser.class: parser\CC4Parser.java
	javac parser\CC4Parser.java

parser\DecafParser.java: parser\DecafParser.g
	java org.antlr.v4.Tool -visitor -lib scanner parser\DecafParser.g

parser\DecafParser.class: parser\DecafErrorListener.java parser\ParseListener.java parser\DecafParser.java 
	javac parser\ParseListener.java
	javac parser\DecafErrorListener.java
	javac parser\DecafParser.java

# ast	
ast\Ast.class: 	ast\Ast.java ast\AstVisitor.java ast\BinOp.java ast\Cond.java ast\Cycle.java 				\
				ast\Declaracion.java ast\Exp.java ast\GraphicTree.java ast\Literal.java ast\MethodCall.java 	\
				ast\Node.java ast\Root.java ast\Statement.java ast\VarLiteral.java
	javac ast/*.java

# Semantic
semantic\Semantic.class: semantic\Semantic.java
	javac semantic\Semantic.java

semantic\Table.class: semantic\Table.java
	javac semantic\Table.java

# Irt
irt\Irt.class: irt\Irt.java
	javac irt\Irt.java

# codegen
codegen\Codegen.class: codegen\Codegen.java
	javac codegen\Codegen.java


# optimizacion
opt\Algebraic.class: opt\Algebraic.java
	javac opt\Algebraic.java

opt\ConstantFolding.class: opt\ConstantFolding.java
	javac opt\ConstantFolding.java

# Lib
lib\Debug.class: lib\Debug.java
	javac lib\Debug.java

lib\ErrorHandler.class: lib\ErrorHandler.java
	javac lib\ErrorHandler.java

lib\OutputFile.class: lib\OutputFile.java
	javac lib\OutputFile.java

clean:
	del Compiler.class
	del scanner\*.class
	del scanner\DecafLexer.java
	del scanner\DecafLexer.tokens
	del parser\*.class
	del parser\DecafParser.java
	del parser\DecafParser.tokens
	del ast\*.class
	del semantic\*.class
	del irt\*.class
	del codegen\*.class
	del opt\*.class
	del lib\*.class
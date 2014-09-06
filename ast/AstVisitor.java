package compiler.ast;

import compiler.parser.CC4Parser;
import compiler.lib.Debug;
import compiler.lib.OutputFile;
import java.util.List;
import java.util.LinkedList;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Token;
import compiler.parser.DecafParser;
import compiler.parser.DecafParserBaseVisitor;

public class AstVisitor extends DecafParserBaseVisitor<Node>{

	// @Override
	// public Node visitStart(DecafParser.StartContext ctx) {
	// 	return visit(ctx.program());
	// }

	@Override
	public Node visitRoot(DecafParser.RootContext ctx){
		Root root = new Root();											// raiz del arbol
		List<DecafParser.Field_declContext> list = ctx.field_decl();	// lista con todas las expresiones, exp()
		
		for(DecafParser.Field_declContext e : list) {
			Node n = visit(e);
			root.add(n);												// visitar cada expresion
		}
		return root;
	}
	
	@Override
	public Node visitLiterales(DecafParser.LiteralesContext ctx){
		return new Literal(ctx.literal().getText());	//crear nodo que represente int, pasar como argumento el contenido del token
	}
	
	@Override
	public Node visitPar(DecafParser.ParContext ctx){
		return visit(ctx.expr());						//visitar expresion
	}
	
	@Override
	public Node visitBloque(DecafParser.BloqueContext ctx){
		// Root root2 = new Root();		
		// for(DecafParser.Field_declContext e : ctx.field_decl()){
		// 	root2.add(visit(e));							//visitar cada expresion
		// }
		// for(DecafParser.StatementContext e : ctx.statement()){
		// 	root2.add(visit(e));						//visitar cada expresion
		// }
		return null;
	}
	
	@Override
	public Node visitAsignacion(DecafParser.AsignacionContext ctx){
		return new Asign(visit(ctx.location()), ctx.ASIG_OP().getText(), visit(ctx.expr()));	//crear nodo para expresion binaria, signo del operador y visita a cada expresion
	}
	
	@Override
	public Node visitStatements(DecafParser.StatementsContext ctx){
		if((ctx.KW_RETURN()==null)&&(ctx.KW_CONTINUE()==null)&&(ctx.method_call()==null)){
			TerminalNode op = ctx.KW_BREAK();
			return new Statement(op.getText());
		}else if((ctx.KW_BREAK()==null)&&(ctx.KW_CONTINUE()==null)&&(ctx.method_call()==null)){
			TerminalNode op = ctx.KW_RETURN();
			return new Statement(op.getText(), visit(ctx.expr()));
		}else if((ctx.KW_BREAK()==null)&&(ctx.KW_RETURN()==null)&&(ctx.method_call()==null)){
			TerminalNode op = ctx.KW_CONTINUE();
			return new Statement(op.getText());
		}else{
			return visit(ctx.method_call());
		}
		
	}
	
	@Override
	public Node visitIfs(DecafParser.IfsContext ctx){
		if(ctx.KW_ELSE()==null){		//crear nodo terminal
			return new Cond(visit(ctx.expr()), visit(ctx.block(0)));	//crear nodo para expresion binaria, signo del operador y visita a cada expresion
		}else{
			return new Cond(visit(ctx.expr()), visit(ctx.block(0)), visit(ctx.block(1)));
		}
	}
	
	@Override
	public Node visitCiclo(DecafParser.CicloContext ctx){
		if(ctx.KW_WHILE()==null){		//crear nodo terminal
			//crear nodo para expresion binaria, signo del operador y visita a cada expresion
			return 
				new Cycle(
					new Asign(
						new VarLiteral( ctx.ID().getText() ),
						ctx.ASIG_OP().getText(),
						visit(ctx.expr(0))
					),
					visit(ctx.expr(1)), 
					visit(ctx.block())
				);	
		}else{
			return new Cycle(visit(ctx.expr(0)), visit(ctx.block()));
		}
	}
	
	@Override
	public Node visitOperacion(DecafParser.OperacionContext ctx){
		return new BinOp(ctx.bin_op().getText(), visit(ctx.expr(0)), visit(ctx.expr(1)));
	}

	@Override
	public Node visitField_decl(DecafParser.Field_declContext ctx) {
		LinkedList<VarLiteral> ids = new LinkedList<VarLiteral>();
		List<TerminalNode> idNodos = ctx.ID();
		List<TerminalNode> intNodos = ctx.INT_LITERAL();

		for(int i = 0, j = 0; i < idNodos.size(); i++){
			TerminalNode nodo = idNodos.get(i);
			if(intNodos != null && intNodos.size() > 0){
				Token tokenInt = intNodos.get(j).getSymbol();
				Token tokenId = nodo.getSymbol();
				if(tokenId.getTokenIndex() == tokenInt.getTokenIndex() - 2 ){
					try{
						ids.add(new VarLiteral(nodo.getText(), Integer.parseInt(tokenInt.getText())));
						j++;
					} catch (Exception e) {
						e.printStackTrace();
						// se ignora la excepcion por que tokenInt es Int_literal y no puede contener otra cosa
						// que no se numeros 
					}
				}else{
					ids.add(new VarLiteral(nodo.getText()));
				}
			}else{
				ids.add(new VarLiteral(nodo.getText()));
			}
		}
		Declaracion dec = new Declaracion(
					visit(ctx.type()).toString(),
					ids
					);
		return dec;
	}


	@Override
	public Node visitType(DecafParser.TypeContext ctx) {
		if(ctx.KW_INT() == null ){
			return new Literal(ctx.KW_BOOL().getText()); 
		} else {
			return new Literal(ctx.KW_INT().getText()); 
		}
	}
	
	@Override
	public Node visitExp(DecafParser.ExpContext ctx){
		if((ctx.location()==null)&&(ctx.method_call()==null)&&(ctx.MINUS()==null)){		//crear nodo terminal
			return new Exp(ctx.NEGATION().getText(), visit(ctx.expr()));
		}else if((ctx.location()==null)&&(ctx.method_call()==null)&&(ctx.NEGATION()==null)){
			return new Exp(ctx.MINUS().getText(), visit(ctx.expr()));
		}else if((ctx.MINUS()==null)&&(ctx.method_call()==null)&&(ctx.NEGATION()==null)){
			return new Exp(visit(ctx.location()));
		}else {
			return new Exp(visit(ctx.method_call()));
		}
	}
	
}

package evaluator.arith;

import language.Operand;
import language.Operator;
import language.arith.NegateOperator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	//LinkedStack<Operand<Integer>> node;
	//int operandcount=0;
	//int operatorcount=0;
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
		//this.stack = null; //TODO initialize your LinkedStack
	stack=new LinkedStack<Operand<Integer>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		// TODO use all of the things you've built so far to 
		// implement the algorithm for postfix expression evaluation
		//DivOperator<Integer> div;
		//Operator<Integer> addition=new PlusOperator();
		//Operator<Integer> operator;
		//operator=new NegateOperator();
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
				//TODO What do we do when we see an operand?
				Operand<Integer> v=token.getOperand();
				stack.push(v);
				//operandcount++;
				break;
			case OPERATOR:
				//TODO What do we do when we see an operator?
				Operator<Integer> o=token.getOperator();
				//operatorcount++;
				if(o.getNumberOfArguments()==1)
				{
					Operand<Integer> y1=stack.top();
					stack.pop();
					o.setOperand(0, y1);
					Operand<Integer> result1=o.performOperation();
					stack.push(result1);
					
				}
				else if(o.getNumberOfArguments()==2)
				{
				Operand<Integer> x1=stack.top();
				stack.pop();
				Operand<Integer> x2=stack.top();
				stack.pop();
				o.setOperand(1, x1);
				o.setOperand(0, x2);
				Operand<Integer> result=o.performOperation();
				stack.push(result);
				}
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}			
		}
		
		//TODO What do we return?
	if(stack.size()==1)
		//if(operandcount<operatorcount||operandcount==operatorcount)
			//throw new IllegalPostfixExpressionException();
		//else
		return stack.pop().getValue();
		else
			throw new IllegalPostfixExpressionException();
	}

}

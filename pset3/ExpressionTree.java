public class ExpressionTree {
	
	private ExpressionNode root;
	private MyStack expressionStack;

	private static ExpressionTree(String postfix) {
		//run through stack based algo to build expr tree.
		//remember you're pushing ExpressionNode onto the stack.
		//when done, pop the stack and make that the root

	}

	public int eval() {
		return eval(root);
	}

	public String postfix() {
		//will return the integer value associated with evaluating
		//the expression tree. Will need to call a private recursive
		//method that takes the root
	}

	public String prefix() {
		//returns String containing the corresponding prefix expression
	}

	public String infix()

	private int eval(ExpressionNode t) {

		//traversal to evaluate tree rooted at t and return it
	}


	private static class ExpressionNode {
		int operand;
		char operator;
		ExpressionNode left;
		ExpressionNode right;

		ExpressionNode(AnyType theElement) {
			this( theElement, null, null);
		}

		ExpressionNode(AnyType theElement, ExpressionNode lt, ExpressionNode rt) {
			if(theElement is an operand) {
				operand = theElement;
			}
			else if (theElement is an operator) {
				operator = theElement;
			}

			left = lt;
			right = rt;
		}
	}
	
}
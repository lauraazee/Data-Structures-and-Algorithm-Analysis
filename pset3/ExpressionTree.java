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
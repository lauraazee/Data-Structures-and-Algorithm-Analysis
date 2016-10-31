public class ExpressionTree {
	
	private ExpressionNode root; 
	private char[] operatorArray; 
	
	private static ExpressionTree(String postfix) {

		char[] numberArray = {'1','2','3','4','5','6','7','8','9'}; 
		char[] operatorArray = {'+','-','*','/'}; // can you do this? Do you need a constructor
		String integerBuffer = "";
		MyStack<ExpressionNode> treeStack = new MyStack<>; //syntax
		
		
		for (int i = 0; i < postfix.length; i++) {
			char c = postfix.charAt(i);
			
			for (int i = 0; i < operatorArray.length(); i++) {
				if (c == operatorArray[i]) {
					ExpressionNode leftNode = treeStack.pop();
					ExpressionNode rightNode = treeStack.pop();
					ExpressionNode operator = new ExpressionNode(c,leftNode,rightNode);
					ExpressionNode root = operator;
					treeStack.push(operator);
				}

			if (c == ' ' && integerBuffer != "") {
				ExpressionNode operand = new ExpressionNode((int) integerBuffer);
				treeStack.push(operand);
				integerBuffer = "";
			}

			else {
				for (int i = 0; i < numberArray.length(); i++) {
					if (c == numberArray[i]) {
						integerBuffer = integerBuffer + (String) c;
					}
				}
			}
		}
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

 
		//traversal to evaluate tree rooted at t and return it
	}

	private int eval(ExpressionNode tree) {
		postfix(tree);
		for 
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
			for (int i = 0; i < operatorArray.length(); i++) {
				if (theElement == operatorArray[i]) {
					operator = theElement;
				}
				else { //integers
					operand = theElement;
			}
			
			left = lt;
			right = rt;
		}
	}
	
}
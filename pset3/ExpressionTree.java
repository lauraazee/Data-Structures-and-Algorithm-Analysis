public class ExpressionTree {
	
	private ExpressionNode root; 
	private char[] operatorArray; 
	private char[] operandArray;
	
	private static ExpressionTree(String postfix) {

		char[] numberArray = {'1','2','3','4','5','6','7','8','9'}; 
		char[] operatorArray = {'+','-','*','/'};
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
		return postfix(root);
	}

	public String prefix() {
		return prefix(root);
	}

	public String infix() {
		return infix(root);
	}

	private int eval(ExpressionNode t) {
	}

	private String prefix(ExpressionNode t) {
		if (t != null) {
			System.out.println(t.element);
			prefix(t.left);
			prefix(t.right);
		}
	}
	private String postfix(ExpressionNode t) {
		if (t != null) {
			postfix(t.left);
			postfix(t.right);
			System.out.println(t.element);
		}
	}

	private String infix(ExpressionNode t) {
		if (t != null) {
			infix(t.left);
			System.out.println(t.element);
			infix(t.right);
		}
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
				if (theElement == operatorArray[i]) { // can this class access the array?
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
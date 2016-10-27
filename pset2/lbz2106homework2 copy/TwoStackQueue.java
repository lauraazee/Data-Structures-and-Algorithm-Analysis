/* Laura Zhang
 * lbz2106
 * creates a queue from two stacks
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	private MyStack<AnyType> stack1;
	private MyStack<AnyType> stack2;

	public TwoStackQueue() {
		this.stack1 = new MyStack<AnyType>();
		this.stack2 = new MyStack<AnyType>();
	}
	

	public void enqueue(AnyType x) {
		
		//all items from stack2 need to be pushed to stack2 first to 
		//ensure that the items are lined up in the right order
		while (stack2.isEmpty() == false) {
			AnyType stack2Element = stack2.pop();
			stack1.push(stack2Element);
		}

		stack1.push(x);

	}


	public AnyType dequeue() {
		
		//all items from stack1 need to be pushed to stack2 to make
		//sure they dequeue in the right order
		while (stack1.isEmpty() == false) {
			AnyType stack1Element = stack1.pop();
			stack2.push(stack1Element);
		}

		if (stack2.isEmpty() == false) {
			return stack2.pop();
		}
		else {
			return null;
		}
	}

	public boolean isEmpty() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

}
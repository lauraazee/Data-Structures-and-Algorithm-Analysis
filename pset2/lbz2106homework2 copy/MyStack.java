import java.util.ArrayList;

public class MyStack<E> {
	private ArrayList<E> myStack;

	public MyStack() {
		this.myStack = new ArrayList<E>();
	}

	public void push(E object) {
		myStack.add(object);
	}

	public E pop() {
		return myStack.remove(myStack.size()-1);
	}

	public E top() {
		return myStack.get(myStack.size()-1);
	}

	public boolean isEmpty() {
		return myStack.isEmpty();
	}

	public int size() {
		return myStack.size();
	}

}
package com.learn.ds;

public class ArrayStack {

	public final static int MAX_SIZE = 100;
	private int top;
	private int[] arr;

	public ArrayStack() {
		this.arr = new int[MAX_SIZE];
		this.top = -1;
	}

	public boolean push(int data) {
		if (isFull()) {
			return false;
		}
		top = top + 1;
		arr[top] = data;
		return true;
	}

	public int pop() {
		if (isEmpty()) {
			return -1;
		}
		int result = arr[top];
		arr[top] = 0;
		top = top - 1;
		return result;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return arr[top];
	}

	public boolean isFull() {
		return top - 1 == MAX_SIZE;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int search(int data) {
		if (isEmpty()) {
			return -1;
		}
		for (int i = 0; i < top; i++) {
			if (data == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public void reverse() {
		if (isEmpty()) {
			return;
		}
		int n = top / 2;
		for (int i = 0, j = top; i <= n; i++, --j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		printStack();
	}

	
	public static void pushToStack(ArrayStack stack, int v) {
		if(stack.isEmpty()) {
			stack.push(v);
		} else {
			int i = stack.pop();
			pushToStack(stack, v);
			stack.push(i);
		}
	}
	
	public static void reverse(ArrayStack stack) {
		if (stack.isEmpty()) {
			return;
		}
		int v = stack.pop();
		reverse(stack);
		pushToStack(stack, v);
	}

	public static int factorial(int n) {
		return n == 1 ? 1 : n * factorial(n - 1);
	}

	public void printStack() {
		for (int i = top; i >= 0; --i) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();

	}

	public static void main(String[] args) throws Exception {
		ArrayStack s = new ArrayStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.printStack();
		reverse(s);
		s.printStack();

		//System.out.println(factorial(6));

	}

}

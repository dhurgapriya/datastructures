package com.learn.ds;

public class LinkedListStack {

	static class Node {
		Node next;
		int data;

		Node(int data, Node n) {
			this.next = n;
			this.data = data;
		}
	}

	private Node top;

	public void push(int data) {
		Node n = new Node(data, top);
		top = n;
	}

	public int peek() {
		if (top == null) {
			return -1;
		}
		return top.data;
	}

	public int pop() {
		if (top == null) {
			return -1;
		}
		Node temp = top;
		top = top.next;
		return temp.data;
	}

	public Node search(int data) {
		if (top == null) {
			return null;
		}
		Node temp = top;
		while (temp != null) {
			if (temp.data == data) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void printLinkedListStack() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	
	public void reverse() {
		if(top == null || top.next == null) {
			return;
		}
		Node p1 = null;
		Node p2 = top;
		while(p2 != null) {
			Node temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		top = p1;
	}
	public static void main(String[] args) {
		LinkedListStack s = new LinkedListStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.printLinkedListStack();
		s.reverse();
		s.printLinkedListStack();
	}
}

package com.learn.ds;

public class LinkedListQueue {

	static class Node {
		Node next;
		int data;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;

	public void offer(int data) {
		Node newNode = new Node(data, null);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
	}

	public int poll() {
		if (isEmpty()) {
			return -1;
		}
		int x = head.data;
		head = head.next;
		return x;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void printLinkedListQueue() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		LinkedListQueue q = new LinkedListQueue();
		q.offer(1);
		q.printLinkedListQueue();
		q.offer(2);
		q.printLinkedListQueue();
		q.offer(3);
		q.printLinkedListQueue();
		q.offer(4);
		q.printLinkedListQueue();
		q.offer(5);
		q.printLinkedListQueue();
		q.poll();
		q.printLinkedListQueue();
		q.poll();
		q.printLinkedListQueue();
		q.poll();
		q.printLinkedListQueue();

	}
}

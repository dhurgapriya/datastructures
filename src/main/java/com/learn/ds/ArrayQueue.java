package com.learn.ds;

public class ArrayQueue {

	private int head;
	private int tail;
	private int[] arr;
	private static final int MAX_SIZE = 10;

	public ArrayQueue() {
		this.head = -1;
		this.tail = -1;
		this.arr = new int[MAX_SIZE];
	}

	public boolean offer(int data) {
		if (isFull()) {
			return false;
		}
		if (isEmpty()) {
			head = head + 1;
			tail = tail + 1;
			arr[head] = data;
		} else if (tail == MAX_SIZE - 1) {
			for (int i = 0; head <= MAX_SIZE; i++, head++) {
				arr[i] = arr[head];
			}
		} else {
			tail = tail + 1;
			arr[tail] = data;
		}
		return true;
	}

	public int poll() {
		if (isEmpty()) {
			return -1;
		}
		int x = arr[head];
		if (head == tail) {
			head = -1;
			tail = -1;
		} else {
			arr[head] = -1;
			head = head + 1;
		}
		return x;
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return arr[head];
	}

	public boolean isEmpty() {
		return head == -1;
	}

	public boolean isFull() {
		return head == 0 && tail == MAX_SIZE - 1;
	}

	public void printArrayQueue() {
		for (int i = head; i <= tail; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		queue.offer(6);
		queue.offer(7);
		queue.offer(8);
		queue.offer(9);
		queue.offer(10);
		System.out.println(queue.isFull());
		queue.offer(10);

		queue.printArrayQueue();
		System.out.println(queue.poll());
		queue.printArrayQueue();
		System.out.println(queue.poll());
		queue.printArrayQueue();
		System.out.println(queue.poll());
		queue.printArrayQueue();

	}

}

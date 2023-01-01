package com.learn.ds;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	private Node head;
	private Node tail;

	static class Node {
		Node next;
		int data;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public void insertAtHead(int data) {
		Node n = new Node(data, head);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			head = n;
		}
	}

	public void insertAtTail(int data) {
		if (head == null) {
			insertAtHead(data);
		} else {
			Node n = new Node(data, null);
			tail.next = n;
			tail = n;
		}
	}

	public void insertAfter(int data, int insertAfter) {
		if (head == null || tail.data == insertAfter) {
			insertAtTail(data);
		} else {
			Node n = search(insertAfter);
			if (n == null) {
				insertAtTail(data);
			} else {
				Node newNode = new Node(data, null);
				Node temp = n.next;
				n.next = newNode;
				newNode.next = temp;
			}
		}
	}

	public void insertBefore(int data, int insertBefore) throws Exception {
		if (head == null || head.data == insertBefore) {
			insertAtHead(data);
		} else {
			Node n = head;
			while (n != null) {
				Node temp = n.next;
				if (temp != null && temp.data == insertBefore) {
					Node newNode = new Node(data, null);
					n.next = newNode;
					newNode.next = temp;
					return;
				}
				n = n.next;
			}
			throw new Exception("No such value found :" + insertBefore);
		}

	}

	public void delete(int data, boolean isDeleteAll) {
		if (head == null) {
			return;
		}
		while (head != null) {
			if (head.data == data) {
				head = head.next;
				if (!isDeleteAll) {
					return;
				}
			} else {
				break;
			}
		}
		Node n = head;
		while (n != null) {
			Node temp = n.next;
			if (temp != null && temp.data == data) {
				n.next = temp.next;
				temp = null;
				if (!isDeleteAll) {
					return;
				}
			}
			n = n.next;
		}
	}

	public Node search(int data) {
		if (head == null) {
			return null;
		}
		if (tail.data == data) {
			return tail;
		}
		Node n = head;
		while (n != null) {
			if (data == n.data) {
				return n;
			}
			n = n.next;
		}
		return null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void printLinkedList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			n = n.next;
			if (n != null) {
				System.out.print("->");
			}
		}
		System.out.println();
	}

	public static void printOddNodes(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		Node p1 = list.head;
		while (p1 != null) {
			System.out.print(p1.data);
			p1 = p1.next != null ? p1.next.next : null;
			if (p1 != null) {
				System.out.print("->");
			}
		}
		System.out.println();
	}

	public static void printEvenNodes(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		Node p1 = list.head.next;
		while (p1 != null) {
			System.out.print(p1.data);
			p1 = p1.next != null ? p1.next.next : null;
			if (p1 != null) {
				System.out.print("->");
			}
		}
		System.out.println();
	}

	public static Node middleOfLinkedList(LinkedList list) {
		if (list.isEmpty()) {
			return null;
		}
		Node p1 = list.head;
		Node p2 = list.head.next;
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next != null ? p2.next.next : null;
		}
		System.out.println(p1.data);
		return p1;
	}

	public static int lengthOfLinkedList(LinkedList list) {
		int length = 0;
		Node n = list.head;
		while (n != null) {
			length++;
			n = n.next;
		}
		System.out.println(length);
		return length;
	}

	public static boolean doesLinkedListHasLoop(LinkedList list) {
		if (list.isEmpty()) {
			return false;
		}
		Node p1 = list.head;
		Node p2 = list.head.next;
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next != null ? p2.next.next : null;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	public static void deleteLoopInLinkedList(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		Set<Node> s = new HashSet<>();
		Node n = list.head;
		while (n != null) {
			Node temp = n.next;
			if (s.contains(temp)) {
				n.next = null;
				break;
			} else {
				s.add(n);
			}
			n = n.next;
		}
		list.printLinkedList();
	}

	public static void deleteLinkedList(LinkedList list) {
		list.head = null;
		list.tail = null;
	}

	public static void deleteMiddleOfLinkedList(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		Node p1 = list.head;
		Node p2 = list.head.next;
		Node n = null;
		while (p2 != null) {
			p2 = p2.next != null ? p2.next.next : null;
			if (p2 == null) {
				n = p1;
			}
			p1 = p1.next;
		}
		n.next = p1.next;
		p1.next = null;
		list.printLinkedList();
	}

	public static void deleteDuplicateElements(LinkedList list) {
		Set<Integer> s = new HashSet<>();
		Node n = list.head;
		s.add(n.data);
		while (n != null) {
			Node temp = n.next != null ? n.next : null;
			if (temp == null) {
				break;
			}
			if (s.contains(temp.data)) {
				// remove n
				n.next = temp.next;
				temp.next = null;
			} else {
				s.add(temp.data);
				n = n.next;
			}
		}
		list.printLinkedList();
	}

	public static void removeNode(int data, LinkedList list) {
		Node node = list.search(data);
		if (node != null) {
			Node temp = node.next;
			node.next = temp.next;
			node.data = temp.data;
		}
		list.printLinkedList();
	}

	public static void deleteNthNodeFromEnd(int n, LinkedList list) {
		int size = lengthOfLinkedList(list);
		int x = (size - n);
		int count = 1;
		Node node = list.head;
		while (node != null) {
			if (count == x) {
				node.next = node.next.next;
				break;
			}
			node = node.next;
			count++;
		}
		list.printLinkedList();
	}

	public static void removeEvenNumberFromLinkedList(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		while (list.head.data % 2 == 0) {
			list.head = list.head.next;
		}
		Node n = list.head;
		while (n != null) {
			Node temp = n.next;
			if (temp != null && temp.data % 2 == 0) {
				n.next = temp.next;
			} else {
				n = n.next;
			}
		}
		list.printLinkedList();
	}

	public static void moveFirstNodeToEnd(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		Node head = list.head;
		Node p1 = list.head.next;
		list.head = p1;
		while (p1 != null) {
			if (p1.next == null) {
				Node node = new Node(head.data, null);
				p1.next = node;
				break;
			}
			p1 = p1.next;
		}
		list.printLinkedList();
	}

	public static void moveLastNodeToFront(LinkedList list) {
		if (list.isEmpty()) {
			return;
		}
		Node n = list.head;
		while (n != null) {
			if (n.next == list.tail) {
				Node temp = list.tail;
				n.next = null;
				list.tail = n;
				temp.next = list.head;
				list.head = temp;
				break;
			}
			n = n.next;
		}
		list.printLinkedList();
	}

	public static boolean isLinkedListPalindrom(LinkedList list) {
		if (list.isEmpty()) {
			return false;
		}
		Node p1 = list.head;
		Node p2 = list.head.next;
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next != null ? p2.next.next : null;
		}
		Node n1 = null;
		Node n2 = p1;
		Node last = null;
		while (n2 != null) {
			Node temp = n2.next;
			if (temp == null) {
				last = n2;
			}
			n2.next = n1;
			n1 = n2;
			n2 = temp;
		}
		Node first = list.head;
		while (last != null) {
			if (first.data != last.data) {
				System.out.println("isPalindrom: " + false);
				return false;
			}
			first = first.next;
			last = last.next;
		}
		System.out.println("isPalindrom: " + true);
		return true;
	}

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();

		list.insertAtTail(1);
		list.insertAtTail(2);
		list.insertAtTail(3);
		list.insertAtTail(4);
		list.insertAtTail(5);
		list.insertAtTail(6);
		list.insertAtTail(7);
		list.insertAtTail(5);
		list.insertAtTail(8);
		list.insertAtTail(9);
		list.insertAtTail(10);

		list.printLinkedList();
		// Check if LinkedList is palindrome
		isLinkedListPalindrom(list);
		LinkedList palindrom = new LinkedList();
		palindrom.insertAtTail(1);
		palindrom.insertAtTail(2);
		palindrom.insertAtTail(3);
		palindrom.insertAtTail(3);
		palindrom.insertAtTail(2);
		palindrom.insertAtTail(1);
		isLinkedListPalindrom(palindrom);


		// Move the first element of the LinkedList to the end
		moveFirstNodeToEnd(list);

		// Move Last Element of LinkedList to Front
		moveLastNodeToFront(list);

		// print only odd nodes of LinkedList
		printOddNodes(list);

		// print only even nodes of LinkedList
		printEvenNodes(list);

		// Remove all even numbers from a LinkedList
		removeEvenNumberFromLinkedList(list);

		// delete nth node from the end
		deleteNthNodeFromEnd(6, list);

		// delete a node in LinkedList
		removeNode(5, list);

		// find the middle of the LinkedList
		middleOfLinkedList(list);

		// delete middle of linked list
		deleteMiddleOfLinkedList(list);

		// find the length of LinkedList
		lengthOfLinkedList(list);

		// delete duplicates in LinkedList
		deleteDuplicateElements(list);

		// does linkedlist has loop
		System.out.println(doesLinkedListHasLoop(list));
		LinkedList ll = new LinkedList();
		Node n1 = new Node(1, null);
		Node n2 = new Node(2, null);
		Node n3 = new Node(3, null);
		Node n4 = new Node(4, null);
		Node n5 = new Node(5, null);
		Node n6 = new Node(6, null);
		ll.head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n2;
		System.out.println(doesLinkedListHasLoop(ll));
		deleteLoopInLinkedList(ll);

		// delete a linked list
		deleteLinkedList(ll);
	}

}

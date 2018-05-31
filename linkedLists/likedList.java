package linkedLists;

import java.util.*;

//import linkedLists.LinkedList.Node;

public class likedList {
	class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public likedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	int size() {
		return size;

	}

	boolean isEmpty() {
		return size == 0;

	}

	public void display() {
		for (Node temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}

	void addFirst(int value) {
		if (size == 0) {
			handleZSize(value);
			return;
		}
		Node temp = new Node();
		temp.data = value;
		temp.next = head;
		this.head = temp;
		size++;

	}

	void addLast(int value) {
		if (size == 0) {
			handleZSize(value);
			return;
		}
		Node temp = new Node();
		temp.data = value;
		this.tail.next = temp;
		this.tail = temp;
		size++;
	}

	void handleZSize(int value) {
		Node temp = new Node();
		temp.data = value;
		head = temp;
		tail = temp;
		size++;

	} 

	void addAt(int value, int idx) {
		if (idx < 0 || idx >= size) {
			System.out.println("out of bound");
			return;
		}
		if (idx == 0)
			addFirst(value);
		else if (idx == size)
			addLast(value);
		else {
			Node temp = new Node();
			temp.data = value;
			Node im1 = getNodeAt(idx - 1);
			temp.next = im1.next;
			im1.next = temp;
		}
	}

	private Node getNodeAt(int idx) {
		if (size < 0 || idx >= size) {
			System.out.println("Index Out Of Bounds");
			return null;
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp; 
	}

	
	private int handleSizeOneRemoval() {

		int temp = head.data;
		
			head = tail = null;
			size = 0;
			return temp;
	}

	int removeAt2(int val) {

		if (head.data == val) {
			head = head.next;
			return val;
		}

		Node curr = head.next;
		Node prev = head;

		while (curr != null) {      

			if (curr.data == val) {
				prev.next = curr.next;
				return val;
			}

			curr = curr.next;
			prev = prev.next;
		}
		return -1;

	}

	int removeAt(int idx) {
		if (size < 0 || idx >= size) {
			System.out.println("Index Out Of Bounds");
			return -1;
		} else if (size == 0) {
			System.out.println("Underflow");
			return -1;
		} else if (size == 1) {
			return handleSizeOneRemoval();

		} else {
			Node im1 = getNodeAt(idx - 1);
			Node i = im1.next;
			Node ip1 = i.next;
			im1.next = ip1;
			// i.next=null;
			// This line is not required in java but is in c++.
			// This due to garbage collection algo of java called mark and sweep
			return i.data;

		}

	}
	public int mid(){
		 Node slow=head;Node fast=head;	

		 while(fast!=null&&fast.next!=null)  
		 { 
			 slow=slow.next; 
			 fast=fast.next.next; 
			  
		 }
		 return slow.data; 
		}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		likedList list = new likedList();
		while (n != 0) {
			String function = scn.next();
			if (function.equals("addFirst")) {
				int n1 = scn.nextInt();
				list.addFirst(n1);
			} else if (function.equals("addLast")) {
				int n1 = scn.nextInt();
				list.addLast(n1);

			} else if (function.equals("addAt")) {
				int n1 = scn.nextInt();
				int n2 = scn.nextInt();
				list.addAt(n1, n2);
			} else if (function.equals("delete")) {
				int n1 = scn.nextInt();
				int del = list.removeAt(n1);
			}

			n--;
		}

		list.display();
	}
}
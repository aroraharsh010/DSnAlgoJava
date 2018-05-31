package hashMaps;

public class GenericLinkedList<T> {
	private class Node {
		T data;
		Node next;

	}

	private Node head;
	private Node tail;
	private int size;

	int size() {
		return size;

	}

	boolean isEmpty() {
		return size == 0;

	}

	void display() {
		for (Node temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}

	void addFirst(T value) {
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

	void addLast(T value) {
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

	void handleZSize(T value) {
		Node temp = new Node();
		temp.data = value;
		head = temp;
		tail = temp;
		size++;
		// temp.data=value;
	} 

	T getFirst() {
		// Node temp=head;
		return head.data;
	}

	T getLast() {
		// Node temp=tail;
		return tail.data;
	}

	T getAt(int idx) {
		if (size < 0 || idx >= size) {
			System.out.println("Index Out Of Bounds");
			return null;
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
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

	void addAt(T value, int idx) {
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

	T removeFirst() {

		if (size == 0) {
			System.out.println("Underflow");
			return null;
		} else if (size == 1) {
			return handleSizeOneRemoval();

		} else {
			Node temp = head;
			Node ip1 = temp.next;
			head = ip1;
			return temp.data;
		}
	}

	T removeLast() {
		if (size == 0) {
			System.out.println("Underflow");
			return null;
		} else if (size == 1) {
			return handleSizeOneRemoval();

		} else {
			Node temp = tail;
			Node im1 = getNodeAt(size - 2);
			tail = im1;
			return temp.data;
		}
	}

	T removeAt(int idx) {
		if (size < 0 || idx >= size) {
			System.out.println("Index Out Of Bounds");
			return null;
		} else if (size == 0) {
			System.out.println("Underflow");
			return null;
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

	private T handleSizeOneRemoval() { 
		T temp = head.data;
		head = tail = null;
		size = 0;
		return temp;
	}

}

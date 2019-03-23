package linkedLists;

public class LinkedList {
	private class Node {
		int data;
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
		// temp.data=value;
	} 

	int getFirst() {
		// Node temp=head;
		return head.data;
	}

	int getLast() {
		// Node temp=tail;
		return tail.data;
	}

	int getAt(int idx) {
		if (size < 0 || idx >= size) {
			System.out.println("Index Out Of Bounds");
			return -1;
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

	int removeFirst() {

		if (size == 0) {
			System.out.println("Underflow");
			return -1;
		} else if (size == 1) {
			return handleSizeOneRemoval();

		} else {
			Node temp = head;
			Node ip1 = temp.next;
			head = ip1;
			return temp.data;
		}
	}

	int removeLast() {
		if (size == 0) {
			System.out.println("Underflow");
			return -1;
		} else if (size == 1) {
			return handleSizeOneRemoval();

		} else {
			Node temp = tail;
			Node im1 = getNodeAt(size - 2);
			tail = im1;
			return temp.data;
		}
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

	private int handleSizeOneRemoval() {
		int temp = head.data;
		head = tail = null;
		size = 0;
		return temp;
	}

	public void reverseDataIteratively() {
		for (int i = 0; i < size / 2; i++) {
			Node f = getNodeAt(i);
			Node s = getNodeAt(size - 1 - i);
			int tem = f.data;
			f.data = s.data;
			s.data = tem;
		}
	}

	public void reversePointerIterative() {

		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node ocnext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ocnext;

		}
		Node t = head; 
		head = tail;
		tail = t;

	}

	public void displayReverse() {
		recurseRev(head);

	}
 
	private void recurseRev(Node curr) {
		if (curr == null)
			return;
		recurseRev(curr.next);
		System.out.print(curr.data + " ");

	}

	public void reversePointerrecursive() {
		reversePointerRecursive(head);
		Node tem = head;
		head = tail;
		tail = tem;
		tail.next = null;
	}

	private void reversePointerRecursive(Node curr) {
		if (curr.next == null)
			return;
		reversePointerRecursive(curr.next);
		curr.next.next = curr;

	}

	public void reverseDataRecursivly() {

		heapMover left = new heapMover();
		left.node = this.head;
		reverseDataRecursivly(left, head, 0);
	}

	private class heapMover {
		Node node;
	} 

	private void reverseDataRecursivly(heapMover left, Node right, int counter) {
		if (right == null)
			return;
		reverseDataRecursivly(left, right.next, counter + 1);
		if (counter >= size / 2) {

			int t = left.node.data;
			left.node.data = right.data;
			right.data = t;
			left.node = left.node.next;

		}
	}

	public void fold() {
		heapMover left = new heapMover();
		left.node = this.head;
		fold(left, head, 0); 
	}

	private void fold(heapMover left, Node right, int counter) {
		if (right == null)
			return;
		fold(left, right.next, counter + 1);
		if (counter > size / 2) {

			Node ocnext = left.node.next;
			left.node.next = right;
			right.next = ocnext;
			left.node = ocnext;

		} else if (counter == size / 2) {
			tail = right;
			tail.next = null; 
		}
	}
	public boolean isPalindrome(){
		heapMover left = new heapMover();
		left.node = this.head; 
		return isPalindrome(left, head, 0); 
	} 
	private boolean isPalindrome(heapMover left, Node right, int counter){
		if (right == null)
			return true; 
		boolean f=isPalindrome(left, right.next, counter + 1);
		if (counter >= size / 2) {

			//int t = left.node.data;
			if(left.node.data != right.data)
			   {left.node = left.node.next;return f=false;}
			left.node = left.node.next;
			   
		} 
		return f;   
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
	
	private void unfold(Node t1) {
		if (t1.next == null) {
			head = tail = t1;
			return;
		} else if (t1.next.next == null) {
			head = t1;
			tail = t1.next;
			return;
		}
		Node t2 = t1.next;
		unfold(t1.next.next);
		t1.next = head;
		head = t1;
		tail.next = t2;
		tail = t2;
		tail.next = null;
	}

	public void OddEven() {
		if (this.size == 0)
			return;
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();
		while (this.size > 0) {
			int data = this.removeFirst();
			if (data % 2 == 0) {
				even.addLast(data);
			} else {
				odd.addLast(data);
			}
		}

		if (odd.size == 0) {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		} else if (even.size == 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			this.head = odd.head;
			this.tail = even.tail;
			odd.tail.next = even.head;
			this.size = odd.size + even.size;
		}
	}

	public void kReverse(int k) {
		LinkedList acc = new LinkedList();
		while (this.size > 0) {
			LinkedList temp = new LinkedList();
			for (int i = 0; i < k && this.size > 0; i++) {
				temp.addFirst(this.removeFirst());
			}
			if (acc.size == 0) {
				acc.head = temp.head;
				acc.tail = temp.tail;
				acc.size = temp.size;
			} else {
				acc.tail.next = temp.head;
				acc.tail = temp.tail;
				acc.size += temp.size;
			}
		}

		this.head = acc.head;
		this.tail = acc.tail;
		this.size = acc.size;
	}

	public int midElement() {
		return midNode(head, tail).data;
	}

	private Node midNode(Node sp, Node ep) {
		Node slow = sp;
		Node fast = sp;
		while (fast != ep && fast.next != ep) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void merge2sortedLLs(LinkedList one, LinkedList two) {
		Node p1 = one.head;
		Node p2 = two.head;

		while (true) {
			if (p1 == null && p2 == null)
				break;
			else if (p1 == null) {
				this.addLast(p2.data);
				p2 = p2.next;
			} else if (p2 == null) {
				this.addLast(p1.data);
				p1 = p1.next;
			} else {
				if (p1.data > p2.data) {
					this.addLast(p2.data);
					p2 = p2.next;
				} else {
					this.addLast(p1.data);
					p1 = p1.next;
				}
			}
		}
	}

	private static LinkedList mergeSort(LinkedList list, Node lo, Node hi) {
		if (lo == hi) {
			LinkedList bl = new LinkedList();
			bl.addLast(lo.data);
			return bl;
		}
		Node mid = list.midNode(lo, hi);
		LinkedList one = mergeSort(list, lo, mid);
		LinkedList two = mergeSort(list, mid.next, hi);
		LinkedList three = new LinkedList();
		three.merge2sortedLLs(one, two);
		return three;
	}

	public static LinkedList mergeSort(LinkedList list) {
		return mergeSort(list, list.head, list.tail);
	}

	public void add2listsR(LinkedList l1, LinkedList l2) {
		int c = add2listsR(l1.head, l2.head, l1.size, l2.size);
		if (c > 0)
			this.addFirst(c);
	}

	private int add2listsR(Node head1, Node head2, int size1, int size2) {// recursively
		if (size1 == 0 && size2 == 0) {
			return 0;
		}
		int c;
		if (size1 > size2) {
			c = add2listsR(head1.next, head2, size1 - 1, size2);
		} else if (size1 < size2) {
			c = add2listsR(head1, head2.next, size1, size2 - 1);
		} else {
			c = add2listsR(head1.next, head2.next, size1 - 1, size2 - 1);
		}
		int myans = c + head1.data + head2.data;
		this.addFirst(myans % 10);
		return myans / 10;

	}

	public static LinkedList add2lists(LinkedList l1, LinkedList l2) {
		int num1 = l1.getNum();
		int num2 = l2.getNum();
		int num3 = num1 + num2;
		return getList(num3);
	}

	private static LinkedList getList(int num) {
		LinkedList list = new LinkedList();

		while (num != 0) {
			int digit = num % 10;
			num /= 10;
			list.addFirst(digit);
		}

		return list;
	}

	private int getNum() {
		int sum = 0;
		int power = 1;
		while (this.size > 0) {
			int digit = this.removeLast();
			sum += digit * power;
			power *= 10;
		}
		return sum;
	}

	public static LinkedList multiply2LinkedLists(LinkedList l1, LinkedList l2) {
		LinkedList ans = new LinkedList();
		int num1 = l1.getNum();
		int num2 = l2.getNum();
		int num3 = num1 * num2;
		ans = getList(num3);
		return ans;
	}

	public boolean isCycle() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			if (slow == fast)
				return true;
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

	public boolean isCycle2() {
		HashSet<Node> visited = new HashSet<>();
		Node curr = head;
		while (curr != null) {
			if (visited.contains(curr))
				return true;
			visited.add(curr);
		}
		return false;
	}

	public void removeCycle() {
		HashSet<Node> visited = new HashSet<>();
		Node prev = head;
		Node curr = head.next;

		while (curr != null) {
			if (visited.contains(curr)) {
				prev.next = null;
			}

			visited.add(curr);
			curr = curr.next;
			prev = prev.next;
		}
	}

}

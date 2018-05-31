package linkedLists;

import java.util.Scanner;



public class lList {
	class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;
	public lList() {
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
	
	/*int removeAt(int idx) {
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
	}*/
		/*private int handleSizeOneRemoval() {

			int temp = head.data;
			
				head = tail = null;
				size = 0;
				return temp;
		}*/ 
		/*private Node getNodeAt(int idx) {
			if (size < 0 || idx >= size) {
				System.out.println("Index Out Of Bounds");
				return null;
			}
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp; 
		}*/ 
	public void displayReverse() {
		recurseRev(head);

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
	private class heapMover {
		Node node;
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

	private void recurseRev(Node curr) {
		if (curr == null)
			return;
		recurseRev(curr.next);
		System.out.print(curr.data + " ");

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
	public void reversePointerIterative(int n) {

		Node prev = null;
		Node curr = head;
		while (n!=0&&curr != null) {
			Node ocnext = curr.next;
			curr.next = prev; 
			prev = curr;
			curr = ocnext;
             n--;
		}
		Node t = head; 
		head = tail;
		tail = t;

	}
	private  void bubbleSort(Node curr,Node temp) 
	{
	 if(curr==null)
		 return;
	 if(temp==null) 
		 return;
	if(temp.next!=null)    
		bubbleSort( curr, temp.next);
	else
		bubbleSort(curr.next, curr.next.next);  
	if(curr.data>temp.data) 
		{
		 int t=curr.data;
		 curr.data=temp.data;
		 temp.data=t;
		} 
    }
	public void bubbleSort()
	{
		Node curr=head;
		Node temp=curr.next;
		bubbleSort(curr, temp);
		
	}
		public static void main(String[] args)
		{
			Scanner scn = new Scanner(System.in);
			int n=scn.nextInt();
			lList list=new lList(); 
			while (n != 0){ 
				int val=scn.nextInt();
				list.addLast(val);  
				n--;
				
			}
			list.bubbleSort(); 
			list.display();
		  // System.out.println(list.isPalindrome());
		}
		
}

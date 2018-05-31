package pep21_18Mar;

public class Queue {
	private int[] data;
	private int front;
	private int size;

	public Queue(int capacity) {
		data = new int[capacity];
		size = 0;
		front = 0;
	}

	public Queue() {
		this(5);
	}

	public void enqueue(int value)// like push
	{
		if (size == data.length) {
			System.out.println("Overflow");
			return;
		}
		int tail = (front + size) % data.length; 
		data[tail] = value;
		size++;

	}

	public int dequeue() {
		if (size == 0) {
			System.out.println("Underflow");
			return -1;
		}

		int value = data[front];
		data[front] = 0;
		front = (front + 1) % data.length; 
		size--; 
		return value;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
	public int front()
	{if(size==0)
	{
		System.out.println("Empty!"); 
		return -1; 
	}
		return data[front]; 
	}

	public void display() {
		for(int i=0;i<data.length;i++)
		{
			int index=(front+i)%data.length;
			if(data[index]!=0) 
			System.out.print(data[index]+" "); 
			
		}
		System.out.println();
	}

}

package pep21_18Mar;

public class QueueClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q=new Queue();
		q.enqueue(10);
		q.display();
		q.enqueue(20);
		q.display();
		q.enqueue(30);
		q.display();
		q.enqueue(40);
		q.display();
		q.enqueue(50); 
		q.display(); 
		q.enqueue(60);
		q.display(); 
		System.out.println("D:"+q.dequeue());
		q.display();
		System.out.println("D:"+q.dequeue());
		q.display();
		q.enqueue(60);
		q.display();
		q.enqueue(70);
		q.display();
		 
		
  

		
	}

}

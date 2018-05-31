package priorityQueues;

public class Client {

	public static void main(String[] args) {
		MedianPQ mpq = new MedianPQ();
		mpq.add(-1);
		mpq.add(2);
		mpq.add(10);
		mpq.add(11); 
		mpq.add(15);
		mpq.add(17);
		mpq.add(50);
		//System.out.println(mpq.peekMedian()); 
		System.out.println(mpq.remove()); 
		
		//System.out.println(mpq.peekMedian());
		System.out.println(mpq.remove());
		
		//System.out.println(mpq.peekMedian());
		System.out.println(mpq.remove());
	//	System.out.println(mpq.remove());

	}

}

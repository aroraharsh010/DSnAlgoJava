package priorityQueues;

import adjacencyMap.GenericHeap;

public class ClientHeap {

	public static void main(String[] args) {

		/*Heap pq = new Heap(new int[]{10,20,-30,3,1,100});
		pq.add(10);
		pq.add(20);
		pq.add(-30);
		pq.add(3);
		pq.add(1);
		pq.add(100);
		pq.display();
		pq.erase(100);
		pq.display();
		
		while (pq.size() > 0) {
			System.out.print(pq.remove()+" ");
		}*/
		String[] arr={"hello","world","abc","def"};
		GenericHeap<String> hp=new GenericHeap<>(arr,false);
		GenericHeap<String> rhp=new GenericHeap<>(arr,true);
		hp.display();
		while (hp.size() > 0) {
			System.out.print(hp.remove()+" ");
		}
		System.out.println();
		while (rhp.size() > 0) {
			System.out.print(rhp.remove()+" ");
		}
		
		
	}

}

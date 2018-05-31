package priorityQueues;

import java.util.*;

public class MedianPQ {
	private PriorityQueue<Integer> minPQ = new PriorityQueue<>();
	private PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
	private int size = 0;

	// log(n)
	public void add(int n) {
		if (maxPQ.size() > 0 && n < maxPQ.peek()) {

			maxPQ.add(n);
			size++;
		} else if (minPQ.size() > 0 && n > minPQ.peek()) {

			minPQ.add(n);
			size++;
		} else {

			maxPQ.add(n);
			size++;
		}
		if (minPQ.size() - maxPQ.size() > 1) { 
			int a = minPQ.remove();
			maxPQ.add(a);
		}
	    else if (minPQ.size() - maxPQ.size() < 1) {
			int a = maxPQ.remove();
			minPQ.add(a);
		}

	}

	public int remove() {

		if (this.size == 0)
			return -1; 

		if (minPQ.size() > maxPQ.size()) {
			size--;
			return minPQ.remove();
		} else {
			size--;
			return maxPQ.remove();
		}
	}

	public int peekMedian() {

		if (this.size == 0)
			return -1;		
		if (minPQ.size() > maxPQ.size())
			return minPQ.peek();
		else
			return maxPQ.peek(); 
	}
	

}

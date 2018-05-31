package adjacencyMap;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericHeap<T> {

	private ArrayList<T> data = new ArrayList<>();
	private HashMap<T, Integer> idxmap = new HashMap<>();
	private boolean rev = false;

	public GenericHeap() {

	}

	public GenericHeap(T[] arr, boolean rev) {// O(n) complexity;//
		this.rev = rev;
		for (T n : arr) {
			data.add(n);
			idxmap.put(n, data.size() - 1);
		}
		for (int i = (data.size() / 2 - 1); i >= 0; i--) {
			downheapify(i);
		}
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public T peek() {
		return data.get(0);
	}

	public void add(T val) {//
		data.add(val);
		idxmap.put(val, data.size() - 1);
		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;
		if (myCompareto(ci, pi) < 0) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	public T remove() {//
		T rv = data.get(0);
		idxmap.remove(rv);
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int c1 = 2 * pi + 1;
		int c2 = 2 * pi + 2;

		int minidx = pi;
		if (c1 < data.size() && myCompareto(c1, minidx) < 0) {
			minidx = c1;
		}
		if (c2 < data.size() && myCompareto(c2, minidx) < 0) {
			minidx = c2;
		}
		if (minidx != pi) {
			swap(pi, minidx);

			downheapify(minidx);
		}

	}

	private void swap(int i, int j) {//

		T ith = data.get(i);
		T jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
		idxmap.put(ith, j);
		idxmap.put(jth, i);
	}

	public void erase(T val) {

		int idx = idxmap.get(val);
		swap(idx, data.size() - 1); 
		data.remove(data.size() - 1);
		idxmap.remove(val);
		if (idx < data.size()) {
			downheapify(idx);
			upheapify(idx);
		}
	}

	//
	private int myCompareto(int i, int j) {
		Comparable<T> ith = (Comparable) data.get(i);
		T jth = data.get(j);

		if (this.rev == false)
			return ith.compareTo(jth);
		else
			return -ith.compareTo(jth);
	}

}

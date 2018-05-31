package priorityQueues;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap {

	private ArrayList<Integer> data = new ArrayList<>();
	private HashMap<Integer, Integer> idxmap = new HashMap<>();

	public Heap() {

	}

	public Heap(int[] arr) {// O(n) complexity;//
		for (int n : arr) {
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

	public int peek() {
		return data.get(0);
	}

	public void add(int val) {//
		data.add(val);
		idxmap.put(val, data.size() - 1);
		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;
		if (data.get(pi) > data.get(ci)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	public int remove() {//
		int rv = data.get(0);
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
		if (c1 < data.size() && data.get(c1) < data.get(minidx)) {
			minidx = c1;
		}
		if (c2 < data.size() && data.get(c2) < data.get(minidx)) {
			minidx = c2;
		}
		if (minidx != pi) {
			swap(pi, minidx);

			downheapify(minidx);
		}

	}

	private void swap(int i, int j) {//

		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
		idxmap.put(ith, j);
		idxmap.put(jth, i);
	}

	public void erase(int val) {

		int idx = idxmap.get(val);
		swap(idx, data.size() - 1);
		data.remove(data.size() - 1);
		idxmap.remove(val);
		if (idx < data.size()) {
			downheapify(idx);
			upheapify(idx);
		}
	}

}

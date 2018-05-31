package priorityQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KMergeSortedList {// And similar Questions on pqs

	public static void main(String[] args) {
		/*
		 * ArrayList<ArrayList<Integer>> list = new ArrayList<>(); list.add(new
		 * ArrayList<>()); list.add(new ArrayList<>()); list.add(new
		 * ArrayList<>()); list.add(new ArrayList<>());
		 * 
		 * list.get(0).addAll(Arrays.asList(10, 15, 20, 25));
		 * list.get(1).addAll(Arrays.asList(11, 14, 17));
		 * list.get(2).addAll(Arrays.asList(5, 7, 28, 30, 35));
		 * list.get(3).addAll(Arrays.asList(22, 29)); mergeKSortedLists(list);
		 * System.out.println(flist);
		 */
		int[] arr = { 17, 10, 15, 35, 55, 22, 88, 77 };
		sortAlmostSortedArr(arr, 2);

	}

	private static class Pair implements Comparable<Pair> {
		int val;
		int didx;
		int lidx;

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
	}

	static ArrayList<Integer> flist = new ArrayList<>();

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> list) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < list.size(); i++) {
			Pair lp = new Pair();
			lp.didx = 0;
			lp.lidx = i;
			lp.val = list.get(i).get(0);
			pq.add(lp);
		}
		while (pq.size() != 0) {
			Pair rp = pq.remove();
			flist.add(rp.val);
			rp.didx++;
			if (list.get(rp.lidx).size() > rp.didx) {

				rp.val = list.get(rp.lidx).get(rp.didx);

				pq.add(rp);

			}
		}
	}

	public static void sortAlmostSortedArr(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ptr;
		for (ptr = 0; ptr < k + 1; ptr++) {
			pq.add(arr[ptr]);
		}
		while (pq.size() != 0) {
			int val = pq.remove();
			System.out.print(val + " ");
			if (ptr < arr.length) {
				pq.add(arr[ptr]);
				ptr++;
			}
		}
	}

}

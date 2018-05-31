package priorityQueues; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmannEncoder {
	private class Node implements Comparable<Node> {
		Node left;
		Node right;
		int freq;
		char ch;

		public int compareTo(Node o) {
			
			return this.freq - o.freq;
		}

	}

	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	public HuffmannEncoder(String blob) {
		// Frequency map
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < blob.length(); i++) {
			char ch = blob.charAt(i);
			map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
		}
		// populate priority queue
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Character> list = new ArrayList<>(map.keySet());

		for (int i = 0; i < list.size(); i++) {
			Node temp = new Node();
			char x = list.get(i);
			temp.ch = x;
			temp.freq = map.get(x);
			pq.add(temp);
		}
		// remove 2 ,merge and add one till size is one

		while (pq.size() != 1) {
			Node a = pq.remove();
			Node b = pq.remove();
			Node temp = new Node();
			temp.freq = a.freq + b.freq;
			temp.left = a;
			temp.right = b;
			pq.add(temp);
		}
		// remove the last one
		Node last = pq.remove();

		// traverse like a binary tree
		traverse(last, "");
	}

	private void traverse(Node last, String asf) {
		if (last.left == null && last.right == null) {
			encoder.put(last.ch, asf);
			decoder.put(asf, last.ch);
			return;
		}
		traverse(last.left, asf + "0");
		traverse(last.right, asf + "1");

	}

	public void encode(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String key = encoder.get(ch);
			res += key;

		}
		System.out.println(res);

	} 

	public void decode(String str) {
		String res = "";
		String pref = "";
		for (int i = 0; i < str.length(); i++) {
 
			char ch = str.charAt(i);
			pref += ch;
			if (decoder.containsKey(pref) == true) {
				res += decoder.get(pref);
				pref = "";
			}
		}
		System.out.println(res);
	}

}

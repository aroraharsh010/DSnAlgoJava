package hashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	private class Node {
		char character;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;

	}

	private Node root;
	private int words = 0;
	private int nodes = 0;

	public Trie() {
		root = new Node();
		this.root.character = '$';
		nodes++;

	}

	public void addWord(String word) {
		addWord(word, root);
	}

	private void addWord(String word, Node node) {
		if (word.length() == 0) {
			if (node.eow == false)
				words++;
			node.eow = true;

			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		if (node.children.containsKey(ch) == true)
			addWord(row, node.children.get(ch));
		else {
			Node temp = new Node();
			nodes++;
			temp.character = ch;
			node.children.put(ch, temp);
			addWord(row, node.children.get(ch));

		}
	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0)
			return node.eow;
		char ch = word.charAt(0);
		String row = word.substring(1);
		boolean f = false;
		if (node.children.containsKey(ch) == true)
			f = searchWord(node.children.get(ch), row);
		else
			return false;
		return f;

	}

	public void remove1(String word) {
		remove1(this.root, word);

	}

	private void remove1(Node node, String word) {
		if (word.length() == 0) {
			if (node.eow == true)
				words--;
			node.eow = false;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		if (node.children.containsKey(ch) == true)
			remove1(node.children.get(ch), row);
		else
			return;
		if (node.children.get(ch).children.size() == 0 && node.children.get(ch).eow == false) {
			node.children.remove(ch);
			nodes--;
		}

	}

	public void displayAsAtree() {
		displayAsAtree(root);
	}

	private void displayAsAtree(Node node) {
		ArrayList<Character> list=new ArrayList<>(node.children.keySet());
		String str=node.character+"-->";
		for(int i=0;i<list.size();i++) 
		{
			str+=list.get(i)+" ";
		}
		str+=".";
        System.out.println(str);
		
		for(int i=0;i<list.size();i++){
        	displayAsAtree(node.children.get(list.get(i)));
        }
	}

	public void displayWords() {
		displayWords(root, "");
	}
 
	private void displayWords(Node node, String str) {
		if (node.eow == true) {
			System.out.println(str);
 
		}
		ArrayList<Character> child = new ArrayList<>(node.children.keySet());
		for (int i = 0; i < child.size(); i++) {
	 		displayWords(node.children.get(child.get(i)), str + child.get(i));
		}

	}
}

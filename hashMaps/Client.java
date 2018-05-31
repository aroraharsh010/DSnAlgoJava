package hashMaps;

public class Client {

	public static void main(String[] args) {

		/*Trie trie=new Trie();
		trie.addWord("abcd");
		trie.addWord("abce");
		trie.addWord("as");
		trie.addWord("ask");
		System.out.println(trie.searchWord("abcde")); 
	    trie.displayAsAtree();
	    trie.displayWords();
		System.out.println(trie.searchWord("as"));
		trie.remove1("as");
		System.out.println(trie.searchWord("as"));
		System.out.println(trie.searchWord("ask"));
		trie.remove1("ask");
		System.out.println(trie.searchWord("ask"));*/
		
		MyHashMap<String, Integer> popMap=new MyHashMap<>();
		popMap.put("India",120);
		popMap.put("Russia",100);
		popMap.put("Pak",80);
		popMap.put("China",150);
		popMap.put("Utopia",20);
		popMap.put("Aus",40);
		popMap.put("Bang",70);
		popMap.display();
		System.out.println(popMap.keyset());
		
	}

}

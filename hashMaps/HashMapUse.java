package hashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapUse {
	public static void main(String[] args) {
		/*
		 * HashMap<String, Integer> hm = new HashMap<>(); hm.put("India", 34);
		 */
		/*
		 * int[] arr1 = { 1, 2, 3, 4, 5, 6, 5, 7, 7 }; int[] arr2 = { 1, 3, 5,
		 * 7, 5, 7 };
		 */
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		longestConsecSubSequence(arr);
	}

	public static Character hfc(String str) {
		HashMap<Character, Integer> fm = new HashMap<>();
		int max = 0;
		for (int i = 0; i < str.length(); i++) {

			int value = -1;
			char ch = str.charAt(i);
			if (fm.containsKey(ch) == true) {
				value = fm.get(ch);
				value++;
				fm.put(ch, value);
			} else
				fm.put(ch, 1);

			if (value > max)
				max = value;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (fm.get(ch) == max)
				return ch;
		}
		return null;
	}

	public static ArrayList<Integer> cElements(int[] one, int[] two) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < one.length; i++) {
			map.put(one[i], false);
		}
		for (int i = 0; i < two.length; i++) {
			if (map.containsKey(two[i])) {
				map.put(two[i], true);
			}

		}
		ArrayList<Integer> list1 = new ArrayList<>(map.keySet());
		for (int i = 0; i < list1.size(); i++) {
			if (map.get(list1.get(i)) == true)
				list.add(list1.get(i));
		}

		return list;
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			if (map.containsKey(one[i])) {
				int freq = map.get(one[i]);
				map.put(one[i], freq + 1);
			} else
				map.put(one[i], 1);
		}
		for (int i = 0; i < two.length; i++) {
			if (map.containsKey(two[i]) == true) {
				int freq = map.get(two[i]);
				if (freq > 0) {
					map.put(two[i], freq - 1);
					list.add(two[i]);
				}
			}

		}

		return list;
	}

	public static void longestConsecSubSequence(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int val: arr){
			map.put(val, true);
		}
		for(int val: arr){
			map.put(val, map.containsKey(val - 1)? false:true);
		}int maxl=0;
		int Sidx=0;
		
		for(int val:arr){
			
			int length=0;
			if(map.get(val)==true)
			{
				for(int j=val;map.containsKey(j)==true;j++){
					length++;
				}
				if(maxl<length)
				{
					maxl=length;
					Sidx=val; 
				}	
			} 
			
		}
		for(int i=0;i<maxl;i++){
			System.out.print(i+Sidx+" "); 
		}

	}
}

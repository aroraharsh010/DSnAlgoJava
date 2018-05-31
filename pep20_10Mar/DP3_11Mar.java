package pep20_10Mar;

import java.util.ArrayList;

public class DP3_11Mar {

	public static void main(String[] args) {

		int[] rodcutArr = { 0, 2, 6, 7, 10, 8, 9, 12, 11 };
		// rodCut(rodcutArr);
		// System.out.println(palindromicCuts("abccbc", 0, 5, new int[6][6]));
		int[] wts = { 25, 26, 10, 18, 22 };
		int[] values = { 100, 50, 17, 22, 80 };
		// System.out.println(knapsack(wts, values, 50, 0, 0, 0));
		knapSackTab(values, wts, 50);

	}

	public static void rodCut(int[] arr) {
		// int omax = Integer.MIN_VALUE;
		int[] str = new int[arr.length];// to store max prices
		String[] path = new String[arr.length];
		str[0] = arr[0];
		path[0] = "";
		path[1] = arr[1] + " "; 
		
		str[1] = arr[1];
		for (int i = 2; i < arr.length; i++) {
			str[i] = arr[i];
			path[i] = i + " ";
			int left = 1;
			int right = i - 1;
			while (left <= right) {

				if (str[left] + str[right] > str[i]) {
					str[i] = str[left] + str[right];
					path[i] = path[left] + path[right] + " ";
				}
				left++;
				right--;
			}
		}
		System.out.println(str[str.length - 1] + "\n" + path[path.length - 1]);
	}

	static int palindromicCuts(String s, int si, int ei, int[][] str) {
		if (IsPalindrome(s, si, ei) == true)
			return 0;
		if (str[si][ei] != 0)
			return str[si][ei];
		int a = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int m1 = palindromicCuts(s, si, i, str);
			int m2 = palindromicCuts(s, i + 1, ei, str);
			if (m1 + m2 + 1 < a)
				a = m1 + m2 + 1;
		}
		str[si][ei] = a;
		return a;
	}

	public static boolean IsPalindrome(String s, int si, int ei) {
		for (int i = 0; i <= (ei - si) / 2; i++) {
			if (s.charAt(si + i) != s.charAt(ei - i))
				return false;
		}
		return true;
	}

	public static int knapsack(int[] wts, int[] values, int capacity, int Witem, int cost, int i) {// Using
																									// memoisation
		int val1 = 0, val2 = 0;
		if (i == wts.length)
			return cost;
		val1 = knapsack(wts, values, capacity, Witem, cost, i + 1);

		if (Witem + wts[i] <= capacity)
			val2 = knapsack(wts, values, capacity, Witem + wts[i], cost + values[i], i + 1);
		int a = Math.max(val1, val2);
		return a;
	}

	static void knapSackTab(int[] cost, int[] wts, int capacity) {
		int[][] str = new int[capacity + 1][cost.length + 1];
		for (int i = 0; i <= capacity; i++) {
			for (int j = 0; j <= cost.length; j++) {
				if (i == 0 || j == 0)
					str[i][j] = 0;
				else {
					int remitem = j - 1;
					// no statement
					int remcost = i;
					int fno = str[remcost][remitem];
					// yes
					int remcyes = i - wts[j - 1];
					int fyes = 0;
					if (remcyes >= 0)
						fyes = str[remcyes][remitem] + cost[j - 1];
					str[i][j] = Math.max(fno, fyes);

				}

			}
		}
		System.out.println(str[str.length - 1][str[0].length - 1]);
	}
	static void coinChangeTab(int[] denoms,int amt)
	{
		int[] str=new int[amt+1];
		ArrayList<String>[] path=new ArrayList[amt+1];
		for(int i=0;i<path.length;i++)
		{
			path[i]=new ArrayList<>();
		}
		str[0]=1;
		
		path[0].add("");
		for(int i=0;i<denoms.length;i++)
		{
			for(int j=denoms[i];j<=amt;j++)
			{
				str[j]=str[j]+str[j-denoms[i]];
				for(String rstr: path[j-denoms[i]])
				{
					String ns=rstr+denoms[i];
					path[j].add(ns);
				}
				
			}
		}
		System.out.println(str[str.length-1]);
		System.out.println(path[path.length-1]);
		
	}
	
	

}

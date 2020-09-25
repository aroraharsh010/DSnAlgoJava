package dynamicProgramming;

import java.util.Arrays;

public class Dp1 {

	static int fibM(int n, int[] str) {
		if (n == 0 || n == 1)
			return n;
		if (str[n] != 0)
			return str[n];
		int fn2 = fibM(n - 2, str);
		int fn1 = fibM(n - 1, str);
		int fn = fn1 + fn2;
		str[n] = fn;
		return fn;
	}

	static int fibT(int n) {
		int[] str = new int[n + 1];
		str[0] = 0;
		str[1] = 1;
		for (int i = 2; i < str.length; i++) {
			str[i] = str[i - 1] + str[i - 2];
		}
		return str[n];
	}

	static int stairs(int n, int[] arr) {
		if (n < 0)
			return 0;
		if (n == 0) {
			return 1;
		}
		if (arr[n] != 0)
			return arr[n];
		int now1 = stairs(n - 1, arr);
		int now2 = stairs(n - 2, arr);
		int now3 = stairs(n - 3, arr);
		int tnows = now1 + now2 + now3;// total no. of ways
		arr[n] = tnows;
		return tnows;
	}

	static int stairs(int n) {
		int[] str = new int[n + 1];
		str[0] = 0;
		str[1] = 1;
		str[2] = 2;
		str[3] = 4;
		str[4]=7;
		for (int i = 5; i <= n; i++) {
			str[i] = str[i - 3] + str[i - 2] + str[i - 1];
		}
		return str[n];
	}

	static int WeirdStairs(int n, int[] stairs, int[] str) {

		if (n == 0) {
			return 1;
		}
		// if (stairs[n] == 0)
		// return 0;
		if (str[n] != 0)
			return str[n];
		int ways = 0;
		for (int i = 1; i <= stairs[n]; i++) {
			if (n - i >= 0)
				ways += WeirdStairs(n - i, stairs, str);
		}
		str[n] = ways;
		return ways;

	}

	static int WeirdStairsTab(int[] jumpSize) {
		int[] str = new int[jumpSize.length];
		str[0] = 1;

		for (int s = 1; s < jumpSize.length; s++) {
			for (int js = 1; js <= jumpSize[s]; js++) {
				int i = s - js;
				if (i >= 0) {
					str[s] += str[i];
				}

			}
		}
		System.out.println(Arrays.toString(str));
		return str[str.length - 1];
	}

	static int countMinSteps(int[] jumpSize) {
		int[] str = new int[jumpSize.length];

		str[0] = 0;
		for (int s = 1; s < jumpSize.length; s++) {
			if (jumpSize[s] == 0) {
				str[s] = -1;
			} else {
				int mymin = Integer.MAX_VALUE;
				for (int js = 1; js <= jumpSize[s]; js++) {
					int i = s - js;
					if (i >= 0 && str[i] != -1) {
						mymin = Math.min(mymin, str[i]);
					}
				}
				if (mymin != Integer.MAX_VALUE)
					str[s] = mymin + 1;
			}
		}
		System.out.println(Arrays.toString(str));
		return str[str.length - 1];
	}

	public static int knapsackm(int[] wts, int[] values, int capacity, int Witem, int cost, int i, int[] str) {
		if (i == wts.length)
			return cost;
		if (str[i] != 0)
			return str[i];
		int val1 = knapsackm(wts, values, capacity, Witem, cost, i + 1, str);
		int val2 = 0;
		if (Witem + wts[i] <= capacity)
			val2 = knapsackm(wts, values, capacity, Witem + wts[i], cost + values[i], i + 1, str);
		int a = Math.max(val1, val2);
		str[i] = a;
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
					// compare and update
					if (remcyes >= 0)
						fyes = str[remcyes][remitem] + cost[j - 1];
					str[i][j] = Math.max(fno, fyes);

				}

			}
		}
		System.out.println(str[str.length - 1][str[0].length - 1]);
	}

	static void knapsack(int[] wts, int[] prices, int cap) {// Sir Method
		int[][] str = new int[wts.length + 1][cap + 1];
		for (int i = 1; i < str.length; i++) {
			for (int j = 1; j < str[0].length; j++) {
				if (str[i - 1][j - wts[i - 1]] + prices[i - 1] >= str[i - 1][j]) {
					str[i][j] = str[i - 1][j - wts[i - 1]] + prices[i - 1];// yes
																			// call
				} else
					str[i][j] = str[i - 1][j];// No call

			}
		}
	}

	static void unboundedKnapsack(int[] wts, int[] prices, int cap) {
		int[] str = new int[cap + 1];
		for (int i = 1; i < str.length; i++) {
			for (int j = 0; j < wts.length; j++) {
				if (i - wts[j] >= 0)
					str[i] = Math.max(str[i - wts[j]] + prices[j], str[i]);
			}
		}
		System.out.println(str.toString());
	}

	static void LongestIncreasingSSequence(int[] arr) {
		int[] str = new int[arr.length];
		str[0] = 1;
		String[] ans = new String[arr.length];
		ans[0] = arr[0] + " ";
		for (int i = 1; i < str.length; i++) {
			ans[i] = "";
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (str[j] > str[i]) {
						str[i] = str[j];
						ans[i] = ans[j];

					}
				}
			}
			str[i]++;
			ans[i] += arr[i] + " ";
		}
		System.out.println(Arrays.toString(str));
		System.out.println(Arrays.toString(ans));
	}

	static void LpSq(String s) {// Longest Palinromic subsequence
		int[][] str = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					str[i][j] = 1;
				}

				else if (gap == 1) {
					if (s.charAt(i) == s.charAt(j))
						str[i][j] = 2 + str[i + 1][j - 1];
					else
						str[i][j] = 1;
				} else {
					str[i][j] = Math.max(str[i + 1][j], str[i][j - 1]);
				}
			}
		}
		System.out.println(str[0][str.length - 1]);
	}

	public static void pCutsT(String s) {// Minimum palindromic cuts in a string
		int[][] str = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (gap == 0)
					str[i][j] = 0;
				else if (gap == 1) {
					str[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
				} else {
					if (s.charAt(i) == s.charAt(j) && str[i + 1][j - 1] == 0) {
						str[i][j] = 0;
					} else {
						int min = s.length();
						for (int k = 0; k < gap; k++) {
							int lhs = str[i][j - gap + k];
							int rhs = str[i + 1 + k][j];
							min = Math.min(lhs + rhs, min);
						}
						str[i][j] = min + 1;
					}
				}
			}
		}
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str.length; j++) {
				System.out.print(str[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Count of Binary Strings of length n with no consecutive 0

	static void count01(int n) {
		int ones = 1;// ending at 1 of length 1
		int zeroes = 1;//
		for (int i = 2; i <= n; i++) {
			int newzeroes = ones;
			int newones = ones + zeroes;
			ones = newones;
			zeroes = newzeroes;
		}
		System.out.println(ones + zeroes);
	}

	static void countabc(String s) {// COunt all subsequences of the form
									// (a^i)(b^j)(c^k) eg aaabc or abbbccc
		int counta = 0;// ending at a
		int countb = 0;
		int countc = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				counta = 2 * counta + 1;
			else if (s.charAt(i) == 'b')
				countb = 2 * countb + counta;
			else if (s.charAt(i) == 'c')
				countc = 2 * countc + countb;
		}
		System.out.println(countc);
	}

	/*
	 * For MCM question. In this we are given array with dimensions of matrices.
	 * Find minimum operations to multiply them all. 
	 * A B C D E 
	 * A 0 6k 18k 
	 * B 0 0 24k 64k 
	 * C 0 0 0 60k 150k 
	 * D 0 0 0 0 120k 
	 * E 0 0 0 0 0
	 * 
	 */

	static void mcm(int[] dims) {
		int[][] str = new int[dims.length - 1][dims.length - 1];
		for (int gap = 0; gap < str.length; gap++) {
			for (int i = 0, j = i + gap; j < str.length; i++, j++) {
				if (gap == 0)
					str[i][j] = 0;
				if (gap == 1)
					str[i][j] = dims[i] * dims[i + 1] * dims[i + 2];
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < gap; k++) {
					int lhc = str[i][j - gap + k];
					int rhc = str[i + 1 + k][j];
					int multc = dims[i] * dims[i + 1 + k] * dims[j + 1];
					int tc = lhc + rhc + multc;
					min = Math.min(min, tc);
				}
				str[i][j] = min;
			}
		}
	}

	/*
	 * In min square cut, we are given a rectangle's dimensions. We need to find
	 * min no. of squares that can be cut from it.
	 */
	static int minSquareCut(int m, int n, int[][] str) {
		if (m == n)
			return 1;
		if (str[m][n] != 0)
			return str[m][n];
		int hmin = Integer.MAX_VALUE;
		int vmin = Integer.MAX_VALUE;
		for (int i = 1; i <= m / 2; i++) {
			int h1 = minSquareCut(i, n, str);
			int h2 = minSquareCut(m - i, n, str);
			hmin = Math.min(h1 + h2, hmin);
			
		}
		for (int j = 1; j <= n / 2; j++) {
			int v1 = minSquareCut(m, j, str);
			int v2 = minSquareCut(m, n - j, str);
			vmin = Math.min(vmin, v1 + v2);
		}
		str[m][n] = Math.min(hmin, vmin);
		return str[m][n];

	}
	
	static int mscInRect(int l,int b,int[][] str){
		if(l==0||b==0)
			return 0;
		if(l==b)
			return 1;
		if(str[l][b]!=0)
			return str[l][b];
		int sd=Math.min(l, b);
		int mymin=Integer.MAX_VALUE;
		for(int x=1;x<=sd;x++){
			int lp1h=l-x;
			int bp1h=x;
			int lp2h=l;
			int bp2h=b-x;
			int msh=mscInRect(lp1h, bp1h, str)+mscInRect(lp2h, bp2h, str)+1;
			int lp1v=x;
			int bp1v=b-x;
			int lp2v=l-x;
			int bp2v=b;
			int msv=mscInRect(lp1v, bp1v, str)+mscInRect(lp2v, bp2v, str)+1;
			mymin=Math.min(mymin,Math.min(msh,msv));
		}
		str[l][b]=mymin;
		return mymin;
	}

	public static void main(String[] args) {
		// System.out.println(fibT(1000000));
		// int n = 7;
		 System.out.println(stairs(13));
		// int[] stairs = { 0, 2, 3, 1, 0, 2, 0, 2, 4 };
		// System.out.println(WeirdStairs(8, stairs, new int[stairs.length +
		// 1]));
		// System.out.println(WeirdStairsTab(stairs));
		// System.out.println(countMinSteps(stairs));
		// int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };

		// LongestIncreasingSSequence(arr);
		// LpSq("abkccgba");
        //pCutsT("abccbc");
//		System.out.println(mscInRect(36,30, new int[37][31]));
		}
}

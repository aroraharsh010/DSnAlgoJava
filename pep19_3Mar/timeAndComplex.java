package pep19_3Mar;

public class timeAndComplex {

	public static void main(String[] args) {

		// int[] arr = { 2, 18, 6, 18, 2, 7, 7 };finduniqueElement(arr);
		// Array for find unique
		/*
		 * int[] arr = { 3, 4, 1, 5, 4, 2}; findDuplicate(arr);
		 */
		// System.out.println(pbpM(0, 10, new int[11]));
		// System.out.println(pbpT(10));
		// System.out.println(countMazePathTab(3, 3));
		// int[][] cost = { { 0, 1, 5, 10 }, { 2, 6, 3, 80 }, { 1, 2, 6, 0 }, {
		// 3, 4, 1, 0 } };
		// minCostP(cost);
		// System.out.println(minCostPath(0, 0, cost, new
		// int[cost.length][cost[0].length]));
		int[][] arr = { { 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 1, 0 }

		};
		maxSizeSqSubMatr(arr);
	}

	public static void finduniqueElement(int[] arr)// with O(n)
	// in array every element has a duplicate except one element.Find unique
	{
		int fxor = 0;
		for (int i = 0; i < arr.length; i++) {
			fxor ^= arr[i];
		}
		System.out.println(fxor);
	}

	public static void findDuplicate(int[] arr)// with complexity O(n)
	{
		int fxor = 0;
		for (int i = 0; i < arr.length; i++) {
			fxor = fxor ^ i ^ arr[i];

		}
		System.out.println(fxor);
	}

	public static int fibDp(int n, int[] arr) {// memorising
		if (n == 0 || n == 1)
			return n;
		if (arr[n] != 0)
			return arr[n];
		int fn1 = fibDp(n - 1, arr);
		int fn2 = fibDp(n - 2, arr);
		int fn = fn1 + fn2;
		arr[n] = fn;
		return fn;   
	}

	public static int pbpM(int src, int dest, int[] arr)// print
														// board
	// paths
	{
		if (src == dest) {
			return 1;
		}
		if (src > dest)
			return 0;
		if (arr[src] != 0)
			return arr[src];
		int cstod = 0;
		for (int i = 1; i <= 6; i++) {

			{
				int citod = pbpM(src + i, dest, arr);
				cstod += citod;
			}

		}
		arr[src] = cstod;
		return cstod;
	}

	// Now tabular form of Dp
	static int FibT(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int x = 2; x <= n; x++) {
			f[x] = f[x - 1] + f[x - 2];
		}
		return f[n];
	}

	static int pbpT(int dest) {
		int[] f = new int[dest + 1];
		f[dest] = 1;
		for (int x = dest - 1; x >= 0; x--) {
			for (int dice = 1; dice <= 6; dice++) {
				if (x + dice <= dest)
					f[x] += f[x + dice];
			}
		}
		return f[0];
	}

	static int countMazePath(int srow, int scol, int destrow, int destcol, int counter) {
		if (srow == destrow && scol == destcol) {
			counter++;
			return counter;
		}
		if (scol + 1 <= destcol)
			counter = countMazePath(srow, scol + 1, destrow, destcol, counter);
		if (srow + 1 <= destrow)
			counter = countMazePath(srow + 1, scol, destrow, destcol, counter);
		return counter;
	}

	static int countMazePathMem(int sr, int sc, int dr, int dc, int[][] arr) {
		int c = 0; 
		if (sr == dr && sc == dc)
			return 1;
		if (arr[sr][sc] != 0)
			return arr[sr][sc];
		if (sc + 1 <= dc)
			c += countMazePathMem(sr, sc + 1, dr, dc, arr);
		if (sr + 1 <= dr)
			c += countMazePathMem(sr + 1, sc, dr, dc, arr);
		arr[sr][sc] = c;
		return c;
	}

	static int countMazePathTab(int dr, int dc) {
		int[][] f = new int[dr + 1][dc + 1];
		f[dr][dc] = 1;

		for (int i = dr; i >= 0; i--) {
			for (int j = dc; j >= 0; j--) {
				if (i == dr || j == dc)
					f[i][j] = 1;
				else
					f[i][j] += f[i + 1][j] + f[i][j + 1];
			}
		}
		return f[0][0];
	}

	static void minCostP(int[][] cost) {// Tabular Type
		int[][] f = new int[cost.length][cost[0].length];
		String[][] psf = new String[cost.length][cost[0].length];
		for (int i = f.length - 1; i >= 0; i--) {
			for (int j = f[0].length - 1; j >= 0; j--) {
				if (i == f.length - 1 && j == f[0].length - 1) {
					{
						f[i][j] = cost[i][j];
						psf[i][j] = "";
					}

				} else if (i == f.length - 1 && j != f[0].length - 1) {
					f[i][j] += cost[i][j] + f[i][j + 1];
					psf[i][j] = "H" + psf[i][j + 1];
				} else if (j == f[0].length - 1 && i != f.length - 1) {
					f[i][j] += cost[i][j] + f[i + 1][j];
					psf[i][j] = "V" + psf[i + 1][j];

				} else {
					if (f[i + 1][j] < f[i][j + 1]) {
						f[i][j] += cost[i][j] + f[i + 1][j];
						psf[i][j] = "V" + psf[i + 1][j];
					}

					else {
						f[i][j] += cost[i][j] + f[i][j + 1];
						psf[i][j] = "H" + psf[i][j + 1];
					}
				}

			}
		}
		System.out.println(psf[0][0] + "@ " + f[0][0]);
	}

	static int minCostPath(int sr, int sc, int[][] costs, int[][] str) {

		if (sr == costs.length - 1 && sc == costs[0].length - 1)
			return costs[sr][sc];
		if (str[sr][sc] != 0)
			return str[sr][sc];

		int cost1 = Integer.MAX_VALUE, cost2 = Integer.MAX_VALUE;
		if (sr + 1 < costs.length)
			cost1 = minCostPath(sr + 1, sc, costs, str);
		if (sc + 1 < costs.length)
			cost2 = minCostPath(sr, sc + 1, costs, str);
		int mcost = costs[sr][sc] + Math.min(cost1, cost2);
		str[sr][sc] = mcost; 
		return mcost;
	} 
    
	static void maxSizeSqSubMatr(int[][] arr) {
		int[][] str = new int[arr.length][arr[0].length];
		int max1 = 0, max2 = 0;
		int max = str[0][0]; 
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (arr[i][j] == 0)
					str[i][j] = 0; 
				else if (i == arr.length - 1 || j == arr.length - 1)
					str[i][j] = 1;
				else {
					str[i][j] = Math.min(str[i + 1][j], Math.min(str[i][j + 1], str[i + 1][j + 1])) + 1;
				}
				if (max < str[i][j]) {
					max1 = i;
					max2 = j; 
					max = str[i][j];
				}
			}
		}

		
		System.out.println(max + " @ [" + max1 + "," + max2 + "]");
	}
	

}

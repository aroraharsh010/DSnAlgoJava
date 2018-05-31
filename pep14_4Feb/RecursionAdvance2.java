package pep14_4Feb;

public class RecursionAdvance2 {

	public static void main(String[] args) {

		// boolean[] board = new boolean[5];
		// permutations(board, 3, 0, "");
		// System.out.println();
		// combinations(board, 3, 0, "", 0);
		/*
		 * int[] coin = { 2, 3, 5, 6 }; coinchange(coin, 10, 0, "", 0);
		 */
		int[] wts = { 10, 2, 30, 40, 5, 60 };
		int[] cost = { 20, 10, 5, 100, 20, 30 };
		System.out.println(knapsack(wts, cost, 50, 0, 0, 0));
	}

	static int counter = 0;
	static int counter2 = 0;

	public static void permutations(boolean[] board, int tqueens, int qpsf, String psf) {
		if (qpsf == tqueens) {
			counter++;
			System.out.println(counter + ". " + psf + " ");
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				permutations(board, tqueens, qpsf + 1, psf + "qb" + (i + 1) + " ");
				board[i] = false;
			}

		}
	}

	public static void combinations(boolean[] board, int tqueens, int qpsf, String psf, int a) {
		if (qpsf == tqueens) {
			counter2++;
			System.out.println(counter2 + ". " + psf + " ");
			return;
		}
		for (int i = a; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				combinations(board, tqueens, qpsf + 1, psf + "qb" + (i + 1) + " ", (i + 1));
				board[i] = false;
			}

		}
	}

	static int counter3 = 0;

	public static void coinchange(int[] coin, int amt, int amtp, String psf, int a) {
		if (amtp == amt) {
			counter3++;
			System.out.println(counter3 + " " + psf);
			return;
		}
		for (int i = a; i < coin.length; i++) {
			if (amtp + coin[i] < amt)
				coinchange(coin, amt, amtp + coin[i], psf + " " + coin[i], i);
		}

	}

	public static int knapsack(int[] wts, int[] values, int capacity, int Witem, int cost, int i) {
		int val1=0,val2=0;
		if(i==wts.length)
			return cost;
		val1=knapsack(wts, values, capacity, Witem, cost, i+1);
		
		if(Witem+wts[i]<=capacity)
			val2=knapsack(wts, values, capacity, Witem+wts[i], cost+values[i], i+1);
		return Math.max(val1, val2);
	}
}

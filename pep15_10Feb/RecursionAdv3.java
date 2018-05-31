package pep15_10Feb;

public class RecursionAdv3 {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		printNQueens(board, 4, 0, "", 0);
	}

	//static int counter2 = 0;

	public static void printNQueens(boolean[][] board, int tqueens, int qpsf, String psf, int a) {
		if (qpsf == tqueens) {
			//counter2++;
			System.out.println( ". " + psf + " ");
			return;
		}
		for (int i = a; i < board.length * board.length; i++) {
			if (board[i / board.length][i % board.length] == false) {
				if (isBoardValid(board, i / board.length, i % board.length) == true) {
					board[i / board.length][i % board.length] = true;
					printNQueens(board, tqueens, qpsf + 1, psf + (i) + " ", i + 1);
					board[i / board.length][i % board.length] = false;
				}
			}
		}
	}

	public static void printNKnights(boolean[][] board, int tknights, int qpsf, String psf, int a) {
		if (qpsf == tknights) {
			//counter2++;
			System.out.println( ". " + psf + " ");
			return;
		}
		for (int i = a; i < board.length * board.length; i++) {
			if (board[i / board.length][i % board.length] == false) {
				if (isKnightValid(board, i / board.length, i % board.length) == true) {
					board[i / board.length][i % board.length] = true;
					printNKnights(board, tknights, qpsf + 1, psf + (i) + " ", i + 1);
					board[i / board.length][i % board.length] = false;
				}
			}
		}
	}

	public static boolean isKnightValid(boolean[][] board, int i, int j) {

		if (i + 2 < board.length && j + 1 < board.length) {
			if (board[i + 2][j + 1] == true) {
				return false;
			}
		}
		if (i + 2 < board.length && j - 1 >= 0) {
			if (board[i + 2][j - 1] == true) {
				return false;
			}
		}
		if (i - 2 >= 0 && j + 1 < board.length) {
			if (board[i - 2][j + 1] == true) {
				return false;
			}
		}
		if (i - 2 >= 0 && j - 1 >= 0) {
			if (board[i - 2][j - 1] == true) {
				return false;
			}
		}
		if (i + 1 < board.length && j + 2 < board.length) {
			if (board[i + 1][j + 2] == true) {
				return false;
			}
		}
		if (i + 1 < board.length && j - 2 >= 0) {
			if (board[i + 1][j - 2] == true) {
				return false;
			}
		}
		if (i - 1 >= 0 && j - 2 >= 0) {
			if (board[i - 1][j - 2] == true) {
				return false;
			}
		}
		if (i - 1 >= 0 && j + 2 < board.length) {
			if (board[i - 1][j + 2] == true) {
				return false;
			}
		}
		return true;

	}

	public static boolean isBoardValid(boolean[][] board, int i, int j) {
		boolean f = false;
		for (int k = i; k < board.length; k++) {
			if (board[k][j] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = i; k >= 0; k--) {
			if (board[k][j] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = j; k < board.length; k++) {
			if (board[i][k] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = j; k >= 0; k--) {
			if (board[i][k] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = i, l = j; k < board.length && l < board.length; k++, l++) {
			if (board[k][l] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
			if (board[k][l] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = i, l = j; k >= 0 && l < board.length; k--, l++) {
			if (board[k][l] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		for (int k = i, l = j; k < board.length && l >= 0; k++, l--) {
			if (board[k][l] == true) {
				f = false;
				return f;
			} else
				f = true;
		}
		return f;
	}

	/*
	 * public static void isBoardValid2(boolean[][] board) better method { for
	 * (int i = 0; i < board.length; i++) { for (int j = 0; j < board.length;
	 * j++) { boolean f = isQueenValid(board, i, j);
	 * 
	 * } } }
	 */

	/*
	 * public static boolean isQueenValid(boolean[][] board, int row, int col)//
	 * called // from // better // method { int[][] direction = { { -1, -1 }, {
	 * -1, 0 }, { -1, 1 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, 0 }, { 1, 1 } };
	 * for (int i = 0; i < direction.length; i++) { for (int rad = 0; rad * rad
	 * <= 2 * board.length * board.length; rad++) { int rdash = row +
	 * direction[i][0]; int cdash = col + rad * direction[i][1]; } } }
	 */

}

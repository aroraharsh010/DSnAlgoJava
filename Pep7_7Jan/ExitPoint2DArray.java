package Pep7_7Jan;

public class ExitPoint2DArray {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		int row = 0, col = 0, dir = 0// for E S W N(0,1,2,3)
		;
		while (true) {
			dir = (dir + arr[row][col]) % 4;
			if (dir == 0) {
				col++;
				if (col == arr[0].length) {
					System.out.println(row + " " + (arr[0].length - 1));
					break;
				}

			} else if (dir == 1) {
				row++;
				if (row == arr.length) {
					System.out.println(arr.length - 1 + " " + col);
					break;
				}
			} else if (dir == 2) {
				col--;
				if (col == -1) {
					System.out.println(row + " " + 0);
					break;
				}
			} else if (dir == 3) {
				row--;
				if (row == -1) {
					System.out.println(0 + " " + col);
					break;
				}
			}
		}

	}
}

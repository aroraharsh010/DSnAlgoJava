package Pep2_25Dec;

import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row = 1, space = n / 2, ni = 1;
		int value = 1;

		while (row <= n) {
			int i = 1;
			int column = 1;

			while (i <= space)

			{
				System.out.print(" ");
				i++;
				column++;
			}
			i = 1;
			while (i <= ni) {
				i++;

				System.out.print(value);
				column++;
				if (column <= n / 2 + 1)
					value++;
				else if (row != 1 && column > n / 2 + 1)
					value--;

			}

			System.out.println("");
			row++;

			if (row <= n / 2 + 1) {
				space--;
				value = row;
				ni += 2;

			} else {
				space++;
				ni -= 2;

			}
		}

	}

}

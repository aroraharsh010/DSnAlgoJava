package Pep2_25Dec;
import java.util.Scanner;
public class PascalTrianglePttern {
	public static void main(String[] args) {
		int row;
		Scanner scn = new Scanner(System.in);
		row = scn.nextInt();
		for (int i = 0; i < row; i++) {
			int value = 1;
			for (int j = 0; j <= i; j++) {
				System.out.print(value + " ");
				value = (value * (i - j)) / (j + 1);
			}
			System.out.println();
		}
	}
}

package pep1_23Dec;
import java.util.Scanner;

public class PrimeNo {

	public static void main(String[] args) {
		int n;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter no.");
		n = scn.nextInt();
		int i = 2;

		while (i * i <= n && n != 1 && n != 0) {
			if (n % i == 0) {
				System.out.println("Not a Prime");
				return;
			} else
				i++;
		}
		System.out.println("Prime");
	}

}

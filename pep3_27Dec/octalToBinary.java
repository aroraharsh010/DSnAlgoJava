package pep3_27Dec;

import java.util.Scanner;

public class octalToBinary {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int src = scn.nextInt(), sb = 8, n = src, p = 1;
		int d = 1, s = 0, pr;
		long dest = 0;
		while (n != 0) {
			int rem = n % 10;

			pr = 1;
			s = 0;
			while (rem != 0) {
				d = rem % 2;
				s += d * pr;
				pr *= 10;
				rem /= 2;
			}
			dest = dest + (s) * p;
			p *= 1000;
			n /= 10;
		}
		System.out.println(dest);

	}

}

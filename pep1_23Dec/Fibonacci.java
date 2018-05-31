package pep1_23Dec;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int n1 = 0, n2 = 1,sum=0;
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 2; i <= n; i++) {
			 

	             sum = n1 + n2;
	            n1 = n2;
	            n2 = sum;
	            if (i==n)
	            {
	            	System.out.println(n2);
	            }
		}
		
	}

}

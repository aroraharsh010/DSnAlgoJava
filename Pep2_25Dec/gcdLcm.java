package Pep2_25Dec;

import java.util.Scanner;

public class gcdLcm {

	public static void main(String[] args) {
		 int n1 , n2 , gcd = 1;
			Scanner scn = new Scanner(System.in);
	         n1=scn.nextInt();
	         n2=scn.nextInt();

	        for(int i = 1; i <= n1 && i <= n2; ++i)
	        {
	            if(n1 % i==0 && n2 % i==0)
	                gcd = i;
	        }

	        
	        int lcm=(n1*n2)/gcd;
	        System.out.print( gcd+" "+lcm);
	}

}

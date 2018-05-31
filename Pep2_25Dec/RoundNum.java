package Pep2_25Dec;

import java.util.Scanner;

public class RoundNum
{

	public static void main(String[] args) 
	{
	    Scanner scn = new Scanner(System.in);
		long p = scn.nextLong();
		long n = scn.nextLong(), l = 0, i = 1;
		long m = n;
		while (m != 0) 
		{
			l++;
			m = m / 10;
		}
		p = p % l;
		if (p == 0) {
			System.out.println(n);
			return;
		}
		if (p > 0) {
			p = l - p;
		}
		if (p < 0)
		p *= -1;
		long r = n;
		r %= (long) Math.pow(10, p);
		n /= (long) Math.pow(10, p);
		r *= (long) Math.pow(10, (l - p));
		r += n;
		System.out.println(r);
     
     
     
     
     scn.close();
	}

}

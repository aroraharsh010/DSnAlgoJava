package pep4_29Dec;

import java.util.Scanner;

public class PreciseSquareRoot {

	public static void main(String[] args) 
	{
         Scanner scn=new Scanner(System.in);
  		 int n=scn.nextInt();
  		 int p=scn.nextInt();
  		int r=(int)Math.pow(10, p);
  		double prsr=Math.sqrt(n);
  		prsr=Math.floor(prsr*r)/r;
  		int insr=(int)prsr;
  		System.out.println(insr+" "+prsr);
  		}

}

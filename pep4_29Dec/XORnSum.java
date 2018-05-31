package pep4_29Dec;

import java.util.Scanner;

public class XORnSum {

	public static void main(String[] args) 
	{
      Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int count=0;
		
		for(int p=0;p<n;p++)
		{
		 if ((n^p)==(n+p))	
          {count++;}
		}
		System.out.println(count);
	}

}

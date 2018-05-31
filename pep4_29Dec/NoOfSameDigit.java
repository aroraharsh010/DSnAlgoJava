package pep4_29Dec;

import java.util.Scanner;

public class NoOfSameDigit {

	public static void main(String[] args) 
	{
     Scanner scn =new Scanner(System.in);
     long n=scn.nextLong();
     long t=n;
     int r=scn.nextInt();
     int count=0;
     while(t!=0)
     {   long rem=t%10;
         
    	 if (r==rem)
    		 count++;
    		
    	 t/=10;
    	 
     }
     System.out.println(count);
	}

}

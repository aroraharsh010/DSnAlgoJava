package pep4_29Dec;

import java.util.Scanner;

public class SumOfOddEvenPlace {

	public static void main(String[] args) 
	{
     Scanner scn = new Scanner(System.in);
     long n=scn.nextLong();
     long t=n;
     int sume=0,sumo=0,count=0;
     while (t!=0)
    	 
     {
    	long r=t%10;
    	 if (count%2==0)
    		 sume+=r;
    	 else
    		 sumo+=r;
    	 t/=10;
    	 count++;
     }
     System.out.println(sume+" "+sumo);
     
	}

}

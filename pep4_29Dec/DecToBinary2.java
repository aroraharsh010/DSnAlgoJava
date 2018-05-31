package pep4_29Dec;

import java.util.Scanner;

public class DecToBinary2 {

	public static void main(String[] args) 
	{
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     int i =31;
     while(i>=0)
     {
    	 int bitMask=1<<i;
    	 if ((bitMask&n)==0)
    		 System.out.print("0");
    	 else 
    		 System.out.print("1");
    	 i--;
    	
     }
     System.out.println(" "+  Integer.toBinaryString(n));
	}

}

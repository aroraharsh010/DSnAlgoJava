package pep3_27Dec;
//for positive no.s only

import java.util.Scanner;

public class bitManipu1 {

	public static void main(String[] args) 
	{
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     int r=scn.nextInt();
     int rem=1;
     for (int i=0;i<=r;i++)
     {
    	 rem=n%2;
    	 n/=2;
    	
     }
     if (rem==1)
     System.out.println("true");
     else
    	System.out.println("false");
	}

}

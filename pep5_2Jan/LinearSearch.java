package pep5_2Jan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		try {
		int N=scn.nextInt(); 
		int[] a=new int[N];
		for(int i=0;i<N;i++)
		   {   
			a[i]=scn.nextInt();
			}
    
     boolean flag=false;
     int n=scn.nextInt();
     for(int i=0;i<a.length;i++)
     {
    	 if(a[i]==n)
    	 {System.out.println(i);flag=true;break;}
    	
    	   
     }
     if (flag==false)
    	 System.out.println(-1);
	} catch(InputMismatchException e)
		{
		System.out.println("Invalid Input");
	}
	}

}

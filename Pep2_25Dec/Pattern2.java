package Pep2_25Dec;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		int row,num=1;
		Scanner scn=new Scanner(System.in);
		row=scn.nextInt();
		int i=0,space=2*row-3;
		while (i<row)
		{   for (int j=1;j<=num;j++)
		{
			System.out.print(j+" ");
			
	     }
		   for (int j=0;j<space;j++)
		   {
			   System.out.print("  ");
		   }
		   for(int j=num;j>0;j--)
		   {
			  if(j==row)
			  {
				  
			  }
			  else
			  System.out.print(j+" "); 
		   }
		   System.out.println("");
		   num++;
		   i++;
		   space-=2;
			
		}
	}

}

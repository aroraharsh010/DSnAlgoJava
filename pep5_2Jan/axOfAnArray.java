package pep5_2Jan;

import java.util.Scanner;

public class axOfAnArray //MaxOfArray
{

	public static void main(String[] args) 
	{Scanner scn = new Scanner(System.in);
	int N=scn.nextInt();
     int[] arr=new int[N];
     for(int i=0;i<N;i++)
     {
    	 arr[i]=scn.nextInt();
     }
     int max=arr[0];//Integer.MIN_VALUE;
     for(int i=1;i<arr.length;i++)
     {
    	 if (arr[i]>max)
    		 max=arr[i];
     }
     System.out.println(max);
	}

}

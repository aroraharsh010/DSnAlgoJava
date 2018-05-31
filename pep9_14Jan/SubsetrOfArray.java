package pep9_14Jan;

import java.util.Scanner;

public class SubsetrOfArray {
 static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) 
	{
	 int n=scn.nextInt();
     int[] arr=new int[n];
     inputArr(arr,n);
     printSubset(arr);
     
     
    }
	public static void inputArr(int[] arr,int N)
    {
    	for(int i=0;i<N;i++)
    	{   
    		arr[i]=scn.nextInt();
    	}
    }
	public static void printSubset(int[] arr)
	{  int limit=1<<arr.length;
		for(int i=0;i<limit;i++)
		{  System.out.print("[");
			for(int j=0;j<arr.length;j++)
			{
				int bitmask=1<<(arr.length-1-j);
				if((i&bitmask)!=0)
				{
					System.out.print(arr[j]+" ");
				}
				
			}
			System.out.print("]");
			System.out.println();
		}
		
	}


}

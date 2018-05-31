package Pep6_6Jan;

import java.util.Scanner;

public class TargetSum {
   static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) 
	{
     int N=scn.nextInt();
     int[] arr=new int[N];
     inputArr(arr,N);
     int n=scn.nextInt();
     bubbleSort(arr);
     printSum(arr,n);
     }
	public static void inputArr(int[] arr,int N)
    {
    	for(int i=0;i<N;i++)
    	{   
    		arr[i]=scn.nextInt();
    	}
    }
	public static void bubbleSort(int[] arr)
	{
		int counter=1;
		while(counter<=arr.length-1)
		{
		 	for(int i=0;i<arr.length-counter;i++)
		 	{
		 		if (arr[i]>arr[i+1])
		 		{
		 			Swap(arr,i,i+1);
		 		}
		 	  
		 	}
		 	counter++;
		}
		
		
	}
	public static void Swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
    public static void printSum(int[] arr,int n)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=i+1;j<arr.length;j++)
    		{
    			if(arr[i]+arr[j]==n)
    				System.out.println(arr[i]+" and "+arr[j]);
    		}
    	}
    }
}

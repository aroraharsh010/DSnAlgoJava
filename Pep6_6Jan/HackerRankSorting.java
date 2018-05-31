package Pep6_6Jan;

import java.util.Scanner;

public class HackerRankSorting {
	static Scanner scn=new Scanner(System.in);
     public static void main(String[] args) 
	{   int N=scn.nextInt();
		int[] arr1=new int[N];
		int[] arr2=new int[N],arr3=new int[N];
		inputArr(arr1,N);
		inputArr(arr2,N);
		inputArr(arr3,N);
		bubbleSort(arr1);
		selectionSort(arr2);
		reverseArray(arr2);
		insertionSort(arr3);
		display(arr1);
		display(arr2);
		display(arr3);
		}
	public static void inputArr(int[] arr,int N)
    {
    	for(int i=0;i<N;i++)
    	{   
    		arr[i]=scn.nextInt();
    	}
    }
	public static void display(int[] arr)
	{
		for(int val:arr)
		{
			System.out.print(val+" ");
		}
		System.out.println();
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
    public static void insertionSort(int[] arr)
	
	{
		int counter=1;
		while(counter<arr.length)
		{
			for(int i=counter;i>0;i--)
			{
				if(arr[i-1]>arr[i])	
					Swap(arr, i-1, i);
				else break;
					
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
    public static void selectionSort(int[] arr)
	{
		int counter=1;
		while(counter<=arr.length-1)
		{
			for(int i=counter;i<arr.length;i++)
			{
				if(arr[i]<arr[counter-1])
				{
					Swap(arr,i,counter-1);
				}
			}
			counter++;
		}
	}
    public static void reverseArray(int[] arr)
    {
    	int h=arr.length-1,t;
        for(int i=0;i<=h/2;i++)
        {
       	 t=arr[i];
       	 arr[i]=arr[h-i];
       	 arr[h-i]=t;
        }

    }
}
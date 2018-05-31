package Pep6_6Jan;

import java.util.Scanner;

public class IntersectionOfArrays {
	static Scanner scn=new Scanner(System.in);

	public static void main(String[] args) 
	{
      int m=scn.nextInt();
      int[] arr1=new int[m];
      inputArr(arr1,m);
      int n=scn.nextInt();
      int[] arr2=new int[n];
      inputArr(arr2,n);
      bubbleSort(arr1);
      bubbleSort(arr2);
      printIntersection(arr1, arr2, m, n);
	}
	static void printIntersection(int[] arr1, int[] arr2, int m, int n)
    {
      int i = 0, j = 0;
      System.out.print("[");
      while (i < m && j < n)
      {
        if (arr1[i] < arr2[j])
          i++;
        else if (arr2[j] < arr1[i])
          j++;
        else
        {
          System.out.print(arr2[j++]+",");
          i++;
        }
      }System.out.print("]");
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
	}

package Pep6_6Jan;

import java.util.Scanner;

public class IsInverse {
	static Scanner scn=new Scanner(System.in);

	public static void main(String[] args)
	{ int N=scn.nextInt();
	 int[] arr1=new int[N],arr2=new int[N];
	 inputArr(arr1,N);
	 inputArr(arr2,N);
	 int[] inv=inverseOfAnArray(arr1);
	 compare(inv,arr2,N);
	 }
	public static void inputArr(int[] arr,int N)
    {
    	for(int i=0;i<N;i++)
    	{   
    		arr[i]=scn.nextInt();
    	}
    }
	public static int[] inverseOfAnArray(int[] arr)
	{       int[] inv=new int[arr.length];
			for(int i=0;i<arr.length;i++)
			{
				inv[arr[i]]=i;
			}return inv;
	}
	public static void compare(int[] arr1,int[] arr2,int N)
	{
		for (int i=0;i<N;i++)
		{
			if (arr1[i]!=arr2[i])
			{
				System.out.println("false");break;
			}
		}
		System.out.println("true");
	}
}

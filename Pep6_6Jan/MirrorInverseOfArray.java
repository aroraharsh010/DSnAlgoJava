package Pep6_6Jan;

import java.util.Scanner;

public class MirrorInverseOfArray {

	public static void main(String[] args) {
	    Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		int[] arr = new int[N];
		inputArr(arr,N);
		boolean res = isMirrorInv(arr);
		int[] inv=inverseOfAnArray(arr);
		display(inv);
		System.out.println(res);

	}

	public static boolean isMirrorInv(int[] arr) {
		boolean f = true;
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[arr[i]] != i) {
				f = false;
				break;
			}

		}
		return f;
	}
    public static void inputArr(int[] arr,int N)
    {
    	for(int i=0;i<N;i++)
    	{   Scanner scn=new Scanner(System.in);
    		arr[i]=scn.nextInt();
    	}
    }
    public static int[] inverseOfAnArray(int[] arr)
	{   
		
			int[] inv=new int[arr.length];
			for(int i=0;i<arr.length;i++)
			{
				inv[arr[i]]=i;
			}
			return inv;
			
		}
    public static void display(int[] arr)
	{
		for(int val:arr)
		{
			System.out.print(val+" ");
		}
		System.out.println();
	}
}

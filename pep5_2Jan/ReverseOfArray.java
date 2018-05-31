package pep5_2Jan;

import java.util.Scanner;

public class ReverseOfArray {

	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
     int arr[]=new int[N];
     for(int i=0;i<N;i++)
     {
    	 arr[i]=scn.nextInt();
     }
     int h=arr.length-1,t;
     for(int i=0;i<=h/2;i++)
     {
    	 t=arr[i];
    	 arr[i]=arr[h-i];
    	 arr[h-i]=t;
     }
     for(int val:arr)
     {
    	 System.out.print(val+" ");
     }
	}

}

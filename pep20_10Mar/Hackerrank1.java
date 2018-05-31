package pep20_10Mar;

import java.util.*;


public class Hackerrank1 {// DP1,2
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();  
		while (n > 0) { 
			int x = scn.nextInt();
			int n1=scn.nextInt();
			System.out.println(smartPower(x, n1));
			n--; 
		} 
		
		
	}

	static boolean checkDupl(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{ 
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				return false;	
			}
		}
		return true; 
	}
	static void inputArr(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			arr[i] = scn.nextInt(); 
		}
		
	}
	static void checkArr(int[] arr)
	{   int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i]; 
		}
		System.out.println(max+", "+min);
			
	}
	static long smartPower(int x,int n)
	{   if(n==0)
		return 1; 
	    long p;
		long pn2=smartPower(x, n/2);
		if (n % 2 == 0)
			p = pn2 * pn2;
		else
			p = pn2 * pn2 * x;  
		return p; 
		
	}
	
	
	

}

package pep14_4Feb;

import java.util.*;

public class hackerrankQ {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// System.out.println(maxFreqChar("abc"));
		int r=scn.nextInt();
		int c=scn.nextInt();
		int[][] arr1 =new int[r][c];
		int[][] arr2 =new int[r][c];
				/*{ { 22, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		saddlePoint(arr);*/
		input(arr1);input(arr2);
		traceMatrix(arr1, arr2);
		 
	}

	public static char maxFreqChar(String s) {
		int max = 0;

		char mch = s.charAt(0);
		for (int j = 0; j < s.length(); j++) {
			int counter = 0;
			char ch = s.charAt(j);
			for (int i = j + 1; i < s.length(); i++) {
				if (s.charAt(i) == ch)
					counter++;
			}
			if (counter > max) {
				counter = max;
				mch = ch;
			}

		}
		return mch;
	}

	public static void saddlePoint(int[][] arr) {
		int max = 0;
		boolean f = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				for (int k = 0; k < arr.length; k++) {
					if (arr[i][j] >= arr[k][j])
						f = true;
					else {
						f = false;
						break;
					}
				}
				if (f == false)
					break; 

				for (int k = 0; k < arr[0].length; k++) {
					if (arr[i][j] <= arr[i][k])
						f = true;
					else {
						f = false;
						break;
					}
				}
				if (f == false)
					break;

				if (f == true)
					max = arr[i][j];
			}

		}
		System.out.println(max);
	}

	public static void input(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

	}
	public static void traceMatrix(int[][] arr1,int[][] arr2)
	{
		int[][] arr=new int[arr1.length][arr1[0].length];
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				arr[i][j]=arr1[i][j]+arr2[i][j];
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i][i];
		}
		System.out.println(sum);
		
		
	}
	
	public static void betweenParanthesis(String s)
	{
		
	}
}

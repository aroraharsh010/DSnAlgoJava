package Pep7_7Jan;

import java.util.Scanner;

public class WaveDisplay {
   static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) 
	{
     int r=scn.nextInt();
     int c=scn.nextInt();
     int[][] arr=new int[r][c];
     input(arr);
     rowWaveDisplay(arr);System.out.println();
     colWaveDisplay(arr);
	}
	public static void rowWaveDisplay(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[0].length; j++) {

					System.out.print(arr[i][j] + " ");

				}
			} else
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}

		}
	}
	public static void colWaveDisplay(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr.length; j++) {

					System.out.print(arr[j][i] + " ");

				}
			} else
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.print(arr[j][i] + " ");
				}

		}
	}
    public static void display(int[][] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr[0].length;j++)
    		{
    			System.out.print(arr[i][j]);
    		}System.out.println();
    	}
    }
    public static void input(int[][] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr[0].length;j++)
    		{
    			arr[i][j]=scn.nextInt();
    		}
    	}
    }
}

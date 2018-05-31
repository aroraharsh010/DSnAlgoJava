package pep8_13Jan;

import java.util.Scanner;

public class MatrixMultiplication {
 static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) 
	{int r=scn.nextInt(),c=scn.nextInt();
     int[][] one=new int[r][c];
     inputArr(one);
     int[][] two=new int[r][c];
     inputArr(two);
     if(one[0].length==two.length)
     {matrixMult(one,two);}
	
	else 
		{System.out.println("cant multiply");}}
	public static void display(int[][] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr[0].length;j++)
    		{
    			System.out.print(arr[i][j]+" ");
    		}System.out.println();
    	}
    }
    public static void matrixMult(int[][] one,int[][] two)
    {
     int[][] product=new int[one.length][two[0].length];	
     int row1=one.length,row2=two.length,col1=one[0].length,col2=two[0].length;
     for(int i=0;i<row1;i++)
     {
    	 for(int j=0;j<col2;j++)
    	 {
    		 for(int k=0;k<row2;k++)//row2||col1
    		 {
    			 product[i][j]+=one[i][k]*two[k][j];
    		 }
    	 }
     }
     display(product);
     
    }
    public static void inputArr(int[][] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{   for(int j=0;j<arr[0].length;j++)
    		{arr[i][j]=scn.nextInt();}
    	}
    }

}

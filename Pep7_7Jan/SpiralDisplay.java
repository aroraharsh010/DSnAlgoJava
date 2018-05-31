package Pep7_7Jan;

import java.util.Scanner;

public class SpiralDisplay {
    static Scanner scn=new Scanner(System.in);
	public static void main(String[] args)
	{
     int r=scn.nextInt();
     int c=scn.nextInt();
     int[][] arr=new int[r][c];
     input(arr);
     spiralDisplay1(arr);
     System.out.println();
     spiralDisplay2(arr);
	}
	 public static void spiralDisplay2(int[][] arr)
	    {
	     int rowmin=0,rowmax=arr.length-1;
	     int t=arr.length*arr[0].length,counter=0;
	     int colmin=0,colmax=arr[0].length-1;
	     
	     while(counter<t)
	     {
	     for  (int row=rowmin;row<=rowmax&&counter<t;row++)
	     {
	    	System.out.print(arr[row][colmin]+" "); 
	    	counter++;
	     }
	     colmin++;
	    for(int col=colmin;col<=colmax&&counter<t;col++)
	    {
	    	System.out.print(arr[rowmax][col]+" ");
	    	counter++;
	    }
	    rowmax--;
	    for ( int row=rowmax;row>=rowmin&&counter<t;row--)
	    {
	    	System.out.print(arr[row][colmax]+" ");
	    	counter++;
	    }
	    colmax--;
	    for ( int col=colmax;col>=colmin&&counter<t;col--)
	    {
	    	System.out.print(arr[rowmin][col]+" ");
	    	counter++;
	    }
	    rowmin++;
	    
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
     public static void spiralDisplay1(int[][] arr)
     {
    	 int rowmin=0,rowmax=arr.length-1;
         int t=arr.length*arr[0].length,counter=0;
         int colmin=0,colmax=arr[0].length-1;
         
         while(counter<t)
         {
        	 for(int col=colmin;col<=colmax&&counter<t;col++)
        	    {
        	    	System.out.print(arr[rowmin][col]+" ");
        	    	counter++;
        	    }
        	  rowmin++;
        	    for  (int row=rowmin;row<=rowmax&&counter<t;row++)
        	     {
        	    	System.out.print(arr[row][colmax]+" "); 
        	    	counter++;
        	     }
        	     colmax--;
        	     for(int col=colmax;col>=colmin;col--)
        	     {
        	    	 System.out.print(arr[rowmax][col]+" ");
        	    	 counter++;
        	     }
        	     rowmax--;
        	     for(int row=rowmax;row>=rowmin;row--)
        	     {
        	    	 System.out.print(arr[row][colmin]+" ");
        	    	 counter++;
        	     }
        	     colmin++;
         }
     }
}

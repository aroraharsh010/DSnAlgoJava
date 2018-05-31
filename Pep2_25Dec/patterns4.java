package Pep2_25Dec;

import java.util.Scanner;

public class patterns4 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
	     int row=scn.nextInt();
	     int value1=0,value2=1,value3;
	     value3=value1+value2;
	     for(int i=0;i<row;i++)
	     {   
	    	 
	    	 
	    	 for(int j=0;j<=i;j++)
	    	 {
	    		 System.out.print(value1+" ");
	    		 value1=value2;value2=value3;value3=value1+value2;
	;    	 }
	    	 
	    	 System.out.println("");
		}
	}

}

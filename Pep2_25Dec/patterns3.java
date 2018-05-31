package Pep2_25Dec;

import java.util.Scanner;

public class patterns3 {

	public static void main(String[] args) {
     Scanner scn=new Scanner(System.in);
     int row=scn.nextInt();
     int value=1;
     for(int i=0;i<=row;i++)
     {   
    	 
    	 
    	 for(int j=0;j<=i;j++)
    	 {
    		 System.out.print(value+" ");
    		 value++;
;    	 }
    	 
    	 System.out.println("");
	}

}
}

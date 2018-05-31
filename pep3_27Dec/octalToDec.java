package pep3_27Dec;

import java.util.Scanner;

public class octalToDec {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
	     int src=scn.nextInt();
	     int dest=0,sb=8,db=10,p=1;
	     int n=src;
	     while(n!=0)
	     {  
	    	int rem=n%db; 
	       
	    	  
	    	 dest=dest+(rem)*p;
	    	 p*=sb;
	    	 n/=db; 
	     }
	     
	     System.out.println(dest);
	     
	}

}

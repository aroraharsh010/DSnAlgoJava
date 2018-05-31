package pep3_27Dec;

import java.util.Scanner;

public class octalToBinary2 {

	public static void main(String[] args) 
	{
		
		      Scanner scn=new Scanner(System.in);
		        int src=scn.nextInt(),sb=8,n=src,p=1;
		        int d=1,s=0,pr=1;
		        long dest=0;
		        while(n!=0)
		        {
		        	int rem=n%10;
		        	if (rem==0)
		        	{
		        		s=111;
		        	}
		        	else if (rem==1)
		        		s=1;
		        	else if(rem==2)
		        		s=10;
		        	else if(rem==3)
		        		s=11;
		        	else if (rem==4)
		        	    s=100;
		        	else if(rem==5)
		        		s=101;
		        	else if (rem==6)
		        		s=110;
		        	else if (rem==7)
		        		s=111;
		        	
		        	
		 	        dest=dest+(s)*p;
			    	 p*=1000;
			    	 n/=10; 
	}
		        System.out.println(dest);

}
}

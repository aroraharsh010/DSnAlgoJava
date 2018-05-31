package pep4_29Dec;

import java.util.Scanner;

public class PowerOfTwo {

	public static void main(String[] args) 
	{
     boolean res=false;
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     int i=1;
     int p=1;
     if (n==1)
     {res=true;}
     while(p<=n)
     { p=(int)Math.pow(2, i);
    	 if(p==n)
    	 {res=true;break;}
    	 i++;
     }
     System.out.println(res);
	}

}

package pep1_23Dec;
import java.util.Scanner;
public class Patterns2 {

	public static void main(String[] args) {
		int n;
          Scanner scn=new Scanner(System.in);
	    n=scn.nextInt();
	    int t=(n/2)+1;
	    int curline=1;
	    while(curline<=t)
	    {
	    	int curspace=t-curline;
	    	for(int i=0;i<curspace;i++)
	    	{
	    		System.out.print(" ");
	    	}
	    	int x=2*curline-1;
	    	for(int i=0;i<x;i++)
	    	{
	    		System.out.print("*");
	    	}
	    	System.out.println(" ");
	    	curline++;
	    }
	    while(curline<=n)
	    {
	    int curspace=curline-t;
	    for(int i=0;i<curspace;i++)
	    {
	    	System.out.print(" ");
	    }
	    
	    int x=2*(n-curline)+1;
	    for(int i=0;i<x;i++)
	    {
	    	System.out.print("*");
	    }
	    System.out.println(" ");
	    curline++;
	    }

	    


        }
		
	}



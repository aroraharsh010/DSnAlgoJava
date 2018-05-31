package pep1_23Dec;
import java.util.Scanner;
public class Pattern1 {

	public static void main(String[] args) {
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     if (n==0)
    	 System.out.println(" ");
     else
     {
     for (int i=0;i<=n;i++)
     {   for (int j=0;j<i;j++)
    	 System.out.print("*");
    	 
       System.out.println(" ");
     }}
		
	}

}

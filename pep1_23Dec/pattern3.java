package pep1_23Dec;
import java.util.Scanner;
public class pattern3 
{

	public static void main(String[] args) 
	{
		int n,star,space;
		Scanner scn=new Scanner(System.in);
		n=scn.nextInt();
		star=n/2+1;
		space=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<star;j++)
			{
				System.out.print("*");
				
			}
			for(int j=0;j<space;j++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<star;j++)
			{
				System.out.print("*");
				
			}
			if(i<=n/2)
			{star-=1;space+=2;}
			else
			{star+=1;space-=2;}
			System.out.println("");
			
		}
		

	}

}

package pep4_29Dec;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args)
	{
       Scanner scn=new Scanner(System.in);
       char ch='y';
       int n1,n2;
		while(ch!='x'&& ch!='X')
		{
			ch=scn.next().charAt(0);
			
			if (ch=='+')
				{n1=scn.nextInt();
			    n2=scn.nextInt();
				System.out.println(n1+n2);
				}
			else if(ch=='-')
				{n1=scn.nextInt();
			n2=scn.nextInt();
				System.out.println(n1-n2);}
			else if (ch=='*')
				{n1=scn.nextInt();
			    n2=scn.nextInt();
				System.out.println(n1*n2);}
			else if (ch=='/')
			{    n1=scn.nextInt();
			n2=scn.nextInt();
				if (n2!=0)
					System.out.println(n1/n2);
			}
			else if (ch=='%')
				{
				n1=scn.nextInt();
				n2=scn.nextInt();
				System.out.println(n1%n2);}
			else if (ch=='x'||ch=='X')
			{System.out.println(" ");}
			else
				System.out.println("Invalid Operation");
		}
	}

}

package pep4_29Dec;

import java.util.Scanner;

public class FarToCel {

	public static void main(String[] args) 
	{
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     double cel= ((5.0/9)*(n-32));
     System.out.println(cel);
	}

}

package pep4_29Dec;

import java.util.Scanner;

public class RightMostOne {

	public static void main(String[] args) 
	{
		 Scanner scn=new Scanner(System.in);
		 int num=scn.nextInt();
		 int bitMapOfRightMostOne=num&(-num);
		 System.out.println(bitMapOfRightMostOne);
  
	}

}

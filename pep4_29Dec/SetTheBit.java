package pep4_29Dec;

import java.util.Scanner;

public class SetTheBit {

	public static void main(String[] args) 
	{

		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int r=scn.nextInt();
		int bitMask=1<<r;
		int numSwitchon=n;
		numSwitchon=numSwitchon|bitMask;
		System.out.println(numSwitchon);
		
	}

}

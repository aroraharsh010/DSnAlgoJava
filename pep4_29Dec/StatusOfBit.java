package pep4_29Dec;

//Bit Manipulation method that includes -ve nums too.
import java.util.Scanner;

public class StatusOfBit {

	public static void main(String[] args) {
     
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int r=scn.nextInt();
		int bitMask=1<<r;
		if((bitMask&n)==0) //or if((bitMask&n)==bitMask)
			System.out.println("False");
			else
				System.out.println("True");
		System.out.println(Integer.toBinaryString(n));
		
	}

}

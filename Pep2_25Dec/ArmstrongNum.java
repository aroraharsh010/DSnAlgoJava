package Pep2_25Dec;

import java.util.Scanner;

public class ArmstrongNum {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int number = scn.nextInt(), t, remainder, result = 0, n = 0;

        t = number;

        for (;t != 0; t /= 10, ++n);

        t = number;

        for (;t != 0; t /= 10)
        {
            remainder = t % 10;
            result += Math.pow(remainder, n);
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
	}

}

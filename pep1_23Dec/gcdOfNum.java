package pep1_23Dec;
import java.util.Scanner;
public class gcdOfNum {

	public static void main(String[] args) {
		int n1 , n2 , gcd = 1;
		Scanner scn = new Scanner(System.in);
         n1=scn.nextInt();
         n2=scn.nextInt();

        for(int i = 1; i <= n1 && i <= n2; ++i)
        {
            if(n1 % i==0 && n2 % i==0)
                gcd = i;
        }

        System.out.println( gcd);
	}

}

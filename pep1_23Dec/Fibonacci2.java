
package pep1_23Dec;
import java.util.Scanner;
public class Fibonacci2 {

	public static void main(String[] args) {
		int t1 = 0, t2 = 1;
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();

        for (int i = 1; i <= 1000000000 ; ++i)
        {
            if (t2<=n)
        	{System.out.print(t2 + "  ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;}
            else
            	break;
        }
	}

}

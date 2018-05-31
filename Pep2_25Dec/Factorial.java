package Pep2_25Dec;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt(),r=scn.nextInt();
    int nfact=1,rfact=1,nrfact=1;
    for(int i=1;i<=n;i++)
    {
    	nfact*=i;
    }
    for(int i=1;i<=r;i++)
    {
    	rfact*=i;
    }
    for(int i=1;i<=n-r;i++)
    {
    	nrfact*=i;
    }
    int p=nfact/(nrfact);
    int c=p/rfact;
    System.out.println(nfact);
    System.out.println(p);
    System.out.println(c);
    
	}

}

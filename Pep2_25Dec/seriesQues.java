package Pep2_25Dec;
import java.util.Scanner;

public class seriesQues {

	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		int a=scn.nextInt(),d=scn.nextInt(),r=scn.nextInt(),n=scn.nextInt();
		int fap=a,fgp=a,fagp=1,sap=a,sgp=a,sagp=a;
		for(int i=1;i<n;i++)
		{
			fap+=d;
			sap+=fap;
			fgp*=r;
			sgp+=fgp;
			fagp=fgp*fap/a;
			sagp+=fagp;
		}
		System.out.print(fap+" "+fgp+" "+fagp+" "+sap+" "+sgp+" "+sagp);
     
	}

}

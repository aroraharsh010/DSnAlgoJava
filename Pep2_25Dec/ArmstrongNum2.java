package Pep2_25Dec;

import java.util.Scanner;

public class ArmstrongNum2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int arn=scn.nextInt();
		int sr=scn.nextInt();
		int er=scn.nextInt();
		if(er<1 || sr<1)
			return;
		int n=0;
		int h=0;
		int temp=arn;
		while(temp!=0)
		{
			temp/=10;
			h++;
		}
		int cp=er;
		while(cp!=0)
		{
			cp/=10;
			n++;
		}
		int sum=0;
		int m=arn;
		while(arn!=0)
		{
			int r;
			r=arn%10;
			sum=sum+(int)Math.pow(r, h);
			arn=arn/10;
		}
		if(sum==m)
			System.out.println("true");
		else System.out.println("false");
		while(sr<er)
		{
			int s=0;
			int q=sr;
			int t=sr;
			while(t!=0)
			{
				int r;
				r=t%10;
				s=s+(int)Math.pow(r, n);
				t=t/10;
			}
			if(s==q)
				System.out.print(sr + " ");
			sr++;
		}

	}

}

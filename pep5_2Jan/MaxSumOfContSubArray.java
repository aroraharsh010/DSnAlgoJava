package pep5_2Jan;

import java.util.Scanner;

public class MaxSumOfContSubArray {

	public static void main(String[] args) 
	{   Scanner scn=new Scanner(System.in);
	    int n=scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[0]=scn.nextInt();
		}
		int cseqsum = arr[0];
		int cseqsp = 0;
		int cseqep = 0;
		int omaxseqsum = arr[0];
		int omaxseqsp = 0;
		int omaxxseqep = 0;
		
		for(int i = 1; i < arr.length; i++){
			if(cseqsum >= 0){ // why >=?
				cseqsum = cseqsum + arr[i];
				cseqep = i;
			} else {
				cseqsum = arr[i];
				cseqsp = i;
				cseqep = i;
			}
			
			if(cseqsum > omaxseqsum){
				omaxseqsum = cseqsum;
				omaxseqsp = cseqsp;
				omaxxseqep = cseqep;
			} else if(cseqsum == omaxseqsum){
				if(omaxxseqep - omaxseqsp < cseqep - cseqsp){
					omaxseqsum = cseqsum;
					omaxseqsp = cseqsp;
					omaxxseqep = cseqep;	
				}
			}
		}
     
     
	}

}

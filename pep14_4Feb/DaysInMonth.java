package pep14_4Feb;

import java.util.*;

public class DaysInMonth {
   static Scanner scn=new Scanner(System.in);
   
	public static void main(String[] args) 
	{
	 int t=scn.nextInt();
	 int[] tday=new int[t];
	 String[] day=new String[t];
	 input(tday, day);
	 int[] count=new int[7];
	 for(int i=0;i<day.length;i++)
	 {   int a=0;
		 if(day[i].equals("mon"))
			 a=0;
		 else if(day[i].equals("tues"))
			 a=1;
		 else if(day[i].equals("wed"))
			 a=2;
		 else if(day[i].equals("thurs"))
			 a=3;
		 else if(day[i].equals("fri"))
			 a=4;
		 else if(day[i].equals("sat"))
			 a=5;
		 else if(day[i].equals("sun"))
			 a=6;
		 int k=a-1;
		 for(int j=1;j<tday[i];j++)
		 {
	      if(k<7)
	    	  k++;
	      else
	    	  k=0;
		  count[k]=count[k]+1;
		 }
		 display(count);System.out.println();
	 }
	 

	}
	public static void input(int[] tday,String[] day)
	{
	  for(int i=0;i<tday.length;i++)
	  {
		tday[i]=scn.nextInt();
		day[i]=scn.next();
	  }
	}

	public static void display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}

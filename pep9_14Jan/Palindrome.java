package pep9_14Jan;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) 
	{Scanner scn=new Scanner(System.in);
     String s1=scn.nextLine();
     countPalinSubstrings(s1);
     
	}
	public static  boolean IsPalindrome(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	public static void countPalinSubstrings(String s)
	{  int count=0;
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				String str=s.substring(i, j);
				boolean res=IsPalindrome(str);
				if (res==true)
				{   System.out.println(str);
					count++;
				}
				
			}
		}
		System.out.println(count);
	}
   

}

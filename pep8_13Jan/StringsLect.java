package pep8_13Jan;

import java.util.Scanner;

public class StringsLect {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		/*printChar(s);
		printSubstrings(s);*/
		Subsequences(s);
	}

	public static void printChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}

	public static void printSubstrings(String s) {

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
				}
		}

	}

	public static void Subsequences(String s) {
	    int limit=1<<s.length();
	
		
		for(int i=0;i<limit;i++)
		{
			for(int j=0;j<s.length();j++)
			{
				int bitmask=1<<(s.length()-1-j);
				if((i&bitmask)!=0)
				{
					System.out.print(s.charAt(j));
				}
				else System.out.print(" ");
			}
			System.out.println();
		}
		

	}

}

package pep12_27Jan;

import java.util.ArrayList;

public class Recursion3//also 4
{

	public static void main(String[] args) {
		// int[] arr={4,1,0,2,3};

		// System.out.println(getKPC("536"));
		// printKPC("234", "");
		int[] snl = new int[21];
		snl[2] = 19;
		snl[5] = 13;
		snl[17] = 3;
		snl[11] = 7;
		int[] dice = { 1, 4, 3, 6, 1, 2, 4, 6, 5, 1, 2, 6, 2 };
		fullSnakeLadder(0, 20, snl, dice, 0);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void Inverse(int[] arr, int i) {
		if (i == arr.length)
			return;
		int t = arr[i];
		Inverse(arr, i + 1);
		arr[t] = i;
	}

	public static ArrayList<String> getSS(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rresult = getSS(ros);
		ArrayList<String> mresult = new ArrayList<>();
		for (String rstr : rresult) {
			mresult.add(rstr);
		}
		for (String rstr : rresult) {
			mresult.add(ch + rstr);
		}
		return mresult;

	}

	public static ArrayList<String> getASCIIss(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rresult = getASCIIss(ros);
		ArrayList<String> mresult = new ArrayList<>();
		for (String rstr : rresult) {
			mresult.add(rstr);
		}
		for (String rstr : rresult) {
			mresult.add(ch + rstr);
		}
		for (String rstr : rresult) {
			mresult.add((int) (ch) + rstr);
		}
		return mresult;

	}

	public static ArrayList<String> getKPC(String s) {
		if (s.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s.charAt(0);
		String s1 = s.substring(1);
		ArrayList<String> rresult = getKPC(s1);
		ArrayList<String> mresult = new ArrayList<>();
		for (int i = 0; i < rresult.size(); i++) {
			for (int j = 0; j < codes[(int) (ch - '0')].length(); j++) {
				mresult.add(codes[(ch - '0')].charAt(j) + rresult.get(i));

			}
		}
		return mresult;

	}

	public static void printSS(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		printSS(ros, asf);
		printSS(ros, asf + ch);
	}

	public static void getASCiiSS(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		getASCiiSS(ros, asf);
		getASCiiSS(ros, asf + ch);
		getASCiiSS(ros, asf + (int) ch);
	}

	static String[] codes = { ".", "abc", "def", "ghi", "jklm", "no", "pqrs", "tu", "vwx", "yz" };

	public static void printKPC(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String chcode = codes[ch - '0'];
		for (int i = 0; i < chcode.length(); i++) {
			printKPC(roq, asf + chcode.charAt(i));

		}

	}

	public static void printBoardPaths(int curr, int end, String psf) {
		if (curr == end) {
			System.out.println(psf);
			return;
		}
		if (curr == 0) {
			printBoardPaths(curr + 1, end, psf + 1);
			printBoardPaths(curr + 6, end, psf + 6);
		} else {
			for (int i = 1; i <= 6; i++) {
				if (curr + i <= end) {
					printBoardPaths(curr + i, end, psf + i);
				}
			}
		}
	}

	static int counter = 1;

	public static void printBoardPathWithLadder(int curr, int end, int[] ladder, String psf) {
		if (curr == end) {
			System.out.println(counter + ". " + psf);
			counter++;
			return;
		}
		if (curr == 0) {
			printBoardPathWithLadder(curr + 1, end, ladder, psf + 1);
			printBoardPathWithLadder(curr + 6, end, ladder, psf + 6);
		} else if (ladder[curr] != 0) {
			printBoardPathWithLadder(ladder[curr], end, ladder, psf + " (" + curr + "->" + ladder[curr] + ") ");
		} else {
			for (int i = 1; i <= 6; i++) {
				if (curr + i <= end && ladder[curr] == 0) {
					printBoardPathWithLadder(curr + i, end, ladder, psf + " " + i);
				}
			}
		}
	}

	public static void fullSnakeLadder(int curr//current position of player
			                         , int end, //final position on game
			                           int[] snl,//array containing src pos of ladders and snakes 
			                           int[] dice, //array containing dice moves
			                           int i//vidx
			                           ) 
	{
		if (curr == end) {      
			System.out.println(true);
			return;
		}
		if(curr>end)
			return;
		if (i == dice.length) {
			System.out.println("false "+curr);
			return;
		}
		if (curr == 0 )
		{   if(dice[i] != 1 || dice[i] != 6)
			    fullSnakeLadder(curr, end, snl, dice, i + 1);
		   else
				fullSnakeLadder(curr+dice[i],end, snl, dice, i+1);
		}
		else if (snl[curr] != 0)
			fullSnakeLadder(snl[curr], end, snl, dice, i);
		else if((curr+dice[i])>end)
			fullSnakeLadder(curr, end, snl, dice, i + 1);
		else 
			fullSnakeLadder(curr + dice[i], end, snl, dice, i + 1);
	}
}

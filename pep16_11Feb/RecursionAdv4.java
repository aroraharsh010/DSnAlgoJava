package pep16_11Feb;

import java.util.ArrayList;

public class RecursionAdv4 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		// ArrayList<Integer> list = new ArrayList<>();
		// printTSS2(arr, 70, 0, 0, list);
		// printTSSstaticSSf(arr, 70, 0, list);
		// ArrayList<Integer> lis1 = new ArrayList<>(), list2 = new
		// ArrayList<>();
		// printEquiSum(arr, 0, "", "", 0, 0);

	   printPerms1SB(new StringBuilder("abc"), new StringBuilder(""));
		printPermutations1("abc", "");
	}

	public static void printTsS(int[] arr, int t, int i, int ssf, String psf) {
		if (i == arr.length) {
			if (t == ssf)
				System.out.println(psf);
			return;
		}

		printTsS(arr, t, i + 1, ssf + arr[i], psf + " " + arr[i]);

		printTsS(arr, t, i + 1, ssf, psf);

	}

	public static void printTSS2(int[] arr, int t, int i, int ssf, ArrayList<Integer> psf) {
		if (i == arr.length) {
			if (t == ssf)
				System.out.println(psf);

			return;
		}
		psf.add(arr[i]);
		printTSS2(arr, t, i + 1, ssf + arr[i], psf);
		psf.remove(psf.size() - 1);
		printTSS2(arr, t, i + 1, ssf, psf);
	}

	static int ssf = 0;

	public static void printTSSstaticSSf(int[] arr, int t, int i, ArrayList<Integer> psf)// Using
																							// static
																							// variables
	{
		if (i == arr.length) {
			if (t == ssf)
				System.out.println(psf);
			return;
		}
		psf.add(arr[i]);
		ssf += arr[i];
		printTSSstaticSSf(arr, t, i + 1, psf);
		ssf -= arr[i];
		psf.remove(psf.size() - 1);
		printTSSstaticSSf(arr, t, i + 1, psf);
	}

	public static void printEquiSum(int[] arr, int i, String s1, String s2, int sum1, int sum2) {
		if (i == arr.length) {
			if (sum1 == sum2)
				System.out.println("[" + s1 + "] [" + s2 + "]");
			return;
		}
		printEquiSum(arr, i + 1, s1 + " " + arr[i], s2, sum1 + arr[i], sum2);
		printEquiSum(arr, i + 1, s1, s2 + " " + arr[i], sum1, sum2 + arr[i]);
	}

	public static void printEquiSum2(int[] arr, int i, ArrayList<Integer> s1, ArrayList<Integer> s2, int sum1,
			int sum2) {
		if (i == arr.length) {
			if (sum1 == sum2)
				System.out.println(s1 + " " + s2);
			return;
		}
		s1.add(arr[i]);
		printEquiSum2(arr, i + 1, s1, s2, sum1 + arr[i], sum2);
		s1.remove(s1.size() - 1);
		s2.add(arr[i]);
		printEquiSum2(arr, i + 1, s1, s2, sum1, sum2 + arr[i]);
		s2.remove(s2.size() - 1);
	}

	public static void printPermutations1(String s, String asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String ros = s.substring(0, i) + s.substring(i + 1);
			printPermutations1(ros, asf + ch);
		}

	}

	public static void printPerms2(String s, String asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		for (int i = 0; i <= asf.length(); i++) {
			String left = asf.substring(0, i);
			String right = asf.substring(i);
			printPerms2(ros, left + ch + right);
		}
	}

	public static void printPerms1SB(StringBuilder s, StringBuilder asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			s.deleteCharAt(i);
			asf.append(ch);
			printPerms1SB(s, asf);
			asf.deleteCharAt(asf.length()-1);
			s.insert(i, ch);
		}
	}

	public static void printPerm2SB(StringBuilder s, StringBuilder asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = s.charAt(0);
		s.deleteCharAt(0);
		for (int i = 0; i <= asf.length(); i++) {
			asf.insert(i, ch);
			printPerm2SB(s, asf);
			asf.deleteCharAt(i);
		}
		s.insert(0, ch);
	}

}

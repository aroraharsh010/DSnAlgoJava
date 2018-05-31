package pep18_18Feb;

import java.util.Arrays;

public class TimeAndComplexity {

	public static void main(String[] args) {
		// polynomial(2, 3);
		// sieveOfEratosthenes(97);
		String s = "abaaba";
		countPalinSubstringslesstime(s);
	}

	public static void polynomial(int x, int n) {
		int a = 0, c = x;
		for (int i = n; i >= 0; i--) {
			a += i * c;
			c *= x;
		}
		System.out.println(a);
	}

	public static void polynomial2(int x, int n) {
		int a = 0, coeff = 1;
		int pow = (int) Math.pow(x, n);

		for (int i = 1; i <= n; i++) {
			a += coeff * pow;
		}
	}

	public static void sieveOfEratosthenes(int n) {// to get all prime nums till
													// n(reduced complexity)
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false; 
		for (int i = 2; i * i < arr.length; i++) {
			if (arr[i] == true) {
				for (int j = i; j * i < arr.length; j++) {
					arr[i * j] = false;
				}
			}
		}
		display(arr);

	}

	public static void display(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true)
				System.out.print(i + " ");
		}

	}

	public static void countPalinSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String str = s.substring(i, j);
				boolean res = IsPalindrome(str);
				if (res == true) {
					System.out.println(str);
					count++;
				}

			}
		}
		System.out.println(count);
	}

	public static boolean IsPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static void countPalinSubstringslesstime(String s) {
		int c = 0; 
		for (int axis = 0; axis < s.length(); axis = axis + 1) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit += 1) {
				if (s.charAt((int) (axis - orbit)) == s.charAt((int) (axis + orbit))) {
					c++;
				} else
					break;
			}
		} 
		for (double axis = 0.5; axis < s.length(); axis = axis + 1) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit += 1) {
				if (s.charAt((int) (axis - orbit)) == s.charAt((int) (axis + orbit))) {
					c++;
				} else
					break;
			}
		}
		System.out.println(c);
	}
}

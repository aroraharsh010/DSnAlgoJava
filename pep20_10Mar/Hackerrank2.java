package pep20_10Mar;

import java.util.*;

public class Hackerrank2 {// rotate

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();
		while (n > 0) {
			int n1=scn.nextInt();
			int[] arr=new int[n1];
			inputArr(arr);
			findDuplicate(arr);
			n--; 

		}
		// sieveOfEratosthenes(n);
	}
	public static void findDuplicate(int[] arr)// with complexity O(n)
	{
		int fxor = 0;
		for (int i = 0; i < arr.length; i++) {
			fxor = fxor ^ i ^ arr[i];

		}
		System.out.println(fxor);
	}

	static void operation(String s) {
		int[] index = new int[26];
		int max = Integer.MIN_VALUE, maxi = 0;
		char[] Char = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);
			int vidx = (int) ch - 97;
			index[vidx]++;
			if (index[vidx] > max) {
				max = index[vidx];
				maxi = vidx;
			}

		}
		System.out.println(Char[maxi]);

	}

	static void inputArr(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			arr[i] = scn.nextInt();
		}

	}

	static void getIndex(int[] arr) {
		int a = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				a = i;
				break;
			}

		}
		System.out.println(a);
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

	static void display(boolean[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true)
				System.out.print(i + " ");
		}
	}

	static void singleLoopScan(int[] arr) {
		int n0 = 0, n1 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				n0++;
			if (arr[i] == 1) 
				n1++;
			/*if (arr[i] == 2)
				n2++;*/
		}
		for (int i = 0; i < n0; i++) {
			System.out.print(0 + " ");
		}
		for (int i = 0; i < n1; i++) {
			System.out.print(1 + " ");

		}
		/*for (int i = 0; i < n2; i++) {
			System.out.print(2 + " ");

		}*/

	}
	

}

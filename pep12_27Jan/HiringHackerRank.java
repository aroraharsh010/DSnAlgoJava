package pep12_27Jan;

import java.util.*;

public class HiringHackerRank {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();
		String[] names = new String[n];
		int[] iArr = new int[n];
		int[] fArr = new int[n];
		inputAll(names, iArr, fArr, n);
		int mDiff = 0, diff = 0, mi = 0;
		for (int i = 0; i < n; i++) {
			diff = fArr[i] - iArr[i];
			if (diff > mDiff) {
				mDiff = diff;
				mi = i;
			}
		}
		System.out.println(names[mi] + " " + mDiff);
	}

	public static void inputAll(String[] names, int[] iArr, int[] fArr, int n) {
		for (int i = 0; i < n; i++) {
			names[i] = scn.next();
			iArr[i] = scn.nextInt();
			fArr[i] = scn.nextInt();
		}
	}
}

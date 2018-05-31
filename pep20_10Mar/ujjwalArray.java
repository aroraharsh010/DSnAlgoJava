package pep20_10Mar;

import java.util.ArrayList;
import java.util.Scanner;

public class ujjwalArray {
	

	int min(int x, int y) {
		return (x < y) ? x : y;
	}

	int max(int x, int y) {
		return (x > y) ? x : y;
	}

		int findLength(int arr[], int n) {
		int max_len = 1; // Initialize result
		for (int i = 0; i < n - 1; i++) {
			int mn = arr[i], mx = arr[i];

			for (int j = i + 1; j < n; j++) {
				mn = min(mn, arr[j]);
				mx = max(mx, arr[j]);

				if ((mx - mn) == j - i)
					max_len = max(max_len, mx - mn + 1);
			}
		}
		return max_len; 
	}

	public static void main(String[] args) {
		ujjwalArray large = new ujjwalArray();
		int arr[] = { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 };
		int n = arr.length;
		System.out.println(large.findLength(arr, n)); 
	}
}

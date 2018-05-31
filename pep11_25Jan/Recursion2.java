package pep11_25Jan;

public class Recursion2 {
	// int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] arr = { 77, 66, 88, 22, 88, 43, 12, -12, 88 };

		/*
		 * printArr(arr,0);System.out.println(); printArrRev(arr,0);
		 */

		/*
		 * int m = maxNum(arr, 0); System.out.println(m);
		 */
		// System.out.println(search(arr, 77, 0));
		// System.out.println(Findex(arr, 88, 0));
		display(fai(arr, 88, 0, 0));
		// display(printArrRev(arr, 0));

	}

	public static int[] printArrRev(int[] arr, int i) {
		int[] a = new int[arr.length];
		if (i == arr.length)
			return new int[arr.length];
		a = printArrRev(arr, i + 1);
		return a;

	}

	public static void printArr(int[] arr, int i) {
		if (i == arr.length)
			return;
		System.out.print(arr[i] + " ");
		printArr(arr, i + 1);

	}

	public static int maxNum(int[] arr, int i) {
		if (i == arr.length)
			return Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		max = maxNum(arr, i + 1);
		if (max < arr[i])
			return arr[i];
		else
			return max;
	}

	public static boolean search(int[] arr, int d, int i) {
		if (i == arr.length)
			return false;
		boolean a = false;
		if (a == false) {
			if (d == arr[i])
				return true;
			else
				a = false;
		}
		a = search(arr, d, i + 1);
		return a;
	}

	public static int Lindex(int[] arr, int d, int i) {
		if (i == arr.length)
			return -1;
		int a = Lindex(arr, d, i + 1);
		if (a == -1) {
			if (d == arr[i])
				return i;
		}
		return a;
	}

	public static int Findex(int[] arr, int d, int i) {
		if (i == arr.length)
			return -1;
		int a = -1;
		if (a == -1) {
			if (d == arr[i])
				return i;
		}
		a = Findex(arr, d, i + 1);
		return a;
	}

	public static int[] fai(int[] arr, int d, int i, int count) {// error
		if (i == arr.length)
			return new int[0];
		if (d == arr[i]) {
			count++;
		}
		int[] a = fai(arr, d, i + 1, count);
		if (d == arr[i]) {
			a[count - 1] = i;
		}
		return a;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	

}

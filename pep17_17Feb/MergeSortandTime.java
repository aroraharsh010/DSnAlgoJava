package pep17_17Feb;

import java.util.*;



public class MergeSortandTime {

	public static void main(String[] args) {
		int[] arr1 = { 1, 34, 56, 78, 90, 100 };
		/*int[] arr2 = { 2, 4, 67, 89, 99 };*/      
		quicksortMeth(arr1, 0, arr1.length - 1);
		display(arr1);
// to sort some stuff quickly use this line of code
		//Arrays.sort(arr1);
		//to sort arraylists use Collections.sort(ArrayList);
		//String s=add2octalNum(335, 572);
	}

	public static int[] merge2Sort(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (k < arr.length) {
			if (i >= arr1.length) {
				arr[k] = arr2[j];
				j++;
				k++;
			} else if (j >= arr2.length) {
				arr[k] = arr1[i];
				i++;
				k++;
			} else {

				if (arr1[i] < arr2[j]) {
					arr[k] = arr1[i];
					i++;
					k++;
				} else {
					arr[k] = arr2[j];
					j++;
					k++;
				}
			}
		}

		return arr;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] mergeSort1Arr(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] x = { arr[lo] };
			return x;
		}
		int mid = (lo + hi) / 2;
		int[] one = mergeSort1Arr(arr, lo, mid);
		int[] two = mergeSort1Arr(arr, mid + 1, hi);
		int[] farr = merge2Sort(one, two);
		return farr;

	}

	public static void quicksortMeth(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int left = low, right = high;
		int mid = (left + right) / 2;
		int p = arr[mid];

		while (left <= right) {
			while (arr[left] < p) {
				left++;
			}
			while (arr[right] > p) {
				right--;
			}
			if (left <= right) {
				int t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
				left++;
				right--;
			}
		}
		quicksortMeth(arr, low, right);
		quicksortMeth(arr, left, high);
	}

	public static String add2octalNum(int a, int b) {
     //int val=a+b;
     return Integer.toOctalString(a+b);
	}

	public static int digits(int a) {
		int counter = 0;
		int rem = -1;
		while (rem != 0) {
			rem = a % 2;
			counter++;
		} 
		return counter;
	}

}

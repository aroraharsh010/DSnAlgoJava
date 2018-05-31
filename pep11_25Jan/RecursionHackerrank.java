package pep11_25Jan;
import java.util.Scanner;

public class RecursionHackerrank {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		/*int n = scn.nextInt();

		int[] arr = new int[n];
		inputArr(arr, n);
		bubbleSort(arr,1,0);
		//int i=scn.nextInt();
		display(arr);*/
		//System.out.println(arr[i]);
		//display(arr);
		/*
		 * int d=scn.nextInt(); int[] a=fai(arr, d, 0, 0); int i=scn.nextInt();
		 * System.out.println(a[i]);
		 */
		/*
		 * int i=scn.nextInt(); System.out.println(triangle(i,0));
		 */
		/*//int div=Integer.parseInt(scn.next(), 10);
		System.out.println(StringSum(s, 0));*/
		/*String s=scn.nextLine();
		String s2=scn.nextLine();*/
		
		/*if(reverseStrings(s, s.length()-1, "").equals(s2))
		System.out.println("true");
		else
			System.out.println("false");*/
		int n=scn.nextInt();
		binomialPascal(n, 0, 0, 1);

	}

	public static boolean palindrome(int[] arr, int i) {
		boolean a = false;
		if (i == arr.length)
			return false;
		if (a == false)
			if (arr[i] == arr[arr.length - 1 - i])
				return true;
		a = palindrome(arr, i + 1);
		return a;

	}

	public static void inputArr(int[] arr, int N) {
		for (int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
	}

	public static int[] fai(int[] arr, int d, int i, int count) {
		if (i == arr.length) {
			int[] a = new int[count];
			return a;
		}
		if (d == arr[i]) {
			count++;
		}
		int[] a = fai(arr, d, i + 1, count);
		if (d == arr[i]) {
			a[count - 1] = i;
		}
		return a;
	}

	public static void print1(int i) {
		if (i == 0)
			return;
		print1(i - 1);
		for (int j = 1; j <= i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	public static void print2(int i) {
		if (i == 0)
			return;

		for (int j = 1; j <= i; j++) {
			System.out.print("*");
		}
		System.out.println();
		print2(i - 1);
	}
    public static int triangle(int n, int sum) {
		if (n == 0)
			return sum;
		sum = sum + n;
		sum = triangle(n - 1, sum);
		return sum;

	}
	public static boolean checkArr(int[] arr, int i)

	{
		if (i == arr.length)
			return true;
		boolean f = checkArr(arr, i + 1);
		if ((i >= 1)) {
			if (arr[i] < arr[i - 1])
				f = false;
		}
		return f;

	}
	public static void reverseArr(int[] arr)
	{
		for(int i=0;i<(arr.length)/2;i++)
		{
			int t=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=t;
		}
	}
	public static void display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
		 System.out.print(arr[i]+" ");
		}
	}
	public static void bubbleSort(int[] arr,int i,int j)
	{
	 if(i==arr.length)
		 return;
	if(j<arr.length-1-i)
		bubbleSort(arr, i, j+1);
	else
		bubbleSort(arr, i+1, 0);
	if(arr[j]>arr[j+1]) 
		Swap(arr, j,j+1);
    }
	public static void binomialPascal(int n,int i,int j,int value)
	{
		if(i==n)
			return ;
		if(j<=i)
			{System.out.print(value);
			binomialPascal(n, i, j+1,value);}
		else
			{System.out.println();
			binomialPascal(n,i+1,0,value);}
		 value=(value * (i - j)) / (j + 1);
		 return ;
			
	}
	public static void Inverse(int[] arr, int i) {
		if (i == arr.length)
			return;
		int t = arr[i];
		Inverse(arr, i + 1);
		arr[t] = i;
	}
	public static void Swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static long StringToInt(String s,long n)
	{   if(s.length()==0)
		return n;
		n+=(long)((s.charAt(0)-'0')*Math.pow(10,s.length()-1));
		String ros=s.substring(1);
	    n=StringToInt(ros,n);
		return n;
	}
    public static int StringSum(String s,int n)
    {
    	if(s.length()==0)
    		return n;
    		n+=(int)((s.charAt(0)-'0'));
    		String ros=s.substring(1);
    	    n=StringSum(ros,n);
    		return n;
    }
    public static String reverseStrings(String s,int i,String s1)
    {
     if(i<0)
    	 return s1;
     s1+=s.charAt(i);
     s1=reverseStrings(s, i-1,s1);
     return s1;
    }
}  

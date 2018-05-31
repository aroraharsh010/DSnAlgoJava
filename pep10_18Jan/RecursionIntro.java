package pep10_18Jan;

public class RecursionIntro {

	public static void main(String[] args) {
		int n1 = 5, x = 3;
		// int f=factorial(n1);System.out.println(f);
		// printDI(n1);
		// int p=powerSmart(n1,x);System.out.println(p);
		// int f=fib(n1);System.out.println(f);
		towerOfHanoiInstruct("a", "b", "c", 3);
	}

	public static void printD(int n) {
		if (n == 0)
			return;
		System.out.print(n + " ");
		printD(n - 1);
	}

	public static void printI(int n) {
		if (n == 0)
			return;
		printI(n - 1);
		System.out.print(n + " ");
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		int fn1 = factorial(n - 1);
		int f = n * fn1;
		return f;

	}

	public static void printDI(int n) {
		if (n == 0)
			return;
		System.out.println("hi " + n);
		printDI(n - 1);
		System.out.println("bye " + n);
	}

	public static int power(int x, int n) {
		if (n == 0)
			return 1;
		int p1 = power(x, n - 1);
		int p = p1 * x;
		return p;

	}

	public static int powerSmart(int x, int n) {
		int p12 = 1, p = 1;
		if (n == 0)
			return 1;

		p12 = power(x, n / 2);

		if (n % 2 == 0)
			p = p12 * p12;
		else
			p = p12 * p12 * x;
		return p;
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int f1 = fib(n - 1) + fib(n - 2);
		return f1;

	}

	public static void towerOfHanoiInstruct(String src, String dest, String help, int shell) {
		if (shell == 0)
			return;
		towerOfHanoiInstruct(src, help, dest, shell - 1);
		System.out.println(shell + "(" + src + "->" + dest + ")");
		towerOfHanoiInstruct(help, dest, src, shell - 1);
	}
	
}

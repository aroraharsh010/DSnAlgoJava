package pep14_4Feb;

import java.util.ArrayList;
import java.util.Scanner;

public class HackerrankQues {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * int n = scn.nextInt(); int[] x = new int[n], y = new int[n]; boolean
		 * f = false; input(x, y, 0); int countx = 0, county = 0; for (int i =
		 * 0; i < x.length - 1; i++) { if (x[i] == x[i + 1]) countx++; } if
		 * (countx == x.length - 1) f = true; for (int i = 0; i < y.length - 1;
		 * i++) { if (y[i] == y[i + 1]) county++; } if (countx == x.length - 1)
		 * f = true; System.out.println(f);
		 */
		/*
		 * int tr=scn.nextInt(),tc=scn.nextInt();
		 * System.out.println(printMazePath2(0, 0, tr, tc, 0));
		 * System.out.println(printMazePath3(0, 0, tr, tc, list, ""));
		 * printMazePath(0, 0, tr, tc, "");
		 */
		/*
		 * printBoardPaths(0, 5, "", 6); System.out.println(printBoardPaths2(0,
		 * 5, 0, 6)); System.out.println(printBoardPaths3(0, 5, list, "", 6));
		 */
		/*
		 * System.out.println(getASCiiSS2("ab",0)); ArrayList<String> list=new
		 * ArrayList<>(); System.out.println(getASCiiSS3("ab", "", list));
		 * getASCiiSS("ab", "");ArrayList<String> list=new ArrayList<>();
		 */

		int n = scn.nextInt();
		long[] u = new long[n];
		long[] v = new long[n];
		long[] x = new long[n];
		double[] s = new double[n];
		input(u, v, x, s);
		for (int i = 0; i < s.length; i++) {
			String res = String.format("%.11f", s[i]);
			System.out.println(res.substring(0, res.length() - 1));
		}

	}

	public static void input(long[] u, long[] v, long[] x, double[] s) {
		for (int i = 0; i < u.length; i++) {
			u[i] = scn.nextInt();
			v[i] = scn.nextInt();
			x[i] = scn.nextInt();
			s[i] = (x[i] / ((double) v[i] + u[i]));
		}
	}

	public static ArrayList<String> printMazePathManyMoves3(int sr, int sc, int dr, int dc, String psf,
			ArrayList<String> list) {
		if (sr == dr && sc == dc) {
			list.add(psf);
			return list;
		}
		if (sr > dr || sc > dc)
			return list;
		for (int i = 1; i <= dc - sc; i++) {
			list = printMazePathManyMoves3(sr, sc + i, dr, dc, psf + "H" + i, list);
		}
		for (int i = 1; i <= dr - sr; i++) {
			list = printMazePathManyMoves3(sr + i, sc, dr, dc, psf + "V" + i, list);
		}

		for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
			list = printMazePathManyMoves3(sr + i, sc + i, dr, dc, psf + "D" + i, list);
		}
		return list;
	}

	public static void printMazePathManyMoves(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		if (sr > dr || sc > dc)
			return;
		for (int i = 1; i <= dc - sc; i++) {
			printMazePathManyMoves(sr, sc + i, dr, dc, psf + "H" + i);
		}
		for (int i = 1; i <= dr - sr; i++) {
			printMazePathManyMoves(sr + i, sc, dr, dc, psf + "V" + i);
		}

		for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
			printMazePathManyMoves(sr + i, sc + i, dr, dc, psf + "D" + i);
		}
	}

	public static int printMazePathManyMoves2(int sr, int sc, int dr, int dc, String psf, int counter) {
		if (sr == dr && sc == dc) {
			counter++;
			return counter;
		}
		if (sr > dr || sc > dc)
			return counter;
		for (int i = 1; i <= dc - sc; i++) {
			counter = printMazePathManyMoves2(sr, sc + i, dr, dc, psf + "H" + i, counter);
		}
		for (int i = 1; i <= dr - sr; i++) {
			counter = printMazePathManyMoves2(sr + i, sc, dr, dc, psf + "V" + i, counter);
		}

		for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
			counter = printMazePathManyMoves2(sr + i, sc + i, dr, dc, psf + "D" + i, counter);
		}
		return counter;
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

	public static ArrayList<String> getASCiiSS3(String ques, String asf, ArrayList<String> list) {
		if (ques.length() == 0) {
			list.add(asf);
			return list;
		}
		char ch = ques.charAt(ques.length() - 1);
		String ros = ques.substring(0, ques.length() - 1);
		list = getASCiiSS3(ros, asf, list);
		list = getASCiiSS3(ros, asf + ch, list);
		list = getASCiiSS3(ros, asf + (int) ch, list);
		return list;
	}

	public static int getASCiiSS2(String ques, int counter) {
		if (ques.length() == 0) {
			return (counter + 1);
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		counter = getASCiiSS2(ros, counter);
		counter = getASCiiSS2(ros, counter);
		counter = getASCiiSS2(ros, counter);
		return counter;
	}

	/*
	 * public static void input(int[] x, int[] y, int i) { if (i == x.length)
	 * return; x[i] = scn.nextInt(); y[i] = scn.nextInt(); input(x, y, i + 1);}
	 */

	public static void printMazePath(int sr, int sc, int dr, int dc, String psf) {// with
		// diagonal
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		if (sc + 1 <= dc)
			printMazePath(sr, sc + 1, dr, dc, psf + "H");
		if (sr + 1 <= dr)
			printMazePath(sr + 1, sc, dr, dc, psf + "V");
		if (sc + 1 <= dc && sr + 1 <= dr)
			printMazePath(sr + 1, sc + 1, dr, dc, psf + "D");

	}

	public static int printMazePath2(int sr, int sc, int dr, int dc, int counter) {// with
		// diagonal
		if (sr == dr && sc == dc) {

			return (counter + 1);
		}
		if (sc + 1 <= dc)
			counter = printMazePath2(sr, sc + 1, dr, dc, counter);
		if (sr + 1 <= dr)
			counter = printMazePath2(sr + 1, sc, dr, dc, counter);
		if (sc + 1 <= dc && sr + 1 <= dr)
			counter = printMazePath2(sr + 1, sc + 1, dr, dc, counter);
		return counter;

	}

	public static ArrayList<String> printMazePath3(int sr, int sc, int dr, int dc, ArrayList<String> list, String psf) {// with
		// diagonal
		if (sr == dr && sc == dc) {
			list.add(psf);
			return list;
		}
		if (sc + 1 <= dc)
			list = printMazePath3(sr, sc + 1, dr, dc, list, psf + "H");
		if (sr + 1 <= dr)
			list = printMazePath3(sr + 1, sc, dr, dc, list, psf + "V");
		if (sc + 1 <= dc && sr + 1 <= dr)
			printMazePath3(sr + 1, sc + 1, dr, dc, list, psf + "D");
		return list;
	}

	public static void printBoardPaths(int curr, int end, String psf, int dice) {
		if (curr == end) {
			System.out.println(psf);
			return;
		}

		else {
			for (int i = 1; i <= dice; i++) {
				if (curr + i <= end) {
					printBoardPaths(curr + i, end, psf + i, dice);
				}
			}
		}
	}

	public static int printBoardPaths2(int curr, int end, int counter, int dice) {
		if (curr == end) {

			return (counter + 1);
		}

		else {
			for (int i = 1; i <= dice; i++) {
				if (curr + i <= end) {
					counter = printBoardPaths2(curr + i, end, counter, dice);
				}
			}
		}
		return counter;
	}

	public static ArrayList<String> printBoardPaths3(int curr, int end, ArrayList<String> list, String psf, int dice) {
		if (curr == end) {
			list.add(psf);
			return list;
		}

		else {
			for (int i = 1; i <= dice; i++) {
				if (curr + i <= end) {
					list = printBoardPaths3(curr + i, end, list, psf + i, dice);
				}
			}
		}
		return list;
	}

}

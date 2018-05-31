package pep14_4Feb;

public class Hackerrank3 {

	public static void main(String[] args) {
		//System.out.println(countHi("khihihijjhihijjjjjhhdhdhi", 0));
		String a = removeHi("khihihijjhihijjjjjhhdhdhi", "");
		System.out.println(a);
	}

	public static String removeHi(String s, String a) {
		if (s.length() <=1) {
			return a;
		} // String b = "";
		String ros;
		char ch = s.charAt(0);
		if (ch == 'h') {
			if (s.charAt(1) == 'i') {
				// b = s.substring(0, 2);
				ros = s.substring(2);
				a = removeHi(ros, a+"pep");
			} else {
				ros = s.substring(1);
				a = removeHi(ros, a + ch);
			}
		} else {
			ros = s.substring(1);
			a = removeHi(ros, a + ch);
		}
		return a;

	}
	public static int countHi(String s, int a) {
		if (s.length() <=1) {
			return a;
		} // String b = "";
		String ros;
		char ch = s.charAt(0);
		if (ch == 'h') {
			if (s.charAt(1) == 'i') {
				// b = s.substring(0, 2);
				ros = s.substring(2);
				a = countHi(ros, a+1);
			} else {
				ros = s.substring(1);
				a = countHi(ros, a );
			}
		} else {
			ros = s.substring(1);
			a = countHi(ros, a );
		}
		return a;

	}

	
}

package pep9_14Jan;

public class StringBuilderQues {

	public static void main(String[] args) {
		String s = "aaabbccddd";
		/*
		 * String s1=toggleCase(s); String s2=modify2(s); System.out.println(s);
		 * System.out.println(s2);
		 */
		compress2(s);

	}

	public static String toggleCase(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				sb.setCharAt(i, (char) (ch + 32));
			} else if (ch >= 'a' && ch <= 'z')
				sb.setCharAt(i, (char) (ch - 32));
		}
		s = sb.toString();
		return s;

	}

	public static String modify1(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (i % 2 == 0) {
				sb.setCharAt(i, (char) (ch - 1));
			} else
				sb.setCharAt(i, (char) (ch + 1));
		}
		s = sb.toString();
		return s;
	}

	public static String modify2(String s) {
		StringBuilder sb = new StringBuilder();
		// sb.append(s.charAt(0));

		for (int i = 0; i < s.length() - 1; i++)

		{
			sb.append(s.charAt(i));
			sb.append(s.charAt(i + 1) - s.charAt(i));

			// sb.append(s.charAt(i+1));
		}
		sb.append(s.charAt(s.length() - 1));
		s = sb.toString();
		return s;
	}

	public static void compress1(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {

			if ((s.charAt(i)) != s.charAt(i + 1)) {
				sb.append(s.charAt(i));
			}

		}
		sb.append(s.charAt(s.length() - 1));
		System.out.println(sb);
	}

	public static void compress2(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {

			if ((s.charAt(i)) != s.charAt(i + 1)) {
				sb.append(s.charAt(i));

				if (count > 1) {
					sb.append(count);
					count = 1;
				}

			} else
				count++;
		}
		sb.append(s.charAt(s.length() - 1));
		System.out.println(sb);
	}
}

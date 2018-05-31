package pep20_10Mar;

public class DP2 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 5, 0, 3 }, { 6, 7, 0, 8, 2 }, { 17, 0, 6, 0, 0 }, { 5, 15, 0, 3, 2 } };
		// goldMiner(arr);
		//palinSubStrings("abaaba");
		int[] arr2={5,3,9,12,8,10,1,80,4};
		longestIncrSubArr(arr2); 
	}

	static void goldMiner(int[][] arr) {      
		int[][] str = new int[arr.length][arr[0].length];
		int max = str[0][0];
		int maxi = 0;
		String[][] opath = new String[arr.length][arr[0].length];

		for (int j = arr[0].length - 1; j >= 0; j--) {
			for (int i = arr.length - 1; i >= 0; i--) {
				if (j == arr[0].length - 1) {
					str[i][j] = arr[i][j];
					opath[i][j] = "";

				}

				else if (i == 0) {
					int a = str[i][j + 1]; 
					int b = str[i + 1][j + 1];
					if (a > b) {
						str[i][j] = arr[i][j] + a;
						opath[i][j] = "H" + opath[i][j + 1];
					} else {
						str[i][j] = arr[i][j] + b;
						opath[i][j] = "D2" + opath[i + 1][j + 1];
					}
				}

				else if (i == arr.length - 1) {
					int a = str[i - 1][j + 1];
					int b = str[i][j + 1];
					if (a > b) {
						str[i][j] = arr[i][j] + a;
						opath[i][j] = "D1" + opath[i - 1][j + 1];
					} else {
						str[i][j] = arr[i][j] + b;
						opath[i][j] = "H" + opath[i][j + 1];
					}
				} else {
					int a = str[i - 1][j + 1];
					int b = str[i][j + 1];
					int c = str[i + 1][j + 1];
					if (a > b && a > c) {
						str[i][j] = arr[i][j] + a;
						opath[i][j] = "D1" + opath[i - 1][j + 1];
					} else if (b > a && b > c) {
						str[i][j] = arr[i][j] + b;
						opath[i][j] = "H" + opath[i][j + 1];
					} else {
						str[i][j] = arr[i][j] + c;
						opath[i][j] = "D2" + opath[i + 1][j + 1];
					}
				}
				if (str[i][j] > max) {
					max = str[i][j];
					maxi = i;
				}
			}
		}
		System.out.println(max + "@ " + maxi + "," + opath[maxi][0]);
	}

	static void palinSubStrings(String s)// Using dp
	{
		int counter = 0;
		boolean[][] arr = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			int i = 0;
			int j = gap + i;
			while (j < s.length()) {
				if (gap == 0) {
					arr[i][j] = true;
					counter++;
				} else if (s.charAt(i) == s.charAt(j)) {
					if (j == i + 1) {
						arr[i][j] = true;
						counter++;
					} else if (arr[i + 1][j - 1] == true) {
						arr[i][j] = true;
						counter++;
					}

				} else
					arr[i][j] = false;
				i++;
				j++;
			}
		}
		System.out.println(counter);
	}

	static void longestIncrSubArr(int[] arr) { 
		int omax=0; 
		int[] str = new int[arr.length];
	String p="";
		String[] path = new String[arr.length];
		str[0] = 1;path[0]=arr[0]+" ";
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				//int a;
				if (arr[i] > arr[j]) {
				if(str[j]>str[i]) 
					{str[i]=str[j];
					 path[i]=path[j];   
					}              
				}
			} 
				str[i]+=1;
				path[i]+= arr[i]+" ";  
			if(str[i]>omax)
				{omax=str[i]; 
				   p = path[i]; 
				}  
		} 
		
		System.out.println(omax+"@ "+p);  

	}
	static void longestBitonicSubsequence(int[] arr)
	{
		
		int omax=0; 
		int[] str = new int[arr.length];
		str[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				//int a;
				if (arr[i] > arr[j]) {
				if(str[j]>str[i]) 
					{str[i]=str[j];
					 //path[i]=path[j];    
					}              
				}
			} 
				str[i]+=1;
				//path[i]+= arr[i]+" ";  
			if(str[i]>omax)
				{omax=str[i];  
				   //p = path[i]; 
				}  
		}
		
		
	}

}

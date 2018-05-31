package Pep7_7Jan;

public class FunWithDisplayingArrrays {

	public static void main(String[] args) {
		int[][] arr = { 
				{ 11, 12, 13, 14 ,15}, 
				{ 21, 22, 23, 24 ,25}, 
				{ 31, 32, 33, 34 ,35 }, };
		colWaveDisplay(arr);
		System.out.println();
		rowWaveDisplay(arr);
		System.out.println();
		spiralDisplay(arr); 

	}

	public static void colWaveDisplay(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr.length; j++) {

					System.out.print(arr[j][i] + " ");

				}
			} else
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.print(arr[j][i] + " ");
				}

		}
	}
    public static void rowWaveDisplay(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[0].length; j++) {

					System.out.print(arr[i][j] + " ");

				}
			} else
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}

		}
	}
    public static void spiralDisplay(int[][] arr)
    {
     int rowmin=0,rowmax=arr.length-1;
     int t=arr.length*arr[0].length,counter=0;
     int colmin=0,colmax=arr[0].length-1;
     
     while(counter<t)
     {
     for  (int row=rowmin;row<=rowmax&&counter<t;row++)
     {
    	System.out.print(arr[row][colmin]+" "); 
    	counter++;
     }
     colmin++;
    for(int col=colmin;col<=colmax&&counter<t;col++)
    {
    	System.out.print(arr[rowmax][col]+" ");
    	counter++;
    }
    rowmax--;
    for ( int row=rowmax;row>=rowmin&&counter<t;row--)
    {
    	System.out.print(arr[row][colmax]+" ");
    	counter++;
    }
    colmax--;
    for ( int col=colmax;col>=colmin&&counter<t;col--)
    {
    	System.out.print(arr[rowmin][col]+" ");
    	counter++;
    }
    rowmin++;
    
     }
    }
}

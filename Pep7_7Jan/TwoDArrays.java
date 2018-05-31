package Pep7_7Jan;

public class TwoDArrays {

	public static void main(String[] args)
	{
     int[][] arr={{2,3,4},{4,5,6},{2,4,6},{3,6,5}};
     display(arr);
	}
	public static void display(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

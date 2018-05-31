package Pep6_6Jan;

public class InverseOfArr {

	public static void main(String[] args) 
	{
      int[] arr={4,2,1,3,0};
      int[] inv=inverseOfAnArray(arr);
      display(arr);
      display(inv);
      
      
	}
	public static int[] inverseOfAnArray(int[] arr)
	{       int[] inv=new int[arr.length];
			for(int i=0;i<arr.length;i++)
			{
				inv[arr[i]]=i;
			}return inv;
	}
	public static void display(int[] arr)
	{
		for(int val:arr)
		{
			System.out.print(val+" ");
		}
		System.out.println();
	}

}

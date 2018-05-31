package Pep6_6Jan;
import java.util.Scanner;
public class RotatingNumArray {

	public static void main(String[] args) 
	{
      int[] arr={9,6,2,3,1};
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      n%=arr.length;
      if(n<0)
    	  n+=arr.length;
      
    
      display(arr);
      rotateArr2(arr, n);
      display(arr);
            
      
	}
	public static void rotateArr(int[] arr,int n)
	{
		int[] temp=new int[n];
		for(int i=0;i<n;i++)
		{
			temp[i]=arr[arr.length-n+1];
			
			
		}
		for (int i=arr.length-n;i>=0;i--)
		{
			arr[i+n]=arr[i];
		}
		
		for(int i=0;i<n;i++)
		{
			arr[i]=temp[i];
			
		}
	}
	public static void display(int[] arr)
	{
		for(int val:arr)
		{
			System.out.print(val+" ");
		}
		System.out.println();
	}
    public static void rotateArr2(int[] arr,int n)
    {

    	
    		reverseArr(arr,0,arr.length-n-1);
    		reverseArr(arr,arr.length-n,arr.length-1);
    		reverseArr(arr,0,arr.length-1);
    		
    	
    }
    public static void reverseArr(int[] arr,int l,int h)
    {
    	for(int i=l;i<=h;i++,h--)
    	     {
    	    	 int t=arr[i];
    	    	 arr[i]=arr[h];
    	    	 arr[h]=t;
    	     }
    	   
    
    }
}

package Pep6_6Jan;

public class SortingFunctions {

	public static void main(String[] args) 
	{
     int[] arr={34,56,31,65,78,1,-67,77,10};
     display(arr);
    // bubbleSort(arr);
     //selectionSort(arr);
     insertionSort(arr);
     display(arr);
	}
	public static void display(int[] arr)
	{
		for(int val:arr)
		{
			System.out.print(val+" ");
		}
		System.out.println();
	}
	public static void bubbleSort(int[] arr)
	{
		int counter=1;
		while(counter<=arr.length-1)
		{
		 	for(int i=0;i<arr.length-counter;i++)
		 	{
		 		if (arr[i]>arr[i+1])
		 		{
		 			Swap(arr,i,i+1);
		 		}
		 	  
		 	}
		 	counter++;
		}
		
		
	}
	public static void selectionSort(int[] arr)
	{
		int counter=1;
		while(counter<=arr.length-1)
		{
			for(int i=counter;i<arr.length;i++)
			{
				if(arr[i]<arr[counter-1])
				{
					Swap(arr,i,counter-1);
				}
			}
			counter++;
		}
	}
	public static void insertionSort(int[] arr)
	
	{
		int counter=1;
		while(counter<arr.length)
		{
			for(int i=counter;i>0;i--)
			{
				if(arr[i-1]>arr[i])	
					Swap(arr, i-1, i);
				else break;
					
			}
			counter++;
		}
	}
	public static void Swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}

package pep12_27Jan;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) 
	{
     //Declaration
		ArrayList<Integer> list=new ArrayList<>();
		//append
		list.add(10);
		list.add(20);
		list.add(30);
		
		//size
		System.out.println(list.size());
		System.out.println(list);
		//insert
		list.add(2,40);
		System.out.println(list);
		//delete
		}

}

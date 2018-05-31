package linkedLists;
public class Client {

	public static void main(String[] args) {

		LinkedList list=new LinkedList();
		list.addLast(10);
	//	list.display();
		list.addFirst(5);
		list.addLast(20);
		list.addLast(10);
		list.addLast(5);
		list.addLast(5);  

		//list.display();
		 
		/*System.out.println(list.getAt(0));
		System.out.println(list.getFirst());
		list.addAt(20, 1); 

		list.display(); 
		//System.out.println(list.getAt(1));
		System.out.println(list.removeFirst());
		
		list.addLast(40);
		list.display();
		System.out.println(list.removeAt(1)); */
		
		//list.reverseDataIteratively();
		//list.reversePointerIterative();		
		list.display(); 
		/*list.reversePointerrecursive();
		list.display();*/
		//list.displayReverse();
		//list.reverseDataRecursivly();
	    //list.fold();
		System.out.println(list.mid()); 
		//System.out.println(list.isPalindrome());//list.display();  

		
	} 

}

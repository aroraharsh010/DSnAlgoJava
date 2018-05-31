package BinaryTrees;

public class BSTClient {

	public static void main(String[] args) {

		int[] arr={12,25,37,50,62,75,87};
		BST bst=new BST(arr);
		//bst.display();
		/*System.out.println(bst.find(62)); 
		System.out.println(bst.find(67)); 
		System.out.println(bst.max()); 
		*//*bst.printAllInRange(22, 60);*/ 
		/*bst.replacenodeWithSum();*/
		//bst.addElement(20);
		bst.removeElement(12);
		bst.display();
	}

}

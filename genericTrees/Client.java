package genericTrees;

public class Client {
// 10 3 20 2 50 0 60 0 30 3 70 2 110 0 120 0 80 0 90 0 40 1 100 0
	// 1 3 2 2 5 0 6 1 40 0 3 3 7 2 11 0 12 0 8 0 90 0 40 1 100 0
	//10 3 20 0 30 0 40 0
	public static void main(String[] args) {
    // GenericTree gt=new GenericTree();
    // gt.display();  
     //System.out.println(gt.height());
     //System.out.println(gt.find(10));
     /*gt.mirror(); 
     gt.display(); */   
     //gt.preorderTraversal();
     //gt.preOTraversalIterative();
    // gt.postOrderTraversal();
    // gt.postOrderIterat();   
     //gt.multiSolver(30); 
     /*gt.levelOrderLinewise();
     gt.levelOrderZigzag();*/   
		GenericTree gt1=new GenericTree();
		//GenericTree gt2=new GenericTree();
		//System.out.println(gt1.isSymmetric());   
		gt1.KthSmallest(3);    
     
     
	}   
 
}

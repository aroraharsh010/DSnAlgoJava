package BinaryTrees;

import java.util.LinkedList;

public class Client {

	public static void main(String[] args) {

		int[] arr1={12,25,37,50,67,77,87};
		
		//int[] arr2={8,4,9,2,10,5,11,1,12,6,3,13,7,14};
		AVL bt=new AVL(arr1);
		
		bt.addElement(5);
		bt.addElement(11);
		bt.removeElement(67);
		bt.display(); 
		//bt.removeLeaves();
		//bt.printOnlyChild();
		//bt.display(); 
		//bt.roottoLeafPathFromTargetSum(150);
		//bt./*pathFr*/omRoot(62);
		/*System.out.println(bt.diametre());
		System.out.println(bt.diameter2()); */
        
		//bt.printKfar(12, 2);
		//bt.levelOrderDislay();
		//binaries(15);\
		//bt.preorderDisplayIterative();
	}
	private static class LevelPair{
		int num;
		String binary;
	}
	public static void binaries(int n){
		LinkedList<LevelPair> queue=new LinkedList<>();
		LevelPair root=new LevelPair();
		root.num=1;
		root.binary="1"; 
		queue.addLast(root);
		while(queue.size()>0){
			LevelPair node=queue.removeFirst();
			System.out.println(node.num+"-->"+node.binary);
			if(node.num==n){
				break;
			}
			LevelPair lp=new LevelPair();
			lp.num=2*node.num;
			lp.binary=node.binary+"0";
			queue.addLast(lp);
			LevelPair rp=new LevelPair();
			rp.num=2*node.num+1;
			rp.binary=node.binary+"1"; 
			queue.addLast(rp);
		}
	}
	
	

}

package segmentTrees;

public class Client {

	public static void main(String[] args) {

		int[] arr={17,11,-2,1,3};
		/*SegmentTree tree=new SegmentTree(arr);
		//tree.update(1, 3);
		tree.display();
		System.out.println(tree.query(1, 2));*/
		FenwickTree tree=new FenwickTree(arr);
		for(int i=0;i<tree.farr.length;i++){
			System.out.print(tree.farr[i]+" ");
		}
		System.out.println("\n"+tree.getSum(1, 2));
	}

}

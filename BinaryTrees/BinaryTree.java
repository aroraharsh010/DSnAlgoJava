package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private int size;
	private Node root;

	public int size() {
		return size;
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = constructPost(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	private Node constructPost(int[] post, int[] in, int psi, int pei, int isi, int iei) {
		if (isi > iei || psi > pei)
			return null;
		Node root1 = new Node();
		root1.data = post[pei];
		int vidx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == root1.data) {
				vidx = i;
				break;
			}
		}
		root1.right = constructPost(post, in, pei - vidx, pei - 1, vidx + 1, iei);
		root1.left = constructPost(post, in, psi, pei - vidx - 1, isi, vidx - 1);
		return root1;
	}

	private Node construct(int[] pre, int[] in, int psi, int pei, int isi, int iei) {
		if (isi > iei || psi > pei)
			return null;

		Node root1 = new Node();
		root1.data = pre[psi];
		int vidx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == root1.data) {
				vidx = i;
				break;
			}

		}
		root1.left = construct(pre, in, psi + 1, psi + vidx - isi, isi, vidx - 1);
		root1.right = construct(pre, in, psi + vidx - isi + 1, pei, vidx + 1, iei);
		return root1;

	}

	public BinaryTree() {
		this.root = new Node();
		root.left = new Node();
		root.right = new Node();
		root.left.left = new Node();
		root.left.right = new Node();
		root.right.left = new Node();
		root.right.right = new Node();
		root.left.right.left=new Node();
		root.data = 50;
		root.left.data = 25;
		root.left.left.data = 12;
		root.left.right.data = 51;
		root.left.right.left.data=37;
		root.right.data = 75;
		root.right.left.data = 62;
		root.right.right.data = 87;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null)
			return;
		String str = "";
		if (node.left == null)
			str += ". <= ";
		else
			str += node.left.data + " <= ";
		str += node.data + " => ";
		if (node.right == null)
			str += ".";
		else
			str += node.right.data;
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {

		if (node == null)
			return 0;
		int ls = size2(node.left);
		int rs = size2(node.right);
		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lchildmax = max(node.left);
		int rchildmax = max(node.right);
		return Math.max(lchildmax, Math.max(rchildmax, node.data));
	}

	public boolean find(int data) {
		return find(data, root);
	}

	private boolean find(int data, Node node) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		boolean resleft = find(data, node.left);
		if (resleft == true)
			return resleft;
		boolean resright = find(data, node.right);
		if (resright == true)
			return resright;
		return false;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		int lefth = height(node.left);
		int righth = height(node.right);
		return Math.max(lefth, righth) + 1;
	}

	public void removeLeaves() {
		removeLeavesSirMeth(null, root, false);
	}

	private void removeLeaves(Node node) {
		if (node == null)
			return;
		if (node.left != null && node.left.left == null && node.left.right == null) {
			node.left = null;
			return;
		}
		if (node.right != null && node.right.left == null && node.right.right == null) {
			node.right = null;
			return;
		}

		removeLeaves(node.left);
		removeLeaves(node.right);

	}

	private void removeLeavesSirMeth(Node parent, Node child, boolean ilc) {
		if (child == null)
			return;

		if (child.left == null && child.right == null) {
			if (parent == null)
				root = null;
			else {
				if (ilc == true)
					parent.left = null;
				else
					parent.right = null;
			}
		}

		removeLeavesSirMeth(child, child.left, true);
		removeLeavesSirMeth(child, child.right, false);
	}

	public void printOnlyChild() {
		printOnlyChild(root);
	}

	private void printOnlyChild(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right != null) {
			System.out.println(node.right.data);
		}
		if (node.right == null && node.left != null) {
			System.out.println(node.left.data);
		}
		printOnlyChild(node.left);
		printOnlyChild(node.right);

	}

	public void pathFromRoot(int data) {

		ArrayList<Integer> list = pathFromRoot(root, data);
		System.out.println(list);
	}

	private ArrayList<Integer> pathFromRoot(Node node, int data) {
		if (node == null)
			return new ArrayList<Integer>();
		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}

		ArrayList<Integer> leftList = pathFromRoot(node.left, data);
		ArrayList<Integer> rightList = pathFromRoot(node.right, data);
		if (leftList.size() != 0) {
			leftList.add(node.data);
			return leftList;
		} else if (rightList.size() != 0) {
			rightList.add(node.data);
			return rightList;
		}
		return new ArrayList<Integer>();

	}

	public void roottoLeafPathFromTargetSum(int tar) {

		roottoLeafPathFromTargetSum(root, tar, "", 0);
	}

	private void roottoLeafPathFromTargetSum(Node node, int tar, String psf, int sumsf) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			if (node.data + sumsf <= tar)
				System.out.println(psf + node.data + " ");

		}

		roottoLeafPathFromTargetSum(node.left, tar, psf + node.data + " ", sumsf + node.data);
		roottoLeafPathFromTargetSum(node.right, tar, psf + node.data + " ", sumsf + node.data);

	}

	public void Kdown(int data, int k) {
		Node node1 = findNode(root, data);
		Kdown(node1, data, k);
	}

	private void Kdown(Node node, int data, int k) {
		if (node == null)
			return;

		if (k <= 0) {
			System.out.print(node.data + " ");
			return;
		}

		Kdown(node.left, data, k - 1);
		Kdown(node.right, data, k - 1);

	}

	private Node findNode(Node node, int data) {
		if (node == null)
			return null;
		if (node.data == data)
			return node;
		Node l = findNode(node.left, data);
		if (l != null)
			return l;
		Node r = findNode(node.right, data);
		if (r != null)
			return r;
		return null;
	}

	public void printKfar(int data, int k) {

		printKfar(root, data, k);
	}

	private ArrayList<Node> printKfar(Node node, int data, int k) {
		if (node == null)
			return new ArrayList<Node>();
		if (node.data == data) {
			Kdown(node, data, k);
			ArrayList<Node> blist = new ArrayList<Node>();
			blist.add(node);
			return blist;
		}
		// left call
		ArrayList<Node> llist = printKfar(node.left, data, k);
		if (llist.size() > 0) {
			if (llist.size() == k)
				System.out.println(node.data);
			else
				Kdown(node.right, data, k - llist.size() - 1);
			llist.add(node);
			return llist;
		}
		ArrayList<Node> rlist = printKfar(node.right, data, k);
		if (rlist.size() > 0) {
			if (rlist.size() == k)
				System.out.println(node.data);
			else
				Kdown(node.left, data, k - rlist.size() - 1);
			rlist.add(node);
			return rlist;
		}
		return new ArrayList<Node>();

	}

	public void levelOrderDislay() {
		LinkedList<Node> list = new LinkedList<>();
		list.addLast(root);
		while (list.size() != 0) {
			Node temp = list.removeFirst();
			System.out.println(temp.data);
			if (temp.left != null)
				list.addLast(temp.left);
			if (temp.right != null)
				list.add(temp.right);
		}

	}

	private class TIhelper {
		Node node;
		boolean selfdone;
		boolean hcLeft;
		boolean hcright;

	}

	public void preorderDisplayIterative() {
		LinkedList<TIhelper> stack = new LinkedList<>();
		TIhelper roothelper = new TIhelper();
		roothelper.node = this.root;
		roothelper.selfdone = false;
		roothelper.hcLeft = false;
		roothelper.hcright = false;
		stack.addFirst(roothelper);
		while (stack.size() > 0) {
			TIhelper tos = stack.getFirst();
			if (tos.selfdone == false) {
				System.out.print(tos.node.data + " ");
				tos.selfdone = true;

			} else if (tos.hcLeft == false) {
				TIhelper lefthelper = new TIhelper();
				if (tos.node.left != null) {
					lefthelper.node = tos.node.left;
					stack.addFirst(lefthelper);

				}
				tos.hcLeft = true;

			} else if (tos.hcright == false) {
				TIhelper righthelper = new TIhelper();
				if (tos.node.right != null) {
					righthelper.node = tos.node.right;
					stack.addFirst(righthelper);

				}
				tos.hcright = true;
			}

			else
				stack.removeFirst();

		}
		System.out.println();
	}

	public int diametre() {
		return diametre(root);
	}
	// diameter is defined as max edge distance b/w any 2 nodes

	private int diametre(Node node) {
		if (node == null)
			return 0;

		int lh = height(node.left);//
		int rh = height(node.right);
		int f1 = lh + rh + 2;
		int f2 = diametre(node.left);
		int f3 = diametre(node.right);
		return Math.max(f1, Math.max(f2, f3));

	}// complexity o(n^2)

	private class diaPair {
		int height;
		int diameter;
	}

	public int diameter2() {
		diaPair rp = diameter2(root);
		return rp.diameter;

	}

	private diaPair diameter2(Node node) {// this is a better method O(n)
		if (node == null) {
			diaPair bp = new diaPair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}
		diaPair lp = diameter2(node.left);
		diaPair rp = diameter2(node.right);
		int f1 = lp.height + rp.height + 2;
		int f2 = lp.diameter;
		int f3 = rp.diameter;
		diaPair mp = new diaPair();
		mp.diameter = Math.max(f1, Math.max(f2, f3));
		mp.height = Math.max(lp.height, rp.height) + 1;
		return mp;

	}

	public boolean isBalanced() {
		return isBalanced(root).flag;
	}

	private class isBalancePair {
		boolean flag;
		int height;
	}// this code could have been written just like diametre1 but complexity
		// very high.

	private isBalancePair isBalanced(Node node) {
		if (node == null) {
			isBalancePair bp = new isBalancePair();
			bp.flag = true;
			bp.height = -1;
			return bp;
		}

		isBalancePair leftb = isBalanced(node.left);
		isBalancePair rightb = isBalanced(node.right);
		isBalancePair mp = new isBalancePair();
		if (Math.abs(leftb.height - rightb.height) > 1) {
			mp.flag = false;
			return mp;
		} else
			mp.flag = true;
		mp.height = Math.max(leftb.height, rightb.height) + 1;
		return mp;
	}

	public boolean isBst() {

		bstPair rp = isBst(root);
		return rp.isBst;
	}

	private class bstPair {
		int max;
		int min;
		boolean isBst;
		Node lBSTroot;
		int lBSTsize;

	}

	private bstPair isBst(Node node) {

		if (node == null) {
			bstPair bp = new bstPair();
			bp.isBst = true;
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			return bp;
		}
		bstPair leftp = isBst(node.left);
		bstPair rightp = isBst(node.right);
		bstPair mp = new bstPair();
		if (leftp.isBst && rightp.isBst && node.data > leftp.max && node.data < rightp.min) {
			mp.isBst = true;
		}
		mp.max = Math.max(node.data, Math.max(rightp.max, leftp.max));
		mp.min = Math.min(node.data, Math.min(leftp.min, rightp.min));
		return mp;

	}

	public void largestBst() {
		bstPair rp = LBst(root);
		System.out.println(rp.isBst);
		System.out.println(rp.lBSTroot.data);
		System.out.println(rp.lBSTsize);
	}

	private bstPair LBst(Node node) {

		if (node == null) {
			bstPair bp = new bstPair();
			bp.isBst = true;
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.lBSTroot = null;
			bp.lBSTsize = 0;
			return bp;
		}
		bstPair leftp = LBst(node.left);
		bstPair rightp = LBst(node.right);
		bstPair mp = new bstPair();
		if (leftp.isBst && rightp.isBst && node.data > leftp.max && node.data < rightp.min) {
			mp.isBst = true;
		}
		mp.max = Math.max(node.data, Math.max(rightp.max, leftp.max));
		mp.min = Math.min(node.data, Math.min(leftp.min, rightp.min));
		if (mp.isBst == true) {
			mp.lBSTroot = node;
			mp.lBSTsize = leftp.lBSTsize + rightp.lBSTsize + 1;

		} else {
			if (leftp.lBSTsize > rightp.lBSTsize) {
				mp.lBSTroot = leftp.lBSTroot;
				mp.lBSTsize = leftp.lBSTsize;
			} else {
				mp.lBSTroot = rightp.lBSTroot;
				mp.lBSTsize = rightp.lBSTsize;
			}
		}
		return mp;

	}//Inorder of bst is always increasing order
	

}

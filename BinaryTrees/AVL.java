package BinaryTrees;

public class AVL {
	private class Node {
		int data;
		Node left;
		Node right;
		int height;
		int bf;
	}

	private int size;
	private Node root;

	public int size() {
		return this.size;
	}

	public AVL(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int si, int ei) {
		if (si > ei)
			return null;
		int mid = (si + ei) / 2;
		Node node = new Node();
		this.size++;

		node.data = sa[mid];

		node.left = construct(sa, si, mid - 1);
		node.right = construct(sa, mid + 1, ei);
		node.height = height(node);
		node.bf = balanceFactor(node);
		return node;

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null)
			return false;
		boolean f = false;
		if (data < node.data)
			f = find(node.left, data);
		else if (data > node.data)
			f = find(node.right, data);
		else if (data == node.data)
			return true;
		return f;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null)
			return node.data;
		else
			return max(node.right);
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
		str += node.data + "[h:" + node.height + "]" + "bf:" + node.bf + " => ";
		if (node.right == null)
			str += ".";
		else
			str += node.right.data;
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public void printAllInRange(int lo, int hi) {

		printAllInRange(root, lo, hi);
	}

	private void printAllInRange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data > lo && node.data < hi) {
			System.out.print(node.data + " ");
			printAllInRange(node.left, lo, hi);
			printAllInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printAllInRange(node.left, lo, hi);
		} else
			printAllInRange(node.right, lo, hi);

	}

	public void replacenodeWithSum() {
		sum = 0;
		replacenodeWithSum(root);
	}

	private static int sum = 0;

	private void replacenodeWithSum(Node node) {
		if (node == null)
			return;
		replacenodeWithSum(node.right);
		int data = node.data;
		node.data = sum;
		sum += data;
		replacenodeWithSum(node.left);
		return;
	}

	// To find pairs of node that reach a target sum
	// in bt get to a node and then call find function on its complement
	// another approach go along euler path and fill arrayList
	// then find complement in this list.(meet in middle) O(nlog(n)) for bt and
	// On for
	// Another method
	// use hashmap
	// add all elements in map
	// visit every element again and cheeck complement in hashmap
	// complexity for both bt and bst here is On
	public void addElement(int data) {
		this.root = addElement(root, data);
	}

	private Node addElement(Node node, int data) {
		if (node == null) {
			node = new Node();
			node.data = data;
			this.size++;
			return node;
		}
		if (node.data > data)
			node.left = addElement(node.left, data);
		else if (node.data < data)
			node.right = addElement(node.right, data);

		node.height = height(node);
		node.bf = balanceFactor(node);

		if (node.bf > 1) {
			int lbf = node.left.bf;
			if (lbf > 0) {// ll case
				node = rightRotation(node);

			} else {// lr case
				node.left = leftRotation(node.left);
				node = rightRotation(node);
			}
		} else if (node.bf < -1) {
			int rbf = node.right.bf;
			if (rbf < 0) {// rr case
				node = leftRotation(node); 

			} else {// rl case
				node.right = rightRotation(node.right);
				node = leftRotation(node);
			}

		}

		return node;
	}

	private Node leftRotation(Node z) {
		Node y = z.right;
		Node t2 = y.left;

		z.right = t2;
		y.left = z;

		z.height = height(z);
		z.bf = balanceFactor(z);
		y.height = height(y);
		y.bf = balanceFactor(y);
		return y;
	}

	private Node rightRotation(Node z) {

		Node y = z.left;
		Node t3 = y.right;
		z.left = t3;
		y.right = z;
		z.height = height(z);
		z.bf = balanceFactor(z);
		y.height = height(y);
		y.bf = balanceFactor(y);

		return y;
	}

	public void removeElement(int data) {
		this.root = removeElement(root, data);
	}

	private Node removeElement(Node node, int data) {
		if (node.data > data)
			node.left = removeElement(node.left, data);
		else if (node.data < data)
			node.right = removeElement(node.right, data);

		else {
			if (node.left == null || node.right == null) {
				node = node.left != null ? node.left : node.right;
			} else {
				int lmax = this.max(node.left);
				node.data = lmax;
				node.left = this.removeElement(node.left, lmax);
			}
		}
		if(node==null)
			return null; 
		
		node.height = height(node);
		node.bf = balanceFactor(node);

		if (node.bf > 1) {
			int lbf = node.left.bf;
			if (lbf > 0) {// ll case
				node = rightRotation(node);

			} else {// lr case
				node.left = leftRotation(node.left);
				node = rightRotation(node);
			}
		} else if (node.bf < -1) {
			int rbf = node.right.bf;
			if (rbf < 0) {// rr case
				node = leftRotation(node); 

			} else {// rl case
				node.right = rightRotation(node.right);
				node = leftRotation(node);
			}

		}

		return node;
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(node.left == null ? -1 : node.left.height, node.right == null ? -1 : node.right.height);
		}
	}

	private int balanceFactor(Node node) {
		int lh = height(node.left);
		int rh = height(node.right);
		return lh - rh;
	}
}

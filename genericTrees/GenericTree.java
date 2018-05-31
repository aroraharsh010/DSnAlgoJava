package genericTrees;

import java.util.*;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	int size;
	Node root;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public GenericTree() {
		root = takeInput(null, 0, new Scanner(System.in));
	}

	private Node takeInput(Node parent, int ithchild, Scanner scn) {
		if (parent == null)
			System.out.println("Enter data for root");
		else
			System.out.println("Enter data for " + ithchild + " of " + parent.data);
		int data = scn.nextInt();
		Node child = new Node();
		child.data = data;
		this.size++;
		System.out.println("Enter no. of children for " + child.data);
		int numgc = scn.nextInt();
		for (int i = 0; i < numgc; i++) {
			Node gc = takeInput(child, i, scn);
			child.children.add(gc);
		}
		return child;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String str = node.data + "-->";
		for (Node child : node.children) {
			str += child.data + " ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size2() {
		return size2(root);

	}

	private int size2(Node node) {
		int size = 0;
		for (Node child : node.children) {
			int csize = size2(child);
			size += csize;
		}
		size += 1;
		return size;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int cmax = max(child);
			if (cmax > max)
				max = cmax;
		}
		return max;
	}

	public int height() {
		int c = height(root);
		return c;
	}

	private int height(Node node) {
		int mdepth = -1;
		for (Node child : node.children) {
			int depth = height(child);
			if (depth > mdepth)
				mdepth = depth;
		}
		return mdepth + 1;
	}

	public boolean find(int val) {
		return find(val, root);
	}

	private boolean find(int data, Node node) {
		if (node.data == data)
			return true;
		for (Node child : node.children) {
			boolean f = find(data, child);
			if (f == true)
				return f;
		}
		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);

		}
		ArrayList<Node> list = node.children;
		int left = 0, right = list.size() - 1;
		while (left < right) {
			Node t = list.get(left);
			list.set(left, list.get(right));
			list.set(right, t);
			left++;
			right--;
		}

	}

	public void preorderTraversal() {
		preorderTraversal(root);
		System.out.println(".");
	}

	private void preorderTraversal(Node node) {
		System.out.println(node.data + " ");
		for (Node child : node.children) {
			preorderTraversal(child);
		}
	}

	public void postOrderTraversal() {
		postorderTraversal(root);
		System.out.println(".");
	}

	private void postorderTraversal(Node node) {
		for (Node child : node.children) {
			postorderTraversal(child);
		}
		System.out.println(node.data + " ");
	}

	private class TIhelper {
		Node node;
		boolean selfdone;
		int nocServ;

	}

	public void preOTraversalIterative() {

		LinkedList<TIhelper> stack = new LinkedList<>();
		TIhelper roothelper = new TIhelper();
		roothelper.node = root;
		roothelper.selfdone = false;
		roothelper.nocServ = 0;
		stack.addFirst(roothelper);
		while (stack.size() > 0) {
			TIhelper tos = stack.getFirst();
			if (tos.selfdone == false) {
				System.out.print(tos.node.data + " ");
				tos.selfdone = true;
			} else if (tos.nocServ < tos.node.children.size()) {
				TIhelper childhelper = new TIhelper();
				childhelper.node = tos.node.children.get(tos.nocServ);
				stack.addFirst(childhelper);
				tos.nocServ += 1;

			} else { 
				stack.removeFirst();
			}

		}
		System.out.println();

	}

	public void postOrderIterat() {
		LinkedList<TIhelper> stack = new LinkedList<>();
		TIhelper roothelper = new TIhelper();
		roothelper.node = root;
		roothelper.selfdone = false;
		roothelper.nocServ = 0;
		stack.addFirst(roothelper);
		while (stack.size() > 0) {
			TIhelper tos = stack.getFirst();

			if (tos.nocServ < tos.node.children.size()) {
				TIhelper childhelper = new TIhelper();
				childhelper.node = tos.node.children.get(tos.nocServ);
				stack.addFirst(childhelper);
				tos.nocServ += 1;

			} else if (tos.selfdone == false) {
				System.out.print(tos.node.data + " ");
				tos.selfdone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	private class HeapMover {
		int size1 = 0;
		boolean find = false;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int height = -1;
		Node pred = null;
		Node succ = null;
		Node justLarger = null;
		Node justSmaller = null;

	}

	public void multiSolver(int data) {
		HeapMover mover = new HeapMover();

		multiSolver(root, mover, 0, data);
		System.out.println("Size:" + mover.size1);
		System.out.println("find:" + mover.find);
		System.out.println("height: " + mover.height);
		System.out.println("max: " + mover.max);
		System.out.println("min: " + mover.min);
		if (mover.succ == null)
			System.out.println("succ not found");
		else
			System.out.println("succ is " + mover.succ.data);
		if (mover.pred == null)
			System.out.println("pred not found");
		else
			System.out.println("pred is " + mover.pred.data);
		if (mover.justLarger == null)
			System.out.println("Just larger not found");
		else
			System.out.println("Just larger = " + mover.justLarger.data);
		if (mover.justSmaller == null)
			System.out.println("Just smaller not found");
		else
			System.out.println("Just Smaller =" + mover.justSmaller.data);
	}

	private void multiSolver(Node node, HeapMover mover, int depth, int data) {

		mover.size1 += 1;
		mover.height = Math.max(depth, mover.height);
		mover.max = Math.max(mover.max, node.data);
		if (node.data > data && mover.justLarger == null) {
			mover.justLarger = node;
		} else if (node.data < data && mover.justSmaller == null) {
			mover.justSmaller = node;
		}

		else if (node.data < data) {
			if (node.data > mover.justSmaller.data)
				mover.justSmaller = node;
		}

		else if (node.data > data) {
			if (node.data < mover.justLarger.data)
				mover.justLarger = node;
		}

		if (mover.find == true && mover.succ == null)
			mover.succ = node;
		if (node.data == data)
			mover.find = true;
		if (mover.find == false)
			mover.pred = node;
		mover.min = Math.min(mover.min, node.data);
		for (Node child : node.children) {

			multiSolver(child, mover, depth + 1, data);

		}

	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.size() != 0) {
			System.out.print(queue.getFirst().data + " ");
			Node temp = queue.removeFirst();
			for (Node child : temp.children) {
				queue.addLast(child);
			}
		}
	}

	public void levelOrderLinewise() {
		LinkedList<Node> cl = new LinkedList<>();
		cl.add(root);
		LinkedList<Node> nl = new LinkedList<>();
		while (cl.size() != 0 || nl.size() != 0) {
			Node temp = cl.getFirst();
			System.out.print(temp.data + " ");
			cl.removeFirst();
			for (Node child : temp.children) {
				nl.addLast(child);
			}
			if (cl.size() == 0) {
				System.out.println();
				cl = nl;
				nl = new LinkedList<>();
			}
		}

	}

	public void levelOrderZigzag() {
		boolean ltr = true;
		LinkedList<Node> cl = new LinkedList<>();
		cl.addFirst(root);
		LinkedList<Node> nl = new LinkedList<>();
		while (cl.size() != 0 || nl.size() != 0) {

			Node temp = cl.getFirst();
			System.out.print(temp.data + " ");
			cl.removeFirst();
			if (ltr == true) {
				for (Node child : temp.children) {
					nl.addFirst(child);
				}
			} else {
				for (int i = temp.children.size() - 1; i >= 0; i--) {
					nl.addFirst(temp.children.get(i));
				}
			}
			if (cl.size() == 0) {
				System.out.println();
				cl = nl;
				nl = new LinkedList<>();
				ltr = !ltr;
			}
		}
	}

	public void removeLeaves() {

		removeLeaves(root);
	}

	private void removeLeaves(Node node) {

		for (int i = node.children.size() - 1; i >= 0; i--)
			if (node.children.get(i).children.size() == 0) {
				node.children.remove(i);
			}
		for (Node child : node.children) {
			removeLeaves(child);
		}

	}

	public void Flatten() {
		Flatten(root);
	}

	private void Flatten(Node node) {

		for (Node child : node.children) {
			Flatten(child);

		}
	}

	public void linearise() {
		linearise(root);
	}

	private void linearise(Node node) {

		for (Node child : node.children) {
			linearise(child);
		}
		for (int i = node.children.size() - 1; i > 0; i--) {
			Node last = node.children.remove(i);
			Node secondLast = node.children.get(i - 1);
			Node SecondLastKiTail = getTail(secondLast);
			SecondLastKiTail.children.add(last);
		}

	}

	private Node getTail(Node node) {
		if (node.children.size() == 0)
			return node;
		else
			return getTail(node.children.get(0));
	}

	public void linearise2() {
		linearise2(root);
	}

	private Node linearise2(Node node) {

		if (node.children.size() == 0)
			return node;
		Node lastChild = node.children.get(node.children.size() - 1);
		Node ovLastTail = linearise2(lastChild);
		for (int i = node.children.size() - 2; i >= 0; i--) {
			Node child = node.children.get(i);
			Node childtail = linearise2(child);
			Node nextChild = node.children.remove(i + 1);
			childtail.children.add(nextChild);
		}
		return ovLastTail;
	}

	public void flatten() {
		flatten(root);
	}

	private void flatten(Node node) {
		for (Node child : node.children) {
			flatten(child);
		}
		ArrayList<Node> list = new ArrayList<>();
		for (Node child : node.children) {
			list.add(child);
			for (Node gc : child.children) {
				list.add(gc);
			}
			node.children = list;
			child.children = new ArrayList<>();

		}
	}

	public boolean isIsomorphic(GenericTree other) {
		if (other.size != this.size)
			return false;
		return isIsomorphic(this.root, other.root);
	}

	private boolean isIsomorphic(Node g1node, Node g2node) {
		boolean res = true;
		if (g1node.children.size() != g2node.children.size()) {
			res = false;
			return res;
		}
		for (int i = 0; i < g1node.children.size(); i++) {
			res = isIsomorphic(g1node.children.get(i), g2node.children.get(i));

		}
		return res;
	}

	public boolean isMirrorImage(GenericTree other) {
		return isMirrorImage(this.root, other.root);
	}

	private boolean isMirrorImage(Node tnode, Node onode) {
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}
		for (int i = 0; i < tnode.children.size(); i++) {
			Node tchild = tnode.children.get(i);
			Node ochild = onode.children.get(onode.children.size() - 1 - i);
			boolean res = isMirrorImage(tchild, ochild);
			if (res == false)
				return res;
		}
		return true;
	}

	public boolean isSymmetric() {
		return isMirrorImage(this.root, this.root);
	}

	public void KthLargest(int k) {
		int ldata = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {

			ldata = KthLargestP(ldata);
		}
		System.out.println(ldata);
	}

	private int KthLargestP(int data) {
		HeapMover mover = new HeapMover();
		multiSolver(root, mover, 0, data);
		if (mover.justSmaller == null)
			return -1;
		else
			return mover.justSmaller.data;  
	}

	public void KthSmallest(int k) {
		int sdata = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			sdata = KthSmallestP(sdata);
		}
		System.out.println(sdata);
	}

	private int KthSmallestP(int data) {

		HeapMover mover = new HeapMover();

		multiSolver(root, mover, 0, data);
		if (mover.justLarger == null)
			return -1;
		else
			return mover.justLarger.data;
	}

}

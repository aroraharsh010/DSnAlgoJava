package adjacencyMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {
	protected HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int numVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (vces.containsKey(vname) == false)
			vces.put(vname, new HashMap<String, Integer>());
	}

	public int numEdges() {//
		int count = 0;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String name : vnames) {
			count += vces.get(name).size();
		}
		return count / 2;

	}

	public boolean containsEdge(String v1name, String v2name) {
		if (vces.containsKey(v1name) && vces.containsKey(v2name))
			return vces.get(v1name).containsKey(v2name);
		else
			return false;
	}

	public void addEdge(String v1name, String v2name, int weight) {//
		if (vces.containsKey(v1name) && vces.containsKey(v2name) && vces.get(v1name).containsKey(v2name) != true) {
			vces.get(v1name).put(v2name, weight);
			vces.get(v2name).put(v1name, weight);
		}
	}

	public void removeEdge(String v1name, String v2name) {//
		if (vces.containsKey(v1name) && vces.containsKey(v2name) && vces.get(v1name).containsKey(v2name) == true) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}

	public void display() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String name : vnames) {
			System.out.println(name + "=>" + vces.get(name));
		}
	}

	public void removeVertex(String vname) {//
		if (vces.containsKey(vname) == false)
			return;
		ArrayList<String> nbrnames = new ArrayList<>(vces.get(vname).keySet());
		for (String name : nbrnames) {
			if (vces.get(name).containsKey(vname) == true)
				vces.get(name).remove(vname);
		}
		vces.remove(vname);
	}

	public boolean hasPath(String v1name, String v2name) {
		HashMap<String, Boolean> str = new HashMap<>();
		return hasPath(v1name, v2name, str);
	}

	public void printPath(String v1name, String v2name) {
		HashMap<String, Boolean> map = new HashMap<>();
		map.put(v1name, true);
		printPath(v1name, v2name, map, v1name);
	}

	private boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> str) {

		if (v1name.equals(v2name))
			return true;

		if (vces.containsKey(v1name) == false)
			return false;

		boolean hasP = false;
		ArrayList<String> nbrs = new ArrayList<>(vces.get(v1name).keySet());
		for (String name : nbrs) {

			if (str.containsKey(name) == false) {
				str.put(name, true);
				hasP = hasPath(name, v2name, str);
				// str.put(name, false);
			}
			if (hasP == true)
				return true;
		}
		return false;
	}

	private void printPath(String v1name, String v2name, HashMap<String, Boolean> str, String psf) {

		if (v1name.equals(v2name)) {
			System.out.println(psf);
			return;
		}

		if (vces.containsKey(v1name) == false)
			return;

		// boolean hasP = false;
		ArrayList<String> nbrs = new ArrayList<>(vces.get(v1name).keySet());
		for (String name : nbrs) {

			if (str.containsKey(name) == false) {
				str.put(name, true);
				printPath(name, v2name, str, psf + " ->" + name);
				str.remove(name);
			}

		}

	}

	public void printLeastCostPath(String v1name, String v2name) {
		HashMap<String, Boolean> map = new HashMap<>();
		map.put(v1name, true);
		HeapMover mover = new HeapMover();
		printleastCostPath(v1name, v2name, map, 0, v1name, mover);
		System.out.println(mover.minWt + " " + mover.sp);
		System.out.println(mover.maxWt + " " + mover.lp);
	}

	private class HeapMover {
		int minWt = Integer.MAX_VALUE;
		int maxWt = Integer.MIN_VALUE;
		String lp = "";
		String sp = "";
	}

	private void printleastCostPath(String v1name, String v2name, HashMap<String, Boolean> str, int cost, String psf,
			HeapMover mover) {

		if (v1name.equals(v2name)) {
			if (cost < mover.minWt) {
				mover.minWt = cost;
				mover.sp = psf;

			}
			if (cost > mover.maxWt) {
				mover.maxWt = cost;
				mover.lp = psf;
			}
			return;
		}

		if (vces.containsKey(v1name) == false)
			return;

		ArrayList<String> nbrs = new ArrayList<>(vces.get(v1name).keySet());
		for (String name : nbrs) {

			if (str.containsKey(name) == false) {
				str.put(name, true);
				printleastCostPath(name, v2name, str, cost + vces.get(v1name).get(name), psf + " ->" + name, mover);
				str.remove(name);
			}

		}

	}

	public void justLargerPath(String sv, String dv, int mindist) {
		HashMap<String, Boolean> map = new HashMap<>();
		map.put(sv, true);
		HeapMover newmover = new HeapMover();
		printJustLargerCostPath(sv, dv, map, 0, sv, newmover, mindist);
		System.out.println(newmover.minWt + " " + newmover.sp);
		// System.out.println(mover.maxWt + " " + mover.lp);
	}

	private void printJustLargerCostPath(String v1name, String v2name, HashMap<String, Boolean> str, int cost,
			String psf, HeapMover mover, int minDist) {

		if (v1name.equals(v2name)) {
			if (cost > minDist) {
				if (cost < mover.minWt) {
					mover.minWt = cost;
					mover.sp = psf;
				}
			}
			if (cost < minDist) {
				if (cost > mover.maxWt) {
					mover.maxWt = cost;
					mover.lp = psf;
				}
			}
			return;
		}

		if (vces.containsKey(v1name) == false)
			return;

		ArrayList<String> nbrs = new ArrayList<>(vces.get(v1name).keySet());
		for (String name : nbrs) {

			if (str.containsKey(name) == false) {
				str.put(name, true);
				printJustLargerCostPath(name, v2name, str, cost + vces.get(v1name).get(name), psf + " ->" + name, mover,
						minDist);
				str.remove(name);
			}

		}

	}

	private class KLargerPair implements Comparable<KLargerPair> {
		int dsf;
		String psf;

		public int compareTo(KLargerPair o) {

			return this.dsf - o.dsf;
		}
	}

	public void kthLargestPath(String sv, String dv, int k) {
		PriorityQueue<KLargerPair> pq = new PriorityQueue<>();
		HashMap<String, Boolean> map = new HashMap<>();
		map.put(sv, true);
		KthLargestPath(sv, dv, map, 0, sv, pq, k);
		System.out.println(pq.peek().psf + "@ " + pq.peek().dsf);

	}

	private void KthLargestPath(String v1name, String v2name, HashMap<String, Boolean> str, int cost, String psf,
			PriorityQueue<KLargerPair> pq, int k) {

		if (v1name.equals(v2name)) {
			KLargerPair pair = new KLargerPair();
			pair.dsf = cost;
			pair.psf = psf;
			if (pq.size() < k) {

				pq.add(pair);
			} else {
				if (pq.peek().dsf < cost) {
					pq.remove();
					pq.add(pair);
				}

			}
			return;
		}

		if (vces.containsKey(v1name) == false)
			return;

		ArrayList<String> nbrs = new ArrayList<>(vces.get(v1name).keySet());
		for (String name : nbrs) {

			if (str.containsKey(name) == false) {
				str.put(name, true);
				KthLargestPath(name, v2name, str, cost + vces.get(v1name).get(name), psf + " ->" + name, pq, k);
				str.remove(name);
			}

		}

	}

	private class Pair { 
		String vname;
		String psf;
		String color; 
	}

	public boolean bfs(String sv, String dv) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, String> map = new HashMap<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		queue.add(rootPair);
		while (queue.size() != 0) {
			// remove the first pair
			Pair removedPair = queue.removeFirst();
			map.put(removedPair.vname, removedPair.psf);
			System.out.println(removedPair.vname + "via" + removedPair.psf);
			if (removedPair.vname.equals(dv)) {
				return true;
			}
			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) {
				if (map.containsKey(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					queue.addLast(np);
				}
			}

		}

		return false;
	}

	public boolean dfs(String sv, String dv) {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, String> map = new HashMap<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		stack.addFirst(rootPair);
		while (stack.size() != 0) {
			// remove the first pair
			Pair removedPair = stack.removeFirst();
			map.put(removedPair.vname, removedPair.psf);
			System.out.println(removedPair.vname + " via " + removedPair.psf);
			if (removedPair.vname.equals(dv)) {
				return true;
			}
			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) {
				if (map.containsKey(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					stack.addFirst(np);
				}
			}

		}

		return false;
	}

	public void bft() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();
		for (String name : vnames) {

			if (visited.contains(name) == false) {
				bftComponent(name, visited);
			}
		}
	}

	private void bftComponent(String sv, HashSet<String> visited) {
		LinkedList<Pair> queue = new LinkedList<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		queue.add(rootPair);
		while (queue.size() != 0) {
			// remove the first pair
			Pair removedPair = queue.removeFirst();
			visited.add(removedPair.vname);
			System.out.println(removedPair.vname + " via " + removedPair.psf);

			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) {
				if (visited.contains(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					queue.addLast(np);
				}
			}

		}
	}

	public void dft() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();
		for (String name : vnames) {
			if (visited.contains(name) == false)
				dftComponent(name, visited);
		}
	}

	private void dftComponent(String sv, HashSet<String> visited) {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		stack.add(rootPair);
		while (stack.size() != 0) {
			// remove the first pair
			Pair removedPair = stack.removeFirst();

			visited.add(removedPair.vname);
			System.out.println(removedPair.vname + " via " + removedPair.psf);

			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) {
				if (visited.contains(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					stack.addFirst(np);
				}
			}

		}
	}

	//%$%%
	public boolean isConnected() {
		int counter = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashSet<String> visited = new HashSet<>();
		for (String name : vnames) {

			if (visited.contains(name) == false) {
				counter++;// for isConnected function
				bftComponent(name, visited);
			}
		}
		if (counter >= 2) {
			return false;
		} else
			return true;

	}

	public boolean isCyclic() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String name : vnames) {

			if (visited.contains(name) == false) {

				return isdftComponentForCycle(name, visited);
			}
		}
		return false;
	}

	private boolean isdftComponentForCycle(String sv, HashSet<String> visited) {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		stack.add(rootPair);
		while (stack.size() != 0) {
			// remove the first pair
			Pair removedPair = stack.removeFirst();
			if (visited.contains(removedPair.vname))
				return true;
			visited.add(removedPair.vname);
			// System.out.println(removedPair.vname + " via " +
			// removedPair.psf);

			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) {
				if (visited.contains(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					stack.addFirst(np);
				}
			}

		}
		return false;
	}

	public ArrayList<String> gcc() {
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String name : vnames) {
			if (!visited.contains(name))
				list.add(dftComponentArraylist(name, visited));

		}

		return list;
	}

	private String dftComponentArraylist(String sv, HashSet<String> visited) {
		String psf = "";
		LinkedList<Pair> stack = new LinkedList<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		stack.add(rootPair);
		while (stack.size() != 0) {
			// remove the first pair
			Pair removedPair = stack.removeFirst();
			if (!visited.contains(removedPair.vname))
				psf += removedPair.vname;
			visited.add(removedPair.vname);

			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) {
				if (visited.contains(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					stack.addFirst(np);
				}
			}

		}
		return psf;
	}

	public boolean isBiPartite(){
		boolean f=false;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		HashMap<String,String> visited = new HashMap<>();
		for (String name : vnames) {

			if (visited.containsKey(name) == false) {
				
				f=dftComponentBiPartite(name, visited);
				if(f==false)
					return false;
			}
		}
		return f; 
	}
	
	private boolean dftComponentBiPartite(String sv, HashMap<String,String> visited) {
		
		LinkedList<Pair> stack = new LinkedList<>();
		Pair rootPair = new Pair();
		rootPair.vname = sv;
		rootPair.psf = sv;
		rootPair.color="red";
		stack.add(rootPair);
		while (stack.size() != 0) {
			// remove the first pair
			Pair removedPair = stack.removeFirst();
			String color=removedPair.color;
			if(visited.containsKey(removedPair.vname))
			{
				String s=visited.get(removedPair.vname);
				if(!s.equals(removedPair.color))
					return false;
			}  
			visited.put(removedPair.vname,color);


			ArrayList<String> nbrs = new ArrayList<>(vces.get(removedPair.vname).keySet());
			for (String nbr : nbrs) { 
				if (visited.containsKey(nbr) == false) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = removedPair.psf + nbr;
					if(removedPair.color.equals("red"))
						np.color="green";
					else
						np.color="red";
					stack.addFirst(np);
				} 
			}
		}
		return true;
	}
	
	
	
	
	
	
	
}
 
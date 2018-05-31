package adjacencyMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TopologicalSort {
	static HashMap<String, HashMap<String, Integer>> dag = new HashMap<>();

	public static void main(String[] args) {
		// topological sort is a permutation of vertices such that start point
		// id=s
		// before and end point is after in the order.

		dag.put("A", new HashMap<>());
		dag.put("B", new HashMap<>());
		dag.put("C", new HashMap<>());
		dag.put("D", new HashMap<>());
		dag.put("E", new HashMap<>());
		dag.put("F", new HashMap<>());

		dag.get("A").put("C", 0);
		dag.get("A").put("F", 0);
		dag.get("B").put("E", 0);
		dag.get("B").put("F", 0);
		dag.get("C").put("D", 0);
		dag.get("D").put("E", 0);

		ArrayList<String> vces = new ArrayList<>(dag.keySet());
		HashSet<String> visited = new HashSet<>();
		

		for (String vname : vces) {
			ArrayList<String> psf = new ArrayList<>();
			if (!visited.contains(vname)) {
				ArrayList<String> tcomp = new ArrayList<>();
				topologicalSort(vname, visited, psf);
			}

		}

	}

	public static void topologicalSort(String src, HashSet<String> visited, ArrayList<String> psf) {

		if (visited.contains(src))
			return;

		visited.add(src);
		for (String nbr : dag.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				psf.add(nbr);
				topologicalSort(nbr, visited, psf);
			}
		}
		psf.add(0, src);

	}

}

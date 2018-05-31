package adjacencyMap;

import java.util.ArrayList;

public class DirectedGraph extends Graph {
	@Override
	public void addEdge(String v1name, String v2name, int weight) {
		if (vces.containsKey(v1name) && vces.containsKey(v2name) && vces.get(v1name).containsKey(v2name) != true) {
			vces.get(v1name).put(v2name, weight);
		}
	}

	@Override
	public void removeEdge(String v1name, String v2name) {
		if (vces.containsKey(v1name) && vces.containsKey(v2name) && vces.get(v1name).containsKey(v2name) == true) {
			vces.get(v1name).remove(v2name);
		}
	}

	@Override
	public int numEdges() {
		int count = 0;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String name : vnames) {
			count += vces.get(name).size();
		}
		return count;
	}

	@Override
	public void removeVertex(String vname) {
		if (vces.containsKey(vname) == false)
			return;
		ArrayList<String> nbrnames = new ArrayList<>(vces.keySet());
		for (String name : nbrnames) {
			if (vces.get(name).containsKey(vname) == true)
				vces.get(name).remove(vname);
		}
		vces.remove(vname);

	}

}

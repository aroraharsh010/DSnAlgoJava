package adjacencyMap;

import java.util.HashMap;

public class djikstraAlgo {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

		graph.put("A", new HashMap<>());
		graph.put("B", new HashMap<>());
		graph.put("C", new HashMap<>());
		graph.put("D", new HashMap<>());
		graph.put("E", new HashMap<>());
		graph.put("F", new HashMap<>());
		graph.put("G", new HashMap<>());

		graph.get("A").put("B", 10);
		graph.get("B").put("A", 10);

		graph.get("A").put("D", 40);
		graph.get("D").put("A", 40);

		graph.get("C").put("B", 10);
		graph.get("B").put("C", 10);

		graph.get("C").put("D", 10);
		graph.get("D").put("C", 10);

		graph.get("D").put("E", 2);
		graph.get("E").put("D", 2);

		graph.get("E").put("G", 8);
		graph.get("G").put("E", 8);

		graph.get("E").put("F", 10);
		graph.get("F").put("E", 10);

		graph.get("F").put("G", 3);
		graph.get("G").put("F", 3);
		djikstra(graph, "A");

	}

	private static void djikstra(HashMap<String, HashMap<String, Integer>> graph, String src) {

		HashMap<String, dpair> map = new HashMap<>();
		GenericHeap<dpair> heap = new GenericHeap<>();

		for (String vname : graph.keySet()) {
			dpair pair = new dpair();
			pair.csf = Integer.MAX_VALUE;
			pair.psf = "";
			pair.vname = vname;
			if (vname.equals(src)) {
				pair.csf = 0;
				pair.psf = vname;
			}
			map.put(vname, pair);
			heap.add(pair);

		}

		while (heap.size() > 0) {
			dpair rp = heap.remove();
			for (String nbr : graph.get(rp.vname).keySet()) {

				dpair nbrPair = map.get(nbr);
				String npsf = rp.psf + nbr;
				int ncsf = rp.csf + graph.get(rp.vname).get(nbr);
				if (ncsf < nbrPair.csf) {
					nbrPair.csf = ncsf;
					nbrPair.psf = npsf;
					heap.erase(nbrPair);
					heap.add(nbrPair);
				}
			}

		}
		System.out.println(map);

	}

	private static class dpair implements Comparable<dpair> {
		String psf;
		int csf;
		String vname;

		@Override
		public int compareTo(dpair o) {
			// TODO Auto-generated method stub
			return (this.csf - o.csf);
		}

		public String toString() {
			return this.psf + "@" + this.csf;
		}
	}

	private static class ppair implements Comparable<ppair> {
		String pvname;
		int csf;
		String vname;

		@Override
		public int compareTo(ppair o) {
			// TODO Auto-generated method stub
			return (this.csf - o.csf);
		}
	}

	public static HashMap<String, HashMap<String, Integer>> prims(HashMap<String, HashMap<String, Integer>> graph) {

		HashMap<String, ppair> map = new HashMap<>();
		HashMap<String,HashMap<String,Integer>> mst=new HashMap<>();
		GenericHeap<ppair> heap = new GenericHeap<>();

		for (String vname : graph.keySet()) {
			ppair pair = new ppair();
			pair.csf = Integer.MAX_VALUE;
			pair.pvname = ""; 
			pair.vname = vname;
			map.put(vname, pair);
			heap.add(pair);
		}
		while(heap.size()!=0){
			
			ppair rp=heap.remove();
			mst.put(rp.vname, new HashMap<>());
			if(rp.pvname.length()!=0){
				mst.get(rp.vname).put(rp.pvname, rp.csf);
				mst.get(rp.pvname).put(rp.vname, rp.csf);
			}
				
			
			for(String nbr: graph.get(rp.vname).keySet()){
				ppair nbrpair=map.get(nbr);
				if(mst.containsKey(nbrpair))
					continue;
				int ncost=graph.get(rp.vname).get(nbr);
				if(ncost<nbrpair.csf){
					nbrpair.csf=ncost;
					nbrpair.pvname=rp.vname;
					heap.erase(nbrpair);
					heap.add(nbrpair);
				}
				
			}
			
		}
   return mst;
	}

	
}

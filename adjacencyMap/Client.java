package adjacencyMap;

public class Client {

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F"); 
		graph.addVertex("G");
		//graph.addVertex("H");
		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 40);
		graph.addEdge("C", "B", 10);
		graph.addEdge("C", "D", 10);
	    graph.addEdge("E", "D", 2);
		graph.addEdge("E", "F", 3);
		graph.addEdge("G", "F", 3);
		graph.addEdge("E", "G", 8);
		//graph.removeEdge("D", "E");
		//graph.removeVertex("A");
		//graph.display();
		//System.out.println(graph.hasPath("A", "G"));
		//graph.printPath("A", "G");
		//graph.justLargerPath("A", "G",40);
	//	graph.kthLargestPath("A", "G",2);
		//System.out.println(graph.dfs("A", "B"));
		//graph.dft();
	//	System.out.println(graph.isCyclic());
		//System.out.println(graph.isBiPartite());
		DirectedGraph dg=new DirectedGraph();
		dg.addVertex("A");
		dg.addVertex("B");
		dg.addVertex("C");
		dg.addVertex("D");
		dg.addVertex("E");
		dg.addVertex("F");
		dg.addVertex("G");
		dg.addEdge("A", "B", 10);
		dg.addEdge("B", "C", 10);
		dg.addEdge("C", "D", 10);
		dg.addEdge("A", "D", 10);
		dg.addEdge("D", "E", 10);
		dg.addEdge("E", "F", 10);
		dg.addEdge("E", "G", 10);
		dg.addEdge("F", "G", 10);
		dg.display();
		
	}

}

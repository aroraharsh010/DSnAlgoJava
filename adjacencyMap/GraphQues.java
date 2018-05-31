package adjacencyMap;

import java.util.HashSet;

public class GraphQues {

	public static void main(String[] args) {
		int[][] graph = new int[7][7];
		graph[0][1] = 10;
		graph[1][0] = 10;

		graph[1][2] = 10;
		graph[2][1] = 10;

		graph[2][3] = 10;
		graph[3][2] = 10;

		graph[0][3] = 40;
		graph[3][0] = 40;

		graph[3][4] = 2;
		graph[4][3] = 2;

		graph[4][5] = 3;
		graph[5][4] = 3;

		graph[5][6] = 3;
		graph[6][5] = 3;

		graph[4][6] = 8;
		graph[6][4] = 8;

		graph[2][5] = 3;
		graph[5][2] = 3;
		HashSet<Integer> visited = new HashSet<>();
		int osrc = 2;

		HamiltonianPath(2, "2 ", graph, visited, osrc);

	}

	public static void HamiltonianPath(int src, String psf, int[][] graph, HashSet<Integer> visited, int osrc) {
		visited.add(src);

		if (visited.size() == graph.length) {
			System.out.print(psf + " is Hamiltonian path");
			if (graph[src][osrc] != 0)
				System.out.print(" And a cycle.");
			System.out.println();
		}
		
		for (int i = 0; i < graph.length; i++) {

			if (graph[src][i] != 0) {
				if (!visited.contains(i))
					HamiltonianPath(i, psf + i + " ", graph, visited, osrc);

			}
		}
		visited.remove(src);
	}
	public static void floydWarshall(int[][] graph,int src){
		//copy from sir code
		
	}

}

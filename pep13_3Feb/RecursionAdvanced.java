package pep13_3Feb;

public class RecursionAdvanced {

	public static void main(String[] args) {
		// printMazePathManyMoves(0, 0, 3, 3, "");
		int[][] maze = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		floodfill(maze, visited, 0, 0, "");
	}

	public static void printMazePath(int sr, int sc, int dr, int dc, String psf) {// with
																					// diagonal
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		if (sc + 1 <= dc && sr + 1 <= dr)
			printMazePath(sr + 1, sc + 1, dr, dc, psf + "d "); // this allows
																// diagonal
																// values
		if (sc + 1 <= dc)
			printMazePath(sr, sc + 1, dr, dc, psf + "h ");
		if (sr + 1 <= dr)
			printMazePath(sr + 1, sc, dr, dc, psf + "v ");

	}

	static int counter = 0;

	public static void printMazePathManyMoves(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			counter++;
			System.out.println(counter + "." + psf);
			return;
		}
		if (sr > dr || sc > dc)
			return;
		for (int i = 1; i <= dr - sr; i++) {
			printMazePathManyMoves(sr + i, sc, dr, dc, psf + "v" + i);
		}
		for (int i = 1; i <= dc - sc; i++) {
			printMazePathManyMoves(sr, sc + i, dr, dc, psf + "h" + i);
		}
		for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
			printMazePathManyMoves(sr + i, sc + i, dr, dc, psf + "d" + i);
		}
	}

	public static void floodfill(int[][] maze, boolean[][] visited, int sr, int sc, String psf) {
		// allows
		// back
		// movement
		// capability
		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			System.out.println(psf);

			return;
		}
		visited[sr][sc] = true;
		if (maze[sr][sc] == 0)
			return;
		if (sc + 1 < maze[0].length && visited[sr][sc + 1] == false) {

			floodfill(maze, visited, sr, sc + 1, psf + "right ");
		}

		if (sr + 1 < maze.length && visited[sr + 1][sc] == false) {
			floodfill(maze, visited, sr + 1, sc, psf + "down ");

		}

		if (sr - 1 >= 0 && visited[sr - 1][sc] == false) {
			floodfill(maze, visited, sr - 1, sc, psf + "up ");

		}
		if (sc - 1 >= 0 && visited[sr][sc - 1] == false) {
			floodfill(maze, visited, sr, sc - 1, psf + "left ");

		}
		visited[sr][sc] = false;
	}
}

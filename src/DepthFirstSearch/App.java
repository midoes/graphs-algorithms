package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class App {

	private final static String STACK_ALGORITHM = "stack";
	private final static String RECURSIVE_ALGORITHM = "recursive";
	
	public static void main(String[] args) {
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		
		List<Vertex> vertexes = new ArrayList<Vertex>();
		
		v1.addNeighboor(v2);
		v1.addNeighboor(v3);
		v3.addNeighboor(v4);
		v4.addNeighboor(v5);
		
		vertexes.add(v1);
		vertexes.add(v2);
		vertexes.add(v3);
		vertexes.add(v4);
		vertexes.add(v5);
		
		DFS dfs = new DFS();
		dfs.getVertexes(vertexes, STACK_ALGORITHM);
		dfs.getVertexes(vertexes, RECURSIVE_ALGORITHM);
		
	}
	
}

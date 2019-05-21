package DepthFirstSearch;

import java.util.List;
import java.util.Stack;

public class DFS {

	private Stack<Vertex> stack;

	public DFS() {
		this.stack = new Stack<Vertex>();
	}

	/**
	 * Call the depth first search method
	 * 
	 * @param vertexes is the list of all vertexes in the graph
	 * @param solutionType is the type of algorithm to solve the graph		
	 * 
	 * */
	public void getVertexes(List<Vertex> vertexes, String solutionType) {
		for (Vertex v : vertexes) {
			if (!v.isVisited()) {
				v.setVisited(true);
				if (solutionType.equals("stack")) {
					dfsWithStack(v);
				} else if (solutionType.equals("recursive")) {
					dfsRecursive(v);
				}
			}
		}
	}

	/**
	 * Implements the depth first search algorithm with a stack
	 * 
	 * */
	private void dfsWithStack(Vertex root) {
		this.stack.add(root);
		root.setVisited(true);
		while (!stack.isEmpty()) {
			Vertex actualVertex = stack.pop();
			System.out.println(actualVertex + "");
			for (Vertex v : actualVertex.getNeighboors()) {
				v.setVisited(true);
				stack.push(v);
			}
		}
	}

	/**
	 * Implements the depth first search algorithm recursively
	 * 
	 * */
	private void dfsRecursive(Vertex vertex) {
		System.out.println(vertex + "");
		for (Vertex v : vertex.getNeighboors()) {
			v.setVisited(true);
			dfsRecursive(v);
		}
	}

}

package CycleDetection;

import java.util.List;

public class CycleDetection {

	/**
	 * Detects if the graph contains cycles
	 * 
	 * @param vertexes is the list of vertexes of the graph
	 * 
	 * */
	public void detectCycle(List<Vertex> vertexes) {
		for(Vertex v: vertexes) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
	}

	/**
	 * Implementation of the depth first search
	 * 
	 * @param vertex is one of the graph
	 * 
	 * */
	private void dfs(Vertex vertex) {
		System.out.println("DFS on vertex: "+vertex);
		vertex.setBeingVisited(true);
		for(Vertex v: vertex.getAdjacenciesList()) {
			System.out.println("Visiting the neighbours of vertex: "+vertex);
			if(v.isBeingVisited()) {
				System.out.println("There is a backward edge: so there is a cycle");
				return;
			}
			if(!v.isVisited()) {
				System.out.println("Visiting vertex: "+v+" recursively...");
				v.setVisited(true);
				dfs(v);
			}
		}
		System.out.println("Set vertex: "+vertex+" setBeingVisited(false) and setVisited(true)");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}
	
}

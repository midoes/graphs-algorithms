package TopologicalOrdering;

import java.util.Stack;

public class TopologicalOrdering {
	
	private Stack<Vertex> stack;
	
	public TopologicalOrdering() {
		this.stack = new Stack<Vertex>();
	}
	
	/**
	 * Store the vertexes of the graph in a linear ordering of its vertices 
	 * such that for every directed edge in a stack
	 * 
	 * */
	public void getVertexes(Vertex vertex) {
		vertex.setVisited(true);
		for(Vertex v: vertex.getNeighboors()) {
			if(!v.isVisited()) {
				getVertexes(v);
			}
		}
		stack.push(vertex);
	}
	
	public Stack<Vertex> getStack(){
		return this.stack;
	}

}

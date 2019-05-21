package TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
	public static void main(String[] args) {
		
		TopologicalOrdering topological = new TopologicalOrdering();
		
		List<Vertex> graph = new ArrayList<Vertex>();
		graph.add(new Vertex("0"));
		graph.add(new Vertex("1"));
		graph.add(new Vertex("2"));
		graph.add(new Vertex("3"));
		graph.add(new Vertex("4"));
		graph.add(new Vertex("5"));
		
		graph.get(2).addNeighboor(graph.get(3));
		graph.get(3).addNeighboor(graph.get(1));
		graph.get(4).addNeighboor(graph.get(0));
		graph.get(4).addNeighboor(graph.get(1));
		graph.get(5).addNeighboor(graph.get(0));
		graph.get(5).addNeighboor(graph.get(2));
		
		for(int i=0; i<graph.size(); i++) {
			if(!graph.get(i).isVisited()) {
				topological.getVertexes(graph.get(i));
			}
		}
		
		Stack<Vertex> stack = topological.getStack();		
		
		for (int i = 0; i < graph.size(); i++) {			
			System.out.println(stack.pop() +" -->");
		}
	}
}

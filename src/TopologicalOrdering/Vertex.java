package TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String data;
	private boolean visited;
	private List<Vertex> neighboors;
	
	public Vertex(String data) {
		this.data = data;
		this.neighboors = new ArrayList<Vertex>();
	}
	
	public void addNeighboor(Vertex v) {
		this.neighboors.add(v);
	}
	
	@Override
	public String toString() {
		return this.data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighboors() {
		return neighboors;
	}

	public void setNeighboors(List<Vertex> neighboors) {
		this.neighboors = neighboors;
	}
	
	
}

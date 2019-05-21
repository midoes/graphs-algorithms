package CycleDetection;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		
		v1.addNeighboor(v2);
		v1.addNeighboor(v3);
		v2.addNeighboor(v3);
		v4.addNeighboor(v1);
		v4.addNeighboor(v5);
		v5.addNeighboor(v6);
		v6.addNeighboor(v4);
		
		List<Vertex> vertexes = new ArrayList<Vertex>();
		vertexes.add(v1);
		vertexes.add(v2);
		vertexes.add(v3);
		vertexes.add(v4);
		vertexes.add(v5);
		vertexes.add(v6);
		
		CycleDetection cycleDetection = new CycleDetection();
		cycleDetection.detectCycle(vertexes);
		
	}

}

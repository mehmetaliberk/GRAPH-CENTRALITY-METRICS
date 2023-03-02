import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	int size;
	public static ArrayList<Node> nodes = new ArrayList<>();
	private HashMap<String, Vertex> vertices;
	private HashMap<String, Edge> edges;

	public Graph() {
		this.vertices = new HashMap<>();
		this.edges = new HashMap<>();
	}

	public void addEdge(String source, String destination, int weight) {

		if (edges.get(source + "-" + destination) == null && edges.get(destination + "-" + source) == null) {
			Vertex source_v, destination_v;

			if (vertices.get(source) == null) {
				source_v = new Vertex(source);
				vertices.put(source, source_v);
			} else
				source_v = vertices.get(source);

			if (vertices.get(destination) == null) {
				destination_v = new Vertex(destination);
				vertices.put(destination, destination_v);
			} else
				destination_v = vertices.get(destination);

			Edge edge = new Edge(source_v, destination_v, weight);
			source_v.addEdge(edge);
			destination_v.addEdge(edge);
			edges.put(source + "-" + destination, edge);
		} 
		else {
			System.out.println("This edge has already added!");
		}
	}

	public void print() {

		System.out.println("Source\tDestination\tWeight");
		for (Edge e : edges.values()) {
			System.out.println("" + e.getSource().getName() + "\t" + e.getDestination().getName() + "\t\t" + e.getWeight() + " ");
		}
	}

	public Iterable<Vertex> vertices() {
		return vertices.values();
	}

	public Iterable<Edge> edges() {
		return edges.values();
	}

	public int size() {
		return vertices.size();
	}


	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		nodes.add(node);
	}
	Graph(int size) {
        this.size = size;
    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
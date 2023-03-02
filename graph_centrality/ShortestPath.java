import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

class ShortestPath {
	Node start, end;

	ShortestPath(Node start, Node end) {
		this.start = start;
		this.end = end;
	}

	public String FindPath() {
		Queue<Node> queue = new LinkedList<>();
		List<Node> used = new ArrayList<>();

		start.visited = true;
		queue.add(start);
		used.add(start);
		while (!queue.isEmpty()) {
			Node current_node = queue.poll();
			for (Node node : current_node.neighbors) {
				if (!node.visited) {
					node.visited = true;
					queue.add(node);
					node.prev = current_node;
					if (node == end) {
						queue.clear();
						break;
					}
				}

			}

		}
		Node node = end;
		List<Node> route = new ArrayList<>();
		while (node != start.prev && node != null) {
			route.add(node);
			node.visited = false;
			node = node.prev;
		}
		String path = route.toString();
		for (int i = 1; i < Graph.nodes.size(); i++) {
			Graph.nodes.get(i).setVisited(false);
		}
		return path;
	}

}
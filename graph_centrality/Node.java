import java.util.*;

class Node{
  public String name;
  public List<Node> neighbors;
  public boolean visited = false;
  public Node prev = null;
  

  Node(String name){
    this.name = name;
    this.neighbors = new ArrayList<>();
  }


  public void add_neighbor(Node node){
    this.neighbors.add(node);
    node.neighbors.add(this);
  }


  public String toString(){
    return this.name;
  }
  public Node getNeighbors(){
	 return neighbors.get(0);
  }

public boolean isVisited() {
	return visited;
}

public void setVisited(boolean visited) {
	this.visited = visited;
}
  
}
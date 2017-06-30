import java.util.HashSet;
import java.util.Set;

public class Graph {
	private Set<Node> vertices = new HashSet<>();
	
	public Set<Node> getVertices() {
		return vertices;
	}

	public void setVertices(Set<Node> vertices) {
		this.vertices = vertices;
	}

	public void addNode(Node node) {
		vertices.add(node);
	}
	
	@Override
	public String toString() {
		return vertices.toString();
	}
}
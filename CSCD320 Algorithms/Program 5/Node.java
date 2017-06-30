import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
	private Integer distance = Integer.MAX_VALUE;
	private String name;
	private List<Node> shortestPath = new LinkedList<>();
	Map<Node, Integer> nextHops = new HashMap<>();
	
	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Map<Node, Integer> getNextHops() {
		return nextHops;
	}

	public void setNextHops(Map<Node, Integer> nextHops) {
		this.nextHops = nextHops;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node(String name) {
		this.name = name;
	}
	
	public void addEdge(Node next, int distance) {
		nextHops.put(next,distance);
	}
	
	@Override
	public String toString(){
		if(this.distance == Integer.MAX_VALUE){
			return this.name + " infinity";
		}
		return this.name + " " + this.distance;
	}
}
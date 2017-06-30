import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {
	public static <E> void main(String[] args) {
		Node node1 = new Node("A");
		Node node2 = new Node("B");
		Node node3 = new Node("C");
		Node node4 = new Node("D");
		Node node5 = new Node("E");
		Node node6 = new Node("F");
		Node node7 = new Node("G");
		Node node8 = new Node("H");
		
		node1.addEdge(node2, 4);
		node1.addEdge(node3, 6);
		node2.addEdge(node4, 2);
		node2.addEdge(node7, 10);
		node3.addEdge(node5, 12);
		node4.addEdge(node7, 6);
		node4.addEdge(node3, 8);
		node5.addEdge(node8, 11);
		node6.addEdge(node7, 9);
		
		Graph graph = new Graph();
		
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		graph.addNode(node4);
		graph.addNode(node5);
		graph.addNode(node6);
		graph.addNode(node7);
		graph.addNode(node8);
		
		System.out.println(graph);
		
		graph = shortestPath(graph, node1);
		
		System.out.println(graph);
	}
	
	public static Graph shortestPath(Graph graph, Node src) {
		src.setDistance(0);
		Set<Node> visitedNodes = new HashSet<>();
		Set<Node> unvisitedNodes = new HashSet<>();
		unvisitedNodes.add(src);
		
		while(unvisitedNodes.size() != 0) {
			Node curr = getShortestDistance(unvisitedNodes);
			unvisitedNodes.remove(curr);
			
			for(Entry<Node, Integer> pair: curr.getNextHops().entrySet()) {
				Node nextNode = pair.getKey();
				Integer weight = pair.getValue();
				
				if(!visitedNodes.contains(nextNode)) {
					minDistance(nextNode, weight,curr);
					unvisitedNodes.add(nextNode);
				}
			}
			visitedNodes.add(curr);
		}
		return graph;
	}
	
	private static Node getShortestDistance(Set<Node> unvisitedNodes) {
		int lowest = Integer.MAX_VALUE;
		Node nextNode = null;
		
		for(Node node: unvisitedNodes) {
			int distance = node.getDistance();
			
			if(distance < lowest){
				lowest = distance;
				nextNode = node;
			}
		}
		return nextNode;
	}
	
	private static void minDistance(Node nextNode, Integer weight, Node src) {
		Integer srcDistance = src.getDistance();
		
		if(srcDistance + weight < nextNode.getDistance()) {
			nextNode.setDistance(srcDistance+weight);
			LinkedList<Node> shortestPath = new LinkedList<>(src.getShortestPath());
			shortestPath.add(src);
			nextNode.setShortestPath(shortestPath);
		}
	}
}
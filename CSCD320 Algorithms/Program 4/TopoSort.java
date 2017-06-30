import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopoSort {
	public static <E>List<E> sort(DAG graph){
		DAG<E> reverse = reverse(graph);
		Set<E> increased = new HashSet<E>();
		Set<E> visited = new HashSet<E>();
		List<E> result = new ArrayList<E>();
		
		for(E vertice: reverse){
			DFS(vertice, reverse, result, visited, increased);
		}
		
		return result;
	}

	private static <E> DAG<E> reverse(DAG<E> graph){
		DAG<E> result = new DAG<E>();
		
		for(E vertice: graph){
			result.addVertice(vertice);
		}
		
		for(E vertice: graph){
			for(E end: graph.hops(vertice))
				result.addEdge(end, vertice);
		}
		
		return result;
	}
	
	private static <E> void DFS(E vertice, DAG<E> graph, List<E> order, Set<E> visited, Set<E> increased){
		if(visited.contains(vertice)){
			if(increased.contains(vertice))
				return;
			throw new IllegalArgumentException("There is a circle.");
		}
		
		visited.add(vertice);
		
		for(E predecessor: graph.hops(vertice)){
			DFS(predecessor, graph, order, visited, increased);
		}
		
		order.add(vertice);
		increased.add(vertice);
	}
}
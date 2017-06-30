import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class TopoSortDriver {
	public static void main(String[] args) {
		
		DAG<Integer> graph = new DAG<Integer>();
		
		graph.addVertice(0);
		graph.addVertice(1);
		graph.addVertice(2);
		graph.addVertice(3);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		System.out.println("Before sort:\n"+graph);
		
		List result = TopoSort.sort(graph);
		
		System.out.println("After sort:\n"+result);
	}
}
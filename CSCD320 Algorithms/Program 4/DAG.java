import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class DAG<E> implements Iterable<E> {
	private Map<E, Set<E>> graph = new HashMap<E, Set<E>>();
	
	public void addEdge(E start, E end){
		if(!graph.containsKey(start) || !graph.containsKey(end))
			throw new NoSuchElementException("Vertices not in graph.");
		graph.get(start).add(end);
	}
		
	public void removeEdge(E start, E end){
		if(!graph.containsKey(start) || !graph.containsKey(end))
			throw new NoSuchElementException("Vertices not in graph.");
		graph.get(start).remove(end);
	}
	
	public boolean edgeExists(E start, E end){
		if(!graph.containsKey(start) || !graph.containsKey(end))
			throw new NoSuchElementException("Vertices not in graph.");
		return graph.get(start).contains(end);
	}
	
	public boolean addVertice(E vertice){
		if(graph.containsKey(vertice))
			return false;
		graph.put(vertice, new HashSet<E>());
		return true;
	}
	
	public Set<E> hops(E vertice){
		Set<E> hops = graph.get(vertice);
		
		if(hops == null)
			throw new NoSuchElementException("Vertice not in graph.");
		return Collections.unmodifiableSet(hops);
	}
	
	public int size(){
		return graph.size();
	}
	
	public boolean isEmpty(){
		return graph.isEmpty();
	}
	
	public Iterator<E> iterator(){
		return graph.keySet().iterator();
	}
	
	@Override
	public String toString(){
		return this.graph.toString();
	}
}
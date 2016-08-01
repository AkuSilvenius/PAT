package HS;

import java.util.*;

public class MFSet<E extends Collection<? super E>> implements HSTreeIn<E> {

	int size;
	Vertex<E> root;

	public MFSet(HSgraph<Vertex<E>> g) {
		this.size = g.size();
	}

	public boolean add(Vertex<E> v) {
		HSTree<E> t = new HSTree<E>(v);
		return true;
	}

	public Node<E> find(Node<E> n) {
		
		if (n != n.parent) {
			n.parent = find(n.parent);
		}
		return n.parent;
		
	}	

	public static <E> void merge(Set<Vertex<E>> A, Set<Vertex<E>> B) {

	}
	
}
package HS;

import java.util.*;

public class MFSet<E> {

	LinkedList<HSTree<E>> forest;

	public MFSet(HSgraph<E> g) {
		this.forest = new LinkedList<HSTree<E>>();
		for (Vertex<E> v : g.vertices()) this.makeSet(v); 
	}

	public boolean makeSet(Vertex<E> v) {
		this.forest.add(new HSTree<E>(v));
		return true;
	}

	public Node<E> findSet(Node<E> n) {

		if (n != n.parent) {
			n.parent = findSet(n.parent);
		}
		return n.parent;

	}

	public void union(Node<E> x, Node<E> y) {
		link(findSet(x), findSet(y));
	}

	public void link(Node<E> x, Node<E> y) {
		if (x.rank > y.rank) y.parent = x;
		else if (x.rank < y.rank) x.parent = y; 

		if (x.rank == y.rank) {
			x.parent = y;
			y.rank++;
		}
	}

}
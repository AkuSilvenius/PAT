package HS;

import java.util.*;

public abstract class HSgraph<E> implements Iterable<E> {

	LinkedList<Vertex<E>> vlist;
	int size;

	public HSgraph(int vertices, int edges) {
		this.size = vertices;
	}

	public int size() {
		return this.size;
	}
	
	public Iterator<Vertex<E>> vertexIterator() {
		return this.vlist.iterator();
	}

	public Iterable<Edge<E>> edges() {
		return vlist.iterator();
	}
	
	public Vertex<E> addVertex(int clr, int ind, float w) {
		Vertex<E> tmp = new Vertex<E>(clr, ind, w);
		vlist.add(tmp);
		return tmp;
	}

	LinkedList<Edge<E>> MSTKruskal(HSgraph<E> g) {
		LinkedList<Edge<E>> mst = new LinkedList<Edge<E>>();
		PriorityQueue<Edge<E>> Q = new PriorityQueue<Edge<E>>(); // TODO: float priority

		for (Edge<E> e : g.edges()) Q.add(e);

		MFSet<E> M = new MFSet<E>(g);

		int i = g.size;
		while(i > 1) {
			Edge<E> e = Q.poll();
			Node<E> s1 = M.findSet(e.getEndPoint());
			Node<E> s2 = M.findSet(e.getStartPoint());
			if (s1 != s2) {
				M.union(s1, s2);
				i--;
				mst.add(e);
			}
		}

		return mst;
	}

}
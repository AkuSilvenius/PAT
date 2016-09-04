package HS;

import java.util.*;

public abstract class HSgraph extends Object implements Iterable<Object> {

	LinkedList<Vertex> vlist;
	LinkedList<Edge> elist;
	int size;

	public HSgraph(int vertices, int edges) {
		this.size = vertices;
	}

	public int size() {
		return this.size;
	}
	
	public Iterable<Vertex> vertices() {
		return this.vlist;
	}

	public Iterator<Vertex> vertexIterator() {
		return this.vlist.iterator();
	}
	
	public Iterator<Edge> edgeIterator() {
		return this.elist.iterator();
	}
	
	public Iterable<Edge> edges() {
		for (Vertex v : vlist) {
			return v.edges;
		}
	}
	
	public Vertex addVertex(int clr, int ind, float w) {
		Vertex tmp = new Vertex(clr, ind, w);
		vlist.add(tmp);
		return tmp;
	}

	LinkedList<Edge> MSTKruskal(HSgraph g) {
		LinkedList<Edge> mst = new LinkedList<Edge>();
		PriorityQueue<Edge> Q = new PriorityQueue<Edge>(); // TODO: float priority

		for (Edge e : g.edges()) Q.add(e);

		MFSet M = new MFSet(g);

		int i = g.size;
		while(i > 1) {
			Edge e = Q.poll();
			Node s1 = M.findSet(e.getEndPoint());
			Node s2 = M.findSet(e.getStartPoint());
			if (s1 != s2) {
				M.union(s1, s2);
				i--;
				mst.add(e);
			}
		}

		return mst;
	}

}
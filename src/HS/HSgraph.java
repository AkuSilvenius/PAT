package HS;

import java.util.*;

public class HSgraph extends Object implements Iterable<Object> {

	LinkedList<Vertex> vlist;
	LinkedList<Edge> elist;
	int size;

	public HSgraph(int vertices, int edges) {
		this.size = vertices;
	}
	
	public Vertex addVertex() {
		Vertex tmp = new Vertex();
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(int ind) {
		Vertex tmp = new Vertex(ind);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(String label) {
		Vertex tmp = new Vertex(label);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(float w) {
		Vertex tmp = new Vertex(w);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(float w, int ind) {
		Vertex tmp = new Vertex(w, ind);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(int clr, float w) {
		Vertex tmp = new Vertex(clr, w);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(int clr, int ind) {
		Vertex tmp = new Vertex(clr, ind);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(String label, int ind) {
		Vertex tmp = new Vertex(label, ind);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(String label, int clr, float w) {
		Vertex tmp = new Vertex(label, clr, w);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(int clr, float w, int ind) {
		Vertex tmp = new Vertex(clr, w, ind);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(String label, int clr, int ind) {
		Vertex tmp = new Vertex(label, clr, ind);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(String label, int clr, int ind, float w) {
		Vertex tmp = new Vertex(label, clr, ind, w);
		this.vlist.add(tmp);
		return tmp;
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
		return this.elist;
	}
	
	public Vertex firstVertex() {
		return this.vlist.peekFirst();
	}
	
	public void removeVertex(Vertex v) {
		this.vlist.remove(this.vlist.indexOf(v));
		for (Edge e : this.elist)
			if (e.getEndPoint().equals(v) || e.getStartPoint().equals(v))
				elist.remove(this.elist.indexOf(e));
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

	public Iterator<Object> iterator() {
		return this.vlist.iterator();
	}

}
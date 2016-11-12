package HS;

import java.util.*;

public class HSgraph extends Object implements Iterable<Vertex>, HSgraphIn {

	LinkedList<Vertex> vlist;
	LinkedList<Edge> elist;

	public HSgraph() {
		this.vlist = new LinkedList<Vertex>();
		this.elist = new LinkedList<Edge>();
	}
	
	public Vertex addVertex() {
		Vertex tmp = new Vertex();
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(int clr) {
		Vertex tmp = new Vertex(clr);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(String label) { 
		Vertex tmp = new Vertex(label);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(int clr, String label) {
		Vertex tmp = new Vertex(clr,label);
		this.vlist.add(tmp);
		return tmp;
	}

	public int size() {
		return this.vlist.size();
	}
	
	public Iterable<Vertex> vertices() {
		return this.vlist;
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

	public Iterator<Vertex> iterator() {
		return this.vlist.iterator();
	}

}
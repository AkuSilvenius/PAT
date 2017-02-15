package HS;

import java.util.LinkedList;
import java.util.Iterator;
import HS_in.Vertex;
import HS_in.Edge;
import HS_in.Graph;

public class AbGraph extends AbKruskal implements Iterable<Vertex>, HS_in.Graph {

	LinkedList<Vertex> vlist;
	LinkedList<Edge> elist;
	
	public AbGraph() {
		this.vlist = new LinkedList<Vertex>();
		this.elist = new LinkedList<Edge>();
	}
	
	public Vertex addVertex(Graph g) {
		Vertex tmp = new AbVertex();
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(Graph g, int clr) {
		Vertex tmp = new AbVertex(clr);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(Graph g, String label) { 
		Vertex tmp = new AbVertex(label);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public Vertex addVertex(Graph g, int clr, String label) {
		Vertex tmp = new AbVertex(clr,label);
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

	public LinkedList<Edge> getEdges() {
		return this.elist;
	}
	
	public LinkedList<Vertex> getVertices() {
		return this.vlist;
	}

}
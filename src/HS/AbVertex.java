package HS;

import java.util.Iterator;
import java.util.LinkedList;
import HS_in.Vertex;
import HS_in.Edge;
import HS_in.Graph;

public class AbVertex implements Comparable<Object>, Iterable<Edge>, Vertex {

	public LinkedList<Edge> edges;
	String label;
	int color;

	public AbVertex() {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = HSCol.NaN;
	}
	
	public AbVertex(String label) {
		this.edges = new LinkedList<Edge>();
		this.label = label;
		this.color = HSCol.NaN;
	}
	
	public AbVertex(int clr) {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = clr;
	}
	
	public AbVertex(int clr, String label) {
		this.edges = new LinkedList<Edge>();
		this.label = label;
		this.color = clr;	
	}
	
	public int getColor() {
		return this.color;
	}

	public Edge getEdge(Vertex v) {
		for (Edge e : this.edges)
			if (e.getEndPoint().equals(v)) return e;
		return null;
	}


	public String getLabel() {
		return this.label;
	}


	public void setColor(int clr) {
		this.color = clr;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public Edge addEdge(Graph g, Vertex v) {
		Edge tmp = new AbEdge(v);
		tmp.setStartPoint(this);
		this.edges.add(tmp);
		g.getEdges().add(tmp);
		return tmp;
	}

	public Edge addEdge(Graph g, Vertex v, float w) {
		Edge tmp = new AbEdge(v, w);
		tmp.setStartPoint(this);
		this.edges.add(tmp);
		g.getEdges().add(tmp);
		return tmp;
	}

	
	public Edge addEdge(Graph g, Vertex v, int clr) {
		Edge tmp = new AbEdge(v, clr);
		tmp.setStartPoint(this);
		this.edges.add(tmp);
		g.getEdges().add(tmp);
		return tmp;
	}

	public Edge addEdge(Graph g, Vertex v, float w, int clr) {
		Edge tmp = new AbEdge(v, w, clr);
		tmp.setStartPoint(this);
		this.edges.add(tmp);
		g.getEdges().add(tmp);
		return tmp;
	}
	
	public void removeEdge(Edge e) {
		for (Edge Edge : this.edges)
			if (Edge.equals(e)) this.edges.remove(e); // hidas
	}
	
	public void removeEdges() {
		this.edges.removeAll(edges);
			
	}
	
	public Iterable<Vertex> neighbors() {
		LinkedList<Vertex> tmp = new LinkedList<Vertex>();
		for (Edge e : this.edges) tmp.add(e.getEndPoint());
		return tmp;
		
	}

	public boolean isAdjacent(Vertex v) {
		for(Edge e : this.edges){
			if(e.getEndPoint().equals(v)){
				return true;
			}
		}for (Edge e : v.getEdges()){
			if(e.getEndPoint().equals(this)){
				return true;
			}
		}

		return false;
	}
	
	public Iterable<Edge> edges() {
		return this.edges;
	}
	
	@Override
	public Iterator<Edge> iterator() {
		return this.iterator();
	}

	@Override
	public int compareTo(Object o) {
		return this.compareTo(o);
	}

	@Override
	public LinkedList<Edge> getEdges() {
		return this.edges;
	}
	
}
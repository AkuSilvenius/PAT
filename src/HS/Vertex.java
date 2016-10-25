package HS;

import java.util.*;

public class Vertex extends Object implements Comparable<Object>, Iterable<Edge>, VertexIn {

	LinkedList<Edge> edges;
	String label;
	int color;

	public Vertex() {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = HSCol.NaN;
	}
	
	public Vertex(String label) {
		this.edges = new LinkedList<Edge>();
		this.label = label;
		this.color = HSCol.NaN;
	}
	
	public Vertex(int clr) {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = clr;
	}
	
	public Vertex(int clr, String label) {
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


	public Edge addEdge(Vertex v) {
		Edge tmp = new Edge(v);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}

	public Edge addEdge(Vertex v, float w) {
		Edge tmp = new Edge(v, w);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}

	
	public Edge addEdge(Vertex v, int clr) {
		Edge tmp = new Edge(v, clr);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}

	public Edge addEdge(Vertex v, float w, int clr) {
		Edge tmp = new Edge(v, w, clr);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}
	
	public void removeEdge(Edge e) {
		for (Edge edge : this.edges)
			if (edge.equals(e)) this.edges.remove(e); // hidas
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
		}for (Edge e : v.edges){
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
	
}
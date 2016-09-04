package HS;

import java.util.*;

public class Vertex extends Object implements Comparable<Object>, Iterable<Object> {

	LinkedList<Edge> edges;
	String label;
	int color;
	int index;
	float weight;

	public Vertex() {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = HSCol.NaN;
		this.index = -1;
		this.weight = Float.NaN;
	}

	public Vertex(int clr, int ind) {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = clr;
		this.index = ind;
		this.weight = Float.NaN;
	}
	
	public Vertex(String label, int clr, int ind) {
		this.edges = new LinkedList<Edge>();
		this.label = label;
		this.color = clr;
		this.index = ind;
		this.weight = Float.NaN;
	}
	public Vertex(int clr, int ind, float w) {
		this.edges = new LinkedList<Edge>();
		this.label = "";
		this.color = clr;
		this.index = ind;
		this.weight = w;
	}
	
	public Vertex(String label, int clr, int ind, float w) {
		this.edges = new LinkedList<Edge>();
		this.label = label;
		this.color = clr;
		this.index = ind;
		this.weight = w;
	}

	public int getColor() {
		return this.color;
	}

	public Edge getEdge(Vertex v) {
		for (Edge e : this.edges)
			if (e.getEndPoint().equals(v)) return e;
		return null;
	}

	public int getIndex() {
		return this.index;
	}

	public String getLabel() {
		return this.label;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setColor(int clr) {
		this.color = clr;
	}

	public void setIndex(int ind) {
		this.index = ind;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setWeight(float w) {
		this.weight = w;
	}

	public Edge addEdge(Vertex v) {
		Edge tmp = new Edge(v);
		edges.add(tmp);
		return tmp;
	}

	public Edge addEdge(Vertex v, float w) {
		Edge tmp = new Edge(v, w);
		edges.add(tmp);
		return tmp;
	}

	public Edge addEdge(Vertex v, int clr) {
		Edge tmp = new Edge(v, clr);
		edges.add(tmp);
		return tmp;
	}

	public Edge addEdge(Vertex v, float w, int clr) {
		Edge tmp = new Edge(v, w, clr);
		edges.add(tmp);
		return tmp;
	}

	public void removeEdge(Edge e) {
		for (Edge edge : this.edges)
			if (edge.equals(e)) edges.r
	}
	
	public Iterable<Vertex> neighbors() {
		return null;

	}

	public boolean isAdjacent(Vertex v) {


		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		return this.iterator();
	}

	@Override
	public int compareTo(Object o) {
		return this.compareTo(o);
	}
	
}
package HS;

import java.util.Iterator;
import java.util.LinkedList;

public class Vertex<E> implements Iterable<E> {

	LinkedList<Edge<E>> edges = new LinkedList<Edge<E>>();
	String label;
	int color;
	int index;
	float weight;

	public Vertex() {
		this.label = "";
		this.color = HSCol.NaN;
		this.index = -1;
		this.weight = Float.NaN;
	}

	public Vertex(String label, int clr, int ind, float w) {
		this.label = label;
		this.color = clr;
		this.index = ind;
		this.weight = w;
	}
	
	public Vertex(int clr, int ind) {
		this.label = "";
		this.color = clr;
		this.index = ind;
		this.weight = Float.NaN;
	}

	public int getColor() {
		return this.color;
	}

	public Edge<E> getEdge(Vertex<E> v) {
		for (Edge<E> e : this.edges)
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
	
	public Edge<E> addEdge(Vertex<E> v) {
		Edge<E> tmp = new Edge<E>(v);
		edges.add(tmp);
		return tmp;
	}
	
	public Edge<E> addEdge(Vertex<E> v, float w) {
		Edge<E> tmp = new Edge<E>(v, w);
		edges.add(tmp);
		return tmp;
	}
	
	public Edge<E> addEdge(Vertex<E> v, int clr) {
		Edge<E> tmp = new Edge<E>(v, clr);
		edges.add(tmp);
		return tmp;
	}
	
	public Edge<E> addEdge(Vertex<E> v, float w, int clr) {
		Edge<E> tmp = new Edge<E>(v, w, clr);
		edges.add(tmp);
		return tmp;
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return null;
	}

	public Iterable<E> neighbors() {
		
	}

	public static boolean isAdjacent() {


		return false;
	}

}
package HS;

import java.util.LinkedList;

public class Edge<E> {
	
	//vitun pelle
	Vertex<E> startPoint;
	Vertex<E> endPoint;
	float weight;
	int color;

	public Edge() {
		this.startPoint = null;
		this.endPoint = null;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}
	
	public Edge(Vertex<E> endpoint) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}
	
	public Edge(Vertex<E> endpoint, float w) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = HSCol.NaN;
	}
	
	public Edge(Vertex<E> endpoint, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = clr;
	}
	
	public Edge(Vertex<E> endpoint, float w, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = clr;
	}

	public void setWeight(int w) {
		this.weight = w;
	}

	public float getWeight() {
		return this.weight;
	}

	public Vertex<E> getEndPoint() {
		return this.endPoint;
	}

	public Vertex<E> getEndPoint(Vertex<E> v) {
		if (!v.equals(this.startPoint)) return null;
		if (v.equals(this.startPoint)) return this.endPoint;
		return this.startPoint;
	}

	public Vertex<E> getStartPoint() {
		return this.startPoint;
	}
}
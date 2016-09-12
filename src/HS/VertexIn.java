package HS;

import java.util.Iterator;

public interface VertexIn {

	int getColor();

	Edge getEdge(Vertex v);

	int getIndex();

	String getLabel();

	float getWeight();

	void setColor(int clr);

	void setIndex(int ind);

	void setLabel(String label);

	void setWeight(float w);

	Edge addEdge(Vertex v);

	Edge addEdge(Vertex v, float w);

	Edge addEdge(Vertex v, String label);

	Edge addEdge(Vertex v, int clr);

	Edge addEdge(Vertex v, float w, int clr);

	Edge addEdge(Vertex v, String label, int clr);

	Edge addEdge(Vertex v, String label, int clr, float w);

	void removeEdge(Edge e);

	void removeEdges();

	Iterable<Vertex> neighbors();

	Iterator<Vertex> neighborsIterator();

	boolean isAdjacent(Vertex v);

	Iterator<Edge> edgeIterator();

	Iterable<Edge> edges();

	Iterator<Edge> iterator();

	int compareTo(Object o);

}
package HS;

import java.util.*;
import HS_in.Vertex;

public class AbVertex extends Object implements Comparable<Object>, Iterable<AbEdge>, Vertex {

	public LinkedList<AbEdge> edges;
	String label;
	int color;

	public AbVertex() {
		this.edges = new LinkedList<AbEdge>();
		this.label = "";
		this.color = HSCol.NaN;
	}
	
	public AbVertex(String label) {
		this.edges = new LinkedList<AbEdge>();
		this.label = label;
		this.color = HSCol.NaN;
	}
	
	public AbVertex(int clr) {
		this.edges = new LinkedList<AbEdge>();
		this.label = "";
		this.color = clr;
	}
	
	public AbVertex(int clr, String label) {
		this.edges = new LinkedList<AbEdge>();
		this.label = label;
		this.color = clr;	
	}
	
	public int getColor() {
		return this.color;
	}

	public AbEdge getEdge(AbVertex v) {
		for (AbEdge e : this.edges)
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


	public AbEdge addEdge(AbVertex v) {
		AbEdge tmp = new AbEdge(v);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}

	public AbEdge addEdge(AbVertex v, float w) {
		AbEdge tmp = new AbEdge(v, w);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}

	
	public AbEdge addEdge(AbVertex v, int clr) {
		AbEdge tmp = new AbEdge(v, clr);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}

	public AbEdge addEdge(AbVertex v, float w, int clr) {
		AbEdge tmp = new AbEdge(v, w, clr);
		tmp.startPoint = this;
		this.edges.add(tmp);
		return tmp;
	}
	
	public void removeEdge(AbEdge e) {
		for (AbEdge abEdge : this.edges)
			if (abEdge.equals(e)) this.edges.remove(e); // hidas
	}
	
	public void removeEdges() {
		this.edges.removeAll(edges);
			
	}
	
	public Iterable<AbVertex> neighbors() {
		LinkedList<AbVertex> tmp = new LinkedList<AbVertex>();
		for (AbEdge e : this.edges) tmp.add(e.getEndPoint());
		return tmp;
		
	}

	public boolean isAdjacent(AbVertex v) {
		for(AbEdge e : this.edges){
			if(e.getEndPoint().equals(v)){
				return true;
			}
		}for (AbEdge e : v.edges){
			if(e.getEndPoint().equals(this)){
				return true;
			}
		}

		return false;
	}
	
	public Iterable<AbEdge> edges() {
		return this.edges;
	}
	
	@Override
	public Iterator<AbEdge> iterator() {
		return this.iterator();
	}

	@Override
	public int compareTo(Object o) {
		return this.compareTo(o);
	}
	
}
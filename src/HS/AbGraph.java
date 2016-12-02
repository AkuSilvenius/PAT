package HS;

import java.util.LinkedList;
import java.util.Iterator;

public class AbGraph extends Object implements Iterable<AbVertex>, HS_in.Graph {

	LinkedList<AbVertex> vlist;
	LinkedList<AbEdge> elist;
	
	public AbGraph() {
		this.vlist = new LinkedList<AbVertex>();
		this.elist = new LinkedList<AbEdge>();
	}
	
	public AbVertex addVertex() {
		AbVertex tmp = new AbVertex();
		this.vlist.add(tmp);
		return tmp;
	}
	
	public AbVertex addVertex(int clr) {
		AbVertex tmp = new AbVertex(clr);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public AbVertex addVertex(String label) { 
		AbVertex tmp = new AbVertex(label);
		this.vlist.add(tmp);
		return tmp;
	}
	
	public AbVertex addVertex(int clr, String label) {
		AbVertex tmp = new AbVertex(clr,label);
		this.vlist.add(tmp);
		return tmp;
	}

	public int size() {
		return this.vlist.size();
	}
	
	public Iterable<AbVertex> vertices() {
		return this.vlist;
	}
	
	public Iterable<AbEdge> abEdges() {
		return this.elist;
	}
	
	public AbVertex firstVertex() {
		return this.vlist.peekFirst();
	}
	
	public void removeVertex(AbVertex v) {
		this.vlist.remove(this.vlist.indexOf(v));
		for (AbEdge e : this.elist)
			if (e.getEndPoint().equals(v) || e.getStartPoint().equals(v))
				elist.remove(this.elist.indexOf(e));
	}

	public Iterator<AbVertex> iterator() {
		return this.vlist.iterator();
	}

}
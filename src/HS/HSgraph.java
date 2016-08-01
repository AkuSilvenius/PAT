package HS;

import java.util.LinkedList;

public abstract class HSgraph<E> implements Iterable<E> {
	
	LinkedList<E> vlist;
	int size;
	
	public HSgraph(int vertices, int edges) {
		this.size = vertices;
	}
	
	public int size() {
		return this.size;
	}
	
	public Iterable<E> vertices() {
		
		return null;
	}
	
}
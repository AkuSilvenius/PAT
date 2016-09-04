package HS;

public class Node<E> {
	
	Node<E> parent;
	Vertex<E> element;
	int rank;
	
	public Node() {
		this.element = null;
		this.parent = null;
		this.rank = 0;
	}
	
	public Node(Vertex<E> e) {
		this.element = e;
		this.parent = null;
		this.rank = 0;
	}
	
	public Vertex<E> getElement() {
		return this.element;
	}
	
	public Node<E> getParent() {
		return this.parent;
	}
	
	public void setElement(Vertex<E> e) {
		this.element = e;
	}
	
	public void setParent(Node<E> p) {
		this.parent = p;
	}	
	
}
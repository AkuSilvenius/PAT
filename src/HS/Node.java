package HS;

public class Node<E> extends Vertex<E> {
	
	Node<E> parent;
	Vertex<E> element;
	int rank;
	
	public Node() {
		this.element = this;
		this.parent = null;
		this.rank = 0;
	}
	
	public Node(Vertex<E> e) {
		this.element = e;
		this.rank = 0;
	}
	
	public Node<E> getParent() {
		return this.parent;
	}
	
	public void setParent(Node<E> p) {
		this.parent = p;
	}	
	
}
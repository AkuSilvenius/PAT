package HS;

public class HSTree<E> extends Node<E> {
	
	Vertex<E> root;
	
	public HSTree(Vertex<E> v) {
		this.root = new Node<E>(v);
	}
		
}
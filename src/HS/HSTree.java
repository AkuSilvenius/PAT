package HS;

public class HSTree<E> {

	Node<E> root;

	public HSTree(Vertex<E> v) {
		this.root = new Node<E>(v);
	}

}
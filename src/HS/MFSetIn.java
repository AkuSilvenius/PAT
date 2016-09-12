package HS;

import HS.HSTree.Node;

public interface MFSetIn {

	boolean makeSet(Vertex v);

	Node findSet(Node n);

	void union(Node x, Node y);

	void link(Node x, Node y);

}
package HS;

import java.util.*;
import HS.HSTree.*;

public class MFSet implements MFSetIn {

	LinkedList<HSTree> forest;

	public MFSet(HSgraph g) {
		this.forest = new LinkedList<HSTree>();
		for (Vertex v : g.vertices()) this.makeSet(v); 
	}

	public boolean makeSet(Vertex v) {
		this.forest.add(new HSTree(v));
		return true;
	}

	public Node findSet(Node n) {

		if (n != n.parent) {
			n.parent = findSet(n.parent);
		}
		return n.parent;

	}

	public void union(Node x, Node y) {
		link(findSet(x), findSet(y));
	}

	public void link(Node x, Node y) {
		if (x.rank > y.rank) y.parent = x;
		else if (x.rank < y.rank) x.parent = y; 

		if (x.rank == y.rank) {
			x.parent = y;
			y.rank++;
		}
	}

}
package HS;

import java.util.LinkedList;
import HS_in.*;

public class AbMFSet implements MFSet {

	LinkedList<AbTree> forest;

	public AbMFSet(Graph g) {
		this.forest = new LinkedList<AbTree>();
		for (Vertex v : g.vertices()) this.makeSet(v); 
	}

	public boolean makeSet(Vertex v) {
		this.forest.add(new AbTree(v));
		return true;
	}

	public Node findSet(Node n) {

		if (n != n.getParent()) {
			n.setParent(findSet(n.getParent()));
		}
		return n.getParent();

	}

	public void union(Node x, Node y) {
		link(findSet(x), findSet(y));
	}

	public void link(Node x, Node y) {
		if (x.getRank() > y.getRank()) y.setParent(x);
		else if (x.getRank() < y.getRank()) x.setParent(y); 

		if (x.getRank() == y.getRank()) {
			x.setParent(y);
			y.setRank(y.getRank()+1);
		}
	}

	public LinkedList<AbTree> getForest() {
		return this.forest;
	}

}
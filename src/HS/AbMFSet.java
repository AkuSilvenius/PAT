package HS;

import java.util.LinkedList;
import HS.AbTree.*;
import HS_in.MFSet;

public class AbMFSet implements MFSet {

	LinkedList<AbTree> forest;

	public AbMFSet(AbGraph g) {
		this.forest = new LinkedList<AbTree>();
		for (AbVertex v : g.vertices()) this.makeSet(v); 
	}

	public boolean makeSet(AbVertex v) {
		this.forest.add(new AbTree(v));
		return true;
	}

	public AbNode findSet(AbNode n) {

		if (n != n.parent) {
			n.parent = findSet(n.parent);
		}
		return n.parent;

	}

	public void union(AbNode x, AbNode y) {
		link(findSet(x), findSet(y));
	}

	public void link(AbNode x, AbNode y) {
		if (x.rank > y.rank) y.parent = x;
		else if (x.rank < y.rank) x.parent = y; 

		if (x.rank == y.rank) {
			x.parent = y;
			y.rank++;
		}
	}

}
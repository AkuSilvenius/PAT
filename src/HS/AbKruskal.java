package HS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import HS.AbTree.AbNode;

public abstract class AbKruskal implements HS_in.Kruskal {
	
	public LinkedList<AbEdge> MSTKruskal(AbGraph g) {
		
		HashMap<AbVertex,AbNode> map = new HashMap<AbVertex,AbNode>(); // findSet()-operaation avuksi while-loopin sisällä
		LinkedList<AbEdge> mst = new LinkedList<AbEdge>();
		PriorityQueue<AbEdge> Q = new PriorityQueue<AbEdge>();

		for (AbEdge e : g.abEdges()) Q.add(e);

		AbMFSet M = new AbMFSet(g);
		for (AbTree t : M.forest) map.put(t.root.element, t.root);

		int i = g.size();
		while(i > 1) {
			AbEdge e = Q.poll();
			AbNode s1 = M.findSet(map.get(e.getEndPoint()));
			AbNode s2 = M.findSet(map.get(e.getStartPoint()));
			if (s1 != s2) {
				M.union(s1, s2);
				i--;
				mst.add(e);
			}
		}

		return mst;
	}
	
}
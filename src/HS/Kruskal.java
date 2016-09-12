package HS;

import java.util.LinkedList;
import java.util.PriorityQueue;
import HS.HSTree.*;

public class Kruskal implements KruskalIn {
	
	public LinkedList<Edge> MSTKruskal(HSgraph g) {
		LinkedList<Edge> mst = new LinkedList<Edge>();
		PriorityQueue<Edge> Q = new PriorityQueue<Edge>();

		for (Edge e : g.edges()) Q.add(e);

		MFSet M = new MFSet(g);

		int i = g.size;
		while(i > 1) {
			Edge e = Q.poll();
			Node s1 = M.findSet(e.getEndPoint());
			Node s2 = M.findSet(e.getStartPoint());
			if (s1 != s2) {
				M.union(s1, s2);
				i--;
				mst.add(e);
			}
		}

		return mst;
	}
	
}
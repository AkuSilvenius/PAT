package HS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import HS_in.*;

public abstract class AbKruskal implements HS_in.Kruskal {

	public LinkedList<Edge> MSTKruskal(Graph g) throws NullPointerException {

		HashMap<Vertex,Node> map = new HashMap<Vertex,Node>(); // findSet()-operaation avuksi while-loopin sisällä
		LinkedList<Edge> mst = new LinkedList<Edge>();
		PriorityQueue<Edge> Q = new PriorityQueue<Edge>();

		if (g.getVertices().size() == 0 || g.getEdges().size() == 0) return mst;

		for (Edge e : g.Edges()){
			Q.add(e);
		};

		MFSet M = new AbMFSet(g);
		for (AbTree t : M.getForest()) map.put(t.root.getElement(), t.root);

		try {
			int i = g.size();

			while(i > 1) {
				Edge e = Q.poll();
				Node s1 = M.findSet(map.get(e.getEndPoint()));
				Node s2 = M.findSet(map.get(e.getStartPoint()));
				if (s1 != s2) {
					M.union(s1, s2);
					i--;
					mst.add(e);
				}
			}
		} catch (NullPointerException n) {
			System.out.println(n + ": Luultavasti verkko on epäyhtenäinen.");
			throw n;
		}

		return mst;
	}

}

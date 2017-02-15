package HS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import HS_in.*;

public abstract class AbKruskal implements HS_in.Graph {

	public LinkedList<Edge> MSTKruskal() throws NullPointerException {

		HashMap<Vertex,Node> map = new HashMap<Vertex,Node>(); // findSet()-operaation avuksi while-loopin sisällä
		LinkedList<Edge> mst = new LinkedList<Edge>();
		PriorityQueue<Edge> Q = new PriorityQueue<Edge>();

		if (this.getVertices().size() == 0 || this.getEdges().size() == 0) return mst;

		for (Edge e : this.edges()){
			Q.add(e);
		};

		MFSet M = new AbMFSet(this);
		for (AbTree t : M.getForest()) map.put(t.root.getElement(), t.root);

		try {
			int i = this.size();

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

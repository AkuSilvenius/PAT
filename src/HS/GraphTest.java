package HS;

import java.util.LinkedList;

public class GraphTest {
	
	public static void main(String [] args) {
		
		if (args.length > 0) {
			LinkedList<Vertex<Integer>> l = new LinkedList<Vertex<Integer>>();
			int n = Integer.valueOf(args[0]);
			for (int i = 0; i < n; i++) {
				Vertex<Integer> tmp = new Vertex<Integer>();
				Vertex<Integer> tmp1 = new Vertex<Integer>();
				float w = (float)(10*Math.random());
				tmp.addEdge(tmp1, w);
				tmp1.addEdge(tmp, w);
				l.add(tmp);
				l.add(tmp1);
			}
			
			for (Vertex<Integer> v : l) {
				for (Edge<Integer> e : v.edges) System.out.println(e.weight);
			}
		}
		
	}
	
}
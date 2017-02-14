package HS;

import HS_in.*;

public class AbTree {

	Node root;

	public AbTree(Vertex v) {
		this.root = new AbNode(v);
	}

	public class AbNode implements Node {

		Node parent;
		Vertex element;
		int rank;

		public AbNode() {
			this.element = null;
			this.parent = this;
			this.rank = 0;
		}

		public AbNode(Vertex e) {
			this.element = e;
			this.parent = this;
			this.rank = 0;
		}

		public Vertex getElement() {
			return this.element;
		}

		public Node getParent() {
			return this.parent;
		}
		
		public int getRank() {
			return this.rank;
		}

		public void setElement(Vertex e) {
			this.element = e;
		}

		public void setParent(Node p) {
			this.parent = p;
		}
		
		public void setRank(int r) {
			this.rank = r;
		}

	}
}
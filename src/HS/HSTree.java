package HS;

public class HSTree {

	Node root;

	public HSTree(Vertex v) {
		this.root = new Node(v);
	}

	public class Node implements NodeIn {

		Node parent;
		Vertex element;
		int rank;

		public Node() {
			this.element = null;
			this.parent = this;
			this.rank = 0;
		}

		public Node(Vertex e) {
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

		public void setElement(Vertex e) {
			this.element = e;
		}

		public void setParent(Node p) {
			this.parent = p;
		}	

	}
}
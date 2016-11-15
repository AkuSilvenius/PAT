package HS;

import HS_in.Node;

public class AbTree {

	AbNode root;

	public AbTree(AbVertex v) {
		this.root = new AbNode(v);
	}

	public class AbNode implements Node {

		AbNode parent;
		AbVertex element;
		int rank;

		public AbNode() {
			this.element = null;
			this.parent = this;
			this.rank = 0;
		}

		public AbNode(AbVertex e) {
			this.element = e;
			this.parent = this;
			this.rank = 0;
		}

		public AbVertex getElement() {
			return this.element;
		}

		public AbNode getParent() {
			return this.parent;
		}

		public void setElement(AbVertex e) {
			this.element = e;
		}

		public void setParent(AbNode p) {
			this.parent = p;
		}	

	}
}
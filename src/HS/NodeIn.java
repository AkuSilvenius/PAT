package HS;

import HS.HSTree.Node;

public interface NodeIn {

	Vertex getElement();

	Node getParent();

	void setElement(Vertex e);

	void setParent(Node p);

}
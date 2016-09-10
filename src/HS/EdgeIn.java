package HS;

public interface EdgeIn {

	void setWeight(int w);

	void setLabel(String l);

	void setColor(int clr);

	boolean goesOut(Vertex v);

	float getWeight();

	Vertex getEndPoint();

	String getLabel();

	Vertex getEndPoint(Vertex v);

	Vertex getStartPoint();

	int compareTo(Object o);

}
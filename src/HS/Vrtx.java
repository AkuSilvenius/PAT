package HS;

public interface Vrtx<E> extends Iterable<E> {

	int getColor();

	Edge<E> getEdge(Vrtx<E> v);

	int getIndex();

	String getLabel();

	float getWeight();

	void setColor(int clr);

	void setIndex(int ind);

	void setLabel(String label);

	void setWeight(float w);

	Edge<E> addEdge(Vrtx<E> v);

	Edge<E> addEdge(Vrtx<E> v, float w);

	Edge<E> addEdge(Vrtx<E> v, int clr);

	Edge<E> addEdge(Vrtx<E> v, float w, int clr);
	
	Iterable<E> neighbors();

}
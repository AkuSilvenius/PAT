package HS;

public interface EdgeIn<E> {

	void setWeight(int w);

	float getWeight();

	Vertex<E> getEndPoint();

	Vertex<E> getEndPoint(Vertex<E> v);

	Vertex<E> getStartPoint();

}
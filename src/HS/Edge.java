package HS;

public class Edge extends Object implements Comparable<Object>, EdgeIn {

	Vertex startPoint;
	Vertex endPoint;
	float weight;
	int color;

	public Edge() {
		this.startPoint = null;
		this.endPoint = null;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}

	public Edge(Vertex endpoint) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}

	public Edge(Vertex endpoint, float w) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = HSCol.NaN;
	}

	public Edge(Vertex endpoint, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = clr;
	}

	public Edge(Vertex endpoint, String label) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}
	
	public Edge(Vertex endpoint, float w, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = clr;
	}
	
	public Edge(Vertex endpoint, String label, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = clr;
	}
	
	public Edge(Vertex endpoint, String label, int clr, float w) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = clr;
	}

	public void setWeight(int w) {
		this.weight = w;
	}

	
	public void setColor(int clr) {
		this.color = clr;
	}
	
	public boolean goesOut(Vertex v){
		if(this.getStartPoint().equals(v)) return true;
		
		return false;
	}

	public float getWeight() {
		return this.weight;
	}

	public Vertex getEndPoint() {
		return this.endPoint;
	}
	
	public Vertex getEndPoint(Vertex v) {
		if (!v.equals(this.startPoint)) return null;
		if (v.equals(this.startPoint)) return this.endPoint;
		return this.startPoint;
	}

	public Vertex getStartPoint() {
		return this.startPoint;
	}

	public int compareTo(Object o) {
		return this.compareTo(o);
	}

}
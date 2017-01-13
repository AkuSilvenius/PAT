package HS;

import HS_in.Edge;

public class AbEdge extends Object implements Comparable<AbEdge>, Edge {

	AbVertex startPoint;
	AbVertex endPoint;
	float weight;
	int color;

	public AbEdge() {
		this.startPoint = null;
		this.endPoint = null;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}

	public AbEdge(AbVertex endpoint) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}

	public AbEdge(AbVertex endpoint, float w) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = HSCol.NaN;
	}

	public AbEdge(AbVertex endpoint, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = clr;
	}

	public AbEdge(AbVertex endpoint, String label) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = HSCol.NaN;
	}

	public AbEdge(AbVertex endpoint, float w, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = w;
		this.color = clr;
	}

	public AbEdge(AbVertex endpoint, String label, int clr) {
		this.startPoint = null;
		this.endPoint = endpoint;
		this.weight = Float.NaN;
		this.color = clr;
	}

	public AbEdge(AbVertex endpoint, String label, int clr, float w) {
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

	public boolean goesOut(AbVertex v){
		if(this.getStartPoint().equals(v)) return true;

		return false;
	}

	public float getWeight() {
		return this.weight;
	}

	public AbVertex getEndPoint() {
		return this.endPoint;
	}

	public AbVertex getEndPoint(AbVertex v) {
		if (!v.equals(this.startPoint)) return null;
		if (v.equals(this.startPoint)) return this.endPoint;
		return this.startPoint;
	}

	public AbVertex getStartPoint() {
		return this.startPoint;
	}

	@Override
	public int compareTo(AbEdge e) {
		return Float.compare(this.getWeight(), e.getWeight());
	}

}

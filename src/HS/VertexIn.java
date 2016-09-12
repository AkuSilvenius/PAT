package HS;

import java.util.Iterator;

// attribuutit:
// LinkedList<Edge> edges;
// String label;
// int color;
// int index;
// float weight;

/**
 * Rajapinta solmujen k‰sittelyyn
 * @author Teemu Holttinen
 */
public interface VertexIn {
	
	/**
	 * Palauttaa solmun v‰rin
	 * @return solmun v‰ri
	 * 
	 * @author Teemu Holttinen
	 */
	int getColor();
	
	/**
	 * Palauttaa m‰‰ritellyn solmun kaaren
	 * @param v - Solmu
	 * @return Kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge getEdge(Vertex v);
	
	/**
	 * Palauttaa solmun indeksin
	 * @return indeksi
	 * 
	 * @author Teemu Holttinen
	 */
	int getIndex();
	
	/**
	 * Palauttaa solmun label-tiedon
	 * @return label-tieto
	 * 
	 * @author Teemu Holttinen
	 */
	String getLabel();
	
	/**
	 * Palauttaa solmun painon
	 * @return Solmun paino
	 * 
	 * @author Teemu Holttinen
	 */
	float getWeight();
	
	/**
	 * Asettaa solmulle v‰rin
	 * @param clr - v‰ri
	 * 
	 * @author Teemu Holttinen
	 */
	void setColor(int clr);

	/**
	 * Asettaa solmulle indeksin
	 * @param ind - indeksi
	 * 
	 * @author Teemu Holttinen
	 */
	void setIndex(int ind);
	
	/**
	 * Asettaa solmulle label-tiedon
	 * @param label - label-tieto
	 * 
	 * @author Teemu Holttinen
	 */
	void setLabel(String label);
	
	/**
	 * Asettaa solmulle painon
	 * @param w - paino
	 * 
	 * @author Teemu Holttinen
	 */
	void setWeight(float w);

	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille
	 * @param v - m‰‰ritelty solmu
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v);
	
	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param w - kaaren paino
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v, float w);
	
	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param label - kaaren label-tieto
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v, String label);
	
	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param clr - kaaren v‰ri
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v, int clr);
	
	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param w - kaaren paino
	 * @param clr - kaaren v‰ri
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v, float w, int clr);
	
	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param label - kaaren label-tieto
	 * @param clr - kaaren v‰ri
	 * @return uusi kaari®
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v, String label, int clr);
	
	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param label - kaaren label tieto
	 * @param clr - kaaren v‰ri
	 * @param w - kaaren paino
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	Edge addEdge(Vertex v, String label, int clr, float w);
	
	/**
	 * Poistaa m‰‰ritellyn kaaren t‰st‰ solmusta
	 * @param e - m‰‰ritelty kaari
	 * 
	 * @author Teemu Holttinen
	 */
	void removeEdge(Edge e);
	
	/**
	 * Poistaa kaikki kaaret t‰st‰ solmusta
	 * 
	 * @author Teemu Holttinen
	 */
	void removeEdges();
	
	/**
	 * Palauttaa iterablen t‰m‰n solmun naapureista
	 * @return Iterable solmun naapureista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterable<Vertex> neighbors();
	
	/**
	 * Palauttaa iteraattorin solmun naapureista
	 * @return iteraattori solmun naapureista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterator<Vertex> neighborsIterator();
	
	/**
	 * Palauttaa boolean arvon onko t‰m‰ solmu ja m‰‰ritelty solmu yhdistetty kaarella
	 * @param v - M‰‰ritelty solmu
	 * @return boolean
	 * 
	 * @author Teemu Holttinen
	 */
	boolean isAdjacent(Vertex v);
	
	/**
	 * Palauttaa iteraattorin t‰st‰ solmusta l‰htevist‰ kaarista
	 * @return iteraattori l‰htevist‰ kaarista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterator<Edge> edgeIterator();
	
	/**
	 * Palauttaa iterablen t‰st‰ solmusta l‰htevist‰ kaarista
	 * @return iterable l‰htevist‰ kaarista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterable<Edge> edges();
	
	/**
	 * Palauttaa iteraattorin solmusta l‰htevist‰ kaarista
	 * @return iteraattori l‰htevist‰ kaarista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterator<Edge> iterator();
	
	/**
	 * Solmujen compareTo-metodi
	 * @param o - M‰‰ritelty olio
	 * @return int
	 * 
	 * @author Teemu Holttinen
	 */
	int compareTo(Object o);

}
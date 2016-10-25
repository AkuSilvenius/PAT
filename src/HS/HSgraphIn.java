package HS;

import java.util.Iterator;

// attribuutit:
// LinkedList<Vertex> vlist;
// LinkedList<Edge> elist;
// int size;

/**
 * Rajapinta suunnatun verkon operaatioihin.
 * @author Aku Silvenius
 */
public interface HSgraphIn {

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex();

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(String label);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @param clr - uuden solmun v‰ri
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(int clr, String label);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(int clr);

	/**
	 * Palauttaa verkon solmujen lukum‰‰r‰n.
	 * @return verkon solmujen lukum‰‰r‰
	 * 
	 * @author Aku Silvenius
	 */
	int size();

	/**
	 * Palauttaa Iterable-toteutuksen verkon solmuista.
	 * @return Iterable-toteutus verkon solmuista
	 * 
	 * @author Aku Silvenius
	 */
	Iterable<Vertex> vertices();

	/**
	 * Palauttaa Iterable-toteutuksen verkon kaarista.
	 * @return Iterable-toteutus verkon kaarista
	 * 
	 * @author Aku Silvenius
	 */
	Iterable<Edge> edges();

	/**
	 * Palauttaa verkon ensimm‰isen solmun.
	 * @return verkon ensimm‰inen solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex firstVertex();

	/**
	 * Poistaa verkosta m‰‰ritellyn solmun ja kaikki siihen kytkeytyneet kaaret.
	 * @param v - poistettava solmu
	 * 
	 * @author Aku Silvenius
	 */
	void removeVertex(Vertex v);

	/**
	 * Palauttaa Iteraattorin verkon kaarista.
	 * @return Iterator verkon kaarista
	 * 
	 * @author Aku Silvenius
	 */
	Iterator<Vertex> iterator();

}
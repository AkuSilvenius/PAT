package HS_in;

import java.util.Iterator;
import java.util.LinkedList;

//attribuutit:
//LinkedList<Vertex> vlist;
//LinkedList<Edge> elist;
//int size;

/**
* Rajapinta suunnatun verkon operaatioihin.
* @author Aku Silvenius
*/
public interface Graph {
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(Graph g);
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(Graph g, int clr);
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(Graph g, String label);
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @param label - uuden solmun nimi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(Graph g, int clr, String label);
	
	/**
	 * Palauttaa verkon solmujen lukum‰‰r‰n.
	 * @return verkon solmujen lukum‰‰r‰
	 * 
	 * @author Aku Silvenius
	 */
	int size();
	
	/**
	 * Palauttaa verkon attribuutin elist
	 * eli kaikki verkon kaaret
	 * @return verkon kaaret
	 * 
	 * @author Teemu Holttinen
	 */
	LinkedList<Edge> getEdges();
	
	/**
	 * Palauttaa verkon attribuutin vlist
	 * eli kaikki verkon solmut
	 * @return verkon solmut
	 * 
	 * @author Teemu Holttinen
	 */
	LinkedList<Vertex> getVertices();
	
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
	
	/**
	 * Etsii ja palauttaa minimaalisen viritt‰v‰n puun (Minimum Spanning Tree, MST),
	 * ts. kaarien listan, joka yhdist‰‰ kaikki verkon g
	 * solmut pienimmill‰ mahdollisilla kaarilla. 
	 * @return lista kaarista, joista MST koostuu
	 *
	 * @author Aku Silvenius
	 */
	LinkedList<Edge> MSTKruskal() throws NullPointerException;
}
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
	 * @param lel - uuden solmun nimi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(Graph g, String label);
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @param lel - uuden solmun nimi
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
	
	LinkedList<Edge> getEdges();
	
	LinkedList<Vertex> getVertices();
	
	/**
	 * Palauttaa Iterle-toteutuksen verkon solmuista.
	 * @return Iterle-toteutus verkon solmuista
	 * 
	 * @author Aku Silvenius
	 */
	Iterable<Vertex> vertices();
	
	/**
	 * Palauttaa Iterle-toteutuksen verkon kaarista.
	 * @return Iterle-toteutus verkon kaarista
	 * 
	 * @author Aku Silvenius
	 */
	Iterable<Edge> Edges();
	
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
	
	LinkedList<Edge> MSTKruskal() throws NullPointerException;
}
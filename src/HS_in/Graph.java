package HS_in;

import java.util.Iterator;

import HS.AbEdge;
import HS.AbVertex;

//attribuutit:
//LinkedList<Vertex> vlist;
//LinkedList<AbEdge> elist;
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
	AbVertex addVertex();
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	AbVertex addVertex(int clr);
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	AbVertex addVertex(String label);
	
	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @param label - uuden solmun nimi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	AbVertex addVertex(int clr, String label);
	
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
	Iterable<AbVertex> vertices();
	
	/**
	 * Palauttaa Iterable-toteutuksen verkon kaarista.
	 * @return Iterable-toteutus verkon kaarista
	 * 
	 * @author Aku Silvenius
	 */
	Iterable<AbEdge> abEdges();
	
	/**
	 * Palauttaa verkon ensimm‰isen solmun.
	 * @return verkon ensimm‰inen solmu
	 * 
	 * @author Aku Silvenius
	 */
	AbVertex firstVertex();
	
	/**
	 * Poistaa verkosta m‰‰ritellyn solmun ja kaikki siihen kytkeytyneet kaaret.
	 * @param v - poistettava solmu
	 * 
	 * @author Aku Silvenius
	 */
	void removeVertex(AbVertex v);
	
	/**
	 * Palauttaa Iteraattorin verkon kaarista.
	 * @return Iterator verkon kaarista
	 * 
	 * @author Aku Silvenius
	 */
	Iterator<AbVertex> iterator();
	
}
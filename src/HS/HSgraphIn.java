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
	 * @param ind - uuden solmun indeksi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(int ind);

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
	 * @param w - uuden solmun paino
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(float w);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param w - uuden solmun paino
	 * @param ind - uuden solmun indeksi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(float w, int ind);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @param w - uuden solmun paino
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(int clr, float w);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @param ind - uuden solmun indeksi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(int clr, int ind);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @param ind - uuden solmun indeksi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(String label, int ind);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @param clr - uuden solmun v‰ri
	 * @param w - uuden solmun paino
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(String label, int clr, float w);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param clr - uuden solmun v‰ri
	 * @param w - uuden solmun paino
	 * @param ind - uuden solmun indeksi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(int clr, float w, int ind);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @param clr - uuden solmun v‰ri
	 * @param ind - uuden solmun indeksi
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(String label, int clr, int ind);

	/**
	 * Lis‰‰ verkkoon uuden solmun tarkennetuilla parametreilla.
	 * @param label - uuden solmun nimi
	 * @param clr - uuden solmun v‰ri
	 * @param ind - uuden solmun indeksi
	 * @param w - uuden solmun paino
	 * @return uusi solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex addVertex(String label, int clr, int ind, float w);

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
	 * Palauttaa Iteraattorin verkon solmuista.
	 * @return Iterator verkon solmuista
	 * 
	 * @author Aku Silvenius
	 */
	Iterator<Vertex> vertexIterator();

	/**
	 * Palauttaa Iteraattorin verkon kaarista.
	 * @return Iterator verkon kaarista
	 * 
	 * @author Aku Silvenius
	 */
	Iterator<Edge> edgeIterator();

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
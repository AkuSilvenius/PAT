package HS;

import HS.HSTree.Node;

// attribuutit:
// Node parent;
// Vertex element;
// int rank;

/**
 * Rajapinta pistevieraiden joukkojen puutoteutuksen solmujen operaatioihin.
 * HUOM. Node-luokka on HSTree-luokan sisäluokka: HSTree-luokalla on vain konstruktori -> ei rajapintaa.
 * @author Aku Silvenius
 */
public interface NodeIn {

	/**
	 * Palauttaa solmun sisältämän verkkosolmun.
	 * @return verkon solmu
	 * 
	 * @author Aku Silvenius
	 */
	Vertex getElement();
	/**
	 * Palauttaa puun solmun parent-muuttujan.
	 * @return puun solmu
	 * 
	 * @author Aku Silvenius
	 */
	Node getParent();

	/**
	 * Asettaa puun solmulle element-muuttujaksi parametrina saadun verkon solmun.
	 * @param e - puun solmulle osoitettava elementti.
	 * 
	 * @author Aku Silvenius
	 */
	void setElement(Vertex e);

	/**
	 * Asettaa puun solmun parent-muuttujaksi parametrina annetun puun solmun.
	 * @param p - puun solmu
	 * 
	 * @author Aku Silvenius
	 */
	void setParent(Node p);

}
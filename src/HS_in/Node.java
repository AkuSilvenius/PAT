package HS_in;

//attribuutit:
//Node parent;
//Vertex element;
//int rank;

/**
* Rajapinta pistevieraiden joukkojen puutoteutuksen solmujen operaatioihin.
* HUOM. AbNode on AbTree-luokan sisäluokka: AbTree-luokalla on vain konstruktori -> ei rajapintaa.
* @author Aku Silvenius
*/
public interface Node {

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
	 * Palauttaa puun solmun rank-muuttujan.
	 * @return rank
	 * 
	 * @author Aku Silvenius
	 */
	int getRank();

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
	
	/**
	 * Asettaa uuden arvon puun solmun rank-muuttujalle.
	 * @param r - uusi rank-arvo
	 * 
	 * @author Aku Silvenius
	 */
	void setRank(int r);

}
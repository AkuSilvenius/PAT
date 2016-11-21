package HS_in;

import java.util.Iterator;

import HS.AbEdge;
import HS.AbVertex;

//attribuutit:
//LinkedList<AbEdge> abEdges;
//String label;
//int color;
//int index;
//float weight;

/**
* Rajapinta solmujen k‰sittelyyn
* @author Teemu Holttinen
*/
public interface Vertex {

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
	AbEdge getEdge(AbVertex v);

	/**
	 * Palauttaa solmun label-tiedon
	 * @return label-tieto
	 * 
	 * @author Teemu Holttinen
	 */
	String getLabel();

	/**
	 * Asettaa solmulle v‰rin
	 * @param clr - v‰ri
	 * 
	 * @author Teemu Holttinen
	 */
	void setColor(int clr);

	
	void setLabel(String label);

	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille
	 * @param v - m‰‰ritelty solmu
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	AbEdge addEdge(AbVertex v);

	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param w - kaaren paino
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	AbEdge addEdge(AbVertex v, float w);

	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param clr - kaaren v‰ri
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	AbEdge addEdge(AbVertex v, int clr);

	/**
	 * Lis‰‰ kaaren t‰m‰n solmun ja m‰‰ritetyn solmun v‰lille lis‰tiedoilla
	 * @param v - m‰‰ritelty solmu
	 * @param w - kaaren paino
	 * @param clr - kaaren v‰ri
	 * @return uusi kaari
	 * 
	 * @author Teemu Holttinen
	 */
	AbEdge addEdge(AbVertex v, float w, int clr);

	/**
	 * Poistaa m‰‰ritellyn kaaren t‰st‰ solmusta
	 * @param e - m‰‰ritelty kaari
	 * 
	 * @author Teemu Holttinen
	 */
	void removeEdge(AbEdge e);

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
	Iterable<AbVertex> neighbors();

	/**
	 * Palauttaa boolean arvon onko t‰m‰ solmu ja m‰‰ritelty solmu yhdistetty kaarella
	 * @param v - M‰‰ritelty solmu
	 * @return boolean
	 * 
	 * @author Teemu Holttinen
	 */
	boolean isAdjacent(AbVertex v);

	/**
	 * Palauttaa iterablen t‰st‰ solmusta l‰htevist‰ kaarista
	 * @return iterable l‰htevist‰ kaarista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterable<AbEdge> abEdges();

	/**
	 * Palauttaa iteraattorin solmusta l‰htevist‰ kaarista
	 * @return iteraattori l‰htevist‰ kaarista
	 * 
	 * @author Teemu Holttinen
	 */
	Iterator<AbEdge> iterator();

	/**
	 * Solmujen compareTo-metodi
	 * @param o - M‰‰ritelty olio
	 * @return int
	 * 
	 * @author Teemu Holttinen
	 */
	int compareTo(Object o);

}
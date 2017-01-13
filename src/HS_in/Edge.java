package HS_in;

import HS.AbVertex;
import HS.AbEdge;

//attribuutit:
//Vertex startPoint;
//Vertex endPoint;
//String label;
//float weight;
//int color;

/**
* Rajapinta kaarien käsittelyyn
* @author Teemu Holttinen
*/
public interface Edge {

	/**
	 * Kaaren painon määrittäminen
	 * @param w - kaaren paino
	 *
	 * @author Teemu Holttinen
	 */
	void setWeight(int w);

	/**
	 * Kaaren värin määrittäminen
	 * @param clr - väri
	 *
	 * @author Teemu Holttinen
	 */
	void setColor(int clr);

	/**
	 * Palauttaa totuusarvon onko solmu v kaaren lähtösolmu
	 * @param v - Tarkasteltava solmu
	 * @return boolean
	 *
	 * @author Teemu Holttinen
	 */
	boolean goesOut(AbVertex v);

	/**
	 * Palauttaa kaaren painon
	 * @return kaaren paino
	 *
	 * @author Teemu Holttinen
	 */
	float getWeight();

	/**
	 * Palauttaa kaaren loppusolmun
	 * @return kaaren loppusolmu
	 *
	 * @author Teemu Holttinen
	 */
	AbVertex getEndPoint();

	/**
	 * Palauttaa kaaren loppusolmun tai null, jos kaarta ei ole
	 * @param Vertex v
	 * @return Loppusolmu tai null, jos kaarta ei ole
	 *
	 * @author Teemu Holttinen
	 */
	AbVertex getEndPoint(AbVertex v);

	/**
	 * Palauttaa kaaren lähtösomun
	 * @return Kaaren lähtösolmu
	 *
	 * @author Teemu Holttinen
	 */
	AbVertex getStartPoint();

	/**
	 * compareTo -metodi kaarten vertaamiseen
	 * @param e - vertailun kohteena oleva kaari
	 * @return int
	 *
	 * @author Teemu Holttinen
	 */
	int compareTo(AbEdge e);

}

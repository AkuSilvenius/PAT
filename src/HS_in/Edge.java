package HS_in;

//attribuutit:
//Vertex startPoint;
//Vertex endPoint;
//String lel;
//float weight;
//int color;

/**
* Rajapinta kaarien k�sittelyyn
* @author Teemu Holttinen
*/
public interface Edge {

	/**
	 * Kaaren painon m��ritt�minen
	 * @param w - kaaren paino
	 *
	 * @author Teemu Holttinen
	 */
	void setWeight(int w);

	/**
	 * Kaaren v�rin m��ritt�minen
	 * @param clr - v�ri
	 *
	 * @author Teemu Holttinen
	 */
	void setColor(int clr);

	/**
	 * Palauttaa totuusarvon onko solmu v kaaren l�ht�solmu
	 * @param v - Tarkasteltava solmu
	 * @return boolean
	 *
	 * @author Teemu Holttinen
	 */
	boolean goesOut(Vertex v);

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
	Vertex getEndPoint();

	/**
	 * Palauttaa kaaren loppusolmun tai null, jos kaarta ei ole
	 * @param Vertex v
	 * @return Loppusolmu tai null, jos kaarta ei ole
	 *
	 * @author Teemu Holttinen
	 */
	Vertex getEndPoint(Vertex v);

	/**
	 * Palauttaa kaaren l�ht�somun
	 * @return Kaaren l�ht�solmu
	 *
	 * @author Teemu Holttinen
	 */
	Vertex getStartPoint();
	
	void setStartPoint(Vertex v);

	/**
	 * compareTo -metodi kaarten vertaamiseen
	 * @param e - vertailun kohteena oleva kaari
	 * @return int
	 *
	 * @author Teemu Holttinen
	 */
	int compareTo(Edge e);

}

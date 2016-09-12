package HS;

/**
 * Rajapinta kaarien käsittelyyn
 * 
 * @author Teemu Holttinen
 *
 */

public interface EdgeIn {
	
	/**
	 * Kaaren painon määrittäminen
	 * @param w - kaaren paino
	 * 
	 * @author Teemu Holttinen
	 */
	void setWeight(int w);
	
	/**
	 * Kaaren label-tiedon määrittäminen
	 * @param l - kaaren label-tieto
	 * 
	 * @author Teemu Holttinen
	 */
	void setLabel(String l);
	
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
	 * Palauttaa kaaren label-tiedon
	 * @return kaaren label-tieto
	 * 
	 * @author Teemu Holttinen
	 */
	String getLabel();
	
	
	/**
	 * Palauttaa kaaren loppusolmun tai null, jos kaarta ei ole
	 * @param Vertex v
	 * @return Loppusolmu tai null, jos kaarta ei ole
	 * 
	 * @author Teemu Holttinen
	 */
	Vertex getEndPoint(Vertex v);
	
	/**
	 * Palauttaa kaaren lähtösomun
	 * @return Kaaren lähtösolmu
	 * 
	 * @author Teemu Holttinen
	 */
	Vertex getStartPoint();
	
	
	/**
	 * compareTo -metodi kaarten vertaamiseen
	 * @param o - määritelty olio
	 * @return int
	 * 
	 * @author Teemu Holttinen
	 */
	int compareTo(Object o);

}
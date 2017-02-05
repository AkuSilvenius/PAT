package HS_in;

import HS.AbVertex;
import HS.AbTree.AbNode;

//attribuutit:
//LinkedList<HSTree> forest;

/**
* Rajapinta pistevieraiden joukkojen operaatioihin.
* @author Aku Silvenius
*/
public interface MFSet {

	/**
	 * Luo uuden joukon (puun) verkon solmulle v.
	 * @param v - verkon solmu joka asetetaan uuden puun juureksi
	 * @return true kun operaatio suoritettu
	 * 
	 * @author Aku Silvenius
	 */
	boolean makeSet(AbVertex v);

	/**
	 * Etsii ja palauttaa joukon (puun) juurisolmun. Samalla
	 * rekursiivinen parent-linkin päivitys juurisolmuun.
	 * @param n - puun solmu, jonka juuri halutaan löytää
	 * @return arametrina saadun solmun puun juurisolmun
	 * 
	 * @author Aku Silvenius
	 */
	AbNode findSet(AbNode n);

	/**
	 * Kuorrutusmetodi kahden solmun yhdistämiselle. Etsii parametreina saatujen
	 * solmujen puiden juurisolmut. Kutsuu link()-metodia parametrinaan löydetyt juurisolmut.
	 * @param x - puun solmu
	 * @param y - puun solmu
	 * 
	 * @author Aku Silvenius
	 */
	void union(AbNode x, AbNode y);

	/**
	 * Yhdistää kaksi joukkoa (puuta) toisiinsa, ts. päivittää toisen puun juuri
	 * solmun parent-linkin osoittamaan toisen puun juurisolmuun. Parent-linkin valintaan
	 * käytetään juurisolmujen rank-lukua.
	 * @param x - puun juurisolmu
	 * @param y - puun juurisolmu
	 * 
	 * @author Aku Silvenius
	 */
	void link(AbNode x, AbNode y);

}
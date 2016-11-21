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
	 * rekursiivinen parent-linkin p�ivitys juurisolmuun.
	 * @param n - puun solmu, jonka juuri halutaan l�yt��
	 * @return arametrina saadun solmun puun juurisolmun
	 * 
	 * @author Aku Silvenius
	 */
	AbNode findSet(AbNode n);

	/**
	 * Kuorrutusmetodi kahden solmun yhdist�miselle. Etsii parametreina saatujen
	 * solmujen puiden juurisolmut. Kutsuu link()-metodia parametrinaan l�ydetyt juurisolmut.
	 * @param x - puun solmu
	 * @param y - puun solmu
	 * 
	 * @author Aku Silvenius
	 */
	void union(AbNode x, AbNode y);

	/**
	 * Yhdist�� kaksi joukkoa (puuta) toisiinsa, ts. p�ivitt�� toisen puun juuri
	 * solmun parent-linkin osoittamaan toisen puun juurisolmuun. Parent-linkin valintaan
	 * k�ytet��n juurisolmujen rank-lukua.
	 * @param x - puun juurisolmu
	 * @param y - puun juurisolmu
	 * 
	 * @author Aku Silvenius
	 */
	void link(AbNode x, AbNode y);

}
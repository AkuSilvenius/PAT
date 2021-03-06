package HS_in;

import java.util.LinkedList;
import HS.AbTree;

//attribuutit:
//LinkedList<AbTree> forest;

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
	boolean makeSet(Vertex v);

	/**
	 * Etsii ja palauttaa joukon (puun) juurisolmun. Samalla
	 * rekursiivinen parent-linkin p�ivitys juurisolmuun.
	 * @param n - puun solmu, jonka juuri halutaan l�yt��
	 * @return parametrina saadun solmun puun juurisolmu
	 * 
	 * @author Aku Silvenius
	 */
	Node findSet(Node n);

	/**
	 * Kuorrutusmetodi kahden solmun yhdist�miselle. Etsii parametreina saatujen
	 * solmujen puiden juurisolmut. Kutsuu link()-metodia parametrinaan l�ydetyt juurisolmut.
	 * @param x - puun solmu
	 * @param y - puun solmu
	 * 
	 * @author Aku Silvenius
	 */
	void union(Node x, Node y);

	/**
	 * Yhdist�� kaksi joukkoa (puuta) toisiinsa, ts. p�ivitt�� toisen puun juuri
	 * solmun parent-linkin osoittamaan toisen puun juurisolmuun. Parent-linkin valintaan
	 * k�ytet��n juurisolmujen rank-lukua.
	 * @param x - puun juurisolmu
	 * @param y - puun juurisolmu
	 * 
	 * @author Aku Silvenius
	 */
	void link(Node x, Node y);
	
	/**
	 * Palauttaa t�m�n joukon forest-attribuutin
	 * @return forest
	 * 
	 * @author Aku Silvenius
	 */
	LinkedList<AbTree> getForest();

}
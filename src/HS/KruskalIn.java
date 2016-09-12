package HS;

import java.util.LinkedList;

/**
 * Rajapinta Kruskalin algoritmille.
 * @author Aku Silvenius
 */
public interface KruskalIn {

	/**
	 * Etsii ja palauttaa minimaalisen viritt�v�n puun (Minimum Spanning Tree, MST),
	 * ts. kaarien listan, joka yhdist�� kaikki verkon g
	 * solmut pienimmill� mahdollisilla kaarilla.
	 * @param g - verkko, jolle MST halutaan l�yt��
	 * @return lista kaarista, joista MST koostuu
	 */
	LinkedList<Edge> MSTKruskal(HSgraph g);

}
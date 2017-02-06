package HS_in;

import java.util.LinkedList;

import HS.AbEdge;
import HS.AbGraph;

/**
 * Rajapinta Kruskalin algoritmille.
 * @author Aku Silvenius
 */
public interface Kruskal {

	/**
	 * Etsii ja palauttaa minimaalisen viritt�v�n puun (Minimum Spanning Tree, MST),
	 * ts. kaarien listan, joka yhdist�� kaikki verkon g
	 * solmut pienimmill� mahdollisilla kaarilla.
	 * @param g - verkko, jolle MST halutaan l�yt��
	 * @return lista kaarista, joista MST koostuu
	 *
	 * @author Aku Silvenius
	 */
	LinkedList<AbEdge> MSTKruskal(AbGraph g) throws NullPointerException;

}

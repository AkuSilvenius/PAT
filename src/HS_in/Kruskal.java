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
	 * Etsii ja palauttaa minimaalisen virittävän puun (Minimum Spanning Tree, MST),
	 * ts. kaarien listan, joka yhdistää kaikki verkon g
	 * solmut pienimmillä mahdollisilla kaarilla.
	 * @param g - verkko, jolle MST halutaan löytää
	 * @return lista kaarista, joista MST koostuu
	 * 
	 * @author Aku Silvenius
	 */
	LinkedList<AbEdge> MSTKruskal(AbGraph g);

}
package HS;

import java.util.LinkedList;

/**
 * Rajapinta Kruskalin algoritmille.
 * @author Aku Silvenius
 */
public interface KruskalIn {

	/**
	 * Etsii ja palauttaa minimaalisen virittävän puun (Minimum Spanning Tree, MST),
	 * ts. kaarien listan, joka yhdistää kaikki verkon g
	 * solmut pienimmillä mahdollisilla kaarilla.
	 * @param g - verkko, jolle MST halutaan löytää
	 * @return lista kaarista, joista MST koostuu
	 */
	LinkedList<Edge> MSTKruskal(HSgraph g);

}
package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.*;
import HS.*;

@SuppressWarnings("serial")
public class Christofides extends JFrame {

	AbGraph g;
	JPanel ylapan;
	JPanel alapan;

	JLabel t;

	JTextField k1;
	JTextField k2;
	JTextField matka;

	JButton lisaa;
	JButton tyh;
	JButton kruskal;

	Kuuntelija k;

	public Christofides() {

		g = new AbGraph();

		ylapan = new JPanel();
		ylapan.setSize(400,150);
		ylapan.setLayout(new BorderLayout());
		alapan = new JPanel();
		alapan.setSize(400,50);
		alapan.setLayout(new BorderLayout());

		k = new Kuuntelija();
		t = new JLabel("Tila");

		k1 = new JTextField("",10);
		k2 = new JTextField("",10);
		matka = new JTextField("",10);

		lisaa = new JButton("Lis‰‰");
		lisaa.addActionListener(k);
		kruskal = new JButton("Laske Kruskal");
		kruskal.addActionListener(k);
		tyh = new JButton("Tyhjenn‰ kaikki");
		tyh.addActionListener(k);

		ylapan.add(k1, BorderLayout.LINE_START);
		ylapan.add(matka, BorderLayout.CENTER);
		ylapan.add(k2, BorderLayout.LINE_END);
		ylapan.add(lisaa, BorderLayout.PAGE_END);
		ylapan.add(tyh, BorderLayout.PAGE_START);
		alapan.add(kruskal, BorderLayout.PAGE_START);
		alapan.add(t, BorderLayout.PAGE_END);

		this.add(Box.createRigidArea(new Dimension(0, 1)));
		this.add(ylapan, BorderLayout.NORTH);
		this.add(alapan, BorderLayout.SOUTH);
		this.setSize(ylapan.getWidth(), ylapan.getHeight()+alapan.getHeight());

		this.setTitle("Verkko");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public class Kuuntelija extends AbKruskal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tyh) {
				k1.setText("");
				k2.setText("");
				matka.setText("");
			}
			if (e.getSource() == lisaa) {
				try {
					int dist = Integer.parseInt(matka.getText());
					String t1 = k1.getText().toLowerCase();
					String t2 = k2.getText().toLowerCase();
					tarkistaK(dist,t1,t2);
				} catch (NumberFormatException n) {
					t.setText("Virheellinen matka");
				}
			}

			if (e.getSource() == kruskal) {
				t.setText("Lasketaan...");
				LinkedList<AbEdge> a = christofides(g);
//				System.out.println(a.size());
				Object opt[] = {"Sulje"};
				String viesti = tulosviesti(a);

				System.out.println(viesti);
				JOptionPane.showOptionDialog(
						null,
						viesti,
						"Christofides",
						JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.PLAIN_MESSAGE,
						null,
						opt,
						opt[0]);
				t.setText("Tila");

			}
		}

		private String tulosviesti(LinkedList<AbEdge> a) {
			System.out.println(a);
			String tmp = "Kauppamatkaajan reitti:\n";
//			String s = a.getFirst().getStartPoint().getLabel() + "->" + a.getFirst().getEndPoint().getLabel()+"|";

//			tmp += s;
			String s;
			for (AbEdge e : a) {
				s = e.getEndPoint().getLabel() + " "+e.getWeight()+" " + e.getStartPoint().getLabel()+"|";
				tmp += s;
			}
			return tmp;
		}

		private LinkedList<AbEdge> christofides(AbGraph g) {
			LinkedList<AbEdge> tmp = MSTKruskal(g);
//			System.out.println(tmp.size());
			//EulerTour(tmp);
			//Shortcuts(tmp);
			return tmp;
		}

		private void Shortcuts(LinkedList<AbEdge> tmp) {

		}

		private void EulerTour(LinkedList<AbEdge> tmp) {
			HashMap<AbVertex, Boolean> oddNodes = new HashMap<AbVertex, Boolean>();
			// OddNodes: etsit‰‰n solmut, joilla pariton m‰‰r‰ kaaria
			for (AbEdge e : tmp) {
				oddNodes.put(e.getStartPoint(), false);
				oddNodes.put(e.getEndPoint(), false);
			}
			for (AbEdge e : tmp) {
				if (e.getStartPoint().edges.size() % 2 != 0) oddNodes.replace(e.getStartPoint(), true);
				if (e.getEndPoint().edges.size() % 2 != 0) oddNodes.replace(e.getEndPoint(), true);
			}

			// Perfect Match: lis‰t‰‰n kaaret, joilla parittomuus poistetaan
			for (Map.Entry<AbVertex, Boolean> b : oddNodes.entrySet()) {
				if (b.getValue() == true) {
					// lis‰t‰‰n t‰ydennyskaari; valitaan sellainen kaari, joka
					// on jo verkossa ja mahdollisimman lyhyt (molempien kaaren p‰iden oltava odd)
					AbVertex v = b.getKey();
					AbEdge min = v.edges.getFirst();
					for (AbEdge e : v.edges)
						if (e.getWeight() < min.getWeight() && e.getEndPoint().edges.size() % 2 != 0) min = e;
					tmp.add(v.addEdge(g, min.getEndPoint(), min.getWeight()));
//					System.out.println(tmp.size());
				}
			}

		}

		public void tarkistaK(float dist, String t1, String t2) {

			if (t1.equals(t2)) {
				t.setText("Sama l‰htˆ-/p‰‰tekaupunki");
				return;
			}

			boolean a = false;
			boolean b = false;
			AbVertex vx = null;
			AbVertex ve = null;
			for (AbVertex v : g.vertices()) {
				if (v.getLabel().equals(t1)) {
					a = true;
					vx = v;
				}
				if (v.getLabel().equals(t2)) {
					b = true;
					ve = v;
				}
			}

			if (a && b) {
				if (vx.isAdjacent(ve)) {
					t.setText("T‰m‰ tieto on jo lis‰tty.");
					return;
				}
				ve.addEdge(g, vx, dist);
				//vx.addEdge(g, ve, dist);

			} else if (a) {
				ve = g.addVertex(g, t2);
				ve.addEdge(g, vx, dist);
				//vx.addEdge(g, ve, dist);
				t.setText("Tiedot lis‰tty.");
			} else if (b) {
				vx = g.addVertex(g, t1);
				vx.addEdge(g, ve, dist);
				//ve.addEdge(g, vx, dist);
				t.setText("Tiedot lis‰tty.");
			} else {
				ve = g.addVertex(g, t2);
				vx = g.addVertex(g, t1);
				ve.addEdge(g, vx, dist);
				//vx.addEdge(g, ve, dist);
				t.setText("Tiedot lis‰tty.");
			}

			System.out.println("g.size"+g.size());

		}

	}

	public static void main(String [] args) {
		new Christofides();
	}

}

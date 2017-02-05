package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.*;
import HS.*;

@SuppressWarnings("serial")
public class GraphTest extends JFrame {

	private final static String FILENAME = "";

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
	JButton tulostus;

	Kuuntelija k;

	public GraphTest() {
		
		
		
		g = new AbGraph();

		ylapan = new JPanel();
		ylapan.setSize(400, 150);
		ylapan.setLayout(new BorderLayout());
		alapan = new JPanel();
		alapan.setSize(400, 50);
		alapan.setLayout(new BorderLayout());

		k = new Kuuntelija();
		t = new JLabel("Tila");

		k1 = new JTextField("", 10);
		k2 = new JTextField("", 10);
		matka = new JTextField("", 10);

		lisaa = new JButton("Lisää");
		lisaa.addActionListener(k);
		kruskal = new JButton("Laske Kruskal");
		kruskal.addActionListener(k);
		tyh = new JButton("Tyhjennä kaikki");
		tyh.addActionListener(k);
		tulostus = new JButton("Tulosta verkko");
		tulostus.addActionListener(k);

		ylapan.add(k1, BorderLayout.LINE_START);
		ylapan.add(matka, BorderLayout.CENTER);
		ylapan.add(k2, BorderLayout.LINE_END);
		ylapan.add(lisaa, BorderLayout.PAGE_END);
		ylapan.add(tyh, BorderLayout.PAGE_START);
		alapan.add(kruskal, BorderLayout.PAGE_START);
		alapan.add(tulostus, BorderLayout.CENTER);
		alapan.add(t, BorderLayout.PAGE_END);

		this.add(Box.createRigidArea(new Dimension(0, 1)));
		this.add(ylapan, BorderLayout.NORTH);
		this.add(alapan, BorderLayout.SOUTH);
		this.setSize(ylapan.getWidth(), ylapan.getHeight() + alapan.getHeight());

		this.setTitle("Verkko");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	} // this

	public class Kuuntelija extends AbKruskal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tulostus)
				tulosta(g);
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
					tarkistaK(dist, t1, t2);
				} catch (NumberFormatException n) {
					t.setText("Virheellinen matka");
				}
			}

			if (e.getSource() == kruskal) {
				t.setText("Lasketaan...");
				LinkedList<AbEdge> a = MST(g);
				Object opt[] = { "Sulje" };
				String viesti = tulosviesti(a);
				t.setText("Kruskal laskettu");

				JOptionPane.showOptionDialog(null, viesti, "GraphTest", JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.PLAIN_MESSAGE, null, opt, opt[0]);

			}
		} // actionPerformed

		private String tulosviesti(LinkedList<AbEdge> a) {
			String tmp = "MST:\n";
			String s;
			for (AbEdge e : a) {
				s = e.getStartPoint().getLabel() + "--{ " + e.getWeight() + " }--" + e.getEndPoint().getLabel();
				tmp += s + "\n";
			}
			return tmp;
		} // tulosviesti

		private LinkedList<AbEdge> MST(AbGraph g) {
			LinkedList<AbEdge> tmp = MSTKruskal(g);
			return tmp;
		}

		public void tarkistaK(float dist, String t1, String t2) {

			if (t1.length() == 0 || t2.length() == 0) {
				t.setText("Tyhjä syöte.");
				return;
			}
			if (t1.equals(t2)) {
				t.setText("Sama lähtö-/päätekaupunki");
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
					t.setText("Välillä " + vx.getLabel() + "-" + ve.getLabel() + " on jo yhteys.");
					return;
				} else {
					ve.addEdge(g, vx, dist);
					vx.addEdge(g, ve, dist);
					t.setText("Lisättiin " + ve.getLabel() + " <-(" + dist + ")-> " + vx.getLabel());
				}

			} else if (a) {
				ve = g.addVertex(g, t2);
				ve.addEdge(g, vx, dist);
				vx.addEdge(g, ve, dist);
				t.setText("Lisättiin " + ve.getLabel() + " <-(" + dist + ")-> " + vx.getLabel());
			} else if (b) {
				vx = g.addVertex(g, t1);
				vx.addEdge(g, ve, dist);
				ve.addEdge(g, vx, dist);
				t.setText("Lisättiin " + vx.getLabel() + " <-(" + dist + ")-> " + ve.getLabel());
			} else {
				ve = g.addVertex(g, t2);
				vx = g.addVertex(g, t1);
				ve.addEdge(g, vx, dist);
				vx.addEdge(g, ve, dist);
				t.setText("Lisättiin " + ve.getLabel() + " <-(" + dist + ")-> " + vx.getLabel());
			}

			System.out.println("g.size: " + g.size());

		} // tarkistaK

		public void readFile(String filename) {

			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

				String rivi;
				String lsolmu;
				String psolmu;
				float paino;

				while ((rivi = br.readLine()) != null) {
					
					try {
						lsolmu = rivi.split("-")[0];
						paino = Float.parseFloat(rivi.split("-")[1]);
						psolmu = rivi.split("-")[2];

						System.out.println("Lähtösolmu " + lsolmu + " paino " + paino + " päätesolmu " + psolmu);

						tarkistaK(paino, lsolmu, psolmu);
						
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public void tulosta(AbGraph g) {
			System.out.println("VERKON TULOSTUS");
			for (AbVertex v : g.vertices()) {
				System.out.print("[" + v.getLabel() + "]: ");
				for (AbEdge e : v.edges()) {
					System.out.print("[(" + e.getWeight() + ") " + e.getEndPoint().getLabel() + "]; ");
				}
				System.out.print("\n");
			}
			System.out.println("----------");
			System.out.println();
			t.setText("Verkko tulostettu konsoliin.");
		} // tulosta

	} // Kuuntelija

	public static void main(String[] args) {

		new GraphTest();
	}

} // GraphTest

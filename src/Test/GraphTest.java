package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import HS.AbGraph;
import HS_in.*;

/**
 * Testiohjelma parityön verkon testaamista varten.
 * @author Teemu Holttinen, Aku Silvenius
 */
@SuppressWarnings("serial")
public class GraphTest extends JFrame {

	Graph g;
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
	JButton luetied;

	Kuuntelija k;

	/**
	 * Testiohjelman (käyttöliittymän) konstruktori.
	 * @author Aku Silvenius
	 */
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
		kruskal = new JButton("Kruskal");
		kruskal.addActionListener(k);
		tyh = new JButton("Tyhjennä kaikki");
		tyh.addActionListener(k);
		tulostus = new JButton("Tulosta");
		tulostus.addActionListener(k);
		luetied = new JButton("Lue tiedostosta");
		luetied.addActionListener(k);

		ylapan.add(k1, BorderLayout.LINE_START);
		ylapan.add(matka, BorderLayout.CENTER);
		ylapan.add(k2, BorderLayout.LINE_END);
		ylapan.add(lisaa, BorderLayout.PAGE_END);
		ylapan.add(tyh, BorderLayout.PAGE_START);
		alapan.add(luetied, BorderLayout.CENTER);
		alapan.add(kruskal, BorderLayout.LINE_START);
		alapan.add(tulostus, BorderLayout.LINE_END);
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

	} //this

	/**
	 * Testiohjelman käyttöliittymän tapahtumien kuuntelija.
	 * Kuuntelee käyttöliittymässä tapahtuvia tapahtumia.
	 * @author Aku Silvenius
	 */
	public class Kuuntelija implements ActionListener {

		/**
		 * Ottaa vastaan tapahtuman (ActionEvent)
		 * @param e - tapahtuma
		 * @author Aku Silvenius
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == luetied)
				try {
					readFile(getFile());
				} catch (IOException i) {
					System.out.println("Tiedostonluku keskeytetty.");
				}

			if (e.getSource() == tulostus) tulosta(g);

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
				String viesti;

				try {
					t.setText("Lasketaan...");
					LinkedList<Edge> a = g.MSTKruskal();
					viesti = tulosviesti(a);
					t.setText("Kruskal laskettu");
				} catch (NullPointerException n) {
					viesti = "Kruskalia ei voitu laskea (syynä voi olla esim. verkon epäyhtenäisyys).";
					t.setText("Kruskal keskeytetty");
				}

				Object opt[] = { "Sulje" };
				JOptionPane.showOptionDialog(null, viesti, "GraphTest", JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.PLAIN_MESSAGE, null, opt, opt[0]);

			}
		} //actionPerformed

		/**
		 * Tiedostonhaku-/valintaikkunan avaava metodi
		 * valmiin verkon lukemista varten.
		 * @return Valitun tiedoston polku tai tyhjä merkkijono
		 * @author Aku Silvenius
		 */
		private String getFile() throws IOException {
			final JFileChooser fc = new JFileChooser();
			int ret = fc.showOpenDialog(alapan);
			if (ret == 1) {
				t.setText("Tiedostonluku keskeytetty.");
				return "";
			} else {
				if (fc.getSelectedFile().getName().equals("US_Cities.txt")) return generateFile(fc.getSelectedFile().getPath());
				else return fc.getSelectedFile().getPath();
			}
		} //getFile

		/**
		 * Luo satunnaisen verkon tiedostosta 'US_Cities.txt'
		 * @param f - tiedosto josta verkko generoidaan (US_Cities.txt)
		 * @return Generoidun verkon (.txt) polku
		 *
		 * @author Aku Silvenius
		 */
		public String generateFile(String f) {
			try {

				String l;
				ArrayList<String> cities = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new FileReader(f));

				// luetaan nimet .txt -> ArrayList
				while ((l = br.readLine()) != null) {
					cities.add(l);
				}

				System.out.println("Luettiin " + cities.size() + " kaupunkia");

				File tmp = new File("generatedGraph.txt");
				PrintWriter w = new PrintWriter(tmp, "UTF-8");
				w.println("PAT");

				// random luku väliltä 25-50
				int rand = ThreadLocalRandom.current().nextInt(25,51);
				int r1,r2,d;

				// kirjoitetaan rand määrä yhteyksiä pieneltä pätkältä ArrayListiä satunnaisilla etäisyyksillä
				for (int x = 0; x < rand; x++) {
					r1 = ThreadLocalRandom.current().nextInt(rand, rand*rand);
					r2 = ThreadLocalRandom.current().nextInt(rand, rand*rand);
					d = ThreadLocalRandom.current().nextInt(0, 1000);
					w.println(cities.get(r1) + "-" + d + "-" + cities.get(r2));
				}

				br.close();
				w.close();

				System.out.println("Luotiin " + rand + " satunnaista yhteyttä");

				return tmp.getPath();

			} catch (Exception e) {
				e.printStackTrace();
				return f;
			}
		} //generateFile

		/**
		 * Luo tulosviestin MST-listan perusteella.
		 * @param a - MST:n sisältävä LinkedList
		 * @return tulosviesti
		 * @author Aku Silvenius
		 */
		private String tulosviesti(LinkedList<Edge> a) {
			String tmp = "MST:\n";
			String s;
			for (Edge e : a) {
				s = e.getStartPoint().getLabel() + "--{ " + e.getWeight() + " }--" + e.getEndPoint().getLabel();
				tmp += s + "\n";
			}
			return tmp;
		} //tulosviesti

		/**
		 * Tarkistaa ja ehtojen täyttyessä lisää verkkoon
		 * käyttöliittymästä saadut tiedot.
		 * @param dist - kahden solmun välinen etäisyys
		 * @param t1 - lähtösolmu
		 * @param t2 - päätesolmu
		 * @author Teemu Holttinen
		 */
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
			Vertex vx = null;
			Vertex ve = null;
			for (Vertex v : g.vertices()) {
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

			// Allaolevan kommenttimerkkien poistaminen: verkon koko kunkin tarkistuksen ja mahd. lisäysten jälkeen
			// System.out.println("g.size: " + g.size());

		} //tarkistaK

		/**
		 * Lukee valitun tiedoston ja lisää sisällön verkkoon.
		 * @param filename - valitun tiedoston polku
		 * @author Teemu Holttinen
		 */
		public void readFile(String filename) {

			System.out.println(filename);

			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

				String rivi;
				String lsolmu;
				String psolmu;
				float paino;

				if (filename.substring(filename.length()-4).equals(".txt") && br.readLine().equals("PAT")) {
					while ((rivi = br.readLine()) != null && rivi.length()>4) {

						try {
							lsolmu = rivi.split("-")[0];
							paino = Float.parseFloat(rivi.split("-")[1]);
							psolmu = rivi.split("-")[2];

							System.out.println("Lähtösolmu " + lsolmu + " paino " + paino + " päätesolmu " + psolmu);

							tarkistaK(paino, lsolmu, psolmu);

						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				} else {
					t.setText("Väärä tiedostomuoto");
				}

			} catch (IOException e) {
				System.out.println("Tiedostonluku keskeytetty.");
			}

		} //readFile

		/**
		 * Tulostaa verkon konsoliin.
		 * @param g - verkko
		 * @author Aku Silvenius
		 */
		public void tulosta(Graph g) {
			System.out.println("VERKON TULOSTUS");
			for (Vertex v : g.vertices()) {
				System.out.print("[" + v.getLabel() + "]: ");
				for (Edge e : v.edges()) {
					System.out.print("[(" + e.getWeight() + ") " + e.getEndPoint().getLabel() + "]; ");
				}
				System.out.print("\n");
			}
			System.out.println("----------");
			System.out.println();
			t.setText("Verkko tulostettu konsoliin.");
		} //tulosta

	} //Kuuntelija

	public static void main(String[] args) {
		new GraphTest();
	} //main

} //GraphTest

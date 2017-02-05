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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
import HS.*;

@SuppressWarnings("serial")
public class GraphTest extends JFrame {

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
	JButton luetied;

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

		lisaa = new JButton("Lis��");
		lisaa.addActionListener(k);
		kruskal = new JButton("Kruskal");
		kruskal.addActionListener(k);
		tyh = new JButton("Tyhjenn� kaikki");
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

	} // this

	public class Kuuntelija extends AbKruskal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == luetied) readFile(getFile());
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
				t.setText("Lasketaan...");
				LinkedList<AbEdge> a = MST(g);
				Object opt[] = { "Sulje" };
				String viesti = tulosviesti(a);
				t.setText("Kruskal laskettu");

				JOptionPane.showOptionDialog(null, viesti, "GraphTest", JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.PLAIN_MESSAGE, null, opt, opt[0]);

			}
		} // actionPerformed

		private String getFile() {
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

				// random luku v�lilt� 25-50
				int rand = ThreadLocalRandom.current().nextInt(25,51);
				int r1,r2,d;

				// kirjoitetaan rand m��r� yhteyksi� pienelt� p�tk�lt� ArrayListi� satunnaisilla et�isyyksill�
				for (int x = 0; x < rand; x++) {
					r1 = ThreadLocalRandom.current().nextInt(rand, (cities.size()/rand));
					r2 = ThreadLocalRandom.current().nextInt(rand, (cities.size()/rand));
					d = ThreadLocalRandom.current().nextInt(0, 1000);
					w.println(cities.get(r1) + "-" + d + "-" + cities.get(r2));
				}

				w.close();

				System.out.println("Luotiin " + rand + " satunnaista yhteytt�");

				return tmp.getPath();

			} catch (Exception e) {
				e.printStackTrace();
				return f;
			}
		} //generateFile

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
				t.setText("Tyhj� sy�te.");
				return;
			}
			if (t1.equals(t2)) {
				t.setText("Sama l�ht�-/p��tekaupunki");
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
					t.setText("V�lill� " + vx.getLabel() + "-" + ve.getLabel() + " on jo yhteys.");
					return;
				} else {
					ve.addEdge(g, vx, dist);
					vx.addEdge(g, ve, dist);
					t.setText("Lis�ttiin " + ve.getLabel() + " <-(" + dist + ")-> " + vx.getLabel());
				}

			} else if (a) {
				ve = g.addVertex(g, t2);
				ve.addEdge(g, vx, dist);
				vx.addEdge(g, ve, dist);
				t.setText("Lis�ttiin " + ve.getLabel() + " <-(" + dist + ")-> " + vx.getLabel());
			} else if (b) {
				vx = g.addVertex(g, t1);
				vx.addEdge(g, ve, dist);
				ve.addEdge(g, vx, dist);
				t.setText("Lis�ttiin " + vx.getLabel() + " <-(" + dist + ")-> " + ve.getLabel());
			} else {
				ve = g.addVertex(g, t2);
				vx = g.addVertex(g, t1);
				ve.addEdge(g, vx, dist);
				vx.addEdge(g, ve, dist);
				t.setText("Lis�ttiin " + ve.getLabel() + " <-(" + dist + ")-> " + vx.getLabel());
			}

			System.out.println("g.size: " + g.size());

		} // tarkistaK

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

							System.out.println("L�ht�solmu " + lsolmu + " paino " + paino + " p��tesolmu " + psolmu);

							tarkistaK(paino, lsolmu, psolmu);

						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				} else {
					t.setText("V��r� tiedostomuoto");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} //readFile

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

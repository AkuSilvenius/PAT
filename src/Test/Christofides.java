package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JButton christo;
	
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
		
		k1 = new JTextField();
		k1.setText("L‰htˆkaupunki");
		k2 = new JTextField();
		k2.setText("P‰‰tekaupunki");
		matka = new JTextField();
		matka.setText("V‰limatka (km)");
		lisaa = new JButton("Lis‰‰");
		lisaa.addActionListener(k);
		christo = new JButton("Laske Christofides");
		christo.addActionListener(k);
		
		ylapan.add(k1, BorderLayout.LINE_START);
		ylapan.add(matka, BorderLayout.CENTER);
		ylapan.add(k2, BorderLayout.LINE_END);
		ylapan.add(lisaa, BorderLayout.PAGE_END);
		alapan.add(christo, BorderLayout.PAGE_START);
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
			if (e.getSource() == lisaa) {
				try {
					int dist = Integer.parseInt(matka.getText());
					String t1 = k1.getText().toLowerCase();
					String t2 = k2.getText().toLowerCase();
					if (tarkistaK(t1,t2))
						lisaaTiedot(dist,t1,t2);
				} catch (NumberFormatException n) {
					t.setText("Virheellinen matka");
				}
			}
			
			if (e.getSource() == christo) {
				t.setText("Lasketaan...");
				LinkedList<AbEdge> a = christofides(g);
				System.out.println(a.size());
				Object opt[] = {"Sulje"};
				String viesti = tulosviesti(a); 
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
			String tmp = "Kauppamatkaajan reitti:\n";
			String s = a.getFirst().getStartPoint().getLabel() + "->";
			tmp.concat(s);
			for (AbEdge e : a) {
				s = e.getEndPoint().getLabel() + "->";
				tmp.concat(s);
			}
			return tmp;
		}

		private LinkedList<AbEdge> christofides(AbGraph g) {
			LinkedList<AbEdge> tmp = MSTKruskal(g);
			System.out.println(tmp.size());
			EulerTour(tmp);
			Shortcuts(tmp);
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
					tmp.add(v.addEdge(min.getEndPoint(), min.getWeight()));
					System.out.println(tmp.size());
				}
			}
			
		}

		private boolean tarkistaK(String t1, String t2) {
			if (t1.equals(t2)) {
				t.setText("Sama l‰htˆ-/p‰‰tekaupunki");
				return false;
			}
			boolean tmp1 = false;
			boolean tmp2 = false;
			for (AbVertex v : g.vertices()) {
				if (v.getLabel().equals(t1)) {
					tmp1 = true;
				}
				if (v.getLabel().equals(t2)) {
					tmp2 = true;
				}
			}
			if (tmp1 && tmp2) {
				t.setText("T‰m‰ tieto on jo lis‰tty.");
				return false;
			}
			
			return true;
		}

		private void lisaaTiedot(float dist, String t1, String t2) {
			AbVertex p = g.addVertex(t1);
			AbVertex q = g.addVertex(t2);
			p.addEdge(q, dist);
			q.addEdge(p, dist);
			t.setText(t1 + " ja " + t2 + " lis‰tty");
			System.out.println(g.size());
		}
		
	}
	
	public static void main(String [] args) {		
		new Christofides();
	}
	
}
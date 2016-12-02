package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
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
		k1.setText("Lähtökaupunki");
		k2 = new JTextField();
		k2.setText("Päätekaupunki");
		matka = new JTextField();
		matka.setText("Välimatka (km)");
		lisaa = new JButton("Lisää");
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
				AbGraph a = christofides(g);
			}
		}

		private AbGraph christofides(AbGraph g) {
			LinkedList<AbEdge> tmp = MSTKruskal(g);
			return g;
		}

		private boolean tarkistaK(String t1, String t2) {
			if (t1.equals(t2)) {
				t.setText("Sama lähtö-/päätekaupunki");
				return false;
			}
			for (AbVertex v : g.vertices()) {
				if (v.getLabel().equals(t1)) {
					t.setText(t1 + " on jo verkossa");
					return false;
				}
				if (v.getLabel().equals(t2)) {
					t.setText(t2 + " on jo verkossa");
					return false;
				}
			}
			
			return true;
		}

		private void lisaaTiedot(float dist, String t1, String t2) {
			AbVertex p = g.addVertex(t1);
			AbVertex q = g.addVertex(t2);
			p.addEdge(q, dist);
			q.addEdge(p, dist);
			t.setText(t1 + " ja " + t2 + " lisätty");
		}

		@Override
		public LinkedList<AbEdge> MSTKruskal(AbGraph g) {
			return this.MSTKruskal(g);
		}
		
	}
	
	public static void main(String [] args) {		
		new Christofides();
	}
	
}
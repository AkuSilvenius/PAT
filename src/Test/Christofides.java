package Test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import HS.*;

@SuppressWarnings("serial")
public class Christofides extends JFrame {

	JPanel ylapan;
	JPanel alapan;
	
	JTextField k1;
	JTextField k2;
	JTextField matka;
	
	JButton lisaa;
	JButton christo;
	
	Kuuntelija k;
	
	public Christofides() {
		
		HSgraph g = new HSgraph();
		
		ylapan = new JPanel();
		ylapan.setSize(400,150);
		ylapan.setLayout(new BorderLayout());
		alapan = new JPanel();
		alapan.setSize(400,50);
		alapan.setLayout(new FlowLayout());
		
		k = new Kuuntelija();
		
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
		alapan.add(christo);
		
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
	
	public class Kuuntelija implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	public static void main(String [] args) {		
		new Christofides();
	}
	
}
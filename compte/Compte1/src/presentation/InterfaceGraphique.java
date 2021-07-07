package presentation;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class InterfaceGraphique extends JFrame {

	public InterfaceGraphique() {
		

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Gestion Compte Banquaire");
		setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		JPanel fenetre = new JPanel(new BorderLayout());
		JPanel p1 = new JPanel(new GridLayout(2, 1));

		JPanel p2 = new JPanel(new GridLayout(5, 5));
		JPanel bas = new JPanel(new BorderLayout());
//		JButton AjouterClientBtn = new JButton("Ajouter Client");
		JButton op = new JButton("Operations");
		
	//	JButton infoClients = new JButton("Informations Client");
		
		JButton historique = new JButton("historique");
		/*
		 * JButton operation = new JButton(new ImageIcon("C:/images/ajout.png"));
		 * JButton infosClient = new JButton(new ImageIcon("C:/images/rechercher.png"));
		 * JButton historique = new JButton(new ImageIcon("C:/images/rechercher.png"));
		 * /*
		 * 
		 */
		JButton quitter = new JButton("quitter");
		JLabel Bienvenue = new JLabel("Bienvenue à votre compte", JLabel.CENTER);

		p1.add(Bienvenue);
//		p2.add(AjouterClientBtn);
		p2.add(op);
		//p2.add(infoClients);
		p2.add(historique);
		
		bas.add(quitter);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(bas, BorderLayout.SOUTH);

		

		this.setSize(500, 300);

		op.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new boutonsOperations();
				setVisible(false);
			}
		});

		
	
		/*infoClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InfoClients();
			}
		});
*/
		
		historique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Historique();
			}
		});
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new InterfaceGraphique();

		
	}
	
}
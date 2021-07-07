package presentation;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

import dao.IDaoCompte;
import dao.IDaoImpliment;
import dao.SingletonConnection;
import metier.entity.Client;

public class Historique extends JFrame {
	JPanel pajout = new JPanel(new GridLayout(3, 1, 5, 5));
	JPanel s = new JPanel(new GridLayout(2, 1));
	JLabel numCompte = new JLabel("Votre Numero de Compte", JLabel.LEFT);
	JTextField tnumCompte = new JTextField();
	JPanel bas = new JPanel(new BorderLayout());

	JButton supprimer = new JButton("Supprimer");
	JButton quitter = new JButton("quitter");
	JButton ok = new JButton("ok");
	JButton afficher = new JButton("Afficher historique");
	IDaoCompte action = new IDaoImpliment();
	JPanel prs = new JPanel(new GridLayout(1, 1));
	TableModele3 c1 = new TableModele3();
	JTable table = new JTable(c1);
	JScrollPane jsp = new JScrollPane(table);

	public Historique() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pajout.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Historique"));

		pajout.add(numCompte);
		pajout.add(tnumCompte);

		pajout.add(supprimer);
		pajout.add(afficher);
		this.add(pajout, BorderLayout.NORTH);
		prs.add(jsp);
		this.add(prs, BorderLayout.CENTER);
		bas.add(quitter);
		this.add(bas, BorderLayout.SOUTH);
		pack();
		setVisible(true);

		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (action.getSolde(Integer.parseInt(tnumCompte.getText())) == null) {
					
					JOptionPane.showMessageDialog(Historique.this, "verifier votre numero de compte ");
				} else {
					if (action.getHistorique(Integer.parseInt(tnumCompte.getText())).size() == 0) {
						JOptionPane.showMessageDialog(Historique.this, "Aucune operation !  ");
					} else {
						c1.chargerTable(action.getHistorique(Integer.parseInt(tnumCompte.getText())));
					}

				}

				
			}

		});

		supprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				action.supprimerHistorique(Integer.parseInt(tnumCompte.getText()));
				c1.chargerTable(action.getHistorique(Integer.parseInt(tnumCompte.getText())));
			}
		});

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public static void main(String args[]) {
		new Historique();
	}
}

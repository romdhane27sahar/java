package presentation;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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
import metier.entity.Client;

public class InfoClients extends JFrame {
	JPanel pajout = new JPanel(new GridLayout(7, 2, 5, 5));
	// JPanel s =new JPanel(new GridLayout(1,1,5,5));

	JLabel nom = new JLabel(" Nom ", JLabel.RIGHT);
	JLabel prenom = new JLabel("Prenom", JLabel.RIGHT);
	JLabel adresse = new JLabel("Adresse", JLabel.RIGHT);
	JLabel contact = new JLabel("Contact", JLabel.RIGHT);

	JTextField tnom = new JTextField();
	JTextField tprenom = new JTextField();
	JTextField tadresse = new JTextField();
	JTextField tcontact = new JTextField();
	JPanel bas = new JPanel(new BorderLayout());
	JButton modifier = new JButton("Modifier");

	JButton quitter = new JButton("quitter");
	JButton ok = new JButton("ok");
	IDaoCompte action = new IDaoImpliment();
	JPanel prs = new JPanel(new GridLayout(1, 1));
	TableModele2 c1 = new TableModele2();
	JTable table = new JTable(c1);
	JScrollPane jsp = new JScrollPane(table);

	public InfoClients() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pajout.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2),
				"Informations de Client"));

		pajout.add(nom);
		pajout.add(tnom);
		pajout.add(prenom);
		pajout.add(tprenom);
		pajout.add(adresse);
		pajout.add(tadresse);
		pajout.add(contact);
		pajout.add(tcontact);
		pajout.add(modifier);

		// s.add(modifier);
		// pajout.add(s,BorderLayout.CENTER);

		this.add(pajout, BorderLayout.NORTH);
		prs.add(jsp);
		this.add(prs, BorderLayout.CENTER);
		bas.add(quitter);
		this.add(bas, BorderLayout.SOUTH);
		this.setSize(500, 700);
		setVisible(true);

		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tcontact.getText().isEmpty() || tadresse.getText().isEmpty() || tnom.getText().isEmpty()
						|| tprenom.getText().isEmpty()) {

				} else {

					
					System.out.println(id);
					Client c = new Client(tnom.getText(), tprenom.getText(), id, tadresse.getText(),
							Integer.parseInt(tcontact.getText()));
					action.modifierInfoClient(c);
					c1.charger(action.getAllClient());

					JOptionPane.showMessageDialog(InfoClients.this, "Client Modifié !");

				}
			}
		});

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				TableMouseClicked(evt);
			}
		});

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		c1.charger(action.getAllClient());
	}

	int id;

	private void TableMouseClicked(MouseEvent evt) {
		TableModele2 model = (TableModele2) table.getModel();
		int Index = table.getSelectedRow();
		id = Integer.parseInt(model.getValueAt(Index, 6).toString());
		tnom.setText(model.getValueAt(Index, 1).toString());
		tprenom.setText(model.getValueAt(Index, 2).toString());
		tadresse.setText(model.getValueAt(Index, 3).toString());
		tcontact.setText(model.getValueAt(Index, 4).toString());

		
	}
}

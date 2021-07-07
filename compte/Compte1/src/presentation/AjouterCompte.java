
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

import dao.IDaoCompte;
import dao.IDaoImpliment;
import metier.entity.Client;

public class AjouterCompte extends JFrame {

	JPanel pajout = new JPanel(new GridLayout(9, 2, 5, 5));
	JLabel numCompte = new JLabel("Numero Compte", JLabel.RIGHT);
	JTextField tnumCompte = new JTextField();
	JLabel numClient = new JLabel("Numero Client", JLabel.RIGHT);
	JTextField tnumClient = new JTextField();
	
	JLabel solde = new JLabel("solde", JLabel.RIGHT);
	JTextField tsolde = new JTextField();
	JLabel NomLabel = new JLabel("Nom", JLabel.RIGHT);
	JLabel PrenomLabel = new JLabel("Prenom", JLabel.RIGHT);
	JLabel AdresseLabel = new JLabel("Adresse", JLabel.RIGHT);
	JLabel ContactLabel  = new JLabel("Contact", JLabel.RIGHT);
	JTextField Tnom = new JTextField();
	JTextField Tprenom= new JTextField();
	JTextField Tadresse= new JTextField();
	JTextField Tcontact= new JTextField();

	JPanel bas = new JPanel(new BorderLayout());
	JButton ajouter = new JButton("Ajouter");
	JButton supprimer = new JButton("Supprimer");
	JButton quitter = new JButton("quitter");
	IDaoCompte action = new IDaoImpliment();
	JPanel prs = new JPanel(new GridLayout(1, 1));
	TableModele2 c1 = new TableModele2();
	JTable table = new JTable(c1);
	JScrollPane jsp = new JScrollPane(table);
	JButton modifier = new JButton("modifier");
	JPanel tousSouth = new JPanel(new BorderLayout());
	JPanel modifierPannel = new JPanel(new BorderLayout());

	public AjouterCompte() {
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pajout.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Ajout Compte"));
		tnumClient.setEnabled(false);
		tnumClient.setText(String.valueOf(RetourId()));
		pajout.add(numCompte);
		pajout.add(tnumCompte);
		pajout.add(numClient);
		pajout.add(tnumClient);
		pajout.add(solde);
		pajout.add(tsolde);
		pajout.add(NomLabel) ; 
		pajout.add(Tnom); 
		pajout.add(PrenomLabel) ;
		pajout.add(Tprenom); 
		pajout.add(AdresseLabel);
		pajout.add(Tadresse) ; 
		pajout.add(ContactLabel);
		pajout.add(Tcontact);
		modifierPannel.add(modifier);
		bas.add(quitter);
		tousSouth.add(modifierPannel, BorderLayout.NORTH);
		tousSouth.add(bas, BorderLayout.SOUTH);
		
		
		
//		Table
		jsp.setSize(500,200);
		
		pajout.add(ajouter);
		pajout.add(supprimer);
		this.add(pajout, BorderLayout.NORTH);
		prs.add(jsp);
		this.add(prs, BorderLayout.CENTER);
		
		this.add(tousSouth, BorderLayout.SOUTH);
		this.setSize(500,600);
		setLocationRelativeTo(null);
		setVisible(true);
		

		c1.charger(action.getAllClient());
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				

				if (tnumCompte.getText().equals("") || tnumClient.getText().equals("") || tsolde.getText().equals("")||
						Tnom.getText().equals("") || Tprenom.getText().equals("") || Tadresse.getText().equals("") || Tcontact.getText().equals("")
						)
					JOptionPane.showMessageDialog(AjouterCompte.this, "erreur de saisie");
				else {
					int numCompte = Integer.parseInt(tnumCompte.getText());
					int numClient = Integer.parseInt(tnumClient.getText());
					double solde = Double.parseDouble(tsolde.getText());
					String nom = Tnom.getText(); 
					String prenom = Tprenom.getText();
					String Addresse = Tadresse.getText(); 
					int Contact = Integer.parseInt(Tcontact.getText().toString()) ; 
					Client c = new Client(numClient, nom, prenom, numCompte, Addresse, Contact, solde); 
					action.ajouterClient(c);
					c1.charger(action.getAllClient());
					tnumClient.setText(String.valueOf(RetourId()));
					clear(); 
				}
			}
		});

		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id ; 
				 TableModele2 modele = (TableModele2) table.getModel();
                 try {
                      int Index = table.getSelectedRow();
                     
                      if (Index != -1 ) {
                          try{
                         id = Integer.valueOf(modele.getValueAt(Index, 0).toString());
                         action.supprimerClient(id);
                        
                         modele.charger(action.getAllClient());
                         JOptionPane.showMessageDialog(AjouterCompte.this, "Client Supprimer");
                     }catch(Exception ex){
                         ex.printStackTrace();
                     }
                      }
                      else {
                    	  JOptionPane.showMessageDialog(AjouterCompte.this, "Selectionner un client à supprimer! ");
                      }
                             
                
                 } catch (Exception exx) {   
                	 exx.printStackTrace();
                 }
			}
		});
		
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InfoClients() ; 
				
			}
		});
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new general() ; 
				dispose();
			}
		});
		
	}
	private int RetourId() {
		int id = action.getAllClient().size();
		return ++id ; 
	}
	private void clear() {
		tnumCompte.setText("");
		tnumClient.setText(String.valueOf(RetourId()));
		tsolde.setText("");
		Tnom.setText("");
		Tprenom.setText("");
		Tadresse.setText("");
		Tcontact.setText("");
	}
	public static void main(String[] args) {
		new AjouterCompte();
	}

}

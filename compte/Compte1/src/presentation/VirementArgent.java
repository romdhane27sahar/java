package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.IDaoCompte;
import dao.IDaoImpliment;
import dao.SoldeInsuffisantException;
import metier.entity.Client;
import metier.entity.Operation;


public class VirementArgent extends JFrame {

JPanel p= new JPanel();
	
	JLabel numCompte1 =new JLabel("numero de votre Compte");
	JTextField num1= new JTextField();
	JLabel numCompte2 =new JLabel("numero du Compte destinataire");
	JTextField num2= new JTextField();
	JLabel montant =new JLabel("Montant à virer");
	JTextField m= new JTextField();
	
	JPanel pp = new JPanel(new GridLayout(4,2,10,10));
	JButton ok = new JButton("OK");
	JButton quitter = new JButton("Quitter");
	IDaoCompte classe  = new IDaoImpliment();
	
	public VirementArgent()
	{
	 this.setVisible(true);
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 this.setTitle("Virement");
	 
	
	 p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE,2)));
	numCompte1.setHorizontalAlignment(JLabel.LEFT);
	num1.setHorizontalAlignment(JTextField.RIGHT);
	numCompte2.setHorizontalAlignment(JLabel.LEFT);

	num2.setHorizontalAlignment(JTextField.RIGHT);
	montant.setHorizontalAlignment(JLabel.LEFT);
	
	
	m.setHorizontalAlignment(JTextField.RIGHT);
	
	quitter.setHorizontalAlignment(JTextField.CENTER);
	this.setLocationRelativeTo(null);
	
	
	 p.add(ok);
	 p.add(quitter);
	pp.add(numCompte1);
	pp.add(num1);
	pp.add(numCompte2);
	pp.add(num2);
	pp.add(montant);
	pp.add(m);
	
	this.add(pp ,BorderLayout.CENTER);
	p.add(ok);
	p.add(quitter);
	
	 this.add(p,BorderLayout.SOUTH);
	 this.setSize(450,300);
	 pack();
	  
	 
	ok.addActionListener( new ActionListener(){
	
			public void actionPerformed(ActionEvent e) {  
				int numCompte1 = Integer.parseInt( num1.getText());
				int numCompte2 = Integer.parseInt( num2.getText());
				double montant = Double.parseDouble(m.getText());
				if(num1.getText().equals("")||num2.getText().equals("")||m.getText().equals(""))
					JOptionPane.showMessageDialog(VirementArgent.this, "erreur de saisie");
				else {
					try {
						Client c1 = classe.getSolde(numCompte1) ; 
						Client c2 = classe.getSolde(numCompte2); 
						Operation operation = new Operation() ;
						classe.virement(c1, c2, montant);
					JOptionPane.showMessageDialog(VirementArgent.this, "votre operation est effectuée avec succèe");
					} catch (SoldeInsuffisantException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(VirementArgent.this, "Montant Insuffisant ! ");
						
					}
				
			}}
				});
				
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
		
	}
	public static void main(String args []) {
		new VerserArgent();
	}
}
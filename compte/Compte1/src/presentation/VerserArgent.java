package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.IDaoImpliment;
import dao.SoldeInsuffisantException;
import metier.entity.Client;
import metier.entity.Operation;




public class VerserArgent extends JFrame{
	JPanel p= new JPanel();
	
	JLabel numCompte =new JLabel("numero de Compte");
	JTextField num= new JTextField();
	JLabel montant =new JLabel("Montant à verser");
	JTextField m= new JTextField();
	JPanel pp = new JPanel(new GridLayout(3,2,10,10));
	JButton ok = new JButton("OK");
	JButton quitter = new JButton("Quitter");
	IDaoImpliment classe  = new IDaoImpliment();
	
	public VerserArgent()
	{
	 this.setVisible(true);
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 this.setTitle("Versement");
	 
	
	 p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.ORANGE,2)));
	numCompte.setHorizontalAlignment(JLabel.LEFT);
	montant.setHorizontalAlignment(JLabel.LEFT);
	
	num.setHorizontalAlignment(JTextField.RIGHT);
	m.setHorizontalAlignment(JTextField.RIGHT);
	
	quitter.setHorizontalAlignment(JTextField.CENTER);
	this.setLocationRelativeTo(null);
	
	pp.add(numCompte);
	pp.add(num);
	pp.add(montant);
	pp.add(m);
	
	this.add(pp , BorderLayout.CENTER);
	p.add(ok);
	p.add(quitter);
	
	 this.add(p,BorderLayout.SOUTH);
	 this.setSize(350,200);
	 /*pack();
	  */
	
	ok.addActionListener( new ActionListener(){
		Client c= new Client();
			public void actionPerformed(ActionEvent e) {  
				int numCompte = Integer.parseInt( num.getText()); 
				double montant = Double.parseDouble(m.getText());
				if(num.getText().equals("")||m.getText().equals(""))
					JOptionPane.showMessageDialog(VerserArgent.this, "erreur de saisie");
				else {
					String s = "Versement" ; 
					int numc = Integer.parseInt(num.getText()) ;
					Double d = Double.parseDouble(m.getText()) ; 
					Operation o = new Operation(s,numc,d); 
					classe.versement(o,d,numc );
					JOptionPane.showMessageDialog(VerserArgent.this, "Votre operation est effectueé par succée");
					
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
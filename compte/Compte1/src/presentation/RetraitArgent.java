package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.*;
import dao.SoldeInsuffisantException;
import metier.entity.Operation;


public class RetraitArgent extends JFrame {

JPanel p= new JPanel();
	

	JLabel numCompte=new JLabel("numero de Compte");
	JTextField num= new JTextField();
	JLabel montant =new JLabel("Montant à retirer");
	JTextField m= new JTextField();
	IDaoCompte action = new IDaoImpliment();
	JPanel pp = new JPanel(new GridLayout(3,2,10,10));
	JButton ok = new JButton("OK");
	JButton quitter = new JButton("Quitter");
	IDaoImpliment classe  = new IDaoImpliment();
	
	public RetraitArgent()
	{
	 this.setVisible(true);
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 this.setTitle("Retrait");
	 
	
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
	/* pack();
	 * 
	 */
	ok.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {  
				
				double montant = Double.parseDouble(m.getText());
				if(num.getText().equals("")||m.getText().equals(""))
					JOptionPane.showMessageDialog(RetraitArgent.this, "erreur de saisie");
				else {
					
					try {
						String s = "Retrait" ; 
						int numc = Integer.parseInt(num.getText()) ;
						Double d = Double.parseDouble(m.getText()) ; 
						Operation o = new Operation(s,numc,d); 
						action.retrait(o, d, numc);
						JOptionPane.showMessageDialog(RetraitArgent.this, "Votre operation est effectueé par succée");
					}catch (SoldeInsuffisantException e1) {
						JOptionPane.showMessageDialog(RetraitArgent.this, "Montant Insuffisant ! ");
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

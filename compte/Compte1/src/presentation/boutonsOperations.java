package presentation;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;
public class boutonsOperations extends JFrame {
	JPanel p = new JPanel ();
	JButton virer = new JButton("Virement");
	JButton retrait= new JButton("Retrait");
	JButton verser = new JButton("Versement");
	JButton quitter = new JButton("quitter");
	
	public boutonsOperations()
	{
		p.add(virer);
		p.add(retrait);
		p.add(verser);
		p.add(quitter,BorderLayout.SOUTH);
	    this.add(p);
		 this.setTitle("Operations");
		 this.setVisible(true);
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setSize(350,98);
		 /*this.pack();
/* 
 * 
 */
		 virer.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 new VirementArgent();
			 }
		 });
		retrait.addActionListener(new ActionListener(){          
			 public void actionPerformed(ActionEvent e) {
				 new RetraitArgent();
			 }
		 });
		verser.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				new VerserArgent();
			 }
		 });
		 
	 quitter.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new InterfaceGraphique().setVisible(true);
		 }
	 });}
	public static void main(String args[]) {
		new boutonsOperations();
	}
}

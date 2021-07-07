package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class general extends JFrame {
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JButton admin= new JButton("Admin");
	JButton utilisateur= new JButton("Utilisateur");
	JButton quitter = new JButton("Quitter");
	

	public general() {
		this.setLayout(new GridLayout(3,1,10,10));
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setTitle("Acceuil");
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
	BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Acceuil");
	
	
	add(admin,BorderLayout.NORTH);
	add(utilisateur,BorderLayout.CENTER);
	add(quitter,BorderLayout.SOUTH);


	
	this.setSize(500, 300);

	
	admin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//new Login();
			new AjouterCompte();
			setVisible(false);
		}
	});
	utilisateur.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new InterfaceGraphique();
			setVisible(false);
		}
	});
	
	quitter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
}

	public static void main(String[] args) {
		new general();

		
	}
}





 
package presentation;
   import java.awt.BorderLayout;



	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
    import javax.swing.JFrame;

	public class Operations extends JFrame {
		JButton virer = new JButton(new ImageIcon("C:/images/ajout.png"));
		JButton retrait= new JButton(new ImageIcon("C:/images/rechercher.png"));
		JButton verser = new JButton(new ImageIcon("c:/images/exit.png"));
		JButton quitter = new JButton(new ImageIcon("c:/images/exit.png"));
		

	

		public void Operations() {
			 this.setTitle("Operations");
			 this.setVisible(true);
			 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			 this.setLayout(new GridLayout(1,4,10,10)); 
			 this.setSize(400,250);
			 this.pack();
			 this.add(virer);
			 this.add(retrait);
			 this.add(verser);
			
		
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
				System.exit(0);
			 }
		 });
		 }
		 
		public static void main(String[]args) {
			new  Operations();
		}
	}
	

/*package presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import dao.SingletonConnection;

public class Login extends JFrame implements ActionListener {

	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("reset");
	JTextField userField = new JTextField();
	JPasswordField PasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("user ID : ");
	JLabel PasswordLabel = new JLabel("Password : ");
	JLabel messageLabel = new JLabel("you're welcome !");
	Login(){
		userIDLabel.setBounds(50,100,75,25);
		PasswordLabel.setBounds(50,150,110,25);

		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));

		userField.setBounds(150,100,200,25);

		PasswordField.setBounds(150,150,200,25);

		loginButton.setBounds(125,200,100,25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);

		resetButton.setBounds(225,200,100,25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);

		add(userIDLabel);
		add(PasswordLabel);
		add(messageLabel);
		add(userField);
		add(PasswordField);
		add(loginButton);
		add(resetButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420,420);
		setLayout(null);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== resetButton) {
			userField.setText("");
			PasswordField.setText("");
		}		if (e.getSource()== loginButton) {
			String userID = userField.getText() ; 
			String password = String.valueOf(PasswordField.getPassword());
			
		}
	
	}
}try
{
	Connection cx = SingletonConnection.getInstance();
    St= con.createStatement();
    
    Rs = St.executeQuery("select * from login where nomAdmin='" +userIDField.getText()+"' and userPasswordField = '"+String.valueOf(pwd.getPassword())+ "'");
	 if (Rs.next())
	 {
           new AjouterCompte().setVisible(true);
           this.dispose();
       }else {
           JOptionPane.showMessageDialog(this, "Wrong UserName or Password");
 
    }
}catch(Exception e1)
	{
		e1.printStackTrace();
	}


}}

loginButton.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new AjouterCompte();
	 }
});}






//	}try
//
//	{
//	
//    St= con.createStatement(); 
//	Rs = St.executeQuery(select * from SuperMarket.ADMINTBL where ANAME='"+t1.getText()+"' and APASS = '"+String.valueOf(pwd.getPassword())+ "'");
//	 if (Rs.next()){
//           new Category().setVisible(true);
//           this.dispose();
//       }else {
//           JOptionPane.showMessageDialog(this, "Wrong UserName or Password");
//       }
//}catch(
//	SQLException e1)
//	{
//	e1.printStackTrace();
//}
	

*/
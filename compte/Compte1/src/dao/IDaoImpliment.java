
package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.entity.Client;

import metier.entity.Operation;
import dao.SingletonConnection;
import dao.IDaoCompte;

public class IDaoImpliment implements IDaoCompte {

	public Client getSolde(int id) {
		Client c = null;
		try {
			Connection cnx = SingletonConnection.getInstance();
			Statement ps = cnx.createStatement();
			ResultSet rs = ps.executeQuery("Select * from t_client where numCompte = " + id);
			while (rs.next()) {
				c = new Client();
				c.setNumClient(rs.getInt(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setAdresse(rs.getString(4));
				c.setContact(rs.getInt(5));
				c.setSolde(rs.getDouble(6));
				c.setNumCompte(rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("erreur null");
		}

		return c;
	}
	
	
	public void updateSolde(int id, Double solde) {
		Connection cnx = SingletonConnection.getInstance();
		try {

			Statement pss = cnx.createStatement();
			String sql = "update t_client set solde = " + solde + "where numCompte = " + id;
			pss.executeUpdate(sql);
			System.out.println("Updateddd");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}



	@Override
	public void retrait(Operation c, double montant, int id) throws SoldeInsuffisantException {
		double d = 0;
		try {
			Connection cx = SingletonConnection.getInstance();
			PreparedStatement st = cx
					.prepareStatement("insert into  t_operation(type,montant,numCompte) values(?,?,?)");
			st.setString(1, c.getType());
			st.setDouble(2, c.getMontant());
			st.setInt(3, c.getNumCompte());
			if (montant < getSolde(id).getSolde()) {
				st.executeUpdate();
				Double nSolde = getSolde(id).getSolde();
				updateSolde(id, nSolde - montant);
			} else {
				throw new SoldeInsuffisantException("solde Insuffisant!");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void versement(Operation c, double montant, int id) {
		double d = 0;
		try {
			Connection cx = SingletonConnection.getInstance();
			PreparedStatement st = cx
					.prepareStatement("insert into  t_operation(type,montant,numCompte) values(?,?,?)");
			st.setString(1, c.getType());
			st.setDouble(2, c.getMontant());
			st.setInt(3, c.getNumCompte());

			st.executeUpdate();
			Double nSolde = getSolde(id).getSolde();
			updateSolde(id, nSolde + montant);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void virement(Client c1, Client c2, double montant) throws SoldeInsuffisantException{
		Connection cnx = SingletonConnection.getInstance();
		try {
			
			cnx.setAutoCommit(false);
			Double montant1 = c2.getSolde()+ montant  ; 
			updateSolde(c2.getNumCompte(),montant1 );
			if (c1.getSolde() < montant) throw new SoldeInsuffisantException("Solde insuffisant");
			Double montant2 = c1.getSolde()- montant  ; 
			updateSolde(c1.getNumCompte(),montant2 );

			cnx.commit();
			
		} catch (Exception e) {
			
				System.out.println(e.getMessage());
				try {
					cnx.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}

	}

	public void supprimerHistorique(int numCompte) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("delete from   t_operation  where numCompte="+numCompte);
			st.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void modifierInfoClient(Client c) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement(
					"update t_client set Prenom=?, Nom=?, Adresse=? , Contact=?  where numCompte=?");
			
			st.setString(2, c.getNom());
			st.setString(1, c.getPrenom());
			st.setString(3, c.getAdresse());
			st.setInt(4, c.getContact());
			st.setInt(5, c.getNumCompte());
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerInfoClient(int numCompte) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("delete  t_operation  where numCompte=?");
			st.setInt(1, numCompte);
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Client> getAllInfoClient() {
		Connection cx = SingletonConnection.getInstance();
		List<Client> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from t_Client  where numCompte=?");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client e = new Client();
				e.setNumClient(rs.getInt(3));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getString(3));
				e.setAdresse(rs.getString(4));
				e.setContact(rs.getInt(5));
				liste.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public  List<Operation> getHistorique(int id) {

		
		List<Operation> l = new ArrayList<>();
		try {
			Connection cx = SingletonConnection.getInstance();
			PreparedStatement ps = cx.prepareStatement("select * from t_operation  where numCompte="+id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Operation c = new Operation();
				c.setCode(rs.getInt(1));
				c.setType(rs.getString(2));
				c.setNumCompte(rs.getInt(4));
				c.setMontant(rs.getDouble(3));

				l.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Client> consulterSolde() {
		Connection cnx = SingletonConnection.getInstance();
		List<Client> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select solde from t_client  where numCompte=?");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client p = new Client();
				p.setSolde(rs.getDouble(7));

				liste.add(p);
			}
		} catch (SQLException p) {
			p.printStackTrace();
		}
		return liste;

	}

	@Override
	public void ajouterClient(Client c) {
		Connection cx = SingletonConnection.getInstance();
		try {
			PreparedStatement st = cx.prepareStatement("insert into t_client values(?,?,?,?,?,?,?)  ");
			st.setInt(1, c.getNumClient());
			st.setString(2, c.getNom());
			st.setString(3, c.getPrenom());
			st.setString(4, c.getAdresse());
			st.setInt(5, c.getContact());
			st.setDouble(6, c.getSolde());
			st.setInt(7, c.getNumCompte());
			st.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Client> getAllClient() {
		Connection cx = SingletonConnection.getInstance();
		List<Client> Liste = new ArrayList<>();
		try {
			Statement ps = cx.createStatement();
			ResultSet rs = ps.executeQuery("Select * from t_client");
			while (rs.next()) {
				Client c = new Client();
				c.setNumClient(rs.getInt(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setAdresse(rs.getString(4));
				c.setContact(rs.getInt(5));
				c.setSolde(rs.getDouble(6));
				c.setNumCompte(rs.getInt(7));
		
				Liste.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Liste;
	}

	@Override
	public void supprimerClient(int id) {

		try {
			Connection cx = SingletonConnection.getInstance();
			String Query = "Delete from t_client where numClient = " + id;
			Statement del;
			del = cx.createStatement();
			del.executeUpdate(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

/*
 * public void virement(Compte c1,Compte c2, double montant) { Connection cnx
 * =SingletonConnection .getInstance(); try { PreparedStatement ps;
 * //c2.setAutoCommit(false);
 * ps=cnx.prepareStatement("update compte set solde=? where code=?");
 * ps.setDouble(1,c2.getSolde()+ montant ); ps.setInt(2, c2.getNumero());
 * ps.executeUpdate(); if(c1.getSolde()<montant)//throw new Exception
 * ("solde insuffisant");
 * 
 * ps=cnx.prepareStatement("update compte set solde=? where code=?");
 * ps.setDouble(1, c1.getSolde()-montant); ps.setInt(2, c1.getNumero());
 * ps.executeUpdate();
 * 
 * //c.commit();
 * 
 * //} //catch (SQLException SoldeInsuffisantException e) { //try {
 * //System.out.println(e.getMessage()); //c.rollback(); }catch (SQLException
 * e1) { e1.printStackTrace(); } }
 * 
 * 
 * public void retrait(Compte c1, double montant) { try { Connection cnx
 * =SingletonConnection .getInstance();
 * 
 * //c.setAutoCommit(false);
 * 
 * 
 * PreparedStatement st
 * =cnx.prepareStatement("update compte set solde=? where code=?");
 * st.executeUpdate(); //if(c1.getSolde()<montant)throw new
 * SoldeInsuffisantException ("solde insuffisant");
 * 
 * st.setDouble(1, c1.getSolde()-montant); st.setInt(2, c1.getNumero());
 * st.executeUpdate();
 * 
 * //c.commit();
 * 
 * //}catch (SQLException SoldeInsuffisantException e1) { //try {
 * //System.out.println(e1.getMessage()); //c.rollback(); }catch (SQLException
 * e1) { e1.printStackTrace(); } }
 * 
 * 
 * 
 * public void versement(Compte c1, double montant) { Connection cnx
 * =SingletonConnection .getInstance(); try { PreparedStatement ps;
 * //c.setAutoCommit(false);
 * ps=cnx.prepareStatement("update compte set solde=? where code=?");
 * ps.setDouble(1, c1.getSolde()+ montant); ps.setInt(2, c1.getNumero());
 * ps.executeUpdate();
 * 
 * //c.commit();
 * 
 * 
 * //c.rollback(); }catch (SQLException e1) { e1.printStackTrace(); } }
 * 
 * public void virement(Compte c1,Compte c2, double montant) { Connection cnx
 * =SingletonConnection .getInstance(); try { PreparedStatement ps;
 * //c2.setAutoCommit(false);
 * ps=cnx.prepareStatement("update compte set solde=? where code=?");
 * ps.setDouble(1,c2.getSolde()+ montant ); ps.setInt(2, c2.getNumero());
 * ps.executeUpdate(); if(c1.getSolde()<montant)//throw new Exception
 * ("solde insuffisant");
 * 
 * ps=cnx.prepareStatement("update compte set solde=? where code=?");
 * ps.setDouble(1, c1.getSolde()-montant); ps.setInt(2, c1.getNumero());
 * ps.executeUpdate();
 * 
 * //c.commit();
 * 
 * //} //catch (SQLException SoldeInsuffisantException e) { //try {
 * //System.out.println(e.getMessage()); //c.rollback(); }catch (SQLException
 * e1) { e1.printStackTrace(); } }
 * 
 * 
 * public void retrait(Compte c1, double montant) { try { Connection cnx
 * =SingletonConnection .getInstance();
 * 
 * //c.setAutoCommit(false);
 * 
 * 
 * PreparedStatement st
 * =cnx.prepareStatement("update compte set solde=? where code=?");
 * st.executeUpdate(); //if(c1.getSolde()<montant)throw new
 * SoldeInsuffisantException ("solde insuffisant");
 * 
 * st.setDouble(1, c1.getSolde()-montant); st.setInt(2, c1.getNumero());
 * st.executeUpdate();
 * 
 * //c.commit();
 * 
 * //}catch (SQLException SoldeInsuffisantException e1) { //try {
 * //System.out.println(e1.getMessage()); //c.rollback(); }catch (SQLException
 * e1) { e1.printStackTrace(); } }
 * 
 * 
 * 
 * public void versement(Compte c1, double montant) { Connection cnx
 * =SingletonConnection .getInstance(); try { PreparedStatement ps;
 * //c.setAutoCommit(false);
 * ps=cnx.prepareStatement("update compte set solde=? where code=?");
 * ps.setDouble(1, c1.getSolde()+ montant); ps.setInt(2, c1.getNumero());
 * ps.executeUpdate();
 * 
 * //c.commit();
 * 
 * 
 * //c.rollback(); }catch (SQLException e1) { e1.printStackTrace(); } }
 */

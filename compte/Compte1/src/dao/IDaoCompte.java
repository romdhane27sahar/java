package dao;
import java .util.List;


import metier.entity.Operation;
import metier.entity.Client;


public interface IDaoCompte {
		public Client getSolde(int id) ; 
		public List<Client> getAllClient();
		public void retrait( Operation c,double montant, int id) throws SoldeInsuffisantException;
		public void versement( Operation c,double montant, int id);
		public void virement(Client c1,Client c2, double montant) throws SoldeInsuffisantException;
		public void ajouterClient(Client c)  ; 
		public List <Client>consulterSolde (); 
		public  List<Operation> getHistorique(int id);
		public void supprimerHistorique(int numCompte) ;
		public void supprimerClient(int id) ;
		public void supprimerInfoClient(int numCompte);
		public void modifierInfoClient(Client c);
		public List<Client> getAllInfoClient();
	
		

	}

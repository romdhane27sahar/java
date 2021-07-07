package metier.entity;


public class Client {
	private int numClient;
	private String nom;
	private String prenom;
	private int numCompte;
	private String adresse;
	private int contact;
	private double solde;
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public Client(int numClient, String nom, String prenom, int numCompte, String adresse, int contact, double solde) {
		super();
		this.numClient = numClient;
		this.nom = nom;
		this.prenom = prenom;
		this.numCompte = numCompte;
		this.adresse = adresse;
		this.contact = contact;
		this.solde= solde;
	}
	public Client(String nom, String prenom, int numCompte, String adresse, int contact) {
		this.nom = nom;
		this.prenom = prenom;
		this.numCompte = numCompte;
		this.adresse = adresse;
		this.contact = contact;
	}
	public String toString() {
		String s = numClient+nom+prenom+numCompte+adresse+contact+solde ; 
		return s ; 
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client() {
		
	}
	public Client(int numCompte) {
		this.numCompte = numCompte ; 
	}

}

	
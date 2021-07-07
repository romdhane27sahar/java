package metier.entity;

import java.sql.Date;

public class Operation {

	private static  int code;
	private int numCompte;
	private String type;
	

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private double montant;

	public int getCode() {
		return code;
	}

	public void setCode(int  code) {
		this.code = code;
	}

	/*
	 * public int getNumClient() { return numClient; } public void setNumClient(int
	 * numClient) { this.numClient = numClient;
	 * 
	 * }
	 */
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Operation( String type , int numCompte, double montant) {
		++code ; 
		this.type = type ; 
		this.montant = montant;
		this.numCompte = numCompte ; 
	}

	public Operation() {
	}
}

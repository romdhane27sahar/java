package presentation;



import java.util.ArrayList;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import metier.entity.Client;





public class TableModele2 extends AbstractTableModel {
	private List<Client> l = new ArrayList<>();
	private String titre[]= {"Numero Client","Nom" ,"Prenom", "Adresse" ,"Contact","solde","Numero Compte"};
	
	
	public int getColumnCount() {
		return  titre.length;
		
	}
	public int getRowCount() {
		return l.size();
	}
	public Object getValueAt(int li ,int c) {
		switch(c) {
		case 0:
			return(l.get(li).getNumClient());
		case 1 :
			return (l.get(li).getNom());
		case 2: 
		    return(l.get(li).getPrenom());
		case 3 :
			 return(l.get(li).getAdresse());
		case 4 : 
			return (l.get(li).getContact());
		case 5:
			return(l.get(li).getSolde());
		case 6 : 
			return (l.get(li).getNumCompte());
		}
		return  null ;
		}
	public String getColumnName(int column) {
		return titre[column];
	}
	public void charger(List<Client> l) {
		this.l = l;
		fireTableDataChanged();
	}
	
	

}




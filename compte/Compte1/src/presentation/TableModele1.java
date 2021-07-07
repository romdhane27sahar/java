/*package presentation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


import metier.entity.Client;

public class TableModele1  extends AbstractTableModel {
	List<Client> client =new ArrayList<>();
	String titre [] = {"Numero de Client", "Nom",  "Prenom" ,"Numero de Compte","Adresse","Contact"};
	
	
	public int getColumnCount() {
		return titre.length;
	
	}
	
	
	public int getRowCount () {
		
		return client.size();
		
	}
	
	public Object getValueAt(int l , int c) {
		switch (c) {
		case 1:
			 return  client.get(l).getNumClient();
		case 2:
			 return client.get(l).getNom();
		case 3: 
			return client.get(l).getPrenom();
			
		case 4:
			return client.get(l).getNumCompte();
		case 5:
			 return  client.get(l).getAdresse();
		case 6:
			 return client.get(l).getContact();
		
			
		
		}
		return null;
	}
	public String getColumnName (int column) {
		
		return titre [column];
	}
	public void chargerTable (List<Client>liste) {
		client = liste ;
		fireTableDataChanged();
	}
		
	}
*/
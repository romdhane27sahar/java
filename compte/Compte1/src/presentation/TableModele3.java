package presentation;


	import java.util.ArrayList;

	import java.util.List;
	import javax.swing.table.AbstractTableModel;

import metier.entity.Operation;

	public class TableModele3  extends AbstractTableModel {
		List<Operation > operation = new ArrayList<>();
		String titre [] = {"code" ,"type","montant","NumCompte" };
		
	
		
		
		public int getColumnCount() {
			return titre.length;
		
		}
		
		
		
		public int getRowCount () {
			
			return operation.size();
			
		}
		
		public Object getValueAt(int l , int c) {
			switch (c) {
			case 0:
				 return  operation.get(l).getCode();
			case 1:
			
				return operation.get(l).getType();
			
			case 2:
				 return  operation.get(l).getMontant();
			case 3:
			
				return operation.get(l).getNumCompte();
			
			
			}
			
			return null;
		}
		public String getColumnName (int column) {
			
			return titre [column];
		}
		public void chargerTable (List<Operation>liste) {
			operation = liste ;
			fireTableDataChanged();
		}
			
		}


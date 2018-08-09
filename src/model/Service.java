package model;

import javafx.collections.ObservableList;
import model.db.DbCategorieRepository;

public class Service {
	
	private DbCategorieRepository categorie;
	
	public Service(){
		this.setCategorie(new DbCategorieRepository());
	}

	public DbCategorieRepository getCategorie() {
		return categorie;
	}

	private void setCategorie(DbCategorieRepository categorie) {
		this.categorie = categorie;
	}
	
	public ObservableList getObserverList(){
		return this.categorie.getOList();
	}

	
	

}

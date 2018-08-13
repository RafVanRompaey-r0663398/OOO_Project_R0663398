package model;

import javafx.collections.ObservableList;
import model.db.DbCategorieRepository;
import model.db.DbVragenRepository;

public class Service {
	
	private DbCategorieRepository categorie;
	private DbVragenRepository vragen;
	
	public Service(){
		this.setCategorie(new DbCategorieRepository());
		this.setVragen(new DbVragenRepository());
	}

	public DbCategorieRepository getCategorie() {
		return (DbCategorieRepository) categorie;
	}

	private void setCategorie(DbCategorieRepository categorie) {
		this.categorie = categorie;
	}
	
	public DbVragenRepository getVragen() {
		return this.vragen;
	}
	
	private void setVragen(DbVragenRepository vragen) {
		this.vragen = vragen;
	}
	
	public ObservableList<Categorie> getCategorieObserverList(){
		return this.categorie.getOList();
	}
	public ObservableList<String> getMainCategorieObserverList(){
		return this.categorie.getOListMainCategories();
	}
	
	public ObservableList<Vraag> getVragenObserverList(){
		return this.vragen.getOList();
	}
	
	public void addCategory(Categorie categorie){
		this.categorie.addCategorieToDb(categorie);
	}
	
	public void addVraag(Vraag vraag){
		this.vragen.addVraagToDb(vraag);
	}

	
	

}

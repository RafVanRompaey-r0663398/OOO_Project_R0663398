/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package model;

import javafx.collections.ObservableList;
import model.db.DbCategorieRepository;
import model.db.DbVragenRepository;

public class Service {
	
	private DbCategorieRepository categorie;
	private DbVragenRepository vragen;
	private Evaluatie evaluatie;
	private PropertiesReader props;
	
	public Service(){
		this.setCategorie(new DbCategorieRepository());
		this.setVragen(new DbVragenRepository());
		this.setEvaluatie(new Evaluatie(this));
		this.setProps(new PropertiesReader() );
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
	
	public Evaluatie getEvaluatie() {
		return this.evaluatie;
	}
	
	private void setEvaluatie(Evaluatie evaluatie) {
		this.evaluatie = evaluatie;
	}
	
	public PropertiesReader getProps() {
		return props;
	}

	public void setProps(PropertiesReader props) {
		this.props = props;
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

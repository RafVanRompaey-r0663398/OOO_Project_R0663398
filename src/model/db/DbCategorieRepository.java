/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package model.db;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;

public class DbCategorieRepository{
	
	/*observable list gebruiken ma wie dafuq weet hoe da moet*/

	private List<Categorie> list = new ArrayList<Categorie>();
	private ObservableList<Categorie> oList = FXCollections.observableArrayList(list);
	
	public DbCategorieRepository(){
		Categorie mockup1 = new Categorie("Design principles","The SOLID design principles");
		this.addCategorieToDb(mockup1);
		Categorie mockup2 = new Categorie("Design patterns","Design patterns discussed this year");
		this.addCategorieToDb(mockup2);
		Categorie mockup3 = new Categorie("Java","Java extra's");
		this.addCategorieToDb(mockup3);
		Categorie mockup4 = new Categorie("UML","Technique of drawing a class diagram");
		this.addCategorieToDb(mockup4);
	}

	public ObservableList<Categorie> getOList() {
		return this.oList;
	}
	
	public ObservableList<String> getOListMainCategories() {
		List<String> result = new ArrayList<String>();
		result.add("No Main Category");
		for(Categorie categorie: this.oList){
			result.add(categorie.getTitle());
		}
		ObservableList<String> Olist = FXCollections.observableArrayList(result);
		return Olist;
	}

	public void setList(ObservableList<Categorie> oList) {
		this.oList = oList;
	}
	
	public void addCategorieToDb(Categorie categorie){
		this.oList.add(categorie);
	}
	
}

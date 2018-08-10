package model.db;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;

public class DbCategorieRepository {
	
	/*observable list gebruiken ma wie dafuq weet hoe da moet*/

	private List list = new ArrayList<Categorie>();
	private ObservableList oList = FXCollections.observableArrayList(list);
	
	public DbCategorieRepository(){
		Categorie mokup1 = new Categorie("Design principles","The SOLID design principles");
		this.addCategorieToDb(mokup1);
		Categorie mokup2 = new Categorie("Design principles","Design patterns discussed this year");
		this.addCategorieToDb(mokup2);
		Categorie mokup3 = new Categorie("Java","Java extra's");
		this.addCategorieToDb(mokup3);
		Categorie mokup4 = new Categorie("UML","Technique of drawing a class diagram");
		this.addCategorieToDb(mokup4);
	}

	public ObservableList<Categorie> getOList() {
		return this.oList;
	}

	public void setList(ObservableList<Categorie> oList) {
		this.oList = oList;
	}
	
	public void addCategorieToDb(Categorie categorie){
		this.oList.add(categorie);
	}
	
}

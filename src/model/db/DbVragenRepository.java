package model.db;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;
import model.Vraag;

public class DbVragenRepository{
	
	private List list = new ArrayList<Vraag>();
	private ObservableList oList = FXCollections.observableArrayList(list);
	
	public DbVragenRepository(){
		Vraag mockUp1 = new Vraag("Welk patroon defineert een familie van algoritmes, kapselt ze in en maakt ze verwiselbaar?", "Design patterns");
		this.addVraagToDb(mockUp1);
		Vraag mockUp2 = new Vraag("Welk ontwerp principe is het minste van toepasing op het strategy patroon?","Design principes");
		this.addVraagToDb(mockUp2);
		
	}
	
	public ObservableList<Vraag> getOList() {
		return this.oList;
	}

	public void setList(ObservableList<Vraag> oList) {
		this.oList = oList;
	}
	
	public void addVraagToDb(Vraag vraag){
		this.oList.add(vraag);
	}

}

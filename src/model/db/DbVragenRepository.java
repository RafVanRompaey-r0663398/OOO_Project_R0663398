package model.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;
import model.Vraag;

public class DbVragenRepository{
	
	private List list = new ArrayList<Vraag>();
	private ObservableList oList = FXCollections.observableArrayList(list);
	
	public DbVragenRepository(){
		 List<String> mockUp1list = new ArrayList<String>();
		 mockUp1list.add("strategy");
		 mockUp1list.add("state");
		 mockUp1list.add("singelton");
		 mockUp1list.add("decorator");
		Vraag mockUp1 = new Vraag("Welk patroon defineert een familie van algoritmes, kapselt ze in en maakt ze verwiselbaar?", "Design patterns", "strategy", mockUp1list);
		this.addVraagToDb(mockUp1);
		Vraag mockUp2 = new Vraag("Welk ontwerp principe is het minste van toepasing op het strategy patroon?","Design principes","singelton", mockUp1list);
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

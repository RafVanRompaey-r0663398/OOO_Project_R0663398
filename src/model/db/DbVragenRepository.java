package model.db;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vraag;

public class DbVragenRepository{
	
	private List<Vraag> list = new ArrayList<Vraag>();
	private ObservableList<Vraag> oList = FXCollections.observableArrayList(list);
	
	public DbVragenRepository(){
		 List<String> mockUp1list = new ArrayList<String>();
		 mockUp1list.add("strategy");
		 mockUp1list.add("state");
		 mockUp1list.add("singelton");
		 mockUp1list.add("decorator");
		Vraag mockUp1 = new Vraag("Welk patroon defineert een familie van algoritmes, kapselt ze in en maakt ze verwiselbaar?", "Design patterns", "je moet elke patroon dat we in de lessen gezien hebben kunnen toe passen","strategy", mockUp1list);
		this.addVraagToDb(mockUp1);
		 List<String> mockUp2list = new ArrayList<String>();
		 mockUp2list.add("SRP");
		 mockUp2list.add("OCP");
		 mockUp2list.add("LSP");
		 mockUp2list.add("ISP");
		 mockUp2list.add("DIP");
		Vraag mockUp2 = new Vraag("Welk ontwerp principe is het minste van toepasing op het strategy patroon?","Design principles","voor elk patroon moet je kunnen aangeven in welke mate een principe van toepassing is.","SRP", mockUp2list);
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

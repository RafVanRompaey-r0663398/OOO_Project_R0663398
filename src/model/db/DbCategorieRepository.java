package model.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Categorie;

public class DbCategorieRepository {

	private Map<String, Categorie> map = new HashMap<String, Categorie>();
	
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

	public Map<String, Categorie> getMap() {
		return map;
	}

	public void setMap(Map<String, Categorie> map) {
		this.map = map;
	}
	
	public void addCategorieToDb(Categorie categorie){
		this.map.put(categorie.getName(), categorie);
	}
	
	public ArrayList<Categorie> getAllCategorieën(){
		return (ArrayList<Categorie>) this.getMap();
	}
	
}

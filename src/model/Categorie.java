package model;

import model.exceptions.ModelException;

public class Categorie {
	
	private String title,description,mainCategory;
	
	public Categorie(){
		super();
	}

	public Categorie(String title, String description) {
		super();
		this.setTitle(title);
		this.setDescription(description);
		this.setMainCategory(title);
	}
	public Categorie(String title, String description, String mainCategory) {
		super();
		this.setTitle(title);
		this.setDescription(description);
		this.setMainCategory(mainCategory);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		if(title== null || title.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		if(description == null || description.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.description = description;
	}
	
	public String getMainCategory() {
		return mainCategory;
	}

	private void setMainCategory(String mainCategory) {
		if(mainCategory == null || mainCategory.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.mainCategory = mainCategory;
	}
	
	
	

}

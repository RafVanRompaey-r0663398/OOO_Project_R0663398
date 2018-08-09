package model;

public class Categorie {
	
	private String title,description;
	
	public Categorie(){
		super();
	}

	public Categorie(String title, String description) {
		super();
		this.setTitle(title);
		this.setDescription(description);
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
	
	
	

}

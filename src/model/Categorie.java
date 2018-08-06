package model;

public class Categorie {
	
	private String name,description;
	
	public Categorie(){
		super();
	}

	public Categorie(String name, String description) {
		super();
		this.setName(name);
		this.setDescription(description);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if(name== null || name.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		if(description == null || description.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.description = description;
	}
	
	
	

}

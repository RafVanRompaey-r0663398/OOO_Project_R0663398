package model;

public class Vraag {
	
	private String question, category;
	
	public Vraag(String question,String category){
		this.setVraagStelling(question);
		this.setCategorie(category);
	}

	public String getQuestion() {
		return question;
	}

	private void setVraagStelling(String question) {
		if(question== null || question.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.question = question;
	}

	public String getCategory() {
		return category;
	}

	private void setCategorie(String category) {
		if(category== null || category.isEmpty())throw new ModelException("mag niet leeg zijn");
		this.category = category;
	}

}

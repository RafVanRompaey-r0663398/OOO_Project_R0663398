package model;

import java.util.List;

public class Vraag {
	
	private String question, category,feedback;
	private List<String> antwoorden;
	
	public Vraag(String question,String category){
		this.setVraagStelling(question);
		this.setCategorie(category);
		this.setFeedback("");
	}
	
	public Vraag(String question,String category,String feedback, List<String> antwoorden){
		this.setVraagStelling(question);
		this.setCategorie(category);
		this.setFeedback(feedback);
		this.setAntwoorden(antwoorden);
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
	
	public String getFeedback() {
		return feedback;
	}

	private void setFeedback(String feedback) {
		if(feedback== null)throw new ModelException("mag niet leeg zijn");
		this.feedback = feedback;
	}
	
	public List<String> getAntwoorden() {
		return antwoorden;
	}

	private void setAntwoorden(List<String> antwoorden) {
		this.antwoorden = antwoorden;
	}

}

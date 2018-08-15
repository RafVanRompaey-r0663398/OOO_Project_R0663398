package controller.handlers;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Categorie;
import view.panels.CDPPopUp;

public class SaveCategorieActionHandler implements EventHandler<ActionEvent> {

	private CDPPopUp CDPane;
	private Controller controller;
	private Categorie categorie;

	public SaveCategorieActionHandler(CDPPopUp CDPane, Controller controller) {
		this.CDPane = CDPane;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		String title = this.CDPane.getPane().getTitleFieldString();
		String description = this.CDPane.getPane().getDescriptionFieldString();
		String mainCategorie = this.CDPane.getPane().getCategorieText();
		if(mainCategorie == "No Main Category"){
		categorie = new Categorie(title, description);
		}
		categorie = new Categorie(title, description,mainCategorie);
		this.controller.getService().addCategory(categorie);
		this.CDPane.closePopUp();
	}
	
}

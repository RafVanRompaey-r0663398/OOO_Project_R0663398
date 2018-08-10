package controller.handlers;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Categorie;
import view.panels.PopUp;

public class SaveActionHandler implements EventHandler<ActionEvent> {

	private PopUp CDPane;
	private Controller controller;
	private Categorie categorie;

	public SaveActionHandler(PopUp CDPane, Controller controller) {
		this.CDPane = CDPane;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		String title = this.CDPane.getPane().getTitleFieldString();
		String description = this.CDPane.getPane().getDescriptionFieldString();
		categorie = new Categorie(title, description);
		this.controller.getService().AddCategory(categorie);
		this.CDPane.closePopUp();
	}
	
}

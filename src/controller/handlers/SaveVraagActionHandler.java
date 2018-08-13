package controller.handlers;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Categorie;
import model.Vraag;
import view.panels.QDPPopUp;

public class SaveVraagActionHandler implements EventHandler<ActionEvent> {

	private QDPPopUp QDPane;
	private Controller controller;
	private Categorie categorie;

	public SaveVraagActionHandler(QDPPopUp QDPane, Controller controller) {
		this.QDPane = QDPane;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		String vraag = QDPane.getPane().getQuestionText();
		String categorie = QDPane.getPane().getCategorieText();
		
		Vraag result = new Vraag(vraag, categorie);
		controller.getService().addVraag(result);
		QDPane.getPane().clearFields();
		QDPane.closePopUp();

	}

}

package controller.handlers;

import java.util.List;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Vraag;
import model.VraagFactory;
import view.panels.QDPPopUp;

public class SaveVraagActionHandler implements EventHandler<ActionEvent> {

	private QDPPopUp QDPane;
	private Controller controller;
	private VraagFactory vraagfactory = new VraagFactory();

	public SaveVraagActionHandler(QDPPopUp QDPane, Controller controller) {
		this.QDPane = QDPane;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		String vraag = QDPane.getPane().getQuestionText();
		String categorie = QDPane.getPane().getCategorieText();
		String feedback = QDPane.getPane().getFeedbackText();
		List<String> antwoorden = QDPane.getPane().getStatements();
		
		Vraag result = vraagfactory.createVraag(vraag, categorie, feedback, antwoorden);
		controller.getService().addVraag(result);
		QDPane.getPane().clearFields();
		QDPane.closePopUp();

	}

}

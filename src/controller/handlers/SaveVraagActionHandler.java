/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package controller.handlers;

import java.util.List;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Vraag;
import model.vraag.VraagFactory;
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
		String correct = QDPane.getPane().getStatementText();
		List<String> antwoorden = QDPane.getPane().getStatements();
		
		Vraag result = vraagfactory.createVraag(vraag, categorie, feedback,correct, antwoorden);
		controller.getService().addVraag(result);
		QDPane.getPane().clearFields();
		QDPane.closePopUp();

	}

}

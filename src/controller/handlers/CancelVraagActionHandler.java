package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.QDPPopUp;

public class CancelVraagActionHandler implements EventHandler<ActionEvent> {
	
	private QDPPopUp QDPane;

	public CancelVraagActionHandler(){
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.QDPane.getPane().clearFields();;
		this.QDPane.closePopUp();
	}
	
	public void setCancelVraagActionHandler(QDPPopUp QDPane) {
		this.QDPane = QDPane;
	}

}

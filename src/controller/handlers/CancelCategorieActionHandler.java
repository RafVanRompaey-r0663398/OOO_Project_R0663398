package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.CDPPopUp;

public class CancelCategorieActionHandler implements EventHandler<ActionEvent> {
	
	private CDPPopUp CDPane;

	public CancelCategorieActionHandler(){
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.CDPane.getPane().clearFields();;
		this.CDPane.closePopUp();
	}
	
	public void setCategoryDetailPane(CDPPopUp CDPane) {
		this.CDPane = CDPane;
	}

}

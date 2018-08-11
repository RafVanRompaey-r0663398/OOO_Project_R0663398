package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.PopUp;

public class CancelActionHandler implements EventHandler<ActionEvent> {
	
	private PopUp CDPane;

	public CancelActionHandler(){
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.CDPane.getPane().clearDescriptionFieldString();
		this.CDPane.getPane().clearTitleFieldString();
		this.CDPane.closePopUp();
	}
	
	public void setCategoryDetailPane(PopUp CDPane) {
		this.CDPane = CDPane;
	}

}

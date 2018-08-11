package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.PopUp;

public class NewQuestionActionHandler implements EventHandler<ActionEvent>{

	private PopUp QDPane;
	
	public NewQuestionActionHandler(){
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		QDPane.showPopUp();
		
	}
	
	public void setCategoryDetailPane(PopUp CDPane) {
		this.QDPane = CDPane;
	}

}

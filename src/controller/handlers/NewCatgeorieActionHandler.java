package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.CDPPopUp;

public class NewCatgeorieActionHandler implements EventHandler<ActionEvent> {

	private CDPPopUp CDPane;

	public NewCatgeorieActionHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		CDPane.showPopUp();
	}

	public void setCategoryDetailPane(CDPPopUp CDPane) {
		this.CDPane = CDPane;
	}

}

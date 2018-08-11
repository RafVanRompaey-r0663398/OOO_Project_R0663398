package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.PopUp;

public class NewCatgeoryActionHandler implements EventHandler<ActionEvent> {

	private PopUp CDPane;

	public NewCatgeoryActionHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		CDPane.showPopUp();
	}

	public void setCategoryDetailPane(PopUp CDPane) {
		this.CDPane = CDPane;
	}

}

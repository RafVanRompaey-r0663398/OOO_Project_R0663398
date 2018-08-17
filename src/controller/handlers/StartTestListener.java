package controller.handlers;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartTestListener implements EventHandler<ActionEvent>{
	private Controller controller;

	public StartTestListener(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		this.controller.setVraagCounter(0);
		controller.getService().getEvaluatie().StartTest();
		this.controller.getTestPopUp().showPopUp();
	}

}


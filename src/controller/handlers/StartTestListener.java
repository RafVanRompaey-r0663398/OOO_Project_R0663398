/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
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


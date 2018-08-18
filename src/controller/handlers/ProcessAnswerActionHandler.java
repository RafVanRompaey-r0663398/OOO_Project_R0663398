/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package controller.handlers;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Evaluatie;
import model.Vraag;
import view.panels.TestPane;

public class ProcessAnswerActionHandler implements EventHandler<ActionEvent> {

	private TestPane testPane;
	private Controller controller;
	private int vraagCounter;

	public ProcessAnswerActionHandler(TestPane testPane, Controller controller) {
		this.testPane=testPane;
		this.controller=controller;
		this.vraagCounter=controller.getVraagCounter();
	}

	@Override
	public void handle(ActionEvent event) {
		String antwoord = testPane.getSelectedStatements().toString().replace('[', ' ').replace(']', ' ');
		if(this.controller.getService().getEvaluatie().isJuistAntwoord(antwoord, controller.getVraagCurrent().getCorrect())){
			this.controller.getService().getEvaluatie().determineScore(controller.getVraagCurrent(), true);
			if(vraagCounter+1==controller.getService().getVragenObserverList().size()){
				this.closeTest();
			}
			else{
				this.incremenet();
			}
		}
		else{
			this.controller.getService().getEvaluatie().determineScore(controller.getVraagCurrent(), false);
			if(vraagCounter+1==controller.getService().getVragenObserverList().size()){
				this.closeTest();
			}
			else{
				this.incremenet();
			}
		}
	}
	private void closeTest(){
		controller.getTestPopUp().closePopUp();
	}
	private void incremenet(){
		vraagCounter++;
		controller.setVraagCounter(vraagCounter);
		controller.getTestPopUp().newQuestion();
	}
}

package controller.handlers;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Vraag;
import view.panels.TestPane;

public class ProcessAnswerActionHandler implements EventHandler<ActionEvent> {

	private TestPane testPane;
	private Controller controller;
	private int vraagCounter;
	private Vraag vraag;

	public ProcessAnswerActionHandler(TestPane testPane, Controller controller) {
		this.testPane=testPane;
		this.controller=controller;
		this.vraagCounter=controller.getVraagCounter();
		this.vraag = controller.getService().getVragenObserverList().get(vraagCounter);
	}

	@Override
	public void handle(ActionEvent event) {
		if(testPane.getSelectedStatements().toString().replace('[', ' ').replace(']', ' ').contains(vraag.getFeedback())){
			System.out.println("juist");
			if(vraagCounter+1==controller.getService().getVragenObserverList().size()){
				this.closeTest();
			}
			else{
				this.incremenet();
			}
		}
		if(!testPane.getSelectedStatements().toString().replace('[', ' ').replace(']', ' ').contains(vraag.getFeedback())){
			System.out.println("fout");
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
		controller.setVraagCounter(0);
		this.vraagCounter=0;
	}
	private void incremenet(){
		vraagCounter++;
		controller.setVraagCounter(vraagCounter);
		controller.getTestPopUp().newQuestion();
	}
}

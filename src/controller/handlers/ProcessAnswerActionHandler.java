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
	private Vraag vraag;
	private Evaluatie evaluatie;

	public ProcessAnswerActionHandler(TestPane testPane, Controller controller) {
		this.testPane=testPane;
		this.controller=controller;
		this.vraagCounter=controller.getVraagCounter();
		this.vraag = controller.getService().getVragenObserverList().get(vraagCounter);
		this.evaluatie = controller.getService().getEvaluatie();
	}

	@Override
	public void handle(ActionEvent event) {
		String antwoord = testPane.getSelectedStatements().toString().replace('[', ' ').replace(']', ' ');
		if(this.evaluatie.isJuistAntwoord(antwoord, vraag.getCorrect())){
			System.out.println("juist");
			this.evaluatie.determineScore(vraag, true);
			if(vraagCounter+1==controller.getService().getVragenObserverList().size()){
				this.closeTest();
			}
			else{
				this.incremenet();
			}
		}
		else{
			System.out.println("fout");
			this.evaluatie.determineScore(vraag, false);
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

/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package view.panels;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.handlers.ProcessAnswerActionHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Vraag;

public class TestPane extends GridPane {
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;
	private Controller controller;
	private ProcessAnswerActionHandler processAnswerActionHandler;

	public TestPane(Controller controller) {
		this.controller = controller;
		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		questionField = new Label();
		questionField.setText(controller.getVraagCurrent().getQuestion());
		add(questionField, 0, 0, 1, 1);
		
		
		statementGroup = new ToggleGroup();
		for (int i = 0; i < controller.getService().getVragenObserverList().get(controller.getVraagCounter()).getAntwoorden().size(); i++) {
			RadioButton radioButton = new RadioButton();
			radioButton.setText((controller.getVraagCurrent().getAntwoorden().get(i)));
			radioButton.setUserData(controller.getVraagCurrent().getAntwoorden().get(i));
			radioButton.setToggleGroup(statementGroup);
			add(radioButton, 0, 2 + i, 1, 1);
		}

		submitButton = new Button("Submit");
		add(submitButton, 0, 11, 1, 1);
		this.processAnswerActionHandler = new ProcessAnswerActionHandler(this, controller);
		this.setProcessAnswerAction(processAnswerActionHandler);
	}

	public void setProcessAnswerAction(EventHandler<ActionEvent> processAnswerAction) {
		submitButton.setOnAction(processAnswerAction);
	}

	public List<String> getSelectedStatements() {
		List<String> selected = new ArrayList<String>();
		if (statementGroup.getSelectedToggle() != null) {
			selected.add(statementGroup.getSelectedToggle().getUserData().toString());
		}
		return selected;
	}

	public void newQuestion() {
		this.getChildren().clear();
		Vraag vraag = controller.getVraagCurrent();
		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		questionField = new Label();
		questionField.setText(vraag.getQuestion());
		add(questionField, 0, 0, 1, 1);

		statementGroup = new ToggleGroup();
		for (int i = 0; i < controller.getService().getVragenObserverList().get(controller.getVraagCounter())
				.getAntwoorden().size(); i++) {
			RadioButton radioButton = new RadioButton();
			radioButton.setText((vraag.getAntwoorden().get(i)));
			radioButton.setUserData(vraag.getAntwoorden().get(i));
			radioButton.setToggleGroup(statementGroup);
			add(radioButton, 0, 2 + i, 1, 1);
		}

		submitButton = new Button("Submit");
		add(submitButton, 0, 11, 1, 1);
		this.processAnswerActionHandler = new ProcessAnswerActionHandler(this, controller);
		this.setProcessAnswerAction(processAnswerActionHandler);
	}
}

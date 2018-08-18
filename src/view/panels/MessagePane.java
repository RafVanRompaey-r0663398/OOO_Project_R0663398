/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package view.panels;

import controller.Controller;
import controller.handlers.StartTestListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.PropertiesReader;

public class MessagePane extends GridPane {
	private Button testButton;
	private Controller controller;

	public MessagePane(Controller controller, Stage primaryStage) {
		this.controller = controller;
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		if (controller.getService().getEvaluatie().getState().toString().equals("NoTakenTest")) {
			Text label = new Text();
			label.setText("You never did this evaluation");
			add(label, 0, 0, 1, 1);
			setHalignment(label, HPos.CENTER);
		}

		testButton = new Button("Evaluate");
		testButton.setOnAction(new StartTestListener(controller));
		add(testButton, 0, 1, 1, 1);
		setHalignment(testButton, HPos.CENTER);
	}

	public void refresh() {
		this.getChildren().clear();
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		if (controller.getService().getEvaluatie().getState().toString().equals("NoTakenTest")) {
			Text label = new Text();
			label.setText("You never did this evaluation");
			add(label, 0, 0, 1, 1);
			setHalignment(label, HPos.CENTER);
		}
		if (!controller.getService().getEvaluatie().getState().toString().equals("resultState")) {
			Text label = new Text();
			if (controller.getService().getEvaluatie().getFout().size() == 0) {
				label.setText("Schitterend! Alles perfect!");
			} else {
				if (controller.getService().getProps().getProperties().getProperty("evaluation.mode").contains("score")) {
					label.setText(controller.getService().getEvaluatie().ScoreText());
				} else {
					label.setText(controller.getService().getEvaluatie().feedbackText());
				}
			}
			add(label, 0, 0, 1, 1);
			setHalignment(label, HPos.CENTER);
		}

		testButton = new Button("Evaluate");
		testButton.setOnAction(new StartTestListener(controller));
		add(testButton, 0, 1, 1, 1);
		setHalignment(testButton, HPos.CENTER);
	}
}

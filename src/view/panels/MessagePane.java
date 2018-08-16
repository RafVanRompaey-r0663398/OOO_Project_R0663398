package view.panels;

import controller.Controller;
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
import javafx.stage.Stage;

public class MessagePane extends GridPane {
	private Button testButton;

	public MessagePane(Controller controller, Stage primaryStage) {
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		testButton = new Button("Evaluate");
		testButton.setOnAction(new StartTestListener(controller));
		add(testButton, 0, 1, 1, 1);
		setHalignment(testButton, HPos.CENTER);
	}

	class StartTestListener implements EventHandler<ActionEvent> {
		private Controller controller;

		public StartTestListener(Controller controller) {
			this.controller = controller;
		}

		@Override
		public void handle(ActionEvent event) {
				this.controller.getTestPopUp().showPopUp();			
		}

	}
}

package controller;

import controller.handlers.NewActionHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Service;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

public class Controller {

	private Service service;
	private NewActionHandler newAction;

	public Controller() {
		this.service = new Service();
		this.newAction = new NewActionHandler();
	}
	
	public void start(Stage primaryStage) {

		try {
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane();
			QuestionDetailPane questionDetailPane = new QuestionDetailPane();

			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(service.getObserverList());
			CategoryDetailPane categoryDetailPanel = new CategoryDetailPane();

			TestPane testPane = new TestPane();
			MessagePane messagePane = new MessagePane();

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);
			/*set new action handler*/
			newAction.setCategoryDetailPane(categoryDetailPanel);
			categoryOverviewPanel.setNewAction(newAction);
			/*______________________*/
			BorderPane borderPane = new AssesMainPane(messagePane, categoryOverviewPanel, questionOverviewPane);
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(borderPane);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

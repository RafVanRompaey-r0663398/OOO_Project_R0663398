package view.panels;

import controller.Controller;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestPopUp {

	private TestPane testPane;
	private Stage stage = new Stage();
	private Stage primaryStage;
	private Controller controller;

	public TestPopUp(Stage primaryStage, Controller controller) {
		this.primaryStage = primaryStage;
		this.testPane= new TestPane(controller);
		this.setPane(testPane);
		Scene scene = new Scene(testPane, 750, 400);
		stage.setTitle("OO-Ontwerp test");
		stage.setScene(scene);
	}

	public TestPane getPane() {
		return this.testPane;
	}

	private void setPane(TestPane pane) {
		this.testPane = pane;
	}

	public void showPopUp() {
		primaryStage.hide();
		stage.show();
	}

	public void closePopUp() {
		stage.close();
		primaryStage.show();
	}
	public void newQuestion(){
		stage.close();
		testPane.newQuestion();
		stage.show();
	}

}

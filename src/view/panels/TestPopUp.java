package view.panels;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestPopUp {

	private TestPane pane;
	private int heigth, legth;
	private String title;
	Stage stage = new Stage();
	Stage primaryStage;

	public TestPopUp(Stage primaryStage, TestPane pane) {
		this.primaryStage = primaryStage;
		Scene scene = new Scene(pane, 750, 400);
		stage.setTitle("de test");
		stage.setScene(scene);
	}

	public TestPane getPane() {
		return this.pane;
	}

	private void setPane(TestPane pane) {
		this.pane = pane;
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public void showPopUp() {
		primaryStage.hide();
		stage.show();
	}

	public void closePopUp() {
		stage.close();
		primaryStage.show();
	}

}

/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package view.panels;
import controller.Controller;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestPopUp {

	private TestPane testPane;
	private Stage stage = new Stage();
	private Stage primaryStage;
	private Controller controller;
	
	public TestPopUp(Stage primaryStage, TestPane testPane,Controller controller) {
		this.controller=controller;
		this.primaryStage = primaryStage;
		this.testPane= testPane;
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
		primaryStage.close();
		stage.show();
	}

	public void closePopUp() {
		stage.close();
		this.controller.getMessagePane().refresh();
		primaryStage.show();
	}
	public void newQuestion(){
		testPane.newQuestion();
	}

}

package view.panels;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class QDPPopUp {
	private QuestionDetailPane pane;
	private int heigth, legth;
	private String title;
	Stage stage = new Stage();

	public QDPPopUp(QuestionDetailPane pane,String title,int heigth,int length){
		this.setPane(pane);
		this.setTitle(title);
		this.setHeigth(heigth);
		this.setLegth(length);
		stage.setTitle(this.title);
		Scene scene = new Scene(this.pane,this.legth,this.heigth);
		stage.setScene(scene);
	}

	public QuestionDetailPane getPane() {
		return this.pane;
	}

	private void setPane(QuestionDetailPane pane) {
		this.pane = pane;
	}

	public int getHeigth() {
		return heigth;
	}

	private void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getLegth() {
		return legth;
	}

	private void setLegth(int legth) {
		this.legth = legth;
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public void showPopUp() {
		stage.show();
	}

	public void closePopUp() {
		stage.close();
	}

}

package controller;

import controller.handlers.CancelCategorieActionHandler;
import controller.handlers.CancelVraagActionHandler;
import controller.handlers.NewCatgeorieActionHandler;
import controller.handlers.NewVraagActionHandler;
import controller.handlers.SaveCategorieActionHandler;
import controller.handlers.SaveVraagActionHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Service;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QDPPopUp;
import view.panels.CDPPopUp;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

public class Controller {

	private Service service;
	private NewCatgeorieActionHandler newCategorieAction;
	private NewVraagActionHandler newVraagAction;
	private CancelCategorieActionHandler cancelCategorieAction;
	private CancelVraagActionHandler cancelVraagAction;
	private SaveCategorieActionHandler saveCategorieAction;
	private SaveVraagActionHandler saveVraagAction;
	private CDPPopUp addCategorie;
	private QDPPopUp addVraag;

	public Controller() {
		this.service = new Service();
		this.newCategorieAction = new NewCatgeorieActionHandler();
		this.newVraagAction = new NewVraagActionHandler();
		this.cancelCategorieAction = new CancelCategorieActionHandler();
		this.cancelVraagAction = new CancelVraagActionHandler();
	}

	public void start(Stage primaryStage) {

		try {
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(this.service);
			QuestionDetailPane questionDetailPane = new QuestionDetailPane(this.service);

			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(this.service);
			CategoryDetailPane categoryDetailPanel = new CategoryDetailPane(this.service);

			this.addCategorie = new CDPPopUp(categoryDetailPanel, "Category add", 200, 300);
			this.addVraag = new QDPPopUp(questionDetailPane, "Question add", 300, 500);
			/* set new Categorie action handler */
			newCategorieAction.setCategoryDetailPane(addCategorie);
			categoryOverviewPanel.setNewAction(newCategorieAction);
			/* set new vraag action handler */
			newVraagAction.setCategoryDetailPane(addVraag);
			questionOverviewPane.setNewAction(newVraagAction);
			/* set Cancel Categorie handler */
			cancelCategorieAction.setCategoryDetailPane(addCategorie);
			categoryDetailPanel.setCancelAction(cancelCategorieAction);
			/* set Cancel vraag handler */
			cancelVraagAction.setCancelVraagActionHandler(addVraag);
			questionDetailPane.setCancelAction(cancelVraagAction);
			/*set save Categorie action handler*/
			this.saveCategorieAction = new SaveCategorieActionHandler(addCategorie, this);
			categoryDetailPanel.setSaveAction(saveCategorieAction);
			/*set save vraag action handler*/
			this.saveVraagAction = new SaveVraagActionHandler(addVraag, this);
			questionDetailPane.setSaveAction(saveVraagAction);
			/* ______________________ */

			TestPane testPane = new TestPane();
			MessagePane messagePane = new MessagePane();

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);
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

	public Service getService() {
		return this.service;
	}
}

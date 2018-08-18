/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package view.panels;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import model.Service;

public class CategoryOverviewPane extends GridPane {
	private TableView table;
	private Button btnNew;
	public CategoryOverviewPane(Controller controller) {
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Categories:"), 0, 0, 1, 1);

		table = new TableView<>();
		table.setPrefWidth(REMAINING);
		TableColumn<String, String> nameCol = new TableColumn<String, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory("title"));
		table.getColumns().add(nameCol);
		TableColumn<String, String> descriptionCol = new TableColumn<String, String>("Description");
		descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));
		table.getColumns().add(descriptionCol);
		table.setItems(controller.getService().getCategorieObserverList());
		this.add(table, 0, 1, 2, 6);

		btnNew = new Button("New");
		this.add(btnNew, 0, 11, 1, 1);
	}

	public void setNewAction(EventHandler<ActionEvent> newAction) {
		btnNew.setOnAction(newAction);
	}

	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}


}

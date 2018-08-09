package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.CategoryDetailPane;

public class NewActionHandler implements EventHandler<ActionEvent> {

	private CategoryDetailPane CDPane;

	public NewActionHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		 System.out.println("pop up venster");
	}

	public void setCategoryDetailPane(CategoryDetailPane CDPane) {
		this.CDPane = CDPane;
	}

}

/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.CDPPopUp;

public class NewCatgeorieActionHandler implements EventHandler<ActionEvent> {

	private CDPPopUp CDPane;

	public NewCatgeorieActionHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		CDPane.showPopUp();
	}

	public void setCategoryDetailPane(CDPPopUp CDPane) {
		this.CDPane = CDPane;
	}

}

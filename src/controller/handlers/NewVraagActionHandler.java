/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package controller.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.QDPPopUp;

public class NewVraagActionHandler implements EventHandler<ActionEvent>{

	private QDPPopUp QDPane;
	
	public NewVraagActionHandler(){
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		QDPane.showPopUp();
		
	}
	
	public void setCategoryDetailPane(QDPPopUp QDPane) {
		this.QDPane = QDPane;
	}
}

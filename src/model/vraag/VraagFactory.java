/*@author  Van_Rompaey_Raf-r0663398
 * git-rep = https://github.com/RafVanRompaey-r0663398/Project-Herkansing_R0663398.git
 * */
package model.vraag;

import java.util.ArrayList;
import java.util.List;

import model.Vraag;
import model.exceptions.ModelException;

public class VraagFactory {

	public VraagFactory() {

	}

	public Vraag createVraag(String question, String category, String feedback,String correct, List<String> antwoorden) {
		Vraag vraag = null;
		String type = TypeVraag(antwoorden);
		if (type == "YesNoQuestion") {
			vraag = new YesNoVraag(question, category, feedback, correct, antwoorden);
		} else if (type == "MultipleChoiceQuestion") {
			vraag = new MultipleChoiceVraag(question, category, feedback,correct, antwoorden);
		} else {
			throw new ModelException("not suported type");
		}
		return vraag;
	}

	public String TypeVraag(List<String> antwoorden) {
		List<String> accepted = new ArrayList<String>();
		accepted.add("Yes");
		accepted.add("No");
		if (antwoorden.size() < 2) {
			throw new ModelException("not suported type");
		}
		if (antwoorden.size() == 2 && antwoorden.containsAll(accepted)) {
			return "YesNoQuestion";
		} else {
			return "MultipleChoiceQuestion";
		}
	}

}

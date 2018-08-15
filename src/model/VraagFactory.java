package model;

import java.util.ArrayList;
import java.util.List;

public class VraagFactory {

	public VraagFactory() {

	}

	public Vraag createVraag(String question, String category, String feedback, List<String> antwoorden) {
		Vraag vraag = null;
		String type = TypeVraag(antwoorden);
		if (type == "YesNoQuestion") {
			vraag = new YesNoVraag(question, category, feedback, antwoorden);
		} else if (type == "MultipleChoiceQuestion") {
			vraag = new MultipleChoiceVraag(question, category, feedback, antwoorden);
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

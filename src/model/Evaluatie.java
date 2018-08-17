package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.db.DbVragenRepository;
import model.state.NoTakenTestState;
import model.state.State;
import model.state.TakingTestState;
import model.state.TestResultState;

public class Evaluatie {

	private List<Vraag> juist, fout;
	private ObservableList<Vraag> oListJuist, oListFout;
	private int aantalVragen;
	private DbVragenRepository vragen;

	private State state;
	private State takingTest;
	private State NoTakenTest;
	private State ResultState;
	

	public Evaluatie(DbVragenRepository vragen) {
		this.vragen = vragen;
		juist = new ArrayList<Vraag>();
		oListJuist = FXCollections.observableArrayList(juist);
		fout = new ArrayList<Vraag>();
		oListFout = FXCollections.observableArrayList(fout);
		this.setAantalVragen(vragen.getOList().size());
		
		this.takingTest = new TakingTestState();
		this.NoTakenTest = new NoTakenTestState();
		this.ResultState = new TestResultState();
		state = this.NoTakenTest;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Vraag> getJuist() {
		return this.juist;
	}

	public List<Vraag> getFout() {
		return this.fout;
	}

	public ObservableList<Vraag> getOListJuist() {
		return this.oListJuist;
	}

	public ObservableList<Vraag> getOListFout() {
		return this.oListFout;
	}

	public void setAantalVragen(int aantalVragen) {
		this.aantalVragen = aantalVragen;
	}
	
	public void StartTest() {
		this.juist.clear();
		this.fout.clear();
		this.oListJuist.clear();
		this.oListFout.clear();
		
		this.state=this.takingTest;
	}
	
	public void EndTest() {
		this.state=this.ResultState;
	}

	public void determineScore(Vraag vraag, Boolean juistantwoord) {
		if (juistantwoord) {
			juist.add(vraag);
			this.oListJuist.add(vraag);
		} else {
			fout.add(vraag);
			this.oListFout.add(vraag);
		}
	}

	public boolean isJuistAntwoord(String antwoord, String sleutel) {
		if (antwoord.replace('[', ' ').replace(']', ' ').contains(sleutel)) {
			return true;
		}
		return false;
	}

	public String ScoreText() {
		return "Your score: " + juist.size() + "/" + this.aantalVragen + "\n" + this.CategoryText();
	}

	public String CategoryText() {
		String result = "";
		for (int i = 0; i < this.aantalVragen; i++) {
			if(!result.contains(vragen.getOList().get(i).getCategory())){
				result += "Category "+vragen.getOList().get(i).getCategory()+":\n";
			}
		}
		return result;
	}
	public String feedbackText() {
		String result = "";
		for (int i = 0; i < this.fout.size(); i++) {
				result +=fout.get(i).getFeedback()+"\n";
		}
		return result;
	}
}

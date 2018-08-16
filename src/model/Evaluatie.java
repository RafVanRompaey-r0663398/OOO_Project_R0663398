package model;

import java.util.ArrayList;
import java.util.List;

public class Evaluatie {
	
	private List<Vraag> juist,fout;
	
	public Evaluatie(){
		juist = new ArrayList<Vraag>();
		fout = new ArrayList<Vraag>();
	}
	
	public void determineScore(Vraag vraag,String antwoord, String sleutel){
		if(this.isJuistAntwoord(antwoord, sleutel)){
			juist.add(vraag);
		}
		else{
			fout.add(vraag);
		}
	}
	
	public boolean isJuistAntwoord(String antwoord, String sleutel){
		if(antwoord.replace('[', ' ').replace(']', ' ').contains(sleutel)){
			return true;
		}
		return false;
	}

}

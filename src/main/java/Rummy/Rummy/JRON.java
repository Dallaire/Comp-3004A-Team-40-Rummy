package Rummy.Rummy;

import java.util.ArrayList;
/**
 * Java Rummy Object Notation
 * Data object pushed to players as part of the Observer Pattern*/
public class JRON {
	
	private ArrayList<ArrayList<Tile>> melds;
	private boolean firstMeld = false;
	private boolean threeLess = false;

	
	public JRON(ArrayList<ArrayList<Tile>> melds,boolean firstMeld,boolean threeLess ) {
		this.setMelds(melds);
		this.setFirstMeld(firstMeld);
		this.setThreeLess(threeLess);
		
	}

	// Getter and Setter for the data fields
	
	public ArrayList<ArrayList<Tile>> getMelds() {
		return melds;
	}

	public void setMelds(ArrayList<ArrayList<Tile>> melds) {
		this.melds = melds;
	}

	public boolean getFirstMeld() {
		return firstMeld;
	}

	public void setFirstMeld(boolean firstMeld) {
		this.firstMeld = firstMeld;
	}

	public boolean getThreeLess() {
		return threeLess;
	}

	public void setThreeLess(boolean threeLess) {
		this.threeLess = threeLess;
	}
	
}

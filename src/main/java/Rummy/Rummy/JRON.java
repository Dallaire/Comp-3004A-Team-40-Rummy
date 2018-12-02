package Rummy.Rummy;

import java.util.ArrayList;
/**
 * Java Rummy Object Notation
 * Data object pushed to players as part of the Observer Pattern*/
public class JRON {
		
	private boolean firstMeld = false;
	private boolean threeLess = false;
	private ArrayList<ArrayList<Tile>> melds = new ArrayList<ArrayList<Tile>>();
	private String context = null;
	private Deck stock = null;
	
	public JRON(ArrayList<ArrayList<Tile>> melds,boolean firstMeld,boolean threeLess, String context, Deck stock) {
		this.setMelds(melds);
		this.setFirstMeld(firstMeld);
		this.setThreeLess(threeLess);
		this.setContext(context);
		this.setStock(stock);
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
		return this.threeLess;
	}

	public void setThreeLess(boolean threeLess) {
		this.threeLess = threeLess;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Deck getStock() {
		return stock;
	}

	public void setStock(Deck deck) {
		this.stock = deck;
	}
	
}

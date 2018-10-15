package Rummy.Rummy;

import java.util.ArrayList;

public class Player {
	//Properties
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	private String name;
	private Strategy strategy;
	private Boolean first30 = false; //flag for if first 30 pts have been played
	
	//Constructor
	public Player(String aName, Strategy aStrategy) {
		this.name = aName;
		this.setStrategy(aStrategy);
	}
	
	//Setter
	public void setStrategy(Strategy aStrategy){
		this.strategy = aStrategy;
	}
	
	public void setFirst30(Boolean bool) {
		this.first30 = bool;
	}
	
	//getters
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public ArrayList<Tile> getHand(){
		return this.hand;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Boolean getFirst30() {
		return this.first30;
	}
	
	//Functionality
	public void addTile(Tile aTile) {
		this.getHand().add(aTile);
	}
	
}

package Rummy.Rummy;

import java.util.ArrayList;

public class Player {
	//Properties
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	private String name;
	private Strategy strategy;
	
	//Constructor
	public Player(String aName, Strategy aStrategy) {
		this.name = aName;
		this.setStrategy(aStrategy);
	}
	
	//Setter
	public void setStrategy(Strategy aStrategy){
		this.strategy = aStrategy;
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
	
	
	//Functionality
	public void addTile() {
		
	}
	
}

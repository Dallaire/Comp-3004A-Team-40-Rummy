package Rummy.Rummy;

import java.util.ArrayList;

public class Player {
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	private String name;
	private Strategy strategy;
	
	public Player(String aName, Strategy aStrategy) {
		this.name = aName;
		this.setStrategy(aStrategy);
	}
	
	public void setStrategy(Strategy aStrategy){
		this.strategy = aStrategy;
	}
	
	public ArrayList<Tile> getHand(){
		return this.hand;
	}
	
	public void addTile() {
		
	}
}

package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;

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
	public void sortHand() {
		Collections.sort(hand,new valueComparator());
	}
	public Tile removeTile(int i) {
		return this.hand.remove(i);
	}
	//Functionality
	public void addTile(Tile aTile) {
		this.getHand().add(aTile);
	}
	public void discardMeld(ArrayList<Tile> meld) {
		for (int i = 0; i < meld.size(); i++) {
			hand.add(meld.get(i));
		}
	}
	public boolean check30(ArrayList<Tile> meld) {
		int sum=0;
		for(int i=0;i<meld.size();i++) {
			sum+=meld.get(i).getValue();
		}
		if (sum>30) {
			return true;
		}
		return false;
		
	}	
		
}

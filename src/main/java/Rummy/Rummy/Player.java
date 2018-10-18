package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	//Properties
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	private String name;
	private Strategy strategy;
	
	//Constructor
	public Player(String aName) {
		this.name = aName;
	}
	public void playTurn() {
		strategy.playTurn();
	}
	//Setter
	public void setStrategy(Strategy aStrategy){
		strategy=aStrategy;
	}
	
	
	//getters
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public ArrayList<Tile> getHand(){
			
		return this.hand;
	}
	
	public void getCards(Deck stock) {
		for(int j=0;j<14;j++) {
			addTile(stock.geTile(stock.getSize()-1));
		}
}

	
	public String getName() {
		return this.name;
	}
	/**
	 * sorts the hand*/
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
	/**
	 * returns meld to player hand*/
	public void discardMeld(ArrayList<Tile> meld) {
		for (int i = 0; i < meld.size(); i++) {
			hand.add(meld.get(i));
		}
	}
	/**
	 * checks if the given meld is greater than of equal 30*/
	public boolean check30(ArrayList<Tile> meld) {
		int sum=0;
		for(int i=0;i<meld.size();i++) {
			sum+=meld.get(i).getValue();
		}
		if (sum>=30) {
			return true;
		}
		return false;
		
	}	
	public void customFillHand() {
		hand.add(new Tile(Color.B,1 ));
		hand.add(new Tile(Color.B,2 ));
		hand.add(new Tile(Color.O,6 ));
		hand.add(new Tile(Color.O,7 ));
		hand.add(new Tile(Color.O,8 ));
		hand.add(new Tile(Color.O,12 ));
		hand.add(new Tile(Color.G,5));
		hand.add(new Tile(Color.G,7 ));
		hand.add(new Tile(Color.G,8 ));
		hand.add(new Tile(Color.R,1 ));
		hand.add(new Tile(Color.R,4 ));
		hand.add(new Tile(Color.R,8 ));
		hand.add(new Tile(Color.R,9 ));
		hand.add(new Tile(Color.R,10 ));
		hand.add(new Tile(Color.R,11 ));
		//hand.add(new Tile(Color.R,1 ));

		
	}
		
}

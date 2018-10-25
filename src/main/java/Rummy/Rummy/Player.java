package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	//Properties
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	private String name;
	private ArrayList<Tile> meld;

	
	//Constructor
	public Player(String aName) {
		this.name = aName;
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
	 * sorts the hand
	 * */
	public void sortHand() {
		Collections.sort(hand,new valueComparator());
	}
	/**
	 * Remove a tile
	 * */
	public Tile removeTile(int i) {
		return this.hand.remove(i);
	}
	
	/**
	 * Add a tile to the players hand
	 * */
	public void addTile(Tile aTile) {
		this.getHand().add(aTile);
	}
	/**
	 * returns meld to player hand
	 * */
	public void discardMeld(ArrayList<Tile> meld) {
		for (int i = 0; i < meld.size(); i++) {
			hand.add(meld.get(i));
		}
	}
	/**
	 * checks if the given meld is greater than of equal 30*/
	
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

	/**
	 * checks for the run with the maximum sum ie O9,O10,O11,O12
	 * TODO: Does checkrun remove the tiles from the hand
	 **/
	public ArrayList<Tile> createRun() {
		ArrayList<Tile> temp = new ArrayList<Tile>();	    
		for (int i=hand.size()-1; i>0;i--) {
			temp.add(hand.get(i));
			for(int j=i-1;j>=0;j--) {
				if(MeldChecker.checkColor(temp.get(temp.size()-1), hand.get(j))
				&&MeldChecker.checkDifference(temp.get(temp.size()-1), hand.get(j))) {
					if (!temp.contains(hand.get(j))) {
						temp.add(hand.get(j));
					}
				}
			}
			if(temp.size()>=3) {
				return temp;
			}
			temp.clear();	
		}
		
		System.out.println("");
		return null;
	}
	/**
	 * checks if a player has a set ie O11,B11,R11,G11*/
	public ArrayList<Tile> createSet() {
		ArrayList<Tile> temp= new ArrayList<Tile>();
		for(int i=hand.size()-1; i>0;i--) {
			temp.add(hand.get(i));
			for(int j=i-1;j>=0;j--) {
			if(temp.get(temp.size()-1).getValue()==hand.get(j).getValue()) {
					temp.add(hand.get(j));
				}
			}
			if(temp.size()>=3) {
				return temp;
			}
			temp.clear();
		}
		System.out.println("");
		return temp;
	}
	
	
	
		
}

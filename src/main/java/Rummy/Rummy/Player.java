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

	/**
	 * checks for the run with the maximum sum ie O9,O10,O11,O12
	 * TODO: Does checkrun remove the tiles from the hand
	 **/
	public ArrayList<Tile> checkRun(ArrayList<Tile> aHand) {
		meld = new ArrayList<Tile>();
	    int meldSize =0;
	    
		for(int i=aHand.size()-1; i>0;i--) {
			meld.add(aHand.get(i));
			meldSize++;
			for(int j=i-1;j>=0;j--) {
				if(checkColor(meld.get(meldSize-1), aHand.get(j))
				&&checkDifference(meld.get(meldSize-1), aHand.get(j))) {
					if (!meld.contains(aHand.get(j))) {
						meld.add(aHand.get(j));
						meldSize++;
					}
				}
			}
			if(meld.size()>=3) {
				return meld;
			}
			meld.clear();	
		}
		
		System.out.println("");
		return null;
	}
	
	/**
	 * checks if a player has a set ie O11,B11,R11,G11*/
	public ArrayList<Tile> checkSet(ArrayList<Tile> aHand) {
		meld = new ArrayList<Tile>();
	    int meldSize=0;
		for(int i=aHand.size()-1; i>0;i--) {
			//System.out.println("im here");
			meld.add(aHand.get(i));
			meldSize++;
			for(int j=i-1;j>=0;j--) {
				//System.out.println("im here");
			 //System.out.println("im here "+meld.get(meldSize).toString());
				//System.out.println(meld.get(meldSize-1).toString());
			if(meld.get(meldSize-1).getValue()==aHand.get(j).getValue()) {
//					//System.out.print(","+aHand.get(j).toString());
					meld.add(aHand.get(j));
//					//System.out.println("im here");
					meldSize++;
				}
			}

		}
		return null;
	}
	
	/**
	 * compares the color of the 2 giver tiles and returns true if equal otherwise false*/
	public boolean checkColor(Tile t1,Tile t2) {
		return t1.colorToString().equals(t2.colorToString());
	}
	/**
	 * compares the value of the 2 giver tiles and returns true if the difference=1 otherwise false*/
	public boolean checkDifference(Tile t1, Tile t2) {
		if ((t1.getValue()-t2.getValue())==1) {
			return true;
		}
		return false;
	}
	
		
}

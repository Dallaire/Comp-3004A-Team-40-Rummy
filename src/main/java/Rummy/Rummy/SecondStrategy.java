package Rummy.Rummy;

import java.util.ArrayList;

public class SecondStrategy extends Player implements Strategy{
	
	//Invoke super class constructor
	public SecondStrategy(String name) {
		super(name);
		
	}
	
	@Override
	public ArrayList<Tile> playTurn(){return null;} //leave blank
	
	public void playTurn2(ArrayList<ArrayList<Tile>> tableMelds) { //don't want to return anything, can just interact with table in the function
		this.setHasPlayed(false);
		if (playedFirst30) {
			if (tableData.getFirstMeld()) { //First 30 already played
				ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
				ArrayList<Tile> meld = this.createRun();
				if (meld == null) {
					meld = this.createSet();
				}
				while (meld != null) {
					temp.add(meld); //add in the meld
					meld = null;
					meld = this.createRun(); //create a new one
					if (meld == null) {
						meld = this.createSet();
					}
				}
				for (Tile tile : this.getHand()) { //play all tiles needing stuff on the board
					for (ArrayList<Tile> tableMeld: Table.getMelds()) {
						tableMeld.add(tile);
						if (!MeldChecker.checkHand(tableMeld)) {//invalid play
							tableMeld.remove(tile);
						}
						else { //valid keep move
							this.getHand().remove(tile);
							this.setHasPlayed(true);
							break;
						}
					}
				}
				if(this.getHand().isEmpty()) { //Win condition
					Table.getMelds().addAll(temp);
					this.setHasPlayed(true);
				}
				else {//return functional melds to hand
					for (ArrayList<Tile> tempMeld : temp) {
						this.getHand().addAll(tempMeld);
					}
					this.getHand().sort(new valueComparator());
				}
			}
			
			//Can play first 30 but hasn't yet
			else {
				ArrayList<Tile> meld = this.createRun();
				if(meld == null || !MeldChecker.check30(meld)) {
					this.getHand().addAll(meld);
					meld.clear();
					meld = this.createSet();
					if(MeldChecker.check30(meld)) {
						Table.addMeld(meld); // plays set as first 30
						this.setHasPlayed(true);
						
					}
					else {
						this.getHand().addAll(meld);
						meld.clear();
						// Default draw from stock
						this.addTile(Table.getTile());
					}
				}
				else {
					Table.addMeld(meld); //plays run as first 30
					this.setHasPlayed(true);
				}
			}
		}
		else {
		// Default draw from stock
			this.addTile(Table.getTile());
			
		}
	}
}

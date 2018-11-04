package Rummy.Rummy;

import java.util.ArrayList;

public class SecondStrategy extends Player implements Strategy{
	
	//Invoke super class constructor
	public SecondStrategy(String name) {
		super(name);
		
	}
	
	@Override
	/**
	 * SecondStrategy
	 * -Plays initial 30 only if another player has played their initial 30
	 * -If it can play all it's Tiles it does
	 * @return Collection of melds*/
	public ArrayList<ArrayList<Tile>> playTurn(){
		
		// pass if no one else has played
		if (tableData.getFirstMeld() == false) {
			return null;
		}
		
		// get all the Table Melds that greater than 3 in size
		
		return null;
		
	} //leave blank
	
	public ArrayList<ArrayList<Tile>> playTurn2() { //don't want to return anything, can just interact with table in the function
		this.setHasPlayed(false);
		ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
		
		if (tableData.getFirstMeld()) {
			if (this.playedFirst30) { //First 30 already played
				
				
				
				ArrayList<Tile> meld = this.createRun(null);
				// create a run or a set
				if (meld == null) {
					meld = this.createSet(null);
				}
				while (meld != null) {
					temp.add(meld); //add in the meld
					meld = null;
					meld = this.createRun(null); //create a new one
					if (meld == null) {
						meld = this.createSet(null);
					}
				}
				
				// keep track of all the played tiles
				ArrayList<Tile> played = new ArrayList<Tile>();
				
				// for each tile in the hand create a meld with tiles on the table
				for (Tile tile : this.getHand()) { //play all tiles needing stuff on the board
					
					// for each table meld check if adding a tile creates a valid meld
					for (ArrayList<Tile> tableMeld: tableData.getMelds()) {
						tableMeld.add(tile);
						if (!MeldChecker.checkHand(tableMeld)) {//invalid play
							tableMeld.remove(tile); //don't actually play it
						}
						else { //valid keep move
							played.add(tile); //play tile
							this.setHasPlayed(true);
							break;
						}
					}
				}
				
				this.getHand().removeAll(played); //remove all played tiles
				
				if(this.getHand().isEmpty()) { //Win condition
					Table.getMelds().addAll(temp);
					
					this.setHasPlayed(true);
					return temp;
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

				ArrayList<Tile> meld = this.createRun(null);
				if(meld == null || !MeldChecker.check30(meld)) {
					if (meld != null) {
						this.getHand().addAll(meld);
						meld.clear();
					}
					meld = this.createSet(null);
					if(meld != null && MeldChecker.check30(meld)) {
						//Table.addMeld(meld); // plays set as first 30
						
						temp.add(meld);
						this.setHasPlayed(true);
						
					}
					else {
						if(meld != null) {
							this.getHand().addAll(meld);
							meld.clear();
						}
						// Default draw from stock
						this.addTile(Table.getTile());
						return null;
					}
				}
				else {
					//Table.addMeld(meld); //plays run as first 30
					temp.add(meld);
					this.setHasPlayed(true);
				}
				
				
			}
		}
		else { //wait to play
		// Default draw from stock
			
			this.addTile(Table.getTile());
			return null;
		}
		
		return temp;
	}
}

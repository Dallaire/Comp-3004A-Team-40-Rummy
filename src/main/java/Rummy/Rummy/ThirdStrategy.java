package Rummy.Rummy;

import java.util.ArrayList;

public class ThirdStrategy extends Player implements Strategy{

	public ThirdStrategy(String aName, boolean isLocal) {
		super(aName, isLocal);
	}

	@SuppressWarnings("unused")
	@Override
	/**
	 * Play first 30 if possible
	 * Play all tiles if possible
	 * If no player has 3 fewer tiles, then play only tiles that require table input
	 * */
	public ArrayList<ArrayList<Tile>> playTurn() { //legacy method
		ArrayList<Tile> meldToPlay; 
		//Default draw from stock
		this.addTile(Table.getTile());
		meldToPlay = null;
		return null;	
	}
	
	public ArrayList<ArrayList<Tile>> playTurn2() {

		this.setHasPlayed(false);
		
		ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
		
		if (playedFirst30) { //already played once

			ArrayList<Tile> meld = this.createRun(null);
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
			
			ArrayList<Tile> played = new ArrayList<Tile>();
			for (Tile tile : this.getHand()) { //play all tiles needing stuff on the board
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
			if(played != null) {
				this.getHand().removeAll(played); //remove all played tiles
			}
			if(this.getHand().isEmpty()) { //Win condition
				if (temp != null) {
					Table.getMelds().addAll(temp);
					this.setHasPlayed(true);
				}
			}
			else {
				if (this.getJRON().getThreeLess()) { //play all possible melds
					if (temp != null) {
						Table.getMelds().addAll(temp);
						this.setHasPlayed(true);
					}
				}
				else{//return functional melds to hand
					if (temp != null) {
						for (ArrayList<Tile> tempMeld : temp) {
							this.getHand().addAll(tempMeld);
						}
					this.getHand().sort(new valueComparator());
					}
				}
			}
		}
		else { //has yet to play first 30 pts
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
				else { //cant play 30 pts
					if (meld != null) {
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
		
		return temp;
	}
}
package Rummy.Rummy;

import java.util.ArrayList;

public class FirstStrategy extends Player implements Strategy{

	public FirstStrategy(String name) {
		super(name);
	}
	public ArrayList<ArrayList<Tile>> playTurn(){return null;}
	public void playTurn(ArrayList<ArrayList<Tile>> tableMelds) { //don't want to return anything, can just interact with table in the function
		this.setHasPlayed(false);
		if (tableData.getFirstMeld()) {
			if (this.playedFirst30) { //First 30 already played
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
				ArrayList<Tile> played = new ArrayList<Tile>();
				for (Tile tile : this.getHand()) { //play all tiles needing stuff on the board
					for (ArrayList<Tile> tableMeld: Table.getMelds()) {
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
				}
				else {//return functional melds to hand
					for (ArrayList<Tile> tempMeld : temp) {
						this.getHand().addAll(tempMeld);
					}
					this.getHand().sort(new valueComparator());
				}
			}
	
	
		}
	}
}

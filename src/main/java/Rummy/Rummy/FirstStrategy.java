package Rummy.Rummy;

import java.util.ArrayList;

public class FirstStrategy extends Player implements Strategy{

	public FirstStrategy(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Tile> playTurn() {
		ArrayList<Tile> meldToPlay = new ArrayList<Tile>();
		
		// check if first 30 pts have been played
		
		/*
		if(MeldChecker.checkRun(this.getHand()) && MeldChecker.checkSet(this.getHand())) {
			
			//meldToPlay = checkRun(this.getHand());
			//table.addMeld(checkRun(this.getHand()));
			//removes the tiles from the players hand
			this.getHand().remove(checkRun(this.getHand()));
			
			
		}else if (this.check30(checkSet(this.getHand()))) {
			
			//table.addMeld(checkSet(this.getHand()));
			meldToPlay = checkSet(this.getHand());
			this.getHand().remove(checkSet(this.getHand()));
			
			
		}else {
			//otherwise player draws a new card from stock
			//this.addTile(table.getTile());
			meldToPlay = null;
			
		}*/
		this.addTile(Table.getTile());
		meldToPlay = null;
		return meldToPlay;
		
	}
	
	
}

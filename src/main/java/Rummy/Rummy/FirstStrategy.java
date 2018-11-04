package Rummy.Rummy;

import java.util.ArrayList;

public class FirstStrategy extends Player implements Strategy {

	public FirstStrategy(String name) {
		super(name);
	}

	/**
	 * Implements P1 of iteration 1
	 * P1 */
	public ArrayList<ArrayList<Tile>> playTurn() {
		ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
		
		temp = createMelds();
		
		int points = 0;
		// if no sets or runs where made grab one from the table and return null
		if (temp.size() == 0)	{
			temp = null;
			this.addTile(Table.getTile());
		} 
		else {
			
			// check how much these melds are worth
			for (ArrayList<Tile> tiles: temp) {
				points += MeldChecker.countPoints(tiles);
			}
			System.out.println(points);
			
			// if the first thirty criteria is not met
			if(points < 30 && this.playedFirst30 == false) {
				System.out.println("First Strategy melds do not have enough points to play to the Table");
				addMelds(temp);
				this.addTile(Table.getTile());
				temp =  null;
			}
		}
		
		return temp;
	}
	
	/**
	 * Function creates melds
	 * @return Collection of melds*/
	protected ArrayList<ArrayList<Tile>> createMelds() {
		
		ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
		
		// create all the sets possible
		while (true) {
			ArrayList<Tile> meld = createSet(null);
			
			// If there are no sets or run to create just give up
			if (meld == null) {
				break;
			} else {
				temp.add(meld);
			}
		}
		
		// create all the runs possible
		while (true) {
			ArrayList<Tile> meld = createRun(null);
			
			// If there are no sets or run to create just give up
			if (meld == null) {
				break;
			} else {
				temp.add(meld);
			}
		}
		
		return temp;
	}

//	public void playTurn(ArrayList<ArrayList<Tile>> tableMelds) { // don't want to return anything, can just interact
//																	// with table in the function
//		this.setHasPlayed(false);
//		if (this.playedFirst30) { // First 30 already played
//			// create a temporary array
//			ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
//			
//			// create a run
//			ArrayList<Tile> meld = this.createRun();
//			
//			// if a run can't be created create set
//			if (meld == null) {
//				meld = this.createSet();
//			}
//			
//			// A none null meld goes in here
//			// Keep creating runs and sets as much as possible
//			while (meld != null) {
//				temp.add(meld); // add in the meld
//				meld = null;
//				meld = this.createRun(); // create a new one
//				if (meld == null) {
//					meld = this.createSet();
//				}
//			}
//			
//			Table.addMeldz(temp);
//
//			if (this.getHand().isEmpty()) { // Win condition
//				Table.getMelds().addAll(temp);
//				this.setHasPlayed(true);
//			}
//			
//			
//			
//		} else {
//			// create a run 
//			ArrayList<Tile> meld = this.createRun();
//			// if the run can't be created or is less than 30 points
//			if (meld == null || !MeldChecker.check30(meld)) {
//				
//				// the run is too small
//				if (meld != null) {
//					this.getHand().addAll(meld);
//					meld.clear();
//				}
//				
//				// try create a set
//				meld = this.createSet();
//				
//				// if the set is not null and point are more than thirty
//				if (meld != null && MeldChecker.check30(meld)) {
//
//					Table.addMeld(meld); // plays set as first 30
//					this.setFirst30(true);
//					this.setHasPlayed(true);
//
//				} else {
//					if (meld != null) {
//						this.getHand().addAll(meld);
//						meld.clear();
//					}
//					// Default draw from stock
//					this.addTile(Table.getTile());
//				}
//			} else {
//				Table.addMeld(meld); // plays run as first 30
//				this.setFirst30(true);
//				this.setHasPlayed(true);
//			}
//		}
//
//	}
	
	
}

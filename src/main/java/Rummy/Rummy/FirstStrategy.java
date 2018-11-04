package Rummy.Rummy;

import java.util.ArrayList;

public class FirstStrategy extends Player implements Strategy {

	public FirstStrategy(String name) {
		super(name);
	}

	public ArrayList<ArrayList<Tile>> playTurn() {
		return null;
	}

	public void playTurn(ArrayList<ArrayList<Tile>> tableMelds) { // don't want to return anything, can just interact
																	// with table in the function
		this.setHasPlayed(false);
		if (this.playedFirst30) { // First 30 already played
			ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
			ArrayList<Tile> meld = this.createRun();
			if (meld == null) {
				meld = this.createSet();
			}
			while (meld != null) {
				temp.add(meld); // add in the meld
				meld = null;
				meld = this.createRun(); // create a new one
				if (meld == null) {
					meld = this.createSet();
				}
			}
			
			Table.addMeldz(temp);

			

			if (this.getHand().isEmpty()) { // Win condition
				Table.getMelds().addAll(temp);
				this.setHasPlayed(true);
			}
		} else {
			ArrayList<Tile> meld = this.createRun();
			if (meld == null || !MeldChecker.check30(meld)) {
				if (meld != null) {
					this.getHand().addAll(meld);
					meld.clear();
				}
				meld = this.createSet();
				if (meld != null && MeldChecker.check30(meld)) {

					Table.addMeld(meld); // plays set as first 30
					this.setFirst30(true);
					this.setHasPlayed(true);

				} else {
					if (meld != null) {
						this.getHand().addAll(meld);
						meld.clear();
					}
					// Default draw from stock
					this.addTile(Table.getTile());
				}
			} else {
				Table.addMeld(meld); // plays run as first 30
				this.setFirst30(true);
				this.setHasPlayed(true);
			}
		}

	}
}

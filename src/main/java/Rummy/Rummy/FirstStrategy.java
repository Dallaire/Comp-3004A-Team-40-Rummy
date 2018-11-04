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
			// create a temporary array
			ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();

			// create a run
			ArrayList<Tile> meld = this.createRun(null);

			// if a run can't be created create set
			if (meld == null) {
				meld = this.createSet(null);
			}

			// A none null meld goes in here
			// Keep creating runs and sets as much as possible
			while (meld != null) {
				temp.add(meld); // add in the meld
				meld = null;
				meld = this.createRun(null); // create a new one
				if (meld == null) {
					meld = this.createSet(null);
				}
			}

			Table.addMeldz(temp);

			if (this.getHand().isEmpty()) { // Win condition
				Table.getMelds().addAll(temp);
				this.setHasPlayed(true);
			}

		} else {
			// create a run
			ArrayList<Tile> meld = this.createRun(null);
			// if the run can't be created or is less than 30 points
			if (meld == null || !MeldChecker.check30(meld)) {

				// the run is too small
				if (meld != null) {
					this.getHand().addAll(meld);
					meld.clear();
				}

				// try create a set
				meld = this.createSet(null);

				// if the set is not null and point are more than thirty
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

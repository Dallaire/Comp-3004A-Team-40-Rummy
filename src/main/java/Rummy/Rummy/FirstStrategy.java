package Rummy.Rummy;

import java.util.ArrayList;

public class FirstStrategy extends Player implements Strategy {

	public FirstStrategy(String name, boolean isLocal) {
		super(name, isLocal);
	}

	public ArrayList<ArrayList<Tile>> playTurn() { // don't want to return anything, can just interact
		
		// create as many melds as possible
		ArrayList<ArrayList<Tile>> temp = createMelds();
		
		// Draw from Tile if no melds could be created
		if (temp == null) {
			this.addTile(Table.getTile());
			return temp;
		}
				
		
		// Check how many points we have
		int points = 0;
		for (ArrayList<Tile> tiles: temp) {
			points += MeldChecker.countPoints(tiles);
		}
		
		System.out.println(this.getName() + " You have " + points +  " points");		
		
		this.setHasPlayed(false);
		if (this.playedFirst30) { // First 30 already played
			// create a temporary array
			return temp;

		} else {


			// if the run can't be created or is less than 30 points
			if (points < 30) {

				// return cards to the players hand
				this.addMelds(temp);
				this.addTile(Table.getTile());
				return null;
				
			// the melds are enough and played
			} else {
				this.setFirst30(true);
				this.setHasPlayed(true);
				return temp; // plays run as first 30
			}
		}
	}

}

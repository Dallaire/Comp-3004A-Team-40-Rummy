package Rummy.Rummy;

import java.util.ArrayList;

/**
 * Interface Strategy
 * Contains implementations of player actions common to all players
 * Abstract methods playturn() is implemented differently for each ai or player
 * 
 *   player - instance of the player
 *   table - the table object 
 *   meld - ?*/
public interface Strategy {
	
	/***/
	public ArrayList<Tile> playTurn();
	


	
}


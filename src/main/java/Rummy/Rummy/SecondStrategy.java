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
		
		if (playedFirst30) {
			if (tableData.getFirstMeld()) {
				
			}
			else {
				// Default draw from stock
					this.addTile(Table.getTile());
			}
		}
		else {
		// Default draw from stock
			this.addTile(Table.getTile());
			
		// TODO  Override the playTurn method
		}
	}
}

package Rummy.Rummy;

import java.util.ArrayList;

public class SecondStrategy extends Player implements Strategy{
	
	//Invoke super class constructor
	public SecondStrategy(String name) {
		super(name);
		
	}
	
	@Override
	public ArrayList<Tile> playTurn() {
		
		// Default draw from stock
		this.addTile(Table.getTile());
		return null;
		// TODO  Override the playTurn method
		
	}
}

package Rummy.Rummy;

import java.util.ArrayList;
import java.util.HashMap;

public class FourthStrategy extends Player implements Strategy{
	
	private ArrayList<ArrayList<Tile>> others = new ArrayList<ArrayList<Tile>>();
	private ArrayList<ArrayList<Tile>> onTable = new ArrayList<ArrayList<Tile>>();
	
	private HashMap<Tile,Integer> tileMap = new HashMap<Tile,Integer>();
	
	public FourthStrategy(String aName, boolean isLocal) {
		super(aName, isLocal);
		// TODO Auto-generated constructor stub
	}
	
	public void compute() {
		
		getPlayersCards();
		
		Tile tile;
		
		for (Color color : Color.values()) {
			for (int i =1; i < 14; i++) {
				tile = new Tile(color, i);
				
				// check if the tile is in one of the other players hands
				for (ArrayList<Tile> melds: others) {
					for (Tile t: melds) {
						if(t.equals(tile)) {
							//tileMap.containsKey(key)
						}
					}
				}
				
				// check if the tile is on the table
				for (ArrayList<Tile> melds: onTable) {
					for (Tile t: melds) {
						if(t.equals(tile)) {
							
						}
					}
				}
			// end for loop	
			}
		// end for loop
		}
		
	}
	
	/**
	 * Get the cards that the other players have, including your own
	 * and also get all the melds that are currently on the table*/
	private void getPlayersCards() {
		
		// Cycle through thte players and add their cards to the list
		Player temp;
		for (int i = 0; i < Table.getNumPlayers()-1; i++) {
			temp = Table.getPlayer(i);
			if (temp.equals(this)) {
				continue;
			}
			
			// Add the other players cards to the ArrayList for further analysis
			others.add(temp.getHand());
		}
		
		// get what is on the table
		onTable = tableData.getMelds();
	}
	
	

}

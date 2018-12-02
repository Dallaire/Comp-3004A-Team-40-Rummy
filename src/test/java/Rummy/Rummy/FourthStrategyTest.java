package Rummy.Rummy;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;

public class FourthStrategyTest extends TestCase {
	
	//Initialize the table
	public void testFourth() {
		Table.initStrat4();
		FourthStrategy player = (FourthStrategy) Table.getPlayer(0);
		player.compute();
		player.setCompute();
	}
	
	/**
	 * Test the data structure which holds the number of occurrences of a tile
	 * This uses string representations as a key and an integer for a value*/
	public void testTileMap() {
		
		// instance variables
		HashMap<String,Integer> tileMap = new HashMap<String,Integer>();
		Tile tile;
		/**************************************************/
		
		for (Color color : Color.values()) {
			for (int i =1; i < 14; i++) {
				tile = new Tile(color, i);
				
					tileMap.put(tile.toString(), 0);
			// end for loop	
			}
		// end for loop
		}
		
		assertEquals(52, tileMap.size());
		System.out.println(tileMap);
	}
	
	
}

package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class FourthStrategy extends Player implements Strategy{
	
	// Instance variables
	private ArrayList<ArrayList<Tile>> others = new ArrayList<ArrayList<Tile>>();
	private ArrayList<ArrayList<Tile>> onTable = new ArrayList<ArrayList<Tile>>();
	// Set compute 
	Set<Integer> possibleSets = new TreeSet<Integer>(); 
	Set<Color> possibleRuns = new TreeSet<Color>();
	
	private HashMap<String,Integer> tileMap = new HashMap<String,Integer>();
	
	public FourthStrategy(String aName, boolean isLocal) {
		super(aName, isLocal);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Analyze the Tiles on the board and determine the number still out there*/
	public void compute() {
		
		dataInit();
		
		Tile tile;
		
		for (Color color : Color.values()) {
			for (int i =1; i < 14; i++) {
				tile = new Tile(color, i);

				// check if the tile is in one of the other players hands
				for (ArrayList<Tile> melds: others) {
					for (Tile t: melds) {
						if(t.equals(tile) && tileMap.containsKey(tile.toString())== false) {
							tileMap.put(tile.toString(), 0);
						} else if (t.equals(tile) && tileMap.containsKey(tile.toString())) {
							tileMap.put(tile.toString(), tileMap.get(t.toString())+ 1);
						}
					}
				}
				
				// check if the tile is on the table
				for (ArrayList<Tile> melds: onTable) {
					for (Tile t: melds) {
						if(tileMap.containsKey(t.toString())) {
							if(t.equals(tile) && tileMap.containsKey(tile.toString()) == false) {
								tileMap.put(tile.toString(), 0);
							} else if (t.equals(tile) && tileMap.containsKey(tile.toString())) {
								tileMap.put(tile.toString(), tileMap.get(t.toString())+ 1);
							}
						}
					}
				}
			// end for loop	
			}
		// end for loop
		}
		
		System.out.println(others.toString());
		System.out.println(onTable.toString());
		System.out.println(tileMap.toString());
		
		setCompute();
		runCompute();
		printMap();
		
		// Iterate through the tileMap and find Tiles that are possibly still in the stock
		
	}
	
	
	/**
	 * Get the cards that the other players have, including your own
	 * and also get all the melds that are currently on the table*/
	private void dataInit() {
		
		// Cycle through the players and add their cards to the list
		Player temp;
		for (int i = 0; i < Table.getNumPlayers(); i++) {
			temp = Table.getPlayer(i);
			if (temp.equals(this)) {
				continue;
			}
			
			// Add the other players cards to the ArrayList for further analysis
			others.add(temp.getHand());
		}
		
		// Populate the tile Data structure and initilize all values to 
		Tile tile;
		for (Color color : Color.values()) {
			for (int i =1; i < 14; i++) {
				tile = new Tile(color, i);
				
					tileMap.put(tile.toString(), 0);
			// end for loop	
			}
		// end for loop
		}
		
		// get what is on the table
		onTable = tableData.getMelds();
	}
	
	/**
	 * Find possible sets in the current hand*/
	public void setCompute() {
		
		System.out.println("\n************Computing Sets************");
		ArrayList<Tile> tempHand = new ArrayList<Tile>(hand);
		Collections.sort(tempHand, new valueComparator());
		System.out.println(tempHand.toString());
		Tile temp;
		for (int i = 0; i < tempHand.size(); i++) {
			temp = tempHand.remove(i);
			for (Tile t: hand) {
				if(temp.getValue() == t.getValue() && temp.getColor() != t.getColor()) {
					possibleSets.add(temp.getValue());
					tempHand.remove(t);
				}
			}
		}

		System.out.println(possibleSets.toString());
		
	}
	/**
	 * Find possible runs in the current hand*/
	public void runCompute() {
		System.out.println("\n************Computing Runs************");
		ArrayList<Tile> tempHand = new ArrayList<Tile>(hand);
		Collections.sort(tempHand, new valueComparator());
		System.out.println(tempHand.toString());
		Tile temp;
		for (int i = 0; i < tempHand.size(); i++) {
			temp = tempHand.remove(i);
			for (Tile t: hand) {
				if(temp.getColor() == t.getColor() && Math.abs(temp.getValue() - t.getValue())==1) {
					possibleRuns.add(temp.getColor());
					tempHand.remove(t);
				}
			}
		}

		System.out.println(possibleRuns.toString());
	}
	
	public void printMap() {
	    Iterator<Entry<String, Integer>> it = tileMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	        
//	        if(pair.getValue() == 0) {
//	        	
//	        }
	    }
	}
}

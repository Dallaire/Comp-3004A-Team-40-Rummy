package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
	private ArrayList<Tile> tiles;
	private Random rn = new Random();
	
	public Deck() {
		this.tiles = new ArrayList<Tile>();
		
		for (Color color : Color.values()) {
			for (int i =1; i < 14; i++) {
				tiles.add(new Tile(color, i));
				tiles.add(new Tile(color, i));
			}
		}
		this.Shuffle();
	}
	
	public Tile geTile(int i) {
		return tiles.remove(i);
	}
	/**
	 * Check if a specific tile is in the Deck
	 * for testing purposes atm*/
	public boolean contains(Tile tile) {
		// TODO Auto-generated method stub
		for(int i = 0; i<this.tiles.size(); i++) {
			System.out.println("Tile: " + tiles.get(i));
			if(this.tiles.get(i) == tile) {
				return true;
			}
		}
		return false;
	}
	
	public int getSize() {
		return tiles.size();
	}
	
	public void Shuffle() {
		Collections.shuffle(this.tiles);
	}
	


	 /** 
	  * Select a random tile from the Deck
	  * @return - Tile
	  */
	public Tile getRandomTile() {
		// TODO Auto-generated method stub
		
		return tiles.remove(rn.nextInt(14));
	}

	
	

}

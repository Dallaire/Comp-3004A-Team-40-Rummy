package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	ArrayList<Tile> tiles;
	
	public Deck() {
		this.tiles = new ArrayList<Tile>();
		
		for (Color color : Color.values()) {
			for (int i =1; i < 14; i++) {
				tiles.add(new Tile(color, i));
				tiles.add(new Tile(color, i));
			}
		}
	}
	
	public Tile geTile(int i) {
		return tiles.remove(i);
	}
	/**
	 * Check if a specific tile is in the Deck
	 * for testing purposes atm*/
	public Boolean contains(Tile tile) {
		// TODO Auto-generated method stub
		if(tiles.indexOf(tile)==-1) 
			return false;
		else
			return true;
	}
	public int getSize() {
		return tiles.size();
	}
	
	public void Shuffle() {
		Collections.shuffle(this.tiles);
	}
	
}

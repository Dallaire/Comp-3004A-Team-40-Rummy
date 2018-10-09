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
	
<<<<<<< HEAD
=======
	/**
	 * Select a specific tile from the Deck*/
	public Tile getTile(Tile tile) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return null;
		
	}
	/**
	 * Check if a specific tile is in the Deck
	 * for testing purposes atm*/
	public Boolean contains(Tile tile) {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 5375e486eba6afa082657ae342ec9cf788938a06
}

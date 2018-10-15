package Rummy.Rummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * The Table class contains all the data structures used to represent game elements
 * The class is responsible for passing data between 
 * @param ArrayList<Player> players = A list of players in the game
 * @param stock = The initial set of 104 tiles used at the start of the game 
 * @param meld = a single meld submitted by a player, which is refreshed after each turn
 * @param melds = a collection of melds submitted
 * @param firstMeld = boolean value of whether or not a valid 30 point melds is played to start the game*/
public class Table {
	
	private ArrayList<Player> players;
	private Deck stock;
	private ArrayList<ArrayList<Tile>> melds = new ArrayList<ArrayList<Tile>>(); //Refactored data structure -Jacob
	private boolean firstMeld = false;
	
	public Table() {
		Strategy stratPlayer = new PlayerStrategy();
		Player gamer = new Player("Player 1", stratPlayer);
		Strategy stratA1 = new FirstStrategy();
		Player ai1 = new Player("AI 1", stratA1);
		Strategy stratA2 = new SecondStrategy();
		Player ai2 = new Player("AI 2", stratA2);
		Strategy stratA3 = new ThirdStrategy();
		Player ai3 = new Player("AI 3", stratA3);
		
		players = new ArrayList<Player>();
		players.add(gamer);
		players.add(ai1);
		players.add(ai2);
		players.add(ai3);
		
		stock = new Deck();
		stock.Shuffle();
		
		
	}
	
	/**
	 * Integer Constructor for a Table to pass in the number of player that will be playing the game
	 * @param num_Players = number of players between 2 and 4 accepted*/
	public Table(int num_Players) {
//		for (int i = 0; i < num_Players; i++) {
//			Player gamer = new Player("Player " + i);
//			players.add(gamer);
//		}
			
	}
	/**
	 * Returns the number of players in the game
	 * @param player = ArrayList of players*/
	public int getNumPlayers() {
		return players.size();
	}
	/**
	 * Returns the number tiles left in the stock
	 * @param stock.getSize() =  the size of the stock on the table*/
	public int getNumTiles() {
		return stock.getSize();
	}
	
	/**
	 * Returns all the melds added to the table by the players
	 * @param melds =  The HashMap of Melds*/
	public int getNumMelds() {
		
		return melds.size();
	}
	
	/*
	 *  Gets a meld by its index
	 */
	public ArrayList<Tile> getMeld(int i){
		return melds.get(i);
	}
	
//	private void setMelds(Set<Set<Tile>> melds) {
//		this.melds = melds;
//	}
	
	/**
	 * @param meld the meld to set
	 * TODO: Maybe some error checking;
	 */
	public void addMeld(ArrayList<Tile> meld) {
		this.melds.add(meld);					// Adding a new meld refactored - Jacob
	}

	/**
	 * Method to get a specific tile
	 * @param c = colour of the Tile
	 * @param v = the value of the Tile*/
	public Tile getTile() {
		//TODO prompt user to select a color and value
		Tile tile = selectTile();
		return stock.getTile(tile);
	}
	
	public void displayStock() {
		System.out.println(stock.toString());
	}
	
	public Tile selectTile() {
		String[] inputArray;
		System.out.print("Please select a tile color followed by a value(separator = ,): \n");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		inputArray = input.split(",");
		
		Color color = colorSelector(inputArray[0]);
		int value = Integer.parseInt(inputArray[1]);
		
		Tile selected = new Tile(color, value);
		System.out.println("You selected " + selected.toString());
		
		scanner.close();
		
		return selected;
		
	}
	
	/**
	 * Check if the stock contains the specified tile
	 * For testing purposes*/
	public boolean stockContains(Tile tile) {
		// TODO Auto-generated method stub
		
		// return stock.contains(tile);
		return false;
	}
	/**
	 * Color selector: Given a string it will return a variable of Type Color
	 * @param c = the String value of the color desired
	 * @return Object of type Color or null if input is invalid
	 * */
	private Color colorSelector(String c) {
		String color =  c.toUpperCase();
		switch(color) {
		case "R":
			return Color.R;
		case "B":
			return Color.B;
		case "G":
			return Color.G;
		case "O":
			return Color.O;		
		default:
			return null;
		}
		
	}
	
	/**
	 * Check if the meld has been played
	 * Needs refactoring into player to see if initial 30 is played
	public boolean checkFirst() {
		return this.firstMeld;
	}
	*/
	/**
	 * @param firstMeld the firstMeld to set
	 
	public void setFirstMeld(boolean firstMeld) {
		this.firstMeld = firstMeld;
	}
	*/
}

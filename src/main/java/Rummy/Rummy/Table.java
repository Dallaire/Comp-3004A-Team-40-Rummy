package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Scanner;

import org.xml.sax.ext.Attributes2;


/**
 * The Table class contains all the data structures used to represent game elements
 * The class is responsible for passing data between 
 * @param ArrayList<Player> players = A list of players in the game
 * @param stock = The initial set of 104 tiles used at the start of the game 
 * @param meld = a single meld submitted by a player, which is refreshed after each turn - Removed -Jacob
 * @param melds = a collection of melds submitted
 * @param firstMeld = boolean value of whether or not a valid 30 point melds is played to start the game*/
public class Table {
	
	private ArrayList<Player> players;
	private Deck stock;

	private ArrayList<Tile> meld;
	private ArrayList<ArrayList<Tile>> melds;
	private boolean firstMeld = false;

	
	public Table() {
		
				
		loadPlayers();
		loadDeck();
		
		
		
	}
	/**
	 * loads the players*/
	public void loadPlayers() {
		Strategy stratA1;
		Player ai1 = new Player("AI 1");
		stratA1 = new FirstStrategy(ai1, this);
		ai1.setStrategy(stratA1);
		Strategy stratA2;
		Player ai2 = new Player("AI 2");
		stratA2 = new SecondStrategy(ai2, this);
		ai2.setStrategy(stratA2);
		Strategy stratA3;
		Player ai3 = new Player("AI 3");
		stratA3 = new ThirdStrategy(ai3, this);
		ai1.setStrategy(stratA3);
		
		players = new ArrayList<Player>();
		players.add(ai1);
		players.add(ai2);
		players.add(ai3);

	}
	/**
	 * loads the deck*/
	public void loadDeck() {
		stock = new Deck();
		stock.Shuffle();
		shareCards();
		melds = new ArrayList<ArrayList<Tile>>();
	}
	/**
	 * distributes cards amongst players*/
	public void shareCards() {
		for(int i=0;i<players.size();i++) {
			for(int j=0;j<14;j++) {
				players.get(i).addTile(getTile());
			}
		}
	}

	public Player getPlayer(int i) {
		return players.get(i);
		
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
		//Tile tile = selectTile();
		return stock.geTile(stock.getSize()-1);
	}
	
	public void displayStock() {
		System.out.println(stock.toString());
	}
	
//	public Tile selectTile() {
//		String[] inputArray;
//		System.out.print("Please select a tile color followed by a value(separator = ,): \n");
//		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();
//		inputArray = input.split(",");
//		
//		Color color = colorSelector(inputArray[0]);
//		int value = Integer.parseInt(inputArray[1]);
//		
//		Tile selected = new Tile(color, value);
//		System.out.println("You selected " + selected.toString());
//		
//		scanner.close();
//		
//		return selected;
//		
//	}
	
	/**
	 * Check if the stock contains the specified tile
	 * For testing purposes*/
	public boolean stockContains(Tile tile) {
		// TODO Auto-generated method stub
		
		return stock.contains(tile);
		//return false;
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

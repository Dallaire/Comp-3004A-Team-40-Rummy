package Rummy.Rummy;

import java.util.ArrayList;


/**
 * The Table class contains all the data structures used to represent game elements
 * The class is responsible for passing data between 
 * players - A list of players in the game
 * stock - The initial set of 104 tiles used at the start of the game 
 * meld - a single meld submitted by a player, which is refreshed after each turn - Removed -Jacob
 * melds - a collection of melds submitted
 * firstMeld - boolean value of whether or not a valid 30 point melds is played to start the game
 * players - An ArrayList of players in on the table
 * */
public class Table {
	
	private ArrayList<Player> players;
	private Deck stock;

	private ArrayList<Tile> meld;
	private ArrayList<ArrayList<Tile>> melds;
	private boolean firstMeld = false;

	/**
	 * Table constructor
	 * Initialise all table variables*/
	public Table() {
		
		loadPlayers();
		loadDeck();
		
	}
	
	/**
	 * Hard coded instantiation of players to populate the list of players*/
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
	
	/**
	 * Get a a player from the player collection
	 * @param {Integer} i - the index of the player 
	 * @return {Object} Player from index i*/
	public Player getPlayer(int i) {
		return players.get(i);
		
	}
	/**
	 * Returns the number of players in the game
	 * player - ArrayList of players
	 * @return Integer representation of the number of the */
	public int getNumPlayers() {
		return players.size();
	}
	/**
	 * Returns the number tiles left in the stock
	 * stock.getSize() -  the size of the stock on the table
	 * @return Integer representing the number of tiles in the stock*/
	public int getNumTiles() {
		return stock.getSize();
	}
	
	/**
	 * Returns all the melds added to the table by the players
	 * melds -  The HashMap of Melds
	 * @return Integer value of size of melds datastructure*/
	public int getNumMelds() {
		
		return melds.size();
	}
	
	/**
	 *  Gets a meld by its index
	 *  @param i - index of tile
	 */
	public ArrayList<Tile> getMeld(int i){
		return melds.get(i);
	}
	
//	private void setMelds(Set<Set<Tile>> melds) {
//		this.melds = melds;
//	}
	
	/**
	 * @param meld - the meld to set
	 * TODO: Maybe some error checking;
	 */
	public void addMeld(ArrayList<Tile> meld) {

		this.melds.add(meld);					// Adding a new meld refactored - Jacob
	}

	/**
	 * Method to get a random tile
	 * @param stock - a collection of Tiles
	 * */
	public Tile getTile() {
		//TODO prompt user to select a color and value
		//Tile tile = selectTile();
		return stock.geTile(stock.getSize()-1);
	}
	
	public void displayStock() {
		System.out.println(stock.toString());
	}
	
	/**
	 * Check if the stock contains the specified tile
	 * For testing purposes*/
	public boolean stockContains(Tile tile) {
		// TODO Auto-generated method stub
		
		return stock.contains(tile);
		//return false;
	}
	/**
	 * Colour selector: Given a string it will return a variable of Type Color
	 * @param c - the String value of the colour desired
	 * @return Object of type Colour or null if input is invalid
	 * */
	@SuppressWarnings("unused")
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
	
}

package Rummy.Rummy;

import java.util.ArrayList;


/**
 * The Table class contains all the data structures used to represent game elements
 * The class is responsible for passing data between 
 * @players {Object} - A list of players in the game
 * @stock - The initial set of 104 tiles used at the start of the game 
 * @meld - a single meld submitted by a player, which is refreshed after each turn - Removed -Jacob
 * @melds - a collection of melds submitted
 * @firstMeld - boolean value of whether or not a valid 30 point melds is played to start the game
 * @players - An ArrayList of players in on the table
 * */
public final class Table {
	
	static private ArrayList<Player> players;
	static private Deck stock;

	//private ArrayList<Tile> meld;
	static private ArrayList<ArrayList<Tile>> melds;
	static private boolean firstMeld = false;
	static private boolean threeLess = false;
	
	static private int whosTurn = 0;

	/**
	 * Table constructor
	 * Initialize all table variables*/
	private Table() {
		
//		loadPlayers();
//		loadDeck();
		
	}

	/**
	 * Print initial tiles for each player*/
	static public void init() {
		loadPlayers();
		loadDeck();
		for (Player x: players) {
			x.printTiles();
		}
	}
	
	/**
	 * Hard coded instantiation of players to populate the list of players
	 * @FirstStrategy - Plays 30 points as soon as it can
	 * @SecondStrategy - 
	 * @ThirdStrategy - */
	static public void loadPlayers() {
		
		PlayerStrategy p1 = new PlayerStrategy("dude");
		FirstStrategy ai1 = new FirstStrategy("AI 1");
		SecondStrategy ai2 = new SecondStrategy("AI 2");	
		ThirdStrategy ai3 = new ThirdStrategy("AI 3");

		players = new ArrayList<Player>();
		players.add(p1);
		players.add(ai1);
		players.add(ai2);
		players.add(ai3);
		

	}
	/**
	 * loads the deck*/
	static public void loadDeck() {
		setStock(new Deck());
		shareCards();
		melds = new ArrayList<ArrayList<Tile>>();
	}
	/**
	 * distributes cards amongst players*/
	static public void shareCards() {
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
	static public Player getPlayer(int i) {
		return players.get(i);
		
	}
	/**
	 * Returns the number of players in the game
	 * player - ArrayList of players
	 * @return Integer representation of the number of the */
	static public int getNumPlayers() {
		return players.size();
	}
	/**
	 * Returns the number tiles left in the stock
	 * stock.getSize() -  the size of the stock on the table
	 * @return Integer representing the number of tiles in the stock*/
	static public int getNumTiles() {
		return getStock().getSize();
	}
	
	/**
	 * Returns all the melds added to the table by the players
	 * melds -  The HashMap of Melds
	 * @return Integer value of size of melds datastructure*/
	static public int getNumMelds() {
		
		return melds.size();
	}
	
	/**
	 *  Gets a meld by its index
	 *  @i - index of tile
	 */
	static public ArrayList<Tile> getMeld(int i){
		return melds.get(i);
	}
	
//	private void setMelds(Set<Set<Tile>> melds) {
//		this.melds = melds;
//	}
	
	/**
	 * @meld - the meld to set
	 * 
	 */
	static public void addMeld(ArrayList<Tile> meld) {

		melds.add(meld);					// Adding a new meld refactored - Jacob
	}

	/**
	 * Method to get a random tile
	 * @stock - a collection of Tiles
	 * */
	static public Tile getTile() {

		return getStock().geTile(getStock().getSize()-1);
	}
	
	static public void displayStock() {
		System.out.println(getStock().toString());
	}
	
	/**
	 * Check if the stock contains the specified tile
	 * For testing purposes*/
	static public boolean stockContains(Tile tile) {
		// TODO Auto-generated method stub
		
		return getStock().contains(tile);
		//return false;
	}
	/**
	 * Colour selector: Given a string it will return a variable of Type Color
	 * @param c - the String value of the colour desired
	 * @return Object of type Colour or null if input is invalid
	 * */
	@SuppressWarnings("unused")
	static private Color colorSelector(String c) {
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
	 * Circular array cycling between 0 and 3
	 * This method increments the index to the next player
	 * */
	static public void nextMove() {
		// TODO Auto-generated method stub
		whosTurn++;
		whosTurn%=4;
		
	}
	
	/**
	 * Returns the index of the next player to play
	 * */
	static public int whosMove() {
		System.out.println(getPlayer(whosTurn).getName() + " " + getPlayer(whosTurn).getClass().getSimpleName());
		return whosTurn;
		
	}
	
	/**
	 * Initiate the next players move
	 * @update() - updates players with current state of the table*/
	static public void playNext() {
		players.get(whosMove()).printTiles();
		
		if(players.get(whosMove()) instanceof PlayerStrategy) {
			melds.add(((PlayerStrategy) players.get(whosMove())).playTurn());
			
		} else {
			melds.add(((FirstStrategy) players.get(whosMove())).playTurn());
			
		}
		players.get(whosMove()).printTiles();
		nextMove();
		update();
	}
	
	static public ArrayList<ArrayList<Tile>> getMelds() {
		return melds;
	}
 
	/**
	 * Check if the first 30 point meld has been played
	 * @return boolean - true if the first meld has been played*/
	static public boolean getFirst() {
		
		return firstMeld;
	}
	
	/**
	 * Check if any player has 3 less cards than Strategy3
	 * @return boolean - true if there is a player who has 3 less than Strategy3*/
	static public boolean getThreeLess() {
		
		return threeLess;
	}
	
	/**
	 * Update all subscribers on the state of the game
	 * */
	static public void update() {
		
		JRON data = new JRON(getMelds(), getFirst(), getThreeLess(),getStock());
	       for (Player x:players) 
	        { 
	            x.update(data);
	        } 
		
	}

	/**
	 * @return the stock
	 */
	public static Deck getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public static void setStock(Deck stock) {
		Table.stock = stock;
	}
}

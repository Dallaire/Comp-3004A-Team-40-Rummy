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
public class Table {
	
	private ArrayList<Player> players;
	private Deck stock;

	private ArrayList<Tile> meld;
	private ArrayList<ArrayList<Tile>> melds;
	private boolean firstMeld = false;
	private boolean threeLess = false;
	
	private int whosTurn = 0;

	/**
	 * Table constructor
	 * Initialize all table variables*/
	public Table() {
		
		loadPlayers();
		loadDeck();
		
	}

	/**
	 * Print initial tiles for each player*/
	public void init() {
		for (Player x: players) {
			x.printTiles();
		}
	}
	
	/**
	 * Hard coded instantiation of players to populate the list of players
	 * @FirstStrategy - Plays 30 points as soon as it can
	 * @SecondStrategy - 
	 * @ThirdStrategy - */
	public void loadPlayers() {
		
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
	 *  @i - index of tile
	 */
	public ArrayList<Tile> getMeld(int i){
		return melds.get(i);
	}
	
//	private void setMelds(Set<Set<Tile>> melds) {
//		this.melds = melds;
//	}
	
	/**
	 * @meld - the meld to set
	 * 
	 */
	public void addMeld(ArrayList<Tile> meld) {

		this.melds.add(meld);					// Adding a new meld refactored - Jacob
	}

	/**
	 * Method to get a random tile
	 * @stock - a collection of Tiles
	 * */
	public Tile getTile() {

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

	/**
	 * Circular array cycling between 0 and 3
	 * This method increments the index to the next player
	 * */
	public void nextMove() {
		// TODO Auto-generated method stub
		this.whosTurn++;
		this.whosTurn%=4;
		
	}
	
	/**
	 * Returns the index of the next player to play
	 * */
	public int whosMove() {
		return this.whosTurn;
		
	}
	
	/**
	 * Initiate the next players move
	 * @update() - updates players with current state of the table*/
	public void playNext() {
		players.get(whosMove()).printTiles();
		
		if(players.get(whosMove()) instanceof PlayerStrategy) {
			((PlayerStrategy) players.get(whosMove())).playTurn();
		}
		
		nextMove();
		update();
	}
	
	public ArrayList<ArrayList<Tile>> getMelds() {
		return this.melds;
	}
 
	/**
	 * Check if the first 30 point meld has been played
	 * @return boolean - true if the first meld has been played*/
	public boolean getFirst() {
		
		return this.firstMeld;
	}
	
	/**
	 * Check if any player has 3 less cards than Strategy3
	 * @return boolean - true if there is a player who has 3 less than Strategy3*/
	public boolean getThreeLess() {
		
		return this.threeLess;
	}
	
	/**
	 * Update all subscribers on the state of the game
	 * */
	public void update() {
		
		JRON data = new JRON(this.getMelds(), this.getFirst(), this.getThreeLess());
	       for (Player x:players) 
	        { 
	            x.update(data);
	        } 
		
	}
}

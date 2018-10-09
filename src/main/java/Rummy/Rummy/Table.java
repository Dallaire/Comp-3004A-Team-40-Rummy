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
<<<<<<< HEAD
	private Set<Tile> meld;
	private Set<Set<Tile>> melds;

=======
	private HashMap<Integer,Tile> meld;
	private HashMap<Integer,HashMap<Integer,Tile>> melds;
	private boolean firstMeld = false;
>>>>>>> 5375e486eba6afa082657ae342ec9cf788938a06
	
	public Table() {
		Strategy stratPlayer = new FirstStrategy();
		
		players.add(ai2);
		players.add(ai3);

		stock=new Deck();
		
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
		
		melds = new HashMap<Integer,HashMap<Integer,Tile>>();
		
	}
<<<<<<< HEAD
	//public Table(int num_Players) {
=======
	
	/**
	 * Integer Constructor for a Table to pass in the number of player that will be playing the game
	 * @param num_Players = number of players between 2 and 4 accepted*/
	public Table(int num_Players) {
>>>>>>> 5375e486eba6afa082657ae342ec9cf788938a06
//		for (int i = 0; i < num_Players; i++) {
//			Player gamer = new Player("Player " + i);
//			players.add(gamer);
//		}
			
	//}
	public void shareCards() {
		for(int i=0;i<players.size();i++) {
			for(int j=0;j<14;j++) {
				players.get(i).addTile(getTile());
			}
		}
	}
	public Tile getTile() {
		return deck.draw();
	}
	public Player getPlayer(int i) {
		return players.get(i);
	}
<<<<<<< HEAD
=======
	/**
	 * Returns the number of players in the game
	 * @param player = ArrayList of players*/
>>>>>>> 5375e486eba6afa082657ae342ec9cf788938a06
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
	
//	private void setMelds(Set<Set<Tile>> melds) {
//		this.melds = melds;
//	}
	
	/**
	 * @param meld the meld to set
	 * TODO: Maybe some error checking;
	 */
	public void addMeld(HashMap<Integer,Tile> meld) {
		this.meld = meld;
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
	 * Check if the meld has been played*/
	public boolean checkFirst() {
		return this.firstMeld;
	}
	/**
	 * @param firstMeld the firstMeld to set
	 */
	public void setFirstMeld(boolean firstMeld) {
		this.firstMeld = firstMeld;
	}
	
}

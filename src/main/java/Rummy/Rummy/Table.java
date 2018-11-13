package Rummy.Rummy;

import java.util.ArrayList;
import java.net.*;
import java.io.*;


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
	
	//Table variables
	static private ArrayList<Player> players;
	static private Deck stock;
	static private ArrayList<ArrayList<Tile>> melds = new ArrayList<ArrayList<Tile>>();
	static private boolean firstMeld = false;
	static private boolean threeLess = false;
	static private JRON jron = new JRON(null, false, false);
	static private boolean winner = false;
	static private int whosTurn = 0;
	static private int numMeldsLastPlayed = 0;

	/**
	 *Start the came with Random Cards*/
	static public void init() {
		loadPlayers();
		loadDeck();
		shareCards();
		for (Player x: players) {
			x.printTiles();
		}
	}
	
	/**
	 * Start the Game and let the user pass
	 * @param f - The name of the input file*/
	static public void initPass(String f) {
		loadPlayers();
		loadDeck();
		shareCards();
		for (Player x: players) {
			x.printTiles();
		}
		
		((PlayerStrategy) players.get(0)).setMode("file");
		((PlayerStrategy) players.get(0)).setFile(f);
		
	}
	
	/**
	 * Init for requirement number 8 on the grid
	 * a - The player can play a single run
	 * b - The player can play a single set
	 * c - The player can play multiple runs
	 * d - The player can play multiple sets
	 * e - The player can play a run and a set
	 * @param f - The name of the input file*/
	static public void init8(String f) {
		//players.clear();	
		loadPlayers();
		loadDeck();
		
		int i = 11;
		for (Player x: players) {
			x.addTile(new Tile(Color.R, i));
			x.addTile(new Tile(Color.B, i));
			x.addTile(new Tile(Color.O, i));
			x.addTile(new Tile(Color.G, i));
			x.addTile(new Tile(Color.R, i-1));
			x.addTile(new Tile(Color.B, i-1));
			x.addTile(new Tile(Color.O, i-1));
			x.addTile(new Tile(Color.G, i-1));
			x.addTile(new Tile(Color.R, i-2));
			x.addTile(new Tile(Color.B, i-2));
			x.addTile(new Tile(Color.O, i-2));
			x.addTile(new Tile(Color.G, i-2));
			x.printTiles();
			i--;
		}
		
		((PlayerStrategy) players.get(0)).setMode("file");
		((PlayerStrategy) players.get(0)).setFile(f);
	}
	
	/**
	 * Init for requirement number 4 on the grid
	 * @param f - The name of the input file
	 * */
	static public void init4a(String f) {
		//players.clear();	
		loadPlayers();
		loadDeck();
		
		int i = 6;
		for (Player x: players) {
			x.addTile(new Tile(Color.R, i));
			x.addTile(new Tile(Color.B, i));
			x.addTile(new Tile(Color.O, i));
			x.addTile(new Tile(Color.G, i));
			x.addTile(new Tile(Color.R, i-1));
			x.addTile(new Tile(Color.B, i-1));
			x.addTile(new Tile(Color.O, i-1));
			x.addTile(new Tile(Color.G, i-1));
			x.addTile(new Tile(Color.R, i-2));
			x.addTile(new Tile(Color.B, i-2));
			x.addTile(new Tile(Color.O, i-2));
			x.addTile(new Tile(Color.G, i-2));
			x.printTiles();
			i--;
		}
		
		((PlayerStrategy) players.get(0)).setMode("file");
		((PlayerStrategy) players.get(0)).setFile(f);
	}
	
	/**
	 * Init for requirement number 4 on the grid
	 * @param f - The name of the input file
	 * */
	static public void init4b(String f) {
		//players.clear();	
		loadPlayers();
		loadDeck();
		
		int i = 3;
		for (Player x: players) {
			x.addTile(new Tile(Color.R, i));
			x.addTile(new Tile(Color.B, i));
			x.addTile(new Tile(Color.O, i));
			x.addTile(new Tile(Color.G, i));
			x.addTile(new Tile(Color.R, i-1));
			x.addTile(new Tile(Color.B, i-1));
			x.addTile(new Tile(Color.O, i-1));
			x.addTile(new Tile(Color.G, i-1));
			x.addTile(new Tile(Color.R, i-2));
			x.addTile(new Tile(Color.B, i-2));
			x.addTile(new Tile(Color.O, i-2));
			x.addTile(new Tile(Color.G, i-2));
			x.printTiles();
			i++;
		}
		
		((PlayerStrategy) players.get(0)).setMode("file");
		((PlayerStrategy) players.get(0)).setFile(f);
	}
	
	
	
	/**
	 * Hard coded instantiation of players to populate the list of players
	 * @FirstStrategy - Plays 30 points as soon as it can
	 * @SecondStrategy - 
	 * @ThirdStrategy - */
	static public void loadPlayers() {
		
		PlayerStrategy p1 = new PlayerStrategy("Human");
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
	static public void remove(int meld) {
		melds.remove(meld);
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
		return stock.getSize();
	}
	
	/**
	 * Returns all the melds added to the table by the players
	 * @melds -  The ArraList of Melds
	 * @return Integer value of size of melds data structure*/
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
	
	//allow control of parameter
	static public void setFirst30(Boolean value) {
		firstMeld = value;
	}
	
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
	 * @whosMove is a circular array which increase every time this method is called
	 * cycling through the players in @players
	 * @update() - updates players with current state of the table*/
	@SuppressWarnings("unused")
	static public void playNext() {
		
		Player player = players.get(whosMove());
		player.printTiles();
		ArrayList<ArrayList<Tile>> meldz = new ArrayList<ArrayList<Tile>>();
		String meldsToString;
		// Each player is cast to their proper class to invoke the playTurn() method
		// if the meld is null it means the player chose to pick from the stock
		// A non-null meld is a valid move placed on the Table
		if(player instanceof PlayerStrategy) {

			meldz = ((PlayerStrategy) player).playTurn();
			meldsToString = meldz.toString();
			meldsToString = "{ " +  meldsToString.substring(1, meldsToString.length()) + " }";
			if (meldz == null) {
				System.out.println("Table: " + player.getClass().getSimpleName() + " " +  player.getName() + " drew from stock");
				numMeldsLastPlayed = 0;
			}
			else if (meldz.size() > 0){
				System.out.println("Table: " + player.getClass().getSimpleName() + " " +  player.getName()+ " played meld(s): " + meldzToString(meldz));
				if (!getFirst()) {
					setFirst30(true);
				}
				addMeldz(meldz);
				numMeldsLastPlayed = meldz.size();
			} else {
				System.out.println("Table: The Player passed");
			}	
			
		} else if (player instanceof FirstStrategy){
			((FirstStrategy) player).playTurn();
			//meldsToString = meldz.toString();
			//meldsToString = "{ " +  meldsToString.substring(1, meldsToString.length()) + " }";
			if (!player.getHasPlayed()) {

				System.out.println(player.getClass().getSimpleName() + " " +  player.getName() +" drew from stock");
				numMeldsLastPlayed = 0;
			}
			else {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName()+ " played a meld: ");
				//addMeldz(meldz);
				if (!getFirst()) {
					setFirst30(true);
				}
				numMeldsLastPlayed = meldz.size();
			}
		} else if (player instanceof SecondStrategy){
			meldz = ((SecondStrategy) player).playTurn2();
			if (meldz == null) {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName() +" drew from stock");
				numMeldsLastPlayed = 0;
			}
			else {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName()+ " played meld(s)" + meldzToString(meldz));
				addMeldz(meldz);
				if (!getFirst()) {
					setFirst30(true);
				}
				numMeldsLastPlayed = meldz.size();
			}
		}
		else if (player instanceof ThirdStrategy){
			meldz = ((ThirdStrategy) player).playTurn2();
			if (meldz == null) {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName() +" drew from stock");
				numMeldsLastPlayed = 0;
			}
			else {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName()+ " played a meld");
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName()+ " played meld(s)" + meldzToString(meldz));
				addMeldz(meldz);
				if (!getFirst()) {
					setFirst30(true);
				}
				numMeldsLastPlayed = meldz.size();
			}
		}
		
		
		player.printTiles();
		//test to see if player has won after playing their hand.
		//if they have break out of the game
		if(player.winner()) {
			System.out.println(player.getName() + " has won the game!");
			setWinner(true);
		}
		
		printMelds();
		nextMove();
		update();
	}
	
	static public void addMeldz (ArrayList<ArrayList<Tile>> meldz) {
		
		for (ArrayList<Tile> x: meldz) {
			Table.addMeld(x);
		}
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
	 * Update all subscribers of the state of the game
	 * Updates
	 * */
	static public void update() {
		
		// update the jron data
		jron.setFirstMeld(getFirst());
		jron.setMelds(getMelds());
		
	       for (Player x:players) 
	        { 
	    	   	// update threeLess for the ThirdStrategy
	            if(players.get(3).getHand().size() - x.getHand().size() == 3)
	            {
	            	if(x.getHand().size() == 0)
	            			setWinner(true);
	            	threeLess = true;
	            	jron.setThreeLess(threeLess);
	            }
	            x.update(jron);
	        } 
		
	}
	static public void setWinner(boolean win) {
		winner = win;
	}
	static public boolean getWinner() {
		return winner;
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
	
	/**
	 * Print all the melds on the Table
	 * @return void*/
	public static void printMelds() {
		String str = "";
		int i = 0;
		
		for (ArrayList<Tile> m: melds){
			if (melds.size() - numMeldsLastPlayed <= i ) {
				str += m.toString().replace("[", "*{").replaceAll("]", "} ");;
			} else {
				str += m.toString().replace("[", "{").replaceAll("]", "} ");;
			}
			
			i++;
		}
		
		System.out.println("------------------------------------" );
		System.out.println("The melds on the Table are:" );
		System.out.println("{ " + str + "}");
		System.out.println("------------------------------------\n\n" );
	}
	
	/**
	 * String format the melds to comfort to Requirement 7
	 * @return String formated variable*/
	public static String meldzToString(ArrayList<ArrayList<Tile>> meldz) {
		String str = "";

		for (ArrayList<Tile> m: meldz){

				str += m.toString().replace("[", "{").replaceAll("]", "} ");;

		}
		
		return "{ " + str + " }";
	}
	
	 public static void connectSocket() throws IOException {

	        int portNumber = 4444;
	        
	        try ( 
	        	//server side of a client/server socket connection
	            ServerSocket serverSocket = new ServerSocket(portNumber);
	        		
	        	//The accept method waits until a client starts up and 
	        	//requests a connection on the host and port of this server.
	            Socket clientSocket = serverSocket.accept();
	            PrintWriter out =
	                new PrintWriter(clientSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(clientSocket.getInputStream()));
	        ) {
	         
	            String inputLine, outputLine;
	             
	            // Initiate conversation with client
	            RummyProtocol kkp = new RummyProtocol();
	            outputLine = kkp.processInput(null);
	            out.println(outputLine);
	            System.out.println(outputLine);
	 
	            while ((inputLine = in.readLine()) != null) {
	                outputLine = kkp.processInput(inputLine);
	                out.println(outputLine);
	                if (outputLine.equals("Bye."))
	                    break;
	            }
	        } catch (IOException e) {
	            System.out.println("Exception caught when trying to listen on port "
	                + portNumber + " or listening for a connection");
	            System.out.println(e.getMessage());
	        }
	    }
	 
	 public void closeSocket() {
		 try {
			ServerSocket serverSocket = new ServerSocket(4444);
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	 }
	 
	
}

package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.net.*;
import java.io.*;


/**
 * The Table class contains all the data structures used to represent game elements
 * The class is responsible for passing data between the players
 * @players {Object} - A list of players in the game
 * @stock - The initial set of 104 tiles used at the start of the game 
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
	static private JRON jron = new JRON(null, false, false, null);
	static private boolean winner = false;
	static private int whosTurn = 0;
	static private int numMeldsLastPlayed = 0;
	static private Random rn = new Random();

	/**
	 *Start the came with Random Cards*/
	static public void init() {
		loadPlayers();
		loadDeck();
		tileDraw();
		shareCards();
		update();
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
		tileDraw();
		shareCards();
		update();
		int index = 0;
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
		tileDraw();
		update();
		
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
		tileDraw();
		update();
		
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
		tileDraw();
		update();
		
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
	 * Instantiation of players to populate the list of players
	 * @FirstStrategy - Plays 30 points as soon as it can
	 * @SecondStrategy - 
	 * @ThirdStrategy - */
	static public void loadPlayers() {
		
		// Prompt the user to enter the number of players that will be human
		System.out.println("How many human players will be playing?");
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		String inputString = "";
		try {
			inputString = input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed at reading user input @loadPlayers");
			e.printStackTrace();
		}
		int num = Integer.parseInt ( inputString );
		
		// Initialize the ArrayList of player
		players = new ArrayList<Player>();
		
		// add the specified number of player to the list
		for (int i = 0; i < num; i++) {
			players.add(new PlayerStrategy("Human" + (i+1) , true));		
		}
		
		// Prompt the user to determine the number of AI's
		System.out.println("How many AI players will be playing?");
		inputString = "";
		try {
//			input.reset();
			inputString = input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = Integer.parseInt ( inputString );
				
		// generate AI based on modulo 3 random number
		int spaces_available = 4 - players.size();
		
		//easiest way to deal with wrong input
		if(num + players.size() == 4) {
			spaces_available = 4 - players.size();
		} else if (num + players.size() < 4 && num > 0) {
			spaces_available = num;
		} else if ((num + players.size() > 4) ) {
			spaces_available = 4 - players.size();
		}
		
		int measure = 0;
		for (int i = 0; i < spaces_available; i++) {
			measure = rn.nextInt(10000)%4;
			if( measure == 0) { //create a StratOne
				players.add(new FirstStrategy("AI1-"+i, true));	
			}
			else if (measure == 1) { //create a StratTwo
				players.add(new SecondStrategy("AI2-"+i, true));	
			}
			else if  (measure == 2){ //create a StratThree
				players.add(new ThirdStrategy("AI3-"+i, true));	
			} 
			else {//create a StratFour
				players.add(new SecondStrategy("AI4-"+i, true));	
			}
		}

	}
	/**
	 * Determine the order in which the players will play
	 * Each player draws a tile the highest goes first
	 * Completely Automated at his moment - no input from players required*/
	public static void tileDraw() {
		System.out.println("\n------------------------------------");
		System.out.println("Begin tile draw to determine who starts");
		ArrayList<Tile> tileMap = new ArrayList<Tile>();
		ArrayList<Tile> dirtyTileMap = new ArrayList<Tile>();
		
		// Draw the random tiles
    	for (int i = 0; i < players.size(); i++) {
    		tileMap.add(stock.getRandomTile());
    		dirtyTileMap.add(tileMap.get(i));
    	}
    	
    	System.out.println("Old order"); 

    	for (int i = 0; i < players.size(); i++) {
    		System.out.println(i +": "+ players.get(i).getName());
    	}

		// run a sort on the tileMap
    	System.out.println(tileMap);
		Collections.sort(tileMap);

		
		// let's do some dirty arrangements
		ArrayList<Player> dirtyTemp =  new ArrayList<Player>();
		// add all the players from one list to the other
    	for (int i = 0; i < players.size(); i++) {
    		dirtyTemp.add(players.get(i));
    	}
    	
    	// get the old index and set new one according to the draw results
    	for (int i = 0; i < players.size(); i++) {
    		
    		players.set( tileMap.indexOf(dirtyTileMap.get(i)), dirtyTemp.get(i));
    	}
    	
		System.out.println(tileMap);
    	System.out.println("New order"); 

    	for (int i = 0; i < players.size(); i++) {
    		System.out.println(i +": "+ players.get(i).getName());
    	}
    	
    	System.out.println("End of tile draw");
    	System.out.println("------------------------------------ \n");
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
			long endTime = System.currentTimeMillis() + 120000;
			while(System.currentTimeMillis() < endTime) { meldz = ((PlayerStrategy) player).playTurn();}
			
//			meldsToString = meldz.toString();
//			meldsToString = "{ " +  meldsToString.substring(1, meldsToString.length()) + " }";
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
			meldz = ((FirstStrategy) player).playTurn();
			if (meldz == null) {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName() +" drew from stock");
				numMeldsLastPlayed = 0;
			}
			else {
				System.out.println(player.getClass().getSimpleName() + " " +  player.getName()+ " played a meld: ");
				addMeldz(meldz);
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
				// meldsToString = meldz.toString();
				// meldsToString = "{ " +  meldsToString.substring(1, meldsToString.length()) + " }";
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
	static public void updateJRON() {
		
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
	        } 
		
	}
	/**
	 * Update all subscribers of the state of the game
	 * Updates
	 * */
	static public void update() {
		
		// update the jron data
		updateJRON();
		jron.setContext("update");
	       for (Player x:players) 
	        { 
	    	   	if(x.isLocal()) 
	    	   	{
	    	   		x.update(jron);
	    	   	}
	    	   	else 
	    	   	{
	    	   		try {
						connectSocket(jron);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	   	}
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
	
	 static void connectSocket(JRON jron) throws IOException, ClassNotFoundException {
		 //PlayerStrategy player = (PlayerStrategy)Table.getPlayer(0);
		 
		 int port = 4444;
	  //create the socket server object
        ServerSocket server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject("Hi Client "+message);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();

	 }
	 
	
}

package Rummy.Rummy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {
	//Properties
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	private String name;
	protected ArrayList<Tile> meld = new ArrayList<Tile>();
	protected JRON tableData = null;
	protected boolean playedFirst30 = false;
	protected boolean hasPlayed = false;
	
	//Constructor
	public Player(String aName) {
		this.name = aName;
	}
	
	
	//getters
	public ArrayList<Tile> getHand(){
			
		return this.hand;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getFirst30() {
		return playedFirst30;
	}
	
	public boolean getHasPlayed() {
		return hasPlayed;
	}
	
	/**
	 * @return - The table Data as a JRON*/
	public JRON getJRON() {
		return tableData;
	}
	
	public boolean winner() {
		if(this.hand.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//Setters
	public void setFirst30(boolean first30) {
		this.playedFirst30 = first30;
	}
	
	public void setHasPlayed(boolean played) {
		this.hasPlayed = played;
	}
	
	public void getCards(Deck stock) {
		for(int j=0;j<14;j++) {
			addTile(stock.geTile(stock.getSize()-1));
		}
	}

	
	/**
	 * sorts the hand
	 * */
	public void sortHand() {
		Collections.sort(hand,new valueComparator());
	}
	/**
	 * Remove tiles from the player hand
	 * @indexes - the indexes of the tiles to be removed
	 * */
	public void removeTiles(int[] indexes) {
		
		//Convert to Integer object array
		Integer[] result = new Integer[indexes.length];
		for (int i = 0; i < indexes.length; i++) {
			result[i] = Integer.valueOf(indexes[i]);
		}
		
		List<Integer> reversedList = Arrays.asList(result);
		//Convert the array to a list and reverse the order
		Collections.sort(reversedList, Collections.reverseOrder());
		
		// Remove the items backwards
		for (int i : reversedList)
		    hand.remove(i);
	}
	
	/**
	 * Add a tile to the players hand
	 * */
	public void addTile(Tile aTile) {
		this.getHand().add(aTile);
	}
	/**
	 * returns meld to player hand
	 * */
	public void discardMeld(ArrayList<Tile> meld) {
		for (int i = 0; i < meld.size(); i++) {
			hand.add(meld.get(i));
		}
	}
	/**
	 * checks if the given meld is greater than of equal 30*/
	
	public void customFillHand() {
		hand.add(new Tile(Color.B,1 ));
		hand.add(new Tile(Color.B,2 ));
		hand.add(new Tile(Color.O,6 ));
		hand.add(new Tile(Color.O,7 ));
		hand.add(new Tile(Color.O,8 ));
		hand.add(new Tile(Color.O,12 ));
		hand.add(new Tile(Color.G,5));
		hand.add(new Tile(Color.G,7 ));
		hand.add(new Tile(Color.G,8 ));
		hand.add(new Tile(Color.R,1 ));
		hand.add(new Tile(Color.R,4 ));
		hand.add(new Tile(Color.R,8 ));
		hand.add(new Tile(Color.R,9 ));
		hand.add(new Tile(Color.R,10 ));
		hand.add(new Tile(Color.R,11 ));
		//hand.add(new Tile(Color.R,1 ));		
	}
	
	/**
	 * Function creates melds
	 * @return Collection of melds*/
	protected ArrayList<ArrayList<Tile>> createMelds() {
		
		ArrayList<ArrayList<Tile>> temp = new ArrayList<ArrayList<Tile>>();
		
		// create all the sets possible
		while (true) {
			ArrayList<Tile> meld = createSet(null);
			
			// If there are no sets or run to create just give up
			if (meld == null) {
				break;
			} else {
				temp.add(meld);
			}
		}
		
		// create all the runs possible
		while (true) {
			ArrayList<Tile> meld = createRun(null);
			
			// If there are no sets or run to create just give up
			if (meld == null) {
				break;
			} else {
				temp.add(meld);
			}
		}
		
		if (temp.size()==0)
			return null;
		
		return temp;
	}

	/**
	 * Create a Run
	 * checks for the run with the maximum sum ie O9,O10,O11,O12
	 * @param - Additional tile from the Table that could be used to make a meld
	 * @return A collection of Melds
	 **/
	public ArrayList<Tile> createRun(ArrayList<Tile> additionalTiles) {
		ArrayList<Tile> temp = new ArrayList<Tile>();
		
		// Create a temporary hand
		ArrayList<Tile> tempHand = new ArrayList<Tile>();
		
		// check if any additional Tiles where added
		if(additionalTiles == null){
			tempHand = this.getHand();
		} else {
			tempHand = this.getHand();
			tempHand.addAll(additionalTiles);
		}
		
		Collections.sort(tempHand,new valueComparator());

		for (int i=0; i<hand.size()-1;i++) {
			temp.add(tempHand.get(i));
			for(int j=i+1;j<hand.size();j++) {
				if(MeldChecker.checkColor(temp.get(temp.size()-1), tempHand.get(j))
				&&MeldChecker.checkDifference(temp.get(temp.size()-1), tempHand.get(j))) {
					if (!temp.contains(tempHand.get(j))) {
						temp.add(tempHand.get(j));
					}
				}
				else if(temp.get(temp.size()-1).equals(tempHand.get(j))) {
					continue;
				}
			}
			if(temp.size()>=3) {
				if (hand.containsAll(tempHand)) {
					hand.removeAll(temp);
				} else {
					ArrayList<Tile> temp2= new ArrayList<Tile>();
					temp2.addAll(temp);
					temp2.removeAll(additionalTiles);
					hand.removeAll(temp2);
				}
				return temp;
			}
			temp.clear();	
		}
		
		System.out.println("");
		return null;
	}
	
	/**
	 * Creates a set from from the players hand and additional tiles
	 * @param - Additional tile from the Table that could be used to make a meld
	 * checks if a player has a set ie O11,B11,R11,G11
	 * @return A collection of Melds*/
	public ArrayList<Tile> createSet(ArrayList<Tile> additionalTiles) {
		
		// Create a temporary hand
		ArrayList<Tile> tempHand = new ArrayList<Tile>();
		
		// check if any additional Tiles where added
		if(additionalTiles == null){
			tempHand = this.getHand();
		} else {
			tempHand = this.getHand();
			tempHand.addAll(additionalTiles);
		}
		
		// create a temporary array of melds
		ArrayList<Tile> temp= new ArrayList<Tile>();
		
		Collections.sort(tempHand,new valueComparator());
		for(int i=tempHand.size()-1; i>0;i--) {

			temp.add(tempHand.get(i));
			
			for(int j=i-1;j>=0;j--) {
				if(temp.get(temp.size()-1).getValue()==tempHand.get(j).getValue()) {
						temp.add(tempHand.get(j));
					}
			}
			
			if(temp.size()>=3) {
				if (hand.containsAll(tempHand)) {
					hand.removeAll(temp);
				} else {
					ArrayList<Tile> temp2= new ArrayList<Tile>();
					temp2.addAll(temp);
					temp2.removeAll(additionalTiles);
					hand.removeAll(temp2);
				}
				return temp;
			}
			temp.clear();
		}
		
		System.out.println("");
		return null;
	}
	
	/**
	 * Add melds to the hand
	 * @param - melds: the collection of melds to add to the hand
	 * @return - void */
	protected void addMelds(ArrayList<ArrayList<Tile>> melds) {
		// TODO Auto-generated method stub
		for(ArrayList<Tile> meld: melds) {
			for (Tile tile: meld) {
				this.addTile(tile);
			}
		}
		
	}
	
	public void update(JRON data) {
		this.tableData = data;
	}

	/**
	 * Print the tiles in the current players hand*/
	public void printTiles() {
		Collections.sort(hand,new valueComparator());
		Collections.sort(hand,new colourCompataror());
		String meldsToString = hand.toString();
		meldsToString = "{ " +  meldsToString.substring(1, meldsToString.length() -1) + " }";
		System.out.println(this.name + "'s cards: " + meldsToString);
	}


	public ArrayList<ArrayList<Tile>> playTurn() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    public void playSocket() throws IOException {
        
//        if (args.length != 2) {
//            System.err.println(
//                "Usage: java EchoClient <host name> <port number>");
//            System.exit(1);
//        }

        String hostName = "localhost";
        int portNumber = 4444;

        try (
            Socket rummySocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(rummySocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(rummySocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
                
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
		
}

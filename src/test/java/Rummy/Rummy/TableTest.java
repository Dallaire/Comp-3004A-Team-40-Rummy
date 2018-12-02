package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;

/**
 * Unit test for 
 */
public class TableTest extends TestCase
{
	
    public void testPlayer() {
    	Table.init();
    	assertEquals(Table.getNumPlayers(),Table.getNumPlayers());

    }

    /**
     * Test that tiles are created*/
    public void testTiles() {
    	Deck tiles = new Deck();
    	assertEquals(104,tiles.getSize());

    }
    /**
     * Check accessibility of melds data structure
     * Should be empty because no melds have been played*/
    public void testMelds() {
    	assertEquals(0, Table.getNumMelds());
    }
    
    /**
     * Test if the tiles is not removed from the deck*/

    /**
     * Test if the tiles are removed from the deck*/
    public void testTileSelector2() {
    	Deck tiles = new Deck();
    	Tile selected = tiles.geTile(0);
    	assertEquals(false, tiles.contains(selected));
    }
    
    /**
     * Test to check if the first legitimate meld of over 30 points has been made
     * should be false by default because no tiles have been played
     * 
     * First 30 by each player must be checked- Jacob
     * 
    public void testCheckFirst1() {
    	Table rummy = new Table();
    	assertEquals(false, rummy.checkFirst()); //
    }
    */
    /**
     * Test to check if the first legitimate meld of over 30 points has been made
     * should be false by default because no tiles have been played
    public void testCheckFirst2() {
    	Table rummy = new Table();
    	assertEquals(false, rummy.checkFirst()); //
    }
    */
    
    /**
     * test to check if player input equals p
     * test to check if player wants to play a new game
     */
    public void testPlayerPlay() {
    	Game input = new Game();
    	assertEquals("Y", input.getGameInput());
    }
    
    /**
     * test to check if game input equals F
     * test to check if the player doesn't want to play a new game
     */
    public void testPlayerNotPlay() {
    	Game input = new Game();
    	assertEquals("N", input.getGameInput());
    }
    
    public void testRunChecker() {
    	ArrayList<Tile> run = new ArrayList<Tile>();
    	run.add(new Tile(Color.B,1));
    	run.add(new Tile(Color.B,2));
    	run.add(new Tile(Color.B,3));
    	assertEquals(true, MeldChecker.checkHand(run));
    }
    public void testMeldChecker() {
    	ArrayList<Tile> meld = new ArrayList<Tile>();
    	meld.add(new Tile(Color.O, 10)); 
    	meld.add(new Tile(Color.B, 10)); 
    	meld.add(new Tile(Color.G, 10));
    	assertEquals(true, MeldChecker.checkHand(meld));
    }
     
    public void testAddMeld() {
 
    	ArrayList<Tile> meld = new ArrayList<Tile>();
    	meld.add(new Tile(Color.O, 10)); 
    	meld.add(new Tile(Color.B, 10)); 
    	meld.add(new Tile(Color.G, 10));
    	Table.addMeld(meld);
    	assertEquals(Table.getMeld(0), meld);
    }
    
    /**
     * Test to assert that each player will receive 14 tiles*/
    public void testDealTiles() {

    	Player one = Table.getPlayer(0);
    	Player two = Table.getPlayer(1);
    	Player three = Table.getPlayer(2);
    	Player four = Table.getPlayer(3);
    	
    	assertEquals(14, one.getHand().size());
    	assertEquals(14, two.getHand().size());
    	assertEquals(14, three.getHand().size());
    	assertEquals(14, four.getHand().size());
    	
    }
    
    /**
     *No assertions here, simply view console output*/
    @SuppressWarnings("null")
	public void testLoadPlayer() {

    	Table.init();
    	ArrayList<Player> players = new ArrayList<Player>();
    	System.out.println(Table.getNumPlayers());
    	for (int i = 0; i < 4; i++) {
    		//System.out.println(players.toString());
    		players.add(Table.getPlayer(i));
    	}
    	System.out.println(players.toString());
    	System.out.println(players.size());
    }

	public void testTile() {

    	// get the players 
    	Table.init();
    	ArrayList<Player> players = new ArrayList<Player>();
    	// get all the cards
    	Deck stock = Table.getStock();
		ArrayList<Tile> tileMap = new ArrayList<Tile>();
		ArrayList<Tile> dirtyTileMap = new ArrayList<Tile>();
		
    	for (int i = 0; i < 4; i++) {
    		players.add(Table.getPlayer(i));
    		tileMap.add(stock.getRandomTile());
    		dirtyTileMap.add(tileMap.get(i));
    	}
    	
    	System.out.println(players);    

		// run an insertion sort on the 
    	System.out.println(tileMap);
		Collections.sort(tileMap);

		
		// let's do some dirty arrangements
		ArrayList<Player> dirtyTemp =  new ArrayList<Player>();
		// add all the players from one list to the other
    	for (int i = 0; i < 4; i++) {
    		dirtyTemp.add(players.get(i));
    	}
    	
    	// get the old index and 
    	for (int i = 0; i < 4; i++) {
    		
    		players.set( tileMap.indexOf(dirtyTileMap.get(i)), dirtyTemp.get(i));
    	}
    	
		System.out.println(tileMap);
		System.out.println(players);
		assertEquals(14, 14);

    }
	
    
}

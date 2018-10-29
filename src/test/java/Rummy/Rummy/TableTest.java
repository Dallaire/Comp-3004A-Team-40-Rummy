package Rummy.Rummy;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * Unit test for 
 */
public class TableTest extends TestCase
{
	
    public void testPlayer() {
    	Table rummy = new Table();
    	assertEquals(2,rummy.getNumPlayers());

    }
    /**
     * Test that the table creates 4 players*/
    public void testPlayer2() {
    	Table rummy = new Table();
    	assertEquals(3,rummy.getNumPlayers());
    }
    
    public void testPlayer3() {
    	Table rummy = new Table();
    	assertEquals(4,rummy.getNumPlayers());
    }
    
    /**
     * Test that tiles are created*/
    public void testTiles() {
    	Table rummy = new Table();

    	assertEquals(104,rummy.getNumTiles() );

    }
    /**
     * Check accessibility of melds data structure
     * Should be empty because no melds have been played*/
    public void testMelds() {
    	Table rummy = new Table();
    	assertEquals(0, rummy.getNumMelds());

    }
    
    /**
     * Test if the tiles is not removed from the deck*/

    /**
     * Test if the tiles are removed from the deck*/
    public void testTileSelector2() {
    	Table rummy = new Table();
    	Tile selected = rummy.getTile(); // select a tile from the stock
    	//boolean value = rummy.stockContains(selected); // Check if the tile is in the stock
    	assertEquals(true, rummy.stockContains(selected)); // should be false
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
    
    /**
     * test to check if player input equals R
     * test to check if the player decides to play a run
     */
    public void testPlayerRun() {
    	Game input = new Game();
    	assertEquals("R", input.getPlayerInput());
    }
    
    /**
     * test to check if player input equals M
     * test to check if the player decides to play a run
     */
    
    public void testPlayerMeld() {
    	Game input = new Game();
    	assertEquals("M", input.getPlayerInput());
    }
    
    public void testRunChecker() {
    	MeldChecker check = new MeldChecker();
    	ArrayList<Tile> run = new ArrayList<Tile>();
    	run.add(new Tile(Color.B,1));
    	run.add(new Tile(Color.B,2));
    	run.add(new Tile(Color.B,3));
    	assertEquals(true, check.handChecker(run));
    }
    public void testMeldChecker() {
    	MeldChecker check = new MeldChecker();
    	ArrayList<Tile> meld = new ArrayList<Tile>();
    	meld.add(new Tile(Color.O, 10)); 
    	meld.add(new Tile(Color.B, 10)); 
    	meld.add(new Tile(Color.G, 10));
    	assertEquals(true, check.handChecker(meld));
    }
     
    public void testAddMeld() {
    	Table table = new Table();
    	ArrayList<Tile> meld = new ArrayList<Tile>();
    	meld.add(new Tile(Color.O, 10)); 
    	meld.add(new Tile(Color.B, 10)); 
    	meld.add(new Tile(Color.G, 10));
    	table.addMeld(meld);
    	assertEquals(table.getMeld(0), meld);
    }
     
}

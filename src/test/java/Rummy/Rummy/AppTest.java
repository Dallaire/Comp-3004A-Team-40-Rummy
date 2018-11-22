package Rummy.Rummy;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple 
 */
public class AppTest extends TestCase
{
    public void testTile() {
    	Tile tile = new Tile(Color.O, 10);
    	assertEquals(Color.O, tile.getColor());
    	assertEquals(10, tile.getValue());
    	assertEquals("O10", tile.toString());
    }
    
    public void testDeck() {
    	Deck deck = new Deck();
    	assertEquals(104, deck.getSize());
    	assertNotNull(deck.geTile(0));
    	assertEquals(103, deck.getSize());
    }
    
    public void testPlayer() {
    	PlayerStrategy player = new PlayerStrategy("John", true);
    	assertEquals("John", player.getName());
    }
    
    public void testAddTile() {
    	PlayerStrategy player = new PlayerStrategy("John", true);
    	player.addTile(new Tile(Color.O, 10));
    	assertEquals(1,player.getHand().size());
    }
    
    /**
     * Test createRun & createSet
     * Play first 30 points as soon as possible
     * */
    public void testCreateRun() {

    	Deck stock = new Deck();
		stock.Shuffle();
		Player ai1 = new Player("POE", true);
		ai1.addTile(new Tile(Color.O, 6));
		ai1.addTile(new Tile(Color.B, 3));
		ai1.addTile(new Tile(Color.R, 12));
		ai1.addTile(new Tile(Color.B, 8));
		ai1.addTile(new Tile(Color.R, 12));
		ai1.addTile(new Tile(Color.G, 13));
		ai1.addTile(new Tile(Color.R, 13));
		ai1.addTile(new Tile(Color.O, 13));
		ai1.addTile(new Tile(Color.O, 13));
		ai1.addTile(new Tile(Color.G, 6));
		ai1.addTile(new Tile(Color.B, 11));
		ai1.addTile(new Tile(Color.B, 9));
		ai1.addTile(new Tile(Color.B, 10));
		Collections.sort(ai1.getHand(),new valueComparator());
    	ArrayList<Tile> temp=ai1.createRun(null);
    	ArrayList<Tile> meld=new ArrayList<Tile>();
    	meld.add(new Tile(Color.B, 11));
    	meld.add(new Tile(Color.B, 10));
    	meld.add(new Tile(Color.B, 9));
    	meld.add(new Tile(Color.B, 8));
    		 
	  	for (int i = 0; i < meld.size(); i++) {   
	  		assertEquals(meld.get(i).getValue(), temp.get(i).getValue());
	  		assertEquals(meld.get(i).getColor(), temp.get(i).getColor());
	  	}    	
    }
    
    public void testCreateSet() {

    	Deck stock = new Deck();
		stock.Shuffle();
		Player ai1 = new Player("POE", true);
		ai1.addTile(new Tile(Color.O, 6));
		ai1.addTile(new Tile(Color.B, 3));
		ai1.addTile(new Tile(Color.R, 12));
		ai1.addTile(new Tile(Color.B, 8));
		ai1.addTile(new Tile(Color.R, 12));
		ai1.addTile(new Tile(Color.G, 13));
		ai1.addTile(new Tile(Color.R, 13));
		ai1.addTile(new Tile(Color.O, 13));
		ai1.addTile(new Tile(Color.O, 13));
		ai1.addTile(new Tile(Color.G, 6));
		ai1.addTile(new Tile(Color.B, 11));
		ai1.addTile(new Tile(Color.B, 9));
		ai1.addTile(new Tile(Color.B, 10));
		Collections.sort(ai1.getHand(),new valueComparator());
    	ArrayList<Tile> temp=ai1.createSet(null);
    	ArrayList<Tile> meld=new ArrayList<Tile>();
    	meld.add(new Tile(Color.G, 13));
    	meld.add(new Tile(Color.R, 13));
    	meld.add(new Tile(Color.O, 13));
    	meld.add(new Tile(Color.O, 13));
    		 
	  	for (int i = 0; i < meld.size(); i++) {   
	  		assertEquals(meld.get(i).getValue(), temp.get(i).getValue());
	  	}    	
    }

}

package Rummy.Rummy;

import junit.framework.TestCase;

/**
 * Unit test for simple 
 */
public class AppTest 
    extends TestCase
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
    }
    
    public void testPlayer() {
    	Strategy first = new FirstStrategy();
    	Player player = new Player("John", first);
    	assertEquals("John", player.getName());
    	assertEquals(first, player.getStrategy());
    	assertFalse(player.getFirst30());
    	player.setFirst30(true);
    	assertTrue(player.getFirst30());
    }
    
    public void testAddTile() {
    	Strategy first = new FirstStrategy();
    	Player player = new Player("John", first);
    	player.addTile(new Tile(Color.O, 10));
    	assertEquals(1,player.getHand().size());
    }
}

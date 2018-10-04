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
    }
    
    public void testDeck() {
    	Deck deck = new Deck();
    	assertEquals(104, deck.getSize());
    }
}

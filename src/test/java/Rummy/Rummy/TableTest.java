package Rummy.Rummy;

import junit.framework.TestCase;

/**
 * Unit test for simple 
 */
public class TableTest extends TestCase
{
    public void testPlayer() {
    	Table rummy = new Table();
    	assertEquals(2,rummy.getNumPlayers());

    }
    
    public void testPlayer2() {
    	Table rummy = new Table();
    	assertEquals(3,rummy.getNumPlayers());
    }
    
    public void testPlayer3() {
    	Table rummy = new Table(4);
    	assertEquals(4,rummy.getNumPlayers());
    }
    
    public void testPlayer4() {
    	Table rummy = new Table();
    	assertEquals(null,rummy.getNumPlayers());
    }
    public void testTiles() {
    	Table rummy = new Table();
    	assertEquals(104,rummy.getNumTiles() );

    }
    
    public void testMelds() {
    	Table rummy = new Table();
    	assertEquals(null, rummy.getMelds());

    }
    
    /**
     * Test if the tiles are removed from the deck*/
    public void testTileSelector() {
    	Table rummy = new Table();
    	Tile selected = rummy.selectTile();
    	boolean value = rummy.stockContains(selected);
    	assertEquals(false, value);
    }
}

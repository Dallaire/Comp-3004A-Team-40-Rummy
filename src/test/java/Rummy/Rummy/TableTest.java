package Rummy.Rummy;

import junit.framework.TestCase;

/**
 * Unit test for simple 
 */
public class TableTest extends TestCase
{
<<<<<<< HEAD
//    public void testPlayer() {
//    	Table rummy = new Table(2);
//    	assertEquals(2,rummy.getNumPlayers());
//
//    }
//    
//    public void testPlayer2() {
//    	Table rummy = new Table(3);
//    	assertEquals(3,rummy.getNumPlayers());
//    }
//    
//    public void testPlayer3() {
//    	Table rummy = new Table(4);
//    	assertEquals(4,rummy.getNumPlayers());
//    }
//    
//    public void testPlayer4() {
//    	Table rummy = new Table(5);
//    	assertEquals(null,rummy.getNumPlayers());
//    }
//    public void testTiles() {
//    	Table rummy = new Table(2);
//    	assertEquals(52,rummy.getNumTiles() );
//
//    }
    public void testShareCards() {
		Table rummy = new Table();
		//rummy.shareCards();
		//assertEquals(5, 5);
		//assertEquals(14, rummy.getPlayer(1).getHand().size());
	}
//    public void testMelds() {
//    	//Table rummy = new Table(2);
//    	//assertEquals(null, );
//
//    }
=======
    public void testPlayer() {
    	Table rummy = new Table();
    	assertEquals(2,rummy.getNumPlayers());

    }
    
    public void testPlayer2() {
    	Table rummy = new Table();
    	assertEquals(3,rummy.getNumPlayers());
    }
    
    public void testPlayer3() {
    	Table rummy = new Table();
    	assertEquals(4,rummy.getNumPlayers());
    }
    
    public void testPlayer4() {
    	Table rummy = new Table();
    	assertEquals(null,rummy.getNumPlayers());
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
    	assertEquals(null, rummy.getNumMelds());

    }
    
    /**
     * Test if the tiles is not removed from the deck*/
    public void testTileSelector1() {
    	Table rummy = new Table();
    	Tile selected = rummy.selectTile(); // select a tile from the stock
    	boolean value = rummy.stockContains(selected); // Check if the tile is in the stock
    	assertEquals(true, value); // should be false
    }
    
    /**
     * Test if the tiles are removed from the deck*/
    public void testTileSelector2() {
    	Table rummy = new Table();
    	Tile selected = rummy.selectTile(); // select a tile from the stock
    	boolean value = rummy.stockContains(selected); // Check if the tile is in the stock
    	assertEquals(false, value); // should be false
    }
    
    /**
     * Test to check if the first legitimate meld of over 30 points has been made
     * should be false by default because no tiles have been played*/
    public void testCheckFirst1() {
    	Table rummy = new Table();
    	assertEquals(false, rummy.checkFirst()); //
    }
    
    /**
     * Test to check if the first legitimate meld of over 30 points has been made
     * should be false by default because no tiles have been played*/
    public void testCheckFirst2() {
    	Table rummy = new Table();
    	assertEquals(false, rummy.checkFirst()); //
    }
>>>>>>> 5375e486eba6afa082657ae342ec9cf788938a06
}

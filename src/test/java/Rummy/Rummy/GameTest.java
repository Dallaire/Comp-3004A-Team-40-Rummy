/**
 * 
 */
package Rummy.Rummy;

import junit.framework.TestCase;

/**
 * @author POE
 *
 */
public class GameTest extends TestCase {

	/**
	 * Test that the game starts*/
	public void testStart() {
		
	}
	
	
	/**
	 * Test Game loads the Table and cycles through players
	 * game starts and cycles through the players to get the */
	public void testGameLoop() {
		Game rummyKub = new Game();
		Table table = new Table();
		rummyKub.play();
		System.out.println(table.getNumPlayers());
		System.out.println(rummyKub.getTurns());
		assertEquals(table.getNumPlayers(), rummyKub.getTurns()); 

	}
	/***
	 * A player is stuck in loop until they play a valid meld*/
	public void testPlayerLoop() {
		
	}

}

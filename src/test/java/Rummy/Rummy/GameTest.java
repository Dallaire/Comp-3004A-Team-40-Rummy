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
	 * Test Game loads te Table and cycles through players
	 * game starts and cycles through the players to get the */
	public void testGameLoop() {
		Game rummyKub = new Game();
		Table table = new Table();
		rummyKub.loop();
		System.out.println(table.getNumPlayers());
		System.out.println(rummyKub.getTurns());
		assertEquals(table.getNumPlayers(), rummyKub.getTurns()); 

	}

}

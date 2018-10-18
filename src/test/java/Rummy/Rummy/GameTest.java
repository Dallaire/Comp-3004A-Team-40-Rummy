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

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	 * Test Game loads te Table and cycles through players
	 * game starts and cycles through the players to get the */
	public void testGameLoop() {
		Game rummyKub = new Game();
		rummyKub.start();
		assertEquals(3, rummyKub.getTurns()); 
	}

}

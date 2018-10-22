package Rummy.Rummy;

import junit.framework.TestCase;

public class TableTest2 extends TestCase {
	
    public void testPlayerMeld() {
    	Game input = new Game();
    	assertEquals("M", input.getPlayerInput());
    }
	
}

package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TableTest2 extends TestCase {
	
	/**
	 * Test that the table cycles through players to play their turns*/
    public void testPlayerMeld1_1() {
    	Table rummy = new Table();
    	assertEquals(0, rummy.whosMove());
    }
    
    public void testPlayerMeld_2() {
    	Table rummy = new Table();
    	rummy.nextMove();
    	assertEquals(1, rummy.whosMove());
    }
    
    public void testPlayerMeld_3() {
    	Table rummy = new Table();
    	rummy.nextMove();
    	rummy.nextMove();
    	assertEquals(2, rummy.whosMove());
    }
    
    public void testPlayerMeld_4() {
    	Table rummy = new Table();
    	rummy.nextMove();
    	rummy.nextMove();
    	rummy.nextMove();
    	assertEquals(3, rummy.whosMove());
    }
	
    public void testPlayerMeld_5() {
    	Table rummy = new Table();
    	rummy.nextMove();
    	rummy.nextMove();
    	rummy.nextMove();
    	rummy.nextMove();
    	assertEquals(0, rummy.whosMove());
    }
    
    /**
     * Test if the JRON is working*/
    public void testJRON() {
    	Table rummy = new Table();
    	JRON data = new JRON(rummy.getMelds(), rummy.getFirst(), rummy.getThreeLess());
    	assertEquals(false, data.getThreeLess());
    	assertEquals(false, data.getFirstMeld());
    	assertEquals(true, data.getMelds() instanceof ArrayList);
    }
}

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
    
    /**
     * Test getting class types of Players*/
    public void testClass() {
		PlayerStrategy p1 = new PlayerStrategy("dude");
		PlayerStrategy p2 = new PlayerStrategy("another dude");
		FirstStrategy ai1 = new FirstStrategy("AI 1");
		SecondStrategy ai2 = new SecondStrategy("AI 2");	
		ThirdStrategy ai3 = new ThirdStrategy("AI 3");
		
		System.out.println(p1.getClass());
		assertEquals(p1.getClass(),p2.getClass());
		assertEquals(true, p1.getClass().equals(p2.getClass()));
		assertEquals(false, p1.getClass().equals(ai3.getClass()));
		assertEquals(false, p1.getClass().equals(ai2.getClass()));
		assertEquals(false, p1.getClass().equals(ai1.getClass()));
    }
}

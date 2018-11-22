package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TableTest2 extends TestCase {
	
	/**
	 * Test that the table cycles through players to play their turns*/
    public void testPlayerMeld1_1() {
    	Table.init();
    	assertEquals(0, Table.whosMove());
    }
    
    public void testPlayerMeld_2() {
    	
    	Table.nextMove();
    	assertEquals(1, Table.whosMove());
    }
    
    public void testPlayerMeld_3() {

    	Table.nextMove();
    	assertEquals(2, Table.whosMove());
    }
    
    public void testPlayerMeld_4() {

    	Table.nextMove();
    	assertEquals(3, Table.whosMove());
    }
	
    public void testPlayerMeld_5() {
   
    	Table.nextMove();
    	assertEquals(0, Table.whosMove());
    }
    
    /**
     * Test if the JRON is working*/
    public void testJRON_1() {

    	JRON data = new JRON(Table.getMelds(), Table.getFirst(), Table.getThreeLess(), null);
    	assertEquals(false, data.getThreeLess());
    	assertEquals(false, data.getFirstMeld());
    	assertEquals(true, data.getMelds() instanceof ArrayList);
    }
    
    /**

     * Test getting class types of Players*/
    public void testClass() {
    	
    	Table.init();
		PlayerStrategy p1 = new PlayerStrategy("dude",true);
		PlayerStrategy p2 = new PlayerStrategy("another dude",true);
		FirstStrategy ai1 = new FirstStrategy("AI 1", true);
		SecondStrategy ai2 = new SecondStrategy("AI 2", true);	
		ThirdStrategy ai3 = new ThirdStrategy("AI 3", true);
		
		System.out.println(p1.getClass());
		assertEquals(p1.getClass(),p2.getClass());
		assertEquals(true, p1.getClass().equals(p2.getClass()));
		assertEquals(false, p1.getClass().equals(ai3.getClass()));
		assertEquals(false, p1.getClass().equals(ai2.getClass()));
		assertEquals(false, p1.getClass().equals(ai1.getClass()));
    }

    public void testPlayersClass() {
    	Table.init();
    	Player player;
    	for (int i = 0; i < 4; i++) {
    		player = Table.getPlayer(i);
    		System.out.println(player.getClass().getSimpleName());  		
    		
    	}  	
    }   

}

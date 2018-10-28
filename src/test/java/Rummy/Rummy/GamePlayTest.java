/**
 * 
 */
package Rummy.Rummy;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author poe
 *
 */
public class GamePlayTest extends TestCase{

	@Test
	public void testCycle() {
		
		Table rummy = new Table();
		rummy.init();
		rummy.playNext();
	}
	
	/**
	 * Test on how to differentiate between ai and human player*/
	public void testDiff() {
		PlayerStrategy p1 = new PlayerStrategy("dude");
		PlayerStrategy p2 = new PlayerStrategy("another dude");
		FirstStrategy ai1 = new FirstStrategy("AI 1");
		SecondStrategy ai2 = new SecondStrategy("AI 2");	
		ThirdStrategy ai3 = new ThirdStrategy("AI 3");
		
		assertEquals(p1 instanceof PlayerStrategy, p2 instanceof PlayerStrategy); 
		assertEquals(p1 instanceof PlayerStrategy, ai1 instanceof Player); 
		assertEquals(p1 instanceof PlayerStrategy, ai2 instanceof SecondStrategy);
		assertEquals(p1 instanceof PlayerStrategy, ai3 instanceof ThirdStrategy);

	}
	
	
	public void testInteractiveLogic() {
		Table rummy = new Table();
		rummy.init();
		rummy.playNext();
		rummy.playNext();
		rummy.playNext();
		rummy.playNext();
		
	}
	
	public void testPlayerReadInput() {
		PlayerStrategy p1 = new PlayerStrategy("dude");
		int[] array = p1.readInput();
		int[] array2 =  {1,2,3};
		assertArrayEquals(array2, array);
		
 	}
	

}

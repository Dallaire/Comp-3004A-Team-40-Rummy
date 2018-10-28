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
		FirstStrategy ai1 = new FirstStrategy("AI 1");
		SecondStrategy ai2 = new SecondStrategy("AI 2");	
		ThirdStrategy ai3 = new ThirdStrategy("AI 3");
		
		assertEquals(p1, ai1); 
		assertEquals(p1, ai2);
		assertEquals(p1, ai3);
		assertEquals(ai2, ai1);
	}

}

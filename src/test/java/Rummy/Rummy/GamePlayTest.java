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

}

package Rummy.Rummy;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class TestFirstStrategy extends TestCase {

	@Test
	public void testplayMeld() {
		Table.init();
		FirstStrategy ai1= new FirstStrategy("AI1");
		ai1.customFillHand();
		ArrayList<ArrayList<Tile>> meld = ai1.playTurn();
		
		for (ArrayList<Tile> m: meld) {
			assertEquals(true, MeldChecker.checkSet(m) || MeldChecker.checkRun(m));
		}
		
		
	}

}

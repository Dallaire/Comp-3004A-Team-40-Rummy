package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SecondStratTests extends TestCase {

	public void testWait30() {
		Table.init();
		SecondStrategy player = (SecondStrategy)Table.getPlayer(2);
		JRON jron = new JRON(Table.getMelds(),Table.getFirst(),Table.getThreeLess(), Table.getStock());
		player.update(jron);
		int handsize1 = player.getHand().size();
		player.playTurn2(Table.getMelds());
		int handsize2 = player.getHand().size();
		assertTrue(Table.getMelds().isEmpty());
		assertEquals(1, handsize2-handsize1);
	}
}

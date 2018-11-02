package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SecondStratTests extends TestCase {

	public void testWait30() {
		Table.init();
		SecondStrategy player = (SecondStrategy)Table.getPlayer(2);
		JRON jron = new JRON(Table.getMelds(),Table.getFirst(),Table.getThreeLess(), Table.getStock());
		player.update(jron);
		player.playTurn2(Table.getMelds());
		assertTrue(Table.getMelds().isEmpty());
	}
}

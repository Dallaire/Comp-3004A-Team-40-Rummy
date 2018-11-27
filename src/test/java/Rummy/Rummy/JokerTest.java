package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class JokerTest extends TestCase {
	
	public void testJokerInSet() {
		Table.getMelds().clear();
		FirstStrategy player = new FirstStrategy("p1", true);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 8));
		player.addTile(new Tile(Color.R, 8));
		player.addTile(new Joker(null,0));
		player.setFirst30(true);
		player.playTurn();
		System.out.println(Table.getMelds());
		assertTrue(player.getHand().isEmpty());
	}
}

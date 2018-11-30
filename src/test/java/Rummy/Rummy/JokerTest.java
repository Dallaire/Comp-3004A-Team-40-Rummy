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
		player.addTile(new Tile(null,0));
		player.setFirst30(true);
		player.playTurn();
		assertTrue(player.getHand().isEmpty());
	}
	
	public void testJokerRun() {
		Table.getMelds().clear();
		FirstStrategy player = new FirstStrategy("p1", true);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.B, 9));
		player.addTile(new Tile(Color.B, 7));
		player.addTile(new Tile(null,0));
		player.setFirst30(true);
		player.playTurn();
		System.out.println(player.getHand().size());
		assertTrue(player.getHand().isEmpty());
	}
}

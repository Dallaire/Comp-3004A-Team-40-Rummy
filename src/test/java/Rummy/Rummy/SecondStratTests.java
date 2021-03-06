package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class SecondStratTests extends TestCase {

	public void testWait30() {
		Table.init();
		Table.getMelds().clear();
		SecondStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof SecondStrategy) {
				player = (SecondStrategy)x;
				break;
			}
		}
		if (player != null) {		JRON jron = new JRON(Table.getMelds(),false,Table.getThreeLess(), "update", Table.getStock());
		player.update(jron);
		int handsize1 = player.getHand().size();
		player.playTurn2();
		int handsize2 = player.getHand().size();
		assertTrue(Table.getMelds().isEmpty());
		assertEquals(1, handsize2-handsize1);}
	}
	
	public void testPlay30isTrue() {
		Table.init();
		Table.getMelds().clear();
		Table.setFirst30(true);
		SecondStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof SecondStrategy) {
				player = (SecondStrategy)x;
				break;
			}
		}
		if (player != null) {
		JRON jron = new JRON(Table.getMelds(),Table.getFirst(),Table.getThreeLess(), "update",Table.getStock());
		player.update(jron);
		int handsize1 = player.getHand().size();
		player.playTurn2();
		int handsize2 = player.getHand().size();
		if(!player.getHasPlayed()) {
			assertTrue(Table.getMelds().isEmpty());
			assertEquals(1, handsize2-handsize1);
		}
		else {
			assertFalse(Table.getMelds().isEmpty());}
		}
	}
	
	public void testPlayAllTilesNoTable() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		SecondStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof SecondStrategy) {
				player = (SecondStrategy)x;
				break;
			}
		}
		if (player != null) {
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 1));
		player.addTile(new Tile(Color.B, 2));
		player.addTile(new Tile(Color.B, 3));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 8));
		player.addTile(new Tile(Color.R, 8));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false, "update", Table.getStock()));
		player.setFirst30(true);
		player.playTurn2();
		
		assertTrue(player.getHand().isEmpty());}
	}
	
	public void testPlayAllTilesWithTable() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		SecondStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof SecondStrategy) {
				player = (SecondStrategy)x;
				break;
			}
		}
		if (player != null) {
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 1));
		player.addTile(new Tile(Color.B, 2));
		player.addTile(new Tile(Color.B, 3));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 8));
		player.addTile(new Tile(Color.R, 5));
		player.addTile(new Tile(Color.R, 8));
		ArrayList<Tile> meld = new ArrayList<Tile>();
		meld.add(new Tile(Color.R, 2));
		meld.add(new Tile(Color.R, 3));
		meld.add(new Tile(Color.R, 4));
		Table.addMeld(meld);
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false, "update", Table.getStock()));
		player.setFirst30(true);
		player.playTurn2();
		assertTrue(player.getHand().isEmpty());}
	}
}

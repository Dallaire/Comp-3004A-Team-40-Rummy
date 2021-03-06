package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ThirdStratTests extends TestCase {
	
	public void testPlayFirst30Immediately() {
		Table.loadPlayers();
		Table.getMelds().clear();
		ThirdStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof ThirdStrategy) {
				player = (ThirdStrategy)x;
				break;
			}
		}
		if (player != null) {
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 12));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 9));
		player.addTile(new Tile(Color.R, 8));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false, "update", Table.getStock()));
		player.playTurn2();

		
		assertTrue(!Table.getMelds().isEmpty());}
	}

	public void testPlayFirst30Later() {
		Table.init();
		Table.getMelds().clear();
		ThirdStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof ThirdStrategy) {
				player = (ThirdStrategy)x;
				break;
			}
		}
		if (player != null) {
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 9));
		player.addTile(new Tile(Color.R, 8));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false, "update", Table.getStock()));

		player.playTurn2();

		
		assertTrue(Table.getMelds().isEmpty());
		
		player.addTile(new Tile(Color.B, 12));

		player.playTurn2();
	
		assertTrue(!Table.getMelds().isEmpty());}
	}
	
	public void testPlayWinNoTable() {
		Table.init();
		Table.getMelds().clear();
		ThirdStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof ThirdStrategy) {
				player = (ThirdStrategy)x;
				break;
			}
		}
		if (player != null) {		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 12));
		player.addTile(new Tile(Color.B, 9));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.R, 7));
		player.addTile(new Tile(Color.R, 9));
		player.addTile(new Tile(Color.R, 8));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false, "update", Table.getStock()));
		player.setFirst30(true);

		player.playTurn2();


		player.playTurn2();
		assertTrue(player.getHand().isEmpty());}
	}
	
	public void testPlayWinWithTable() {
		Table.init();
		Table.getMelds().clear();
		ThirdStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof ThirdStrategy) {
				player = (ThirdStrategy)x;
				break;
			}
		}
		if (player != null) {		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 12));
		player.addTile(new Tile(Color.B, 9));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.R, 7));
		player.addTile(new Tile(Color.R, 9));
		player.addTile(new Tile(Color.R, 8));
		player.addTile(new Tile(Color.G, 4));
		player.addTile(new Tile(Color.G, 5));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false, "update", Table.getStock()));
		player.setFirst30(true);
		ArrayList<Tile> meld = new ArrayList<Tile>();
		meld.add(new Tile(Color.G, 1));
		meld.add(new Tile(Color.G, 2));
		meld.add(new Tile(Color.G, 3));

		player.playTurn2();
		Table.addMeld(meld);

		player.playTurn2();
		assertTrue(player.getHand().isEmpty());}
	}
	
	/**
	 * Test that the JRON return false for threeLess if all players pass*/
	/*public void testThreeLess_1() {
		Table.initPass("pass");
		Table.playNext();
		Table.playNext();
		Table.playNext();
		Table.playNext();
		ThirdStrategy player = null;
		for (Player x:Table.getPlayers()) {
			if (x instanceof ThirdStrategy) {
				player = (ThirdStrategy)x;
				break;
			}
		}
		if (player != null) {		JRON data = player.getJRON();
		boolean threeLess = data.getThreeLess();
		assertEquals(false, threeLess);}
		
	}*/
}

package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class PlayerStrataTests extends TestCase {
	public void testSelectBoard() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		PlayerStrategy player = (PlayerStrategy)Table.getPlayer(0);
		ArrayList<Tile> meld = new ArrayList<Tile>();
		meld.add(new Tile(Color.R, 2));
		meld.add(new Tile(Color.R, 3));
		meld.add(new Tile(Color.R, 4));
		Table.addMeld(meld);
		player.selectBoardTile();
		System.out.println("Table After selected: " + Table.getMelds());
		System.out.println("Hand: " + player.getHand());
		assertEquals(meld,player.getHand());
		
	}
}

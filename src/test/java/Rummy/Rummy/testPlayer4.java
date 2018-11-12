package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class testPlayer4 extends TestCase {

	/**
	 * Test for 4b2
	 * The PlayerStrategy plays multiple melds more than 30 points
	 * -shows player can add a meld to the Table*/
	public void testPlayerManyMeldsTo30_1() {
		Table.init4a("4b1");
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.R, 4));
		meld.add(new Tile(Color.B, 4));
		meld.add(new Tile(Color.G, 4));
		meld.add(new Tile(Color.O, 4));
		assertEquals(Table.getNumMelds(), 3);
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
		meld.clear();
		
		meld.add(new Tile(Color.R, 5));
		meld.add(new Tile(Color.B, 5));
		meld.add(new Tile(Color.G, 5));
		meld.add(new Tile(Color.O, 5));
		assertEquals(Table.getNumMelds(), 3);
		assertEquals(true, Table.getMeld(1).toString().equals(meld.toString()));
		meld.clear();
		
		meld.add(new Tile(Color.R, 6));
		meld.add(new Tile(Color.B, 6));
		meld.add(new Tile(Color.G, 6));
		meld.add(new Tile(Color.O, 6));
		assertEquals(Table.getNumMelds(), 3);
		assertEquals(true, Table.getMeld(2).toString().equals(meld.toString()));
	}
	
	/**
	 * Test for 4b2
	 * The PlayerStrategy plays multiple melds less than 30
	 * -shows player can add a meld to the Table*/
	public void testPlayerManyMeldsTo30_2() {
		Table.init4b("4b2");

		int size_before = Table.getPlayer(0).getHand().size();
		Table.playNext();
		assertEquals(Table.getNumMelds(),0);
		assertEquals(Table.getPlayer(0).getHand().size(), size_before + 1);

	}
	
}

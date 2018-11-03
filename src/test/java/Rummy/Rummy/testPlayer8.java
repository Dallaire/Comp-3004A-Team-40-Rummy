package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class testPlayer8 extends TestCase {
	
	/**
	 * Test file input mode*/
	public void testPlayerFileMode() {
		Table.init8();
		PlayerStrategy player = (PlayerStrategy) Table.getPlayer(0);
		String mode = player.getMode();
		assertEquals("file", mode);
	}
	
	/**
	 * Test for 8b
	 * The PlayerStrategy plays a single set
	 * -shows player can add a meld to the Table*/
	public void testPlayerPlaysMeld() {
		Table.init8();
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.R, 9));
		meld.add(new Tile(Color.B, 9));
		meld.add(new Tile(Color.G, 9));
		meld.add(new Tile(Color.O, 9));
		System.out.println(Table.getMeld(0).toString());
		System.out.println(meld.toString());
		assertEquals(Table.getNumMelds(), 1);
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
	}
	
	
}

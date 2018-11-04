package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class testPlayer8 extends TestCase {
	
	/**
	 * Test file input mode*/
	public void testPlayerFileMode() {
		Table.init8("8a");
		PlayerStrategy player = (PlayerStrategy) Table.getPlayer(0);
		String mode = player.getMode();
		assertEquals("file", mode);
	}
	
	/**
	 * Test for 8b
	 * The PlayerStrategy plays a single set
	 * -shows player can add a meld to the Table*/
	public void testPlayerPlaysMeldSet() {
		Table.init8("8b");
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.R, 9));
		meld.add(new Tile(Color.B, 9));
		meld.add(new Tile(Color.G, 9));
		meld.add(new Tile(Color.O, 9));
		assertEquals(Table.getNumMelds(), 1);
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
	}
	
	/**
	 * Test for 8a
	 * The PlayerStrategy plays a single run
	 * -shows player can add a meld to the Table*/
	public void testPlayerPlaysMeldRun() {
		Table.init8("8a");
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.B, 9));
		meld.add(new Tile(Color.B, 10));
		meld.add(new Tile(Color.B, 11));

		assertEquals(1, Table.getNumMelds());
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
	}
	
	/**
	 * Test for 8c
	 * The PlayerStrategy plays multiple runs
	 * -shows player can add a meld to the Table*/
	public void testPlayerPlaysMeldMultipleRuns() {
		Table.init8("8c");
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.B, 9));
		meld.add(new Tile(Color.B, 10));
		meld.add(new Tile(Color.B, 11));
		
		assertEquals(Table.getNumMelds(), 2);
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
		meld.clear();
		
		meld.add(new Tile(Color.G, 9));
		meld.add(new Tile(Color.G, 10));
		meld.add(new Tile(Color.G, 11));
		
		assertEquals(Table.getNumMelds(), 2);
		assertEquals(true, Table.getMeld(1).toString().equals(meld.toString()));
		
	}
	
	/**
	 * Test for 8d
	 * The PlayerStrategy plays multiple sets
	 * -shows player can add a meld to the Table*/
	public void testPlayerPlaysMeldMultipleSet() {
		Table.init8("8d");
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.R, 9));
		meld.add(new Tile(Color.B, 9));
		meld.add(new Tile(Color.G, 9));
		meld.add(new Tile(Color.O, 9));
		assertEquals(Table.getNumMelds(), 2);
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
		meld.clear();
		
		meld.add(new Tile(Color.R, 10));
		meld.add(new Tile(Color.B, 10));
		meld.add(new Tile(Color.G, 10));
		meld.add(new Tile(Color.O, 10));
		assertEquals(Table.getNumMelds(), 2);
		assertEquals(true, Table.getMeld(1).toString().equals(meld.toString()));
	}
	
	/**
	 * Test for 4b2
	 * The PlayerStrategy plays multiple melds to get to 30
	 * -shows player can add a meld to the Table*/
	public void testPlayerManyMeldsTo30() {
		Table.init4("4b2");
		Table.playNext();
		ArrayList<Tile> meld = new ArrayList<Tile>();
		
		meld.add(new Tile(Color.R, 9));
		meld.add(new Tile(Color.B, 9));
		meld.add(new Tile(Color.G, 9));
		meld.add(new Tile(Color.O, 9));
		assertEquals(Table.getNumMelds(), 2);
		assertEquals(true, Table.getMeld(0).toString().equals(meld.toString()));
		meld.clear();
		
		meld.add(new Tile(Color.R, 10));
		meld.add(new Tile(Color.B, 10));
		meld.add(new Tile(Color.G, 10));
		meld.add(new Tile(Color.O, 10));
		assertEquals(Table.getNumMelds(), 2);
		assertEquals(true, Table.getMeld(1).toString().equals(meld.toString()));
	}
	
	
	
	
}

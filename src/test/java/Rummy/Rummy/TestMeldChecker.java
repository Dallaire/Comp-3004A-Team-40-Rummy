package Rummy.Rummy;

import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import org.junit.Test;

import junit.framework.TestCase;

public class TestMeldChecker extends TestCase {
	@Test
	public void testCheckDifference() {
		Tile t1= new Tile(Color.O, 10);
		Tile t2= new Tile(Color.O, 9);
		assertTrue(MeldChecker.checkDifference(t1,t2));
		assertFalse(MeldChecker.checkDifference(t1, t1));
	}
	public void testCheckColor() {
		Tile t1= new Tile(Color.O, 10);
		Tile t2= new Tile(Color.B, 9);
		assertTrue(MeldChecker.checkColor(t1, t1));
		assertFalse(MeldChecker.checkColor(t1, t2));
	}
	public void testCheck30() {
		ArrayList<Tile> meld=new ArrayList<Tile>();
		meld.add(new Tile(Color.O, 11));
		meld.add(new Tile(Color.O, 11));
		meld.add(new Tile(Color.O, 11));
		meld.add(new Tile(Color.O, 11));
		assertTrue(MeldChecker.check30(meld));
		meld.clear();
		meld.add(new Tile(Color.O, 1));
		meld.add(new Tile(Color.O, 1));
		meld.add(new Tile(Color.O, 1));
		assertFalse(MeldChecker.check30(meld));

	}
	public void testCheckSet() {
		ArrayList<Tile> meld=new ArrayList<Tile>();
		meld.add(new Tile(Color.O, 11));
		meld.add(new Tile(Color.O, 11));
		meld.add(new Tile(Color.O, 11));
		assertTrue(MeldChecker.checkSet(meld));
		meld.add(new Tile(Color.O, 9));
		assertFalse(MeldChecker.checkSet(meld));
	}
	public void testCheckRun() {
		ArrayList<Tile> meld=new ArrayList<Tile>();
		meld.add(new Tile(Color.O, 11));
		meld.add(new Tile(Color.O, 10));
		meld.add(new Tile(Color.O, 9));
		assertTrue(MeldChecker.checkRun(meld));
		meld.add(new Tile(Color.B, 3));
		assertFalse(MeldChecker.checkRun(meld));
	}
	public void testCheckSum() {
		ArrayList<Tile> meld=new ArrayList<Tile>();
		meld.add(new Tile(Color.O, 10));
		meld.add(new Tile(Color.O, 10));
		meld.add(new Tile(Color.O, 10));
		assertEquals(30, MeldChecker.checkSum(meld));
	}
}

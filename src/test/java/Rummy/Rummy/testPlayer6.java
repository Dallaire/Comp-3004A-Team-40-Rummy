package Rummy.Rummy;

import junit.framework.TestCase;

public class testPlayer6 extends TestCase {
	/**
	 * Test for 6
	 * The PlayerStrategy draws from Pile
	 * -shows player can add a meld to the Table*/
	public void testPlayerPlaysPicksFromStock() {
		Table.init8("6a");
		int size_before = Table.getMelds().size();
		Table.playNext();
		int size_after = Table.getMelds().size();
		System.out.println(size_before - size_after);
		assertEquals(1, size_before - size_after);
	}
}

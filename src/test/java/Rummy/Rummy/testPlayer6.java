package Rummy.Rummy;

import junit.framework.TestCase;

public class testPlayer6 extends TestCase {
	/**
	 * Test for 6
	 * The PlayerStrategy draws from Pile
	 * -Size of stock is reduced by one*/
	public void testPlayerPlaysPicksFromStock() {
		Table.init8("6a");
		int size_before = Table.getStock().getSize();
		Table.playNext();
		int size_after = Table.getStock().getSize();
		System.out.println(size_before);
		System.out.println(size_after);
		assertEquals(1, size_before - size_after);
	}
}

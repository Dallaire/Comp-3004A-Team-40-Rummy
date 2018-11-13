package Rummy.Rummy;

import java.io.IOException;

import junit.framework.TestCase;

public class SocketTests extends TestCase {

	/**
	 * Test that the game connects
	 * @throws IOException */
	public void testConnect() throws IOException {
		
		Table.init();
		Table.connectSocket();
		PlayerStrategy player = (PlayerStrategy)Table.getPlayer(0);
		player.playSocket();
	}
	
	
}

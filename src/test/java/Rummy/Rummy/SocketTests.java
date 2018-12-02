package Rummy.Rummy;

import java.io.IOException;

import junit.framework.TestCase;

public class SocketTests extends TestCase {

	/**
	 * Test that the game connects
	 * @throws IOException */
	public void testTableConnect() throws IOException {
		
		Table.init();
		JRON jron = new JRON(null, false, false, "update", Table.getStock());
		try {
			Table.connectSocket(jron);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test that the game connects
	 * @throws IOException */
	public void testPlayerConnect() throws IOException {
		Table.init();
		PlayerStrategy player = (PlayerStrategy)Table.getPlayer(0);
		try {
			player.playSocket();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

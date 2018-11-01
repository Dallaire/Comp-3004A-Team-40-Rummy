package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	private String gameInput;
	public Game() {
		play();
	}
	/**
	 * Game Loop
	 * takes in a p1 hand and asks them how they want them to play the game.
	 */
	public void play() {
		System.out.println("Would you like to play Rummy(Y/N)");
		Scanner sc = new Scanner(System.in);
		gameInput = sc.nextLine();
		if(gameInput.equals("Y")) {
			Table.init();
			while(!Table.winner()) {
				Table.playNext();
			}
		}
		
	}
	
	
	
	public String getGameInput() {
		return this.gameInput;
	}



	/**
	 * @return the turns
	 */


	
}

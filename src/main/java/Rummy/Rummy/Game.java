package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	
	private String gameInput;
	private String playerInput;
	private Player p1,p2,p3,p4;
	private boolean won = false;
	private int turns = 0;
	Table table = new Table();
	

	public Game() {
		play();
	}
	/**
	 * Game Loop
	 * takes in a p1 hand and asks them how they want them to play the game.
	 */
	public void play() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Would you Like to play a new game?(Y/N)");
			gameInput = sc.nextLine().toUpperCase();
			if(gameInput.equals("N")) {
				sc.close();
				break;
			}else {
				/** 
				 * if game is won break else run the game.
				 */
				if(won) {
					break;
				}else {
					run(p1,p2,p3,p4,this.table);
				}
				
			}
			
		}
	}
	
	
	public String getGameInput() {
		return this.gameInput;
	}
	public String getPlayerInput() {
		return this.playerInput;
	}


	 public void run(PlayerStrategy human, FirstStrategy stratOne, SecondStrategy stratTwo, ThirdStrategy stratThree, Table board) {
		int n = board.getNumPlayers();
		while(true) {
			if(this.turns==n) {
				this.turns = 0;
			}else {
				if(this.turns == 0) {
					human.playTurn();
					if(human.getHand().size() == 0) {
						this.won = true;
						break;
					}
				}else if(this.turns == 1) {
					stratOne.playTurn();
					if(stratOne.getHand().size() == 0) {
						this.won = true;
						break;
					}
				}else if(this.turns == 2) {
					stratTwo.playTurn();
					if(stratTwo.getHand().size() == 0) {
						this.won = true;
						break;
					}
				}else {
					stratThree.playTurn();
					if(stratThree.getHand().size() == 0) {
						this.won = true;
						break;
					}
				}
				this.turns++;
			}

		}
		
			
		
	}

	/**
	 * @return the turns
	 */
	public int getTurns() {
		return this.turns;
	}

	
}

package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerStrategy extends Player implements Strategy {

	public PlayerStrategy(String aName) {
		super(aName);
	}

	//Logic is broken
	@Override
	/**
	 * @return - null if passing and or a meld*/
	public ArrayList<Tile> playTurn() {
		boolean flag = true;
		// Put the player in a loop
		while (flag == true) {
			// Allow the player to choose what they want to do
			int choice = makeChoice();
			System.out.println(choice);
			if (choice == 1) //play a meld from the hand
			{
				// let the player select the tiles they wish to play
				int[] indexes = selectTile();
				meld.clear();
				
				// create the meld using the indexes
				for (int x: indexes) {
					
					System.out.println(x);
					System.out.println(this.getHand().size());
					meld.add(this.getHand().get(x));
				}
				
				// if the first thirty points aren't yet played check for that 
				if (getFirst30() == false) {
					if(MeldChecker.check30(meld) == false) {
						System.out.println("On first play the total points must be >=30");
						continue; 
					} else if(MeldChecker.checkRun(meld) == false && MeldChecker.checkSet(meld) == false) {
						System.out.println("Please play a valid run or set");
						continue;
					} else if(MeldChecker.checkRun(meld) == true || MeldChecker.checkSet(meld) == true) {
						System.out.println("Player " + this.getName() + " played this meld: \n" + meld.toString());
						
					}
				}
				
			} 
			else //pick a tile from the stock and pass on turn
			{
				this.addTile(Table.getTile());
				meld = null;
				flag = false;
			}
		}

		return meld; //if the player passes, return null else return the meld
	}
	
	/**
	 * Read the input from the console
	 * @return - an integer array of indexes the player wishes to create a meld from*/
	public int[] selectTile() {
		
		System.out.println("Create your meld, select the tiles by index in comma separated list: ");
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(",");
		int[] indexes = new int[input.length];
		
		for(int i = 0;i < input.length;i++)
		{
		   // Note that this is assuming valid input
		   // If you want to check then add a try/catch 
		   // and another index for the numbers if to continue adding the others (see below)
		   indexes[i] = Integer.parseInt(input[i]);
		}
		
		sc.close();
		
		return indexes;
	}
	
	/**
	 * Read the input from the console to device on action to take
	 * @return - an integer 1 for play a meld and 2 for */
	public int makeChoice() {
		
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("What would you like to do? \n 1) play a meld or \n 2) pick from the stock");			
			String input = sc.nextLine();
			choice = Integer.parseInt(input);
			
			if (choice == 1 || choice == 2) {
				break;
			}
			
		}
		
		sc.close();
		
		return choice;
	}


}

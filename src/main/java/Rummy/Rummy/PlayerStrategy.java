package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerStrategy extends Player implements Strategy {

	public PlayerStrategy(String aName) {
		super(aName);
	}

	//Logic is broken
	@Override
	public ArrayList<Tile> playTurn() {
		
		// Allow the player to choose what they want to do
		int choice = makeChoice();
		
		if (choice == 1) //play a meld from the hand
		{
			// let the player select the tiles they wish to play
			int[] indexes = selectTile();
			meld.clear();
			
			// create the meld using the indexes
			for (int x: indexes) {
				
				System.out.println(x);
				System.out.println(this.getHand().size());
				Tile temp = this.getHand().get(x);
				meld.add(temp);
			}
			
		} else //pick a tile from the stock and pass on turn
		{
			this.addTile(Table.getTile());
		}
		
		
		
		// if the meld is legit remove it from the hand
		if (!playedFirst30) {
			if(!MeldChecker.check30(meld)) {
				System.out.println("Not enough points buddy.");
				
			} 
			else {
			 //TODO actually playing the meld onto the table
				this.setFirst30(true);
			}
		}
		else {
			//TODO check if valid play and execute it
		}

		return meld; //????
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
		
		while(choice != 1 | choice !=2) {
			
			System.out.println("What would you like to do? \n 1) play a meld or \n 2) pick from the stock");			
			String input = sc.nextLine();
			choice= Integer.parseInt(input);
			
		}
		
		sc.close();
		
		return choice;
	}


}

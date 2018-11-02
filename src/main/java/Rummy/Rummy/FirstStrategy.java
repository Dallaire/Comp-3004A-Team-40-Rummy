package Rummy.Rummy;

import java.util.ArrayList;

public class FirstStrategy extends Player implements Strategy{

	public FirstStrategy(String name) {
		super(name);
	}

	@Override
	public ArrayList<Tile> playTurn() {
		int sumRun=0;
		int sumSet=0;
		// see if we can create a set
		
		// see if we can create a run
		if(createSet()!=null) {
		 sumSet=MeldChecker.checkSum(createSet());
		}
		if (createRun()!=null) {
			sumRun=MeldChecker.checkSum(createRun());

		}
		/** check if first 30 pts have been played
		 * if yes returns a set or a run every time this function is called*/
		 if (playedFirst30) {
			return playMeld();
		}else if (sumRun+sumSet<30) {
			/** check if you have 30 to play
			 * if yes returns the melds that will*/
			this.addTile(Table.getTile());
			return null;
		}	
		else {
		return playMeld();
		}
		}		
	
	public ArrayList<Tile> playMeld() {
		ArrayList<Tile> meldToPlay = new ArrayList<Tile>();

		meldToPlay =createRun();
		if(meldToPlay!=null) {
			getHand().removeAll(meldToPlay);
			return meldToPlay;
		}
		meldToPlay=createSet();
		if (meldToPlay!=null) {
			getHand().removeAll(meldToPlay);
			return meldToPlay;
		}
		return null;
	}
	
	
}

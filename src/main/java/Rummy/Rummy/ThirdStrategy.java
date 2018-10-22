package Rummy.Rummy;

import java.util.ArrayList;

public class ThirdStrategy extends Player implements Strategy{

	public ThirdStrategy(String aName) {
		super(aName);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	@Override
	/**
	 * Play first 30 if possible
	 * Play all tiles if possible
	 * If no player has 3 fewer tiles, then play only tiles that require table input
	 * */
	public ArrayList<Tile> playTurn() {
		ArrayList<Tile> meldToPlay; 
		
		if(false) {
			
		}else {
			meldToPlay = null;
		}
		
		return meldToPlay;
		
		
	}
}
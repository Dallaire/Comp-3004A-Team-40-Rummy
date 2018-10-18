package Rummy.Rummy;

import java.util.ArrayList;

public abstract class Strategy {
	boolean firstPlay;
	Player player;
	Table table;
	ArrayList<Tile> meld;
	int meldSize;
	public  Strategy(Player player, Table table){
		// TODO Auto-generated constructor stub
		this.player=player;
		this.table=table;
		firstPlay=false;
	}
	public Strategy(Player player) {
		this.player=player;
	}
	//public abstract void gamePlay();
	public abstract void playTurn();
	//plays the first meld >30
	public boolean firstPlay() {
		/**
		 * compares the run vs the set to take the bigger one and adds it to the table
		 * */
		if(checkRun(player.getHand()).size()>checkSet(player.getHand()).size()&&
				player.check30(checkRun(player.getHand()))) {
			table.addMeld(checkRun(player.getHand()));
			//removes the tiles from the players hand
			player.getHand().remove(checkRun(player.getHand()));
			return true;
		}else if (player.check30(checkSet(player.getHand()))) {
			table.addMeld(checkSet(player.getHand()));
			player.getHand().remove(checkSet(player.getHand()));
			return true;
		}else {
			//otherwise player draws a new card from stock
			player.addTile(table.getTile());

			return false;
		}		
	}
	/**
	 * checks for the run with the maximum sum ie O9,O10,O11,O12
	 **/
	public ArrayList<Tile> checkRun(ArrayList<Tile> aHand) {
		meld = new ArrayList<Tile>();
	    meldSize=0;
		for(int i=aHand.size()-1; i>0;i--) {
			meld.add(aHand.get(i));
			meldSize++;
			for(int j=i-1;j>=0;j--) {
				if(checkColor(meld.get(meldSize-1), aHand.get(j))
				&&checkDifference(meld.get(meldSize-1), aHand.get(j))) {
					if (!meld.contains(aHand.get(j))) {
						meld.add(aHand.get(j));
						meldSize++;
					}
				}
			}
			if(meld.size()>=3) {
				return meld;
			}
			meld.clear();	
}
		System.out.println("");
		return null;
	}	
	/**
	 * checks if a player has a set ie O11,B11,R11,G11*/
	public ArrayList<Tile> checkSet(ArrayList<Tile> aHand) {
		meld = new ArrayList<Tile>();
	    meldSize=0;
		for(int i=aHand.size()-1; i>0;i--) {
			//System.out.println("im here");
			meld.add(aHand.get(i));
			meldSize++;
			for(int j=i-1;j>=0;j--) {
				//System.out.println("im here");
			 //System.out.println("im here "+meld.get(meldSize).toString());
				//System.out.println(meld.get(meldSize-1).toString());
			if(meld.get(meldSize-1).getValue()==aHand.get(j).getValue()) {
//					//System.out.print(","+aHand.get(j).toString());
					meld.add(aHand.get(j));
//					//System.out.println("im here");
					meldSize++;
				}
			}
		//System.out.println(meld.size());

//			if(meld.size()>=3) {
//				//System.out.println("im here");
//
//			return meld;
//		    }
//		meld.clear();
		//	System.out.println(meld.size());

		}
		return null;
	}
	/**
	 * compares the color of the 2 giver tiles and returns true if equal otherwise false*/
	public boolean checkColor(Tile t1,Tile t2) {
		return t1.colorToString().equals(t2.colorToString());
	}
	/**
	 * compares the value of the 2 giver tiles and returns true if the difference=1 otherwise false*/
	public boolean checkDifference(Tile t1, Tile t2) {
		if ((t1.getValue()-t2.getValue())==1) {
			return true;
		}
		return false;
	}
	
}


package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FirstStrategy implements Strategy{

	@Override
	public void strategy(Player player,Table table) {
		if(checkRun(player.getHand()).size()>checkSet(player.getHand()).size()&&
				player.check30(checkRun(player.getHand()))) {
			table.addMeld(checkRun(player.getHand()));
			player.getHand().remove(checkRun(player.getHand()));
		}else if (player.check30(checkSet(player.getHand()))) {
			player.getHand().remove(checkSet(player.getHand()));
		}else {
			player.addTile(table.getTile());
		}		
	}
	

	
	public ArrayList<Tile> checkRun(ArrayList<Tile> aHand) {
		Collections.sort(aHand,new valueComparator());
		ArrayList<Tile> meld = null;
		for(int i=aHand.size(); i>0;i--) {
			meld.add(aHand.get(i));
			for(int j=i-1;j>0;j--) {
				if(aHand.get(i).getValue()-aHand.get(j).getValue()==1&&
			    	  aHand.get(i).getColor().equals(aHand.get(i).getColor())) {
					meld.add(aHand.get(j));
				}
			}
			if(meld.size()>=3) {
				return meld;
			}
		}
		return null;
	}
	
	public ArrayList<Tile> checkSet(ArrayList<Tile> aHand) {
		Collections.sort(aHand,new valueComparator());
		ArrayList<Tile> meld = null;
		for(int i=aHand.size(); i>0;i--) {
			meld.add(aHand.get(i));
			for(int j=i-1;j>0;j--) {
				if(aHand.get(i).getValue()==aHand.get(j).getValue()) {
					meld.add(aHand.get(j));
				}
			}
			if(meld.size()>=3) {
				return meld;
			}
		}
		
		return null;
		
	}

	
}

package Rummy.Rummy;

import java.util.Comparator;

public class valueComparator implements Comparator<Tile> {

	 @Override
	 /**
		 * sorts the hand by value*/
	    public int compare(Tile o1, Tile o2) {
	        return o1.getValue()-o2.getValue();
	    }
		
}

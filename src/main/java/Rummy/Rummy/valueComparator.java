package Rummy.Rummy;

import java.util.Comparator;

public class valueComparator implements Comparator<Tile> {

	 @Override
	 /**
		 * sorts the hand by value*/
	    public int compare(Tile o1, Tile o2) {
		 	Color c1 = o1.getColor();
		 	Color c2 = o2.getColor();
		 	int comp = c1.compareTo(c2);
		 	
		 	if (comp != 0) {return comp;}
		 	
		 	Integer i1 = o1.getValue();
		 	Integer i2 = o2.getValue();
	        return i1.compareTo(i2);
	    }
		
}

package Rummy.Rummy;

import java.util.Comparator;

public class colourCompataror implements Comparator<Tile>{

	@Override
	public int compare(Tile o1, Tile o2) {
		// TODO Auto-generated method stub
		return o1.colorToString().compareTo(o2.colorToString());
	}

}

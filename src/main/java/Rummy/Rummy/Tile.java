package Rummy.Rummy;


public class Tile implements Comparable<Tile>{
	private Color color;
	//Ace =1, j-K = 11-13
	private int value;

	public Tile(Color aColor, int aValue) {
		this.color = aColor;
		this.value = aValue;
	}

	public Color getColor() {
		return this.color;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return color.toString() + String.valueOf(value);
	}
	
	public String valueToString() {
		return String.valueOf(value);
	}
	
	public String colorToString() {
		return color.toString();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Tile) {
			Tile t = (Tile) o;
			return (this.getColor() == t.getColor() && this.getValue() == t.getValue());
		}
		return false;
	}
	/**
	 * @param otherTile - the tile to be compared
	 * @return A negative, zero, or a positive integer depending on the difference in values*/
	@Override
	public int compareTo(Tile otherTile) {
		
		//Compare the Tile colors if they are equal compare the colors
	 	Color c1 = this.getColor();
	 	Color c2 = otherTile.getColor();
	 	int comp = c1.compareTo(c2);
	 	
	 	if (comp != 0) {return comp;}
	 	
	 	//Compare the Tiles by value
	 	if (this.getValue() > otherTile.getValue() || this.getValue() == 0) {
	 		return -1;
	 	}
	 	else {
	 		return 1;
	 	}	
		
	}

}

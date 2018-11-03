package Rummy.Rummy;


public class Tile {
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
	
}

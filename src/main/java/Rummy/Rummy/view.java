package Rummy.Rummy;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class view extends Parent {
    GridPane gridPane =new GridPane();
	HBox tiles =new HBox();
	
	public void displayTiles(ArrayList<Tile> arrayList) {
		//HBox panel= new HBox(1);

		for (int i = 0; i < arrayList.size(); i++) {
		
			drawTile(arrayList.get(i));
          
		}
		
gridPane
}
	 public void drawTile(Tile tile) {
			Rectangle bg = new Rectangle(50, 80);
			bg.setArcWidth(20);
			bg.setArcHeight(20);
			bg.setFill(Color.WHITE);
			
			Text text = new Text(tile.toString());
			text.setWrappingWidth(70);
			text.setStyle("-fx-font: 24 arial;");
			
			switch (tile.getColor()) {
			case R:
				text.setFill(Color.RED);
				break;
			case B:
				text.setFill(Color.BLUE);
				break;
			case G:
				text.setFill(Color.GREEN);
				break;
			case O:
				text.setFill(Color.ORANGE);
				break;
			default:
				break;
			}
			tiles.getChildren().addAll(bg,text);
	}
	
}
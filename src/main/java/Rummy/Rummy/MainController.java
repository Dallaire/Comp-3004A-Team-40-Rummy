package Rummy.Rummy;

import javafx.scene.control.ComboBox;

public class MainController {
	public Main main;
	
	//game rigging items
	public ComboBox<String> COLOR_SELECTOR;
	public ComboBox<Integer> NUMBER_SELECTOR;
	
	public void setRigginComboBoxes() {
		COLOR_SELECTOR.getItems().addAll(
				"Joker",
				"Green",
				"Orange",
				"Red",
				"Blue");
		NUMBER_SELECTOR.getItems().addAll(
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9,
				10,
				11,
				12,
				13);
		COLOR_SELECTOR.getSelectionModel().selectFirst();
		NUMBER_SELECTOR.getSelectionModel().selectFirst();
	}
	
	public void onClickDeal() {
		Color color = null;
		if (COLOR_SELECTOR.getValue().equals("Joker"))
			color = null;
		if (COLOR_SELECTOR.getValue().equals("Green"))
			color = Color.G;
		if (COLOR_SELECTOR.getValue().equals("Orange"))
			color = Color.O;
		if (COLOR_SELECTOR.getValue().equals("Red"))
			color = Color.R;
		if (COLOR_SELECTOR.getValue().equals("Blue"))
			color = Color.B;
		Table.getPlayer(Table.getWhosTurn()).addTile(new Tile (color, NUMBER_SELECTOR.getValue()));
	}
	
	public void onClickEndTurn() {
		
	}
}

package Rummy.Rummy;

import java.io.IOException;
import Rummy.Rummy.Main;
import javax.management.openmbean.OpenDataException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class StartPageController {
	public Main main;

	//ObservableList<Integer> choices = FXCollections.observableArrayList(1,2,3,4);
	@FXML
	public ComboBox p1;
	public ComboBox p2;
	public ComboBox p3;
	public ComboBox p4;
	public Button startPageOKbutton;
	public void setNumPlayerCombo() {
		p1.getItems().addAll(
				"None",
				"Human",
				"AI1",
				"AI2",
				"AI3"

				);
		p2.getItems().addAll(
				"None",
				"Human",
				"AI1",
				"AI2",
				"AI3"

				);	
		p3.getItems().addAll(
						"None",
						"Human",
						"AI1",
						"AI2",
						"AI3"

						);
		p4.getItems().addAll(
				"None",
				"Human",
				"AI1",
				"AI2",
				"AI3"

				);
		p1.getSelectionModel().selectFirst();
		p2.getSelectionModel().selectFirst();
		p3.getSelectionModel().selectFirst();
		p4.getSelectionModel().selectFirst();

	}
	
	public void onClickstartPageOKbutton() throws IOException {
		//TODO Populate Table.players
		Main.showMainPage();
	}
//	private void startPage() throws IOException {
//		main.showStartPage();
//	}
	
	
}

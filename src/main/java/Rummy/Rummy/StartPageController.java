package Rummy.Rummy;

import java.io.IOException;
import java.util.Collections;

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
		if (p1.getValue() == "Human")
			Table.getPlayers().add(new PlayerStrategy("p1",true));
		else if (p1.getValue() == "AI1")
			Table.getPlayers().add(new FirstStrategy("p1",true));
		else if (p1.getValue() == "AI2")
			Table.getPlayers().add(new SecondStrategy("p1",true));
		else if (p1.getValue() == "AI3")
			Table.getPlayers().add(new ThirdStrategy("p1",true));
		
		if (p2.getValue() == "Human")
			Table.getPlayers().add(new PlayerStrategy("p2",true));
		else if (p2.getValue() == "AI1")
			Table.getPlayers().add(new FirstStrategy("p2",true));
		else if (p2.getValue() == "AI2")
			Table.getPlayers().add(new SecondStrategy("p2",true));
		else if (p2.getValue() == "AI3")
			Table.getPlayers().add(new ThirdStrategy("p2",true));
		
		if (p3.getValue() == "Human")
			Table.getPlayers().add(new PlayerStrategy("p3",true));
		else if (p3.getValue() == "AI1")
			Table.getPlayers().add(new FirstStrategy("p3",true));
		else if (p3.getValue() == "AI2")
			Table.getPlayers().add(new SecondStrategy("p3",true));
		else if (p3.getValue() == "AI3")
			Table.getPlayers().add(new ThirdStrategy("p3",true));
		
		if (p4.getValue() == "Human")
			Table.getPlayers().add(new PlayerStrategy("p4",true));
		else if (p4.getValue() == "AI1")
			Table.getPlayers().add(new FirstStrategy("p4",true));
		else if (p4.getValue() == "AI2")
			Table.getPlayers().add(new SecondStrategy("p4",true));
		else if (p4.getValue() == "AI3")
			Table.getPlayers().add(new ThirdStrategy("p4",true));
		
		Collections.sort(Table.getPlayers(), (a,b) -> Integer.compare(a.getRandomValue(),b.getRandomValue()));
		System.out.println(Table.getPlayers());
		Main.showMainPage();
	}
	
	
}

package Rummy.Rummy;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainController {
	public Main main;
	
	//game rigging items
	public ComboBox<String> COLOR_SELECTOR;
	public ComboBox<Integer> NUMBER_SELECTOR;
	public VBox infoBox;
	public HBox playerHand;
	public ProgressBar timer;
	public TitledPane playerPanel;
	public Button endButton;
	public Button nextButton;
	
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
		populatePlayerHand();
	}
	
	public void populateInfoBox() {
		infoBox.getChildren().clear();
		for (Player p: Table.getPlayers()) {
			infoBox.getChildren().add(new Text(p.getName() + ": " + p.getHand().size()));
		}
	}
	
	public void onClickEndTurn() {
		timer.progressProperty().unbind();
		nextButton.setDisable(false);
	}
	
	public void onClickNextPlayer() {
		Table.nextMove();
		playerPanel.setText("Current Player: " + Table.getPlayer(Table.getWhosTurn()).getName());
		if (Table.getPlayer(Table.getWhosTurn()) instanceof PlayerStrategy) {
			nextButton.setDisable(true);
		}
		populatePlayerHand();
	}
	
	public void populatePlayerHand() {
		Player p = Table.getPlayer(Table.getWhosTurn());
		playerHand.getChildren().clear();
		for (int i = 0; i<p.getHand().size(); i++) {
			playerHand.getChildren().add(new Text(p.getHand().get(i).toString()));
		}
		populateInfoBox();
	}
	
	public void onClickStartRigged() {
		Table.setWhosTurn(0);
	}
	
	public void onClickStartUnrigged() {
		Table.setWhosTurn(0);
		Table.loadDeck();
		Table.shareCards();
		populatePlayerHand();
	}
	
	//timerBinding, time and Task code adapted from Life FX Youtube channel video: JavaFX 8 Tutorial - Progress Bar - #20
	public void timerBinding() {
		timer.progressProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
             
             if(t1.doubleValue()==0){
                 return;
             	}
         	}
		});
	}
	
	public void time() {
		Task task = taskCreator(120);
        timer.progressProperty().unbind();
        timer.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
	}
	
	private Task taskCreator(int seconds){
        return new Task() {
                   @Override
                   protected Object call() throws Exception {
                       for(int i=0; i<seconds;i++){
                        Thread.sleep(1000);
                        updateProgress(i+1, seconds);                    
                       }
                       return true;
                   }
               };
	}
}

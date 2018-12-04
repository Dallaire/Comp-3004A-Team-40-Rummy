package Rummy.Rummy;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainController {
	public Main main;
	
	//game rigging items
	public ComboBox<String> COLOR_SELECTOR;
	public ComboBox<Integer> NUMBER_SELECTOR;
	public VBox infoBox;
	public ProgressBar timer;
	
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
	
	public void populateInfoBox() {
		for (Player p: Table.getPlayers()) {
			infoBox.getChildren().add(new Text(p.getName() + ": " + p.getHand().size()));
		}
	}
	
	public void onClickEndTurn() {
		timer.progressProperty().unbind();
	}
	
	public void onClickNextPlayer() {
		Table.nextMove();
	}
	
	public void onClickStart() {
		
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

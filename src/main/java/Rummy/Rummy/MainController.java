package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainController {
	public Main main;
	
	//game rigging items
	public ComboBox<String> COLOR_SELECTOR;
	public ComboBox<Integer> NUMBER_SELECTOR;
	public VBox infoBox;
	public ListView playerHand;
	public ProgressBar timer;
	public TitledPane playerPanel;
	public Button endButton;
	public Button nextButton;
	public ListView<ListView<Tile>> tableList;
	
	static final DataFormat TILE_LIST = new DataFormat("TileList");

	
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
	
	public void populateTableList() {
		tableList.getItems().clear();
		for (int i =0; i<=Table.getMelds().size();i++) {
			ListView<Tile> meldContents = new ListView<Tile>();
			meldContents.setOrientation(Orientation.HORIZONTAL);
			meldContents.setPrefHeight(30);
			if(i == Table.getMelds().size()) {
				ArrayList<Tile> meld = new ArrayList<Tile>();}
			else {ArrayList<Tile> meld = Table.getMeld(i);
				Collections.sort(meld, new valueComparator());
				for (Tile tile: meld) {
					meldContents.getItems().add(tile);
				}
			}
			meldContents.setOnDragDetected(new EventHandler <MouseEvent>() {
				public void handle(MouseEvent event) {
					dragDetected(event,meldContents);
				}
			});
			meldContents.setOnDragDropped(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					dragDropped(event, meldContents);
				}
			});
			meldContents.setOnDragOver(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					dragOver(event, meldContents);
				}
			});
			meldContents.setOnDragDone(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					dragDone(event, meldContents);
				}
			});
			tableList.getItems().add(meldContents);
		}
	}
	
	public void convertHand() {
		Table.getPlayer(Table.getWhosTurn()).getHand().clear();
		Table.getPlayer(Table.getWhosTurn()).getHand().addAll(playerHand.getItems());
	}
	
	@SuppressWarnings("unchecked")
	public void convertTable() {
		Table.getMelds().clear();
		for (int i = 0; i < tableList.getItems().size(); i++) {
			ArrayList<Tile> meld = new ArrayList<Tile>();
			for (int j = 0; j < tableList.getItems().get(i).getItems().size(); j++) {
				Tile t = tableList.getItems().get(i).getItems().get(j);
				meld.add(t);
				}
			Table.addMeld(meld);
		}
		
	}
	
	public void onClickEndTurn() {
		timer.progressProperty().unbind();
		nextButton.setDisable(false);
		convertHand();
		convertTable();
	}
	
	public void onClickNextPlayer() {
		Table.update();
		Table.nextMove();
		nextButton.setDisable(false);
		playerPanel.setText("Current Player: " + Table.getPlayer(Table.getWhosTurn()).getName());
		populatePlayerHand();
		if (Table.getPlayer(Table.getWhosTurn()) instanceof PlayerStrategy) {
			nextButton.setDisable(true);
		}		
		else if (!endButton.isDisable()) {
			ArrayList<ArrayList<Tile>> melds = null;
			if (Table.getPlayer(Table.getWhosTurn()) instanceof FirstStrategy) {
				melds = Table.getPlayer(Table.getWhosTurn()).playTurn();
				if(melds != null) Table.getMelds().addAll(melds);
			}
			else if (Table.getPlayer(Table.getWhosTurn()) instanceof SecondStrategy) {
				melds = ((SecondStrategy) Table.getPlayer(Table.getWhosTurn())).playTurn2();
				if(melds != null) Table.getMelds().addAll(melds);
			}
			else if (Table.getPlayer(Table.getWhosTurn()) instanceof ThirdStrategy) {
				melds = ((ThirdStrategy) Table.getPlayer(Table.getWhosTurn())).playTurn2();
				if(melds != null) Table.getMelds().addAll(melds);
			}
		}
		
	}
	
	public void populatePlayerHand() {
		Player p = Table.getPlayer(Table.getWhosTurn());
		Collections.sort(p.getHand(), new valueComparator());
		playerHand.getItems().clear();
		for (int i = 0; i<p.getHand().size(); i++) {
			playerHand.getItems().add(p.getHand().get(i));
		}
		populateInfoBox();
		populateTableList();
	}
	
	public void onClickStartRigged() {
		Table.setWhosTurn(0);
		Table.update();
		ArrayList<ArrayList<Tile>> melds = null;
		if (Table.getPlayer(Table.getWhosTurn()) instanceof FirstStrategy) {
			melds = Table.getPlayer(Table.getWhosTurn()).playTurn();
			if(melds != null) Table.getMelds().addAll(melds);
		}
		else if (Table.getPlayer(Table.getWhosTurn()) instanceof SecondStrategy) {
			melds = ((SecondStrategy) Table.getPlayer(Table.getWhosTurn())).playTurn2();
			if(melds != null) Table.getMelds().addAll(melds);
		}
		else if (Table.getPlayer(Table.getWhosTurn()) instanceof ThirdStrategy) {
			melds = ((ThirdStrategy) Table.getPlayer(Table.getWhosTurn())).playTurn2();
			if(melds != null) Table.getMelds().addAll(melds);
		}
	}
	
	public void onClickStartUnrigged() {
		Table.setWhosTurn(0);
		Table.loadDeck();
		Table.shareCards();
		populatePlayerHand();
		endButton.setDisable(false);
		Table.update();
		ArrayList<ArrayList<Tile>> melds = null;
		if (Table.getPlayer(Table.getWhosTurn()) instanceof PlayerStrategy) {
			nextButton.setDisable(true);
		}
		else if (Table.getPlayer(Table.getWhosTurn()) instanceof FirstStrategy) {
			melds = Table.getPlayer(Table.getWhosTurn()).playTurn();
			if(melds != null) Table.getMelds().addAll(melds);
		}
		else if (Table.getPlayer(Table.getWhosTurn()) instanceof SecondStrategy) {
			melds = ((SecondStrategy) Table.getPlayer(Table.getWhosTurn())).playTurn2();
			if(melds != null) Table.getMelds().addAll(melds);
		}
		else if (Table.getPlayer(Table.getWhosTurn()) instanceof ThirdStrategy) {
			melds = ((ThirdStrategy) Table.getPlayer(Table.getWhosTurn())).playTurn2();
			if(melds != null) Table.getMelds().addAll(melds);
		}
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
	
	public void dragDetected(MouseEvent event, ListView<Tile> listView) {
		int selectCount = listView.getSelectionModel().getSelectedIndices().size();
		if(selectCount == 0) {
			event.consume();
			return;}
		Dragboard db = playerHand.startDragAndDrop(TransferMode.COPY_OR_MOVE);
		ArrayList<Tile> selectedTiles = getSelectedTiles(listView);
		ClipboardContent content = new ClipboardContent();
		content.put(TILE_LIST, selectedTiles);
		db.setContent(content);
		event.consume();
	}
	
	public void dragOver(DragEvent event, ListView<Tile> meld) {
		Dragboard db = event.getDragboard();
		if (event.getGestureSource() != meld && db.hasContent(TILE_LIST)) {
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}
		event.consume();
	}
	
	public void dragDropped(DragEvent event, ListView<Tile> listView) {
		boolean dragCompleted = false;
		Dragboard db = event.getDragboard();
		
		if(db.hasContent(TILE_LIST)) {
			ArrayList<Tile> t = (ArrayList<Tile>)db.getContent(TILE_LIST);
			listView.getItems().addAll(t);
			dragCompleted = true;
		}
		event.setDropCompleted(dragCompleted);
		event.consume();
	}
	
	public void dragDone(DragEvent event, ListView<Tile> listview) {
		TransferMode tm = event.getTransferMode();
		if (tm == TransferMode.MOVE);
			removeSelectedTiles(listview);
		event.consume();
	}
	
	public ArrayList<Tile> getSelectedTiles(ListView<Tile> listView) {
		ArrayList<Tile> list = new ArrayList<>(listView.getSelectionModel().getSelectedItems());
		return list;
	}
	
	public void removeSelectedTiles(ListView<Tile> listView) {
		List<Tile> selected = new ArrayList<>();
		for (Tile t: listView.getSelectionModel().getSelectedItems())
			selected.add(t);
		listView.getSelectionModel().clearSelection();
		listView.getItems().removeAll(selected);
	}
}

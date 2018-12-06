package Rummy.Rummy;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	private static Stage primaryStage;
	private static Pane mainLayout;
	
	public static void main(String[] args) { 
        launch(args);
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("RummyKub");
		//showMainView();
		showStartPage();
		//showMainPage();
		
	}
//	private void showMainView() throws IOException {
//		
//		
//		
//	}
	public void showStartPage() throws IOException {
		FXMLLoader loader= new FXMLLoader();
		
		loader.setLocation(Main.class.getResource("StartPageUI.fxml"));
		mainLayout =loader.load();
		
		StartPageController controller= loader.getController();
		
		
		Scene scene =new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		controller.setNumPlayerCombo();
		
	}
	public static void showMainPage() throws IOException {
		FXMLLoader loader= new FXMLLoader();
		
		loader.setLocation(Main.class.getResource("MainUI.fxml"));
		Pane MainPage=loader.load();
		MainController controller = loader.getController();
		mainLayout.getChildren().clear();
		mainLayout.getChildren().add(MainPage);
		controller.setRigginComboBoxes();
		controller.populateInfoBox();
		controller.timerBinding();
		controller.playerPanel.setText(("Current Player: " + Table.getPlayer(Table.getWhosTurn()).getName()));
		controller.endButton.setDisable(true);
		controller.playerHand.setOnDragDetected(new EventHandler <MouseEvent>() {
			public void handle(MouseEvent event) {
				controller.dragDetected(event, controller.playerHand);
			}
		});
		controller.playerHand.setOnDragDropped(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				controller.dragDropped(event, controller.playerHand);
			}
		});
		controller.playerHand.setOnDragOver(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				controller.dragOver(event, controller.playerHand);
			}
		});
		controller.playerHand.setOnDragDone(new EventHandler <DragEvent>() {
			public void handle(DragEvent event) {
				controller.dragDone(event, controller.playerHand);
			}
		});
	}
	
}

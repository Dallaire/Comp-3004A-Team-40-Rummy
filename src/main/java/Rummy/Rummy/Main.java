package Rummy.Rummy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
		//controller.main=
		//mainLayout.getChildren((startPage);
		
		Scene scene =new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		controller.setNumPlayerCombo();
		
	}
	public static void showMainPage() throws IOException {
		FXMLLoader loader= new FXMLLoader();
		
		loader.setLocation(Main.class.getResource("MainUI.fxml"));
		Pane MainPage=loader.load();
		
		mainLayout.getChildren().add(MainPage);
		//StartPageController controller= loader.getController();
		//mainLayout.getChildren((startPage);
		
//		Scene scene =new Scene(MainPage);
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}

	
}

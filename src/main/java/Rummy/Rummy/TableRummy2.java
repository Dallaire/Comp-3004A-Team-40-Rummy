/**
 * 
 */
package Rummy.Rummy;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import 			javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.Random;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsInstanceOf;

import javafx.animation.AnimationTimer;


/**
 * @author POE
 *
 */
@SuppressWarnings("restriction")
public class TableRummy2 extends Application {
	view view= new view();
	
	 private SimpleBooleanProperty playable = new SimpleBooleanProperty();
	 
	 private HBox player1Tiles=new HBox(20);
	 private HBox stockTiles = new HBox(20);
	 Table table = new Table();
	
	  public static void main(String[] args) { 
	        launch(args);
	    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		 	primaryStage.setScene(view.drawTiles(arrayList));
	        primaryStage.setWidth(1200);
	        primaryStage.setHeight(900);
	        //primaryStage.setResizable(false);
	        primaryStage.setTitle("RummyKub");
	        primaryStage.show();
	}

	private Parent createContent() {
		
		
		table.loadPlayers();
		table.loadDeck();
		table.shareCards();
		
		Pane root =new Pane();
		root.setPrefSize(1200, 900);
		
		 Region background = new Region();
	     background.setPrefSize(1200, 900);
	     background.setStyle("-fx-background-color: rgba(0, 0, 0, 1)");
	     
	     	HBox rootLayout = new HBox(5);
	        rootLayout.setPadding(new Insets(5, 5, 5, 5));
	        Rectangle leftBG = new Rectangle(600, 860);
	        leftBG.setArcWidth(50);
	        leftBG.setArcHeight(50);
	        leftBG.setFill(Color.WHITE);
	        Rectangle rightBG = new Rectangle(600, 860);
	        rightBG.setArcWidth(50);
	        rightBG.setArcHeight(50);
	        rightBG.setFill(Color.WHITE);
	        
	        StackPane leftStack = new StackPane();
	        
	        VBox leftVBox = new VBox(50);
	        leftVBox.setAlignment(Pos.TOP_CENTER);
//	        for (int i = 0; i < .length; i++) {
//				
//			}
	        root.getChildren().addAll(background,leftBG,rightBG);
		return root;
	}
//	static public void shareCards() {
//		for(int i=0;i<players.size();i++) {
//			for(int j=0;j<14;j++) {
//				players.get(i).addTile(getTile());
//			}
//		}
//	}
//	static public void loadPlayers() {
//		
//		PlayerStrategy p1 = new PlayerStrategy("Human");
//		FirstStrategy ai1 = new FirstStrategy("AI 1");
//		SecondStrategy ai2 = new SecondStrategy("AI 2");	
//		ThirdStrategy ai3 = new ThirdStrategy("AI 3");
//
//		players = new ArrayList<Player>();
//		players.add(p1);
//		players.add(ai1);
//		players.add(ai2);
//		players.add(ai3);
//
//
//	}
//
//		
//	static public void loadDeck() {
//		stock= new Deck();
//	}
	
	
    

}
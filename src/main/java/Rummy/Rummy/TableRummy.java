/**
 * 
 */
package Rummy.Rummy;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;


/**
 * @author POE
 *
 */
@SuppressWarnings("restriction")
public class TableRummy extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Initialize the variables which setup out stage
        primaryStage.setTitle("Tile Rummy");
        Group root = new Group();
        final Canvas canvas = new Canvas(720, 480);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        
        // Variable that we will be playing with
        final long startNanoTime = System.nanoTime();
        final ArrayList<Circle> circles = new ArrayList<Circle>();
        final Random rn = new Random();
        
        
        // handle what happens when the user double-clicks
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
         new EventHandler<MouseEvent>() {
             public void handle(MouseEvent t) {            
                 if (t.getClickCount() >0) {
                     
                     circles.add(new Circle(t.getX() + rn.nextDouble() * 30.0, t.getY() + rn.nextDouble() * 30.0,t.getX() ,t.getY()));
                     drawOval(canvas.getGraphicsContext2D(), t.getX(),t.getY());
                 }  
             }
         });
        
        new AnimationTimer() {
        	public void handle(long currentNanoTime) {
        		double t = (currentNanoTime - startNanoTime) / 1000000000.0;
        		reset(canvas, Color.WHITE);
        		for(int i = 0; i < circles.size(); i++) {
        			circles.get(i).update(t);          		
                    drawOval(canvas.getGraphicsContext2D(), circles.get(i).getX(), circles.get(i).getY());
        		}

        	}
        }.start();
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

	private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillOval(10, 60, 30, 30);
		
	}
	
	private void drawOval(GraphicsContext gc, double x, double y) {
		gc.setFill(Color.GREEN);
		gc.fillOval(x, y, 30, 30);
	}
	
    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    

}
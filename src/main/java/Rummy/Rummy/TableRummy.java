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
import javafx.scene.shape.ArcType;
import javafx.scene.input.MouseEvent;


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
        primaryStage.setTitle("Tile Rummy");
        Group root = new Group();
        final Canvas canvas = new Canvas(720, 480);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        
        // handle what happens when the user double-clicks
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
         new EventHandler<MouseEvent>() {
             public void handle(MouseEvent t) {            
                 if (t.getClickCount() >0) {
                     reset(canvas, Color.WHITE);
                     drawOval(canvas.getGraphicsContext2D(), t);
                 }  
             }
         });
        
        
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

	private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillOval(10, 60, 30, 30);
		
	}
	
	private void drawOval(GraphicsContext gc, MouseEvent e) {
		gc.setFill(Color.GREEN);
		gc.fillOval(e.getX(), e.getY(), 30, 30);
	}
	
    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
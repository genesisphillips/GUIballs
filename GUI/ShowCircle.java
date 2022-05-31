import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

	public class ShowCircle extends Application{
		@Override
		public void start (Stage primaryStage){
			Pane pane = new Pane();
			
			Circle circle = new Circle();
			circle.setRadius(50);
			circle.setStroke(Color.HOTPINK);
			circle.setFill(Color.ALICEBLUE);
			//circle.setCenterX();
			circle.centerXProperty().bind(pane.widthProperty().divide(2));
			circle.centerYProperty().bind(pane.heightProperty().divide(2));
			
			pane.getChildren().add(circle);
			Scene scene = new Scene(pane, 200, 200);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		public static void main(String[] args){
			launch(args);
		}
		
		

	}

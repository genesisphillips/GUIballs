import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TitlesCalculator extends Application{
	private TextField tfFloorWidth = new TextField();
	private TextField tfFloorLength = new TextField();
	
	private TextField tfBoxSize = new TextField();
	private TextField tfBoxesNeed = new TextField();
	private Button btCalculate =  new Button("Calculate");
	
	@Override
	public void start(Stage primaryStage){
		GridPane gridPane = new GridPane();
		
		gridPane.add(new Label("Floor width(feet)"), 0, 0);
		gridPane.add(tfFloorWidth, 1, 0);
		
		gridPane.add(new Label("Floor length(feet)"), 0, 3);
		gridPane.add(tfFloorLength, 1, 3);
		
		
		gridPane.add(new Label("Box Size"), 0, 5);
		gridPane.add(tfBoxSize, 1, 5);
		
		gridPane.add(new Label("Boxes need"), 0, 7);
		gridPane.add(tfBoxesNeed, 1, 7);
		
		gridPane.add(btCalculate, 1, 8);
        
		
		// process the button click event
		btCalculate.setOnAction(e -> calculateBoxNeed());
		
		 Scene scene = new Scene(gridPane, 250, 150);
		 primaryStage.setTitle("TilesCalculator"); // Set title
		 primaryStage.setScene(scene); // Place the scene in the stage
		 primaryStage.show(); // Display the stage
	}	
	public static void main(String[] args) {
		launch(args);

	}
	
	private void calculateBoxNeed(){
		double floorWidth = Double.parseDouble(tfFloorWidth.getText());
		double floorLength = Double.parseDouble(tfFloorLength.getText());
		double boxSize = Double.parseDouble(tfBoxSize.getText());
		
		double boxesNeed = floorWidth * floorLength / boxSize;
		
		tfBoxesNeed.setText(String.format("%.1f", boxesNeed));
		
	}


}

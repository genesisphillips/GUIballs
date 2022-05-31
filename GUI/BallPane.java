import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
  public final double radius = 20;
  private double x = radius, y = radius;
  private double dx = 1, dy = 1;
  private Circle circle = new Circle(x, y, radius);
  private Circle circle2 = new Circle(x, y, 40);
  private Circle circle3 = new Circle(x, y, 10);
  private Timeline animation;

  public BallPane() {
    circle.setFill(Color.HOTPINK); // Set ball color
    getChildren().add(circle); // Place a ball into this pane
    
    circle2.setFill(Color.CYAN);
    getChildren().add(circle2);
    
    circle3.setFill(Color.BLACK);
    getChildren().add(circle3);

    // Create an animation for moving the ball
    animation = new Timeline(
      new KeyFrame(Duration.millis(1), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  public void play() {
    animation.play();
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.5);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.5 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  protected void moveBall() {
    // Check boundaries
    if (x < radius || x > getWidth() - 20) {
      dx *= -1; // Change ball move direction
    }
    if (y < radius || y > getHeight() - 20) {
      dy *= -1; // Change ball move direction
    }

    if (x < 19 || x > getWidth() - 5) {
        dx *= -1; // Change ball move direction
      }
    if (y < 19 || y > getHeight() - 20) {
        dy *= -1; // Change ball move direction
      }
      
     if (x < 30 || x > getWidth() - 50) {
          dx *= -1; // Change ball move direction
       }
      if (y < radius || y > getHeight() - 50) {
          dy *= -1; // Change ball move direction
      }
    
    // Adjust ball position
    x += dx;
    y += dy;
    circle.setCenterX(x);
    circle.setCenterY(y);
    
    x += dx;
    y += dy;
    circle2.setCenterX(x/2);
    circle2.setCenterY(y/2);
    
    x += dx;
    y += dy;
    circle3.setCenterX(x/4);
    circle3.setCenterY(y/4);
    
  }
}

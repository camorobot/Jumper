package nl.camorobot.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {
  public ScoreText(Coordinate2D initialLocation) {
    super(initialLocation);
    setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
    setFill(Color.DARKBLUE);
  }

  // This method will set the score text
  public void setScoreText(int score){
    setText("Score: " + score);
  }

}

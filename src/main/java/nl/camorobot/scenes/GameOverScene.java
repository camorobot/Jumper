package nl.camorobot.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.camorobot.Jumper;
import nl.camorobot.buttons.StartButton;

public class GameOverScene extends StaticScene {

  private Jumper jumper;
  private int playerScore;

  public GameOverScene(Jumper Jumper, int playerScore) {
    this.jumper = Jumper;
    this.playerScore = playerScore;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/TitleScene.jpg");
  }

  @Override
  public void setupEntities() {
    playerScore = jumper.getPlayerScore();

    TextEntity gameOverText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/5), "Game Over!");
    gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    gameOverText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    gameOverText.setFill(Color.PURPLE);
    addEntity(gameOverText);

    TextEntity scoreText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/4), "Your score: " + playerScore);
    scoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    scoreText.setFill(Color.PURPLE);
    addEntity(scoreText);

    StartButton startButton = new StartButton(new Coordinate2D(getWidth()/2, getHeight()/2),jumper);
    addEntity(startButton);
  }
}

package nl.camorobot.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.camorobot.Jumper;
import nl.camorobot.buttons.QuitGameButton;
import nl.camorobot.buttons.StartButton;
import nl.camorobot.buttons.TryAgainButton;

public class GameOverScene extends StaticScene {

  private final Jumper JUMPER;
  private int playerScore;

  public GameOverScene(Jumper Jumper, int playerScore) {
    this.JUMPER = Jumper;
    this.playerScore = playerScore;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/TitleScene.jpg");
  }

  @Override
  public void setupEntities() {
    playerScore = JUMPER.getPlayerScore();

    // Show the appropriate message based on the dead message
    switch (JUMPER.getDeadMessage()){
      case "Bomb":
        TextEntity bombText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/3), "Game over: You hit a bomb!");
        bombText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        bombText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        bombText.setFill(Color.PURPLE);
        addEntity(bombText);

        TryAgainButton tryAgainButton = new TryAgainButton(new Coordinate2D(getWidth()/2, getHeight()/2), JUMPER);
        addEntity(tryAgainButton);
        break;
      case "Fell":
        TextEntity fellText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/3), "Game over: You fell off the platform!");
        fellText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        fellText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        fellText.setFill(Color.PURPLE);
        addEntity(fellText);

        TryAgainButton tryAgainButton2 = new TryAgainButton(new Coordinate2D(getWidth()/2, getHeight()/2), JUMPER);
        addEntity(tryAgainButton2);
        break;
      default:
        TextEntity gameOverText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/5), "You win!");
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        gameOverText.setFill(Color.PURPLE);
        addEntity(gameOverText);

        TextEntity scoreText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/4), "Your score: " + playerScore);
        scoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        scoreText.setFill(Color.PURPLE);
        addEntity(scoreText);

        StartButton startButton = new StartButton(new Coordinate2D(getWidth()/2, getHeight()/2),JUMPER);
        addEntity(startButton);
    }

    QuitGameButton quitGameButton = new QuitGameButton(new Coordinate2D(getWidth()/2, getHeight()/1.5), JUMPER);
    addEntity(quitGameButton);

    JUMPER.setDeadMessage("Finished");
    JUMPER.setPlayerScore(0);


  }
}

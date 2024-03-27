package nl.camorobot.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import nl.camorobot.Jumper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import nl.camorobot.entities.finish.Finish;
import nl.camorobot.entities.player.Player;
import nl.camorobot.entities.rocket.Rocket;
import nl.camorobot.platforms.*;
import nl.camorobot.text.ScoreText;


public class GameScene extends DynamicScene implements EntitySpawnerContainer {

  private Jumper jumper;
  private Player player;
  private int playerScore;
  private PlatformSpawner platformSpawner;

  public GameScene(Jumper jumper, int playerScore) {
    this.jumper = jumper;
    this.playerScore = playerScore;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/GameScene.jpg");
  }

  @Override
  public void setupEntities() {
    jumper.setPlayerScore(0);
    ScoreText scoreText = new ScoreText(new Coordinate2D(10, 30));
    addEntity(scoreText);

    player = new Player("sprites/player_sprites_2.png", new Coordinate2D(getWidth()/2, getHeight() - 25),new Size(35,35), 1,2, jumper, scoreText);

    Rocket rocket = new Rocket("sprites/rocket.png", new Coordinate2D(300, 25), new Size(50,50),player);
    addEntity(rocket);

    int xLocation = (int)(Math.random() * 550);
    System.out.println(xLocation);
    Finish finish = new Finish(new Coordinate2D(xLocation, 5), new Size(50,50));
    addEntity(finish);

    addEntity(player);
  }

  @Override
  public void setupEntitySpawners() {
    platformSpawner = new PlatformSpawner(player ,500, jumper);
    addEntitySpawner(platformSpawner);
  }
}

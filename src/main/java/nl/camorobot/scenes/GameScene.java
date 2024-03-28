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

  private final Jumper JUMPER;
  private Player player;

  public GameScene(Jumper jumper) {
    this.JUMPER = jumper;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/GameScene.jpg");
  }

  @Override
  public void setupEntities() {
    JUMPER.setPlayerScore(0);
    ScoreText scoreText = new ScoreText(new Coordinate2D(10, 30));
    addEntity(scoreText);

    player = new Player("sprites/player_sprites_2.png", new Coordinate2D(getWidth()/2, getHeight() - 25),new Size(35,35), 1,2, JUMPER, scoreText);

    Rocket rocket = new Rocket("sprites/rocket.png", new Coordinate2D(300, 25), new Size(50,50),player);
    addEntity(rocket);

    int xLocation = (int)(Math.random() * 550);
    Finish finish = new Finish(new Coordinate2D(xLocation, 5), new Size(50,50));
    addEntity(finish);

    addEntity(player);
  }

  @Override
  public void setupEntitySpawners() {
    PlatformSpawner platformSpawner = new PlatformSpawner(player, 500, JUMPER);
    addEntitySpawner(platformSpawner);
  }
}

package nl.camorobot.scenes;

import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import nl.camorobot.Jumper;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import nl.camorobot.entities.player.Player;
import nl.camorobot.platforms.*;
import nl.camorobot.text.ScoreText;


public class GameScene extends ScrollableDynamicScene implements EntitySpawnerContainer {

  private Jumper jumper;
  private Player player;
  private PlatformSpawner platformSpawner;

  public GameScene(Jumper jumper) {
    this.jumper = jumper;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/GameScene.jpg");
  }

  @Override
  public void setupEntities() {
    ScoreText scoreText = new ScoreText(new Coordinate2D(10, 30));
    addEntity(scoreText);

    player = new Player("sprites/player_sprites.png", new Coordinate2D(300,300), new Size(25,25), 1,2, scoreText);

    Platform greenPlatform = new GreenPlatform(new Coordinate2D(50, 500), player);
    addEntity(greenPlatform);

    Platform brownPlatform = new BrownPlatform(new Coordinate2D(300, 500), player);
    addEntity(brownPlatform);

//    Platform bluePlatform = new BluePlatform(new Coordinate2D(200, 250), player);
//    addEntity(bluePlatform);

    addEntity(player);
  }

  @Override
  public void setupEntitySpawners() {
    System.out.println(this);
    platformSpawner = new PlatformSpawner(player ,750, this);
    addEntitySpawner(platformSpawner);
  }
}

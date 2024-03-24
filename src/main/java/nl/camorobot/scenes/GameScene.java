package nl.camorobot.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import nl.camorobot.Jumper;
import nl.camorobot.entities.player.Player;

public class GameScene extends ScrollableDynamicScene {

  private Jumper jumper;

  public GameScene(Jumper jumper) {
    this.jumper = jumper;
  }

  @Override
  public void setupScene() {
    setBackgroundImage("backgrounds/GameScene.jpg");

  }

  @Override
  public void setupEntities() {
    Player player = new Player("sprites/player_right.png", new Coordinate2D(300,300));
    addEntity(player);
  }
}

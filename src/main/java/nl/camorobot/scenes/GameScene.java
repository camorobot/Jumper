package nl.camorobot.scenes;

import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import nl.camorobot.Jumper;

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

  }
}

package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.camorobot.entities.player.Player;
import nl.camorobot.scenes.GameScene;

import java.util.Random;

public class PlatformSpawner extends EntitySpawner {

  private Player player;

  public PlatformSpawner(Player player, final long intervalInMs) {
    super(intervalInMs);
    this.player = player;
  }

  @Override
  protected void spawnEntities() {
    Random rand = new Random();

    int sceneWidth = 600; // De breedte van je scene
    int sceneHeight = 800; // De hoogte van je scene

    int x = rand.nextInt(sceneWidth - 100);
    int y = 0;

    int randomNum = rand.nextInt(5); // Genereert een getal tussen 0 en 4

    switch (randomNum) {
      case 0:
        // 1 op 5 kans
        spawn(new BrownPlatform(new Coordinate2D(x, y), player));
        break;
      default:
        // 4 op 5 kans
        spawn(new GreenPlatform(new Coordinate2D(x, y), player));
        break;
    }

  }


}

package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.camorobot.Jumper;
import nl.camorobot.entities.player.Player;

import java.util.Random;

public class PlatformSpawner extends EntitySpawner {

  private final Player PLAYER;
  private final Jumper JUMPER;
  private int platformsSinceLastBomb = 0;

  public PlatformSpawner(Player player, final long intervalInMs, Jumper jumper) {
    super(intervalInMs);
    this.PLAYER = player;
    this.JUMPER = jumper;
  }

  @Override
  public void spawnEntities() {
    Random rand = new Random();
    int sceneWidth = 600;
    int x = rand.nextInt(sceneWidth - 100);
    int y = 0;
    int randomNum = platformsSinceLastBomb >= 5 ? 2 : rand.nextInt(8);

    switch (randomNum) {
      case 0:
        spawn(new BrownPlatform(new Coordinate2D(x, y), PLAYER));
        break;
      case 1:
        spawn(new BluePlatform(new Coordinate2D(x, y), new Size(50, 50), PLAYER));
        break;
      case 2:
        // If the last 5 platforms were NOT bombs, spawn a bomb platform
        if (platformsSinceLastBomb >= 5) {
          spawn(new BombPlatform(new Coordinate2D(x, y), new Size(50, 50), JUMPER));
          platformsSinceLastBomb = 0;
        } else {
          spawn(new GreenPlatform(new Coordinate2D(x, y), PLAYER));
          platformsSinceLastBomb++;
        }
        break;
      default:
        spawn(new GreenPlatform(new Coordinate2D(x, y), PLAYER));
        platformsSinceLastBomb++;
        break;
    }
  }

}

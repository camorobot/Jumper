package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.camorobot.Jumper;
import nl.camorobot.entities.player.Player;

import java.util.Random;

public class PlatformSpawner extends EntitySpawner {

  private Player player;
  private Jumper jumper;
  private int platformsSinceLastBomb = 0;

  public PlatformSpawner(Player player, final long intervalInMs, Jumper jumper) {
    super(intervalInMs);
    this.player = player;
    this.jumper = jumper;
  }

  @Override
  protected void spawnEntities() {
    Random rand = new Random();
    int sceneWidth = 600;
    int x = rand.nextInt(sceneWidth - 100);
    int y = 0;
    int randomNum = platformsSinceLastBomb >= 5 ? 2 : rand.nextInt(8);

    switch (randomNum) {
      case 0:
        spawn(new BrownPlatform(new Coordinate2D(x, y), player));
        break;
      case 1:
        spawn(new BluePlatform(new Coordinate2D(x, y), new Size(50, 50), player));
        break;
      case 2:
        if (platformsSinceLastBomb >= 5) {
          spawn(new BombPlatform(new Coordinate2D(x, y), new Size(50, 50), jumper));
          platformsSinceLastBomb = 0;
        } else {
          spawn(new GreenPlatform(new Coordinate2D(x, y), player));
          platformsSinceLastBomb++;
        }
        break;
      default:
        spawn(new GreenPlatform(new Coordinate2D(x, y), player));
        platformsSinceLastBomb++;
        break;
    }
  }

}

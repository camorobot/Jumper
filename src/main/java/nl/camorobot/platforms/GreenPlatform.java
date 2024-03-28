package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.camorobot.entities.player.Player;

public class GreenPlatform extends Platform{

  private final Player PLAYER;


  public GreenPlatform(Coordinate2D initialLocation, Player player) {
    super("sprites/greenplatform.png", initialLocation, new Size(55, 50));
    this.PLAYER = player;
  }

  // This method will be called when the player collides with the green platform
  // The player will be boosted
  @Override
  public void activeerEffect() {
    PLAYER.setMotion(8, 180d);
  }
}

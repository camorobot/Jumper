package nl.camorobot.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.camorobot.entities.player.Player;

public class GreenPlatform extends Platform{

  Player player;

  public GreenPlatform(Coordinate2D initialLocation, Player player) {
    super("sprites/greenplatform.png", initialLocation, new Size(55, 50));
    this.player = player;
  }

  @Override
  public void activeerEffect() {
    System.out.println("Direction: " + player.getDirection());
    player.setMotion(5, 180d);
  }
}
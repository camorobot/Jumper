package nl.camorobot.entities.rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.camorobot.entities.player.Player;

public class Rocket extends DynamicSpriteEntity implements Collider {

  private final Player PLAYER;

  public Rocket(String resource, Coordinate2D initialLocation, Size size, Player player) {
    super(resource, initialLocation, size);
    this.PLAYER = player;
    setMotion(1,0d);
  }

  // This method will be called when the player collides with the rocket
  // The player will be boosted and the rocket will be removed
  public void boost(){
    PLAYER.setMotion(20, 180d);
    remove();
  }

}

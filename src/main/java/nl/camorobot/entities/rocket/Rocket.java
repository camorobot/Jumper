package nl.camorobot.entities.rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.camorobot.entities.player.Player;

public class Rocket extends DynamicSpriteEntity implements Collider {

  private Player player;

  public Rocket(String resource, Coordinate2D initialLocation, Size size, Player player) {
    super(resource, initialLocation, size);
    this.player = player;
    setMotion(1,0d);
  }

  public void boost(){
    player.setMotion(20, 180d);
    remove();
  }

}
